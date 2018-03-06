package com.hgl.recruitms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.AttachMapper;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.enums.DictEnum;
import com.hgl.recruitms.enums.PathCodeEnum;
import com.hgl.recruitms.model.Attach;
import com.hgl.recruitms.model.AttachExample;
import com.hgl.recruitms.model.AttachExample.Criteria;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.service.AttachService;
import com.hgl.recruitms.service.DictionaryService;

/**
 * ClassName: DictionaryServiceImpl <br/>
 * date: 2017年12月16日 上午11:38:49 <br/>
 * Description：附件操作相关接口 1、获取绝对路径
 * 
 * @author lqju
 * @version Copyright (c) 2017, 深圳市览众科技股份有限公司 All Rights Reserved.
 */
@Service
public class AttachServiceImpl implements AttachService {
	private static final Logger logger = LogManager.getLogger(AttachServiceImpl.class);

	private String sepa = java.io.File.separator;

	@Autowired
	private AttachMapper attachMapper;

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 根据配置枚举信息，获取文件存储绝对路径.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#getAttachRealPath(com.efunds.pms.common.sys.model.AttachConf)
	 */
	@Override
	public String getAttachRealPath() {
		boolean success = true;
		String absolutePath = PathCodeEnum.ABSOLUTEPATH.getCode();
		String sSubPath = PathCodeEnum.SUBPATH.getCode();
		PathCodeEnum codeType = PathCodeEnum.fromCode(sSubPath);
		if (codeType != null) {
			Calendar now = Calendar.getInstance();
			switch (codeType) {
			case YEAR:
				absolutePath += sepa + now.get(Calendar.YEAR);
				break;
			case YEAR_MOUTH:
				absolutePath += sepa + now.get(Calendar.YEAR) + sepa + (now.get(Calendar.MONTH) + 1);
				break;
			case YEAR_MOUTH_DAY:
				absolutePath += sepa + now.get(Calendar.YEAR) + sepa + (now.get(Calendar.MONTH) + 1) + sepa
						+ now.get(Calendar.DAY_OF_MONTH);
				break;
			default:
				break;
			}
		}
		File folder = new File(absolutePath);
		// 除了最底层目录可能重名外，也有可能中间的某个目录存在同名文件，导致创建目录失败，这种情况暂时不考虑
		if (!folder.isDirectory()) {
			if (folder.exists()) {
				success = folder.renameTo(new File(absolutePath + ".rename"));
				logger.debug("重命名文件 {} to {}.rename", absolutePath, absolutePath);
			}
			success = folder.mkdirs();
			logger.info("创建路径({}):{}", success, absolutePath);
		}
		return success ? absolutePath : null;
	}

	/**
	 * 上传附件.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#uploadAttach(java.io.InputStream,
	 *      java.lang.String, java.lang.Integer, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public Attach uploadAttach(InputStream is, String fileName, Integer nAttachNoOld,
			String sCreator, String sCreatorNo) throws IOException {
		Integer nVersion = 1;
		if (nAttachNoOld != null) {
			Attach attachOld = getAttach(nAttachNoOld);
			if (attachOld == null) {
				throw new NullPointerException("更新版本异常！无法根据附件ID（" + nAttachNoOld + "）获取附件信息");
			}
			nVersion = attachOld.getnVersion().intValue() + 1;
		}

		String filePath = getAttachRealPath();// 获取存储目录
		logger.info("文件路径：{}", filePath);
		if (StringUtils.isEmpty(filePath)) {
			throw new NullPointerException("获取配置路径错误！（" + filePath + "）");
		}
		// 设置附件信息
		Attach attach = new Attach();
		attach.setsAttachName(fileName);
		attach.setnVersion(nVersion);
		attach.setsCreator(sCreator);
		attach.setsCreatorNo(sCreatorNo);
		int effect = attachMapper.insertSelective(attach);// 先插入一条附件记录
		if (effect != 1) {
			logger.error("插入一条附件记录失败！");
			throw new RuntimeException("上传附件失败（insert record error）！");
		}

		Integer nAttachNo = attach.getnAttachNo();
		String sPath = filePath + sepa + nAttachNo + "_" + fileName;// 组装附件路径：文件格式 附件id+文件名称
		// 保存文件到文件系统
		FileOutputStream fos = new FileOutputStream(new File(sPath));
		byte[] b = new byte[1024];
		int readed = 0;
		while ((readed = is.read(b)) != -1) {
			fos.write(b, 0, readed);
		}
		is.close();
		fos.close();
		// 设置绝对路径
		attach.setsPath(sPath);
		attach.setnLastAttachNo(nAttachNo);// 设置 最新 版本附件字段
		effect = attachMapper.updateByPrimaryKeySelective(attach);
		// 如果更新结果不等于1，则表示更新信息失败，抛出异常
		if (effect != 1) {
			logger.error("上传附件失败！{}", attach);
			throw new RuntimeException("上传附件失败（update path error）！" + attach);
		}
		if (nAttachNoOld != null) {
			// 上传附件成功，更新旧版本的附件关联ID
			Attach record = new Attach();
			record.setnLastAttachNo(nAttachNo);
			AttachExample example = new AttachExample();
			example.createCriteria().andNLastAttachNoEqualTo(nAttachNoOld);
			attachMapper.updateByExampleSelective(record, example);
		}

		logger.info("上传文件成功！（{},{}）", attach, filePath);
		return attach;
	}

	/**
	 * checkFileName:(校验文件名称). <br/>
	 * 
	 * @author lqju
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	@Override
	public boolean checkFileName(String fileName) {

		// 校验文件名，不能包含文件系统不支持的字符；校验扩展名，过滤白名单之外的类型，防止恶意攻击。
		String filename = StringUtils.stripFilenameExtension(fileName);
		String filenameExtension = StringUtils.getFilenameExtension(fileName);
		// 校验文件名，不能包含“?:"*<>\/|”，这些文件系统无法支持的字符
		Pattern pattern = Pattern.compile("\\?|:|\"|\\*|<|>|\\\\|/|\\|");
		Matcher m = pattern.matcher(filename);
		if (m.find()) {
			return false;
		}
		// 读取数据库配置
		List<Dictionary> list = dictionaryService.getDictByItemCode(DictEnum.FILE_TYPE_WHITE_LIST.toString());
		if (CollectionUtils.isEmpty(list)) {
			logger.info("字典配置数据异常，无法找到白名单配置信息{}", DictEnum.FILE_TYPE_WHITE_LIST.toString());
			throw new NullPointerException("无法找到对应的白名单配置！");
		}
		Dictionary dict = list.get(0);
		// 校验扩展名是否在数据库配置的白名单里
		if (!CollectionUtils.arrayToList(dict.getsItemValue().split(",")).contains(filenameExtension)) {
			return false;
		}
		return true;
	}

	/**
	 * 通过附件id下载附件.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#downloadAttach(java.lang.Integer,
	 *      java.io.OutputStream)
	 */
	@Override
	public void downloadAttach(Attach attachDto, OutputStream os) throws IOException {
		String sPath = attachDto.getsPath();// 获取附件绝对路径
		if (StringUtils.isEmpty(sPath) || !new File(sPath).exists()) {
			logger.error("下载附件失败！无法在文件系统中找到相关附件，{}", attachDto);
			throw new NullPointerException("下载传附件失败！无法在文件系统中找到相关附件！（" + attachDto + "）");
		}
		// 校验文件权限

		// 从文件系统读取附件
		FileInputStream fis = new FileInputStream(new File(sPath));
		byte[] b = new byte[1024]; // 每次读取1k数据
		int len = 0;
		while (-1 != (len = fis.read(b))) {
			os.write(b, 0, len);
		}
		fis.close();
		os.flush();
		os.close();
	}

	/**
	 * 获取附件信息.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#getAttach(java.lang.Integer)
	 */
	@Override
	public Attach getAttach(Integer nAttachNo) {
		return attachMapper.selectByPrimaryKey(nAttachNo);
	}

	/**
	 * zipPackDownload：批量下载
	 * 
	 * @author cxl
	 * @createDate 2017年12月21日
	 * @param attachNoList
	 * @return
	 * @throws IOException
	 */
	@Override
	public void zipPack(List<Attach> attachList, OutputStream os) throws IOException {
		HashMap<String, String> map = new HashMap<>();
		InputStream input = null;
		if (attachList != null && attachList.size() > 0) { // 要压缩的附件集合有值
			// 用 java.util.zip.ZipOutputStream
			// 的话，会出现文件名中文乱码的问题，所以改为用org.apache.tools.zip.ZipOutputStream
			ZipOutputStream zos = new ZipOutputStream(os);
			zos.setComment("zip file");// 设置注释
			zos.setEncoding("gbk"); // 如果不加此句，压缩文件依然可以生成，只是在打开和解压的时候，会显示乱码，但是还是会解压出来
			for (int i = 0; i < attachList.size(); i++) {
				Attach dto = attachList.get(i);
				String dtoPath = dto.getsPath();// 文件系统中的路径
				if (StringUtils.isEmpty(dtoPath) || !new File(dtoPath).exists()) {
					logger.error("下载附件失败！无法在文件系统中找到相关附件，{}", dto);
					continue;
				}
				File dtoFile = new File(dtoPath); // 获取到文件对象，因为需要文字名
				input = new FileInputStream(dtoFile); // 获取到文件的输入流
				// String nameInPack = "【压缩文件" + (i + 1) + "】" +
				// dto.getsAttachName();//为了防止出现重名文件，在压缩包里的文件名前面加特殊标识
				// 将重复的名称改为相同的后面加(序号)，进行累加 By huangjx date 20180206
				// 判断文件名称是否存在map中
				String nameInPack = "";
				if (map.containsKey(dto.getsAttachName())) {
					// 将Key值设置为当前附件名称 ，value从之前的进行累加
					map.put(dto.getsAttachName(), Integer.valueOf(map.get(dto.getsAttachName())) + 1 + "");
					nameInPack = dto.getsAttachName();
					// 获得后缀名.的索引
					int index = nameInPack.lastIndexOf(".");
					// 截取.之前加上当前累计数量，在拼接上后缀名称（）
					nameInPack = nameInPack.substring(0, index) + "(" + map.get(dto.getsAttachName()) + ")"
							+ nameInPack.substring(index, nameInPack.length());
				} else {
					// 不存在HashMap中，则初始化附件统计数量
					map.put(dto.getsAttachName(), "0");
					nameInPack = dto.getsAttachName();
				}
				zos.putNextEntry(new ZipEntry(nameInPack)); // 设置到压缩流中
				byte[] b = new byte[1024]; // 每次读取1k数据
				int len = 0;
				while (-1 != (len = input.read(b))) {
					zos.write(b, 0, len);
				}
				input.close();
			}
			zos.flush();
			zos.close();

		} else {
			logger.error("下载附件失败！选择的附件对象都没有可下载的附件，{}", attachList);
			throw new NullPointerException("下载传附件失败！选择的附件对象都没有可下载的附件！（" + attachList + "）");
		}
	}

	/**
	 * 根据附件ID查询历史版本附件.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#getAttachVersions(java.lang.Integer)
	 */
	@Override
	public List<Attach> getAttachVersions(Integer nAttachNo) {
		AttachExample example = new AttachExample();
		example.createCriteria().andSStatusEqualTo(DataStatusEnum.VALID.getCode()).andNLastAttachNoEqualTo(nAttachNo);// 根据n_last_attach_no字段查询同一版本的文件信息
		example.setOrderByClause("n_version desc");// 按照版本倒序
		return attachMapper.selectByExample(example);
	}

	/**
	 * 删除附件：软删除.
	 * 
	 * @see com.efunds.pms.common.sys.service.AttachService#deleteAttach(java.lang.Integer)
	 */
	@Override
	public boolean deleteAttach(Integer nAttachNo) {
		Attach record = new Attach();
		record.setnAttachNo(nAttachNo);
		record.setsStatus(DataStatusEnum.INVALID.getCode());
		int i = attachMapper.updateByPrimaryKeySelective(record);
		return i > 0;
	}

	@Override
	public List<Attach> getAttachList(List<Integer> attachNoList) {
		if (CollectionUtils.isEmpty(attachNoList)) {
			throw new IllegalArgumentException("附件ID列表不能为空！");
		}
		AttachExample example = new AttachExample();
		example.createCriteria().andNAttachNoIn(attachNoList);
		return attachMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Attach> getAttachListPage(@RequestParam int pageIndex, @RequestParam int pageSize,
			String sAttachName, String sFileType, Date dCreateTime) {
		// 用于查询全部信息，判断是否需要查询全部的信息
		logger.info("查询附件信息列表：{},{},{},{},{}", pageIndex, pageSize, sAttachName, sFileType, dCreateTime);
		// 拼装条件
		AttachExample example = new AttachExample();
		Criteria criteria = example.createCriteria();
		criteria.andNAttachNoIsNotNull();
		criteria.andSStatusNotEqualTo(DataStatusEnum.INVALID.getCode());
		// 模糊查询
		if (StringUtils.hasText(sAttachName)) {
			criteria.andSAttachNameLike("%" + sAttachName + "%");
		}
		if (StringUtils.hasText(sFileType)) {
			criteria.andSFileTypeLike("%" + sFileType + "%");
		}
		criteria.andDCreateTimeLessThanOrEqualTo(dCreateTime);
		example.setOrderByClause(" D_CREATE_TIME ASC ");
		logger.debug("附件信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<Attach> attachs = attachMapper.selectByExample(example);
		return new PageInfo<Attach>(attachs);
	}

	/**  
	 * 更新附件名称 
	 * @see com.hgl.recruitms.service.AttachService#updateAttachName(java.lang.Integer, java.lang.String)  
	 */
	@Override
	public boolean updateAttachName(Integer nAttachNo, String attachName) {
		Attach record = new Attach();
		record.setnAttachNo(nAttachNo);
		record.setsAttachName(attachName);
		int i = attachMapper.updateByPrimaryKeySelective(record);
		return i > 0;
	}
}

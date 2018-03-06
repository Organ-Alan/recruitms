package com.hgl.recruitms.common.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.CommonResponseObject;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.util.CommonUtil;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.Attach;
import com.hgl.recruitms.service.AttachService;
import com.hgl.recruitms.service.CommonService;

/**
 * ClassName: AttachController <br/>
 * Description：上传附件，包括入学须知文档、通知书模板文档、招生计划文档等
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/{version}/common/attach")
public class AttachController {
	private static final Logger logger = LogManager.getLogger(AttachController.class);

	@Autowired
	private CommonResponseObject builder;

	@Autowired
	private AttachService attachService;

	@Autowired
	private CommonService<Account> commonService;

	/**
	 * uploadFile:(上传文件). <br/>
	 * 
	 * @author huanggl
	 * @param file
	 * @param fileName
	 * @param nFundNo
	 * @param sAttachCode
	 * @param sAttachType
	 * @param parentCode
	 * @param parentType
	 * @param nAttachNo
	 * @param sFundType
	 * @param PmsUserBean
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/file", method = { RequestMethod.POST })
	public ResponseObject<?> uploadFile(@RequestParam Part file, @RequestParam String fileName,
			@RequestParam String sAttachType, @RequestParam Integer nAttachNoOld, @RequestParam String sUsername)
			throws IOException {
		InputStream is = file.getInputStream();
		if (!attachService.checkFileName(fileName)) {
			return builder.error(ErrorEnum.FILETYPEERROR.getErrorCode(), "不支持的文件类型！（" + fileName + "）");
		}
		Account account = commonService.selectBysUserName(sUsername);
		Attach attach = attachService.uploadAttach(is, fileName, nAttachNoOld, account.getsUserNo(),
				account.getsUsername());
		return builder.success(attach);
	}

	/**
	 * downloadFile:(通过附件id下载附件). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 *            附件ID
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/file/{nAttachNo}", method = RequestMethod.GET)
	public void downloadFile(@PathVariable Integer nAttachNo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("开始下载附件：{}", nAttachNo);
		Attach attach = attachService.getAttach(nAttachNo);
		if (attach == null) { // 附件不存在
			logger.error("下载附件失败！无法获取相关附件信息，{}", nAttachNo);
			throw new NullPointerException("下载传附件失败！无法获取相关附件信息（" + nAttachNo + "）");
		}

		String fileName = CommonUtil.adjustFileName(request.getHeader("User-Agent"), attach.getsAttachName());
		logger.debug("fileName {},", fileName);
		// -----------------------
		// 设置文件名及响应头
		// 这个方法在IE中会乱码
		// response.setHeader("Content-Disposition","attachment; filename="+new
		// String(fileName.getBytes("utf-8"), "ISO8859-1")+"");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "");
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
		// 要先设置请求头，再写输出流，下载才能正常
		OutputStream os = response.getOutputStream();
		attachService.downloadAttach(attach, os);
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (Exception e) {
				logger.info("close os error");
			}
		}
		logger.info("下载附件完成{}", attach);
	}

	/**
	 * getAttachVersions:(根据附件ID查询历史版本附件). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 * @return
	 */
	@RequestMapping(value = "/versions/{nAttachNo}", method = { RequestMethod.GET })
	public ResponseObject<?> getAttachVersions(@PathVariable Integer nAttachNo) {
		List<Attach> attachList = attachService.getAttachVersions(nAttachNo);
		if (attachList == null || attachList.size() == 0) {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无相关文件的版本信息！（" + nAttachNo + "）");
		}
		return builder.success(attachList);
	}

	/**
	 * deleteAttach:(删除附件). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 * @return
	 */
	@RequestMapping(value = "/file/{nAttachNo}", method = { RequestMethod.PUT })
	public ResponseObject<?> deleteAttach(@PathVariable Integer nAttachNo) {
		boolean delSuccess = attachService.deleteAttach(nAttachNo);
		return builder.success(delSuccess);
	}

	/**
	 * updateAttach:更新附件名称. <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 * @param attachName
	 * @return
	 */
	@RequestMapping(value = "/file", method = { RequestMethod.PUT })
	public ResponseObject<?> updateAttachName(@RequestParam Integer nAttachNo, @RequestParam String attachName) {
		if (nAttachNo == null || attachName == null) {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "参数异常！");
		}
		if (!attachService.checkFileName(attachName)) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "不支持的文件类型！（" + attachName + "）");
		}
		boolean delSuccess = attachService.updateAttachName(nAttachNo, attachName);
		return builder.success(delSuccess);
	}

	/**
	 * downloadAttach：通过附件id打包下载附件
	 * 
	 * @author huanggl
	 * @createDate 2017年12月18日
	 * @param nAttachNo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public void zipPack(@RequestParam List<Integer> attachNos, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

		String zipName = "压缩文件_" + sdf.format(new Date()) + ".zip";
		if (CollectionUtils.isEmpty(attachNos)) {
			throw new IllegalArgumentException("附件ID列表不能为空！");
		}
		// 根据附件ID查询附加信息
		List<Attach> attchList = attachService.getAttachList(attachNos);
		/*
		 * 压缩包名称固定为“压缩文件_YYYYMMddHHmmss.zip”，不取文件名
		 * 
		 * for (Attach attach : attchList) { zipName += "【" + attach.getsAttachName() +
		 * "】";//组装压缩文件的文件名 } if(zipName.length() == 0){ throw new
		 * NullPointerException("获取文件名称失败！"); } if(zipName.length() > 100){ zipName =
		 * zipName.substring(0, 100) + "...";//截取100个字符作为压缩包名称 } zipName = zipName +
		 * ".zip";
		 */

		// 设置文件名称
		zipName = CommonUtil.adjustFileName(request.getHeader("User-Agent"), zipName);
		// -----------------------
		// 设置文件名及响应头
		// 这个方法在IE中会乱码
		// response.setHeader("Content-Disposition","attachment; filename="+new
		// String(fileName.getBytes("utf-8"), "ISO8859-1")+"");
		response.setHeader("Content-Disposition", "attachment; filename=" + zipName + "");
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());

		if (attchList != null && attchList.size() > 0) {
			// 要先设置请求头，再写输出流，下载才能正常
			OutputStream os = response.getOutputStream();
			attachService.zipPack(attchList, os);
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (Exception e) {
					logger.info("close os error");
				}
			}
			logger.info("下载附件完成{}", zipName);
		} else {
			logger.error("下载附件失败！选择的附件对象都没有可下载的附件路径，{}", attchList);
			throw new NullPointerException("下载传附件失败！选择的附件对象都没有可下载的附件路径！（" + attchList + "）");
		}
	}

	/**
	 * getAttachListPage:(根据文件名和列表搜索条件查询分页信息). <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sAttachName
	 *            文件名
	 * @param sFileType
	 *            文件后缀名
	 * @param dCreateTime
	 *            上传时间
	 * @return
	 */
	@RequestMapping(value = "/attachListPage", method = RequestMethod.GET)
	public ResponseObject<?> getAttachListPage(@RequestParam int pageIndex, @RequestParam int pageSize,
			String sAttachName, String sFileType, Date dCreateTime) {
		PageInfo<Attach> attachList = attachService.getAttachListPage(pageIndex, pageSize, sAttachName.trim(),
				sFileType.trim(), dCreateTime);
		return builder.success(attachList);
	}

}

package com.hgl.recruitms.service.impl;

import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.RecruitInfoMapper;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.enums.PayFlagEnum;
import com.hgl.recruitms.enums.RecruitInfoColEnum;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.enums.YesOrNoEnum;
import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.model.RecruitInfoExample;
import com.hgl.recruitms.model.RecruitInfoExample.Criteria;
import com.hgl.recruitms.service.DepartmentService;
import com.hgl.recruitms.service.RecruitInfoService;

/**
 * ClassName: RecruitInfoServiceImpl <br/>
 * Description：新生信息业务接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@Service
public class RecruitInfoServiceImpl implements RecruitInfoService {
	static Logger logger = LoggerFactory.getLogger(RecruitInfoServiceImpl.class);
	@Autowired
	private RecruitInfoMapper recruitInfoMapper;

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 新增新生信息时，系统默认待审核
	 * 
	 * @see com.hgl.recruitms.service.RecruitInfoService#insertRecruitInfo(com.hgl.recruitms.model.RecruitInfo)
	 */
	@Override
	public boolean insertRecruitInfo(RecruitInfo recruitInfo) {
		recruitInfo.setsStatus(AuditStatusEnum.AUDIT.getCode());
		recruitInfo.setdOperateTime(new Date());
		int count = recruitInfoMapper.insert(recruitInfo);
		logger.info("新增新生信息:" + recruitInfo.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public RecruitInfo getRecruitInfo(Integer nStudentId) {
		RecruitInfo recruitInfo = new RecruitInfo();
		RecruitInfoExample recruitInfoExample = new RecruitInfoExample();
		// 拼装条件（）
		recruitInfoExample.createCriteria().andNStudentIdEqualTo(nStudentId);
		List<RecruitInfo> recruitInfoList = recruitInfoMapper.selectByExample(recruitInfoExample);
		if (recruitInfoList != null && recruitInfoList.size() > 0) {
			recruitInfo = recruitInfoList.get(0);// 获取学生信息信息
		}
		return recruitInfo;
	}
	
	@Override
	public RecruitInfo getRecruitInfo(String sStudentName) {
		RecruitInfoExample recruitInfoExample = new RecruitInfoExample();
		// 拼装条件（）
		recruitInfoExample.createCriteria().andNStudentIdIsNotNull().andSStudentNameEqualTo(sStudentName);
		List<RecruitInfo> recruitInfoList = recruitInfoMapper.selectByExample(recruitInfoExample);
		if (CollectionUtils.isEmpty(recruitInfoList)) {
			throw new RuntimeException("无法获取信息，请联系管理员！");
		}
		return recruitInfoList.get(0);
	}

	@Override
	public boolean updateRecruitInfo(RecruitInfo recruitInfo) {
		// 通过主键学生信息编码进行修改
		int count = 0;
		//如果该学生未被审核通过就交学费，就提示审核未通过，不允许交学费。
		RecruitInfo recruitInfoCpm = recruitInfoMapper.selectByPrimaryKey(recruitInfo.getnStudentId());
		if (!recruitInfo.getsPayFlag().equals("")) {
			if (recruitInfoCpm.getsStatus().equals(AuditStatusEnum.REFUSE.getCode())) {
				throw new RuntimeException("修改基础信息失败，该学生未被审核，不允许缴费！");
			}
		}
		recruitInfo.setdOperateTime(new Date());
		recruitInfo.setsStatus(AuditStatusEnum.AUDIT.getCode());
		count = recruitInfoMapper.updateByPrimaryKeySelective(recruitInfo);
		logger.debug("调用数据库修改学生信息信息的条数为::" + count);
		// 当修改学生信息信息失败时
		if (count < 1) {
			logger.error("修改基础信息失败,修改基础信息数据为：" + recruitInfo.toString() + "，条件为:" + recruitInfo.getnStudentId());
			throw new RuntimeException("修改基础信息失败，抛出异常，事务回滚");
		}
		return count > 0;
	}

	/**
	 * listRecruitInfo:分页获取新生信息 <br/>
	 * 
	 * @see com.hgl.recruitms.service.RecruitInfoService#listRecruitInfo(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<RecruitInfo> listRecruitInfos(Integer pageIndex, Integer pageSize, String sStudentNo,
			String sStudentName, String sAdmitedMajor, String sGrade, String sPayFlag, String sStatus) {
		// 用于查询全部信息，判断是否需要查询全部的信息，包括已变更，已删除的产品信息
		logger.info("查询新生信息列表：{},{},{},{},{},{},{},{}", pageIndex, pageSize, sStudentNo, sStudentName, sAdmitedMajor,
				sGrade, sPayFlag, sStatus);
		// 拼装条件
		RecruitInfoExample example = new RecruitInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andNStudentIdIsNotNull();
		// 模糊查询
		if (StringUtils.hasText(sStudentNo)) {
			criteria.andSStudentNoLike("%" + sStudentNo + "%");
		}
		if (StringUtils.hasText(sStudentName)) {
			criteria.andSStudentNameLike("%" + sStudentName + "%");
		}
		if (StringUtils.hasText(sAdmitedMajor)) {
			criteria.andSAdmitedMajorLike("%" + sAdmitedMajor + "%");
		}
		if (StringUtils.hasText(sGrade)) {
			criteria.andSGradeLike("%" + sGrade + "%");
		}
		if (StringUtils.hasText(sPayFlag)) {
			criteria.andSPayFlagEqualTo(sPayFlag);
		}
		if (StringUtils.hasText(sStatus)) {
			criteria.andSStatusEqualTo(sStatus);
		}
		example.setOrderByClause(" D_OPERATE_TIME desc ");
		logger.debug("新生信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<RecruitInfo> recruitInfos = recruitInfoMapper.selectByExample(example);
		return new PageInfo<RecruitInfo>(recruitInfos);
	}

	@Override
	public int accountRecruitStudent() {
		RecruitInfoExample example = new RecruitInfoExample();
		// 过滤无效的学生信息
		example.createCriteria().andNStudentIdIsNotNull();
		int count = (int) recruitInfoMapper.countByExample(example);
		return count;
	}

	/**
	 * 批量审核新生数据
	 * 
	 * @param action
	 *            2、审核通过 3、审核不通过
	 * @see com.hgl.recruitms.service.RecruitInfoService#updateInfoStatus(java.lang.Integer[],
	 *      java.lang.String)
	 */
	@Override
	public boolean updateInfoStatus(Integer nStudentId, String action) {
		RecruitInfoExample example = new RecruitInfoExample();
		Criteria criteria = example.createCriteria();
		if (nStudentId == null) {
			return false;
		}
		criteria.andNStudentIdEqualTo(nStudentId);
		RecruitInfo recruitInfo = new RecruitInfo();
		int count = 0;
		// 审核通过
		if (action.equals(AuditStatusEnum.PASS.getCode())) {
			logger.debug("审核通过：：" + action);
			recruitInfo.setsStatus(AuditStatusEnum.PASS.getCode());
			count = recruitInfoMapper.updateByExampleSelective(recruitInfo, example);
		}
		// 审核不通过
		if (action.equals(AuditStatusEnum.REFUSE.getCode())) {
			logger.debug("审核不通过：：" + action);
			recruitInfo.setsStatus(AuditStatusEnum.REFUSE.getCode());
			count = recruitInfoMapper.updateByExampleSelective(recruitInfo, example);
		}
		if (count != 1) {
			// 当批量删除数量，与受影响行数不符时，抛出异常，事务回滚
			logger.info("批量审核失败,审核数量与需要审核数量不符：" + count + "  数量为" + count);
			throw new IndexOutOfBoundsException("批量审核失败");
		}
		logger.debug("批量审核：" + nStudentId + "新生信息，结果：" + (count > 0));
		return count > 0;
	}

	/**
	 * 导出新生信息列表
	 * 
	 * @see com.hgl.recruitms.service.RecruitInfoService#exportRecruitInfo(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.util.List, java.lang.String)
	 */
	@Override
	public List<List<String>> exportRecruitInfo(String sStudentNo, String sStudentName, String sAdmitedMajor,
			String sGrade, String sPayFlag, String sStatus, List<Integer> nStudentIdList, String exportType) {
		List<List<String>> table = new ArrayList<>();
		List<String> line = new ArrayList<>();
		// 第一行，表头：根据枚举配置表头信息
		String headsStr = TBHeaderEnum.fromName(exportType).getCode();
		String[] headArr = headsStr.split(",");
		for (String head : headArr) {

			// 通过属性获取对应的中文名称
			String name = RecruitInfoColEnum.fromCode(head).getName();
			line.add(name);
		}
		table.add(line);

		PageInfo<RecruitInfo> pageInfo = listRecruitInfos(0, 0, sStudentNo, sStudentName, sAdmitedMajor, sGrade,
				sPayFlag, sStatus);
		List<RecruitInfo> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (RecruitInfo recruitInfo : list) {
				line = new ArrayList<>();
				for (String head : headArr) {
					String sValue = "";
					Field field = null;
					try {
						// 在父类中没有获取到属性则去子类中取值，子类中依旧无法找到属性时，抛出异常
						try {
							field = RecruitInfo.class.getDeclaredField(head);
						} catch (NoSuchFieldException e) {
							field = RecruitInfo.class.getDeclaredField(head);
						}
						// 设置为可访问recruitInfo内部属性
						field.setAccessible(true);
						try {
							// 处理特殊字段数据：枚举、时间
							if (head.equals("sStatus")) {
								// 如果是审核状态，则对数据进行处理：1-待审核，2-审核通过，3-审核不通过
								sValue = (String) field.get(recruitInfo);
								if (StringUtils.hasText(sValue)) {
									sValue = AuditStatusEnum.fromCode(sValue).getName();
								}
							} else if (head.equals("sAdmitedMajor")) {
								// 如果是录取专业，则调用字典查询接口
								sValue = (String) field.get(recruitInfo);
								if (StringUtils.hasText(sValue)) {
									sValue = departmentService.getDeptByCode(sValue).getsFullName();
								}
							} else if (head.equals("sPayFlag")) {
								// 如果是是否缴费，则对数据进行处理：0- 未缴费，1-已缴费，2-已缴部分费用
								sValue = (String) field.get(recruitInfo);
								if (StringUtils.hasText(sValue)) {
									sValue = PayFlagEnum.fromCode(sValue).getName();
								}
							} else {
								sValue = (String) field.get(recruitInfo);
							}
						} catch (IllegalArgumentException e) {
							logger.error("新生导出出现异常（IllegalArgumentException）：：" + e);
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							logger.error("新生导出出现异常(IllegalAccessException):" + e);
							e.printStackTrace();
						}
					} catch (NoSuchFieldException e) {
						logger.error("新生导出出现异常(NoSuchFieldException):" + e);
						e.printStackTrace();
					} catch (SecurityException e) {
						logger.error("新生导出出现异常(SecurityException):" + e);
						e.printStackTrace();
					}
					line.add(sValue);
				}
				table.add(line);
			}
		}
		return table;
	}

	/**
	 * 获取审核通过的新生信息
	 * 
	 * @see com.hgl.recruitms.service.RecruitInfoService#getPassedAuditStu()
	 */
	@Override
	public Integer getPassedAuditStu() {
		RecruitInfoExample example = new RecruitInfoExample();
		example.createCriteria().andNStudentIdIsNotNull().andSStatusEqualTo(AuditStatusEnum.PASS.getCode());
		List<RecruitInfo> recruitInfos = recruitInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(recruitInfos)) {
			return null;
		}
		return recruitInfos.size();
	}

	/**
	 * getRateRigister:获取新生报到率
	 * 
	 * @author huanggl
	 * @return
	 */
	public String getRateRigister() {
		RecruitInfoExample example = new RecruitInfoExample();
		RecruitInfoExample unregisterExample = new RecruitInfoExample();
		example.createCriteria().andNStudentIdIsNotNull();
		unregisterExample.createCriteria().andNStudentIdIsNotNull().andSRegisterFlagEqualTo(YesOrNoEnum.N.getCode());
		List<RecruitInfo> total = recruitInfoMapper.selectByExample(example);
		List<RecruitInfo> unregisters = recruitInfoMapper.selectByExample(unregisterExample);
		if (CollectionUtils.isEmpty(unregisters) && CollectionUtils.isEmpty(total)) {
			throw new RuntimeException("获取报到率失败！报到学生人数为+" + total.size() + "  未注册学生人数为：" + unregisters.size());
		}
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(4);
		String sRateRigister = numberFormat.format((float) unregisters.size() / (float) total.size() * 100);
		System.out.println("报到率为:" + sRateRigister + "%");
		return sRateRigister;
	}
}

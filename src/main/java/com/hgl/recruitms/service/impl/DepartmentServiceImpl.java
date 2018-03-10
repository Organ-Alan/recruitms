package com.hgl.recruitms.service.impl;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.bean.EnrolmentInfo;
import com.hgl.recruitms.dao.DepartmentMapper;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.enums.DeptInfoColEnum;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.model.DepartmentExample;
import com.hgl.recruitms.model.DepartmentExample.Criteria;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.service.CommonService;
import com.hgl.recruitms.service.DepartmentService;
import com.hgl.recruitms.service.DictionaryService;
import com.hgl.recruitms.service.RecruitInfoService;

/**
 * ClassName: DepartmentServiceImpl <br/>
 * Description：院系专业信息业务接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private CommonService<Department> commonService;

	@Autowired
	private RecruitInfoService recruitInfoService;
	
	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private CommonService<Account> accountService;

	@Override
	public boolean insertDepartment(Department Department) {
		int count = departmentMapper.insertSelective(Department);
		logger.info("新增院系专业信息:" + Department.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public Department getDepartment(Integer nDeptNo) {
		Department Department = new Department();
		DepartmentExample DepartmentExample = new DepartmentExample();
		// 拼装条件（院系专业内部编码）
		DepartmentExample.createCriteria().andNDeptNoEqualTo(nDeptNo);
		List<Department> DepartmentList = departmentMapper.selectByExample(DepartmentExample);
		if (DepartmentList != null && DepartmentList.size() > 0) {
			Department = DepartmentList.get(0);// 获取学生信息信息
		}
		return Department;
	}

	/**
	 * listDepartment:分页获取院系专业信息 <br/>
	 * 
	 * @see com.hgl.recruitms.service.DepartmentService#listDepartments(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Department> listDepartments(Integer pageIndex, Integer pageSize, String sDeptCode,
			String sShortName, String sFullName, String sRegion, String dbEnrolScore) {
		// 用于查询全部信息，判断是否需要查询全部的信息，包括已变更，已删除的院系专业信息
		logger.info("查询院系专业列表：{},{},{},{},{},{},{},{}", pageIndex, pageSize, sDeptCode, sShortName, sFullName, sRegion,
				dbEnrolScore);

		// 拼装条件
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNDeptNoIsNotNull();
		criteria.andCValidFlagNotEqualTo(DataStatusEnum.INVALID.getCode());
		// 模糊查询
		if (StringUtils.hasText(sDeptCode)) {
			criteria.andSDeptCodeLike("%" + sDeptCode + "%");
		}
		if (StringUtils.hasText(sShortName)) {
			criteria.andSShortNameLike("%" + sShortName + "%");
		}
		if (StringUtils.hasText(sFullName)) {
			criteria.andSFullNameLike("%" + sFullName + "%");
		}
		if (StringUtils.hasText(sRegion)) {
			criteria.andSRegionEqualTo(sRegion);
		}
		if (StringUtils.hasText(dbEnrolScore)) {
			criteria.andDbEnrolScoreEqualTo(Double.parseDouble(dbEnrolScore));
		}
		example.setOrderByClause(" N_COUNT_ENROL ASC ");
		logger.debug("字典信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<Department> Departments = departmentMapper.selectByExample(example);
		return new PageInfo<Department>(Departments);
	}

	/**
	 * 院系专业信息修改.
	 * 
	 * @see com.efunds.pms.oneonone.service.DepartmentService#updateDepartment(com.efunds.pms.oneonone.model.Department,
	 *      java.lang.String)
	 */
	@Override
	public boolean updateDepartment(Department department, String sUsername) {
		Integer nDeptNo = department.getnDeptNo();
		// 通过院系专业内部编码获取旧的数据 查询条件是审核
		Department oldDepartment = departmentMapper.selectByPrimaryKey(nDeptNo);
		if (oldDepartment == null) {
			throw new NullPointerException("通过院系专业内部编码获取旧的院系专业信息为空！");
		}
		Account account = accountService.selectBysUserName(sUsername);
		List<String> noCheck = new ArrayList<>();
		noCheck.add("sCreator");
		noCheck.add("sCreatorNo");
		noCheck.add("dCreateTime");
		logger.debug("院系专业获取旧的院系专业信息为：" + oldDepartment + "当前院系专业信息为：：" + department);
		boolean flag = commonService.checkDiffAndInsert(oldDepartment, department, noCheck, account.getsUserNo(),
				account.getsUsername());
		return flag;
	}

	/**
	 * 修改审核的审核通过或者审核不通过
	 * 
	 * @see com.hgl.recruitms.service.DepartmentService#updateRevisionReview(java.util.List,
	 *      java.util.List, java.lang.String)
	 */
	@Override
	public boolean updateRevisionReview(List<Integer> nDeptNoList, List<Integer> sAuditNoList, String auditStatus,
			String sUsername) throws IllegalArgumentException, IllegalAccessException, ParseException {

		if (CollectionUtils.isEmpty(nDeptNoList)) {
			throw new NullPointerException("院系专业内部编码集合为空");
		}
		// 去重 ,院系专业内部编码存在重复id,且转换成set集合的时候list集合不能为空
		HashSet<Integer> nDeptNoSet = new HashSet<Integer>(nDeptNoList);
		nDeptNoList.clear();
		nDeptNoList.addAll(nDeptNoSet);
		logger.debug("获取去重后的院系专业内部编码集合为：" + nDeptNoList);
		DepartmentExample departmentExample = new DepartmentExample();
		departmentExample.createCriteria().andNDeptNoIn(nDeptNoList);
		// 通过从院系专业内部编码查询获取旧的院系专业信息集合
		List<Department> oldtList = new ArrayList<Department>();
		if (!AuditStatusEnum.REFUSE.getCode().equals(auditStatus)) {
			oldtList = departmentMapper.selectByExample(departmentExample);
		}
		logger.debug("院系专业获取旧的院系专业信息对象集合为：" + oldtList);
		Account account = accountService.selectBysUserName(sUsername);
		// 审核是否能够成功
		boolean flag = commonService.updateAuditStatus(oldtList, sAuditNoList, AuditStatusEnum.fromCode(auditStatus),
				nDeptNoList, account.getsUserNo(), account.getsUsername());

		if (flag && AuditStatusEnum.PASS.getCode().equals(auditStatus)) {
			for (Department department : oldtList) {
				logger.debug("当前需要更新的基础信息：" + department);
				// 更新院系专业信息
				int count = departmentMapper.updateByPrimaryKey(department);
				if (count <= 0) {
					throw new RuntimeException("审核通过中修改院系专业的基础信息失败");
				}
			}
		}
		return flag;
	}

	@Override
	public boolean delDeptInfo(Integer nDeptNo) {
		// 修改院系专业表的数据状态sValidFlag值为删除状态
		Department department = departmentMapper.selectByPrimaryKey(nDeptNo);
		department.setcValidFlag(DataStatusEnum.INVALID.getCode());
		int isSuccess = departmentMapper.updateByPrimaryKeySelective(department);
		return isSuccess > 0;
	}

	/**
	 * 根据专业代码获取院系专业信息
	 * 
	 * @see com.hgl.recruitms.service.DepartmentService#getDeptByCode(java.lang.String)
	 */
	@Override
	public Department getDeptByCode(String sDeptCode) {
		System.out.println("+++++"+sDeptCode);	
		DepartmentExample example = new DepartmentExample();
		// example.createCriteria().andSDeptCodeEqualTo(sDeptCode);
		if (!StringUtils.hasText(sDeptCode)) {
			logger.error("错误专业代码：" + sDeptCode);
			throw new RuntimeException("专业信息查询失败,请联系管理员!");
		}
		example.createCriteria().andSDeptCodeEqualTo(sDeptCode);
		List<Department> departments = departmentMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(departments)) {
			logger.error("查询该专业信息为空：" + sDeptCode);
			throw new RuntimeException("专业信息查询失败,请联系管理员!");
		}
		return departments.get(0);
	}

	@Override
	public EnrolmentInfo getEnrolmentInfo() {
		EnrolmentInfo enrolmentInfo = new EnrolmentInfo();
		EnrolmentInfo result = new EnrolmentInfo();
		result = departmentMapper.selectEnrolmentInfo();
		// 统计招生计划人数
		enrolmentInfo.setnEnrolNumber(result.getnEnrolNumber());
		logger.debug("统计出来的招生计划人数：" + result.getnEnrolNumber());

		// 统计录取人数
//		Integer nAdmitedNumber = Integer.parseInt(CommonUtil.numberToThousands((long)recruitInfoService.accountRecruitStudent()));
		Integer nAdmitedNumber =recruitInfoService.accountRecruitStudent();
		enrolmentInfo.setnAdmitedNumber(nAdmitedNumber);

		// 审核通过新生
//		Integer nRecruitNumber = Integer.parseInt(CommonUtil.numberToThousands((long)recruitInfoService.getPassedAuditStu()));
		Integer nRecruitNumber =recruitInfoService.getPassedAuditStu();
		enrolmentInfo.setnRecruitNumber(nRecruitNumber);

		// 报到率
		String sRateRigister = recruitInfoService.getRateRigister();
		enrolmentInfo.setsRateRigister(sRateRigister);

		// 学院总人数
		
		Integer nTotalNumber = 14433;
		enrolmentInfo.setnTotalNumber(nTotalNumber);

		// 就业率
		enrolmentInfo.setsRateEmployment("93.295");

		// 国际班数
		enrolmentInfo.setnInternationalClassNum(result.getnInternationalClassNum());

		// 遍历全院专业信息
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andNDeptNoIsNotNull().andCValidFlagEqualTo(DataStatusEnum.VALID.getCode());
		PageInfo<Department> departments = listDepartments(1, 100);
		enrolmentInfo.setDepartments(departments);
		return enrolmentInfo;
	}

	@Override
	public PageInfo<Department> listDepartments(Integer pageIndex, Integer pageSize) {
		logger.debug("字典信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<Department> Departments = departmentMapper.accountDepartments();
		return new PageInfo<Department>(Departments);
	}

	@Override
	public List<List<String>> exportRecruitInfo(String sDeptCode, String sShortName, String sFullName, String sRegion,
			String dbEnrolScore, List<Integer> nStudentIdList, String exportType) {
		List<List<String>> table = new ArrayList<>();
		List<String> line = new ArrayList<>();
		// 第一行，表头：根据枚举配置表头信息
		String headsStr = TBHeaderEnum.fromName(exportType).getCode();
		String[] headArr = headsStr.split(",");
		for (String head : headArr) {

			// 通过属性获取对应的中文名称
			String name = DeptInfoColEnum.fromCode(head).getName();
			line.add(name);
		}
		table.add(line);

		PageInfo<Department> pageInfo = listDepartments(0, 0, sDeptCode, sShortName, sFullName, sRegion, dbEnrolScore);
				
		List<Department> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (Department department : list) {
				line = new ArrayList<>();
				for (String head : headArr) {
					String sValue = "";
					Field field = null;
					try {
						// 在父类中没有获取到属性则去子类中取值，子类中依旧无法找到属性时，抛出异常
						try {
							field = Department.class.getDeclaredField(head);
						} catch (NoSuchFieldException e) {
							field = Department.class.getDeclaredField(head);
						}
						// 设置为可访问recruitInfo内部属性
						field.setAccessible(true);
						try {
							// 处理特殊字段数据：枚举、时间
							if (head.equals("cValidFlag")) {
								// 如果是审核状态，则对数据进行处理：1-待审核，2-审核通过，3-审核不通过
								sValue = (String) field.get(department);
								if (StringUtils.hasText(sValue)) {
									sValue = AuditStatusEnum.fromCode(sValue).getName();
								}
							} else if (head.equals("sRegion")) {
								// 如果是录取专业，则调用字典查询接口
								sValue = (String) field.get(department);
								if (StringUtils.hasText(sValue)) {
									Dictionary dictionary = dictionaryService.getDicByItemCodeAndKey("COLLEGE", sValue);
									if (dictionary == null) {
										sValue = (String) field.get(department);
									}else {
										sValue = dictionary.getsItemValue();
									}
								}
							} else if (head.equals("nCountEnrol")||head.equals("nCountExtRnrol")) {
								// 如果是是否缴费，则对数据进行处理：0- 未缴费，1-已缴费，2-已缴部分费用
								Integer i = (Integer) field.get(department);
								sValue = String.valueOf(i);
							}else if (head.equals("dbEnrolScore")) {
								Double temp = (Double) field.get(department);
								sValue = String.valueOf(temp);
							} else {
								sValue = (String) field.get(department);
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
}

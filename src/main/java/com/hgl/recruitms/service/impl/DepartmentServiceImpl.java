package com.hgl.recruitms.service.impl;

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
import com.hgl.recruitms.dao.DepartmentMapper;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.model.DepartmentExample;
import com.hgl.recruitms.model.DepartmentExample.Criteria;
import com.hgl.recruitms.service.CommonService;
import com.hgl.recruitms.service.DepartmentService;

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
	private CommonService<Account> accountService;

	@Override
	public boolean insertDepartment(Department Department) {
		int count = departmentMapper.insert(Department);
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

		DepartmentExample DepartmentExample = new DepartmentExample();
		DepartmentExample.createCriteria().andNDeptNoIn(nDeptNoList);
		// 通过从院系专业内部编码查询获取旧的院系专业信息集合
		List<Department> oldtList = new ArrayList<Department>();
		if (!AuditStatusEnum.REFUSE.getCode().equals(auditStatus)) {
			oldtList = departmentMapper.selectByExample(DepartmentExample);
		}
		logger.debug("院系专业获取旧的院系专业信息对象集合为：" + oldtList);
		Account account = accountService.selectBysUserName(sUsername);
		// 审核是否能够成功
		boolean flag = commonService.updateAuditStatus(oldtList, sAuditNoList, AuditStatusEnum.fromCode(auditStatus),
				nDeptNoList, account.getsUserNo(), account.getsUsername());

		if (flag && AuditStatusEnum.PASS.getCode().equals(auditStatus)) {
			for (Department Department : oldtList) {
				logger.debug("当前需要更新的基础信息：" + Department);
				// 更新院系专业信息
				int count = departmentMapper.updateByPrimaryKey(Department);
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
	 * @see com.hgl.recruitms.service.DepartmentService#getDeptByCode(java.lang.String)  
	 */
	@Override
	public Department getDeptByCode(String sDeptCode) {
		DepartmentExample example = new DepartmentExample();
//		example.createCriteria().andSDeptCodeEqualTo(sDeptCode);
		if (!StringUtils.hasText(sDeptCode)) {
			logger.error("错误专业代码："+sDeptCode);
			throw new RuntimeException("专业信息查询失败,请联系管理员!");
		}
		example.createCriteria().andSDeptCodeEqualTo(sDeptCode);
		List<Department> departments = departmentMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(departments)) {
			logger.error("查询该专业信息为空："+sDeptCode);
			throw new RuntimeException("专业信息查询失败,请联系管理员!");
		}
		return departments.get(0);
	}
}

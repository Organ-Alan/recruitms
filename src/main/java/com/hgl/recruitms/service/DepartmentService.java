package com.hgl.recruitms.service;

import java.text.ParseException;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.bean.EnrolmentInfo;
import com.hgl.recruitms.model.Department;

/**
 * ClassName: DepartmentService <br/>
 * Description：院系专业管理业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface DepartmentService {
	/**
	 * insertDepartment:(新增院系专业). <br/>
	 * 
	 * @author huanggl
	 * @param Department
	 *            院系专业类
	 * @return 返回true则成功，返回false则失败
	 */
	boolean insertDepartment(Department department);

	/**
	 * getDepartment:(单个查询的院系专业). <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            内部编码
	 * @return 院系专业类
	 */
	Department getDepartment(Integer nDeptNo);

	/**
	 * updateDepartment:(修改院系专业). <br/>
	 * 
	 * @author huanggl
	 * @param department
	 *            院系专业类
	 * @return true修改成功 false修改失败
	 */
	boolean updateDepartment(Department department, String sUsername);

	/**
	 * delDeptInfo:软删除院系专业. <br/>
	 * 
	 * @author huanggl
	 * @param nDeptNo
	 * @return
	 */
	boolean delDeptInfo(Integer nDeptNo);

	/**
	 * listDepartments:分页获取院系专业列表. <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sDeptCode
	 *            专业代码
	 * @param sShortName
	 *            专业简称
	 * @param sFullName
	 *            专业全称
	 * @param sRegion
	 *            院系
	 * @param dbEnrolScore
	 *            录取分数线
	 * @return
	 */
	PageInfo<Department> listDepartments(Integer pageIndex, Integer pageSize, String sDeptCode, String sShortName,
			String sFullName, String sRegion, String dbEnrolScore);

	/**
	 * updateRevisionReview:(修改审核的审核通过或者审核不通过). <br/>
	 * 
	 * @author huanggl
	 * @param nDeptNoList
	 * @param sAuditNoList
	 * @param auditStatus
	 * @param sUsername
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	boolean updateRevisionReview(List<Integer> nDeptNoList, List<Integer> sAuditNoList, String auditStatus,
			String sUsername) throws IllegalArgumentException, IllegalAccessException, ParseException;
	
	/**  
	 * getDeptByCode:通过专业代码获取专业信息 <br/>  
	 * @author huanggl
	 * @param sDeptCode
	 * @return  
	 */
	Department getDeptByCode(String sDeptCode);
	
	EnrolmentInfo getEnrolmentInfo();
	
	/**  
	 * listDepartments:自定义分页，包含院系的信息. <br/>  
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @return  
	 */
	PageInfo<Department> listDepartments(Integer pageIndex, Integer pageSize);
	
}

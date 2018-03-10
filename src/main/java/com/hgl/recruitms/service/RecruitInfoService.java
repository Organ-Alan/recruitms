package com.hgl.recruitms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.RecruitInfo;

/**
 * ClassName: RecruitInfoService <br/>
 * Description：新生信息管理业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface RecruitInfoService {
	/**
	 * insertRecruitInfo:(新增新生信息). <br/>
	 * 
	 * @author huanggl
	 * @param RecruitInfo
	 *            新生信息类
	 * @return 返回true则成功，返回false则失败
	 */
	boolean insertRecruitInfo(RecruitInfo recruitInfo);

	/**
	 * getRecruitInfo:(单个查询的新生信息). <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            内部编码
	 * @return 新生信息类
	 */
	RecruitInfo getRecruitInfo(Integer nStudentId);

	RecruitInfo getRecruitInfo(String sStudentName);
	/**
	 * updateRecruitInfo:(修改新生信息). <br/>
	 * 
	 * @author huanggl
	 * @param recruitInfo
	 *            新生信息类
	 * @return true修改成功 false修改失败
	 */
	boolean updateRecruitInfo(RecruitInfo recruitInfo);

	/**
	 * accountRecruitStudent:统计新生数目，用于统计报到率. <br/>
	 * 
	 * @author huanggl
	 * @return
	 */
	int accountRecruitStudent();

	/**
	 * listRecruitInfo:分页获取新生信息 <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 *            首页
	 * @param pageSize
	 *            页码
	 * @param sStudentNo
	 * 
	 * @param sStudentName
	 *            姓名
	 * @param sAdmitedMajor
	 *            录取专业
	 * @param sGrade
	 *            年级
	 * @param sPayFlag
	 *            是否缴费
	 * @param sStatus
	 *            审核状态
	 * @return
	 */
	PageInfo<RecruitInfo> listRecruitInfos(Integer pageIndex, Integer pageSize, String sStudentNo, String sStudentName,
			String sAdmitedMajor, String sGrade, String sPayFlag, String sStatus);

	/**
	 * updateInfoStatus:审核通过或不通过.. <br/>
	 * 
	 * @author huanggl
	 * @param nStudentIds
	 *            批量审核接口
	 * @return
	 */
	boolean updateInfoStatus(Integer nStudentId, String action);

	/**
	 * exportRecruitInfo:根据查询条件，导出结果. <br/>
	 * 
	 * @author huanggl
	 * @param sStudentNo
	 *            学号
	 * @param sStudentName
	 *            姓名
	 * @param sAdmitedMajor
	 *            录取专业
	 * @param sGrade
	 *            年级
	 * @param sPayFlag
	 *            是否缴费
	 * @param sStatus
	 *            审核状态
	 * @param nStudentIdList
	 *            勾选列表
	 * @param exportType
	 *            导出内容
	 * @return
	 */
	List<List<String>> exportRecruitInfo(String sStudentNo, String sStudentName, String sAdmitedMajor, String sGrade,
			String sPayFlag, String sStatus, List<Integer> nStudentIdList, String exportType);
	
	/**  
	 * getPassedAuditStu:获取审核通过的学生数目 <br/>  
	 * @author huanggl
	 * @return  
	 */
	Integer getPassedAuditStu();
	
	/**  
	 * getRateRigister:获取新生报到率. <br/>  
	 * @author huanggl
	 * @return  
	 */
	String getRateRigister();
}

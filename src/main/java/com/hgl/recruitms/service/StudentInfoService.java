package com.hgl.recruitms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.StudentInfo;

/**
 * ClassName: StudentInfoService <br/>
 * Description：考生信息管理业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface StudentInfoService {
	/**
	 * insertStudentInfo:(新增考生生信息). <br/>
	 * 
	 * @author huanggl
	 * @param StudentInfo
	 *            新生信息类
	 * @return 返回true则成功，返回false则失败
	 */
	boolean insertStudentInfo(StudentInfo studentInfo);

	/**
	 * getStudentInfo:(单个查询的新生信息). <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            内部编码
	 * @return 新生信息类
	 */
	StudentInfo getStudentInfo(Integer nStudentId);

	/**
	 * updateStudentInfo:(修改新生信息). <br/>
	 * 
	 * @author huanggl
	 * @param StudentInfo
	 *            新生信息类
	 * @return true修改成功 false修改失败
	 */
	boolean updateStudentInfo(StudentInfo studentInfo);

	/**
	 * 
	 * deleteStudentInfo:考生信息可以删除，但是只能进行软删除，一遍后续管理人员追踪数据. <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            学生信息ID集合
	 * @return 是否删除成功
	 * @throws Exception
	 */
	boolean deleteStudentInfo(Integer[] nStudentIds) throws IndexOutOfBoundsException;

	/**
	 * accountStudent:统计考生数目. <br/>
	 * 
	 * @author huanggl
	 * @return
	 */
	int accountStudent();

	/**
	 * listStudentInfo:分页获取考生信息 <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sCandidateNum
	 *            准考证
	 * @param sStudentName
	 *            姓名
	 * @param sNativePlace
	 *            籍贯
	 * @param sEnrolMajor
	 *            报考专业
	 * @param sDataFlag
	 *            数据状态
	 * @return
	 */
	PageInfo<StudentInfo> listStudentInfos(Integer pageIndex, Integer pageSize, String sCandidateNum,
			String sStudentName, String sNativePlace, String sEnrolMajor, String sDataFlag);

	/**  
	 * exportStudentInfo:导出考生信息. <br/>  
	 * @author huanggl
	 * @param sCandidateNum 准考证号
	 * @param sStudentName 姓名
	 * @param sNativePlace 籍贯
	 * @param sEnrolMajor 报考专业
	 * @param sDataFlag 数据状态
	 * @param nStudentIdList 勾选列表
	 * @param exportType 导出类型
	 * @return  
	 */
	List<List<String>> exportRecruitInfo(String sCandidateNum, String sStudentName, String sNativePlace,
			String sEnrolMajor, String sDataFlag, List<Integer> nStudentIdList, String exportType);

}

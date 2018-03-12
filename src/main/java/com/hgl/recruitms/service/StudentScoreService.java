package com.hgl.recruitms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.Score;

/**
 * ClassName: ScoreService <br/>
 * Description：学生成绩信息管理业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface StudentScoreService {
	/**
	 * insertScore:(新增新生成绩信息). <br/>
	 * 
	 * @author huanggl
	 * @param Score
	 *            新生成绩信息类
	 * @return 返回true则成功，返回false则失败
	 */
	boolean insertScore(Score studentScore);

	/**
	 * getScore:(单个查询的新生成绩信息). <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            内部编码
	 * @return 新生成绩信息类
	 */
	Score getScore(Integer nStudentId);
	
	Score getScoreByName(String sStudentName);
	
	/**
	 * getScore:(删除新生成绩信息). <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 *            内部编码
	 * @return 新生成绩信息类
	 */
	boolean delScore(Integer nStudentId);

	/**
	 * updateScore:(修改新生成绩信息). <br/>
	 * 
	 * @author huanggl
	 * @param Score
	 *            新生成绩信息类
	 * @return true修改成功 false修改失败
	 */
	boolean updateScore(Score studentScore);

	/**
	 * listScores:分页获取成绩信息. <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sStudentNo
	 *            学号
	 * @param sStudentName
	 *            姓名
	 * @param sSubjectType
	 *            科目类型
	 * @param sTotalScore
	 *            总分
	 * @return
	 */
	PageInfo<Score> listScores(Integer pageIndex, Integer pageSize, String sStudentNo, String sStudentName,
			String sSubjectType);

	/**
	 * exportScoreInfo:导出成绩信息. <br/>
	 * 
	 * @author huanggl
	 * @param sStudentNo
	 *            学号
	 * @param sStudentName
	 *            姓名
	 * @param sSubjectType
	 *            科目类型
	 * @param sTotalScore
	 *            总分
	 * @param nStudentIdList
	 *            勾选数据
	 * @param exportType
	 *            导出内容
	 * @return
	 */
	List<List<String>> exportScoreInfo(String sStudentNo, String sStudentName, String sSubjectType, String sTotalScore,
			List<Integer> nStudentIdList, String exportType);

}

package com.hgl.recruitms.service;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.QAInfo;

/**
 * ClassName: QAInfoService <br/>
 * Description：答疑信息管理业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface QAInfoService {
	/**
	 * insertQAInfo:(新增答疑信息). <br/>
	 * 
	 * @author huanggl
	 * @param QAInfo
	 *            答疑信息类
	 * @return 返回true则成功，返回false则失败
	 */
	boolean insertQAInfo(QAInfo qaInfo);

	/**
	 * getQAInfo:(单个查询的答疑信息). <br/>
	 * 
	 * @author huanggl
	 * @param nQaId
	 *            内部编码
	 * @return 答疑信息类
	 */
	QAInfo getQAInfo(Integer nQaId);

	/**
	 * updateQAInfo:(修改答疑信息). <br/>
	 * 
	 * @author huanggl
	 * @param qaInfo
	 *            答疑信息类
	 * @return true修改成功 false修改失败
	 */
	boolean updateQAInfo(QAInfo qaInfo);

	/**
	 * accountRecruitStudent:统计答疑数目，用于统计报到率. <br/>
	 * 
	 * @author huanggl
	 * @return
	 */
	int accountQAInfo();

	/**
	 * delDeptInfo:软删除答疑信息. <br/>
	 * 
	 * @author huanggl
	 * @param nQaId
	 * @return
	 */
	boolean delQAInfo(Integer nQaId);
	
	/**
	 * listQAInfo:分页获取答疑信息 <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sQuestion
	 *            问题
	 * @return
	 */
	PageInfo<QAInfo> listQAInfos(Integer pageIndex, Integer pageSize, String sQuestion);
}

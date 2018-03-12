package com.hgl.recruitms.service.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.test.BaseSpringContextTest;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.service.RecruitInfoService;


/**  
 * ClassName: DictionaryServiceTest <br/>  
 * date: 2017年11月14日 上午11:05:59 <br/>  
 * Description：测试字典查询接口相关操作
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class RecruitInfoServiceTest extends BaseSpringContextTest {
	static Logger logger = LoggerFactory.getLogger(RecruitInfoServiceTest.class);
	@Autowired
	private RecruitInfoService recruitInfoService;

	/**
	 * list:分页查询信息列表. <br/>
	 * 
	 * @author huanggl
	 */
	@Test
	public void list() {
		Integer pageIndex = 1;
		Integer pageSize = 10;
		String sStudentNo = "";
		String sStudentName	 = "";
		String sAdmitedMajor = "";
		String sGrade = "2014";
		String sPayFlag = "";
		String sStatus = "1";	
		PageInfo<RecruitInfo> dictionarys = recruitInfoService.listRecruitInfos(pageIndex, pageSize, sStudentNo, sStudentName, sAdmitedMajor, sGrade, sPayFlag, sStatus);
		System.out.println(JsonUtil.serialize(dictionarys));
	}
	@Test
	public void update() {
		RecruitInfo recruitInfo = new RecruitInfo();
		recruitInfo.setnStudentId(11001);
		recruitInfo.setsPayFlag("1");
		boolean result = recruitInfoService.updateRecruitInfo(recruitInfo);
		System.out.println(result);
	}
}

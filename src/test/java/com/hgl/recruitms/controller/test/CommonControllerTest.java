package com.hgl.recruitms.controller.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hgl.recruitms.common.test.BaseSpringMvcTest;

/**
 * ClassName: CommonControllerTest <br/>
 * date: 2017年11月14日 上午11:05:59 <br/>
 * Description：测试字典查询接口相关操作
 * 
 * @author huanggl
 * @version Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.
 */
public class CommonControllerTest extends BaseSpringMvcTest {
	static Logger logger = LoggerFactory.getLogger(CommonControllerTest.class);

	@Test
	public void validate() throws Exception {
		perform(MockMvcRequestBuilders.post("/recruitms/v1/common/login")
				.param("sUsername", "admin")
				.param("sPassword", "111111"));
	}
	@Test
	public void listAuditPage() throws Exception {
		perform(
                MockMvcRequestBuilders.get("/recruitms/v1/common/listAuditPage")
                .param("pageIndex", "1")
                .param("pageSize", "10")
                .param("sDeptCode", "")
                .param("sFullName", "")
                .param("sStatus", ""));
		
	}
	@Test
	public void listAttach() throws Exception {
		perform(
                MockMvcRequestBuilders.get("/admin/common/attach/attachListPage")
                .param("pageIndex", "1")
                .param("pageSize", "10")
                .param("sAttachName", "14,15")
                .param("sFileType", "32")
                .param("dCreateTime", ""));
		
	}
	@Test
	public void listallAttach() throws Exception {
		perform(
                MockMvcRequestBuilders.get("/admin/allAttachList")
                .param("pageIndex", "3")
                .param("pageSize", "6")
                .param("sAttachName", "")
                .param("sFileType", "")
                .param("sAttachType", ""));
		
	}
	@Test
	public void audit() throws Exception {
		perform(
                MockMvcRequestBuilders.post("/admin/auditStatus")
                .param("sAuditNoList", "14,15")
                .param("nDeptNoList", "32")
                .param("auditStatus", "2")
                .param("sUsername", "admin"));
		
	}
}

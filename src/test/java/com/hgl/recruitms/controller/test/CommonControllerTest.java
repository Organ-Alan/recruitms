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
		perform(MockMvcRequestBuilders.post("/recruitms/v1/common/Account")
				.param("sUsername", "test")
				.param("sPassword", "test"));
	}
}

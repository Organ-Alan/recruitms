package com.hgl.recruitms.example.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hgl.recruitms.common.test.BaseSpringMvcTest;
import com.hgl.recruitms.common.util.JsonUtil;

public class ControllerTest extends BaseSpringMvcTest{
	
	@Test
	public void test() throws Exception {
		perform(MockMvcRequestBuilders
				.get("/recruitms/v1/Example/test")
				.contentType(MediaType.APPLICATION_JSON).content(JsonUtil.serialize("")));
	}
}

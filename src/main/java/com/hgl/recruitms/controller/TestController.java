package com.hgl.recruitms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.service.TestService;

@RestController
@RequestMapping("/recruitms/{version}/Example")
public class TestController {
	
	@Autowired
	private CommonResponseBuilder builder;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test",method={RequestMethod.GET})
	public ResponseObject<?> select(){
		return builder.success(testService.select());
	}
	// get host:port/pms/v1/Example/selectA
	
}

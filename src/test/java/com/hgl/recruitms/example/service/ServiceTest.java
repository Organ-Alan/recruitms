package com.hgl.recruitms.example.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hgl.recruitms.common.test.BaseSpringContextTest;
import com.hgl.recruitms.service.impl.TestServiceImpl;

public class ServiceTest extends BaseSpringContextTest{
	
	@Autowired
	private TestServiceImpl testService;
	
	@Test
	public void select(){
		System.out.println(testService.select());
	}
}

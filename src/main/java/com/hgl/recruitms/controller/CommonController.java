package com.hgl.recruitms.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hgl.recruitms.common.sys.controller.response.ErrorEnum;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.service.AccountService;

/**
 * ClassName: CommonController <br/>
 * Description：公共模块请求分派 1、登录验证：通过用户类型判断用户的性质，系招生办和院招生办登录到管理员界面。学生则有权限限制，仅有查看等功能
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/recruitms/{version}/common")
public class CommonController {

	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private AccountService accountService;

	/**
	 * validate:登录认证
	 */
	@RequestMapping(value = "/Account", method = { RequestMethod.POST })
	public ResponseObject<?> validate(@RequestParam String sUsername, @RequestParam String sPassword) {
		// 校验返回结果
		if (Strings.isEmpty(sUsername) || Strings.isEmpty(sPassword)) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "账号密码错误！");
		}
		Account account = accountService.checkLogin(sUsername, sPassword);
		return builder.success(account);
	}
}

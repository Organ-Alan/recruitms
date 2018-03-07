package com.hgl.recruitms.common.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.jwt.Jwt;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.model.AuditInfo;
import com.hgl.recruitms.service.CommonService;

/**
 * ClassName: CommonController <br/>
 * Description：公共模块请求分派 1、登录认证：通过用户类型判断用户的性质，系招生办和院招生办登录到管理员界面。学生则有权限限制，仅有查看等功能
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/{version}/common")
public class CommonController {
	static Logger logger = LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private CommonService<?> commonService;

	/**
	 * validate:登录认证
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ResponseObject<?> validate(@RequestParam String sUsername, @RequestParam String sPassword) {
		// 校验返回结果
		if (Strings.isEmpty(sUsername) || Strings.isEmpty(sPassword)) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(),"登录失败！");
		}
		logger.debug(sUsername + "===" + sPassword);
		// 用户名密码校验成功后，生成token返回客户端
		if (commonService.checkLogin(sUsername, sPassword)) {
			// 生成token
			Map<String, Object> payload = new HashMap<String, Object>();
			Date date = new Date();
			payload.put("UserID", sUsername);// 用户ID
			payload.put("CreateTime", date.getTime());// 生成时间
			payload.put("Exp", date.getTime() + 1000 * 60 * 60);// 过期时间1小时
			String token = Jwt.createToken(payload);
			payload.put("token", token);
			return builder.success(payload);

		}
		return builder.error(ErrorEnum.IllegalArgument.getErrorCode(),"账号密码错误！");
	}

	/**  
	 * listAuditPage:分页获取修改审核信息. <br/>  
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sDeptCode 院系专业代码
	 * @param sFullName	院系专业名称
	 * @param sStatus	审核状态
	 * @return  
	 */
	@RequestMapping(value = "/listAuditPage", method = { RequestMethod.GET })
	public ResponseObject<?> listAuditPage(@RequestParam int pageIndex, @RequestParam int pageSize, String sDeptCode,
			String sFullName, String sStatus) {
		PageInfo<AuditInfo> list = commonService.listAuditPage(pageIndex, pageSize, sDeptCode.trim(), sFullName.trim(),
				sStatus);
		return builder.success(list);
	}
}

package com.hgl.recruitms.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.jwt.Jwt;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.enums.UserTypeEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.Attach;
import com.hgl.recruitms.model.AuditInfo;
import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.service.AccountInfoService;
import com.hgl.recruitms.service.AttachService;
import com.hgl.recruitms.service.CommonService;
import com.hgl.recruitms.service.RecruitInfoService;

/**
 * ClassName: CommonController <br/>
 * Description：公共模块请求分派 1、登录认证：通过用户类型判断用户的性质，系招生办和院招生办登录到管理员界面。学生则有权限限制，仅有查看等功能
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/admin")
public class CommonController {
	static Logger logger = LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	private CommonResponseBuilder builder;
	
	@Autowired
	private AttachService attachService;

	@Autowired
	private CommonService<?> commonService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private RecruitInfoService recruitInfoService;

	/**
	 * validate:登录认证
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ResponseObject<?> validate(@RequestParam String sUsername, @RequestParam String sPassword,@RequestParam String sUserType) {
		// 校验返回结果
		if (Strings.isEmpty(sUsername) || Strings.isEmpty(sPassword)) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(),"登录失败！");
		}
		if (Strings.isEmpty(sUserType)) {
			sUserType = "1";
		}
		logger.debug(sUsername + "===" + sPassword +"==="+sUserType);
		String checkResult= commonService.checkLogin(sUsername, sPassword,sUserType);
		System.out.println(checkResult);
		// 用户名密码校验成功后，生成token返回客户端
		if (checkResult.equals(UserTypeEnum.STUDENT.getCode())) {
			// 生成token
			Map<String, Object> payload = new HashMap<String, Object>();
			Date date = new Date();
			payload.put("UserID", sUsername);// 用户ID
			payload.put("checkRerult", UserTypeEnum.STUDENT.getCode());
			payload.put("CreateTime", date.getTime());// 生成时间
			payload.put("Exp", date.getTime() + 1000 * 60 * 60);// 过期时间1小时
			String token = Jwt.createToken(payload);
			payload.put("token", token);
			return builder.success(payload);

		}
		if (checkResult.equals(UserTypeEnum.D_ADMIN.getCode())||checkResult.equals(UserTypeEnum.F_ADMIN.getCode())) {
			// 生成token
			Map<String, Object> payload = new HashMap<String, Object>();
			Date date = new Date();
			payload.put("UserID", sUsername);// 用户ID
			payload.put("checkRerult", UserTypeEnum.D_ADMIN.getCode());
			payload.put("CreateTime", date.getTime());// 生成时间
			payload.put("Exp", date.getTime() + 1000 * 60 * 60);// 过期时间1小时
			String token = Jwt.createToken(payload);
			payload.put("token", token);
			return builder.success(payload);

		}
		return builder.error(ErrorEnum.IllegalArgument.getErrorCode(),"账号密码错误！");
	}
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public ResponseObject<?> logout(HttpServletResponse response,HttpServletRequest request) {
		request.getSession().setAttribute("sUsername", null);
		return builder.success();
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
	public ModelAndView listAuditPage(HttpServletResponse response,HttpServletRequest request,@RequestParam int pageIndex, @RequestParam int pageSize, String sDeptCode,
			String sFullName, String sStatus) {
		PageInfo<AuditInfo> list = commonService.listAuditPage(pageIndex, pageSize, sDeptCode.trim(), sFullName.trim(),
				sStatus);
		request.getSession().setAttribute("listAuditPage", list);
		return new ModelAndView("auditList.jsp");
	}
	
	/**  
	 * sendNoticeFile:上传文件. <br/>  
	 * @author huanggl
	 * @param response
	 * @param request
	 * @param nStudentId
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping(value = "/sendNoticeFile", method = { RequestMethod.POST })
	public ModelAndView sendNoticeFile(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer nStudentId) throws IOException {
		
		//获取文件的路径
		File file = new File("F:\\GraduattionSources\\GraduationProject\\document\\dockerUpload\\temp\\录取通知书.jpg");
		InputStream inputStream = new FileInputStream(file);
		RecruitInfo recruitInfo = recruitInfoService.getRecruitInfo(nStudentId);
		String fileName =recruitInfo.getsStudentName()+"_录取通知书";
		String sAttachType = "通知书";
		Attach attach = attachService.uploadAttach(inputStream,sAttachType, fileName, nStudentId,"admin",
				"院招生办");
		if (attach == null) {
			return new ModelAndView("errorPage.jsp");
		}
		return new ModelAndView("enrollmentNotice.jsp");
	}
	
	/**  
	 * listAcnInfos:分页查询. <br/>  
	 * @author huanggl
	 * @param response
	 * @param request
	 * @param pageIndex
	 * @param pageSize
	 * @param sUsername
	 * @param sUserType
	 * @return  
	 */
	@RequestMapping(value = "/listAcnInfos", method = { RequestMethod.GET })
	public ModelAndView listAcnInfos(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sUsername, String sUserType) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		request.getSession().setAttribute("listAcnInfos", null);
		PageInfo<Account> pageInfo = accountInfoService.listAccountyPage(pageIndex, pageSize, sUsername, sUserType);
		request.getSession().setAttribute("listAcnInfos", pageInfo);
		logger.debug(JsonUtil.serialize(pageInfo));
		return new ModelAndView("accountInfoList.jsp");
	}

	/**  
	 * getAccount:获取信息. <br/>  
	 * @author huanggl
	 * @param nAcnNo
	 * @return  
	 */
	@RequestMapping(value = "/account/{nAcnNo}", method = { RequestMethod.GET })
	public ResponseObject<?> getAccount(@PathVariable Integer nAcnNo) {
		if (nAcnNo == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "账号信息内部编码" + nAcnNo + "错误！");
		}
		return builder.success(accountInfoService.getAccount(nAcnNo));
	}

	/**
	 * insertAccount:新增账号信息. <br/>
	 * 
	 * @author huanggl
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/account", method = { RequestMethod.POST })
	public ResponseObject<?> insertAccount(@RequestBody Account account) {
		logger.info("需要新增账号信息：{}", account);
		if (account == null) {// 新增信息为空
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "请求对象出错（" + account + "）");
		}
		boolean isSuccess = accountInfoService.insertAccount(account);
		if (isSuccess) {
			return builder.success(account);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法添加账号信息（" + account + "）,请重新尝试！");
		}
	}

	/**
	 * updateAccount:修改账号信息 <br/>
	 * 
	 * @author huanggl
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "updateAccount", method = { RequestMethod.POST })
	public ResponseObject<?> updateAccount(@RequestBody Account account) {
		logger.debug("更新内容为：{}" + account.toString());
		boolean flag = accountInfoService.updateAccountInfo(account);
		if (!flag) {
			return builder.error(-1, "更改出错！");
		}
		return builder.success(account);
	}
	
	/**
	 * delAccount:删除账号信息 <br/>
	 * 
	 * @author huanggl
	 * @param nAcnNo
	 * @return
	 */
	@RequestMapping(value = "delAccount", method = { RequestMethod.POST })
	public ResponseObject<?> delAccount(@RequestParam Integer nAcnNo) {
		logger.debug("删除内容为：{}" + nAcnNo);
		boolean flag = accountInfoService.delAccount(nAcnNo);
		if (!flag) {
			return builder.error(-1, "删除出错！");
		}
		return builder.success();
	}
	
}

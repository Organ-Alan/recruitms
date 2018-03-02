package com.hgl.recruitms.common.sys.controller.response;


/**  
 * ClassName: ErrorEnum <br/>  
 * date: 2017年12月6日 下午4:11:48 <br/>  
 * Description：自定义错误代码，返回规范化的错误代码到前端。
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum ErrorEnum {
	IllegalArgument(1000,"参数错误",IllegalArgumentException.class),
	NullPointer(1900,"空指针异常",NullPointerException.class),
	FILETYPEERROR(1901,"上传文件的格式不符合要求",ClassCastException.class),
	QUARTZJOBERROR(1902,"定时任务异常",RuntimeException.class),
	ROLENAMEEXIST(1903, "角色名已存在！", Exception.class),
	USERNAMEEXIST(1904, "账号已存在！", Exception.class);
	
	
	private Integer errorCode;
	private String errorMsg;
	private Class<? extends Exception> errorClass;
	
	ErrorEnum(Integer errorCode, String errorMsg, Class<? extends Exception> errorClass) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorClass = errorClass;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public Class<? extends Exception> getErrorClass() {
		return errorClass;
	}
	

}

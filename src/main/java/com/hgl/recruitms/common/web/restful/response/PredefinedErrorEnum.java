package com.hgl.recruitms.common.web.restful.response;


/**
 * 预先定义好的错误信息（通用定义）
 * @author ex-zhuwd
 *
 */
public enum PredefinedErrorEnum {
	
	IllegalArgument(100,"参数错误",IllegalArgumentException.class,null),
	IllegalState(101,"状态异常",IllegalStateException.class,null),
	NullPointer(102,"空引用异常",NullPointerException.class,null),
	NotSupportedMediaType(103,"不支持的媒体类型",null,"org.springframework.web.HttpMediaTypeNotSupportedException"),
	UNAUTHORIZED(104,"未认证",null,null),
	AUTHORIZEEXPIRED(105,"TOKEN无效",null,null);

	
	private Integer errorCode;
	private String errorMsg;
	private Class<? extends Exception> errorClass;
	private String className;
	
	PredefinedErrorEnum(Integer errorCode, String errorMsg, Class<? extends Exception> errorClass, String className) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorClass = errorClass;
		this.className = className;
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
	public String getErrorClassName() {
		return className;
	}
	
}

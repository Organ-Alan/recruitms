package com.hgl.recruitms.common.web.restful.response;


public class ErrorInfo {
	
	private Integer errorCode;
	private String errorMsg;
	
	public ErrorInfo() {
	}
	
	public ErrorInfo(Integer errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}



	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

}

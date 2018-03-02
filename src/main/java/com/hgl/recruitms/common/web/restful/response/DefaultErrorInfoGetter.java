package com.hgl.recruitms.common.web.restful.response;

public class DefaultErrorInfoGetter implements ErrorInfoGetter{
	public ErrorInfo getErrorInfo(Class<? extends Exception> classObj) {
		for(PredefinedErrorEnum errorEnum : PredefinedErrorEnum.values()){
			if(classObj != null && (classObj.equals(errorEnum.getErrorClass()) || classObj.getName().equals(errorEnum.getErrorClassName()))){
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorEnum.getErrorCode());
				errorInfo.setErrorMsg(errorEnum.getErrorMsg());
				return errorInfo;
			}
		}
		return null;
	}
	public ErrorInfo getErrorInfo(Integer code) {
		for(PredefinedErrorEnum errorEnum : PredefinedErrorEnum.values()){
			if(code != null && code.equals(errorEnum.getErrorCode())){
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorEnum.getErrorCode());
				errorInfo.setErrorMsg(errorEnum.getErrorMsg());
				return errorInfo;
			}
		}
		return null;
	}
}

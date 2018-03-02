package com.hgl.recruitms.common.web.restful.response;

public interface ErrorInfoGetter {
	
	ErrorInfo getErrorInfo(Class<? extends Exception> classObj);
	
	ErrorInfo getErrorInfo(Integer code);

}

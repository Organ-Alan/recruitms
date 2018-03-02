package com.hgl.recruitms.common.web.restful.response;

/**  
 * ClassName: AbstractResponseObjectBuilder <br/>  
 * date: 2017年12月6日 下午4:17:21 <br/>  
 * Description：根据restful规则，定义controller层返回前端的统一方法
 * 如error返回前端表示请求失败
 * sucess返回前段表示请求成功，并把请求后结果返回到前端
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public abstract class AbstractResponseObjectBuilder {
	
	protected abstract ErrorInfo getErrorInfo(Class<? extends Exception> classObj);
	
	protected abstract ErrorInfo getErrorInfo(Integer code);

	public ResponseObject<?> success(){
		@SuppressWarnings("rawtypes")
		ResponseObject<?> responseObject = new ResponseObject();
		
		responseObject.setCode(0);
		responseObject.setMsg("成功");
		
		return responseObject;
	}
	
	
	public <T> ResponseObject<T> success(T data){
		ResponseObject<T> responseObject = new ResponseObject<T>();
		
		responseObject.setCode(0);
		responseObject.setMsg("成功");
		responseObject.setData(data);
		
		return responseObject;
	}
	
	public ResponseObject<?> error(Exception exception){
		return error(exception.getClass(),exception.getMessage(),null);
	}
	
	public ResponseObject<?> error(Exception exception,String errorId){
		return error(exception.getClass(),exception.getMessage(),errorId);
	}
	
	
	public ResponseObject<?> error(Class<? extends Exception> exceptionClass){
		return error(exceptionClass,null,null);
	}
	
	
	public ResponseObject<?> error(Class<? extends Exception> exceptionClass,String detailMsg){
		return error(exceptionClass,detailMsg,null);
	}
	
	public ResponseObject<?> error(Class<? extends Exception> exceptionClass,String detailMsg,String errorId){
		ErrorInfo errorInfo = getErrorInfo(exceptionClass);
		if(errorInfo == null){
			errorInfo = getUnknownErrorInfo();
		}
		
		ResponseObject<?> responseObject = new ResponseObject<Object>();
		
		responseObject.setCode(errorInfo.getErrorCode());
		responseObject.setMsg(errorInfo.getErrorMsg());
		responseObject.setDetailMsg(detailMsg);
		responseObject.setErrorId(errorId);
		
		return responseObject;
	}
	
	
	public ResponseObject<Object> error(Integer code){
		return error(code,null,null);
	}
	
	public ResponseObject<Object> error(Integer code,String detailMsg){
		return error(code,detailMsg,null,null);
	}
	
	public ResponseObject<Object> error(Integer code,String detailMsg,Object data){
		return error(code,detailMsg,null,data);
	}
	
	public ResponseObject<Object> error(Integer code,String detailMsg,String errorId,Object data){
		ErrorInfo errorInfo = getErrorInfo(code);
		if(errorInfo == null){
			errorInfo = getUnknownErrorInfo();
		}
		
		
		ResponseObject<Object> responseObject = new ResponseObject<Object>();
		
		responseObject.setCode(errorInfo.getErrorCode());
		responseObject.setMsg(errorInfo.getErrorMsg());
		responseObject.setDetailMsg(detailMsg);
		responseObject.setErrorId(errorId);
		responseObject.setData(data);
		
		return responseObject;
	}
	
	protected ErrorInfo getUnknownErrorInfo() {
		ErrorInfo errorInfo = new ErrorInfo(-1, "未知错误");
		return errorInfo;
	}

}

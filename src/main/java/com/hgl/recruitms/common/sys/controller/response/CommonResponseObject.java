package com.hgl.recruitms.common.sys.controller.response;

import org.springframework.stereotype.Component;

import com.hgl.recruitms.common.web.restful.response.AbstractExtResponseObjectBuilder;
import com.hgl.recruitms.common.web.restful.response.ErrorInfo;
import com.hgl.recruitms.common.web.restful.response.ErrorInfoGetter;

/**  
 * ClassName: CommonResponseObject <br/>  
 * date: 2017年12月6日 下午4:10:57 <br/>  
 * Description：定义统一返回前端的对象，包括错误代码，使用枚举返回
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
@Component
public class CommonResponseObject extends AbstractExtResponseObjectBuilder {

	private ErrorInfoGetter errorInfoGetter;
	
	@Override
	public ErrorInfoGetter getErrorInfoGetter() {
		return errorInfoGetter;
	}
	public CommonResponseObject() {
		errorInfoGetter = new ErrorInfoGetter() {			
			public ErrorInfo getErrorInfo(Class<? extends Exception> classObj) {
				for(ErrorEnum errorEnum : ErrorEnum.values()){
					if(classObj != null && (classObj.equals(errorEnum.getErrorClass()))){
						ErrorInfo errorInfo = new ErrorInfo();
						errorInfo.setErrorCode(errorEnum.getErrorCode());
						errorInfo.setErrorMsg(errorEnum.getErrorMsg());
						return errorInfo;
					}
				}
				return null;
			}

			public ErrorInfo getErrorInfo(Integer code) {
				for(ErrorEnum errorEnum : ErrorEnum.values()){
					if(code != null && code.equals(errorEnum.getErrorCode())){
						ErrorInfo errorInfo = new ErrorInfo();
						errorInfo.setErrorCode(errorEnum.getErrorCode());
						errorInfo.setErrorMsg(errorEnum.getErrorMsg());
						return errorInfo;
					}
				}
				return null;
			}
		};
	}

}

package com.hgl.recruitms.common.web.restful.response;

public abstract class AbstractExtResponseObjectBuilder extends AbstractResponseObjectBuilder{
	
	private ErrorInfoGetter predefinedErrorInfoGetter;
	
	public AbstractExtResponseObjectBuilder(){
		this.predefinedErrorInfoGetter = new DefaultErrorInfoGetter();
	}
	
	public abstract ErrorInfoGetter getErrorInfoGetter();

	/**  
	 * 通过类对象获取错误信息
	 * @see com.hgl.recruitms.common.web.restful.response.AbstractResponseObjectBuilder#getErrorInfo(java.lang.Class)  
	 */
	@Override
	protected ErrorInfo getErrorInfo(Class<? extends Exception> classObj) {
		ErrorInfo info = predefinedErrorInfoGetter.getErrorInfo(classObj);
		if(info == null && getErrorInfoGetter() != null){
			info = getErrorInfoGetter().getErrorInfo(classObj);
		}
		return info;
	}
	
	/**  
	 * 通过错误代码获取错误信息 
	 * @see com.hgl.recruitms.common.web.restful.response.AbstractResponseObjectBuilder#getErrorInfo(java.lang.Integer)  
	 */
	@Override
	protected ErrorInfo getErrorInfo(Integer code) {
		ErrorInfo info = predefinedErrorInfoGetter.getErrorInfo(code);
		if(info == null && getErrorInfoGetter() != null){
			info = getErrorInfoGetter().getErrorInfo(code);
		}
		return info;
	}

}

package com.hgl.recruitms.common.web.restful.response;



/**  
 * ClassName: ResponseObject <br/>  
 * date: 2017年12月6日 下午4:20:45 <br/>  
 * Description：
 * <p>规范：</p>
 * <p>错误码使用 [-1,99999]的数值</p>
 * <p>-1为未知错误</p>
 * <p>0为成功</p>
 * <p>[1,1000]为通用定义的（即不与特定业务系统关联定义的）错误码区间。[1,1000]的通用错误码目前只开放[100,200]，其他为保留使用。</p>
 * 
 * <p>[1000,99999]为具体业务系统定义的错误码区间</p>
 * <p>每个业务系统占据的错误码个数为1000个。</p>
 * <p>假设有业务系统 system1,system2....systemN,则每个业务系统的错误码区间应分别为</p>
 * <p>[1000,1999],[2000,2999]...,[9000,9999]....[11000,11999],[12000,12999],[99000,99999]</p>
 *
 * @author huanggl  
 * @version @param <T>  
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class ResponseObject<T> {
	
	/** 错误码 */
	private Integer code;
	/** 正常的有效数据 */
	private T data;
	/** 辅助排错字段 */
	private String errorId;
	/** 错误信息（通常固定） */
	private String msg;
	/** 错误信息（通过程序运行时指定） */
	private String detailMsg;
	
	
	protected ResponseObject(){}
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getDetailMsg() {
		return detailMsg;
	}


	public void setDetailMsg(String detail) {
		this.detailMsg = detail;
	}
	

}

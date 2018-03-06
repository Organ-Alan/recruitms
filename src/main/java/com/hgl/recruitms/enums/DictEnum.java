package com.hgl.recruitms.enums;

/**  
 * ClassName: DictEnum <br/>   
 * Description：文件上传白名单
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum DictEnum {
	FILE_TYPE_WHITE_LIST("FILE_TYPE_WHITE_LIST");// "上传附件扩展名白名单"
	private String code;
	DictEnum(String code){
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}

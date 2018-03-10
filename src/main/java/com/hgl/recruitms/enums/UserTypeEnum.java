package com.hgl.recruitms.enums;

/**  
 * ClassName: AuditStatusEnum <br/>   
 * Description：审核状态枚举
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum UserTypeEnum {
	
	STUDENT("1", "学生"),
	D_ADMIN("2", "系招生办"),
	F_ADMIN("3", "院招生办");

	private String code;
	private String name;

	UserTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public static UserTypeEnum fromCode(String code) {
		for (UserTypeEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static UserTypeEnum fromName(String name) {
		for (UserTypeEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

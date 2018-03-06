package com.hgl.recruitms.enums;

/**  
 * ClassName: AuditStatusEnum <br/>   
 * Description：审核状态枚举
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum AuditStatusEnum {
	
	AUDIT("1", "待审核"),
	PASS("2", "审核通过"),
	REFUSE("3", "审核不通过");

	private String code;
	private String name;

	AuditStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public static AuditStatusEnum fromCode(String code) {
		for (AuditStatusEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static AuditStatusEnum fromName(String name) {
		for (AuditStatusEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

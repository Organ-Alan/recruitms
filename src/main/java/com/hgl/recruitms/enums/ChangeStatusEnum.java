package com.hgl.recruitms.enums;

/**  
 * ClassName: AuditStatusEnum <br/>   
 * Description：数据改变枚举
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum ChangeStatusEnum {
	
	INSERT("1", "录入待审"),
	UPDATE("2", "修改待审"),
	DELETE("3", "删除待审");

	private String code;
	private String name;

	ChangeStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public static ChangeStatusEnum fromCode(String code) {
		for (ChangeStatusEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static ChangeStatusEnum fromName(String name) {
		for (ChangeStatusEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

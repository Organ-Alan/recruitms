package com.hgl.recruitms.enums;



/**  
 * ClassName: DataStatusEnum <br/>  
 * date: 2017年11月14日 上午11:04:36 <br/>  
 * Description：字典数据状态枚举
 * @author huanggl  
 * DICTVALID:字典数据有效状态
 * DICTINVALID：字典数据删除状态
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum DataStatusEnum {
	//添加字典数据是否有效枚举
	VALID("1", "有效"),INVALID("2", "删除");
	private String code;
	private String name;

	DataStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static DataStatusEnum fromCode(String code) {
		for (DataStatusEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static DataStatusEnum fromName(String name) {
		for (DataStatusEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

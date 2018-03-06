package com.hgl.recruitms.enums;



/**  
 * ClassName: DataStatusEnum <br/>  
 * date: 2017年11月14日 上午11:04:36 <br/>  
 * Description：是否缴费枚举
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum PayFlagEnum {
	UNPAID("0", "未缴费"),PAIDED("1", "已缴费"),PART("2","已缴部分费用");
	private String code;
	private String name;

	PayFlagEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static PayFlagEnum fromCode(String code) {
		for (PayFlagEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static PayFlagEnum fromName(String name) {
		for (PayFlagEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

package com.hgl.recruitms.enums;

/**  
 * ClassName: DeptInfoColEnum <br/>   
 * Description：1、导出Excel表格,信息列表表头配置枚举
 * 				2、调用反射机制Field.get(Object)，根据对象内部属性获取数据
 * 				3、该枚举属性名与对象名必须一致，否则获取数据失败
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum DeptInfoColEnum {
	a("sDeptCode", "专业代码"),
	b("sShortName", "专业简称"),
	c("sFullName","专业全称"),
	d("sRegion","所属院系"),
	e("sTuition","学费"),
	f("nCountEnrol","计划招生人数"),
	g("nCountExtRnrol","补录人数"),
	h("sRemark","备注");
	private String code;
	private String name;

	DeptInfoColEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static DeptInfoColEnum fromCode(String code) {
		for (DeptInfoColEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static DeptInfoColEnum fromName(String name) {
		for (DeptInfoColEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

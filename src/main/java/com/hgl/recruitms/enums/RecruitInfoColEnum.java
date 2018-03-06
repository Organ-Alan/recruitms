package com.hgl.recruitms.enums;

/**  
 * ClassName: RecruitInfoColEnum <br/>   
 * Description：1、导出Excel表格,信息列表表头配置枚举
 * 				2、调用反射机制Field.get(Object)，根据对象内部属性获取数据
 * 				3、该枚举属性名与对象名必须一致，否则获取数据失败
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum RecruitInfoColEnum {
	a("sGrade", "所属年级"),
	b("sStudentNo", "学号"),
	c("sStudentName","学生姓名"),
	d("sAddress","通讯地址"),
	e("sContact","联系方式"),
	f("sAdmitedMajor","录取专业"),
	g("sPayFlag","是否缴费"),
	h("sStatus","审核状态");
	private String code;
	private String name;

	RecruitInfoColEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static RecruitInfoColEnum fromCode(String code) {
		for (RecruitInfoColEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static RecruitInfoColEnum fromName(String name) {
		for (RecruitInfoColEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

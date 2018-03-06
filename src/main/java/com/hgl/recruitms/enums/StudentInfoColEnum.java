package com.hgl.recruitms.enums;

/**  
 * ClassName: StudentInfoColEnum <br/>   
 * Description：1、导出Excel表格,信息列表表头配置枚举
 * 				2、调用反射机制Field.get(Object)，根据对象内部属性获取数据
 * 				3、该枚举属性名与对象名必须一致，否则获取数据失败
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum StudentInfoColEnum {
	a("sCandidateNum", "准考证号"),
	b("sStudentName", "姓名"),
	c("nAge","年龄"),
	d("sNativePlace","籍贯"),
	e("sAddress","通讯地址"),
	f("sContact","联系方式"),
	g("sEnrolMajor","报考专业"),
	h("sPolitiis","政治面貌");
	private String code;
	private String name;

	StudentInfoColEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static StudentInfoColEnum fromCode(String code) {
		for (StudentInfoColEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static StudentInfoColEnum fromName(String name) {
		for (StudentInfoColEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

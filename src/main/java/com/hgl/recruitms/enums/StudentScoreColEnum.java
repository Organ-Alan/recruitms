package com.hgl.recruitms.enums;

/**  
 * ClassName: StudentScoreColEnum <br/>   
 * Description：1、导出Excel表格,信息列表表头配置枚举
 * 				2、调用反射机制Field.get(Object)，根据对象内部属性获取数据
 * 				3、该枚举属性名与对象名必须一致，否则获取数据失败
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum StudentScoreColEnum {
	a("sStudentName", "学生姓名"),
	b("sStudentNo", "学号"),
	c("sSubjectType","科目类型"),
	d("dbScore","综合科成绩"),
	e("dbChinses","语文成绩"),
	f("dbEnglish","英语成绩"),
	g("dbMath","数学成绩"),
	h("sTotalScore","总分");

	private String code;
	private String name;

	StudentScoreColEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public static StudentScoreColEnum fromCode(String code) {
		for (StudentScoreColEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static StudentScoreColEnum fromName(String name) {
		for (StudentScoreColEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

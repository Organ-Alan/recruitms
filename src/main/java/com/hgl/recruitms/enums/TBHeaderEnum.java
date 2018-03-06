package com.hgl.recruitms.enums;



/**  
 * ClassName: DataStatusEnum <br/>  
 * date: 2017年11月14日 上午11:04:36 <br/>  
 * Description：表头配置枚举
 * 可以根据需要配置不同模块的列表表头
 * 灵活实现导出不同列表数据
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public enum TBHeaderEnum {
	//添加表头信息
	RECRUITINFO("sGrade,sStudentNo,sStudentName,sAddress,sContact,sAdmitedMajor,sPayFlag,sStatus", "RecruitInfo"),
	STUDENTINFO("sCandidateNum,sStudentName,nAge,sNativePlace,sAddress,sContact,sEnrolMajor", "StudentInfo"),
	SCOREINFO("sStudentNo,sStudentName,sSubjectType,dbScore,dbChinses,dbEnglish,dbMath,sTotalScore","ScoreInfo");
	private String code;
	private String name;

	TBHeaderEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static TBHeaderEnum fromCode(String code) {
		for (TBHeaderEnum e : values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static TBHeaderEnum fromName(String name) {
		for (TBHeaderEnum e : values()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
}

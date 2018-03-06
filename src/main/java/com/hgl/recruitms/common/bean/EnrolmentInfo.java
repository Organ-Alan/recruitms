package com.hgl.recruitms.common.bean;

import java.util.List;

import com.hgl.recruitms.model.Department;

/**
 * ClassName: EnrolmentIngo <br/>
 * Description：首页招生统计信息
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public class EnrolmentInfo {
	private Integer nEnrolNumber; // 计划招生人数

	private Integer nAdmitedNumber; // 录取人数

	private Integer nRecruitNumber;// 审核通过新生

	private String sRateRigister; //报到率

	private Integer nTotalNumber; //学院总人数

	private String sRateEmployment; //就业率

	private Integer nInternationalClassNum; //国际班数

	private List<Department> Department;

	public Integer getnEnrolNumber() {
		return nEnrolNumber;
	}

	public void setnEnrolNumber(Integer nEnrolNumber) {
		this.nEnrolNumber = nEnrolNumber;
	}

	public Integer getnAdmitedNumber() {
		return nAdmitedNumber;
	}

	public void setnAdmitedNumber(Integer nAdmitedNumber) {
		this.nAdmitedNumber = nAdmitedNumber;
	}

	public Integer getnRecruitNumber() {
		return nRecruitNumber;
	}

	public void setnRecruitNumber(Integer nRecruitNumber) {
		this.nRecruitNumber = nRecruitNumber;
	}

	public Integer getnTotalNumber() {
		return nTotalNumber;
	}

	public void setnTotalNumber(Integer nTotalNumber) {
		this.nTotalNumber = nTotalNumber;
	}

	public Integer getnInternationalClassNum() {
		return nInternationalClassNum;
	}

	public void setnInternationalClassNum(Integer nInternationalClassNum) {
		this.nInternationalClassNum = nInternationalClassNum;
	}

	public List<Department> getDepartment() {
		return Department;
	}

	public void setDepartment(List<Department> department) {
		Department = department;
	}

	public String getsRateRigister() {
		return sRateRigister;
	}

	public void setsRateRigister(String sRateRigister) {
		this.sRateRigister = sRateRigister;
	}

	public String getsRateEmployment() {
		return sRateEmployment;
	}

	public void setsRateEmployment(String sRateEmployment) {
		this.sRateEmployment = sRateEmployment;
	}
}

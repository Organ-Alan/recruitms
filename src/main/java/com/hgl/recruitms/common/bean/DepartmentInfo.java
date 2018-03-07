package com.hgl.recruitms.common.bean;

/**
 * ClassName: EnrolmentIngo <br/>
 * Description：首页招生统计信息
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public class DepartmentInfo {
	private String nSortNum; // 序号
	
	private String sDepartmenName; // 院系

	private Integer nCountEnrol;; // 招生人数

	private String completeFlag; //是否已完成招生
	
	public String getsDepartmenName() {
		return sDepartmenName;
	}

	public void setsDepartmenName(String sDepartmenName) {
		this.sDepartmenName = sDepartmenName;
	}

	public Integer getnCountEnrol() {
		return nCountEnrol;
	}

	public void setnCountEnrol(Integer nCountEnrol) {
		this.nCountEnrol = nCountEnrol;
	}

	public String getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(String completeFlag) {
		this.completeFlag = completeFlag;
	}

	public String getnSortNum() {
		return nSortNum;
	}

	public void setnSortNum(String nSortNum) {
		this.nSortNum = nSortNum;
	}
}

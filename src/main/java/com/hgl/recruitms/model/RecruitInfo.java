package com.hgl.recruitms.model;

import java.util.Date;

public class RecruitInfo {
    private Integer nStudentId;

    private String sCandidateNum;

    private String sStudentName;

    private String sStudentNo;

    private Integer nAge;

    private String cSex;

    private String sAddress;

    private String sContact;

    private String sEmail;

    private String sOtherCtact;

    private String sEnrolMajor;

    private String sAdmitedMajor;

    private Integer sAdmitedNo;

    private String sRegisterFlag;

    private String sGrade;

    private String sPolitiis;

    private String sPayFlag;

    private String sOperator;

    private String sOperatorNo;

    private Date dOperateTime;

    private String sStatus;

    public Integer getnStudentId() {
        return nStudentId;
    }

    public RecruitInfo withnStudentId(Integer nStudentId) {
        this.setnStudentId(nStudentId);
        return this;
    }

    public void setnStudentId(Integer nStudentId) {
        this.nStudentId = nStudentId;
    }

    public String getsCandidateNum() {
        return sCandidateNum;
    }

    public RecruitInfo withsCandidateNum(String sCandidateNum) {
        this.setsCandidateNum(sCandidateNum);
        return this;
    }

    public void setsCandidateNum(String sCandidateNum) {
        this.sCandidateNum = sCandidateNum == null ? null : sCandidateNum.trim();
    }

    public String getsStudentName() {
        return sStudentName;
    }

    public RecruitInfo withsStudentName(String sStudentName) {
        this.setsStudentName(sStudentName);
        return this;
    }

    public void setsStudentName(String sStudentName) {
        this.sStudentName = sStudentName == null ? null : sStudentName.trim();
    }

    public String getsStudentNo() {
        return sStudentNo;
    }

    public RecruitInfo withsStudentNo(String sStudentNo) {
        this.setsStudentNo(sStudentNo);
        return this;
    }

    public void setsStudentNo(String sStudentNo) {
        this.sStudentNo = sStudentNo == null ? null : sStudentNo.trim();
    }

    public Integer getnAge() {
        return nAge;
    }

    public RecruitInfo withnAge(Integer nAge) {
        this.setnAge(nAge);
        return this;
    }

    public void setnAge(Integer nAge) {
        this.nAge = nAge;
    }

    public String getcSex() {
        return cSex;
    }

    public RecruitInfo withcSex(String cSex) {
        this.setcSex(cSex);
        return this;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public RecruitInfo withsAddress(String sAddress) {
        this.setsAddress(sAddress);
        return this;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public String getsContact() {
        return sContact;
    }

    public RecruitInfo withsContact(String sContact) {
        this.setsContact(sContact);
        return this;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact == null ? null : sContact.trim();
    }

    public String getsEmail() {
        return sEmail;
    }

    public RecruitInfo withsEmail(String sEmail) {
        this.setsEmail(sEmail);
        return this;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail == null ? null : sEmail.trim();
    }

    public String getsOtherCtact() {
        return sOtherCtact;
    }

    public RecruitInfo withsOtherCtact(String sOtherCtact) {
        this.setsOtherCtact(sOtherCtact);
        return this;
    }

    public void setsOtherCtact(String sOtherCtact) {
        this.sOtherCtact = sOtherCtact == null ? null : sOtherCtact.trim();
    }

    public String getsEnrolMajor() {
        return sEnrolMajor;
    }

    public RecruitInfo withsEnrolMajor(String sEnrolMajor) {
        this.setsEnrolMajor(sEnrolMajor);
        return this;
    }

    public void setsEnrolMajor(String sEnrolMajor) {
        this.sEnrolMajor = sEnrolMajor == null ? null : sEnrolMajor.trim();
    }

    public String getsAdmitedMajor() {
        return sAdmitedMajor;
    }

    public RecruitInfo withsAdmitedMajor(String sAdmitedMajor) {
        this.setsAdmitedMajor(sAdmitedMajor);
        return this;
    }

    public void setsAdmitedMajor(String sAdmitedMajor) {
        this.sAdmitedMajor = sAdmitedMajor == null ? null : sAdmitedMajor.trim();
    }

    public Integer getsAdmitedNo() {
        return sAdmitedNo;
    }

    public RecruitInfo withsAdmitedNo(Integer sAdmitedNo) {
        this.setsAdmitedNo(sAdmitedNo);
        return this;
    }

    public void setsAdmitedNo(Integer sAdmitedNo) {
        this.sAdmitedNo = sAdmitedNo;
    }

    public String getsRegisterFlag() {
        return sRegisterFlag;
    }

    public RecruitInfo withsRegisterFlag(String sRegisterFlag) {
        this.setsRegisterFlag(sRegisterFlag);
        return this;
    }

    public void setsRegisterFlag(String sRegisterFlag) {
        this.sRegisterFlag = sRegisterFlag == null ? null : sRegisterFlag.trim();
    }

    public String getsGrade() {
        return sGrade;
    }

    public RecruitInfo withsGrade(String sGrade) {
        this.setsGrade(sGrade);
        return this;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade == null ? null : sGrade.trim();
    }

    public String getsPolitiis() {
        return sPolitiis;
    }

    public RecruitInfo withsPolitiis(String sPolitiis) {
        this.setsPolitiis(sPolitiis);
        return this;
    }

    public void setsPolitiis(String sPolitiis) {
        this.sPolitiis = sPolitiis == null ? null : sPolitiis.trim();
    }

    public String getsPayFlag() {
        return sPayFlag;
    }

    public RecruitInfo withsPayFlag(String sPayFlag) {
        this.setsPayFlag(sPayFlag);
        return this;
    }

    public void setsPayFlag(String sPayFlag) {
        this.sPayFlag = sPayFlag == null ? null : sPayFlag.trim();
    }

    public String getsOperator() {
        return sOperator;
    }

    public RecruitInfo withsOperator(String sOperator) {
        this.setsOperator(sOperator);
        return this;
    }

    public void setsOperator(String sOperator) {
        this.sOperator = sOperator == null ? null : sOperator.trim();
    }

    public String getsOperatorNo() {
        return sOperatorNo;
    }

    public RecruitInfo withsOperatorNo(String sOperatorNo) {
        this.setsOperatorNo(sOperatorNo);
        return this;
    }

    public void setsOperatorNo(String sOperatorNo) {
        this.sOperatorNo = sOperatorNo == null ? null : sOperatorNo.trim();
    }

    public Date getdOperateTime() {
        return dOperateTime;
    }

    public RecruitInfo withdOperateTime(Date dOperateTime) {
        this.setdOperateTime(dOperateTime);
        return this;
    }

    public void setdOperateTime(Date dOperateTime) {
        this.dOperateTime = dOperateTime;
    }

    public String getsStatus() {
        return sStatus;
    }

    public RecruitInfo withsStatus(String sStatus) {
        this.setsStatus(sStatus);
        return this;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus == null ? null : sStatus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nStudentId=").append(nStudentId);
        sb.append(", sCandidateNum=").append(sCandidateNum);
        sb.append(", sStudentName=").append(sStudentName);
        sb.append(", sStudentNo=").append(sStudentNo);
        sb.append(", nAge=").append(nAge);
        sb.append(", cSex=").append(cSex);
        sb.append(", sAddress=").append(sAddress);
        sb.append(", sContact=").append(sContact);
        sb.append(", sEmail=").append(sEmail);
        sb.append(", sOtherCtact=").append(sOtherCtact);
        sb.append(", sEnrolMajor=").append(sEnrolMajor);
        sb.append(", sAdmitedMajor=").append(sAdmitedMajor);
        sb.append(", sAdmitedNo=").append(sAdmitedNo);
        sb.append(", sRegisterFlag=").append(sRegisterFlag);
        sb.append(", sGrade=").append(sGrade);
        sb.append(", sPolitiis=").append(sPolitiis);
        sb.append(", sPayFlag=").append(sPayFlag);
        sb.append(", sOperator=").append(sOperator);
        sb.append(", sOperatorNo=").append(sOperatorNo);
        sb.append(", dOperateTime=").append(dOperateTime);
        sb.append(", sStatus=").append(sStatus);
        sb.append("]");
        return sb.toString();
    }
}
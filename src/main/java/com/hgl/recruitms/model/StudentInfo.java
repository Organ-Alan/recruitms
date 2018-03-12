package com.hgl.recruitms.model;

public class StudentInfo {
    private Integer nStudentId;

    private String sCandidateNum;

    private String sStudentName;

    private Integer nAge;

    private String cSex;

    private String sNativePlace;

    private String sAddress;

    private String sContact;

    private String sNoticeFlag;

    private String sEmail;

    private String sOtherCtact;

    private String sEnrolMajor;

    private String sPolitiis;

    private String sDataFlag;

    public Integer getnStudentId() {
        return nStudentId;
    }

    public StudentInfo withnStudentId(Integer nStudentId) {
        this.setnStudentId(nStudentId);
        return this;
    }

    public void setnStudentId(Integer nStudentId) {
        this.nStudentId = nStudentId;
    }

    public String getsCandidateNum() {
        return sCandidateNum;
    }

    public StudentInfo withsCandidateNum(String sCandidateNum) {
        this.setsCandidateNum(sCandidateNum);
        return this;
    }

    public void setsCandidateNum(String sCandidateNum) {
        this.sCandidateNum = sCandidateNum == null ? null : sCandidateNum.trim();
    }

    public String getsStudentName() {
        return sStudentName;
    }

    public StudentInfo withsStudentName(String sStudentName) {
        this.setsStudentName(sStudentName);
        return this;
    }

    public void setsStudentName(String sStudentName) {
        this.sStudentName = sStudentName == null ? null : sStudentName.trim();
    }

    public Integer getnAge() {
        return nAge;
    }

    public StudentInfo withnAge(Integer nAge) {
        this.setnAge(nAge);
        return this;
    }

    public void setnAge(Integer nAge) {
        this.nAge = nAge;
    }

    public String getcSex() {
        return cSex;
    }

    public StudentInfo withcSex(String cSex) {
        this.setcSex(cSex);
        return this;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getsNativePlace() {
        return sNativePlace;
    }

    public StudentInfo withsNativePlace(String sNativePlace) {
        this.setsNativePlace(sNativePlace);
        return this;
    }

    public void setsNativePlace(String sNativePlace) {
        this.sNativePlace = sNativePlace == null ? null : sNativePlace.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public StudentInfo withsAddress(String sAddress) {
        this.setsAddress(sAddress);
        return this;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public String getsContact() {
        return sContact;
    }

    public StudentInfo withsContact(String sContact) {
        this.setsContact(sContact);
        return this;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact == null ? null : sContact.trim();
    }

    public String getsNoticeFlag() {
        return sNoticeFlag;
    }

    public StudentInfo withsNoticeFlag(String sNoticeFlag) {
        this.setsNoticeFlag(sNoticeFlag);
        return this;
    }

    public void setsNoticeFlag(String sNoticeFlag) {
        this.sNoticeFlag = sNoticeFlag == null ? null : sNoticeFlag.trim();
    }

    public String getsEmail() {
        return sEmail;
    }

    public StudentInfo withsEmail(String sEmail) {
        this.setsEmail(sEmail);
        return this;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail == null ? null : sEmail.trim();
    }

    public String getsOtherCtact() {
        return sOtherCtact;
    }

    public StudentInfo withsOtherCtact(String sOtherCtact) {
        this.setsOtherCtact(sOtherCtact);
        return this;
    }

    public void setsOtherCtact(String sOtherCtact) {
        this.sOtherCtact = sOtherCtact == null ? null : sOtherCtact.trim();
    }

    public String getsEnrolMajor() {
        return sEnrolMajor;
    }

    public StudentInfo withsEnrolMajor(String sEnrolMajor) {
        this.setsEnrolMajor(sEnrolMajor);
        return this;
    }

    public void setsEnrolMajor(String sEnrolMajor) {
        this.sEnrolMajor = sEnrolMajor == null ? null : sEnrolMajor.trim();
    }

    public String getsPolitiis() {
        return sPolitiis;
    }

    public StudentInfo withsPolitiis(String sPolitiis) {
        this.setsPolitiis(sPolitiis);
        return this;
    }

    public void setsPolitiis(String sPolitiis) {
        this.sPolitiis = sPolitiis == null ? null : sPolitiis.trim();
    }

    public String getsDataFlag() {
        return sDataFlag;
    }

    public StudentInfo withsDataFlag(String sDataFlag) {
        this.setsDataFlag(sDataFlag);
        return this;
    }

    public void setsDataFlag(String sDataFlag) {
        this.sDataFlag = sDataFlag == null ? null : sDataFlag.trim();
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
        sb.append(", nAge=").append(nAge);
        sb.append(", cSex=").append(cSex);
        sb.append(", sNativePlace=").append(sNativePlace);
        sb.append(", sAddress=").append(sAddress);
        sb.append(", sContact=").append(sContact);
        sb.append(", sNoticeFlag=").append(sNoticeFlag);
        sb.append(", sEmail=").append(sEmail);
        sb.append(", sOtherCtact=").append(sOtherCtact);
        sb.append(", sEnrolMajor=").append(sEnrolMajor);
        sb.append(", sPolitiis=").append(sPolitiis);
        sb.append(", sDataFlag=").append(sDataFlag);
        sb.append("]");
        return sb.toString();
    }
}
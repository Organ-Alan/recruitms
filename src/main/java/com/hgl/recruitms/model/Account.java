package com.hgl.recruitms.model;

import java.util.Date;

public class Account {
    private Integer nAcnNo;

    private String sUserNo;

    private String sUsername;

    private String sPassword;

    private String sUserType;

    private Date dRgTime;

    private String sExtValue1;

    public Integer getnAcnNo() {
        return nAcnNo;
    }

    public Account withnAcnNo(Integer nAcnNo) {
        this.setnAcnNo(nAcnNo);
        return this;
    }

    public void setnAcnNo(Integer nAcnNo) {
        this.nAcnNo = nAcnNo;
    }

    public String getsUserNo() {
        return sUserNo;
    }

    public Account withsUserNo(String sUserNo) {
        this.setsUserNo(sUserNo);
        return this;
    }

    public void setsUserNo(String sUserNo) {
        this.sUserNo = sUserNo == null ? null : sUserNo.trim();
    }

    public String getsUsername() {
        return sUsername;
    }

    public Account withsUsername(String sUsername) {
        this.setsUsername(sUsername);
        return this;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername == null ? null : sUsername.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public Account withsPassword(String sPassword) {
        this.setsPassword(sPassword);
        return this;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

    public String getsUserType() {
        return sUserType;
    }

    public Account withsUserType(String sUserType) {
        this.setsUserType(sUserType);
        return this;
    }

    public void setsUserType(String sUserType) {
        this.sUserType = sUserType == null ? null : sUserType.trim();
    }

    public Date getdRgTime() {
        return dRgTime;
    }

    public Account withdRgTime(Date dRgTime) {
        this.setdRgTime(dRgTime);
        return this;
    }

    public void setdRgTime(Date dRgTime) {
        this.dRgTime = dRgTime;
    }

    public String getsExtValue1() {
        return sExtValue1;
    }

    public Account withsExtValue1(String sExtValue1) {
        this.setsExtValue1(sExtValue1);
        return this;
    }

    public void setsExtValue1(String sExtValue1) {
        this.sExtValue1 = sExtValue1 == null ? null : sExtValue1.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nAcnNo=").append(nAcnNo);
        sb.append(", sUserNo=").append(sUserNo);
        sb.append(", sUsername=").append(sUsername);
        sb.append(", sPassword=").append(sPassword);
        sb.append(", sUserType=").append(sUserType);
        sb.append(", dRgTime=").append(dRgTime);
        sb.append(", sExtValue1=").append(sExtValue1);
        sb.append("]");
        return sb.toString();
    }
}
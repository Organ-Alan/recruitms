package com.hgl.recruitms.model;

public class Account {
    private Integer nFundNo;

    private String sUserNo;

    private String sUsername;

    private String sPassword;

    private String sUserType;

    public Integer getnFundNo() {
        return nFundNo;
    }

    public Account withnFundNo(Integer nFundNo) {
        this.setnFundNo(nFundNo);
        return this;
    }

    public void setnFundNo(Integer nFundNo) {
        this.nFundNo = nFundNo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nFundNo=").append(nFundNo);
        sb.append(", sUserNo=").append(sUserNo);
        sb.append(", sUsername=").append(sUsername);
        sb.append(", sPassword=").append(sPassword);
        sb.append(", sUserType=").append(sUserType);
        sb.append("]");
        return sb.toString();
    }
}
package com.hgl.recruitms.model;

import java.util.Date;

public class Attach {
    private Integer nAttachNo;

    private String sAttachName;

    private String sAttachType;

    private String sPath;

    private Integer nVersion;

    private String sStatus;

    private Date dCreateTime;

    private String sCreator;

    private String sCreatorNo;

    private Integer nLastAttachNo;

    private String sFileType;

    private String sSavePath;

    private String sSubPath;

    public Integer getnAttachNo() {
        return nAttachNo;
    }

    public Attach withnAttachNo(Integer nAttachNo) {
        this.setnAttachNo(nAttachNo);
        return this;
    }

    public void setnAttachNo(Integer nAttachNo) {
        this.nAttachNo = nAttachNo;
    }

    public String getsAttachName() {
        return sAttachName;
    }

    public Attach withsAttachName(String sAttachName) {
        this.setsAttachName(sAttachName);
        return this;
    }

    public void setsAttachName(String sAttachName) {
        this.sAttachName = sAttachName == null ? null : sAttachName.trim();
    }

    public String getsAttachType() {
        return sAttachType;
    }

    public Attach withsAttachType(String sAttachType) {
        this.setsAttachType(sAttachType);
        return this;
    }

    public void setsAttachType(String sAttachType) {
        this.sAttachType = sAttachType == null ? null : sAttachType.trim();
    }

    public String getsPath() {
        return sPath;
    }

    public Attach withsPath(String sPath) {
        this.setsPath(sPath);
        return this;
    }

    public void setsPath(String sPath) {
        this.sPath = sPath == null ? null : sPath.trim();
    }

    public Integer getnVersion() {
        return nVersion;
    }

    public Attach withnVersion(Integer nVersion) {
        this.setnVersion(nVersion);
        return this;
    }

    public void setnVersion(Integer nVersion) {
        this.nVersion = nVersion;
    }

    public String getsStatus() {
        return sStatus;
    }

    public Attach withsStatus(String sStatus) {
        this.setsStatus(sStatus);
        return this;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus == null ? null : sStatus.trim();
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public Attach withdCreateTime(Date dCreateTime) {
        this.setdCreateTime(dCreateTime);
        return this;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public String getsCreator() {
        return sCreator;
    }

    public Attach withsCreator(String sCreator) {
        this.setsCreator(sCreator);
        return this;
    }

    public void setsCreator(String sCreator) {
        this.sCreator = sCreator == null ? null : sCreator.trim();
    }

    public String getsCreatorNo() {
        return sCreatorNo;
    }

    public Attach withsCreatorNo(String sCreatorNo) {
        this.setsCreatorNo(sCreatorNo);
        return this;
    }

    public void setsCreatorNo(String sCreatorNo) {
        this.sCreatorNo = sCreatorNo == null ? null : sCreatorNo.trim();
    }

    public Integer getnLastAttachNo() {
        return nLastAttachNo;
    }

    public Attach withnLastAttachNo(Integer nLastAttachNo) {
        this.setnLastAttachNo(nLastAttachNo);
        return this;
    }

    public void setnLastAttachNo(Integer nLastAttachNo) {
        this.nLastAttachNo = nLastAttachNo;
    }

    public String getsFileType() {
        return sFileType;
    }

    public Attach withsFileType(String sFileType) {
        this.setsFileType(sFileType);
        return this;
    }

    public void setsFileType(String sFileType) {
        this.sFileType = sFileType == null ? null : sFileType.trim();
    }

    public String getsSavePath() {
        return sSavePath;
    }

    public Attach withsSavePath(String sSavePath) {
        this.setsSavePath(sSavePath);
        return this;
    }

    public void setsSavePath(String sSavePath) {
        this.sSavePath = sSavePath == null ? null : sSavePath.trim();
    }

    public String getsSubPath() {
        return sSubPath;
    }

    public Attach withsSubPath(String sSubPath) {
        this.setsSubPath(sSubPath);
        return this;
    }

    public void setsSubPath(String sSubPath) {
        this.sSubPath = sSubPath == null ? null : sSubPath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nAttachNo=").append(nAttachNo);
        sb.append(", sAttachName=").append(sAttachName);
        sb.append(", sAttachType=").append(sAttachType);
        sb.append(", sPath=").append(sPath);
        sb.append(", nVersion=").append(nVersion);
        sb.append(", sStatus=").append(sStatus);
        sb.append(", dCreateTime=").append(dCreateTime);
        sb.append(", sCreator=").append(sCreator);
        sb.append(", sCreatorNo=").append(sCreatorNo);
        sb.append(", nLastAttachNo=").append(nLastAttachNo);
        sb.append(", sFileType=").append(sFileType);
        sb.append(", sSavePath=").append(sSavePath);
        sb.append(", sSubPath=").append(sSubPath);
        sb.append("]");
        return sb.toString();
    }
}
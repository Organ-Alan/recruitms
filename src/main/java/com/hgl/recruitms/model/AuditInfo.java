package com.hgl.recruitms.model;

import java.util.Date;

public class AuditInfo {
    private Integer nAuditNo;

    private Integer nDeptNo;

    private String sDeptCode;

    private String sShortName;

    private String sFullName;

    private String sModifyItemid;

    private String sModifyItem;

    private String sBeforeModify;

    private String sAfterModify;

    private String sCreator;

    private String sCreatorNo;

    private Date dCreateTime;

    private String sOperator;

    private String sStatus;

    private String sOperatorNo;

    private Date dOperateTime;

    public Integer getnAuditNo() {
        return nAuditNo;
    }

    public AuditInfo withnAuditNo(Integer nAuditNo) {
        this.setnAuditNo(nAuditNo);
        return this;
    }

    public void setnAuditNo(Integer nAuditNo) {
        this.nAuditNo = nAuditNo;
    }

    public Integer getnDeptNo() {
        return nDeptNo;
    }

    public AuditInfo withnDeptNo(Integer nDeptNo) {
        this.setnDeptNo(nDeptNo);
        return this;
    }

    public void setnDeptNo(Integer nDeptNo) {
        this.nDeptNo = nDeptNo;
    }

    public String getsDeptCode() {
        return sDeptCode;
    }

    public AuditInfo withsDeptCode(String sDeptCode) {
        this.setsDeptCode(sDeptCode);
        return this;
    }

    public void setsDeptCode(String sDeptCode) {
        this.sDeptCode = sDeptCode == null ? null : sDeptCode.trim();
    }

    public String getsShortName() {
        return sShortName;
    }

    public AuditInfo withsShortName(String sShortName) {
        this.setsShortName(sShortName);
        return this;
    }

    public void setsShortName(String sShortName) {
        this.sShortName = sShortName == null ? null : sShortName.trim();
    }

    public String getsFullName() {
        return sFullName;
    }

    public AuditInfo withsFullName(String sFullName) {
        this.setsFullName(sFullName);
        return this;
    }

    public void setsFullName(String sFullName) {
        this.sFullName = sFullName == null ? null : sFullName.trim();
    }

    public String getsModifyItemid() {
        return sModifyItemid;
    }

    public AuditInfo withsModifyItemid(String sModifyItemid) {
        this.setsModifyItemid(sModifyItemid);
        return this;
    }

    public void setsModifyItemid(String sModifyItemid) {
        this.sModifyItemid = sModifyItemid == null ? null : sModifyItemid.trim();
    }

    public String getsModifyItem() {
        return sModifyItem;
    }

    public AuditInfo withsModifyItem(String sModifyItem) {
        this.setsModifyItem(sModifyItem);
        return this;
    }

    public void setsModifyItem(String sModifyItem) {
        this.sModifyItem = sModifyItem == null ? null : sModifyItem.trim();
    }

    public String getsBeforeModify() {
        return sBeforeModify;
    }

    public AuditInfo withsBeforeModify(String sBeforeModify) {
        this.setsBeforeModify(sBeforeModify);
        return this;
    }

    public void setsBeforeModify(String sBeforeModify) {
        this.sBeforeModify = sBeforeModify == null ? null : sBeforeModify.trim();
    }

    public String getsAfterModify() {
        return sAfterModify;
    }

    public AuditInfo withsAfterModify(String sAfterModify) {
        this.setsAfterModify(sAfterModify);
        return this;
    }

    public void setsAfterModify(String sAfterModify) {
        this.sAfterModify = sAfterModify == null ? null : sAfterModify.trim();
    }

    public String getsCreator() {
        return sCreator;
    }

    public AuditInfo withsCreator(String sCreator) {
        this.setsCreator(sCreator);
        return this;
    }

    public void setsCreator(String sCreator) {
        this.sCreator = sCreator == null ? null : sCreator.trim();
    }

    public String getsCreatorNo() {
        return sCreatorNo;
    }

    public AuditInfo withsCreatorNo(String sCreatorNo) {
        this.setsCreatorNo(sCreatorNo);
        return this;
    }

    public void setsCreatorNo(String sCreatorNo) {
        this.sCreatorNo = sCreatorNo == null ? null : sCreatorNo.trim();
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public AuditInfo withdCreateTime(Date dCreateTime) {
        this.setdCreateTime(dCreateTime);
        return this;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public String getsOperator() {
        return sOperator;
    }

    public AuditInfo withsOperator(String sOperator) {
        this.setsOperator(sOperator);
        return this;
    }

    public void setsOperator(String sOperator) {
        this.sOperator = sOperator == null ? null : sOperator.trim();
    }

    public String getsStatus() {
        return sStatus;
    }

    public AuditInfo withsStatus(String sStatus) {
        this.setsStatus(sStatus);
        return this;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus == null ? null : sStatus.trim();
    }

    public String getsOperatorNo() {
        return sOperatorNo;
    }

    public AuditInfo withsOperatorNo(String sOperatorNo) {
        this.setsOperatorNo(sOperatorNo);
        return this;
    }

    public void setsOperatorNo(String sOperatorNo) {
        this.sOperatorNo = sOperatorNo == null ? null : sOperatorNo.trim();
    }

    public Date getdOperateTime() {
        return dOperateTime;
    }

    public AuditInfo withdOperateTime(Date dOperateTime) {
        this.setdOperateTime(dOperateTime);
        return this;
    }

    public void setdOperateTime(Date dOperateTime) {
        this.dOperateTime = dOperateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nAuditNo=").append(nAuditNo);
        sb.append(", nDeptNo=").append(nDeptNo);
        sb.append(", sDeptCode=").append(sDeptCode);
        sb.append(", sShortName=").append(sShortName);
        sb.append(", sFullName=").append(sFullName);
        sb.append(", sModifyItemid=").append(sModifyItemid);
        sb.append(", sModifyItem=").append(sModifyItem);
        sb.append(", sBeforeModify=").append(sBeforeModify);
        sb.append(", sAfterModify=").append(sAfterModify);
        sb.append(", sCreator=").append(sCreator);
        sb.append(", sCreatorNo=").append(sCreatorNo);
        sb.append(", dCreateTime=").append(dCreateTime);
        sb.append(", sOperator=").append(sOperator);
        sb.append(", sStatus=").append(sStatus);
        sb.append(", sOperatorNo=").append(sOperatorNo);
        sb.append(", dOperateTime=").append(dOperateTime);
        sb.append("]");
        return sb.toString();
    }
}
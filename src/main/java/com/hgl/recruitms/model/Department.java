package com.hgl.recruitms.model;

public class Department {
    private Integer nDeptNo;

    private String sDeptCode;

    private String sShortName;

    private String sFullName;

    private String sRegion;

    private String sTuition;

    private Integer nCountEnrol;

    private Integer nCountExtRnrol;

    private Double dbEnrolScore;

    private String sRemark;

    private String cValidFlag;

    public Integer getnDeptNo() {
        return nDeptNo;
    }

    public Department withnDeptNo(Integer nDeptNo) {
        this.setnDeptNo(nDeptNo);
        return this;
    }

    public void setnDeptNo(Integer nDeptNo) {
        this.nDeptNo = nDeptNo;
    }

    public String getsDeptCode() {
        return sDeptCode;
    }

    public Department withsDeptCode(String sDeptCode) {
        this.setsDeptCode(sDeptCode);
        return this;
    }

    public void setsDeptCode(String sDeptCode) {
        this.sDeptCode = sDeptCode == null ? null : sDeptCode.trim();
    }

    public String getsShortName() {
        return sShortName;
    }

    public Department withsShortName(String sShortName) {
        this.setsShortName(sShortName);
        return this;
    }

    public void setsShortName(String sShortName) {
        this.sShortName = sShortName == null ? null : sShortName.trim();
    }

    public String getsFullName() {
        return sFullName;
    }

    public Department withsFullName(String sFullName) {
        this.setsFullName(sFullName);
        return this;
    }

    public void setsFullName(String sFullName) {
        this.sFullName = sFullName == null ? null : sFullName.trim();
    }

    public String getsRegion() {
        return sRegion;
    }

    public Department withsRegion(String sRegion) {
        this.setsRegion(sRegion);
        return this;
    }

    public void setsRegion(String sRegion) {
        this.sRegion = sRegion == null ? null : sRegion.trim();
    }

    public String getsTuition() {
        return sTuition;
    }

    public Department withsTuition(String sTuition) {
        this.setsTuition(sTuition);
        return this;
    }

    public void setsTuition(String sTuition) {
        this.sTuition = sTuition == null ? null : sTuition.trim();
    }

    public Integer getnCountEnrol() {
        return nCountEnrol;
    }

    public Department withnCountEnrol(Integer nCountEnrol) {
        this.setnCountEnrol(nCountEnrol);
        return this;
    }

    public void setnCountEnrol(Integer nCountEnrol) {
        this.nCountEnrol = nCountEnrol;
    }

    public Integer getnCountExtRnrol() {
        return nCountExtRnrol;
    }

    public Department withnCountExtRnrol(Integer nCountExtRnrol) {
        this.setnCountExtRnrol(nCountExtRnrol);
        return this;
    }

    public void setnCountExtRnrol(Integer nCountExtRnrol) {
        this.nCountExtRnrol = nCountExtRnrol;
    }

    public Double getDbEnrolScore() {
        return dbEnrolScore;
    }

    public Department withDbEnrolScore(Double dbEnrolScore) {
        this.setDbEnrolScore(dbEnrolScore);
        return this;
    }

    public void setDbEnrolScore(Double dbEnrolScore) {
        this.dbEnrolScore = dbEnrolScore;
    }

    public String getsRemark() {
        return sRemark;
    }

    public Department withsRemark(String sRemark) {
        this.setsRemark(sRemark);
        return this;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark == null ? null : sRemark.trim();
    }

    public String getcValidFlag() {
        return cValidFlag;
    }

    public Department withcValidFlag(String cValidFlag) {
        this.setcValidFlag(cValidFlag);
        return this;
    }

    public void setcValidFlag(String cValidFlag) {
        this.cValidFlag = cValidFlag == null ? null : cValidFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nDeptNo=").append(nDeptNo);
        sb.append(", sDeptCode=").append(sDeptCode);
        sb.append(", sShortName=").append(sShortName);
        sb.append(", sFullName=").append(sFullName);
        sb.append(", sRegion=").append(sRegion);
        sb.append(", sTuition=").append(sTuition);
        sb.append(", nCountEnrol=").append(nCountEnrol);
        sb.append(", nCountExtRnrol=").append(nCountExtRnrol);
        sb.append(", dbEnrolScore=").append(dbEnrolScore);
        sb.append(", sRemark=").append(sRemark);
        sb.append(", cValidFlag=").append(cValidFlag);
        sb.append("]");
        return sb.toString();
    }
}
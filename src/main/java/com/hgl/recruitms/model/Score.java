package com.hgl.recruitms.model;

public class Score {
    private Integer nStudentId;

    private String sStudentName;

    private String sStudentNo;

    private String sSubjectType;

    private Double dbScore;

    private Double dbChinses;

    private Double dbEnglish;

    private Double dbMath;

    private String sTotalScore;

    public Integer getnStudentId() {
        return nStudentId;
    }

    public Score withnStudentId(Integer nStudentId) {
        this.setnStudentId(nStudentId);
        return this;
    }

    public void setnStudentId(Integer nStudentId) {
        this.nStudentId = nStudentId;
    }

    public String getsStudentName() {
        return sStudentName;
    }

    public Score withsStudentName(String sStudentName) {
        this.setsStudentName(sStudentName);
        return this;
    }

    public void setsStudentName(String sStudentName) {
        this.sStudentName = sStudentName == null ? null : sStudentName.trim();
    }

    public String getsStudentNo() {
        return sStudentNo;
    }

    public Score withsStudentNo(String sStudentNo) {
        this.setsStudentNo(sStudentNo);
        return this;
    }

    public void setsStudentNo(String sStudentNo) {
        this.sStudentNo = sStudentNo == null ? null : sStudentNo.trim();
    }

    public String getsSubjectType() {
        return sSubjectType;
    }

    public Score withsSubjectType(String sSubjectType) {
        this.setsSubjectType(sSubjectType);
        return this;
    }

    public void setsSubjectType(String sSubjectType) {
        this.sSubjectType = sSubjectType == null ? null : sSubjectType.trim();
    }

    public Double getDbScore() {
        return dbScore;
    }

    public Score withDbScore(Double dbScore) {
        this.setDbScore(dbScore);
        return this;
    }

    public void setDbScore(Double dbScore) {
        this.dbScore = dbScore;
    }

    public Double getDbChinses() {
        return dbChinses;
    }

    public Score withDbChinses(Double dbChinses) {
        this.setDbChinses(dbChinses);
        return this;
    }

    public void setDbChinses(Double dbChinses) {
        this.dbChinses = dbChinses;
    }

    public Double getDbEnglish() {
        return dbEnglish;
    }

    public Score withDbEnglish(Double dbEnglish) {
        this.setDbEnglish(dbEnglish);
        return this;
    }

    public void setDbEnglish(Double dbEnglish) {
        this.dbEnglish = dbEnglish;
    }

    public Double getDbMath() {
        return dbMath;
    }

    public Score withDbMath(Double dbMath) {
        this.setDbMath(dbMath);
        return this;
    }

    public void setDbMath(Double dbMath) {
        this.dbMath = dbMath;
    }

    public String getsTotalScore() {
        return sTotalScore;
    }

    public Score withsTotalScore(String sTotalScore) {
        this.setsTotalScore(sTotalScore);
        return this;
    }

    public void setsTotalScore(String sTotalScore) {
        this.sTotalScore = sTotalScore == null ? null : sTotalScore.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nStudentId=").append(nStudentId);
        sb.append(", sStudentName=").append(sStudentName);
        sb.append(", sStudentNo=").append(sStudentNo);
        sb.append(", sSubjectType=").append(sSubjectType);
        sb.append(", dbScore=").append(dbScore);
        sb.append(", dbChinses=").append(dbChinses);
        sb.append(", dbEnglish=").append(dbEnglish);
        sb.append(", dbMath=").append(dbMath);
        sb.append(", sTotalScore=").append(sTotalScore);
        sb.append("]");
        return sb.toString();
    }
}
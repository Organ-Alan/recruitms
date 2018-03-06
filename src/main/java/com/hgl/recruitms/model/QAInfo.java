package com.hgl.recruitms.model;

import java.util.Date;

public class QAInfo {
    private Integer nQaId;

    private Integer sSortNo;

    private String sQuestion;

    private String sAnswer;

    private String sRemark;

    private String cValidFlag;

    private Date dCreateTime;

    private String sCreator;

    private Integer sCreatorNo;

    public Integer getnQaId() {
        return nQaId;
    }

    public QAInfo withnQaId(Integer nQaId) {
        this.setnQaId(nQaId);
        return this;
    }

    public void setnQaId(Integer nQaId) {
        this.nQaId = nQaId;
    }

    public Integer getsSortNo() {
        return sSortNo;
    }

    public QAInfo withsSortNo(Integer sSortNo) {
        this.setsSortNo(sSortNo);
        return this;
    }

    public void setsSortNo(Integer sSortNo) {
        this.sSortNo = sSortNo;
    }

    public String getsQuestion() {
        return sQuestion;
    }

    public QAInfo withsQuestion(String sQuestion) {
        this.setsQuestion(sQuestion);
        return this;
    }

    public void setsQuestion(String sQuestion) {
        this.sQuestion = sQuestion == null ? null : sQuestion.trim();
    }

    public String getsAnswer() {
        return sAnswer;
    }

    public QAInfo withsAnswer(String sAnswer) {
        this.setsAnswer(sAnswer);
        return this;
    }

    public void setsAnswer(String sAnswer) {
        this.sAnswer = sAnswer == null ? null : sAnswer.trim();
    }

    public String getsRemark() {
        return sRemark;
    }

    public QAInfo withsRemark(String sRemark) {
        this.setsRemark(sRemark);
        return this;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark == null ? null : sRemark.trim();
    }

    public String getcValidFlag() {
        return cValidFlag;
    }

    public QAInfo withcValidFlag(String cValidFlag) {
        this.setcValidFlag(cValidFlag);
        return this;
    }

    public void setcValidFlag(String cValidFlag) {
        this.cValidFlag = cValidFlag == null ? null : cValidFlag.trim();
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public QAInfo withdCreateTime(Date dCreateTime) {
        this.setdCreateTime(dCreateTime);
        return this;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public String getsCreator() {
        return sCreator;
    }

    public QAInfo withsCreator(String sCreator) {
        this.setsCreator(sCreator);
        return this;
    }

    public void setsCreator(String sCreator) {
        this.sCreator = sCreator == null ? null : sCreator.trim();
    }

    public Integer getsCreatorNo() {
        return sCreatorNo;
    }

    public QAInfo withsCreatorNo(Integer sCreatorNo) {
        this.setsCreatorNo(sCreatorNo);
        return this;
    }

    public void setsCreatorNo(Integer sCreatorNo) {
        this.sCreatorNo = sCreatorNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nQaId=").append(nQaId);
        sb.append(", sSortNo=").append(sSortNo);
        sb.append(", sQuestion=").append(sQuestion);
        sb.append(", sAnswer=").append(sAnswer);
        sb.append(", sRemark=").append(sRemark);
        sb.append(", cValidFlag=").append(cValidFlag);
        sb.append(", dCreateTime=").append(dCreateTime);
        sb.append(", sCreator=").append(sCreator);
        sb.append(", sCreatorNo=").append(sCreatorNo);
        sb.append("]");
        return sb.toString();
    }
}
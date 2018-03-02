package com.hgl.recruitms.model;

public class Dictionary {
    private Integer nDictNo;

    private String sItemCode;

    private String sSortNo;

    private String sItemKey;

    private String sItemValue;

    private String sRemark;

    private String cValidFlag;

    public Integer getnDictNo() {
        return nDictNo;
    }

    public Dictionary withnDictNo(Integer nDictNo) {
        this.setnDictNo(nDictNo);
        return this;
    }

    public void setnDictNo(Integer nDictNo) {
        this.nDictNo = nDictNo;
    }

    public String getsItemCode() {
        return sItemCode;
    }

    public Dictionary withsItemCode(String sItemCode) {
        this.setsItemCode(sItemCode);
        return this;
    }

    public void setsItemCode(String sItemCode) {
        this.sItemCode = sItemCode == null ? null : sItemCode.trim();
    }

    public String getsSortNo() {
        return sSortNo;
    }

    public Dictionary withsSortNo(String sSortNo) {
        this.setsSortNo(sSortNo);
        return this;
    }

    public void setsSortNo(String sSortNo) {
        this.sSortNo = sSortNo == null ? null : sSortNo.trim();
    }

    public String getsItemKey() {
        return sItemKey;
    }

    public Dictionary withsItemKey(String sItemKey) {
        this.setsItemKey(sItemKey);
        return this;
    }

    public void setsItemKey(String sItemKey) {
        this.sItemKey = sItemKey == null ? null : sItemKey.trim();
    }

    public String getsItemValue() {
        return sItemValue;
    }

    public Dictionary withsItemValue(String sItemValue) {
        this.setsItemValue(sItemValue);
        return this;
    }

    public void setsItemValue(String sItemValue) {
        this.sItemValue = sItemValue == null ? null : sItemValue.trim();
    }

    public String getsRemark() {
        return sRemark;
    }

    public Dictionary withsRemark(String sRemark) {
        this.setsRemark(sRemark);
        return this;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark == null ? null : sRemark.trim();
    }

    public String getcValidFlag() {
        return cValidFlag;
    }

    public Dictionary withcValidFlag(String cValidFlag) {
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
        sb.append(", nDictNo=").append(nDictNo);
        sb.append(", sItemCode=").append(sItemCode);
        sb.append(", sSortNo=").append(sSortNo);
        sb.append(", sItemKey=").append(sItemKey);
        sb.append(", sItemValue=").append(sItemValue);
        sb.append(", sRemark=").append(sRemark);
        sb.append(", cValidFlag=").append(cValidFlag);
        sb.append("]");
        return sb.toString();
    }
}
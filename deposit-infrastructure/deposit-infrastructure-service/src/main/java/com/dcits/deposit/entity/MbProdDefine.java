package com.dcits.deposit.entity;

public class MbProdDefine {
    /** 产品类型 */
    private String prodType;
    /** 序号 */
    private String seqNo;
    /** 组件类型 */
    private String assembleType;
    /** 组件ID */
    private String assembleId;
    /** 参数KEY值 */
    private String attrKey;
    /** 属性值 */
    private String attrValue;
    /** 基础事件 */
    private String eventDefault;
    /** 状态 */
    private String status;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getAssembleType() {
        return assembleType;
    }

    public void setAssembleType(String assembleType) {
        this.assembleType = assembleType;
    }

    public String getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(String assembleId) {
        this.assembleId = assembleId;
    }

    public String getAttrKey() {
        return attrKey;
    }

    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getEventDefault() {
        return eventDefault;
    }

    public void setEventDefault(String eventDefault) {
        this.eventDefault = eventDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
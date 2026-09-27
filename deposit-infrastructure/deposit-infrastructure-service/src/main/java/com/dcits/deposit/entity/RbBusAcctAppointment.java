package com.dcits.deposit.entity;

import java.util.Date;

public class RbBusAcctAppointment {
    /** 产品编号 */
    private String prodNo;
    /** 账号 */
    private String baseAcctNo;
    /** 发证国家 */
    private String issCountry;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 预约编号 */
    private String orderNo;
    /** 对公账号预约状态 */
    private String appointmentStatus;
    /** 证件号码 */
    private String documentId;
    /** 交易日期 */
    private Date tranDate;
    /** 客户细分类型 */
    private String categoryType;
    /** 存款账户类型 */
    private String rbAcctType;
    /** 客户类型 */
    private String clientType;
    /** 交易机构号 */
    private String tranBranch;
    /** 证件类型 */
    private String documentType;
    /** 客户名称 */
    private String clientName;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 预约到期日期 */
    private Date applyDueDate;

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(String issCountry) {
        this.issCountry = issCountry;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(String rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public Date getApplyDueDate() {
        return applyDueDate;
    }

    public void setApplyDueDate(Date applyDueDate) {
        this.applyDueDate = applyDueDate;
    }
}
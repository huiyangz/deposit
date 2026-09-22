package com.dcits.deposit.entity;

import java.util.Date;

public class RbTranControlHist {
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 渠道日期 */
    private Date channelDate;
    /** 渠道类型 */
    private String sourceType;
    /** 子流水号 */
    private String subSeqNo;
    /** 业务细类 */
    private String busiSubClass;
    /** 客户号 */
    private String clientNo;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 事件类型 */
    private String tranEventType;
    /** 交易描述 */
    private String tranDesc;
    /** 交易参考号 */
    private String reference;
    /** 联机交易状态 */
    private String onlineTranStatus;
    /** 接口服务类型 */
    private String messageType;
    /** 接口服务代码 */
    private String messageCode;
    /** 服务代码 */
    private String serviceCode;
    /** 源模块 */
    private String sourceModule;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 消费系统流水号 */
    private String customerSeqNo;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 传输代码 */
    private String tranCode;
    /** TAE交易模式 */
    private String taeTradeMode;
    /** 借贷标志 */
    private String drCrFlag;
    /** tae记账标志 */
    private String taeFlag;

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public Date getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(Date channelDate) {
        this.channelDate = channelDate;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getBusiSubClass() {
        return busiSubClass;
    }

    public void setBusiSubClass(String busiSubClass) {
        this.busiSubClass = busiSubClass;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getTranEventType() {
        return tranEventType;
    }

    public void setTranEventType(String tranEventType) {
        this.tranEventType = tranEventType;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getOnlineTranStatus() {
        return onlineTranStatus;
    }

    public void setOnlineTranStatus(String onlineTranStatus) {
        this.onlineTranStatus = onlineTranStatus;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCustomerSeqNo() {
        return customerSeqNo;
    }

    public void setCustomerSeqNo(String customerSeqNo) {
        this.customerSeqNo = customerSeqNo;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getTaeTradeMode() {
        return taeTradeMode;
    }

    public void setTaeTradeMode(String taeTradeMode) {
        this.taeTradeMode = taeTradeMode;
    }

    public String getDrCrFlag() {
        return drCrFlag;
    }

    public void setDrCrFlag(String drCrFlag) {
        this.drCrFlag = drCrFlag;
    }

    public String getTaeFlag() {
        return taeFlag;
    }

    public void setTaeFlag(String taeFlag) {
        this.taeFlag = taeFlag;
    }
}
package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbCentReg {
    /** 序号 */
    private String seqNo;
    /** 交易参考号 */
    private String reference;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 子流水号 */
    private String subSeqNo;
    /** 原渠道流水号 */
    private String origChannelSeqNo;
    /** 原始渠道子流水号 */
    private String origSubSeqNo;
    /** 销户标识 */
    private String closeAcctInd;
    /** 分位处理类型 */
    private String centDealType;
    /** 分位金额 */
    private BigDecimal centAmt;
    /** 币种 */
    private String ccy;
    /** 金额类型 */
    private String amtType;
    /** 客户号 */
    private String clientNo;
    /** 交易日期 */
    private Date tranDate;
    /** 业务处理状态 */
    private String tranStatus;
    /** 交易类型 */
    private String tranType;
    /** 事件类型 */
    private String eventType;
    /** 冲正标志 */
    private String reversalFlag;
    /** 冲正流水号 */
    private String reversalSeqNo;
    /** 冲正交易类型 */
    private String reversalTranType;
    /** 冲正交易日期 */
    private Date reversalTranDate;
    /** 冲正柜员号 */
    private String reversalUserId;
    /** 冲正原因 */
    private String reversalReason;
    /** 冲正抹账标志 */
    private String wipeAccount;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getOrigChannelSeqNo() {
        return origChannelSeqNo;
    }

    public void setOrigChannelSeqNo(String origChannelSeqNo) {
        this.origChannelSeqNo = origChannelSeqNo;
    }

    public String getOrigSubSeqNo() {
        return origSubSeqNo;
    }

    public void setOrigSubSeqNo(String origSubSeqNo) {
        this.origSubSeqNo = origSubSeqNo;
    }

    public String getCloseAcctInd() {
        return closeAcctInd;
    }

    public void setCloseAcctInd(String closeAcctInd) {
        this.closeAcctInd = closeAcctInd;
    }

    public String getCentDealType() {
        return centDealType;
    }

    public void setCentDealType(String centDealType) {
        this.centDealType = centDealType;
    }

    public BigDecimal getCentAmt() {
        return centAmt;
    }

    public void setCentAmt(BigDecimal centAmt) {
        this.centAmt = centAmt;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
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

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(String reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public String getReversalSeqNo() {
        return reversalSeqNo;
    }

    public void setReversalSeqNo(String reversalSeqNo) {
        this.reversalSeqNo = reversalSeqNo;
    }

    public String getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(String reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public Date getReversalTranDate() {
        return reversalTranDate;
    }

    public void setReversalTranDate(Date reversalTranDate) {
        this.reversalTranDate = reversalTranDate;
    }

    public String getReversalUserId() {
        return reversalUserId;
    }

    public void setReversalUserId(String reversalUserId) {
        this.reversalUserId = reversalUserId;
    }

    public String getReversalReason() {
        return reversalReason;
    }

    public void setReversalReason(String reversalReason) {
        this.reversalReason = reversalReason;
    }

    public String getWipeAccount() {
        return wipeAccount;
    }

    public void setWipeAccount(String wipeAccount) {
        this.wipeAccount = wipeAccount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
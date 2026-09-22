package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.CentDealType;
import com.dcits.deposit.enums.CloseAcctInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WipeAccount;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbCentRegEO {
    /** 序号 */
    @NotNull
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
    private CloseAcctInd closeAcctInd;
    /** 分位处理类型 */
    private CentDealType centDealType;
    /** 分位金额 */
    private BigDecimal centAmt;
    /** 币种 */
    private AcctCcy ccy;
    /** 金额类型 */
    private AmtType amtType;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 业务处理状态 */
    private TranStatus tranStatus;
    /** 交易类型 */
    private TranType tranType;
    /** 事件类型 */
    private String eventType;
    /** 冲正标志 */
    private IndividualFlag reversalFlag;
    /** 冲正流水号 */
    private String reversalSeqNo;
    /** 冲正交易类型 */
    private TranType reversalTranType;
    /** 冲正交易日期 */
    private java.util.Date reversalTranDate;
    /** 冲正柜员号 */
    private String reversalUserId;
    /** 冲正原因 */
    private String reversalReason;
    /** 冲正抹账标志 */
    private WipeAccount wipeAccount;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
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

    public CloseAcctInd getCloseAcctInd() {
        return closeAcctInd;
    }

    public void setCloseAcctInd(CloseAcctInd closeAcctInd) {
        this.closeAcctInd = closeAcctInd;
    }

    public CentDealType getCentDealType() {
        return centDealType;
    }

    public void setCentDealType(CentDealType centDealType) {
        this.centDealType = centDealType;
    }

    public BigDecimal getCentAmt() {
        return centAmt;
    }

    public void setCentAmt(BigDecimal centAmt) {
        this.centAmt = centAmt;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public IndividualFlag getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(IndividualFlag reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public String getReversalSeqNo() {
        return reversalSeqNo;
    }

    public void setReversalSeqNo(String reversalSeqNo) {
        this.reversalSeqNo = reversalSeqNo;
    }

    public TranType getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(TranType reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public java.util.Date getReversalTranDate() {
        return reversalTranDate;
    }

    public void setReversalTranDate(java.util.Date reversalTranDate) {
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

    public WipeAccount getWipeAccount() {
        return wipeAccount;
    }

    public void setWipeAccount(WipeAccount wipeAccount) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
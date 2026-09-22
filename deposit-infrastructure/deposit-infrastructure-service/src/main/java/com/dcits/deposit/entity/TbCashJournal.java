package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TbCashJournal {
    /** 流水号 */
    private String journalId;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 子流水号 */
    private String subSeqNo;
    /** 记账引擎流水号 */
    private String taeSeqNo;
    /** 交易参考号 */
    private String reference;
    /** 调拨编号 */
    private String moveId;
    /** 现金凭证调拨类型 */
    private String moveType;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易柜员号 */
    private String userId;
    /** 渠道类型 */
    private String sourceType;
    /** 源模块 */
    private String sourceModule;
    /** 尾箱编号 */
    private String tailboxId;
    /** 尾箱绑定柜员号 */
    private String tailboxUserId;
    /** 币种 */
    private String ccy;
    /** 现金数量 */
    private Integer cashNum;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 实际金额 */
    private BigDecimal actualAmt;
    /** 收付标志 */
    private String payRec;
    /** 交易代码 */
    private String programId;
    /** 交易描述 */
    private String tranDesc;
    /** 备注 */
    private String remark;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 冲正标志 */
    private String reserveFlag;
    /** 对方交易机构号 */
    private String toBranch;
    /** 对方柜员号 */
    private String toUserId;
    /** 对方尾箱编号 */
    private String toTailboxId;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
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

    public String getTaeSeqNo() {
        return taeSeqNo;
    }

    public void setTaeSeqNo(String taeSeqNo) {
        this.taeSeqNo = taeSeqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public String getTailboxUserId() {
        return tailboxUserId;
    }

    public void setTailboxUserId(String tailboxUserId) {
        this.tailboxUserId = tailboxUserId;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Integer getCashNum() {
        return cashNum;
    }

    public void setCashNum(Integer cashNum) {
        this.cashNum = cashNum;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getActualAmt() {
        return actualAmt;
    }

    public void setActualAmt(BigDecimal actualAmt) {
        this.actualAmt = actualAmt;
    }

    public String getPayRec() {
        return payRec;
    }

    public void setPayRec(String payRec) {
        this.payRec = payRec;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
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

    public String getReserveFlag() {
        return reserveFlag;
    }

    public void setReserveFlag(String reserveFlag) {
        this.reserveFlag = reserveFlag;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToTailboxId() {
        return toTailboxId;
    }

    public void setToTailboxId(String toTailboxId) {
        this.toTailboxId = toTailboxId;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbTranHistBook {
    /** 序号 */
    private String seqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户币种 */
    private String acctCcy;
    /** 产品类型 */
    private String prodType;
    /** 账户序号 */
    private String acctSeqNo;
    /** 客户号 */
    private String clientNo;
    /** 交易参考号 */
    private String reference;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易日期 */
    private Date tranDate;
    /** 事件类型 */
    private String eventType;
    /** 交易类型 */
    private String tranType;
    /** 借贷标志 */
    private String crDrInd;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 交易前余额 */
    private BigDecimal previousBalAmt;
    /** 实际余额 */
    private BigDecimal actualBal;
    /** 业务处理状态 */
    private String tranStatus;
    /** 交易描述 */
    private String tranDesc;
    /** 交易附言 */
    private String tranNote;
    /** 对账簿打印标志 */
    private String bookPrintFlag;
    /** 余额类型 */
    private String balType;
    /** 冲正交易标志 */
    private String reversal;
    /** 摘要 */
    private String narrative;
    /** 生效日期 */
    private Date effectDate;
    /** 原始交易时间戳 */
    private String origTranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getPreviousBalAmt() {
        return previousBalAmt;
    }

    public void setPreviousBalAmt(BigDecimal previousBalAmt) {
        this.previousBalAmt = previousBalAmt;
    }

    public BigDecimal getActualBal() {
        return actualBal;
    }

    public void setActualBal(BigDecimal actualBal) {
        this.actualBal = actualBal;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public String getBookPrintFlag() {
        return bookPrintFlag;
    }

    public void setBookPrintFlag(String bookPrintFlag) {
        this.bookPrintFlag = bookPrintFlag;
    }

    public String getBalType() {
        return balType;
    }

    public void setBalType(String balType) {
        this.balType = balType;
    }

    public String getReversal() {
        return reversal;
    }

    public void setReversal(String reversal) {
        this.reversal = reversal;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getOrigTranTimestamp() {
        return origTranTimestamp;
    }

    public void setOrigTranTimestamp(String origTranTimestamp) {
        this.origTranTimestamp = origTranTimestamp;
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
package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbTranHistBookEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 产品类型 */
    private String prodType;
    /** 账户序号 */
    private String acctSeqNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易参考号 */
    private String reference;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 事件类型 */
    private String eventType;
    /** 交易类型 */
    private TranType tranType;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 交易前余额 */
    private BigDecimal previousBalAmt;
    /** 实际余额 */
    private BigDecimal actualBal;
    /** 业务处理状态 */
    private TranStatus tranStatus;
    /** 交易描述 */
    private String tranDesc;
    /** 交易附言 */
    private String tranNote;
    /** 对账簿打印标志 */
    private IndividualFlag bookPrintFlag;
    /** 余额类型 */
    private BalType balType;
    /** 冲正交易标志 */
    private IndividualFlag reversal;
    /** 摘要 */
    private String narrative;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 原始交易时间戳 */
    private String origTranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
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

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
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

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
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

    public IndividualFlag getBookPrintFlag() {
        return bookPrintFlag;
    }

    public void setBookPrintFlag(IndividualFlag bookPrintFlag) {
        this.bookPrintFlag = bookPrintFlag;
    }

    public BalType getBalType() {
        return balType;
    }

    public void setBalType(BalType balType) {
        this.balType = balType;
    }

    public IndividualFlag getReversal() {
        return reversal;
    }

    public void setReversal(IndividualFlag reversal) {
        this.reversal = reversal;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
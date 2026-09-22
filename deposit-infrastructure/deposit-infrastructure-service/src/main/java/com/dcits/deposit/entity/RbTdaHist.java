package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbTdaHist {
    /** 序号 */
    private String seqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    private String clientNo;
    /** 账户开户日期 */
    private Date acctOpenDate;
    /** 到期日期 */
    private Date maturityDate;
    /** 定期账户交易日期 */
    private Date acctMovtDate;
    /** 转存类型 */
    private String movtStatus;
    /** 续存期数 */
    private Integer addTerm;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 自动转存类型 */
    private String autoRenewRollover;
    /** 部分本金转存标志 */
    private String partialRenewRoll;
    /** 部分本金转存金额 */
    private BigDecimal partialRenewAmt;
    /** 允许增加本金标志 */
    private String addtlPrincipal;
    /** 本息转存次数 */
    private Integer rolloverNo;
    /** 本金转存次数 */
    private Integer renewNo;
    /** 定期交易状态 */
    private String tdaStatus;
    /** 已转存次数 */
    private Integer renewTimes;
    /** 冲正交易序号 */
    private String revSeqNo;
    /** 交易序号 */
    private String tranSeqNo;
    /** 定期存单号 */
    private String tdaCertificateNo;
    /** 账户执行利率 */
    private BigDecimal acctLevelIntRate;
    /** 挂失编号 */
    private String lostNo;
    /** 交易参考号 */
    private String reference;
    /** 税金 */
    private BigDecimal taxAmt;
    /** 支取金额 */
    private BigDecimal debtAmt;
    /** 本金 */
    private BigDecimal principalAmt;
    /** 实际本金 */
    private BigDecimal principalAmtActual;
    /** 结息总金额 */
    private BigDecimal grossInterestAmt;
    /** 利息调整金额 */
    private BigDecimal intAdj;
    /** 当日利息调整金额 */
    private BigDecimal intAdjCtd;
    /** 净利息 */
    private BigDecimal netInterestAmt;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 支取执行利率 */
    private BigDecimal debtIntRate;
    /** 交易场景编码 */
    private String tranScene;
    /** 交易柜员号 */
    private String userId;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;

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

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getAcctMovtDate() {
        return acctMovtDate;
    }

    public void setAcctMovtDate(Date acctMovtDate) {
        this.acctMovtDate = acctMovtDate;
    }

    public String getMovtStatus() {
        return movtStatus;
    }

    public void setMovtStatus(String movtStatus) {
        this.movtStatus = movtStatus;
    }

    public Integer getAddTerm() {
        return addTerm;
    }

    public void setAddTerm(Integer addTerm) {
        this.addTerm = addTerm;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getAutoRenewRollover() {
        return autoRenewRollover;
    }

    public void setAutoRenewRollover(String autoRenewRollover) {
        this.autoRenewRollover = autoRenewRollover;
    }

    public String getPartialRenewRoll() {
        return partialRenewRoll;
    }

    public void setPartialRenewRoll(String partialRenewRoll) {
        this.partialRenewRoll = partialRenewRoll;
    }

    public BigDecimal getPartialRenewAmt() {
        return partialRenewAmt;
    }

    public void setPartialRenewAmt(BigDecimal partialRenewAmt) {
        this.partialRenewAmt = partialRenewAmt;
    }

    public String getAddtlPrincipal() {
        return addtlPrincipal;
    }

    public void setAddtlPrincipal(String addtlPrincipal) {
        this.addtlPrincipal = addtlPrincipal;
    }

    public Integer getRolloverNo() {
        return rolloverNo;
    }

    public void setRolloverNo(Integer rolloverNo) {
        this.rolloverNo = rolloverNo;
    }

    public Integer getRenewNo() {
        return renewNo;
    }

    public void setRenewNo(Integer renewNo) {
        this.renewNo = renewNo;
    }

    public String getTdaStatus() {
        return tdaStatus;
    }

    public void setTdaStatus(String tdaStatus) {
        this.tdaStatus = tdaStatus;
    }

    public Integer getRenewTimes() {
        return renewTimes;
    }

    public void setRenewTimes(Integer renewTimes) {
        this.renewTimes = renewTimes;
    }

    public String getRevSeqNo() {
        return revSeqNo;
    }

    public void setRevSeqNo(String revSeqNo) {
        this.revSeqNo = revSeqNo;
    }

    public String getTranSeqNo() {
        return tranSeqNo;
    }

    public void setTranSeqNo(String tranSeqNo) {
        this.tranSeqNo = tranSeqNo;
    }

    public String getTdaCertificateNo() {
        return tdaCertificateNo;
    }

    public void setTdaCertificateNo(String tdaCertificateNo) {
        this.tdaCertificateNo = tdaCertificateNo;
    }

    public BigDecimal getAcctLevelIntRate() {
        return acctLevelIntRate;
    }

    public void setAcctLevelIntRate(BigDecimal acctLevelIntRate) {
        this.acctLevelIntRate = acctLevelIntRate;
    }

    public String getLostNo() {
        return lostNo;
    }

    public void setLostNo(String lostNo) {
        this.lostNo = lostNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public BigDecimal getDebtAmt() {
        return debtAmt;
    }

    public void setDebtAmt(BigDecimal debtAmt) {
        this.debtAmt = debtAmt;
    }

    public BigDecimal getPrincipalAmt() {
        return principalAmt;
    }

    public void setPrincipalAmt(BigDecimal principalAmt) {
        this.principalAmt = principalAmt;
    }

    public BigDecimal getPrincipalAmtActual() {
        return principalAmtActual;
    }

    public void setPrincipalAmtActual(BigDecimal principalAmtActual) {
        this.principalAmtActual = principalAmtActual;
    }

    public BigDecimal getGrossInterestAmt() {
        return grossInterestAmt;
    }

    public void setGrossInterestAmt(BigDecimal grossInterestAmt) {
        this.grossInterestAmt = grossInterestAmt;
    }

    public BigDecimal getIntAdj() {
        return intAdj;
    }

    public void setIntAdj(BigDecimal intAdj) {
        this.intAdj = intAdj;
    }

    public BigDecimal getIntAdjCtd() {
        return intAdjCtd;
    }

    public void setIntAdjCtd(BigDecimal intAdjCtd) {
        this.intAdjCtd = intAdjCtd;
    }

    public BigDecimal getNetInterestAmt() {
        return netInterestAmt;
    }

    public void setNetInterestAmt(BigDecimal netInterestAmt) {
        this.netInterestAmt = netInterestAmt;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public BigDecimal getDebtIntRate() {
        return debtIntRate;
    }

    public void setDebtIntRate(BigDecimal debtIntRate) {
        this.debtIntRate = debtIntRate;
    }

    public String getTranScene() {
        return tranScene;
    }

    public void setTranScene(String tranScene) {
        this.tranScene = tranScene;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbTdaHistEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账户开户日期 */
    private java.util.Date acctOpenDate;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 定期账户交易日期 */
    @NotNull
    private java.util.Date acctMovtDate;
    /** 转存类型 */
    private MovtStatus movtStatus;
    /** 续存期数 */
    private Integer addTerm;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 自动转存类型 */
    private AutoRenewRollover autoRenewRollover;
    /** 部分本金转存标志 */
    private IndividualFlag partialRenewRoll;
    /** 部分本金转存金额 */
    private BigDecimal partialRenewAmt;
    /** 允许增加本金标志 */
    private IndividualFlag addtlPrincipal;
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
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;

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

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.util.Date getAcctMovtDate() {
        return acctMovtDate;
    }

    public void setAcctMovtDate(java.util.Date acctMovtDate) {
        this.acctMovtDate = acctMovtDate;
    }

    public MovtStatus getMovtStatus() {
        return movtStatus;
    }

    public void setMovtStatus(MovtStatus movtStatus) {
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

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public AutoRenewRollover getAutoRenewRollover() {
        return autoRenewRollover;
    }

    public void setAutoRenewRollover(AutoRenewRollover autoRenewRollover) {
        this.autoRenewRollover = autoRenewRollover;
    }

    public IndividualFlag getPartialRenewRoll() {
        return partialRenewRoll;
    }

    public void setPartialRenewRoll(IndividualFlag partialRenewRoll) {
        this.partialRenewRoll = partialRenewRoll;
    }

    public BigDecimal getPartialRenewAmt() {
        return partialRenewAmt;
    }

    public void setPartialRenewAmt(BigDecimal partialRenewAmt) {
        this.partialRenewAmt = partialRenewAmt;
    }

    public IndividualFlag getAddtlPrincipal() {
        return addtlPrincipal;
    }

    public void setAddtlPrincipal(IndividualFlag addtlPrincipal) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
package com.dcits.depsit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBusAgreementOverdraft {
    /** 对公存款合约类型 */
    private String rbBusAgreementType;
    /** 协议签约状态 */
    private String greementSignStatus;
    /** 摊销日 */
    private String amortizeDay;
    /** 贷款内部键编码 */
    private Integer loanInternalKey;
    /** 基准利率 */
    private BigDecimal intBasisRate;
    /** 透支额度 */
    private BigDecimal odAmt;
    /** 结束日期 */
    private Date endDate;
    /** 透支模式标志 */
    private String odMode;
    /** 开始日期 */
    private Date startDate;
    /** 透支期限类型 */
    private String odTermType;
    /** 费用摊销开始日 */
    private Date amortizeStartDate;
    /** 产品编号 */
    private String prodNo;
    /** 透支方式 */
    private String odMethod;
    /** 法透到期日计算规则 */
    private String odMaturityRule;
    /** 摊销时间类型 */
    private String amortizeTimeType;
    /** 白名单客户名称集合 */
    private String whiteClientName;
    /** 费用类型 */
    private String feeType;
    /** 费率 */
    private BigDecimal feeRate;
    /** 手续费收取方式 */
    private String feeTakenMode;
    /** 透支产品编号 */
    private String odProdNo;
    /** 摊销月 */
    private String amortizeMonth;
    /** 费用摊销截止日期 */
    private Date amortizeEndDate;
    /** 靠档跨月跨季执行利率 */
    private BigDecimal crossPeriodRate;
    /** 透支还款标志 */
    private String odPayMethod;
    /** 透支币种 */
    private String odCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 协议编号 */
    private String agreementId;
    /** 逾期利率 */
    private BigDecimal pastDueRate;
    /** 透支期限 */
    private String odTerm;
    /** 起透金额 */
    private BigDecimal odStartAmt;
    /** 账户币种 */
    private String acctCcy;
    /** 收费频率 */
    private String chargePeriodFreq;
    /** 摊销频率 */
    private String amortizePeriodFreq;
    /** 账号 */
    private String baseAcctNo;
    /** 摊销标志 */
    private String profitAmortizeFlag;
    /** 透支免息期 */
    private String odGracePeriod;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 协议签约生效状态 */
    private String agreementSignEffectStatus;
    /** 费用收取类型 */
    private String feeChargeType;
    /** 靠档跨月季标识 */
    private String isOverMonthSeasonOd;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;

    public String getRbBusAgreementType() {
        return rbBusAgreementType;
    }

    public void setRbBusAgreementType(String rbBusAgreementType) {
        this.rbBusAgreementType = rbBusAgreementType;
    }

    public String getGreementSignStatus() {
        return greementSignStatus;
    }

    public void setGreementSignStatus(String greementSignStatus) {
        this.greementSignStatus = greementSignStatus;
    }

    public String getAmortizeDay() {
        return amortizeDay;
    }

    public void setAmortizeDay(String amortizeDay) {
        this.amortizeDay = amortizeDay;
    }

    public Integer getLoanInternalKey() {
        return loanInternalKey;
    }

    public void setLoanInternalKey(Integer loanInternalKey) {
        this.loanInternalKey = loanInternalKey;
    }

    public BigDecimal getIntBasisRate() {
        return intBasisRate;
    }

    public void setIntBasisRate(BigDecimal intBasisRate) {
        this.intBasisRate = intBasisRate;
    }

    public BigDecimal getOdAmt() {
        return odAmt;
    }

    public void setOdAmt(BigDecimal odAmt) {
        this.odAmt = odAmt;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOdMode() {
        return odMode;
    }

    public void setOdMode(String odMode) {
        this.odMode = odMode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getOdTermType() {
        return odTermType;
    }

    public void setOdTermType(String odTermType) {
        this.odTermType = odTermType;
    }

    public Date getAmortizeStartDate() {
        return amortizeStartDate;
    }

    public void setAmortizeStartDate(Date amortizeStartDate) {
        this.amortizeStartDate = amortizeStartDate;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getOdMethod() {
        return odMethod;
    }

    public void setOdMethod(String odMethod) {
        this.odMethod = odMethod;
    }

    public String getOdMaturityRule() {
        return odMaturityRule;
    }

    public void setOdMaturityRule(String odMaturityRule) {
        this.odMaturityRule = odMaturityRule;
    }

    public String getAmortizeTimeType() {
        return amortizeTimeType;
    }

    public void setAmortizeTimeType(String amortizeTimeType) {
        this.amortizeTimeType = amortizeTimeType;
    }

    public String getWhiteClientName() {
        return whiteClientName;
    }

    public void setWhiteClientName(String whiteClientName) {
        this.whiteClientName = whiteClientName;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public String getFeeTakenMode() {
        return feeTakenMode;
    }

    public void setFeeTakenMode(String feeTakenMode) {
        this.feeTakenMode = feeTakenMode;
    }

    public String getOdProdNo() {
        return odProdNo;
    }

    public void setOdProdNo(String odProdNo) {
        this.odProdNo = odProdNo;
    }

    public String getAmortizeMonth() {
        return amortizeMonth;
    }

    public void setAmortizeMonth(String amortizeMonth) {
        this.amortizeMonth = amortizeMonth;
    }

    public Date getAmortizeEndDate() {
        return amortizeEndDate;
    }

    public void setAmortizeEndDate(Date amortizeEndDate) {
        this.amortizeEndDate = amortizeEndDate;
    }

    public BigDecimal getCrossPeriodRate() {
        return crossPeriodRate;
    }

    public void setCrossPeriodRate(BigDecimal crossPeriodRate) {
        this.crossPeriodRate = crossPeriodRate;
    }

    public String getOdPayMethod() {
        return odPayMethod;
    }

    public void setOdPayMethod(String odPayMethod) {
        this.odPayMethod = odPayMethod;
    }

    public String getOdCcy() {
        return odCcy;
    }

    public void setOdCcy(String odCcy) {
        this.odCcy = odCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public BigDecimal getPastDueRate() {
        return pastDueRate;
    }

    public void setPastDueRate(BigDecimal pastDueRate) {
        this.pastDueRate = pastDueRate;
    }

    public String getOdTerm() {
        return odTerm;
    }

    public void setOdTerm(String odTerm) {
        this.odTerm = odTerm;
    }

    public BigDecimal getOdStartAmt() {
        return odStartAmt;
    }

    public void setOdStartAmt(BigDecimal odStartAmt) {
        this.odStartAmt = odStartAmt;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getChargePeriodFreq() {
        return chargePeriodFreq;
    }

    public void setChargePeriodFreq(String chargePeriodFreq) {
        this.chargePeriodFreq = chargePeriodFreq;
    }

    public String getAmortizePeriodFreq() {
        return amortizePeriodFreq;
    }

    public void setAmortizePeriodFreq(String amortizePeriodFreq) {
        this.amortizePeriodFreq = amortizePeriodFreq;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getProfitAmortizeFlag() {
        return profitAmortizeFlag;
    }

    public void setProfitAmortizeFlag(String profitAmortizeFlag) {
        this.profitAmortizeFlag = profitAmortizeFlag;
    }

    public String getOdGracePeriod() {
        return odGracePeriod;
    }

    public void setOdGracePeriod(String odGracePeriod) {
        this.odGracePeriod = odGracePeriod;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getAgreementSignEffectStatus() {
        return agreementSignEffectStatus;
    }

    public void setAgreementSignEffectStatus(String agreementSignEffectStatus) {
        this.agreementSignEffectStatus = agreementSignEffectStatus;
    }

    public String getFeeChargeType() {
        return feeChargeType;
    }

    public void setFeeChargeType(String feeChargeType) {
        this.feeChargeType = feeChargeType;
    }

    public String getIsOverMonthSeasonOd() {
        return isOverMonthSeasonOd;
    }

    public void setIsOverMonthSeasonOd(String isOverMonthSeasonOd) {
        this.isOverMonthSeasonOd = isOverMonthSeasonOd;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }
}
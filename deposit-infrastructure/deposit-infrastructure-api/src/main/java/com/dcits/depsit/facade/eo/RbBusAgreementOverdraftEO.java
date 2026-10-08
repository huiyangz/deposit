package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AgreementSignEffectStatus;
import com.dcits.depsit.enums.AmortizeTimeType;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.FeeTakenMode;
import com.dcits.depsit.enums.FeeType;
import com.dcits.depsit.enums.GreementSignStatus;
import com.dcits.depsit.enums.IsOverMonthSeasonOd;
import com.dcits.depsit.enums.OdMaturityRule;
import com.dcits.depsit.enums.OdMethod;
import com.dcits.depsit.enums.OdMode;
import com.dcits.depsit.enums.OdPayMethod;
import com.dcits.depsit.enums.RbBusAgreementType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TermType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusAgreementOverdraftEO {
    /** 对公存款合约类型 */
    private RbBusAgreementType rbBusAgreementType;
    /** 协议签约状态 */
    private GreementSignStatus greementSignStatus;
    /** 摊销日 */
    private String amortizeDay;
    /** 贷款内部键编码 */
    @NotNull
    private Integer loanInternalKey;
    /** 基准利率 */
    private BigDecimal intBasisRate;
    /** 透支额度 */
    private BigDecimal odAmt;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 透支模式标志 */
    private OdMode odMode;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 透支期限类型 */
    private TermType odTermType;
    /** 费用摊销开始日 */
    private java.util.Date amortizeStartDate;
    /** 产品编号 */
    private String prodNo;
    /** 透支方式 */
    private OdMethod odMethod;
    /** 法透到期日计算规则 */
    private OdMaturityRule odMaturityRule;
    /** 摊销时间类型 */
    private AmortizeTimeType amortizeTimeType;
    /** 白名单客户名称集合 */
    private String whiteClientName;
    /** 费用类型 */
    private FeeType feeType;
    /** 费率 */
    private BigDecimal feeRate;
    /** 手续费收取方式 */
    private FeeTakenMode feeTakenMode;
    /** 透支产品编号 */
    private String odProdNo;
    /** 摊销月 */
    private String amortizeMonth;
    /** 费用摊销截止日期 */
    private java.util.Date amortizeEndDate;
    /** 靠档跨月跨季执行利率 */
    private BigDecimal crossPeriodRate;
    /** 透支还款标志 */
    private OdPayMethod odPayMethod;
    /** 透支币种 */
    private Ccy odCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 逾期利率 */
    private BigDecimal pastDueRate;
    /** 透支期限 */
    private String odTerm;
    /** 起透金额 */
    private BigDecimal odStartAmt;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 收费频率 */
    private RollFreq chargePeriodFreq;
    /** 摊销频率 */
    private RollFreq amortizePeriodFreq;
    /** 账号 */
    private String baseAcctNo;
    /** 摊销标志 */
    private String profitAmortizeFlag;
    /** 透支免息期 */
    private RollFreq odGracePeriod;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 协议签约生效状态 */
    private AgreementSignEffectStatus agreementSignEffectStatus;
    /** 费用收取类型 */
    private FeeTakenMode feeChargeType;
    /** 靠档跨月季标识 */
    private IsOverMonthSeasonOd isOverMonthSeasonOd;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;

    public RbBusAgreementType getRbBusAgreementType() {
        return rbBusAgreementType;
    }

    public void setRbBusAgreementType(RbBusAgreementType rbBusAgreementType) {
        this.rbBusAgreementType = rbBusAgreementType;
    }

    public GreementSignStatus getGreementSignStatus() {
        return greementSignStatus;
    }

    public void setGreementSignStatus(GreementSignStatus greementSignStatus) {
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

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public OdMode getOdMode() {
        return odMode;
    }

    public void setOdMode(OdMode odMode) {
        this.odMode = odMode;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public TermType getOdTermType() {
        return odTermType;
    }

    public void setOdTermType(TermType odTermType) {
        this.odTermType = odTermType;
    }

    public java.util.Date getAmortizeStartDate() {
        return amortizeStartDate;
    }

    public void setAmortizeStartDate(java.util.Date amortizeStartDate) {
        this.amortizeStartDate = amortizeStartDate;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public OdMethod getOdMethod() {
        return odMethod;
    }

    public void setOdMethod(OdMethod odMethod) {
        this.odMethod = odMethod;
    }

    public OdMaturityRule getOdMaturityRule() {
        return odMaturityRule;
    }

    public void setOdMaturityRule(OdMaturityRule odMaturityRule) {
        this.odMaturityRule = odMaturityRule;
    }

    public AmortizeTimeType getAmortizeTimeType() {
        return amortizeTimeType;
    }

    public void setAmortizeTimeType(AmortizeTimeType amortizeTimeType) {
        this.amortizeTimeType = amortizeTimeType;
    }

    public String getWhiteClientName() {
        return whiteClientName;
    }

    public void setWhiteClientName(String whiteClientName) {
        this.whiteClientName = whiteClientName;
    }

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public FeeTakenMode getFeeTakenMode() {
        return feeTakenMode;
    }

    public void setFeeTakenMode(FeeTakenMode feeTakenMode) {
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

    public java.util.Date getAmortizeEndDate() {
        return amortizeEndDate;
    }

    public void setAmortizeEndDate(java.util.Date amortizeEndDate) {
        this.amortizeEndDate = amortizeEndDate;
    }

    public BigDecimal getCrossPeriodRate() {
        return crossPeriodRate;
    }

    public void setCrossPeriodRate(BigDecimal crossPeriodRate) {
        this.crossPeriodRate = crossPeriodRate;
    }

    public OdPayMethod getOdPayMethod() {
        return odPayMethod;
    }

    public void setOdPayMethod(OdPayMethod odPayMethod) {
        this.odPayMethod = odPayMethod;
    }

    public Ccy getOdCcy() {
        return odCcy;
    }

    public void setOdCcy(Ccy odCcy) {
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

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public RollFreq getChargePeriodFreq() {
        return chargePeriodFreq;
    }

    public void setChargePeriodFreq(RollFreq chargePeriodFreq) {
        this.chargePeriodFreq = chargePeriodFreq;
    }

    public RollFreq getAmortizePeriodFreq() {
        return amortizePeriodFreq;
    }

    public void setAmortizePeriodFreq(RollFreq amortizePeriodFreq) {
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

    public RollFreq getOdGracePeriod() {
        return odGracePeriod;
    }

    public void setOdGracePeriod(RollFreq odGracePeriod) {
        this.odGracePeriod = odGracePeriod;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public AgreementSignEffectStatus getAgreementSignEffectStatus() {
        return agreementSignEffectStatus;
    }

    public void setAgreementSignEffectStatus(AgreementSignEffectStatus agreementSignEffectStatus) {
        this.agreementSignEffectStatus = agreementSignEffectStatus;
    }

    public FeeTakenMode getFeeChargeType() {
        return feeChargeType;
    }

    public void setFeeChargeType(FeeTakenMode feeChargeType) {
        this.feeChargeType = feeChargeType;
    }

    public IsOverMonthSeasonOd getIsOverMonthSeasonOd() {
        return isOverMonthSeasonOd;
    }

    public void setIsOverMonthSeasonOd(IsOverMonthSeasonOd isOverMonthSeasonOd) {
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
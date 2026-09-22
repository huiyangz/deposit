package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.YearBasis;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctEventRegisterEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 账户开户日期 */
    private java.util.Date acctOpenDate;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 客户类型 */
    private ClientType clientType;
    /** 转存类型 */
    private MovtStatus movtStatus;
    /** 利息分类 */
    @NotNull
    private IntClass intClass;
    /** 利率类型 */
    private IntType intType;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 利息调整金额 */
    private BigDecimal intAdj;
    /** 当日利息调整金额 */
    private BigDecimal intAdjCtd;
    /** 账户执行利率 */
    private BigDecimal acctLevelIntRate;
    /** 结息总金额 */
    private BigDecimal grossInterestAmt;
    /** 计算利息 */
    private BigDecimal calcIntAmt;
    /** 上一结息日期 */
    private java.util.Date lastCycleDate;
    /** 利息资本化标志 */
    private IndividualFlag intCapFlag;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 金额类型 */
    private AmtType amtType;
    /** 本金 */
    private BigDecimal principalAmt;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 支取执行利率 */
    private BigDecimal debtIntRate;
    /** 净利息 */
    private BigDecimal netInterestAmt;
    /** 计息天数 */
    private Integer calcDays;
    /** 税率 */
    private BigDecimal taxRate;
    /** 税率类型 */
    private TaxType taxType;
    /** 税金 */
    private BigDecimal taxAmt;
    /** 交易参考号 */
    private String reference;
    /** 过账标志 */
    private IndividualFlag glPostedFlag;
    /** 冲正日期 */
    private java.util.Date reversalDate;
    /** 摘要 */
    private String narrative;
    /** 源模块 */
    private SourceModule sourceModule;
    /** 业务处理状态 */
    private TranStatus tranStatus;
    /** 打印次数 */
    private Integer printCnt;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 业务流水号 */
    private String busSeqNo;
    /** 计息开始日期 */
    private java.util.Date calcBeginDate;
    /** 月基准 */
    private MonthBasis monthBasis;
    /** 年基准天数 */
    private YearBasis yearBasis;
    /** 对账代码 */
    private String reaccountCd;
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

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
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

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public MovtStatus getMovtStatus() {
        return movtStatus;
    }

    public void setMovtStatus(MovtStatus movtStatus) {
        this.movtStatus = movtStatus;
    }

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
        this.intClass = intClass;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
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

    public BigDecimal getAcctLevelIntRate() {
        return acctLevelIntRate;
    }

    public void setAcctLevelIntRate(BigDecimal acctLevelIntRate) {
        this.acctLevelIntRate = acctLevelIntRate;
    }

    public BigDecimal getGrossInterestAmt() {
        return grossInterestAmt;
    }

    public void setGrossInterestAmt(BigDecimal grossInterestAmt) {
        this.grossInterestAmt = grossInterestAmt;
    }

    public BigDecimal getCalcIntAmt() {
        return calcIntAmt;
    }

    public void setCalcIntAmt(BigDecimal calcIntAmt) {
        this.calcIntAmt = calcIntAmt;
    }

    public java.util.Date getLastCycleDate() {
        return lastCycleDate;
    }

    public void setLastCycleDate(java.util.Date lastCycleDate) {
        this.lastCycleDate = lastCycleDate;
    }

    public IndividualFlag getIntCapFlag() {
        return intCapFlag;
    }

    public void setIntCapFlag(IndividualFlag intCapFlag) {
        this.intCapFlag = intCapFlag;
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

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public BigDecimal getPrincipalAmt() {
        return principalAmt;
    }

    public void setPrincipalAmt(BigDecimal principalAmt) {
        this.principalAmt = principalAmt;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getDebtIntRate() {
        return debtIntRate;
    }

    public void setDebtIntRate(BigDecimal debtIntRate) {
        this.debtIntRate = debtIntRate;
    }

    public BigDecimal getNetInterestAmt() {
        return netInterestAmt;
    }

    public void setNetInterestAmt(BigDecimal netInterestAmt) {
        this.netInterestAmt = netInterestAmt;
    }

    public Integer getCalcDays() {
        return calcDays;
    }

    public void setCalcDays(Integer calcDays) {
        this.calcDays = calcDays;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public IndividualFlag getGlPostedFlag() {
        return glPostedFlag;
    }

    public void setGlPostedFlag(IndividualFlag glPostedFlag) {
        this.glPostedFlag = glPostedFlag;
    }

    public java.util.Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(java.util.Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public Integer getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(Integer printCnt) {
        this.printCnt = printCnt;
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

    public String getBusSeqNo() {
        return busSeqNo;
    }

    public void setBusSeqNo(String busSeqNo) {
        this.busSeqNo = busSeqNo;
    }

    public java.util.Date getCalcBeginDate() {
        return calcBeginDate;
    }

    public void setCalcBeginDate(java.util.Date calcBeginDate) {
        this.calcBeginDate = calcBeginDate;
    }

    public MonthBasis getMonthBasis() {
        return monthBasis;
    }

    public void setMonthBasis(MonthBasis monthBasis) {
        this.monthBasis = monthBasis;
    }

    public YearBasis getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(YearBasis yearBasis) {
        this.yearBasis = yearBasis;
    }

    public String getReaccountCd() {
        return reaccountCd;
    }

    public void setReaccountCd(String reaccountCd) {
        this.reaccountCd = reaccountCd;
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
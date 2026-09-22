package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpenNumType;
import com.dcits.deposit.enums.OthAcctSort;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RenewAcctType;
import com.dcits.deposit.enums.RenewType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAgreementSweepEO {
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 序号 */
    private String seqNo;
    /** 贷款还款计划编号 */
    private String schedNo;
    /** 合约类型1 */
    private AgreementType agreementType;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户名称 */
    private String acctName;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 账户利率浮动百分比 */
    private BigDecimal acctPercentRate;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 最低转存金额 */
    private BigDecimal renewMinAmt;
    /** 约定转存方式 */
    private RenewType renewType;
    /** 转存方式 */
    private AutoRenewRollover renewMethod;
    /** 约定转账金额倍数 */
    private Integer renewMultiple;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手产品编号 */
    private String othProdType;
    /** 对手账户币种 */
    private AcctCcy othAcctCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 转入方账户类型 */
    private OthAcctSort othAcctSort;
    /** 账户用途 */
    private ReasonCode reasonCode;
    /** 余额比例 */
    private BigDecimal balRatio;
    /** 优先级 */
    private String priority;
    /** 签约日期 */
    private java.util.Date signDate;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 协议状态 */
    private AgreementStatus agreementStatus;
    /** 累计金额 */
    private BigDecimal sumAmt;
    /** 约定转账基本单位金额 */
    private BigDecimal tranBaseAmt;
    /** 累计追踪次数 */
    private Integer sumConCount;
    /** 累计转账次数 */
    private Integer sumCount;
    /** 持续划款次数 */
    private Integer conTransferCount;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 摘要 */
    private String narrative;
    /** 转存账户类型 */
    private RenewAcctType renewAcctType;
    /** 多笔开立标志 */
    private OpenNumType openNumType;
    /** 自动结清标志 */
    private IndividualFlag autoSettleFlag;
    /** 本息入账账号 */
    private String priintBaseAcctNo;
    /** 本息入账账户序号 */
    private String priintAcctSeqNo;
    /** 本息入账产品编号 */
    private String priintProdType;
    /** 本息入账币种 */
    private AcctCcy priintCcy;
    /** 系统内理财固定金额 */
    private BigDecimal finFixedAmt;
    /** 保底金额 */
    private BigDecimal lowestAmt;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 结算账户产品类型 */
    private String settleProdType;
    /** 交易账号币种 */
    private AcctCcy settleAcctCcy;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 出账日累计限额 */
    private BigDecimal limitAmtOutDay;
    /** 月累计限额 */
    private BigDecimal monthLimit;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 对手客户号 */
    private String othClientNo;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getSchedNo() {
        return schedNo;
    }

    public void setSchedNo(String schedNo) {
        this.schedNo = schedNo;
    }

    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
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

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public BigDecimal getAcctFixedRate() {
        return acctFixedRate;
    }

    public void setAcctFixedRate(BigDecimal acctFixedRate) {
        this.acctFixedRate = acctFixedRate;
    }

    public BigDecimal getAcctPercentRate() {
        return acctPercentRate;
    }

    public void setAcctPercentRate(BigDecimal acctPercentRate) {
        this.acctPercentRate = acctPercentRate;
    }

    public BigDecimal getAcctSpreadRate() {
        return acctSpreadRate;
    }

    public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
        this.acctSpreadRate = acctSpreadRate;
    }

    public BigDecimal getRenewMinAmt() {
        return renewMinAmt;
    }

    public void setRenewMinAmt(BigDecimal renewMinAmt) {
        this.renewMinAmt = renewMinAmt;
    }

    public RenewType getRenewType() {
        return renewType;
    }

    public void setRenewType(RenewType renewType) {
        this.renewType = renewType;
    }

    public AutoRenewRollover getRenewMethod() {
        return renewMethod;
    }

    public void setRenewMethod(AutoRenewRollover renewMethod) {
        this.renewMethod = renewMethod;
    }

    public Integer getRenewMultiple() {
        return renewMultiple;
    }

    public void setRenewMultiple(Integer renewMultiple) {
        this.renewMultiple = renewMultiple;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public Integer getOthInternalKey() {
        return othInternalKey;
    }

    public void setOthInternalKey(Integer othInternalKey) {
        this.othInternalKey = othInternalKey;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public String getOthProdType() {
        return othProdType;
    }

    public void setOthProdType(String othProdType) {
        this.othProdType = othProdType;
    }

    public AcctCcy getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(AcctCcy othAcctCcy) {
        this.othAcctCcy = othAcctCcy;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getOthBankCode() {
        return othBankCode;
    }

    public void setOthBankCode(String othBankCode) {
        this.othBankCode = othBankCode;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
    }

    public OthAcctSort getOthAcctSort() {
        return othAcctSort;
    }

    public void setOthAcctSort(OthAcctSort othAcctSort) {
        this.othAcctSort = othAcctSort;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public BigDecimal getBalRatio() {
        return balRatio;
    }

    public void setBalRatio(BigDecimal balRatio) {
        this.balRatio = balRatio;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public java.util.Date getSignDate() {
        return signDate;
    }

    public void setSignDate(java.util.Date signDate) {
        this.signDate = signDate;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
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

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public AgreementStatus getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(AgreementStatus agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public BigDecimal getSumAmt() {
        return sumAmt;
    }

    public void setSumAmt(BigDecimal sumAmt) {
        this.sumAmt = sumAmt;
    }

    public BigDecimal getTranBaseAmt() {
        return tranBaseAmt;
    }

    public void setTranBaseAmt(BigDecimal tranBaseAmt) {
        this.tranBaseAmt = tranBaseAmt;
    }

    public Integer getSumConCount() {
        return sumConCount;
    }

    public void setSumConCount(Integer sumConCount) {
        this.sumConCount = sumConCount;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }

    public Integer getConTransferCount() {
        return conTransferCount;
    }

    public void setConTransferCount(Integer conTransferCount) {
        this.conTransferCount = conTransferCount;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public RenewAcctType getRenewAcctType() {
        return renewAcctType;
    }

    public void setRenewAcctType(RenewAcctType renewAcctType) {
        this.renewAcctType = renewAcctType;
    }

    public OpenNumType getOpenNumType() {
        return openNumType;
    }

    public void setOpenNumType(OpenNumType openNumType) {
        this.openNumType = openNumType;
    }

    public IndividualFlag getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(IndividualFlag autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public String getPriintBaseAcctNo() {
        return priintBaseAcctNo;
    }

    public void setPriintBaseAcctNo(String priintBaseAcctNo) {
        this.priintBaseAcctNo = priintBaseAcctNo;
    }

    public String getPriintAcctSeqNo() {
        return priintAcctSeqNo;
    }

    public void setPriintAcctSeqNo(String priintAcctSeqNo) {
        this.priintAcctSeqNo = priintAcctSeqNo;
    }

    public String getPriintProdType() {
        return priintProdType;
    }

    public void setPriintProdType(String priintProdType) {
        this.priintProdType = priintProdType;
    }

    public AcctCcy getPriintCcy() {
        return priintCcy;
    }

    public void setPriintCcy(AcctCcy priintCcy) {
        this.priintCcy = priintCcy;
    }

    public BigDecimal getFinFixedAmt() {
        return finFixedAmt;
    }

    public void setFinFixedAmt(BigDecimal finFixedAmt) {
        this.finFixedAmt = finFixedAmt;
    }

    public BigDecimal getLowestAmt() {
        return lowestAmt;
    }

    public void setLowestAmt(BigDecimal lowestAmt) {
        this.lowestAmt = lowestAmt;
    }

    public String getSettleBaseAcctNo() {
        return settleBaseAcctNo;
    }

    public void setSettleBaseAcctNo(String settleBaseAcctNo) {
        this.settleBaseAcctNo = settleBaseAcctNo;
    }

    public String getSettleProdType() {
        return settleProdType;
    }

    public void setSettleProdType(String settleProdType) {
        this.settleProdType = settleProdType;
    }

    public AcctCcy getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(AcctCcy settleAcctCcy) {
        this.settleAcctCcy = settleAcctCcy;
    }

    public String getSettleAcctSeqNo() {
        return settleAcctSeqNo;
    }

    public void setSettleAcctSeqNo(String settleAcctSeqNo) {
        this.settleAcctSeqNo = settleAcctSeqNo;
    }

    public BigDecimal getLimitAmtOutDay() {
        return limitAmtOutDay;
    }

    public void setLimitAmtOutDay(BigDecimal limitAmtOutDay) {
        this.limitAmtOutDay = limitAmtOutDay;
    }

    public BigDecimal getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(BigDecimal monthLimit) {
        this.monthLimit = monthLimit;
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

    public String getOthClientNo() {
        return othClientNo;
    }

    public void setOthClientNo(String othClientNo) {
        this.othClientNo = othClientNo;
    }
}
package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAgreementSweep {
    /** 协议编号 */
    private String agreementId;
    /** 序号 */
    private String seqNo;
    /** 贷款还款计划编号 */
    private String schedNo;
    /** 合约类型1 */
    private String agreementType;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
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
    private String renewType;
    /** 转存方式 */
    private String renewMethod;
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
    private String othAcctCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 转入方账户类型 */
    private String othAcctSort;
    /** 账户用途 */
    private String reasonCode;
    /** 余额比例 */
    private BigDecimal balRatio;
    /** 优先级 */
    private String priority;
    /** 签约日期 */
    private Date signDate;
    /** 开始日期 */
    private Date startDate;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 结束日期 */
    private Date endDate;
    /** 协议状态 */
    private String agreementStatus;
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
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private String company;
    /** 摘要 */
    private String narrative;
    /** 转存账户类型 */
    private String renewAcctType;
    /** 多笔开立标志 */
    private String openNumType;
    /** 自动结清标志 */
    private String autoSettleFlag;
    /** 本息入账账号 */
    private String priintBaseAcctNo;
    /** 本息入账账户序号 */
    private String priintAcctSeqNo;
    /** 本息入账产品编号 */
    private String priintProdType;
    /** 本息入账币种 */
    private String priintCcy;
    /** 系统内理财固定金额 */
    private BigDecimal finFixedAmt;
    /** 保底金额 */
    private BigDecimal lowestAmt;
    /** 结算账号 */
    private String settleBaseAcctNo;
    /** 结算账户产品类型 */
    private String settleProdType;
    /** 交易账号币种 */
    private String settleAcctCcy;
    /** 交易账号序号 */
    private String settleAcctSeqNo;
    /** 出账日累计限额 */
    private BigDecimal limitAmtOutDay;
    /** 月累计限额 */
    private BigDecimal monthLimit;
    /** 最后修改日期 */
    private Date lastChangeDate;
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

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
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

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
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

    public String getRenewType() {
        return renewType;
    }

    public void setRenewType(String renewType) {
        this.renewType = renewType;
    }

    public String getRenewMethod() {
        return renewMethod;
    }

    public void setRenewMethod(String renewMethod) {
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

    public String getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(String othAcctCcy) {
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

    public String getOthAcctSort() {
        return othAcctSort;
    }

    public void setOthAcctSort(String othAcctSort) {
        this.othAcctSort = othAcctSort;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
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

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getRenewAcctType() {
        return renewAcctType;
    }

    public void setRenewAcctType(String renewAcctType) {
        this.renewAcctType = renewAcctType;
    }

    public String getOpenNumType() {
        return openNumType;
    }

    public void setOpenNumType(String openNumType) {
        this.openNumType = openNumType;
    }

    public String getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(String autoSettleFlag) {
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

    public String getPriintCcy() {
        return priintCcy;
    }

    public void setPriintCcy(String priintCcy) {
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

    public String getSettleAcctCcy() {
        return settleAcctCcy;
    }

    public void setSettleAcctCcy(String settleAcctCcy) {
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
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
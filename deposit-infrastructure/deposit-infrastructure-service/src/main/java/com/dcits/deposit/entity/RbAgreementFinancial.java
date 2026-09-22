package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAgreementFinancial {
    /** 协议编号 */
    private String agreementId;
    /** 合约类型1 */
    private String agreementType;
    /** 理财产品编号 */
    private String finProdType;
    /** 理财产品描述 */
    private String finProdDesc;
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
    /** 客户号 */
    private String clientNo;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 系统内理财固定金额 */
    private BigDecimal finFixedAmt;
    /** 合约存款留存金额 */
    private BigDecimal remainAmt;
    /** 最小起存金额 */
    private BigDecimal intMinAmt;
    /** 系统内理财划转频率 */
    private String transferFreq;
    /** 转存开始日期 */
    private Date transferStartDate;
    /** 系统内理财划转频率类型 */
    private String transferFreqType;
    /** 系统内理财划转结束日期 */
    private Date transferEndDate;
    /** 转存日 */
    private String transferDay;
    /** 协议状态 */
    private String agreementStatus;
    /** 下次划转日期 */
    private Date nextTransferDate;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 自动转存类型 */
    private String autoRenewRollover;
    /** 定期账户序列号 */
    private String tdaAcctSeqNo;
    /** 定期账号 */
    private String tdaBaseAcctNo;
    /** 定期账户产品编号 */
    private String tdaAcctProdType;
    /** 定期账户币种 */
    private String tdaAcctCcy;
    /** 系统内理财金额 */
    private BigDecimal financialAmount;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 失败总次数 */
    private Integer failureTotalTimes;
    /** 累计失败次数 */
    private Integer failureTimes;
    /** 累积成功次数 */
    private Integer successTimes;
    /** 成功总次数 */
    private Integer successTotalTimes;
    /** 自动延期标志 */
    private String autoExtend;
    /** 上一划转日期 */
    private Date lastTransferDate;
    /** 签约机构号 */
    private String signBranch;
    /** 本汇票签约柜员号 */
    private String signUserId;
    /** 解约柜员号 */
    private String outSignUserId;
    /** 解约机构号 */
    private String outSignBranch;
    /** 客户经理 */
    private String acctExec;
    /** 客户经理名称 */
    private String acctExecName;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 自动结清标志 */
    private String autoSettleFlag;
    /** 存款性质 */
    private String depositNature;
    /** 交易失败原因 */
    private String failureReason;
    /** 解约操作日期 */
    private Date unsignOperateDate;
    /** 摊销时间类型 */
    private String amortizeTimeType;
    /** 费用类型 */
    private String feeType;
    /** 基准利率 */
    private BigDecimal intBasisRate;
    /** 逾期利率 */
    private BigDecimal pastDueRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 上一转存流水号 */
    private String lastTransferReference;
    /** 签约流水号 */
    private String signReference;
    /** 解约流水号 */
    private String unsignReference;
    /** 透支模式标志 */
    private String odMode;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public String getFinProdType() {
        return finProdType;
    }

    public void setFinProdType(String finProdType) {
        this.finProdType = finProdType;
    }

    public String getFinProdDesc() {
        return finProdDesc;
    }

    public void setFinProdDesc(String finProdDesc) {
        this.finProdDesc = finProdDesc;
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

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getFinFixedAmt() {
        return finFixedAmt;
    }

    public void setFinFixedAmt(BigDecimal finFixedAmt) {
        this.finFixedAmt = finFixedAmt;
    }

    public BigDecimal getRemainAmt() {
        return remainAmt;
    }

    public void setRemainAmt(BigDecimal remainAmt) {
        this.remainAmt = remainAmt;
    }

    public BigDecimal getIntMinAmt() {
        return intMinAmt;
    }

    public void setIntMinAmt(BigDecimal intMinAmt) {
        this.intMinAmt = intMinAmt;
    }

    public String getTransferFreq() {
        return transferFreq;
    }

    public void setTransferFreq(String transferFreq) {
        this.transferFreq = transferFreq;
    }

    public Date getTransferStartDate() {
        return transferStartDate;
    }

    public void setTransferStartDate(Date transferStartDate) {
        this.transferStartDate = transferStartDate;
    }

    public String getTransferFreqType() {
        return transferFreqType;
    }

    public void setTransferFreqType(String transferFreqType) {
        this.transferFreqType = transferFreqType;
    }

    public Date getTransferEndDate() {
        return transferEndDate;
    }

    public void setTransferEndDate(Date transferEndDate) {
        this.transferEndDate = transferEndDate;
    }

    public String getTransferDay() {
        return transferDay;
    }

    public void setTransferDay(String transferDay) {
        this.transferDay = transferDay;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public Date getNextTransferDate() {
        return nextTransferDate;
    }

    public void setNextTransferDate(Date nextTransferDate) {
        this.nextTransferDate = nextTransferDate;
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

    public String getTdaAcctSeqNo() {
        return tdaAcctSeqNo;
    }

    public void setTdaAcctSeqNo(String tdaAcctSeqNo) {
        this.tdaAcctSeqNo = tdaAcctSeqNo;
    }

    public String getTdaBaseAcctNo() {
        return tdaBaseAcctNo;
    }

    public void setTdaBaseAcctNo(String tdaBaseAcctNo) {
        this.tdaBaseAcctNo = tdaBaseAcctNo;
    }

    public String getTdaAcctProdType() {
        return tdaAcctProdType;
    }

    public void setTdaAcctProdType(String tdaAcctProdType) {
        this.tdaAcctProdType = tdaAcctProdType;
    }

    public String getTdaAcctCcy() {
        return tdaAcctCcy;
    }

    public void setTdaAcctCcy(String tdaAcctCcy) {
        this.tdaAcctCcy = tdaAcctCcy;
    }

    public BigDecimal getFinancialAmount() {
        return financialAmount;
    }

    public void setFinancialAmount(BigDecimal financialAmount) {
        this.financialAmount = financialAmount;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Integer getFailureTotalTimes() {
        return failureTotalTimes;
    }

    public void setFailureTotalTimes(Integer failureTotalTimes) {
        this.failureTotalTimes = failureTotalTimes;
    }

    public Integer getFailureTimes() {
        return failureTimes;
    }

    public void setFailureTimes(Integer failureTimes) {
        this.failureTimes = failureTimes;
    }

    public Integer getSuccessTimes() {
        return successTimes;
    }

    public void setSuccessTimes(Integer successTimes) {
        this.successTimes = successTimes;
    }

    public Integer getSuccessTotalTimes() {
        return successTotalTimes;
    }

    public void setSuccessTotalTimes(Integer successTotalTimes) {
        this.successTotalTimes = successTotalTimes;
    }

    public String getAutoExtend() {
        return autoExtend;
    }

    public void setAutoExtend(String autoExtend) {
        this.autoExtend = autoExtend;
    }

    public Date getLastTransferDate() {
        return lastTransferDate;
    }

    public void setLastTransferDate(Date lastTransferDate) {
        this.lastTransferDate = lastTransferDate;
    }

    public String getSignBranch() {
        return signBranch;
    }

    public void setSignBranch(String signBranch) {
        this.signBranch = signBranch;
    }

    public String getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(String signUserId) {
        this.signUserId = signUserId;
    }

    public String getOutSignUserId() {
        return outSignUserId;
    }

    public void setOutSignUserId(String outSignUserId) {
        this.outSignUserId = outSignUserId;
    }

    public String getOutSignBranch() {
        return outSignBranch;
    }

    public void setOutSignBranch(String outSignBranch) {
        this.outSignBranch = outSignBranch;
    }

    public String getAcctExec() {
        return acctExec;
    }

    public void setAcctExec(String acctExec) {
        this.acctExec = acctExec;
    }

    public String getAcctExecName() {
        return acctExecName;
    }

    public void setAcctExecName(String acctExecName) {
        this.acctExecName = acctExecName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(String autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public String getDepositNature() {
        return depositNature;
    }

    public void setDepositNature(String depositNature) {
        this.depositNature = depositNature;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Date getUnsignOperateDate() {
        return unsignOperateDate;
    }

    public void setUnsignOperateDate(Date unsignOperateDate) {
        this.unsignOperateDate = unsignOperateDate;
    }

    public String getAmortizeTimeType() {
        return amortizeTimeType;
    }

    public void setAmortizeTimeType(String amortizeTimeType) {
        this.amortizeTimeType = amortizeTimeType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getIntBasisRate() {
        return intBasisRate;
    }

    public void setIntBasisRate(BigDecimal intBasisRate) {
        this.intBasisRate = intBasisRate;
    }

    public BigDecimal getPastDueRate() {
        return pastDueRate;
    }

    public void setPastDueRate(BigDecimal pastDueRate) {
        this.pastDueRate = pastDueRate;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public String getLastTransferReference() {
        return lastTransferReference;
    }

    public void setLastTransferReference(String lastTransferReference) {
        this.lastTransferReference = lastTransferReference;
    }

    public String getSignReference() {
        return signReference;
    }

    public void setSignReference(String signReference) {
        this.signReference = signReference;
    }

    public String getUnsignReference() {
        return unsignReference;
    }

    public void setUnsignReference(String unsignReference) {
        this.unsignReference = unsignReference;
    }

    public String getOdMode() {
        return odMode;
    }

    public void setOdMode(String odMode) {
        this.odMode = odMode;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
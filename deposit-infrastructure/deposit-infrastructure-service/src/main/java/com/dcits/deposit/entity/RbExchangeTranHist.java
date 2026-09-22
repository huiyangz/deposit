package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbExchangeTranHist {
    /** 序号 */
    private String seqNo;
    /** 现金交易流水号 */
    private String cashSeqNo;
    /** TAE子流水号 */
    private String taeSubSeqNo;
    /** 结售汇序号 */
    private String exchangeSeqNo;
    /** 贷方账户主键 */
    private Integer depositInternalKey;
    /** 结售汇贷方账号 */
    private String depositBaseAcctNo;
    /** 贷方账户序列号 */
    private String depositAcctSeqNo;
    /** 贷方账户产品类型名称 */
    private String depositProdType;
    /** 贷方余额类型 */
    private String depositBalanceType;
    /** 贷方交易序号 */
    private String depositSeqNo;
    /** 借方账户内部键 */
    private Integer withdrawInternalKey;
    /** 借方账户账号 */
    private String withdrawBaseAcctNo;
    /** 借方账户币种 */
    private String withdrawAcctCcy;
    /** 结售汇借方账户序号 */
    private String withdrawAcctSeqNo;
    /** 借方账户产品类型 */
    private String withdrawProdType;
    /** 借方余额类型 */
    private String withdrawBalanceType;
    /** 借方交易序号 */
    private String withdrawSeqNo;
    /** 客户号 */
    private String clientNo;
    /** 交易类型 */
    private String tranType;
    /** 交易日期 */
    private Date tranDate;
    /** 交易机构号 */
    private String tranBranch;
    /** 冲正日期 */
    private Date reversalDate;
    /** 冲正交易类型 */
    private String reversalTranType;
    /** 结售汇交易状态 */
    private String exchangeTranStatus;
    /** 买卖固定方类型 */
    private String sellBuyInd;
    /** 报价类型 */
    private String quoteType;
    /** 汇率类型 */
    private String rateType;
    /** 买入金额 */
    private BigDecimal buyAmount;
    /** 买入币种 */
    private String buyCcy;
    /** 结售汇买方汇率 */
    private BigDecimal buyRate;
    /** 卖出币种 */
    private String sellCcy;
    /** 卖出金额 */
    private BigDecimal sellAmount;
    /** 卖方汇率 */
    private BigDecimal sellRate;
    /** 执行汇率 */
    private BigDecimal exchRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 基础报价方式 */
    private String baseQuoteType;
    /** 基础汇率类型 */
    private String baseRateType;
    /** 基础汇率 */
    private BigDecimal baseRate;
    /** 基础等值金额 */
    private BigDecimal baseEquivAmt;
    /** 交叉汇率 */
    private BigDecimal crossRate;
    /** 交叉汇率属性 */
    private String crossRateAttr;
    /** 平盘交叉汇率 */
    private BigDecimal uncCrossRate;
    /** 结售汇内部汇率 */
    private BigDecimal innerRate;
    /** 找零等值金额 */
    private BigDecimal changeBaseEquivAmt;
    /** 找零人民币金额 */
    private BigDecimal changeCnyAmount;
    /** 外币找零汇率 */
    private BigDecimal changeRate;
    /** 找零基础报价类型 */
    private String changeBaseQuoteType;
    /** 外币找零报价类型 */
    private String changeQuoteType;
    /** 外币找零汇率类型 */
    private String changeRateType;
    /** 交易参考号 */
    private String reference;
    /** 跟踪参考号 */
    private String traceRefNo;
    /** 渠道类型 */
    private String sourceType;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 备注 */
    private String remark;
    /** 源模块 */
    private String sourceModule;
    /** 终端编号 */
    private String terminalId;
    /** 跟踪编码 */
    private String traceRefCode;
    /** 复核日期 */
    private Date approvalDate;
    /** 记账日期 */
    private Date valueDate;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 复核授权柜员号 */
    private String apprAuthUserId;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 冲正授权柜员号 */
    private String reversalAuthUserId;
    /** 冲正柜员号 */
    private String reversalUserId;
    /** 利润中心 */
    private String profitCenter;
    /** 外币系统内平盘控制金额 */
    private BigDecimal fcyCtrlIbuncAmt;
    /** 平盘状态 */
    private String uncStatus;
    /** 系统内平盘流水号 */
    private String ibuncReference;
    /** 交易市场平盘流水号 */
    private String obuncReference;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 买入平盘汇率 */
    private BigDecimal buyUncRate;
    /** 国籍 */
    private String countryLoc;
    /** 优惠券汇率类型 */
    private String couponRateType;
    /** 生效日期 */
    private Date effectDate;
    /** 生效时间 */
    private String effectTime;
    /** 浮动点差 */
    private BigDecimal floatPoint;
    /** 尾零处理标志 */
    private String minAmtFlag;
    /** 结售汇卖出平盘汇率 */
    private BigDecimal sellUncRate;
    /** 归属机构号 */
    private String branch;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private String documentType;
    /** 地区码 */
    private String areaCode;
    /** 客户名称 */
    private String clientName;
    /** 对私客户标志 */
    private String isIndividual;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getCashSeqNo() {
        return cashSeqNo;
    }

    public void setCashSeqNo(String cashSeqNo) {
        this.cashSeqNo = cashSeqNo;
    }

    public String getTaeSubSeqNo() {
        return taeSubSeqNo;
    }

    public void setTaeSubSeqNo(String taeSubSeqNo) {
        this.taeSubSeqNo = taeSubSeqNo;
    }

    public String getExchangeSeqNo() {
        return exchangeSeqNo;
    }

    public void setExchangeSeqNo(String exchangeSeqNo) {
        this.exchangeSeqNo = exchangeSeqNo;
    }

    public Integer getDepositInternalKey() {
        return depositInternalKey;
    }

    public void setDepositInternalKey(Integer depositInternalKey) {
        this.depositInternalKey = depositInternalKey;
    }

    public String getDepositBaseAcctNo() {
        return depositBaseAcctNo;
    }

    public void setDepositBaseAcctNo(String depositBaseAcctNo) {
        this.depositBaseAcctNo = depositBaseAcctNo;
    }

    public String getDepositAcctSeqNo() {
        return depositAcctSeqNo;
    }

    public void setDepositAcctSeqNo(String depositAcctSeqNo) {
        this.depositAcctSeqNo = depositAcctSeqNo;
    }

    public String getDepositProdType() {
        return depositProdType;
    }

    public void setDepositProdType(String depositProdType) {
        this.depositProdType = depositProdType;
    }

    public String getDepositBalanceType() {
        return depositBalanceType;
    }

    public void setDepositBalanceType(String depositBalanceType) {
        this.depositBalanceType = depositBalanceType;
    }

    public String getDepositSeqNo() {
        return depositSeqNo;
    }

    public void setDepositSeqNo(String depositSeqNo) {
        this.depositSeqNo = depositSeqNo;
    }

    public Integer getWithdrawInternalKey() {
        return withdrawInternalKey;
    }

    public void setWithdrawInternalKey(Integer withdrawInternalKey) {
        this.withdrawInternalKey = withdrawInternalKey;
    }

    public String getWithdrawBaseAcctNo() {
        return withdrawBaseAcctNo;
    }

    public void setWithdrawBaseAcctNo(String withdrawBaseAcctNo) {
        this.withdrawBaseAcctNo = withdrawBaseAcctNo;
    }

    public String getWithdrawAcctCcy() {
        return withdrawAcctCcy;
    }

    public void setWithdrawAcctCcy(String withdrawAcctCcy) {
        this.withdrawAcctCcy = withdrawAcctCcy;
    }

    public String getWithdrawAcctSeqNo() {
        return withdrawAcctSeqNo;
    }

    public void setWithdrawAcctSeqNo(String withdrawAcctSeqNo) {
        this.withdrawAcctSeqNo = withdrawAcctSeqNo;
    }

    public String getWithdrawProdType() {
        return withdrawProdType;
    }

    public void setWithdrawProdType(String withdrawProdType) {
        this.withdrawProdType = withdrawProdType;
    }

    public String getWithdrawBalanceType() {
        return withdrawBalanceType;
    }

    public void setWithdrawBalanceType(String withdrawBalanceType) {
        this.withdrawBalanceType = withdrawBalanceType;
    }

    public String getWithdrawSeqNo() {
        return withdrawSeqNo;
    }

    public void setWithdrawSeqNo(String withdrawSeqNo) {
        this.withdrawSeqNo = withdrawSeqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public String getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(String reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public String getExchangeTranStatus() {
        return exchangeTranStatus;
    }

    public void setExchangeTranStatus(String exchangeTranStatus) {
        this.exchangeTranStatus = exchangeTranStatus;
    }

    public String getSellBuyInd() {
        return sellBuyInd;
    }

    public void setSellBuyInd(String sellBuyInd) {
        this.sellBuyInd = sellBuyInd;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getBuyCcy() {
        return buyCcy;
    }

    public void setBuyCcy(String buyCcy) {
        this.buyCcy = buyCcy;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public String getSellCcy() {
        return sellCcy;
    }

    public void setSellCcy(String sellCcy) {
        this.sellCcy = sellCcy;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    public BigDecimal getExchRate() {
        return exchRate;
    }

    public void setExchRate(BigDecimal exchRate) {
        this.exchRate = exchRate;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public String getBaseQuoteType() {
        return baseQuoteType;
    }

    public void setBaseQuoteType(String baseQuoteType) {
        this.baseQuoteType = baseQuoteType;
    }

    public String getBaseRateType() {
        return baseRateType;
    }

    public void setBaseRateType(String baseRateType) {
        this.baseRateType = baseRateType;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getBaseEquivAmt() {
        return baseEquivAmt;
    }

    public void setBaseEquivAmt(BigDecimal baseEquivAmt) {
        this.baseEquivAmt = baseEquivAmt;
    }

    public BigDecimal getCrossRate() {
        return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate) {
        this.crossRate = crossRate;
    }

    public String getCrossRateAttr() {
        return crossRateAttr;
    }

    public void setCrossRateAttr(String crossRateAttr) {
        this.crossRateAttr = crossRateAttr;
    }

    public BigDecimal getUncCrossRate() {
        return uncCrossRate;
    }

    public void setUncCrossRate(BigDecimal uncCrossRate) {
        this.uncCrossRate = uncCrossRate;
    }

    public BigDecimal getInnerRate() {
        return innerRate;
    }

    public void setInnerRate(BigDecimal innerRate) {
        this.innerRate = innerRate;
    }

    public BigDecimal getChangeBaseEquivAmt() {
        return changeBaseEquivAmt;
    }

    public void setChangeBaseEquivAmt(BigDecimal changeBaseEquivAmt) {
        this.changeBaseEquivAmt = changeBaseEquivAmt;
    }

    public BigDecimal getChangeCnyAmount() {
        return changeCnyAmount;
    }

    public void setChangeCnyAmount(BigDecimal changeCnyAmount) {
        this.changeCnyAmount = changeCnyAmount;
    }

    public BigDecimal getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(BigDecimal changeRate) {
        this.changeRate = changeRate;
    }

    public String getChangeBaseQuoteType() {
        return changeBaseQuoteType;
    }

    public void setChangeBaseQuoteType(String changeBaseQuoteType) {
        this.changeBaseQuoteType = changeBaseQuoteType;
    }

    public String getChangeQuoteType() {
        return changeQuoteType;
    }

    public void setChangeQuoteType(String changeQuoteType) {
        this.changeQuoteType = changeQuoteType;
    }

    public String getChangeRateType() {
        return changeRateType;
    }

    public void setChangeRateType(String changeRateType) {
        this.changeRateType = changeRateType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTraceRefNo() {
        return traceRefNo;
    }

    public void setTraceRefNo(String traceRefNo) {
        this.traceRefNo = traceRefNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getBankSeqNo() {
        return bankSeqNo;
    }

    public void setBankSeqNo(String bankSeqNo) {
        this.bankSeqNo = bankSeqNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTraceRefCode() {
        return traceRefCode;
    }

    public void setTraceRefCode(String traceRefCode) {
        this.traceRefCode = traceRefCode;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getApprAuthUserId() {
        return apprAuthUserId;
    }

    public void setApprAuthUserId(String apprAuthUserId) {
        this.apprAuthUserId = apprAuthUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getReversalAuthUserId() {
        return reversalAuthUserId;
    }

    public void setReversalAuthUserId(String reversalAuthUserId) {
        this.reversalAuthUserId = reversalAuthUserId;
    }

    public String getReversalUserId() {
        return reversalUserId;
    }

    public void setReversalUserId(String reversalUserId) {
        this.reversalUserId = reversalUserId;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public BigDecimal getFcyCtrlIbuncAmt() {
        return fcyCtrlIbuncAmt;
    }

    public void setFcyCtrlIbuncAmt(BigDecimal fcyCtrlIbuncAmt) {
        this.fcyCtrlIbuncAmt = fcyCtrlIbuncAmt;
    }

    public String getUncStatus() {
        return uncStatus;
    }

    public void setUncStatus(String uncStatus) {
        this.uncStatus = uncStatus;
    }

    public String getIbuncReference() {
        return ibuncReference;
    }

    public void setIbuncReference(String ibuncReference) {
        this.ibuncReference = ibuncReference;
    }

    public String getObuncReference() {
        return obuncReference;
    }

    public void setObuncReference(String obuncReference) {
        this.obuncReference = obuncReference;
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

    public BigDecimal getBuyUncRate() {
        return buyUncRate;
    }

    public void setBuyUncRate(BigDecimal buyUncRate) {
        this.buyUncRate = buyUncRate;
    }

    public String getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(String countryLoc) {
        this.countryLoc = countryLoc;
    }

    public String getCouponRateType() {
        return couponRateType;
    }

    public void setCouponRateType(String couponRateType) {
        this.couponRateType = couponRateType;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public BigDecimal getFloatPoint() {
        return floatPoint;
    }

    public void setFloatPoint(BigDecimal floatPoint) {
        this.floatPoint = floatPoint;
    }

    public String getMinAmtFlag() {
        return minAmtFlag;
    }

    public void setMinAmtFlag(String minAmtFlag) {
        this.minAmtFlag = minAmtFlag;
    }

    public BigDecimal getSellUncRate() {
        return sellUncRate;
    }

    public void setSellUncRate(BigDecimal sellUncRate) {
        this.sellUncRate = sellUncRate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(String isIndividual) {
        this.isIndividual = isIndividual;
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
}
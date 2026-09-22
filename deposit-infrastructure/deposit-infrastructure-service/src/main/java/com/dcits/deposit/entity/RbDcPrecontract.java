package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbDcPrecontract {
    /** 预约编号 */
    private String precontractNo;
    /** 客户号 */
    private String clientNo;
    /** 期次代码 */
    private String stageCode;
    /** 发行年度 */
    private String issueYear;
    /** 期次类产品预约类型 */
    private String precontractType;
    /** 期次类产品预约状态 */
    private String precontractStatus;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户币种 */
    private String acctCcy;
    /** 账户名称 */
    private String acctName;
    /** 账户属性 */
    private String acctNature;
    /** 账户状态 */
    private String acctStatus;
    /** 归属机构号 */
    private String branch;
    /** 期次类产品预约机构号 */
    private String precontractBranch;
    /** 预约登记日期 */
    private Date precontractDate;
    /** 期次类产品预约币种 */
    private String precontractCcy;
    /** 预约金额 */
    private BigDecimal precontractAmt;
    /** 预约开户日期 */
    private Date precontractOpenDate;
    /** 额度扣减类型 */
    private String stageLimitClass;
    /** 起息日期 */
    private Date intStartDate;
    /** 自动结清标志 */
    private String autoSettleFlag;
    /** 按频率付息标志 */
    private String cycleIntFlag;
    /** 付息方式 */
    private String payIntMode;
    /** 结息频率 */
    private String cycleFreq;
    /** 结息日 */
    private String intDay;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 追加挂账编号 */
    private String subHangSeqNo;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 期次类产品发行起始日期 */
    private Date issueStartDate;
    /** 期次类产品发行终止日期 */
    private Date issueEndDate;
    /** 大额存单期次发行金额 */
    private BigDecimal issueAmt;
    /** 利率类型 */
    private String intType;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 渠道类型 */
    private String sourceType;
    /** 摘要 */
    private String narrative;
    /** 交易参考号 */
    private String reference;
    /** 对手账户内部键 */
    private Integer othInternalKey;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手产品编号 */
    private String othProdType;
    /** 对手币种 */
    private String othCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对手账户名称 */
    private String othAcctName;
    /** 认购账户内部键值 */
    private Integer subsInternalKey;
    /** 利息入账账户键值 */
    private Integer intInternalKey;
    /** 质押标志 */
    private String pledgedFlag;
    /** 限制编号 */
    private String resSeqNo;
    /** 大额存单转让编号 */
    private String trfNo;
    /** 转让价格 */
    private BigDecimal trfTotalSettleAmt;
    /** 赎回日期 */
    private Date redeemDate;
    /** 预计赎回利息 */
    private BigDecimal expRedeemIntAmt;
    /** 支取方式 */
    private String withdrawalType;
    /** 凭证号 */
    private String voucherNo;
    /** 打印次数 */
    private Integer printCnt;
    /** 期次产品分类 */
    private String stageProdClass;
    /** 计息类型 */
    private String intCalcType;
    /** 利息税征收标志 */
    private String intTaxLevy;
    /** 交易失败原因 */
    private String failureReason;
    /** 删除日期 */
    private Date deleteDate;
    /** 撤销原因 */
    private String delReason;
    /** 交易柜员号 */
    private String userId;
    /** 授权柜员号 */
    private String authUserId;
    /** 撤销柜员号 */
    private String delUserId;
    /** 撤销授权柜员号 */
    private String delAuthUserId;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;
    /** 结算账户主键 */
    private Integer settleInternalKey;

    public String getPrecontractNo() {
        return precontractNo;
    }

    public void setPrecontractNo(String precontractNo) {
        this.precontractNo = precontractNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getPrecontractType() {
        return precontractType;
    }

    public void setPrecontractType(String precontractType) {
        this.precontractType = precontractType;
    }

    public String getPrecontractStatus() {
        return precontractStatus;
    }

    public void setPrecontractStatus(String precontractStatus) {
        this.precontractStatus = precontractStatus;
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

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(String acctNature) {
        this.acctNature = acctNature;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPrecontractBranch() {
        return precontractBranch;
    }

    public void setPrecontractBranch(String precontractBranch) {
        this.precontractBranch = precontractBranch;
    }

    public Date getPrecontractDate() {
        return precontractDate;
    }

    public void setPrecontractDate(Date precontractDate) {
        this.precontractDate = precontractDate;
    }

    public String getPrecontractCcy() {
        return precontractCcy;
    }

    public void setPrecontractCcy(String precontractCcy) {
        this.precontractCcy = precontractCcy;
    }

    public BigDecimal getPrecontractAmt() {
        return precontractAmt;
    }

    public void setPrecontractAmt(BigDecimal precontractAmt) {
        this.precontractAmt = precontractAmt;
    }

    public Date getPrecontractOpenDate() {
        return precontractOpenDate;
    }

    public void setPrecontractOpenDate(Date precontractOpenDate) {
        this.precontractOpenDate = precontractOpenDate;
    }

    public String getStageLimitClass() {
        return stageLimitClass;
    }

    public void setStageLimitClass(String stageLimitClass) {
        this.stageLimitClass = stageLimitClass;
    }

    public Date getIntStartDate() {
        return intStartDate;
    }

    public void setIntStartDate(Date intStartDate) {
        this.intStartDate = intStartDate;
    }

    public String getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(String autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public String getCycleIntFlag() {
        return cycleIntFlag;
    }

    public void setCycleIntFlag(String cycleIntFlag) {
        this.cycleIntFlag = cycleIntFlag;
    }

    public String getPayIntMode() {
        return payIntMode;
    }

    public void setPayIntMode(String payIntMode) {
        this.payIntMode = payIntMode;
    }

    public String getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(String cycleFreq) {
        this.cycleFreq = cycleFreq;
    }

    public String getIntDay() {
        return intDay;
    }

    public void setIntDay(String intDay) {
        this.intDay = intDay;
    }

    public String getHangSeqNo() {
        return hangSeqNo;
    }

    public void setHangSeqNo(String hangSeqNo) {
        this.hangSeqNo = hangSeqNo;
    }

    public String getSubHangSeqNo() {
        return subHangSeqNo;
    }

    public void setSubHangSeqNo(String subHangSeqNo) {
        this.subHangSeqNo = subHangSeqNo;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public Date getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(Date issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public Date getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public BigDecimal getIssueAmt() {
        return issueAmt;
    }

    public void setIssueAmt(BigDecimal issueAmt) {
        this.issueAmt = issueAmt;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public String getOthCcy() {
        return othCcy;
    }

    public void setOthCcy(String othCcy) {
        this.othCcy = othCcy;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getOthAcctName() {
        return othAcctName;
    }

    public void setOthAcctName(String othAcctName) {
        this.othAcctName = othAcctName;
    }

    public Integer getSubsInternalKey() {
        return subsInternalKey;
    }

    public void setSubsInternalKey(Integer subsInternalKey) {
        this.subsInternalKey = subsInternalKey;
    }

    public Integer getIntInternalKey() {
        return intInternalKey;
    }

    public void setIntInternalKey(Integer intInternalKey) {
        this.intInternalKey = intInternalKey;
    }

    public String getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(String pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getTrfNo() {
        return trfNo;
    }

    public void setTrfNo(String trfNo) {
        this.trfNo = trfNo;
    }

    public BigDecimal getTrfTotalSettleAmt() {
        return trfTotalSettleAmt;
    }

    public void setTrfTotalSettleAmt(BigDecimal trfTotalSettleAmt) {
        this.trfTotalSettleAmt = trfTotalSettleAmt;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getExpRedeemIntAmt() {
        return expRedeemIntAmt;
    }

    public void setExpRedeemIntAmt(BigDecimal expRedeemIntAmt) {
        this.expRedeemIntAmt = expRedeemIntAmt;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(Integer printCnt) {
        this.printCnt = printCnt;
    }

    public String getStageProdClass() {
        return stageProdClass;
    }

    public void setStageProdClass(String stageProdClass) {
        this.stageProdClass = stageProdClass;
    }

    public String getIntCalcType() {
        return intCalcType;
    }

    public void setIntCalcType(String intCalcType) {
        this.intCalcType = intCalcType;
    }

    public String getIntTaxLevy() {
        return intTaxLevy;
    }

    public void setIntTaxLevy(String intTaxLevy) {
        this.intTaxLevy = intTaxLevy;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
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

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelAuthUserId() {
        return delAuthUserId;
    }

    public void setDelAuthUserId(String delAuthUserId) {
        this.delAuthUserId = delAuthUserId;
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

    public Integer getSettleInternalKey() {
        return settleInternalKey;
    }

    public void setSettleInternalKey(Integer settleInternalKey) {
        this.settleInternalKey = settleInternalKey;
    }
}
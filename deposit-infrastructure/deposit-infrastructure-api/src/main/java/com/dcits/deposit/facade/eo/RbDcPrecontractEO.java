package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntCalcType;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.PayIntMode;
import com.dcits.deposit.enums.PrecontractStatus;
import com.dcits.deposit.enums.PrecontractType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.StageProdClass;
import com.dcits.deposit.enums.WithdrawalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbDcPrecontractEO {
    /** 预约编号 */
    @NotNull
    private String precontractNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 期次代码 */
    private String stageCode;
    /** 发行年度 */
    private String issueYear;
    /** 期次类产品预约类型 */
    private PrecontractType precontractType;
    /** 期次类产品预约状态 */
    private PrecontractStatus precontractStatus;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户名称 */
    private String acctName;
    /** 账户属性 */
    private AcctNature acctNature;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 期次类产品预约机构号 */
    private AcctBranch precontractBranch;
    /** 预约登记日期 */
    private java.util.Date precontractDate;
    /** 期次类产品预约币种 */
    private AcctCcy precontractCcy;
    /** 预约金额 */
    private BigDecimal precontractAmt;
    /** 预约开户日期 */
    private java.util.Date precontractOpenDate;
    /** 额度扣减类型 */
    private StageLimitClass stageLimitClass;
    /** 起息日期 */
    private java.util.Date intStartDate;
    /** 自动结清标志 */
    private IndividualFlag autoSettleFlag;
    /** 按频率付息标志 */
    private IndividualFlag cycleIntFlag;
    /** 付息方式 */
    private PayIntMode payIntMode;
    /** 结息频率 */
    private CycleFreq cycleFreq;
    /** 结息日 */
    private String intDay;
    /** 挂账编号 */
    private String hangSeqNo;
    /** 追加挂账编号 */
    private String subHangSeqNo;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 期次类产品发行起始日期 */
    private java.util.Date issueStartDate;
    /** 期次类产品发行终止日期 */
    private java.util.Date issueEndDate;
    /** 大额存单期次发行金额 */
    private BigDecimal issueAmt;
    /** 利率类型 */
    private IntType intType;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 渠道类型 */
    private SourceType sourceType;
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
    private AcctCcy othCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对手账户名称 */
    private String othAcctName;
    /** 认购账户内部键值 */
    private Integer subsInternalKey;
    /** 利息入账账户键值 */
    private Integer intInternalKey;
    /** 质押标志 */
    private IndividualFlag pledgedFlag;
    /** 限制编号 */
    private String resSeqNo;
    /** 大额存单转让编号 */
    private String trfNo;
    /** 转让价格 */
    private BigDecimal trfTotalSettleAmt;
    /** 赎回日期 */
    private java.util.Date redeemDate;
    /** 预计赎回利息 */
    private BigDecimal expRedeemIntAmt;
    /** 支取方式 */
    private WithdrawalType withdrawalType;
    /** 凭证号 */
    private String voucherNo;
    /** 打印次数 */
    private Integer printCnt;
    /** 期次产品分类 */
    private StageProdClass stageProdClass;
    /** 计息类型 */
    private IntCalcType intCalcType;
    /** 利息税征收标志 */
    private IndividualFlag intTaxLevy;
    /** 交易失败原因 */
    private String failureReason;
    /** 删除日期 */
    private java.util.Date deleteDate;
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
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;
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

    public PrecontractType getPrecontractType() {
        return precontractType;
    }

    public void setPrecontractType(PrecontractType precontractType) {
        this.precontractType = precontractType;
    }

    public PrecontractStatus getPrecontractStatus() {
        return precontractStatus;
    }

    public void setPrecontractStatus(PrecontractStatus precontractStatus) {
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

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public AcctNature getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(AcctNature acctNature) {
        this.acctNature = acctNature;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public AcctBranch getPrecontractBranch() {
        return precontractBranch;
    }

    public void setPrecontractBranch(AcctBranch precontractBranch) {
        this.precontractBranch = precontractBranch;
    }

    public java.util.Date getPrecontractDate() {
        return precontractDate;
    }

    public void setPrecontractDate(java.util.Date precontractDate) {
        this.precontractDate = precontractDate;
    }

    public AcctCcy getPrecontractCcy() {
        return precontractCcy;
    }

    public void setPrecontractCcy(AcctCcy precontractCcy) {
        this.precontractCcy = precontractCcy;
    }

    public BigDecimal getPrecontractAmt() {
        return precontractAmt;
    }

    public void setPrecontractAmt(BigDecimal precontractAmt) {
        this.precontractAmt = precontractAmt;
    }

    public java.util.Date getPrecontractOpenDate() {
        return precontractOpenDate;
    }

    public void setPrecontractOpenDate(java.util.Date precontractOpenDate) {
        this.precontractOpenDate = precontractOpenDate;
    }

    public StageLimitClass getStageLimitClass() {
        return stageLimitClass;
    }

    public void setStageLimitClass(StageLimitClass stageLimitClass) {
        this.stageLimitClass = stageLimitClass;
    }

    public java.util.Date getIntStartDate() {
        return intStartDate;
    }

    public void setIntStartDate(java.util.Date intStartDate) {
        this.intStartDate = intStartDate;
    }

    public IndividualFlag getAutoSettleFlag() {
        return autoSettleFlag;
    }

    public void setAutoSettleFlag(IndividualFlag autoSettleFlag) {
        this.autoSettleFlag = autoSettleFlag;
    }

    public IndividualFlag getCycleIntFlag() {
        return cycleIntFlag;
    }

    public void setCycleIntFlag(IndividualFlag cycleIntFlag) {
        this.cycleIntFlag = cycleIntFlag;
    }

    public PayIntMode getPayIntMode() {
        return payIntMode;
    }

    public void setPayIntMode(PayIntMode payIntMode) {
        this.payIntMode = payIntMode;
    }

    public CycleFreq getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(CycleFreq cycleFreq) {
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

    public java.util.Date getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(java.util.Date issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public java.util.Date getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(java.util.Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public BigDecimal getIssueAmt() {
        return issueAmt;
    }

    public void setIssueAmt(BigDecimal issueAmt) {
        this.issueAmt = issueAmt;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
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

    public AcctCcy getOthCcy() {
        return othCcy;
    }

    public void setOthCcy(AcctCcy othCcy) {
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

    public IndividualFlag getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(IndividualFlag pledgedFlag) {
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

    public java.util.Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(java.util.Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getExpRedeemIntAmt() {
        return expRedeemIntAmt;
    }

    public void setExpRedeemIntAmt(BigDecimal expRedeemIntAmt) {
        this.expRedeemIntAmt = expRedeemIntAmt;
    }

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
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

    public StageProdClass getStageProdClass() {
        return stageProdClass;
    }

    public void setStageProdClass(StageProdClass stageProdClass) {
        this.stageProdClass = stageProdClass;
    }

    public IntCalcType getIntCalcType() {
        return intCalcType;
    }

    public void setIntCalcType(IntCalcType intCalcType) {
        this.intCalcType = intCalcType;
    }

    public IndividualFlag getIntTaxLevy() {
        return intTaxLevy;
    }

    public void setIntTaxLevy(IndividualFlag intTaxLevy) {
        this.intTaxLevy = intTaxLevy;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public java.util.Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(java.util.Date deleteDate) {
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

    public Integer getSettleInternalKey() {
        return settleInternalKey;
    }

    public void setSettleInternalKey(Integer settleInternalKey) {
        this.settleInternalKey = settleInternalKey;
    }
}
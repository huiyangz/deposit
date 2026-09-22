package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import com.dcits.deposit.enums.DossStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.ToAcctType;
import com.dcits.deposit.enums.ToBankInd;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctDossRegEO {
    /** 转久悬操作类型 */
    private DossOperateType dossOperateType;
    /** 批次号 */
    private String batchNo;
    /** 手工导入标志 */
    private IndividualFlag handFlag;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
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
    /** 对公对私标志 */
    private IndividualFlag individualFlag;
    /** 金额类型 */
    private AmtType amtType;
    /** 余额 */
    private BigDecimal balance;
    /** 利息 */
    private BigDecimal intAmt;
    /** 本息合计金额 */
    private BigDecimal porIntTot;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 实际入账金额 */
    private BigDecimal recordAmt;
    /** 账户利息税金额 */
    private BigDecimal taxSc;
    /** 久悬户状态 */
    private DossStatus dossStatus;
    /** 上一久悬状态 */
    private DossStatus prevDossStatus;
    /** 转久悬日期 */
    private java.util.Date dossDate;
    /** 转久悬机构号 */
    private AcctBranch dossBranch;
    /** 转久悬户柜员号 */
    private String dossUserId;
    /** 转入久悬原因 */
    private String todossReason;
    /** 激活日期 */
    private java.util.Date activeDate;
    /** 久悬户激活机构号 */
    private AcctBranch activeBranch;
    /** 久悬户激活柜员号 */
    private String activeUserId;
    /** 转营业外日期 */
    private java.util.Date outBusiDate;
    /** 转营业外柜员号 */
    private String outBusiUserId;
    /** 久悬清理日期 */
    private java.util.Date withdrawalDate;
    /** 久悬清理机构号 */
    private AcctBranch withdrawalBranch;
    /** 转出柜员号 */
    private String withdrawalUserId;
    /** 转出久悬原因 */
    private String withdrawalReason;
    /** 转入账号 */
    private String toBaseAcctNo;
    /** 转入币种 */
    private AcctCcy toCcy;
    /** 转出户序号 */
    private String toAcctSeqNo;
    /** 转出账户名称 */
    private String toAcctName;
    /** 转入产品编号 */
    private String toProdType;
    /** 久悬转入方账户类型 */
    private ToAcctType toAcctType;
    /** 转入账号他行标志 */
    private ToBankInd toBankInd;
    /** 限制编号 */
    private String resSeqNo;
    /** 备注 */
    private String remark;
    /** 交易参考号 */
    private String reference;
    /** 授权柜员号 */
    private String authUserId;
    /** 交易柜员号 */
    private String userId;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;

    public DossOperateType getDossOperateType() {
        return dossOperateType;
    }

    public void setDossOperateType(DossOperateType dossOperateType) {
        this.dossOperateType = dossOperateType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public IndividualFlag getHandFlag() {
        return handFlag;
    }

    public void setHandFlag(IndividualFlag handFlag) {
        this.handFlag = handFlag;
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

    public IndividualFlag getIndividualFlag() {
        return individualFlag;
    }

    public void setIndividualFlag(IndividualFlag individualFlag) {
        this.individualFlag = individualFlag;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getPorIntTot() {
        return porIntTot;
    }

    public void setPorIntTot(BigDecimal porIntTot) {
        this.porIntTot = porIntTot;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getRecordAmt() {
        return recordAmt;
    }

    public void setRecordAmt(BigDecimal recordAmt) {
        this.recordAmt = recordAmt;
    }

    public BigDecimal getTaxSc() {
        return taxSc;
    }

    public void setTaxSc(BigDecimal taxSc) {
        this.taxSc = taxSc;
    }

    public DossStatus getDossStatus() {
        return dossStatus;
    }

    public void setDossStatus(DossStatus dossStatus) {
        this.dossStatus = dossStatus;
    }

    public DossStatus getPrevDossStatus() {
        return prevDossStatus;
    }

    public void setPrevDossStatus(DossStatus prevDossStatus) {
        this.prevDossStatus = prevDossStatus;
    }

    public java.util.Date getDossDate() {
        return dossDate;
    }

    public void setDossDate(java.util.Date dossDate) {
        this.dossDate = dossDate;
    }

    public AcctBranch getDossBranch() {
        return dossBranch;
    }

    public void setDossBranch(AcctBranch dossBranch) {
        this.dossBranch = dossBranch;
    }

    public String getDossUserId() {
        return dossUserId;
    }

    public void setDossUserId(String dossUserId) {
        this.dossUserId = dossUserId;
    }

    public String getTodossReason() {
        return todossReason;
    }

    public void setTodossReason(String todossReason) {
        this.todossReason = todossReason;
    }

    public java.util.Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(java.util.Date activeDate) {
        this.activeDate = activeDate;
    }

    public AcctBranch getActiveBranch() {
        return activeBranch;
    }

    public void setActiveBranch(AcctBranch activeBranch) {
        this.activeBranch = activeBranch;
    }

    public String getActiveUserId() {
        return activeUserId;
    }

    public void setActiveUserId(String activeUserId) {
        this.activeUserId = activeUserId;
    }

    public java.util.Date getOutBusiDate() {
        return outBusiDate;
    }

    public void setOutBusiDate(java.util.Date outBusiDate) {
        this.outBusiDate = outBusiDate;
    }

    public String getOutBusiUserId() {
        return outBusiUserId;
    }

    public void setOutBusiUserId(String outBusiUserId) {
        this.outBusiUserId = outBusiUserId;
    }

    public java.util.Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(java.util.Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public AcctBranch getWithdrawalBranch() {
        return withdrawalBranch;
    }

    public void setWithdrawalBranch(AcctBranch withdrawalBranch) {
        this.withdrawalBranch = withdrawalBranch;
    }

    public String getWithdrawalUserId() {
        return withdrawalUserId;
    }

    public void setWithdrawalUserId(String withdrawalUserId) {
        this.withdrawalUserId = withdrawalUserId;
    }

    public String getWithdrawalReason() {
        return withdrawalReason;
    }

    public void setWithdrawalReason(String withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
    }

    public String getToBaseAcctNo() {
        return toBaseAcctNo;
    }

    public void setToBaseAcctNo(String toBaseAcctNo) {
        this.toBaseAcctNo = toBaseAcctNo;
    }

    public AcctCcy getToCcy() {
        return toCcy;
    }

    public void setToCcy(AcctCcy toCcy) {
        this.toCcy = toCcy;
    }

    public String getToAcctSeqNo() {
        return toAcctSeqNo;
    }

    public void setToAcctSeqNo(String toAcctSeqNo) {
        this.toAcctSeqNo = toAcctSeqNo;
    }

    public String getToAcctName() {
        return toAcctName;
    }

    public void setToAcctName(String toAcctName) {
        this.toAcctName = toAcctName;
    }

    public String getToProdType() {
        return toProdType;
    }

    public void setToProdType(String toProdType) {
        this.toProdType = toProdType;
    }

    public ToAcctType getToAcctType() {
        return toAcctType;
    }

    public void setToAcctType(ToAcctType toAcctType) {
        this.toAcctType = toAcctType;
    }

    public ToBankInd getToBankInd() {
        return toBankInd;
    }

    public void setToBankInd(ToBankInd toBankInd) {
        this.toBankInd = toBankInd;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
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
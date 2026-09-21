package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAcctDossReg {
    /** 转久悬操作类型 */
    private String dossOperateType;
    /** 批次号 */
    private String batchNo;
    /** 手工导入标志 */
    private String handFlag;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    private String clientNo;
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
    /** 对公对私标志 */
    private String individualFlag;
    /** 金额类型 */
    private String amtType;
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
    private String dossStatus;
    /** 上一久悬状态 */
    private String prevDossStatus;
    /** 转久悬日期 */
    private Date dossDate;
    /** 转久悬机构号 */
    private String dossBranch;
    /** 转久悬户柜员号 */
    private String dossUserId;
    /** 转入久悬原因 */
    private String todossReason;
    /** 激活日期 */
    private Date activeDate;
    /** 久悬户激活机构号 */
    private String activeBranch;
    /** 久悬户激活柜员号 */
    private String activeUserId;
    /** 转营业外日期 */
    private Date outBusiDate;
    /** 转营业外柜员号 */
    private String outBusiUserId;
    /** 久悬清理日期 */
    private Date withdrawalDate;
    /** 久悬清理机构号 */
    private String withdrawalBranch;
    /** 转出柜员号 */
    private String withdrawalUserId;
    /** 转出久悬原因 */
    private String withdrawalReason;
    /** 转入账号 */
    private String toBaseAcctNo;
    /** 转入币种 */
    private String toCcy;
    /** 转出户序号 */
    private String toAcctSeqNo;
    /** 转出账户名称 */
    private String toAcctName;
    /** 转入产品编号 */
    private String toProdType;
    /** 久悬转入方账户类型 */
    private String toAcctType;
    /** 转入账号他行标志 */
    private String toBankInd;
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
    private String sourceType;
    /** 归属机构号 */
    private String branch;
    /** 交易日期 */
    private Date tranDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;

    public String getDossOperateType() {
        return dossOperateType;
    }

    public void setDossOperateType(String dossOperateType) {
        this.dossOperateType = dossOperateType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getHandFlag() {
        return handFlag;
    }

    public void setHandFlag(String handFlag) {
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

    public String getIndividualFlag() {
        return individualFlag;
    }

    public void setIndividualFlag(String individualFlag) {
        this.individualFlag = individualFlag;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
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

    public String getDossStatus() {
        return dossStatus;
    }

    public void setDossStatus(String dossStatus) {
        this.dossStatus = dossStatus;
    }

    public String getPrevDossStatus() {
        return prevDossStatus;
    }

    public void setPrevDossStatus(String prevDossStatus) {
        this.prevDossStatus = prevDossStatus;
    }

    public Date getDossDate() {
        return dossDate;
    }

    public void setDossDate(Date dossDate) {
        this.dossDate = dossDate;
    }

    public String getDossBranch() {
        return dossBranch;
    }

    public void setDossBranch(String dossBranch) {
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

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getActiveBranch() {
        return activeBranch;
    }

    public void setActiveBranch(String activeBranch) {
        this.activeBranch = activeBranch;
    }

    public String getActiveUserId() {
        return activeUserId;
    }

    public void setActiveUserId(String activeUserId) {
        this.activeUserId = activeUserId;
    }

    public Date getOutBusiDate() {
        return outBusiDate;
    }

    public void setOutBusiDate(Date outBusiDate) {
        this.outBusiDate = outBusiDate;
    }

    public String getOutBusiUserId() {
        return outBusiUserId;
    }

    public void setOutBusiUserId(String outBusiUserId) {
        this.outBusiUserId = outBusiUserId;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getWithdrawalBranch() {
        return withdrawalBranch;
    }

    public void setWithdrawalBranch(String withdrawalBranch) {
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

    public String getToCcy() {
        return toCcy;
    }

    public void setToCcy(String toCcy) {
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

    public String getToAcctType() {
        return toAcctType;
    }

    public void setToAcctType(String toAcctType) {
        this.toAcctType = toAcctType;
    }

    public String getToBankInd() {
        return toBankInd;
    }

    public void setToBankInd(String toBankInd) {
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
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
}
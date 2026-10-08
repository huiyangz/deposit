package com.dcits.depsit.entity;

import java.util.Date;

public class RbVoucherLost {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 解挂日期 */
    private Date unlostDate;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 解挂机构号 */
    private String unchainBranch;
    /** 挂失解挂原因 */
    private String reportedLostReason;
    /** 解挂柜员号 */
    private String unlostUserId;
    /** 交易参考号 */
    private String reference;
    /** 交易机构号 */
    private String tranBranch;
    /** 凭证挂失状态 */
    private String voucherLostStatus;
    /** 凭证号 */
    private String voucherNo;
    /** 账户币种 */
    private String acctCcy;
    /** 解挂类型 */
    private String relieveLossType;
    /** 账户名称 */
    private String acctName;
    /** 处理结果信息 */
    private String dealResult;
    /** 凭证前缀编码 */
    private String prefix;
    /** 解挂授权柜员号 */
    private String unchainAuthUserId;
    /** 挂失键编码 */
    private String lostKey;
    /** 账户序号 */
    private String acctSeqNo;
    /** 交易日期 */
    private Date tranDate;
    /** 挂失类型 */
    private String lostType;
    /** 账号 */
    private String baseAcctNo;
    /** 挂失编号 */
    private String lostNo;
    /** 账户冻结开始序号 */
    private String startSeqNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 冻结标志 */
    private String resFlag;
    /** 交易柜员号 */
    private String userId;
    /** 客户号 */
    private String clientNo;
    /** 渠道类型 */
    private String sourceType;
    /** 产品编号 */
    private String prodNo;
    /** 授权柜员号 */
    private String authUserId;
    /** 自动解挂日期 */
    private Date autoUnblockDate;
    /** 凭证类型 */
    private String docType;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public Date getUnlostDate() {
        return unlostDate;
    }

    public void setUnlostDate(Date unlostDate) {
        this.unlostDate = unlostDate;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getUnchainBranch() {
        return unchainBranch;
    }

    public void setUnchainBranch(String unchainBranch) {
        this.unchainBranch = unchainBranch;
    }

    public String getReportedLostReason() {
        return reportedLostReason;
    }

    public void setReportedLostReason(String reportedLostReason) {
        this.reportedLostReason = reportedLostReason;
    }

    public String getUnlostUserId() {
        return unlostUserId;
    }

    public void setUnlostUserId(String unlostUserId) {
        this.unlostUserId = unlostUserId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getVoucherLostStatus() {
        return voucherLostStatus;
    }

    public void setVoucherLostStatus(String voucherLostStatus) {
        this.voucherLostStatus = voucherLostStatus;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getRelieveLossType() {
        return relieveLossType;
    }

    public void setRelieveLossType(String relieveLossType) {
        this.relieveLossType = relieveLossType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUnchainAuthUserId() {
        return unchainAuthUserId;
    }

    public void setUnchainAuthUserId(String unchainAuthUserId) {
        this.unchainAuthUserId = unchainAuthUserId;
    }

    public String getLostKey() {
        return lostKey;
    }

    public void setLostKey(String lostKey) {
        this.lostKey = lostKey;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getLostType() {
        return lostType;
    }

    public void setLostType(String lostType) {
        this.lostType = lostType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getLostNo() {
        return lostNo;
    }

    public void setLostNo(String lostNo) {
        this.lostNo = lostNo;
    }

    public String getStartSeqNo() {
        return startSeqNo;
    }

    public void setStartSeqNo(String startSeqNo) {
        this.startSeqNo = startSeqNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getResFlag() {
        return resFlag;
    }

    public void setResFlag(String resFlag) {
        this.resFlag = resFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public Date getAutoUnblockDate() {
        return autoUnblockDate;
    }

    public void setAutoUnblockDate(Date autoUnblockDate) {
        this.autoUnblockDate = autoUnblockDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
package com.dcits.deposit.entity;

import java.util.Date;

public class RbBaseAcct {
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 客户号 */
    private String clientNo;
    /** 客户类型 */
    private String clientType;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private String documentType;
    /** 发证国家 */
    private String issCountry;
    /** 卡号 */
    private String cardNo;
    /** 渠道类型 */
    private String sourceType;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 账户开户日期 */
    private Date acctOpenDate;
    /** 账户类型 */
    private String acctType;
    /** 账户名称 */
    private String acctName;
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户状态 */
    private String acctStatus;
    /** 账户上一状态 */
    private String acctStatusPrev;
    /** 账户状态更新日期 */
    private Date acctStatusUpdDate;
    /** 销户原因 */
    private String acctCloseReason;
    /** 销户柜员号 */
    private String acctCloseUserId;
    /** 账户描述 */
    private String acctDesc;
    /** 账户限制状态标志 */
    private String acctResStatus;
    /** 原产品类型 */
    private String oldProdType;
    /** 终端编号 */
    private String terminalId;
    /** 客户经理 */
    private String acctExec;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 通兑标志 */
    private String allDraInd;
    /** 通存标志 */
    private String allDepInd;
    /** 销户日期 */
    private Date acctCloseDate;
    /** 源模块 */
    private String sourceModule;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
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

    public String getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(String issCountry) {
        this.issCountry = issCountry;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAltAcctName() {
        return altAcctName;
    }

    public void setAltAcctName(String altAcctName) {
        this.altAcctName = altAcctName;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctStatusPrev() {
        return acctStatusPrev;
    }

    public void setAcctStatusPrev(String acctStatusPrev) {
        this.acctStatusPrev = acctStatusPrev;
    }

    public Date getAcctStatusUpdDate() {
        return acctStatusUpdDate;
    }

    public void setAcctStatusUpdDate(Date acctStatusUpdDate) {
        this.acctStatusUpdDate = acctStatusUpdDate;
    }

    public String getAcctCloseReason() {
        return acctCloseReason;
    }

    public void setAcctCloseReason(String acctCloseReason) {
        this.acctCloseReason = acctCloseReason;
    }

    public String getAcctCloseUserId() {
        return acctCloseUserId;
    }

    public void setAcctCloseUserId(String acctCloseUserId) {
        this.acctCloseUserId = acctCloseUserId;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public String getAcctResStatus() {
        return acctResStatus;
    }

    public void setAcctResStatus(String acctResStatus) {
        this.acctResStatus = acctResStatus;
    }

    public String getOldProdType() {
        return oldProdType;
    }

    public void setOldProdType(String oldProdType) {
        this.oldProdType = oldProdType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAcctExec() {
        return acctExec;
    }

    public void setAcctExec(String acctExec) {
        this.acctExec = acctExec;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
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

    public String getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(String allDraInd) {
        this.allDraInd = allDraInd;
    }

    public String getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(String allDepInd) {
        this.allDepInd = allDepInd;
    }

    public Date getAcctCloseDate() {
        return acctCloseDate;
    }

    public void setAcctCloseDate(Date acctCloseDate) {
        this.acctCloseDate = acctCloseDate;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
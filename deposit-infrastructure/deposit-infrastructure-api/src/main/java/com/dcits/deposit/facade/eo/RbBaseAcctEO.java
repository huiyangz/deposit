package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import jakarta.validation.constraints.NotNull;

public class RbBaseAcctEO {
    /** 账号/卡号 */
    @NotNull
    private String baseAcctNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 客户类型 */
    private ClientType clientType;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 卡号 */
    private String cardNo;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 账户开户日期 */
    private java.util.Date acctOpenDate;
    /** 账户类型 */
    private AcctType acctType;
    /** 账户名称 */
    private String acctName;
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户上一状态 */
    private AcctStatus acctStatusPrev;
    /** 账户状态更新日期 */
    private java.util.Date acctStatusUpdDate;
    /** 销户原因 */
    private String acctCloseReason;
    /** 销户柜员号 */
    private String acctCloseUserId;
    /** 账户描述 */
    private String acctDesc;
    /** 账户限制状态标志 */
    private IndividualFlag acctResStatus;
    /** 原产品类型 */
    private String oldProdType;
    /** 终端编号 */
    private String terminalId;
    /** 客户经理 */
    private String acctExec;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 通兑标志 */
    private AllDraInd allDraInd;
    /** 通存标志 */
    private IndividualFlag allDepInd;
    /** 销户日期 */
    private java.util.Date acctCloseDate;
    /** 源模块 */
    private SourceModule sourceModule;
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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
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

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
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

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AcctStatus getAcctStatusPrev() {
        return acctStatusPrev;
    }

    public void setAcctStatusPrev(AcctStatus acctStatusPrev) {
        this.acctStatusPrev = acctStatusPrev;
    }

    public java.util.Date getAcctStatusUpdDate() {
        return acctStatusUpdDate;
    }

    public void setAcctStatusUpdDate(java.util.Date acctStatusUpdDate) {
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

    public IndividualFlag getAcctResStatus() {
        return acctResStatus;
    }

    public void setAcctResStatus(IndividualFlag acctResStatus) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public AllDraInd getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(AllDraInd allDraInd) {
        this.allDraInd = allDraInd;
    }

    public IndividualFlag getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(IndividualFlag allDepInd) {
        this.allDepInd = allDepInd;
    }

    public java.util.Date getAcctCloseDate() {
        return acctCloseDate;
    }

    public void setAcctCloseDate(java.util.Date acctCloseDate) {
        this.acctCloseDate = acctCloseDate;
    }

    public SourceModule getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(SourceModule sourceModule) {
        this.sourceModule = sourceModule;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
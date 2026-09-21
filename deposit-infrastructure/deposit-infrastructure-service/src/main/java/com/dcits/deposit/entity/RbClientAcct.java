package com.dcits.deposit.entity;

import java.util.Date;

public class RbClientAcct {
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 客户号 */
    private String clientNo;
    /** 对客账户内部键值 */
    private Integer custInternalKey;
    /** 客户类型 */
    private String clientType;
    /** 账户路由主体类别 */
    private String acctDomain;
    /** 单位结算卡标志 */
    private String isCorpSettleCard;
    /** 卡折一体标志 */
    private String cardPbUnionFlag;
    /** 凭证种类 */
    private String docClass;
    /** 凭证类型 */
    private String docType;
    /** 凭证号 */
    private String voucherNo;
    /** 客户凭证状态 */
    private String clientVoucherStatus;
    /** 支取方式 */
    private String withdrawalType;
    /** 客户账户状态 */
    private String clientAcctStatus;
    /** 账户开户日期 */
    private Date acctOpenDate;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 销户机构号 */
    private String closeBranch;
    /** 创建日期 */
    private Date createDate;
    /** 更新日期 */
    private Date updateDate;
    /** 录入柜员号 */
    private String createUserId;
    /** 修改柜员号 */
    private String updateUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 法人 */
    private String company;

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

    public Integer getCustInternalKey() {
        return custInternalKey;
    }

    public void setCustInternalKey(Integer custInternalKey) {
        this.custInternalKey = custInternalKey;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAcctDomain() {
        return acctDomain;
    }

    public void setAcctDomain(String acctDomain) {
        this.acctDomain = acctDomain;
    }

    public String getIsCorpSettleCard() {
        return isCorpSettleCard;
    }

    public void setIsCorpSettleCard(String isCorpSettleCard) {
        this.isCorpSettleCard = isCorpSettleCard;
    }

    public String getCardPbUnionFlag() {
        return cardPbUnionFlag;
    }

    public void setCardPbUnionFlag(String cardPbUnionFlag) {
        this.cardPbUnionFlag = cardPbUnionFlag;
    }

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getClientVoucherStatus() {
        return clientVoucherStatus;
    }

    public void setClientVoucherStatus(String clientVoucherStatus) {
        this.clientVoucherStatus = clientVoucherStatus;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getClientAcctStatus() {
        return clientAcctStatus;
    }

    public void setClientAcctStatus(String clientAcctStatus) {
        this.clientAcctStatus = clientAcctStatus;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getCloseBranch() {
        return closeBranch;
    }

    public void setCloseBranch(String closeBranch) {
        this.closeBranch = closeBranch;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
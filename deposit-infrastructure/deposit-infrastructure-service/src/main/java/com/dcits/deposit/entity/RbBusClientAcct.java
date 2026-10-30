package com.dcits.deposit.entity;

import java.util.Date;

public class RbBusClientAcct {
    /** 账号 */
    private String baseAcctNo;
    /** 单位结算卡标志 */
    private String isCorpSettleCard;
    /** 客户号 */
    private String clientNo;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 账户路由主体类别 */
    private String acctDomain;
    /** 账户开户日期 */
    private Date acctOpenDate;
    /** 销户机构号 */
    private String closeBranch;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 客户账户状态 */
    private String clientAcctStatus;
    /** 账户开立行行号 */
    private String acctBranch;
    /** 凭证类型 */
    private String docType;
    /** 凭证号 */
    private String voucherNo;
    /** 客户凭证状态 */
    private String clientVoucherStatus;
    /** 客户类型 */
    private String clientType;
    /** 凭证种类 */
    private String docClass;
    /** 卡折一体标志 */
    private String cardPbUnionFlag;
    /** 支取方式 */
    private String withdrawalType;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getIsCorpSettleCard() {
        return isCorpSettleCard;
    }

    public void setIsCorpSettleCard(String isCorpSettleCard) {
        this.isCorpSettleCard = isCorpSettleCard;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getAcctDomain() {
        return acctDomain;
    }

    public void setAcctDomain(String acctDomain) {
        this.acctDomain = acctDomain;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public String getCloseBranch() {
        return closeBranch;
    }

    public void setCloseBranch(String closeBranch) {
        this.closeBranch = closeBranch;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getClientAcctStatus() {
        return clientAcctStatus;
    }

    public void setClientAcctStatus(String clientAcctStatus) {
        this.clientAcctStatus = clientAcctStatus;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
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

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public String getCardPbUnionFlag() {
        return cardPbUnionFlag;
    }

    public void setCardPbUnionFlag(String cardPbUnionFlag) {
        this.cardPbUnionFlag = cardPbUnionFlag;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
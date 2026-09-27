package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.WithdrawalType;
import jakarta.validation.constraints.NotNull;

public class RbBusClientAcctEO {
    /** 账号 */
    @NotNull
    private String baseAcctNo;
    /** 单位结算卡标志 */
    @NotNull
    private String isCorpSettleCard;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 账户路由主体类别 */
    @NotNull
    private String acctDomain;
    /** 账户开户日期 */
    @NotNull
    private java.util.Date acctOpenDate;
    /** 销户机构号 */
    private TranBranch closeBranch;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 客户账户状态 */
    private String clientAcctStatus;
    /** 账户开立行行号 */
    @NotNull
    private TranBranch acctBranch;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证号 */
    private String voucherNo;
    /** 客户凭证状态 */
    private String clientVoucherStatus;
    /** 客户类型 */
    @NotNull
    private ClientType clientType;
    /** 凭证种类 */
    private DocClass docClass;
    /** 卡折一体标志 */
    @NotNull
    private String cardPbUnionFlag;
    /** 支取方式 */
    private WithdrawalType withdrawalType;

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

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public TranBranch getCloseBranch() {
        return closeBranch;
    }

    public void setCloseBranch(TranBranch closeBranch) {
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

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public String getCardPbUnionFlag() {
        return cardPbUnionFlag;
    }

    public void setCardPbUnionFlag(String cardPbUnionFlag) {
        this.cardPbUnionFlag = cardPbUnionFlag;
    }

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
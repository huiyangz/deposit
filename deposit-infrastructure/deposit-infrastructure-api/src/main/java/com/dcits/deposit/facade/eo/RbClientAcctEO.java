package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.WithdrawalType;
import jakarta.validation.constraints.NotNull;

public class RbClientAcctEO {
    /** 账号/卡号 */
    @NotNull
    private String baseAcctNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 对客账户内部键值 */
    private Integer custInternalKey;
    /** 客户类型 */
    private ClientType clientType;
    /** 账户路由主体类别 */
    private String acctDomain;
    /** 单位结算卡标志 */
    private IndividualFlag isCorpSettleCard;
    /** 卡折一体标志 */
    private IndividualFlag cardPbUnionFlag;
    /** 凭证种类 */
    private DocClass docClass;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证号 */
    private String voucherNo;
    /** 客户凭证状态 */
    private String clientVoucherStatus;
    /** 支取方式 */
    private WithdrawalType withdrawalType;
    /** 客户账户状态 */
    private String clientAcctStatus;
    /** 账户开户日期 */
    private java.util.Date acctOpenDate;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 销户机构号 */
    private AcctBranch closeBranch;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 录入柜员号 */
    private String createUserId;
    /** 修改柜员号 */
    private String updateUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 法人 */
    private Company company;

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

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAcctDomain() {
        return acctDomain;
    }

    public void setAcctDomain(String acctDomain) {
        this.acctDomain = acctDomain;
    }

    public IndividualFlag getIsCorpSettleCard() {
        return isCorpSettleCard;
    }

    public void setIsCorpSettleCard(IndividualFlag isCorpSettleCard) {
        this.isCorpSettleCard = isCorpSettleCard;
    }

    public IndividualFlag getCardPbUnionFlag() {
        return cardPbUnionFlag;
    }

    public void setCardPbUnionFlag(IndividualFlag cardPbUnionFlag) {
        this.cardPbUnionFlag = cardPbUnionFlag;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
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

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getClientAcctStatus() {
        return clientAcctStatus;
    }

    public void setClientAcctStatus(String clientAcctStatus) {
        this.clientAcctStatus = clientAcctStatus;
    }

    public java.util.Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(java.util.Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public AcctBranch getCloseBranch() {
        return closeBranch;
    }

    public void setCloseBranch(AcctBranch closeBranch) {
        this.closeBranch = closeBranch;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
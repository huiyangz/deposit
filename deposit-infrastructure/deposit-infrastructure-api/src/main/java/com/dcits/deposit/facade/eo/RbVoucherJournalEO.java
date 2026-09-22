package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.VoucherStatus;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbVoucherJournalEO {
    /** 检查柜员号 */
    private String checkUserId;
    /** 凭证流水ID */
    @NotNull
    private String voucherJournalId;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 卡号 */
    private String cardNo;
    /** 金额 */
    private BigDecimal amount;
    /** 币种 */
    private AcctCcy ccy;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 凭证状态 */
    private VoucherStatus voucherStatus;
    /** 原凭证状态 */
    private VoucherStatus oldStatus;
    /** 交易参考号 */
    private String reference;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 交易描述 */
    private String tranDesc;
    /** 模块 */
    private SourceModule moduleId;
    /** 交易代码 */
    private String programId;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 交易柜员号 */
    private String userId;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 备注 */
    private String remark;
    /** 法人 */
    private Company company;
    /** 作废原因代码 */
    private CanReasonCode canReasonCode;
    /** 出票日期 */
    private java.util.Date billDate;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getVoucherJournalId() {
        return voucherJournalId;
    }

    public void setVoucherJournalId(String voucherJournalId) {
        this.voucherJournalId = voucherJournalId;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public VoucherStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(VoucherStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public SourceModule getModuleId() {
        return moduleId;
    }

    public void setModuleId(SourceModule moduleId) {
        this.moduleId = moduleId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CanReasonCode getCanReasonCode() {
        return canReasonCode;
    }

    public void setCanReasonCode(CanReasonCode canReasonCode) {
        this.canReasonCode = canReasonCode;
    }

    public java.util.Date getBillDate() {
        return billDate;
    }

    public void setBillDate(java.util.Date billDate) {
        this.billDate = billDate;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.VoucherStatus;
import jakarta.validation.constraints.NotNull;

public class RbVoucherAcctRelationEO {
    /** 账号/卡号 */
    @NotNull
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 卡号 */
    private String cardNo;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证类型 */
    @NotNull
    private DocType docType;
    /** 凭证种类 */
    private DocClass docClass;
    /** 凭证号 */
    @NotNull
    private String voucherNo;
    /** 凭证状态 */
    private VoucherStatus voucherStatus;
    /** 原凭证状态 */
    private VoucherStatus oldStatus;
    /** 交易参考号 */
    private String reference;
    /** 抵质押标志 */
    private IndividualFlag collatInd;
    /** 抵质押编号 */
    private String collatNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 摘要 */
    private String narrative;
    /** 备注 */
    private String remark;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 作废原因代码 */
    private CanReasonCode canReasonCode;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
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

    public IndividualFlag getCollatInd() {
        return collatInd;
    }

    public void setCollatInd(IndividualFlag collatInd) {
        this.collatInd = collatInd;
    }

    public String getCollatNo() {
        return collatNo;
    }

    public void setCollatNo(String collatNo) {
        this.collatNo = collatNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
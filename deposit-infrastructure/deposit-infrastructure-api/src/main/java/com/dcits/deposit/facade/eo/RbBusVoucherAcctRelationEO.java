package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import jakarta.validation.constraints.NotNull;

public class RbBusVoucherAcctRelationEO {
    /** 卡号 */
    private String cardNo;
    /** 账户序号 */
    private String acctSeqNo;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 凭证类型 */
    @NotNull
    private DocType docType;
    /** 摘要 */
    private String narrative;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 原凭证状态 */
    @NotNull
    private VoucherStatus oldStatus;
    /** 产品编号 */
    private String prodNo;
    /** 账号 */
    @NotNull
    private String baseAcctNo;
    /** 作废原因代码 */
    private CanReasonCode canReasonCode;
    /** 凭证状态 */
    @NotNull
    private VoucherStatus voucherStatus;
    /** 凭证号 */
    @NotNull
    private String voucherNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 抵质押标志 */
    private String collatInd;
    /** 凭证种类 */
    private DocClass docClass;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 抵质押编号 */
    private String collatNo;
    /** 凭证前缀编码 */
    private String prefix;
    /** 交易参考号 */
    private String reference;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public VoucherStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(VoucherStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public CanReasonCode getCanReasonCode() {
        return canReasonCode;
    }

    public void setCanReasonCode(CanReasonCode canReasonCode) {
        this.canReasonCode = canReasonCode;
    }

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getCollatInd() {
        return collatInd;
    }

    public void setCollatInd(String collatInd) {
        this.collatInd = collatInd;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getCollatNo() {
        return collatNo;
    }

    public void setCollatNo(String collatNo) {
        this.collatNo = collatNo;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
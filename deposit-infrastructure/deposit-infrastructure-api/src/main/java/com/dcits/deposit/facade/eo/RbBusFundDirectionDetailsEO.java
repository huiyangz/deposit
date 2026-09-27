package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import jakarta.validation.constraints.NotNull;

public class RbBusFundDirectionDetailsEO {
    /** 证件类型 */
    private DocumentType documentType;
    /** 账号 */
    @NotNull
    private String baseAcctNo;
    /** 资金去向支付行行号 */
    private String fundToBankNo;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;
    /** 账户序号 */
    private String acctSeqNo;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 资金来源 */
    private FundSource fundSource;
    /** 登记类型 */
    private RegType regType;
    /** 应解汇款内部账号 */
    private String babInternalBaseAcctNo;
    /** 币种 */
    private Ccy ccy;
    /** 证件号码 */
    private String documentId;
    /** 资金来源账户名称 */
    private String fundFromName;
    /** 产品编号 */
    private String prodNo;
    /** 资金来源账号 */
    private String fundFromAcctNo;
    /** 资金来源去向 */
    private FundAcctPurpose fundAcctPurpose;
    /** 代理人姓名 */
    private String agentName;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 资金去向账户名称 */
    private String fundToName;
    /** 资金来源行行号 */
    private String fundFromBankNo;
    /** 资金去向账号 */
    private String fundToAcctNo;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getFundToBankNo() {
        return fundToBankNo;
    }

    public void setFundToBankNo(String fundToBankNo) {
        this.fundToBankNo = fundToBankNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public FundSource getFundSource() {
        return fundSource;
    }

    public void setFundSource(FundSource fundSource) {
        this.fundSource = fundSource;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public String getBabInternalBaseAcctNo() {
        return babInternalBaseAcctNo;
    }

    public void setBabInternalBaseAcctNo(String babInternalBaseAcctNo) {
        this.babInternalBaseAcctNo = babInternalBaseAcctNo;
    }

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
        this.ccy = ccy;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFundFromName() {
        return fundFromName;
    }

    public void setFundFromName(String fundFromName) {
        this.fundFromName = fundFromName;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getFundFromAcctNo() {
        return fundFromAcctNo;
    }

    public void setFundFromAcctNo(String fundFromAcctNo) {
        this.fundFromAcctNo = fundFromAcctNo;
    }

    public FundAcctPurpose getFundAcctPurpose() {
        return fundAcctPurpose;
    }

    public void setFundAcctPurpose(FundAcctPurpose fundAcctPurpose) {
        this.fundAcctPurpose = fundAcctPurpose;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getFundToName() {
        return fundToName;
    }

    public void setFundToName(String fundToName) {
        this.fundToName = fundToName;
    }

    public String getFundFromBankNo() {
        return fundFromBankNo;
    }

    public void setFundFromBankNo(String fundFromBankNo) {
        this.fundFromBankNo = fundFromBankNo;
    }

    public String getFundToAcctNo() {
        return fundToAcctNo;
    }

    public void setFundToAcctNo(String fundToAcctNo) {
        this.fundToAcctNo = fundToAcctNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
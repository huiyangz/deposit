package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import jakarta.validation.constraints.NotNull;

public class RbFundDirectionDetailsEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 币种 */
    private AcctCcy ccy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 代理人姓名 */
    private String agentName;
    /** 登记类型 */
    private RegType regType;
    /** 资金来源 */
    private FundSource fundSource;
    /** 资金来源账号 */
    private String fundFromAcctNo;
    /** 资金来源账户名称 */
    private String fundFromName;
    /** 资金来源行行号 */
    private String fundFromBankNo;
    /** 资金去向账号 */
    private String fundToAcctNo;
    /** 资金去向账户名称 */
    private String fundToName;
    /** 资金去向支付行行号 */
    private String fundToBankNo;
    /** 资金来源去向 */
    private FundAcctPurpose fundAcctPurpose;
    /** 应解汇款内部账号 */
    private String babInternalBaseAcctNo;
    /** 证件类型 */
    private DocumentType documentType;
    /** 证件号码 */
    private String documentId;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
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

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public FundSource getFundSource() {
        return fundSource;
    }

    public void setFundSource(FundSource fundSource) {
        this.fundSource = fundSource;
    }

    public String getFundFromAcctNo() {
        return fundFromAcctNo;
    }

    public void setFundFromAcctNo(String fundFromAcctNo) {
        this.fundFromAcctNo = fundFromAcctNo;
    }

    public String getFundFromName() {
        return fundFromName;
    }

    public void setFundFromName(String fundFromName) {
        this.fundFromName = fundFromName;
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

    public String getFundToName() {
        return fundToName;
    }

    public void setFundToName(String fundToName) {
        this.fundToName = fundToName;
    }

    public String getFundToBankNo() {
        return fundToBankNo;
    }

    public void setFundToBankNo(String fundToBankNo) {
        this.fundToBankNo = fundToBankNo;
    }

    public FundAcctPurpose getFundAcctPurpose() {
        return fundAcctPurpose;
    }

    public void setFundAcctPurpose(FundAcctPurpose fundAcctPurpose) {
        this.fundAcctPurpose = fundAcctPurpose;
    }

    public String getBabInternalBaseAcctNo() {
        return babInternalBaseAcctNo;
    }

    public void setBabInternalBaseAcctNo(String babInternalBaseAcctNo) {
        this.babInternalBaseAcctNo = babInternalBaseAcctNo;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
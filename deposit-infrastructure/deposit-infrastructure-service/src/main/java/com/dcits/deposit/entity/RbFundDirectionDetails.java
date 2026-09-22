package com.dcits.deposit.entity;

import java.util.Date;

public class RbFundDirectionDetails {
    /** 序号 */
    private String seqNo;
    /** 客户号 */
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 币种 */
    private String ccy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 代理人姓名 */
    private String agentName;
    /** 登记类型 */
    private String regType;
    /** 资金来源 */
    private String fundSource;
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
    private String fundAcctPurpose;
    /** 应解汇款内部账号 */
    private String babInternalBaseAcctNo;
    /** 证件类型 */
    private String documentType;
    /** 证件号码 */
    private String documentId;
    /** 交易日期 */
    private Date tranDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;

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

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
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

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
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

    public String getFundAcctPurpose() {
        return fundAcctPurpose;
    }

    public void setFundAcctPurpose(String fundAcctPurpose) {
        this.fundAcctPurpose = fundAcctPurpose;
    }

    public String getBabInternalBaseAcctNo() {
        return babInternalBaseAcctNo;
    }

    public void setBabInternalBaseAcctNo(String babInternalBaseAcctNo) {
        this.babInternalBaseAcctNo = babInternalBaseAcctNo;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
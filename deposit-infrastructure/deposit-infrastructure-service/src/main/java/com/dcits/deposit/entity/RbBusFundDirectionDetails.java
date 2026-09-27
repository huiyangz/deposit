package com.dcits.deposit.entity;

import java.util.Date;

public class RbBusFundDirectionDetails {
    /** 证件类型 */
    private String documentType;
    /** 账号 */
    private String baseAcctNo;
    /** 资金去向支付行行号 */
    private String fundToBankNo;
    /** 交易日期 */
    private Date tranDate;
    /** 账户序号 */
    private String acctSeqNo;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 资金来源 */
    private String fundSource;
    /** 登记类型 */
    private String regType;
    /** 应解汇款内部账号 */
    private String babInternalBaseAcctNo;
    /** 币种 */
    private String ccy;
    /** 证件号码 */
    private String documentId;
    /** 资金来源账户名称 */
    private String fundFromName;
    /** 产品编号 */
    private String prodNo;
    /** 资金来源账号 */
    private String fundFromAcctNo;
    /** 资金来源去向 */
    private String fundAcctPurpose;
    /** 代理人姓名 */
    private String agentName;
    /** 序号 */
    private String seqNo;
    /** 资金去向账户名称 */
    private String fundToName;
    /** 资金来源行行号 */
    private String fundFromBankNo;
    /** 资金去向账号 */
    private String fundToAcctNo;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
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

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
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

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getBabInternalBaseAcctNo() {
        return babInternalBaseAcctNo;
    }

    public void setBabInternalBaseAcctNo(String babInternalBaseAcctNo) {
        this.babInternalBaseAcctNo = babInternalBaseAcctNo;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
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

    public String getFundAcctPurpose() {
        return fundAcctPurpose;
    }

    public void setFundAcctPurpose(String fundAcctPurpose) {
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
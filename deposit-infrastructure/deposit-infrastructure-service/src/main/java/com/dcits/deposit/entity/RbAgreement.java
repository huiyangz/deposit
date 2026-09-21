package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAgreement {
    /** 协议编号 */
    private String agreementId;
    /** 签约机构号 */
    private String signBranch;
    /** 合约类型1 */
    private String agreementType;
    /** 合约分类 */
    private String agreementClass;
    /** 协议键类型 */
    private String agreementKeyType;
    /** 合约键值描述 */
    private String agreementKey;
    /** 合约金额 */
    private BigDecimal agreementAmt;
    /** 签约主产品类型 */
    private String agreProdType;
    /** 签约渠道 */
    private String signChannel;
    /** 交易机构号 */
    private String tranBranch;
    /** 签约日期 */
    private Date signDate;
    /** 本汇票签约柜员号 */
    private String signUserId;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 协议状态 */
    private String agreementStatus;
    /** 允许签约后销户标志 */
    private String agreementCloseAcctFlag;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户名称 */
    private String acctName;
    /** 客户号 */
    private String clientNo;
    /** 客户简称 */
    private String clientShort;
    /** 对方账户内部键 */
    private Integer oppositeInternalKey;
    /** 协议签订日期 */
    private Date agreementOpenDate;
    /** 解约机构号 */
    private String outSignBranch;
    /** 解约渠道编号 */
    private String outSignChannel;
    /** 解约日期 */
    private Date outSignDate;
    /** 解约柜员号 */
    private String outSignUserId;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getSignBranch() {
        return signBranch;
    }

    public void setSignBranch(String signBranch) {
        this.signBranch = signBranch;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public String getAgreementClass() {
        return agreementClass;
    }

    public void setAgreementClass(String agreementClass) {
        this.agreementClass = agreementClass;
    }

    public String getAgreementKeyType() {
        return agreementKeyType;
    }

    public void setAgreementKeyType(String agreementKeyType) {
        this.agreementKeyType = agreementKeyType;
    }

    public String getAgreementKey() {
        return agreementKey;
    }

    public void setAgreementKey(String agreementKey) {
        this.agreementKey = agreementKey;
    }

    public BigDecimal getAgreementAmt() {
        return agreementAmt;
    }

    public void setAgreementAmt(BigDecimal agreementAmt) {
        this.agreementAmt = agreementAmt;
    }

    public String getAgreProdType() {
        return agreProdType;
    }

    public void setAgreProdType(String agreProdType) {
        this.agreProdType = agreProdType;
    }

    public String getSignChannel() {
        return signChannel;
    }

    public void setSignChannel(String signChannel) {
        this.signChannel = signChannel;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(String signUserId) {
        this.signUserId = signUserId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(String agreementCloseAcctFlag) {
        this.agreementCloseAcctFlag = agreementCloseAcctFlag;
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

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientShort() {
        return clientShort;
    }

    public void setClientShort(String clientShort) {
        this.clientShort = clientShort;
    }

    public Integer getOppositeInternalKey() {
        return oppositeInternalKey;
    }

    public void setOppositeInternalKey(Integer oppositeInternalKey) {
        this.oppositeInternalKey = oppositeInternalKey;
    }

    public Date getAgreementOpenDate() {
        return agreementOpenDate;
    }

    public void setAgreementOpenDate(Date agreementOpenDate) {
        this.agreementOpenDate = agreementOpenDate;
    }

    public String getOutSignBranch() {
        return outSignBranch;
    }

    public void setOutSignBranch(String outSignBranch) {
        this.outSignBranch = outSignBranch;
    }

    public String getOutSignChannel() {
        return outSignChannel;
    }

    public void setOutSignChannel(String outSignChannel) {
        this.outSignChannel = outSignChannel;
    }

    public Date getOutSignDate() {
        return outSignDate;
    }

    public void setOutSignDate(Date outSignDate) {
        this.outSignDate = outSignDate;
    }

    public String getOutSignUserId() {
        return outSignUserId;
    }

    public void setOutSignUserId(String outSignUserId) {
        this.outSignUserId = outSignUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
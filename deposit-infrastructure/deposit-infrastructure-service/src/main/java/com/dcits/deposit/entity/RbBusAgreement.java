package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBusAgreement {
    /** 对公存款合约类型 */
    private String rbBusAgreementType;
    /** 合约分类 */
    private String agreementClass;
    /** 产品编号 */
    private String prodNo;
    /** 协议键类型 */
    private String agreementKeyType;
    /** 合约金额 */
    private BigDecimal agreementAmt;
    /** 合约键值描述 */
    private String agreementKey;
    /** 客户号 */
    private String clientNo;
    /** 协议签订日期 */
    private Date agreementOpenDate;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 结束日期 */
    private Date endDate;
    /** 账户币种 */
    private String acctCcy;
    /** 签约日期 */
    private Date signDate;
    /** 解约日期 */
    private Date outSignDate;
    /** 协议编号 */
    private String agreementId;
    /** 签约主产品编号 */
    private String agreProdNo;
    /** 客户简称 */
    private String clientShort;
    /** 解约柜员号 */
    private String outSignUserId;
    /** 签约渠道 */
    private String signChannel;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 账号 */
    private String baseAcctNo;
    /** 解约渠道编号 */
    private String outSignChannel;
    /** 开始日期 */
    private Date startDate;
    /** 签约机构号 */
    private String signBranch;
    /** 解约机构号 */
    private String outSignBranch;
    /** 协议签约生效状态 */
    private String agreementSignEffectStatus;
    /** 交易机构号 */
    private String tranBranch;
    /** 允许签约后销户标志 */
    private String agreementCloseAcctFlag;
    /** 协议签约状态 */
    private String greementSignStatus;
    /** 账户名称 */
    private String acctName;
    /** 账户序号 */
    private String acctSeqNo;
    /** 签约柜员号 */
    private String signUserId;

    public String getRbBusAgreementType() {
        return rbBusAgreementType;
    }

    public void setRbBusAgreementType(String rbBusAgreementType) {
        this.rbBusAgreementType = rbBusAgreementType;
    }

    public String getAgreementClass() {
        return agreementClass;
    }

    public void setAgreementClass(String agreementClass) {
        this.agreementClass = agreementClass;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getAgreementKeyType() {
        return agreementKeyType;
    }

    public void setAgreementKeyType(String agreementKeyType) {
        this.agreementKeyType = agreementKeyType;
    }

    public BigDecimal getAgreementAmt() {
        return agreementAmt;
    }

    public void setAgreementAmt(BigDecimal agreementAmt) {
        this.agreementAmt = agreementAmt;
    }

    public String getAgreementKey() {
        return agreementKey;
    }

    public void setAgreementKey(String agreementKey) {
        this.agreementKey = agreementKey;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getAgreementOpenDate() {
        return agreementOpenDate;
    }

    public void setAgreementOpenDate(Date agreementOpenDate) {
        this.agreementOpenDate = agreementOpenDate;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getOutSignDate() {
        return outSignDate;
    }

    public void setOutSignDate(Date outSignDate) {
        this.outSignDate = outSignDate;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreProdNo() {
        return agreProdNo;
    }

    public void setAgreProdNo(String agreProdNo) {
        this.agreProdNo = agreProdNo;
    }

    public String getClientShort() {
        return clientShort;
    }

    public void setClientShort(String clientShort) {
        this.clientShort = clientShort;
    }

    public String getOutSignUserId() {
        return outSignUserId;
    }

    public void setOutSignUserId(String outSignUserId) {
        this.outSignUserId = outSignUserId;
    }

    public String getSignChannel() {
        return signChannel;
    }

    public void setSignChannel(String signChannel) {
        this.signChannel = signChannel;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getOutSignChannel() {
        return outSignChannel;
    }

    public void setOutSignChannel(String outSignChannel) {
        this.outSignChannel = outSignChannel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSignBranch() {
        return signBranch;
    }

    public void setSignBranch(String signBranch) {
        this.signBranch = signBranch;
    }

    public String getOutSignBranch() {
        return outSignBranch;
    }

    public void setOutSignBranch(String outSignBranch) {
        this.outSignBranch = outSignBranch;
    }

    public String getAgreementSignEffectStatus() {
        return agreementSignEffectStatus;
    }

    public void setAgreementSignEffectStatus(String agreementSignEffectStatus) {
        this.agreementSignEffectStatus = agreementSignEffectStatus;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(String agreementCloseAcctFlag) {
        this.agreementCloseAcctFlag = agreementCloseAcctFlag;
    }

    public String getGreementSignStatus() {
        return greementSignStatus;
    }

    public void setGreementSignStatus(String greementSignStatus) {
        this.greementSignStatus = greementSignStatus;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(String signUserId) {
        this.signUserId = signUserId;
    }
}
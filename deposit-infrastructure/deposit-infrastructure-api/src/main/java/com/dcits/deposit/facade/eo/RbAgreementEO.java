package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAgreementEO {
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 签约机构号 */
    private AcctBranch signBranch;
    /** 合约类型1 */
    private AgreementType agreementType;
    /** 合约分类 */
    private AgreementClass agreementClass;
    /** 协议键类型 */
    private String agreementKeyType;
    /** 合约键值描述 */
    private String agreementKey;
    /** 合约金额 */
    private BigDecimal agreementAmt;
    /** 签约主产品类型 */
    private String agreProdType;
    /** 签约渠道 */
    private SourceType signChannel;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 签约日期 */
    private java.util.Date signDate;
    /** 本汇票签约柜员号 */
    private String signUserId;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 协议状态 */
    private AgreementStatus agreementStatus;
    /** 允许签约后销户标志 */
    private IndividualFlag agreementCloseAcctFlag;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户名称 */
    private String acctName;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 客户简称 */
    private String clientShort;
    /** 对方账户内部键 */
    private Integer oppositeInternalKey;
    /** 协议签订日期 */
    private java.util.Date agreementOpenDate;
    /** 解约机构号 */
    private AcctBranch outSignBranch;
    /** 解约渠道编号 */
    private SourceType outSignChannel;
    /** 解约日期 */
    private java.util.Date outSignDate;
    /** 解约柜员号 */
    private String outSignUserId;
    /** 交易柜员号 */
    private String userId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public AcctBranch getSignBranch() {
        return signBranch;
    }

    public void setSignBranch(AcctBranch signBranch) {
        this.signBranch = signBranch;
    }

    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
    }

    public AgreementClass getAgreementClass() {
        return agreementClass;
    }

    public void setAgreementClass(AgreementClass agreementClass) {
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

    public SourceType getSignChannel() {
        return signChannel;
    }

    public void setSignChannel(SourceType signChannel) {
        this.signChannel = signChannel;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public java.util.Date getSignDate() {
        return signDate;
    }

    public void setSignDate(java.util.Date signDate) {
        this.signDate = signDate;
    }

    public String getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(String signUserId) {
        this.signUserId = signUserId;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public AgreementStatus getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(AgreementStatus agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public IndividualFlag getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(IndividualFlag agreementCloseAcctFlag) {
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

    public java.util.Date getAgreementOpenDate() {
        return agreementOpenDate;
    }

    public void setAgreementOpenDate(java.util.Date agreementOpenDate) {
        this.agreementOpenDate = agreementOpenDate;
    }

    public AcctBranch getOutSignBranch() {
        return outSignBranch;
    }

    public void setOutSignBranch(AcctBranch outSignBranch) {
        this.outSignBranch = outSignBranch;
    }

    public SourceType getOutSignChannel() {
        return outSignChannel;
    }

    public void setOutSignChannel(SourceType outSignChannel) {
        this.outSignChannel = outSignChannel;
    }

    public java.util.Date getOutSignDate() {
        return outSignDate;
    }

    public void setOutSignDate(java.util.Date outSignDate) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
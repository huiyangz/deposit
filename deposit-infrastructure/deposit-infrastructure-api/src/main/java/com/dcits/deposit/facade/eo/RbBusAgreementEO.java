package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusAgreementEO {
    /** 对公存款合约类型 */
    @NotNull
    private RbBusAgreementType rbBusAgreementType;
    /** 合约分类 */
    private AgreementClass agreementClass;
    /** 产品编号 */
    private String prodNo;
    /** 协议键类型 */
    private String agreementKeyType;
    /** 合约金额 */
    private BigDecimal agreementAmt;
    /** 合约键值描述 */
    private String agreementKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 协议签订日期 */
    private java.util.Date agreementOpenDate;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 结束日期 */
    @NotNull
    private java.util.Date endDate;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 签约日期 */
    private java.util.Date signDate;
    /** 解约日期 */
    private java.util.Date outSignDate;
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 签约主产品编号 */
    private String agreProdNo;
    /** 客户简称 */
    private String clientShort;
    /** 解约柜员号 */
    private String outSignUserId;
    /** 签约渠道 */
    private SourceType signChannel;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 账号 */
    private String baseAcctNo;
    /** 解约渠道编号 */
    private SourceType outSignChannel;
    /** 开始日期 */
    @NotNull
    private java.util.Date startDate;
    /** 签约机构号 */
    private TranBranch signBranch;
    /** 解约机构号 */
    private TranBranch outSignBranch;
    /** 协议签约生效状态 */
    private AgreementSignEffectStatus agreementSignEffectStatus;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 允许签约后销户标志 */
    private String agreementCloseAcctFlag;
    /** 协议签约状态 */
    private GreementSignStatus greementSignStatus;
    /** 账户名称 */
    private String acctName;
    /** 账户序号 */
    private String acctSeqNo;
    /** 签约柜员号 */
    private String signUserId;

    public RbBusAgreementType getRbBusAgreementType() {
        return rbBusAgreementType;
    }

    public void setRbBusAgreementType(RbBusAgreementType rbBusAgreementType) {
        this.rbBusAgreementType = rbBusAgreementType;
    }

    public AgreementClass getAgreementClass() {
        return agreementClass;
    }

    public void setAgreementClass(AgreementClass agreementClass) {
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

    public java.util.Date getAgreementOpenDate() {
        return agreementOpenDate;
    }

    public void setAgreementOpenDate(java.util.Date agreementOpenDate) {
        this.agreementOpenDate = agreementOpenDate;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public java.util.Date getSignDate() {
        return signDate;
    }

    public void setSignDate(java.util.Date signDate) {
        this.signDate = signDate;
    }

    public java.util.Date getOutSignDate() {
        return outSignDate;
    }

    public void setOutSignDate(java.util.Date outSignDate) {
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

    public SourceType getSignChannel() {
        return signChannel;
    }

    public void setSignChannel(SourceType signChannel) {
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

    public SourceType getOutSignChannel() {
        return outSignChannel;
    }

    public void setOutSignChannel(SourceType outSignChannel) {
        this.outSignChannel = outSignChannel;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public TranBranch getSignBranch() {
        return signBranch;
    }

    public void setSignBranch(TranBranch signBranch) {
        this.signBranch = signBranch;
    }

    public TranBranch getOutSignBranch() {
        return outSignBranch;
    }

    public void setOutSignBranch(TranBranch outSignBranch) {
        this.outSignBranch = outSignBranch;
    }

    public AgreementSignEffectStatus getAgreementSignEffectStatus() {
        return agreementSignEffectStatus;
    }

    public void setAgreementSignEffectStatus(AgreementSignEffectStatus agreementSignEffectStatus) {
        this.agreementSignEffectStatus = agreementSignEffectStatus;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(String agreementCloseAcctFlag) {
        this.agreementCloseAcctFlag = agreementCloseAcctFlag;
    }

    public GreementSignStatus getGreementSignStatus() {
        return greementSignStatus;
    }

    public void setGreementSignStatus(GreementSignStatus greementSignStatus) {
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
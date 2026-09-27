package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import jakarta.validation.constraints.NotNull;

public class RbBusAgreementYhtEO {
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 扣划利息标志 */
    private String intFlag;
    /** 自有资金子账号标志 */
    private String selfFlag;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 协议签约生效状态 */
    private AgreementSignEffectStatus agreementSignEffectStatus;
    /** 子账户结算方式 */
    private AcctSettleMethod acctSettleMethod;
    /** 上级账户内部键 */
    @NotNull
    private Integer parentInternalKey;
    /** 账户名称 */
    private String acctName;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 账户结算模式 */
    private SettleInd settleInd;
    /** 主协议号 */
    private String mainAgreementId;
    /** 账户虚实标志 */
    private String acctRealFlag;
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 一户通产品编号 */
    private String yhtProdNo;
    /** 下级账户最大序号 */
    private String nextMaxSeqNo;
    /** 一户通账户层级 */
    private String yhtAcctLevel;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 一户通账户标志 */
    private YhtAcctFlag yhtAcctFlag;
    /** 一户通账户结构模式 */
    private YhtAcctOrgSchema yhtAcctOrgSchema;
    /** 内部户透支标志 */
    private String issOdFlag;
    /** 协议签约状态 */
    private GreementSignStatus greementSignStatus;

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(String intFlag) {
        this.intFlag = intFlag;
    }

    public String getSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(String selfFlag) {
        this.selfFlag = selfFlag;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public AgreementSignEffectStatus getAgreementSignEffectStatus() {
        return agreementSignEffectStatus;
    }

    public void setAgreementSignEffectStatus(AgreementSignEffectStatus agreementSignEffectStatus) {
        this.agreementSignEffectStatus = agreementSignEffectStatus;
    }

    public AcctSettleMethod getAcctSettleMethod() {
        return acctSettleMethod;
    }

    public void setAcctSettleMethod(AcctSettleMethod acctSettleMethod) {
        this.acctSettleMethod = acctSettleMethod;
    }

    public Integer getParentInternalKey() {
        return parentInternalKey;
    }

    public void setParentInternalKey(Integer parentInternalKey) {
        this.parentInternalKey = parentInternalKey;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public SettleInd getSettleInd() {
        return settleInd;
    }

    public void setSettleInd(SettleInd settleInd) {
        this.settleInd = settleInd;
    }

    public String getMainAgreementId() {
        return mainAgreementId;
    }

    public void setMainAgreementId(String mainAgreementId) {
        this.mainAgreementId = mainAgreementId;
    }

    public String getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(String acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getYhtProdNo() {
        return yhtProdNo;
    }

    public void setYhtProdNo(String yhtProdNo) {
        this.yhtProdNo = yhtProdNo;
    }

    public String getNextMaxSeqNo() {
        return nextMaxSeqNo;
    }

    public void setNextMaxSeqNo(String nextMaxSeqNo) {
        this.nextMaxSeqNo = nextMaxSeqNo;
    }

    public String getYhtAcctLevel() {
        return yhtAcctLevel;
    }

    public void setYhtAcctLevel(String yhtAcctLevel) {
        this.yhtAcctLevel = yhtAcctLevel;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public YhtAcctFlag getYhtAcctFlag() {
        return yhtAcctFlag;
    }

    public void setYhtAcctFlag(YhtAcctFlag yhtAcctFlag) {
        this.yhtAcctFlag = yhtAcctFlag;
    }

    public YhtAcctOrgSchema getYhtAcctOrgSchema() {
        return yhtAcctOrgSchema;
    }

    public void setYhtAcctOrgSchema(YhtAcctOrgSchema yhtAcctOrgSchema) {
        this.yhtAcctOrgSchema = yhtAcctOrgSchema;
    }

    public String getIssOdFlag() {
        return issOdFlag;
    }

    public void setIssOdFlag(String issOdFlag) {
        this.issOdFlag = issOdFlag;
    }

    public GreementSignStatus getGreementSignStatus() {
        return greementSignStatus;
    }

    public void setGreementSignStatus(GreementSignStatus greementSignStatus) {
        this.greementSignStatus = greementSignStatus;
    }
}
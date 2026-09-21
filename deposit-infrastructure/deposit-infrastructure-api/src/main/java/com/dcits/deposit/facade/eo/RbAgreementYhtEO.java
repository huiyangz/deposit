package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import jakarta.validation.constraints.NotNull;

public class RbAgreementYhtEO {
    /** 协议编号 */
    @NotNull
    private String agreementId;
    /** 主协议号 */
    private String mainAgreementId;
    /** 协议状态 */
    private AgreementStatus agreementStatus;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 上级账户内部键 */
    private Integer parentInternalKey;
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
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户虚实标志 */
    private IndividualFlag acctRealFlag;
    /** 下级账户最大序号 */
    private String nextMaxSeqNo;
    /** 自有资金子账号标志 */
    private IndividualFlag selfFlag;
    /** 扣划利息标志 */
    private IndividualFlag intFlag;
    /** 账户结算模式 */
    private SettleInd settleInd;
    /** 一户通产品类型 */
    private String yhtProdType;
    /** 一户通账户标志 */
    private YhtAcctFlag yhtAcctFlag;
    /** 一户通账户层级 */
    private String yhtAcctLevel;
    /** 一户通主账户标志 */
    private YhtAcctFlag yhtAcctMainFlag;
    /** 一户通账户结构模式 */
    private YhtAcctOrgSchema yhtAcctOrgSchema;
    /** 内部户透支标志 */
    private IndividualFlag issOdFlag;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 是否未移植数据 */
    private String nonTransplantFlag;
    /** 子账户结算方式 */
    private AcctSettleMethod acctSettleMethod;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getMainAgreementId() {
        return mainAgreementId;
    }

    public void setMainAgreementId(String mainAgreementId) {
        this.mainAgreementId = mainAgreementId;
    }

    public AgreementStatus getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(AgreementStatus agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public Integer getParentInternalKey() {
        return parentInternalKey;
    }

    public void setParentInternalKey(Integer parentInternalKey) {
        this.parentInternalKey = parentInternalKey;
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

    public String getAltAcctName() {
        return altAcctName;
    }

    public void setAltAcctName(String altAcctName) {
        this.altAcctName = altAcctName;
    }

    public IndividualFlag getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(IndividualFlag acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public String getNextMaxSeqNo() {
        return nextMaxSeqNo;
    }

    public void setNextMaxSeqNo(String nextMaxSeqNo) {
        this.nextMaxSeqNo = nextMaxSeqNo;
    }

    public IndividualFlag getSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(IndividualFlag selfFlag) {
        this.selfFlag = selfFlag;
    }

    public IndividualFlag getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(IndividualFlag intFlag) {
        this.intFlag = intFlag;
    }

    public SettleInd getSettleInd() {
        return settleInd;
    }

    public void setSettleInd(SettleInd settleInd) {
        this.settleInd = settleInd;
    }

    public String getYhtProdType() {
        return yhtProdType;
    }

    public void setYhtProdType(String yhtProdType) {
        this.yhtProdType = yhtProdType;
    }

    public YhtAcctFlag getYhtAcctFlag() {
        return yhtAcctFlag;
    }

    public void setYhtAcctFlag(YhtAcctFlag yhtAcctFlag) {
        this.yhtAcctFlag = yhtAcctFlag;
    }

    public String getYhtAcctLevel() {
        return yhtAcctLevel;
    }

    public void setYhtAcctLevel(String yhtAcctLevel) {
        this.yhtAcctLevel = yhtAcctLevel;
    }

    public YhtAcctFlag getYhtAcctMainFlag() {
        return yhtAcctMainFlag;
    }

    public void setYhtAcctMainFlag(YhtAcctFlag yhtAcctMainFlag) {
        this.yhtAcctMainFlag = yhtAcctMainFlag;
    }

    public YhtAcctOrgSchema getYhtAcctOrgSchema() {
        return yhtAcctOrgSchema;
    }

    public void setYhtAcctOrgSchema(YhtAcctOrgSchema yhtAcctOrgSchema) {
        this.yhtAcctOrgSchema = yhtAcctOrgSchema;
    }

    public IndividualFlag getIssOdFlag() {
        return issOdFlag;
    }

    public void setIssOdFlag(IndividualFlag issOdFlag) {
        this.issOdFlag = issOdFlag;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public String getNonTransplantFlag() {
        return nonTransplantFlag;
    }

    public void setNonTransplantFlag(String nonTransplantFlag) {
        this.nonTransplantFlag = nonTransplantFlag;
    }

    public AcctSettleMethod getAcctSettleMethod() {
        return acctSettleMethod;
    }

    public void setAcctSettleMethod(AcctSettleMethod acctSettleMethod) {
        this.acctSettleMethod = acctSettleMethod;
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
}
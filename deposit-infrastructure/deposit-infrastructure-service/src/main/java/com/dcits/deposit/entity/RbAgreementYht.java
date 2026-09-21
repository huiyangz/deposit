package com.dcits.deposit.entity;

import java.util.Date;

public class RbAgreementYht {
    /** 协议编号 */
    private String agreementId;
    /** 主协议号 */
    private String mainAgreementId;
    /** 协议状态 */
    private String agreementStatus;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 上级账户内部键 */
    private Integer parentInternalKey;
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
    /** 备用账户名称 */
    private String altAcctName;
    /** 账户虚实标志 */
    private String acctRealFlag;
    /** 下级账户最大序号 */
    private String nextMaxSeqNo;
    /** 自有资金子账号标志 */
    private String selfFlag;
    /** 扣划利息标志 */
    private String intFlag;
    /** 账户结算模式 */
    private String settleInd;
    /** 一户通产品类型 */
    private String yhtProdType;
    /** 一户通账户标志 */
    private String yhtAcctFlag;
    /** 一户通账户层级 */
    private String yhtAcctLevel;
    /** 一户通主账户标志 */
    private String yhtAcctMainFlag;
    /** 一户通账户结构模式 */
    private String yhtAcctOrgSchema;
    /** 内部户透支标志 */
    private String issOdFlag;
    /** 渠道类型 */
    private String sourceType;
    /** 客户号 */
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 是否未移植数据 */
    private String nonTransplantFlag;
    /** 子账户结算方式 */
    private String acctSettleMethod;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

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

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
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

    public String getAltAcctName() {
        return altAcctName;
    }

    public void setAltAcctName(String altAcctName) {
        this.altAcctName = altAcctName;
    }

    public String getAcctRealFlag() {
        return acctRealFlag;
    }

    public void setAcctRealFlag(String acctRealFlag) {
        this.acctRealFlag = acctRealFlag;
    }

    public String getNextMaxSeqNo() {
        return nextMaxSeqNo;
    }

    public void setNextMaxSeqNo(String nextMaxSeqNo) {
        this.nextMaxSeqNo = nextMaxSeqNo;
    }

    public String getSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(String selfFlag) {
        this.selfFlag = selfFlag;
    }

    public String getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(String intFlag) {
        this.intFlag = intFlag;
    }

    public String getSettleInd() {
        return settleInd;
    }

    public void setSettleInd(String settleInd) {
        this.settleInd = settleInd;
    }

    public String getYhtProdType() {
        return yhtProdType;
    }

    public void setYhtProdType(String yhtProdType) {
        this.yhtProdType = yhtProdType;
    }

    public String getYhtAcctFlag() {
        return yhtAcctFlag;
    }

    public void setYhtAcctFlag(String yhtAcctFlag) {
        this.yhtAcctFlag = yhtAcctFlag;
    }

    public String getYhtAcctLevel() {
        return yhtAcctLevel;
    }

    public void setYhtAcctLevel(String yhtAcctLevel) {
        this.yhtAcctLevel = yhtAcctLevel;
    }

    public String getYhtAcctMainFlag() {
        return yhtAcctMainFlag;
    }

    public void setYhtAcctMainFlag(String yhtAcctMainFlag) {
        this.yhtAcctMainFlag = yhtAcctMainFlag;
    }

    public String getYhtAcctOrgSchema() {
        return yhtAcctOrgSchema;
    }

    public void setYhtAcctOrgSchema(String yhtAcctOrgSchema) {
        this.yhtAcctOrgSchema = yhtAcctOrgSchema;
    }

    public String getIssOdFlag() {
        return issOdFlag;
    }

    public void setIssOdFlag(String issOdFlag) {
        this.issOdFlag = issOdFlag;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNonTransplantFlag() {
        return nonTransplantFlag;
    }

    public void setNonTransplantFlag(String nonTransplantFlag) {
        this.nonTransplantFlag = nonTransplantFlag;
    }

    public String getAcctSettleMethod() {
        return acctSettleMethod;
    }

    public void setAcctSettleMethod(String acctSettleMethod) {
        this.acctSettleMethod = acctSettleMethod;
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
}
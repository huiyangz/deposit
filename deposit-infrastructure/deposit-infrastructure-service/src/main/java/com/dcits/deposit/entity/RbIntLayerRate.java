package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbIntLayerRate {
    /** 费率编号 */
    private String irlSeqNo;
    /** 协议编号 */
    private String agreementId;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    private String clientNo;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 账户利率浮动百分比 */
    private BigDecimal acctPercentRate;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 分段周期 */
    private String nearPeriod;
    /** 分段周期类型 */
    private String nearPeriodType;
    /** 开始日期 */
    private Date startDate;
    /** 结束日期 */
    private Date endDate;
    /** 计提天数 */
    private Integer accrDays;
    /** 计提金额 */
    private BigDecimal accrAmt;
    /** 靠档金额 */
    private BigDecimal nearAmt;
    /** 利息分类 */
    private String intClass;
    /** 利率类型 */
    private String intType;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 月基准 */
    private String monthBasis;
    /** 年基准天数 */
    private String yearBasis;
    /** 系统编号 */
    private String systemId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getIrlSeqNo() {
        return irlSeqNo;
    }

    public void setIrlSeqNo(String irlSeqNo) {
        this.irlSeqNo = irlSeqNo;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public BigDecimal getAcctFixedRate() {
        return acctFixedRate;
    }

    public void setAcctFixedRate(BigDecimal acctFixedRate) {
        this.acctFixedRate = acctFixedRate;
    }

    public BigDecimal getAcctPercentRate() {
        return acctPercentRate;
    }

    public void setAcctPercentRate(BigDecimal acctPercentRate) {
        this.acctPercentRate = acctPercentRate;
    }

    public BigDecimal getAcctSpreadRate() {
        return acctSpreadRate;
    }

    public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
        this.acctSpreadRate = acctSpreadRate;
    }

    public String getNearPeriod() {
        return nearPeriod;
    }

    public void setNearPeriod(String nearPeriod) {
        this.nearPeriod = nearPeriod;
    }

    public String getNearPeriodType() {
        return nearPeriodType;
    }

    public void setNearPeriodType(String nearPeriodType) {
        this.nearPeriodType = nearPeriodType;
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

    public Integer getAccrDays() {
        return accrDays;
    }

    public void setAccrDays(Integer accrDays) {
        this.accrDays = accrDays;
    }

    public BigDecimal getAccrAmt() {
        return accrAmt;
    }

    public void setAccrAmt(BigDecimal accrAmt) {
        this.accrAmt = accrAmt;
    }

    public BigDecimal getNearAmt() {
        return nearAmt;
    }

    public void setNearAmt(BigDecimal nearAmt) {
        this.nearAmt = nearAmt;
    }

    public String getIntClass() {
        return intClass;
    }

    public void setIntClass(String intClass) {
        this.intClass = intClass;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public String getMonthBasis() {
        return monthBasis;
    }

    public void setMonthBasis(String monthBasis) {
        this.monthBasis = monthBasis;
    }

    public String getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(String yearBasis) {
        this.yearBasis = yearBasis;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
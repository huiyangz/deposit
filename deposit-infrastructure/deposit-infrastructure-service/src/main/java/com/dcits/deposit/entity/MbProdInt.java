package com.dcits.deposit.entity;

import java.math.BigDecimal;

public class MbProdInt {
    /** 产品类型 */
    private String prodType;
    /** 事件类型 */
    private String eventType;
    /** 利息分类 */
    private String intClass;
    /** 利率类型 */
    private String intType;
    /** 税率类型 */
    private String taxType;
    /** 账户利率使用标志 */
    private String acctRateFlag;
    /** 利息计算方法 */
    private String intCalcMethod;
    /** 利率分层规则 */
    private String rateLayerRule;
    /** 利率靠档金额类型 */
    private String rateGearAmtType;
    /** 金额靠档方向 */
    private String gearAmtInd;
    /** 金额靠档方式 */
    private String gearAmtMethod;
    /** 天数靠档方向 */
    private String gearDaysInd;
    /** 天数靠档方式 */
    private String gearDaysMethod;
    /** 利息计算金额类型 */
    private String intCalcAmtType;
    /** 计息生效日期计算方法 */
    private String effectDateCalcMethod;
    /** 靠档天数计算类型 */
    private String daysGearType;
    /** 利率启用方式 */
    private String intApplType;
    /** 月基准 */
    private String monthBasis;
    /** 分组规则类型 */
    private String groupRuleType;
    /** 利息生效规则 */
    private String intMatchRule;
    /** 利息重算方法 */
    private String intRecalcMethod;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 利率变更日 */
    private String rollDay;
    /** 利率变更周期 */
    private String rollFreq;
    /** 是否截位标志 */
    private String roundDownFlag;
    /** 利率类型表达式 */
    private String intTypeExp;
    /** 月基准表达式 */
    private String monthBasisExp;
    /** 分组规则表达式 */
    private String groupRuleTypeExp;
    /** 最小利率表达式 */
    private String minRateExp;
    /** 最大利率表达式 */
    private String maxRateExp;
    /** 利息计算方法表达式 */
    private String intCalcMethodExp;
    /** 利息计算金额类型表达式 */
    private String intCalcAmtTypeExp;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 利率浮动标志 */
    private String calcByInt;
    /** 年基准天数 */
    private String yearBasis;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getAcctRateFlag() {
        return acctRateFlag;
    }

    public void setAcctRateFlag(String acctRateFlag) {
        this.acctRateFlag = acctRateFlag;
    }

    public String getIntCalcMethod() {
        return intCalcMethod;
    }

    public void setIntCalcMethod(String intCalcMethod) {
        this.intCalcMethod = intCalcMethod;
    }

    public String getRateLayerRule() {
        return rateLayerRule;
    }

    public void setRateLayerRule(String rateLayerRule) {
        this.rateLayerRule = rateLayerRule;
    }

    public String getRateGearAmtType() {
        return rateGearAmtType;
    }

    public void setRateGearAmtType(String rateGearAmtType) {
        this.rateGearAmtType = rateGearAmtType;
    }

    public String getGearAmtInd() {
        return gearAmtInd;
    }

    public void setGearAmtInd(String gearAmtInd) {
        this.gearAmtInd = gearAmtInd;
    }

    public String getGearAmtMethod() {
        return gearAmtMethod;
    }

    public void setGearAmtMethod(String gearAmtMethod) {
        this.gearAmtMethod = gearAmtMethod;
    }

    public String getGearDaysInd() {
        return gearDaysInd;
    }

    public void setGearDaysInd(String gearDaysInd) {
        this.gearDaysInd = gearDaysInd;
    }

    public String getGearDaysMethod() {
        return gearDaysMethod;
    }

    public void setGearDaysMethod(String gearDaysMethod) {
        this.gearDaysMethod = gearDaysMethod;
    }

    public String getIntCalcAmtType() {
        return intCalcAmtType;
    }

    public void setIntCalcAmtType(String intCalcAmtType) {
        this.intCalcAmtType = intCalcAmtType;
    }

    public String getEffectDateCalcMethod() {
        return effectDateCalcMethod;
    }

    public void setEffectDateCalcMethod(String effectDateCalcMethod) {
        this.effectDateCalcMethod = effectDateCalcMethod;
    }

    public String getDaysGearType() {
        return daysGearType;
    }

    public void setDaysGearType(String daysGearType) {
        this.daysGearType = daysGearType;
    }

    public String getIntApplType() {
        return intApplType;
    }

    public void setIntApplType(String intApplType) {
        this.intApplType = intApplType;
    }

    public String getMonthBasis() {
        return monthBasis;
    }

    public void setMonthBasis(String monthBasis) {
        this.monthBasis = monthBasis;
    }

    public String getGroupRuleType() {
        return groupRuleType;
    }

    public void setGroupRuleType(String groupRuleType) {
        this.groupRuleType = groupRuleType;
    }

    public String getIntMatchRule() {
        return intMatchRule;
    }

    public void setIntMatchRule(String intMatchRule) {
        this.intMatchRule = intMatchRule;
    }

    public String getIntRecalcMethod() {
        return intRecalcMethod;
    }

    public void setIntRecalcMethod(String intRecalcMethod) {
        this.intRecalcMethod = intRecalcMethod;
    }

    public BigDecimal getMinRate() {
        return minRate;
    }

    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    public String getRollDay() {
        return rollDay;
    }

    public void setRollDay(String rollDay) {
        this.rollDay = rollDay;
    }

    public String getRollFreq() {
        return rollFreq;
    }

    public void setRollFreq(String rollFreq) {
        this.rollFreq = rollFreq;
    }

    public String getRoundDownFlag() {
        return roundDownFlag;
    }

    public void setRoundDownFlag(String roundDownFlag) {
        this.roundDownFlag = roundDownFlag;
    }

    public String getIntTypeExp() {
        return intTypeExp;
    }

    public void setIntTypeExp(String intTypeExp) {
        this.intTypeExp = intTypeExp;
    }

    public String getMonthBasisExp() {
        return monthBasisExp;
    }

    public void setMonthBasisExp(String monthBasisExp) {
        this.monthBasisExp = monthBasisExp;
    }

    public String getGroupRuleTypeExp() {
        return groupRuleTypeExp;
    }

    public void setGroupRuleTypeExp(String groupRuleTypeExp) {
        this.groupRuleTypeExp = groupRuleTypeExp;
    }

    public String getMinRateExp() {
        return minRateExp;
    }

    public void setMinRateExp(String minRateExp) {
        this.minRateExp = minRateExp;
    }

    public String getMaxRateExp() {
        return maxRateExp;
    }

    public void setMaxRateExp(String maxRateExp) {
        this.maxRateExp = maxRateExp;
    }

    public String getIntCalcMethodExp() {
        return intCalcMethodExp;
    }

    public void setIntCalcMethodExp(String intCalcMethodExp) {
        this.intCalcMethodExp = intCalcMethodExp;
    }

    public String getIntCalcAmtTypeExp() {
        return intCalcAmtTypeExp;
    }

    public void setIntCalcAmtTypeExp(String intCalcAmtTypeExp) {
        this.intCalcAmtTypeExp = intCalcAmtTypeExp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public BigDecimal getSpreadPercent() {
        return spreadPercent;
    }

    public void setSpreadPercent(BigDecimal spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public String getCalcByInt() {
        return calcByInt;
    }

    public void setCalcByInt(String calcByInt) {
        this.calcByInt = calcByInt;
    }

    public String getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(String yearBasis) {
        this.yearBasis = yearBasis;
    }
}
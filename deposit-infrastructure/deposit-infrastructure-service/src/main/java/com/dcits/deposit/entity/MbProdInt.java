package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MbProdInt {
    /** 凭证主键 */
    private Integer voucherId;
    /** 账户利率使用标志 */
    private String acctRateFlag;
    /** 是否截位标志 */
    private String roundDownFlag;
    /** 凭证起始号码 */
    private String voucherStartNo;
    /** 年基准天数类型 */
    private String yearBasisType;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 凭证状态 */
    private String voucherStatus;
    /** 尾箱编号 */
    private String tailboxId;
    /** 上日期末凭证总数 */
    private Integer eopdVoucherSum;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 利息生效规则 */
    private String intMatchRule;
    /** 月基准天数类型 */
    private String monthBasisType;
    /** 起始号码数值 */
    private Integer startNoInt;
    /** 最大利率表达式 */
    private String maxRateExp;
    /** 凭证前缀编码 */
    private String prefix;
    /** 最小利率表达式 */
    private String minRateExp;
    /** 金额靠档方式 */
    private String gearAmtMethod;
    /** 利率变更日 */
    private String rollDay;
    /** 产品编号 */
    private String prodNo;
    /** 利息计算方法 */
    private String intCalcMethod;
    /** 上一柜员号 */
    private String lastUserId;
    /** 归属机构号 */
    private String branch;
    /** 天数靠档方向 */
    private String gearDaysInd;
    /** 更新日期 */
    private Date updateDate;
    /** 利率类型 */
    private String intType;
    /** 金额靠档方向 */
    private String gearAmtInd;
    /** 靠档天数计算类型 */
    private String daysGearType;
    /** 利率变更方式 */
    private String intChangeType;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 计息生效日期计算方法 */
    private String effectDateCalcMethod;
    /** 分组规则表达式 */
    private String groupRuleTypeExp;
    /** 利率分层规则 */
    private String rateLayerRule;
    /** 分组规则类型 */
    private String groupRuleType;
    /** 利率变更周期 */
    private String rollFreq;
    /** 利息计算金额类型 */
    private String intCalcAmtType;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 凭证类型 */
    private String docType;
    /** 上日期初凭证总数 */
    private Integer sopdVoucherSum;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 利息重算方法 */
    private String intRecalcMethod;
    /** 税率类型编号 */
    private String taxTypeNo;
    /** 事件类型 */
    private String eventType;
    /** 利率浮动标志 */
    private String calcByInt;
    /** 凭证终止号码 */
    private String voucherEndNo;
    /** 天数靠档方式 */
    private String gearDaysMethod;
    /** 月基准表达式 */
    private String monthBasisExp;
    /** 利率靠档金额类型 */
    private String rateGearAmtType;
    /** 凭证合计数 */
    private Integer voucherSum;
    /** 利息分类 */
    private String intClass;
    /** 利息计算金额类型表达式 */
    private String intCalcAmtTypeExp;
    /** 利息计算方法表达式 */
    private String intCalcMethodExp;
    /** 终止号码数值 */
    private Integer endNoInt;
    /** 利率类型表达式 */
    private String intTypeExp;

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getAcctRateFlag() {
        return acctRateFlag;
    }

    public void setAcctRateFlag(String acctRateFlag) {
        this.acctRateFlag = acctRateFlag;
    }

    public String getRoundDownFlag() {
        return roundDownFlag;
    }

    public void setRoundDownFlag(String roundDownFlag) {
        this.roundDownFlag = roundDownFlag;
    }

    public String getVoucherStartNo() {
        return voucherStartNo;
    }

    public void setVoucherStartNo(String voucherStartNo) {
        this.voucherStartNo = voucherStartNo;
    }

    public String getYearBasisType() {
        return yearBasisType;
    }

    public void setYearBasisType(String yearBasisType) {
        this.yearBasisType = yearBasisType;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    public String getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public Integer getEopdVoucherSum() {
        return eopdVoucherSum;
    }

    public void setEopdVoucherSum(Integer eopdVoucherSum) {
        this.eopdVoucherSum = eopdVoucherSum;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public String getIntMatchRule() {
        return intMatchRule;
    }

    public void setIntMatchRule(String intMatchRule) {
        this.intMatchRule = intMatchRule;
    }

    public String getMonthBasisType() {
        return monthBasisType;
    }

    public void setMonthBasisType(String monthBasisType) {
        this.monthBasisType = monthBasisType;
    }

    public Integer getStartNoInt() {
        return startNoInt;
    }

    public void setStartNoInt(Integer startNoInt) {
        this.startNoInt = startNoInt;
    }

    public String getMaxRateExp() {
        return maxRateExp;
    }

    public void setMaxRateExp(String maxRateExp) {
        this.maxRateExp = maxRateExp;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getMinRateExp() {
        return minRateExp;
    }

    public void setMinRateExp(String minRateExp) {
        this.minRateExp = minRateExp;
    }

    public String getGearAmtMethod() {
        return gearAmtMethod;
    }

    public void setGearAmtMethod(String gearAmtMethod) {
        this.gearAmtMethod = gearAmtMethod;
    }

    public String getRollDay() {
        return rollDay;
    }

    public void setRollDay(String rollDay) {
        this.rollDay = rollDay;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getIntCalcMethod() {
        return intCalcMethod;
    }

    public void setIntCalcMethod(String intCalcMethod) {
        this.intCalcMethod = intCalcMethod;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGearDaysInd() {
        return gearDaysInd;
    }

    public void setGearDaysInd(String gearDaysInd) {
        this.gearDaysInd = gearDaysInd;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public String getGearAmtInd() {
        return gearAmtInd;
    }

    public void setGearAmtInd(String gearAmtInd) {
        this.gearAmtInd = gearAmtInd;
    }

    public String getDaysGearType() {
        return daysGearType;
    }

    public void setDaysGearType(String daysGearType) {
        this.daysGearType = daysGearType;
    }

    public String getIntChangeType() {
        return intChangeType;
    }

    public void setIntChangeType(String intChangeType) {
        this.intChangeType = intChangeType;
    }

    public BigDecimal getMinRate() {
        return minRate;
    }

    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    public String getEffectDateCalcMethod() {
        return effectDateCalcMethod;
    }

    public void setEffectDateCalcMethod(String effectDateCalcMethod) {
        this.effectDateCalcMethod = effectDateCalcMethod;
    }

    public String getGroupRuleTypeExp() {
        return groupRuleTypeExp;
    }

    public void setGroupRuleTypeExp(String groupRuleTypeExp) {
        this.groupRuleTypeExp = groupRuleTypeExp;
    }

    public String getRateLayerRule() {
        return rateLayerRule;
    }

    public void setRateLayerRule(String rateLayerRule) {
        this.rateLayerRule = rateLayerRule;
    }

    public String getGroupRuleType() {
        return groupRuleType;
    }

    public void setGroupRuleType(String groupRuleType) {
        this.groupRuleType = groupRuleType;
    }

    public String getRollFreq() {
        return rollFreq;
    }

    public void setRollFreq(String rollFreq) {
        this.rollFreq = rollFreq;
    }

    public String getIntCalcAmtType() {
        return intCalcAmtType;
    }

    public void setIntCalcAmtType(String intCalcAmtType) {
        this.intCalcAmtType = intCalcAmtType;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getSopdVoucherSum() {
        return sopdVoucherSum;
    }

    public void setSopdVoucherSum(Integer sopdVoucherSum) {
        this.sopdVoucherSum = sopdVoucherSum;
    }

    public BigDecimal getSpreadPercent() {
        return spreadPercent;
    }

    public void setSpreadPercent(BigDecimal spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getIntRecalcMethod() {
        return intRecalcMethod;
    }

    public void setIntRecalcMethod(String intRecalcMethod) {
        this.intRecalcMethod = intRecalcMethod;
    }

    public String getTaxTypeNo() {
        return taxTypeNo;
    }

    public void setTaxTypeNo(String taxTypeNo) {
        this.taxTypeNo = taxTypeNo;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCalcByInt() {
        return calcByInt;
    }

    public void setCalcByInt(String calcByInt) {
        this.calcByInt = calcByInt;
    }

    public String getVoucherEndNo() {
        return voucherEndNo;
    }

    public void setVoucherEndNo(String voucherEndNo) {
        this.voucherEndNo = voucherEndNo;
    }

    public String getGearDaysMethod() {
        return gearDaysMethod;
    }

    public void setGearDaysMethod(String gearDaysMethod) {
        this.gearDaysMethod = gearDaysMethod;
    }

    public String getMonthBasisExp() {
        return monthBasisExp;
    }

    public void setMonthBasisExp(String monthBasisExp) {
        this.monthBasisExp = monthBasisExp;
    }

    public String getRateGearAmtType() {
        return rateGearAmtType;
    }

    public void setRateGearAmtType(String rateGearAmtType) {
        this.rateGearAmtType = rateGearAmtType;
    }

    public Integer getVoucherSum() {
        return voucherSum;
    }

    public void setVoucherSum(Integer voucherSum) {
        this.voucherSum = voucherSum;
    }

    public String getIntClass() {
        return intClass;
    }

    public void setIntClass(String intClass) {
        this.intClass = intClass;
    }

    public String getIntCalcAmtTypeExp() {
        return intCalcAmtTypeExp;
    }

    public void setIntCalcAmtTypeExp(String intCalcAmtTypeExp) {
        this.intCalcAmtTypeExp = intCalcAmtTypeExp;
    }

    public String getIntCalcMethodExp() {
        return intCalcMethodExp;
    }

    public void setIntCalcMethodExp(String intCalcMethodExp) {
        this.intCalcMethodExp = intCalcMethodExp;
    }

    public Integer getEndNoInt() {
        return endNoInt;
    }

    public void setEndNoInt(Integer endNoInt) {
        this.endNoInt = endNoInt;
    }

    public String getIntTypeExp() {
        return intTypeExp;
    }

    public void setIntTypeExp(String intTypeExp) {
        this.intTypeExp = intTypeExp;
    }
}
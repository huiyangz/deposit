package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.GearAmtInd;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbProdIntEO {
    /** 产品类型 */
    @NotNull
    private String prodType;
    /** 事件类型 */
    @NotNull
    private String eventType;
    /** 利息分类 */
    @NotNull
    private IntClass intClass;
    /** 利率类型 */
    @NotNull
    private IntType intType;
    /** 税率类型 */
    private TaxType taxType;
    /** 账户利率使用标志 */
    private IndividualFlag acctRateFlag;
    /** 利息计算方法 */
    private IntCalcMethod intCalcMethod;
    /** 利率分层规则 */
    private RateLayerRule rateLayerRule;
    /** 利率靠档金额类型 */
    private AmtType rateGearAmtType;
    /** 金额靠档方向 */
    private GearAmtInd gearAmtInd;
    /** 金额靠档方式 */
    private GearAmtMethod gearAmtMethod;
    /** 天数靠档方向 */
    private GearAmtInd gearDaysInd;
    /** 天数靠档方式 */
    private GearAmtMethod gearDaysMethod;
    /** 利息计算金额类型 */
    private AmtType intCalcAmtType;
    /** 计息生效日期计算方法 */
    private EffectDateCalcMethod effectDateCalcMethod;
    /** 靠档天数计算类型 */
    private DaysGearType daysGearType;
    /** 利率启用方式 */
    private IntApplType intApplType;
    /** 月基准 */
    private MonthBasis monthBasis;
    /** 分组规则类型 */
    private GroupRuleType groupRuleType;
    /** 利息生效规则 */
    private IntMatchRule intMatchRule;
    /** 利息重算方法 */
    private IntRecalcMethod intRecalcMethod;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 利率变更日 */
    private String rollDay;
    /** 利率变更周期 */
    private CycleFreq rollFreq;
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
    @NotNull
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 利率浮动标志 */
    private IndividualFlag calcByInt;
    /** 年基准天数 */
    private YearBasis yearBasis;

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

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
        this.intClass = intClass;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public IndividualFlag getAcctRateFlag() {
        return acctRateFlag;
    }

    public void setAcctRateFlag(IndividualFlag acctRateFlag) {
        this.acctRateFlag = acctRateFlag;
    }

    public IntCalcMethod getIntCalcMethod() {
        return intCalcMethod;
    }

    public void setIntCalcMethod(IntCalcMethod intCalcMethod) {
        this.intCalcMethod = intCalcMethod;
    }

    public RateLayerRule getRateLayerRule() {
        return rateLayerRule;
    }

    public void setRateLayerRule(RateLayerRule rateLayerRule) {
        this.rateLayerRule = rateLayerRule;
    }

    public AmtType getRateGearAmtType() {
        return rateGearAmtType;
    }

    public void setRateGearAmtType(AmtType rateGearAmtType) {
        this.rateGearAmtType = rateGearAmtType;
    }

    public GearAmtInd getGearAmtInd() {
        return gearAmtInd;
    }

    public void setGearAmtInd(GearAmtInd gearAmtInd) {
        this.gearAmtInd = gearAmtInd;
    }

    public GearAmtMethod getGearAmtMethod() {
        return gearAmtMethod;
    }

    public void setGearAmtMethod(GearAmtMethod gearAmtMethod) {
        this.gearAmtMethod = gearAmtMethod;
    }

    public GearAmtInd getGearDaysInd() {
        return gearDaysInd;
    }

    public void setGearDaysInd(GearAmtInd gearDaysInd) {
        this.gearDaysInd = gearDaysInd;
    }

    public GearAmtMethod getGearDaysMethod() {
        return gearDaysMethod;
    }

    public void setGearDaysMethod(GearAmtMethod gearDaysMethod) {
        this.gearDaysMethod = gearDaysMethod;
    }

    public AmtType getIntCalcAmtType() {
        return intCalcAmtType;
    }

    public void setIntCalcAmtType(AmtType intCalcAmtType) {
        this.intCalcAmtType = intCalcAmtType;
    }

    public EffectDateCalcMethod getEffectDateCalcMethod() {
        return effectDateCalcMethod;
    }

    public void setEffectDateCalcMethod(EffectDateCalcMethod effectDateCalcMethod) {
        this.effectDateCalcMethod = effectDateCalcMethod;
    }

    public DaysGearType getDaysGearType() {
        return daysGearType;
    }

    public void setDaysGearType(DaysGearType daysGearType) {
        this.daysGearType = daysGearType;
    }

    public IntApplType getIntApplType() {
        return intApplType;
    }

    public void setIntApplType(IntApplType intApplType) {
        this.intApplType = intApplType;
    }

    public MonthBasis getMonthBasis() {
        return monthBasis;
    }

    public void setMonthBasis(MonthBasis monthBasis) {
        this.monthBasis = monthBasis;
    }

    public GroupRuleType getGroupRuleType() {
        return groupRuleType;
    }

    public void setGroupRuleType(GroupRuleType groupRuleType) {
        this.groupRuleType = groupRuleType;
    }

    public IntMatchRule getIntMatchRule() {
        return intMatchRule;
    }

    public void setIntMatchRule(IntMatchRule intMatchRule) {
        this.intMatchRule = intMatchRule;
    }

    public IntRecalcMethod getIntRecalcMethod() {
        return intRecalcMethod;
    }

    public void setIntRecalcMethod(IntRecalcMethod intRecalcMethod) {
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

    public CycleFreq getRollFreq() {
        return rollFreq;
    }

    public void setRollFreq(CycleFreq rollFreq) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public IndividualFlag getCalcByInt() {
        return calcByInt;
    }

    public void setCalcByInt(IndividualFlag calcByInt) {
        this.calcByInt = calcByInt;
    }

    public YearBasis getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(YearBasis yearBasis) {
        this.yearBasis = yearBasis;
    }
}
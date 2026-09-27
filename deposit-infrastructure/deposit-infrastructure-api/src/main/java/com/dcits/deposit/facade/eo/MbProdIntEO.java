package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.GearDaysInd;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.YearBasisType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbProdIntEO {
    /** 凭证主键 */
    @NotNull
    private Integer voucherId;
    /** 账户利率使用标志 */
    private String acctRateFlag;
    /** 是否截位标志 */
    private String roundDownFlag;
    /** 凭证起始号码 */
    @NotNull
    private String voucherStartNo;
    /** 年基准天数类型 */
    private YearBasisType yearBasisType;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 凭证状态 */
    @NotNull
    private VoucherStatus voucherStatus;
    /** 尾箱编号 */
    @NotNull
    private String tailboxId;
    /** 上日期末凭证总数 */
    private Integer eopdVoucherSum;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 利息生效规则 */
    private IntMatchRule intMatchRule;
    /** 月基准天数类型 */
    private MonthBasisType monthBasisType;
    /** 起始号码数值 */
    private Integer startNoInt;
    /** 最大利率表达式 */
    private String maxRateExp;
    /** 凭证前缀编码 */
    private String prefix;
    /** 最小利率表达式 */
    private String minRateExp;
    /** 金额靠档方式 */
    private GearAmtMethod gearAmtMethod;
    /** 利率变更日 */
    private String rollDay;
    /** 产品编号 */
    @NotNull
    private String prodNo;
    /** 利息计算方法 */
    private IntCalcMethod intCalcMethod;
    /** 上一柜员号 */
    private String lastUserId;
    /** 归属机构号 */
    private TranBranch branch;
    /** 天数靠档方向 */
    private GearDaysInd gearDaysInd;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 利率类型 */
    @NotNull
    private IntType intType;
    /** 金额靠档方向 */
    private GearDaysInd gearAmtInd;
    /** 靠档天数计算类型 */
    private DaysGearType daysGearType;
    /** 利率变更方式 */
    private IntChangeType intChangeType;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 计息生效日期计算方法 */
    private EffectDateCalcMethod effectDateCalcMethod;
    /** 分组规则表达式 */
    private String groupRuleTypeExp;
    /** 利率分层规则 */
    private RateLayerRule rateLayerRule;
    /** 分组规则类型 */
    private GroupRuleType groupRuleType;
    /** 利率变更周期 */
    private RollFreq rollFreq;
    /** 利息计算金额类型 */
    private IntCalcAmtType intCalcAmtType;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 凭证类型 */
    @NotNull
    private DocType docType;
    /** 上日期初凭证总数 */
    private Integer sopdVoucherSum;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 利息重算方法 */
    @NotNull
    private IntRecalcMethod intRecalcMethod;
    /** 税率类型编号 */
    private String taxTypeNo;
    /** 事件类型 */
    @NotNull
    private String eventType;
    /** 利率浮动标志 */
    private String calcByInt;
    /** 凭证终止号码 */
    @NotNull
    private String voucherEndNo;
    /** 天数靠档方式 */
    private GearAmtMethod gearDaysMethod;
    /** 月基准表达式 */
    private String monthBasisExp;
    /** 利率靠档金额类型 */
    private IntCalcAmtType rateGearAmtType;
    /** 凭证合计数 */
    @NotNull
    private Integer voucherSum;
    /** 利息分类 */
    @NotNull
    private IntClass intClass;
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

    public YearBasisType getYearBasisType() {
        return yearBasisType;
    }

    public void setYearBasisType(YearBasisType yearBasisType) {
        this.yearBasisType = yearBasisType;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
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

    public IntMatchRule getIntMatchRule() {
        return intMatchRule;
    }

    public void setIntMatchRule(IntMatchRule intMatchRule) {
        this.intMatchRule = intMatchRule;
    }

    public MonthBasisType getMonthBasisType() {
        return monthBasisType;
    }

    public void setMonthBasisType(MonthBasisType monthBasisType) {
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

    public GearAmtMethod getGearAmtMethod() {
        return gearAmtMethod;
    }

    public void setGearAmtMethod(GearAmtMethod gearAmtMethod) {
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

    public IntCalcMethod getIntCalcMethod() {
        return intCalcMethod;
    }

    public void setIntCalcMethod(IntCalcMethod intCalcMethod) {
        this.intCalcMethod = intCalcMethod;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public GearDaysInd getGearDaysInd() {
        return gearDaysInd;
    }

    public void setGearDaysInd(GearDaysInd gearDaysInd) {
        this.gearDaysInd = gearDaysInd;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public GearDaysInd getGearAmtInd() {
        return gearAmtInd;
    }

    public void setGearAmtInd(GearDaysInd gearAmtInd) {
        this.gearAmtInd = gearAmtInd;
    }

    public DaysGearType getDaysGearType() {
        return daysGearType;
    }

    public void setDaysGearType(DaysGearType daysGearType) {
        this.daysGearType = daysGearType;
    }

    public IntChangeType getIntChangeType() {
        return intChangeType;
    }

    public void setIntChangeType(IntChangeType intChangeType) {
        this.intChangeType = intChangeType;
    }

    public BigDecimal getMinRate() {
        return minRate;
    }

    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    public EffectDateCalcMethod getEffectDateCalcMethod() {
        return effectDateCalcMethod;
    }

    public void setEffectDateCalcMethod(EffectDateCalcMethod effectDateCalcMethod) {
        this.effectDateCalcMethod = effectDateCalcMethod;
    }

    public String getGroupRuleTypeExp() {
        return groupRuleTypeExp;
    }

    public void setGroupRuleTypeExp(String groupRuleTypeExp) {
        this.groupRuleTypeExp = groupRuleTypeExp;
    }

    public RateLayerRule getRateLayerRule() {
        return rateLayerRule;
    }

    public void setRateLayerRule(RateLayerRule rateLayerRule) {
        this.rateLayerRule = rateLayerRule;
    }

    public GroupRuleType getGroupRuleType() {
        return groupRuleType;
    }

    public void setGroupRuleType(GroupRuleType groupRuleType) {
        this.groupRuleType = groupRuleType;
    }

    public RollFreq getRollFreq() {
        return rollFreq;
    }

    public void setRollFreq(RollFreq rollFreq) {
        this.rollFreq = rollFreq;
    }

    public IntCalcAmtType getIntCalcAmtType() {
        return intCalcAmtType;
    }

    public void setIntCalcAmtType(IntCalcAmtType intCalcAmtType) {
        this.intCalcAmtType = intCalcAmtType;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
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

    public IntRecalcMethod getIntRecalcMethod() {
        return intRecalcMethod;
    }

    public void setIntRecalcMethod(IntRecalcMethod intRecalcMethod) {
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

    public GearAmtMethod getGearDaysMethod() {
        return gearDaysMethod;
    }

    public void setGearDaysMethod(GearAmtMethod gearDaysMethod) {
        this.gearDaysMethod = gearDaysMethod;
    }

    public String getMonthBasisExp() {
        return monthBasisExp;
    }

    public void setMonthBasisExp(String monthBasisExp) {
        this.monthBasisExp = monthBasisExp;
    }

    public IntCalcAmtType getRateGearAmtType() {
        return rateGearAmtType;
    }

    public void setRateGearAmtType(IntCalcAmtType rateGearAmtType) {
        this.rateGearAmtType = rateGearAmtType;
    }

    public Integer getVoucherSum() {
        return voucherSum;
    }

    public void setVoucherSum(Integer voucherSum) {
        this.voucherSum = voucherSum;
    }

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
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
package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.YearBasisType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusAcctIntDetailEO {
    /** 下一结息日期 */
    private java.util.Date nextCycleDate;
    /** 逾期利息 */
    private BigDecimal intPastDue;
    /** 利率类型 */
    private IntType intType;
    /** 当日利息调整金额 */
    private BigDecimal intAdjCtd;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 浮动方式 */
    private FloatType floatType;
    /** 系统编号 */
    private String systemId;
    /** 上日前付息金额 */
    private BigDecimal discntIntPrev;
    /** 年基准天数类型 */
    private YearBasisType yearBasisType;
    /** 利率分段标志 */
    private String splitRateFlag;
    /** 累计计提 */
    private BigDecimal intAccrued;
    /** 上日逾期利息 */
    private BigDecimal lastIntPastDue;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 税率类型编号 */
    private String taxTypeNo;
    /** 计息开始日期 */
    private java.util.Date calcBeginDate;
    /** 计提日计提利息 */
    private BigDecimal intAccruedCtd;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 结息金额 */
    private BigDecimal intPosted;
    /** 扣划利息标志 */
    private String intFlag;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 上一利息计提日期 */
    private java.util.Date lastAccrualDate;
    /** 计息方式 */
    private IntCalcBal intCalcBal;
    /** 下一计提日期 */
    private java.util.Date nextAccrDate;
    /** 结息频率 */
    private RollFreq cycleFreq;
    /** 结息标志 */
    private String cycleFlag;
    /** 月基准天数类型 */
    private MonthBasisType monthBasisType;
    /** 合约积数 */
    private BigDecimal agreeAgg;
    /** 利息资本化标志 */
    private String intCapFlag;
    /** 税率 */
    private BigDecimal taxRate;
    /** 上日累计计提利息 */
    private BigDecimal intAccruedPrev;
    /** 折扣利息标志 */
    private String discntUiFlag;
    /** 利息 */
    private BigDecimal intAmt;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 账户利率浮动百分比 */
    private BigDecimal acctPercentRate;
    /** 上日利息调整金额 */
    private BigDecimal intAdjPrev;
    /** 结息日 */
    private String intDay;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 是否重算 */
    private String retryFlag;
    /** 利率变更方式 */
    private IntChangeType intChangeType;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 积数 */
    @NotNull
    private BigDecimal agg;
    /** 违约执行利率 */
    private BigDecimal pastFadRate;
    /** 签约分层利率类型 */
    private IntType layerAgreement;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 计息截止日期 */
    private java.util.Date calcEndDate;
    /** 结息日利息 */
    private BigDecimal intPostedCtd;
    /** 未实现利息 */
    private BigDecimal discntRetainInt;
    /** 折扣利息 */
    private BigDecimal discntInt;
    /** 利息调整金额 */
    private BigDecimal intAdj;
    /** 利息分类 */
    @NotNull
    private IntClass intClass;
    /** 计提日计提实际金额 */
    private BigDecimal intAccruedCalcCtd;
    /** 上一结息日期 */
    private java.util.Date lastCycleDate;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 总累计积数 */
    private BigDecimal totalAgg;
    /** 计提金额差额 */
    private BigDecimal intAccruedDiff;

    public java.util.Date getNextCycleDate() {
        return nextCycleDate;
    }

    public void setNextCycleDate(java.util.Date nextCycleDate) {
        this.nextCycleDate = nextCycleDate;
    }

    public BigDecimal getIntPastDue() {
        return intPastDue;
    }

    public void setIntPastDue(BigDecimal intPastDue) {
        this.intPastDue = intPastDue;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public BigDecimal getIntAdjCtd() {
        return intAdjCtd;
    }

    public void setIntAdjCtd(BigDecimal intAdjCtd) {
        this.intAdjCtd = intAdjCtd;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public FloatType getFloatType() {
        return floatType;
    }

    public void setFloatType(FloatType floatType) {
        this.floatType = floatType;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public BigDecimal getDiscntIntPrev() {
        return discntIntPrev;
    }

    public void setDiscntIntPrev(BigDecimal discntIntPrev) {
        this.discntIntPrev = discntIntPrev;
    }

    public YearBasisType getYearBasisType() {
        return yearBasisType;
    }

    public void setYearBasisType(YearBasisType yearBasisType) {
        this.yearBasisType = yearBasisType;
    }

    public String getSplitRateFlag() {
        return splitRateFlag;
    }

    public void setSplitRateFlag(String splitRateFlag) {
        this.splitRateFlag = splitRateFlag;
    }

    public BigDecimal getIntAccrued() {
        return intAccrued;
    }

    public void setIntAccrued(BigDecimal intAccrued) {
        this.intAccrued = intAccrued;
    }

    public BigDecimal getLastIntPastDue() {
        return lastIntPastDue;
    }

    public void setLastIntPastDue(BigDecimal lastIntPastDue) {
        this.lastIntPastDue = lastIntPastDue;
    }

    public BigDecimal getAcctSpreadRate() {
        return acctSpreadRate;
    }

    public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
        this.acctSpreadRate = acctSpreadRate;
    }

    public String getTaxTypeNo() {
        return taxTypeNo;
    }

    public void setTaxTypeNo(String taxTypeNo) {
        this.taxTypeNo = taxTypeNo;
    }

    public java.util.Date getCalcBeginDate() {
        return calcBeginDate;
    }

    public void setCalcBeginDate(java.util.Date calcBeginDate) {
        this.calcBeginDate = calcBeginDate;
    }

    public BigDecimal getIntAccruedCtd() {
        return intAccruedCtd;
    }

    public void setIntAccruedCtd(BigDecimal intAccruedCtd) {
        this.intAccruedCtd = intAccruedCtd;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public BigDecimal getIntPosted() {
        return intPosted;
    }

    public void setIntPosted(BigDecimal intPosted) {
        this.intPosted = intPosted;
    }

    public String getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(String intFlag) {
        this.intFlag = intFlag;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public java.util.Date getLastAccrualDate() {
        return lastAccrualDate;
    }

    public void setLastAccrualDate(java.util.Date lastAccrualDate) {
        this.lastAccrualDate = lastAccrualDate;
    }

    public IntCalcBal getIntCalcBal() {
        return intCalcBal;
    }

    public void setIntCalcBal(IntCalcBal intCalcBal) {
        this.intCalcBal = intCalcBal;
    }

    public java.util.Date getNextAccrDate() {
        return nextAccrDate;
    }

    public void setNextAccrDate(java.util.Date nextAccrDate) {
        this.nextAccrDate = nextAccrDate;
    }

    public RollFreq getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(RollFreq cycleFreq) {
        this.cycleFreq = cycleFreq;
    }

    public String getCycleFlag() {
        return cycleFlag;
    }

    public void setCycleFlag(String cycleFlag) {
        this.cycleFlag = cycleFlag;
    }

    public MonthBasisType getMonthBasisType() {
        return monthBasisType;
    }

    public void setMonthBasisType(MonthBasisType monthBasisType) {
        this.monthBasisType = monthBasisType;
    }

    public BigDecimal getAgreeAgg() {
        return agreeAgg;
    }

    public void setAgreeAgg(BigDecimal agreeAgg) {
        this.agreeAgg = agreeAgg;
    }

    public String getIntCapFlag() {
        return intCapFlag;
    }

    public void setIntCapFlag(String intCapFlag) {
        this.intCapFlag = intCapFlag;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getIntAccruedPrev() {
        return intAccruedPrev;
    }

    public void setIntAccruedPrev(BigDecimal intAccruedPrev) {
        this.intAccruedPrev = intAccruedPrev;
    }

    public String getDiscntUiFlag() {
        return discntUiFlag;
    }

    public void setDiscntUiFlag(String discntUiFlag) {
        this.discntUiFlag = discntUiFlag;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getSpreadPercent() {
        return spreadPercent;
    }

    public void setSpreadPercent(BigDecimal spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public BigDecimal getAcctPercentRate() {
        return acctPercentRate;
    }

    public void setAcctPercentRate(BigDecimal acctPercentRate) {
        this.acctPercentRate = acctPercentRate;
    }

    public BigDecimal getIntAdjPrev() {
        return intAdjPrev;
    }

    public void setIntAdjPrev(BigDecimal intAdjPrev) {
        this.intAdjPrev = intAdjPrev;
    }

    public String getIntDay() {
        return intDay;
    }

    public void setIntDay(String intDay) {
        this.intDay = intDay;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public String getRetryFlag() {
        return retryFlag;
    }

    public void setRetryFlag(String retryFlag) {
        this.retryFlag = retryFlag;
    }

    public IntChangeType getIntChangeType() {
        return intChangeType;
    }

    public void setIntChangeType(IntChangeType intChangeType) {
        this.intChangeType = intChangeType;
    }

    public BigDecimal getAcctFixedRate() {
        return acctFixedRate;
    }

    public void setAcctFixedRate(BigDecimal acctFixedRate) {
        this.acctFixedRate = acctFixedRate;
    }

    public BigDecimal getAgg() {
        return agg;
    }

    public void setAgg(BigDecimal agg) {
        this.agg = agg;
    }

    public BigDecimal getPastFadRate() {
        return pastFadRate;
    }

    public void setPastFadRate(BigDecimal pastFadRate) {
        this.pastFadRate = pastFadRate;
    }

    public IntType getLayerAgreement() {
        return layerAgreement;
    }

    public void setLayerAgreement(IntType layerAgreement) {
        this.layerAgreement = layerAgreement;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public java.util.Date getCalcEndDate() {
        return calcEndDate;
    }

    public void setCalcEndDate(java.util.Date calcEndDate) {
        this.calcEndDate = calcEndDate;
    }

    public BigDecimal getIntPostedCtd() {
        return intPostedCtd;
    }

    public void setIntPostedCtd(BigDecimal intPostedCtd) {
        this.intPostedCtd = intPostedCtd;
    }

    public BigDecimal getDiscntRetainInt() {
        return discntRetainInt;
    }

    public void setDiscntRetainInt(BigDecimal discntRetainInt) {
        this.discntRetainInt = discntRetainInt;
    }

    public BigDecimal getDiscntInt() {
        return discntInt;
    }

    public void setDiscntInt(BigDecimal discntInt) {
        this.discntInt = discntInt;
    }

    public BigDecimal getIntAdj() {
        return intAdj;
    }

    public void setIntAdj(BigDecimal intAdj) {
        this.intAdj = intAdj;
    }

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
        this.intClass = intClass;
    }

    public BigDecimal getIntAccruedCalcCtd() {
        return intAccruedCalcCtd;
    }

    public void setIntAccruedCalcCtd(BigDecimal intAccruedCalcCtd) {
        this.intAccruedCalcCtd = intAccruedCalcCtd;
    }

    public java.util.Date getLastCycleDate() {
        return lastCycleDate;
    }

    public void setLastCycleDate(java.util.Date lastCycleDate) {
        this.lastCycleDate = lastCycleDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public BigDecimal getTotalAgg() {
        return totalAgg;
    }

    public void setTotalAgg(BigDecimal totalAgg) {
        this.totalAgg = totalAgg;
    }

    public BigDecimal getIntAccruedDiff() {
        return intAccruedDiff;
    }

    public void setIntAccruedDiff(BigDecimal intAccruedDiff) {
        this.intAccruedDiff = intAccruedDiff;
    }
}
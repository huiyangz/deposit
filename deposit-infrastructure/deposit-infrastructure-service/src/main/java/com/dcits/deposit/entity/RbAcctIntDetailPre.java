package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAcctIntDetailPre {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 利息分类 */
    private String intClass;
    /** 计提周期 */
    private String accrPeriodFreq;
    /** 下一计提日期 */
    private Date nextAccrDate;
    /** 上一利息计提日期 */
    private Date lastAccrualDate;
    /** 结息标志 */
    private String cycleFlag;
    /** 利息资本化标志 */
    private String intCapFlag;
    /** 下一结息日期 */
    private Date nextCycleDate;
    /** 上一结息日期 */
    private Date lastCycleDate;
    /** 上一真实结息日 */
    private Date lastTrueCycleDate;
    /** 上上次结息日期 */
    private Date lastCycleDatePre;
    /** 结息频率 */
    private String cycleFreq;
    /** 计提日 */
    private String accrIntDay;
    /** 结息日 */
    private String intDay;
    /** 利率类型 */
    private String intType;
    /** 利率生效方式 */
    private String rateEffectType;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 浮动方式 */
    private String floatType;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 利率分段标志 */
    private String splitRateFlag;
    /** 执行利率下限 */
    private BigDecimal minIntRate;
    /** 执行利率上限 */
    private BigDecimal maxIntRate;
    /** 月基准 */
    private String monthBasis;
    /** 年基准天数 */
    private String yearBasis;
    /** 罚息利率使用方式 */
    private String penaltyOdiRateType;
    /** 利率变化标志 */
    private String rateChangeInd;
    /** 累计计提 */
    private BigDecimal intAccrued;
    /** 积数 */
    private BigDecimal agg;
    /** 计提日计提实际金额 */
    private BigDecimal intAccruedCalcCtd;
    /** 计提日计提利息 */
    private BigDecimal intAccruedCtd;
    /** 计提金额差额 */
    private BigDecimal intAccruedDiff;
    /** 上日累计计提利息 */
    private BigDecimal intAccruedPrev;
    /** 上上日累计计提利息 */
    private BigDecimal intAccruedLastPrev;
    /** 存期计提累计利息 */
    private BigDecimal intAccruedT;
    /** 利息调整金额 */
    private BigDecimal intAdj;
    /** 当日利息调整金额 */
    private BigDecimal intAdjCtd;
    /** 上日利息调整金额 */
    private BigDecimal intAdjPrev;
    /** 上上日利息调整金额 */
    private BigDecimal intAdjLastPrev;
    /** 计息方式 */
    private String intCalcBal;
    /** 逾期利息 */
    private BigDecimal intPastDue;
    /** 结息金额 */
    private BigDecimal intPosted;
    /** 结息日利息 */
    private BigDecimal intPostedCtd;
    /** 计息剩余天数 */
    private Integer intRemDays;
    /** 折扣利息 */
    private BigDecimal discntInt;
    /** 上日前付息金额 */
    private BigDecimal discntIntPrev;
    /** 上上日前付息金额 */
    private BigDecimal discntIntLastPrev;
    /** 未实现利息 */
    private BigDecimal discntRetainInt;
    /** 折扣利息标志 */
    private String discntUiFlag;
    /** 折扣罚息 */
    private BigDecimal uiPenaltyAmt;
    /** 折扣付出利息 */
    private BigDecimal uiInt;
    /** 明细检查计算余额 */
    private BigDecimal calcBalance;
    /** 计息截止日期 */
    private Date calcEndDate;
    /** 利率启用方式 */
    private String intApplType;
    /** 上一利率启用方式 */
    private String intApplTypePrev;
    /** 利率变更日 */
    private String rollDay;
    /** 利率变更周期 */
    private String rollFreq;
    /** 利率浮动标志 */
    private String calcByInt;
    /** 上一利率变更日期 */
    private Date lastRollDate;
    /** 下一利率变更日期 */
    private Date nextRollDate;
    /** 定期账户计提起始日 */
    private String tdAccrIntDay;
    /** 当期累计计息天数 */
    private Integer tdIntNumDays;
    /** 定期上一计提日期 */
    private Date tdLastAccrDate;
    /** 合约优惠金额 */
    private BigDecimal agreeReduceAmt;
    /** 利息 */
    private BigDecimal intAmt;
    /** 利息资本化金额 */
    private BigDecimal intCapAmt;
    /** 账户结算日期 */
    private Date settleCycleDate;
    /** 协议固定利率 */
    private BigDecimal agreeFixedRate;
    /** 合约浮动百分点 */
    private BigDecimal agreeSpreadRate;
    /** 合约利息 */
    private BigDecimal agreeInt;
    /** 上日逾期利息 */
    private BigDecimal lastIntPastDue;
    /** 税率类型 */
    private String taxType;
    /** 税率 */
    private BigDecimal taxRate;
    /** 账户固定税率 */
    private BigDecimal acctFixedTaxRate;
    /** 利息税率浮动百分比 */
    private BigDecimal acctPercentTaxRate;
    /** 利息税率浮动百分点 */
    private BigDecimal acctSpreadTaxRate;
    /** 结息周期内利息税累计金额 */
    private BigDecimal taxAccrued;
    /** 计提日利息税原金额 */
    private BigDecimal taxAccruedCalcCtd;
    /** 计提日利息税 */
    private BigDecimal taxAccruedCtd;
    /** 利息税差额 */
    private BigDecimal taxAccruedDiff;
    /** 结息日利息税金额 */
    private BigDecimal taxPostedCtd;
    /** 利息税累计金额 */
    private BigDecimal taxPosted;
    /** 存量利息税金额 */
    private BigDecimal intTaxT;
    /** 利率变更日类型 */
    private String followIntDayType;
    /** 是否重算 */
    private String retryFlag;
    /** 协议变动类型 */
    private String agreeChangeType;
    /** 合约积数 */
    private BigDecimal agreeAgg;
    /** 合约浮动百分比 */
    private BigDecimal agreePercentRate;
    /** 签约分层利率类型 */
    private String layerAgreement;
    /** 回溯自然日天数 */
    private Integer followTraceNaturalDays;
    /** 回溯工作日天数 */
    private Integer followTraceWorkdayDays;
    /** 扣划利息标志 */
    private String intFlag;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 系统编号 */
    private String systemId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 客户号 */
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 上日计提调整备份日期 */
    private Date adjUpdLastDate;
    /** 上日已付利息备份日期 */
    private Date advUpdLastDate;
    /** 违约执行利率 */
    private BigDecimal pastFadRate;
    /** 总累计积数 */
    private BigDecimal totalAgg;
    /** 延期付息累计金额 */
    private BigDecimal delayTotalAmt;
    /** 延期付息金额 */
    private BigDecimal delayIntAmt;
    /** 上一延期付息金额 */
    private BigDecimal delayIntAmtPrev;
    /** 延迟付息累计供核算金额-上上日 */
    private BigDecimal delayIntAmtLastPrev;
    /** 成功标志 */
    private String successFlag;
    /** 计息开始日期 */
    private Date calcBeginDate;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getIntClass() {
        return intClass;
    }

    public void setIntClass(String intClass) {
        this.intClass = intClass;
    }

    public String getAccrPeriodFreq() {
        return accrPeriodFreq;
    }

    public void setAccrPeriodFreq(String accrPeriodFreq) {
        this.accrPeriodFreq = accrPeriodFreq;
    }

    public Date getNextAccrDate() {
        return nextAccrDate;
    }

    public void setNextAccrDate(Date nextAccrDate) {
        this.nextAccrDate = nextAccrDate;
    }

    public Date getLastAccrualDate() {
        return lastAccrualDate;
    }

    public void setLastAccrualDate(Date lastAccrualDate) {
        this.lastAccrualDate = lastAccrualDate;
    }

    public String getCycleFlag() {
        return cycleFlag;
    }

    public void setCycleFlag(String cycleFlag) {
        this.cycleFlag = cycleFlag;
    }

    public String getIntCapFlag() {
        return intCapFlag;
    }

    public void setIntCapFlag(String intCapFlag) {
        this.intCapFlag = intCapFlag;
    }

    public Date getNextCycleDate() {
        return nextCycleDate;
    }

    public void setNextCycleDate(Date nextCycleDate) {
        this.nextCycleDate = nextCycleDate;
    }

    public Date getLastCycleDate() {
        return lastCycleDate;
    }

    public void setLastCycleDate(Date lastCycleDate) {
        this.lastCycleDate = lastCycleDate;
    }

    public Date getLastTrueCycleDate() {
        return lastTrueCycleDate;
    }

    public void setLastTrueCycleDate(Date lastTrueCycleDate) {
        this.lastTrueCycleDate = lastTrueCycleDate;
    }

    public Date getLastCycleDatePre() {
        return lastCycleDatePre;
    }

    public void setLastCycleDatePre(Date lastCycleDatePre) {
        this.lastCycleDatePre = lastCycleDatePre;
    }

    public String getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(String cycleFreq) {
        this.cycleFreq = cycleFreq;
    }

    public String getAccrIntDay() {
        return accrIntDay;
    }

    public void setAccrIntDay(String accrIntDay) {
        this.accrIntDay = accrIntDay;
    }

    public String getIntDay() {
        return intDay;
    }

    public void setIntDay(String intDay) {
        this.intDay = intDay;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public String getRateEffectType() {
        return rateEffectType;
    }

    public void setRateEffectType(String rateEffectType) {
        this.rateEffectType = rateEffectType;
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

    public String getFloatType() {
        return floatType;
    }

    public void setFloatType(String floatType) {
        this.floatType = floatType;
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

    public BigDecimal getAcctFixedRate() {
        return acctFixedRate;
    }

    public void setAcctFixedRate(BigDecimal acctFixedRate) {
        this.acctFixedRate = acctFixedRate;
    }

    public BigDecimal getAcctSpreadRate() {
        return acctSpreadRate;
    }

    public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
        this.acctSpreadRate = acctSpreadRate;
    }

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public String getSplitRateFlag() {
        return splitRateFlag;
    }

    public void setSplitRateFlag(String splitRateFlag) {
        this.splitRateFlag = splitRateFlag;
    }

    public BigDecimal getMinIntRate() {
        return minIntRate;
    }

    public void setMinIntRate(BigDecimal minIntRate) {
        this.minIntRate = minIntRate;
    }

    public BigDecimal getMaxIntRate() {
        return maxIntRate;
    }

    public void setMaxIntRate(BigDecimal maxIntRate) {
        this.maxIntRate = maxIntRate;
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

    public String getPenaltyOdiRateType() {
        return penaltyOdiRateType;
    }

    public void setPenaltyOdiRateType(String penaltyOdiRateType) {
        this.penaltyOdiRateType = penaltyOdiRateType;
    }

    public String getRateChangeInd() {
        return rateChangeInd;
    }

    public void setRateChangeInd(String rateChangeInd) {
        this.rateChangeInd = rateChangeInd;
    }

    public BigDecimal getIntAccrued() {
        return intAccrued;
    }

    public void setIntAccrued(BigDecimal intAccrued) {
        this.intAccrued = intAccrued;
    }

    public BigDecimal getAgg() {
        return agg;
    }

    public void setAgg(BigDecimal agg) {
        this.agg = agg;
    }

    public BigDecimal getIntAccruedCalcCtd() {
        return intAccruedCalcCtd;
    }

    public void setIntAccruedCalcCtd(BigDecimal intAccruedCalcCtd) {
        this.intAccruedCalcCtd = intAccruedCalcCtd;
    }

    public BigDecimal getIntAccruedCtd() {
        return intAccruedCtd;
    }

    public void setIntAccruedCtd(BigDecimal intAccruedCtd) {
        this.intAccruedCtd = intAccruedCtd;
    }

    public BigDecimal getIntAccruedDiff() {
        return intAccruedDiff;
    }

    public void setIntAccruedDiff(BigDecimal intAccruedDiff) {
        this.intAccruedDiff = intAccruedDiff;
    }

    public BigDecimal getIntAccruedPrev() {
        return intAccruedPrev;
    }

    public void setIntAccruedPrev(BigDecimal intAccruedPrev) {
        this.intAccruedPrev = intAccruedPrev;
    }

    public BigDecimal getIntAccruedLastPrev() {
        return intAccruedLastPrev;
    }

    public void setIntAccruedLastPrev(BigDecimal intAccruedLastPrev) {
        this.intAccruedLastPrev = intAccruedLastPrev;
    }

    public BigDecimal getIntAccruedT() {
        return intAccruedT;
    }

    public void setIntAccruedT(BigDecimal intAccruedT) {
        this.intAccruedT = intAccruedT;
    }

    public BigDecimal getIntAdj() {
        return intAdj;
    }

    public void setIntAdj(BigDecimal intAdj) {
        this.intAdj = intAdj;
    }

    public BigDecimal getIntAdjCtd() {
        return intAdjCtd;
    }

    public void setIntAdjCtd(BigDecimal intAdjCtd) {
        this.intAdjCtd = intAdjCtd;
    }

    public BigDecimal getIntAdjPrev() {
        return intAdjPrev;
    }

    public void setIntAdjPrev(BigDecimal intAdjPrev) {
        this.intAdjPrev = intAdjPrev;
    }

    public BigDecimal getIntAdjLastPrev() {
        return intAdjLastPrev;
    }

    public void setIntAdjLastPrev(BigDecimal intAdjLastPrev) {
        this.intAdjLastPrev = intAdjLastPrev;
    }

    public String getIntCalcBal() {
        return intCalcBal;
    }

    public void setIntCalcBal(String intCalcBal) {
        this.intCalcBal = intCalcBal;
    }

    public BigDecimal getIntPastDue() {
        return intPastDue;
    }

    public void setIntPastDue(BigDecimal intPastDue) {
        this.intPastDue = intPastDue;
    }

    public BigDecimal getIntPosted() {
        return intPosted;
    }

    public void setIntPosted(BigDecimal intPosted) {
        this.intPosted = intPosted;
    }

    public BigDecimal getIntPostedCtd() {
        return intPostedCtd;
    }

    public void setIntPostedCtd(BigDecimal intPostedCtd) {
        this.intPostedCtd = intPostedCtd;
    }

    public Integer getIntRemDays() {
        return intRemDays;
    }

    public void setIntRemDays(Integer intRemDays) {
        this.intRemDays = intRemDays;
    }

    public BigDecimal getDiscntInt() {
        return discntInt;
    }

    public void setDiscntInt(BigDecimal discntInt) {
        this.discntInt = discntInt;
    }

    public BigDecimal getDiscntIntPrev() {
        return discntIntPrev;
    }

    public void setDiscntIntPrev(BigDecimal discntIntPrev) {
        this.discntIntPrev = discntIntPrev;
    }

    public BigDecimal getDiscntIntLastPrev() {
        return discntIntLastPrev;
    }

    public void setDiscntIntLastPrev(BigDecimal discntIntLastPrev) {
        this.discntIntLastPrev = discntIntLastPrev;
    }

    public BigDecimal getDiscntRetainInt() {
        return discntRetainInt;
    }

    public void setDiscntRetainInt(BigDecimal discntRetainInt) {
        this.discntRetainInt = discntRetainInt;
    }

    public String getDiscntUiFlag() {
        return discntUiFlag;
    }

    public void setDiscntUiFlag(String discntUiFlag) {
        this.discntUiFlag = discntUiFlag;
    }

    public BigDecimal getUiPenaltyAmt() {
        return uiPenaltyAmt;
    }

    public void setUiPenaltyAmt(BigDecimal uiPenaltyAmt) {
        this.uiPenaltyAmt = uiPenaltyAmt;
    }

    public BigDecimal getUiInt() {
        return uiInt;
    }

    public void setUiInt(BigDecimal uiInt) {
        this.uiInt = uiInt;
    }

    public BigDecimal getCalcBalance() {
        return calcBalance;
    }

    public void setCalcBalance(BigDecimal calcBalance) {
        this.calcBalance = calcBalance;
    }

    public Date getCalcEndDate() {
        return calcEndDate;
    }

    public void setCalcEndDate(Date calcEndDate) {
        this.calcEndDate = calcEndDate;
    }

    public String getIntApplType() {
        return intApplType;
    }

    public void setIntApplType(String intApplType) {
        this.intApplType = intApplType;
    }

    public String getIntApplTypePrev() {
        return intApplTypePrev;
    }

    public void setIntApplTypePrev(String intApplTypePrev) {
        this.intApplTypePrev = intApplTypePrev;
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

    public String getCalcByInt() {
        return calcByInt;
    }

    public void setCalcByInt(String calcByInt) {
        this.calcByInt = calcByInt;
    }

    public Date getLastRollDate() {
        return lastRollDate;
    }

    public void setLastRollDate(Date lastRollDate) {
        this.lastRollDate = lastRollDate;
    }

    public Date getNextRollDate() {
        return nextRollDate;
    }

    public void setNextRollDate(Date nextRollDate) {
        this.nextRollDate = nextRollDate;
    }

    public String getTdAccrIntDay() {
        return tdAccrIntDay;
    }

    public void setTdAccrIntDay(String tdAccrIntDay) {
        this.tdAccrIntDay = tdAccrIntDay;
    }

    public Integer getTdIntNumDays() {
        return tdIntNumDays;
    }

    public void setTdIntNumDays(Integer tdIntNumDays) {
        this.tdIntNumDays = tdIntNumDays;
    }

    public Date getTdLastAccrDate() {
        return tdLastAccrDate;
    }

    public void setTdLastAccrDate(Date tdLastAccrDate) {
        this.tdLastAccrDate = tdLastAccrDate;
    }

    public BigDecimal getAgreeReduceAmt() {
        return agreeReduceAmt;
    }

    public void setAgreeReduceAmt(BigDecimal agreeReduceAmt) {
        this.agreeReduceAmt = agreeReduceAmt;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getIntCapAmt() {
        return intCapAmt;
    }

    public void setIntCapAmt(BigDecimal intCapAmt) {
        this.intCapAmt = intCapAmt;
    }

    public Date getSettleCycleDate() {
        return settleCycleDate;
    }

    public void setSettleCycleDate(Date settleCycleDate) {
        this.settleCycleDate = settleCycleDate;
    }

    public BigDecimal getAgreeFixedRate() {
        return agreeFixedRate;
    }

    public void setAgreeFixedRate(BigDecimal agreeFixedRate) {
        this.agreeFixedRate = agreeFixedRate;
    }

    public BigDecimal getAgreeSpreadRate() {
        return agreeSpreadRate;
    }

    public void setAgreeSpreadRate(BigDecimal agreeSpreadRate) {
        this.agreeSpreadRate = agreeSpreadRate;
    }

    public BigDecimal getAgreeInt() {
        return agreeInt;
    }

    public void setAgreeInt(BigDecimal agreeInt) {
        this.agreeInt = agreeInt;
    }

    public BigDecimal getLastIntPastDue() {
        return lastIntPastDue;
    }

    public void setLastIntPastDue(BigDecimal lastIntPastDue) {
        this.lastIntPastDue = lastIntPastDue;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getAcctFixedTaxRate() {
        return acctFixedTaxRate;
    }

    public void setAcctFixedTaxRate(BigDecimal acctFixedTaxRate) {
        this.acctFixedTaxRate = acctFixedTaxRate;
    }

    public BigDecimal getAcctPercentTaxRate() {
        return acctPercentTaxRate;
    }

    public void setAcctPercentTaxRate(BigDecimal acctPercentTaxRate) {
        this.acctPercentTaxRate = acctPercentTaxRate;
    }

    public BigDecimal getAcctSpreadTaxRate() {
        return acctSpreadTaxRate;
    }

    public void setAcctSpreadTaxRate(BigDecimal acctSpreadTaxRate) {
        this.acctSpreadTaxRate = acctSpreadTaxRate;
    }

    public BigDecimal getTaxAccrued() {
        return taxAccrued;
    }

    public void setTaxAccrued(BigDecimal taxAccrued) {
        this.taxAccrued = taxAccrued;
    }

    public BigDecimal getTaxAccruedCalcCtd() {
        return taxAccruedCalcCtd;
    }

    public void setTaxAccruedCalcCtd(BigDecimal taxAccruedCalcCtd) {
        this.taxAccruedCalcCtd = taxAccruedCalcCtd;
    }

    public BigDecimal getTaxAccruedCtd() {
        return taxAccruedCtd;
    }

    public void setTaxAccruedCtd(BigDecimal taxAccruedCtd) {
        this.taxAccruedCtd = taxAccruedCtd;
    }

    public BigDecimal getTaxAccruedDiff() {
        return taxAccruedDiff;
    }

    public void setTaxAccruedDiff(BigDecimal taxAccruedDiff) {
        this.taxAccruedDiff = taxAccruedDiff;
    }

    public BigDecimal getTaxPostedCtd() {
        return taxPostedCtd;
    }

    public void setTaxPostedCtd(BigDecimal taxPostedCtd) {
        this.taxPostedCtd = taxPostedCtd;
    }

    public BigDecimal getTaxPosted() {
        return taxPosted;
    }

    public void setTaxPosted(BigDecimal taxPosted) {
        this.taxPosted = taxPosted;
    }

    public BigDecimal getIntTaxT() {
        return intTaxT;
    }

    public void setIntTaxT(BigDecimal intTaxT) {
        this.intTaxT = intTaxT;
    }

    public String getFollowIntDayType() {
        return followIntDayType;
    }

    public void setFollowIntDayType(String followIntDayType) {
        this.followIntDayType = followIntDayType;
    }

    public String getRetryFlag() {
        return retryFlag;
    }

    public void setRetryFlag(String retryFlag) {
        this.retryFlag = retryFlag;
    }

    public String getAgreeChangeType() {
        return agreeChangeType;
    }

    public void setAgreeChangeType(String agreeChangeType) {
        this.agreeChangeType = agreeChangeType;
    }

    public BigDecimal getAgreeAgg() {
        return agreeAgg;
    }

    public void setAgreeAgg(BigDecimal agreeAgg) {
        this.agreeAgg = agreeAgg;
    }

    public BigDecimal getAgreePercentRate() {
        return agreePercentRate;
    }

    public void setAgreePercentRate(BigDecimal agreePercentRate) {
        this.agreePercentRate = agreePercentRate;
    }

    public String getLayerAgreement() {
        return layerAgreement;
    }

    public void setLayerAgreement(String layerAgreement) {
        this.layerAgreement = layerAgreement;
    }

    public Integer getFollowTraceNaturalDays() {
        return followTraceNaturalDays;
    }

    public void setFollowTraceNaturalDays(Integer followTraceNaturalDays) {
        this.followTraceNaturalDays = followTraceNaturalDays;
    }

    public Integer getFollowTraceWorkdayDays() {
        return followTraceWorkdayDays;
    }

    public void setFollowTraceWorkdayDays(Integer followTraceWorkdayDays) {
        this.followTraceWorkdayDays = followTraceWorkdayDays;
    }

    public String getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(String intFlag) {
        this.intFlag = intFlag;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
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

    public Date getAdjUpdLastDate() {
        return adjUpdLastDate;
    }

    public void setAdjUpdLastDate(Date adjUpdLastDate) {
        this.adjUpdLastDate = adjUpdLastDate;
    }

    public Date getAdvUpdLastDate() {
        return advUpdLastDate;
    }

    public void setAdvUpdLastDate(Date advUpdLastDate) {
        this.advUpdLastDate = advUpdLastDate;
    }

    public BigDecimal getPastFadRate() {
        return pastFadRate;
    }

    public void setPastFadRate(BigDecimal pastFadRate) {
        this.pastFadRate = pastFadRate;
    }

    public BigDecimal getTotalAgg() {
        return totalAgg;
    }

    public void setTotalAgg(BigDecimal totalAgg) {
        this.totalAgg = totalAgg;
    }

    public BigDecimal getDelayTotalAmt() {
        return delayTotalAmt;
    }

    public void setDelayTotalAmt(BigDecimal delayTotalAmt) {
        this.delayTotalAmt = delayTotalAmt;
    }

    public BigDecimal getDelayIntAmt() {
        return delayIntAmt;
    }

    public void setDelayIntAmt(BigDecimal delayIntAmt) {
        this.delayIntAmt = delayIntAmt;
    }

    public BigDecimal getDelayIntAmtPrev() {
        return delayIntAmtPrev;
    }

    public void setDelayIntAmtPrev(BigDecimal delayIntAmtPrev) {
        this.delayIntAmtPrev = delayIntAmtPrev;
    }

    public BigDecimal getDelayIntAmtLastPrev() {
        return delayIntAmtLastPrev;
    }

    public void setDelayIntAmtLastPrev(BigDecimal delayIntAmtLastPrev) {
        this.delayIntAmtLastPrev = delayIntAmtLastPrev;
    }

    public String getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(String successFlag) {
        this.successFlag = successFlag;
    }

    public Date getCalcBeginDate() {
        return calcBeginDate;
    }

    public void setCalcBeginDate(Date calcBeginDate) {
        this.calcBeginDate = calcBeginDate;
    }
}
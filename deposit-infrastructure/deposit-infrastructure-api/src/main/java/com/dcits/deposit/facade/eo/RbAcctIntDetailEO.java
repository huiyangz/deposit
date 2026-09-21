package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.YearBasis;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctIntDetailEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 利息分类 */
    @NotNull
    private IntClass intClass;
    /** 下一计提日期 */
    private java.util.Date nextAccrDate;
    /** 上一利息计提日期 */
    private java.util.Date lastAccrualDate;
    /** 结息标志 */
    private IndividualFlag cycleFlag;
    /** 利息资本化标志 */
    private IndividualFlag intCapFlag;
    /** 下一结息日期 */
    private java.util.Date nextCycleDate;
    /** 上一结息日期 */
    private java.util.Date lastCycleDate;
    /** 上一真实结息日 */
    private java.util.Date lastTrueCycleDate;
    /** 上上次结息日期 */
    private java.util.Date lastCycleDatePre;
    /** 结息频率 */
    private CycleFreq cycleFreq;
    /** 结息日 */
    private String intDay;
    /** 利率类型 */
    private IntType intType;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 浮动方式 */
    private FloatType floatType;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 账户利率浮动百分比 */
    private BigDecimal acctPercentRate;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 利率分段标志 */
    private IndividualFlag splitRateFlag;
    /** 执行利率下限 */
    private BigDecimal minIntRate;
    /** 执行利率上限 */
    private BigDecimal maxIntRate;
    /** 月基准 */
    private MonthBasis monthBasis;
    /** 年基准天数 */
    private YearBasis yearBasis;
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
    /** 利息调整金额 */
    private BigDecimal intAdj;
    /** 当日利息调整金额 */
    private BigDecimal intAdjCtd;
    /** 上日利息调整金额 */
    private BigDecimal intAdjPrev;
    /** 上上日利息调整金额 */
    private BigDecimal intAdjLastPrev;
    /** 计息方式 */
    private IntCalcBal intCalcBal;
    /** 逾期利息 */
    private BigDecimal intPastDue;
    /** 结息金额 */
    private BigDecimal intPosted;
    /** 结息日利息 */
    private BigDecimal intPostedCtd;
    /** 折扣利息 */
    private BigDecimal discntInt;
    /** 上日前付息金额 */
    private BigDecimal discntIntPrev;
    /** 上上日前付息金额 */
    private BigDecimal discntIntLastPrev;
    /** 未实现利息 */
    private BigDecimal discntRetainInt;
    /** 折扣利息标志 */
    private IndividualFlag discntUiFlag;
    /** 计息开始日期 */
    private java.util.Date calcBeginDate;
    /** 计息截止日期 */
    private java.util.Date calcEndDate;
    /** 利率启用方式 */
    private IntApplType intApplType;
    /** 上一利率启用方式 */
    private IntApplType intApplTypePrev;
    /** 利率变更日 */
    private String rollDay;
    /** 利率变更周期 */
    private CycleFreq rollFreq;
    /** 利率浮动标志 */
    private IndividualFlag calcByInt;
    /** 上一利率变更日期 */
    private java.util.Date lastRollDate;
    /** 下一利率变更日期 */
    private java.util.Date nextRollDate;
    /** 当期累计计息天数 */
    private Integer tdIntNumDays;
    /** 利息 */
    private BigDecimal intAmt;
    /** 上日逾期利息 */
    private BigDecimal lastIntPastDue;
    /** 税率类型 */
    private TaxType taxType;
    /** 税率 */
    private BigDecimal taxRate;
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
    /** 是否重算 */
    private String retryFlag;
    /** 合约积数 */
    private BigDecimal agreeAgg;
    /** 签约分层利率类型 */
    private IntType layerAgreement;
    /** 扣划利息标志 */
    private IndividualFlag intFlag;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 系统编号 */
    private String systemId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 上日计提调整备份日期 */
    private java.util.Date adjUpdLastDate;
    /** 上日已付利息备份日期 */
    private java.util.Date advUpdLastDate;
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
    /** 上一预计提日 */
    private java.util.Date lastPreAccrualDate;
    /** 上日已付利息及计提备份日期 */
    private java.util.Date intUpdLastDate;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public IntClass getIntClass() {
        return intClass;
    }

    public void setIntClass(IntClass intClass) {
        this.intClass = intClass;
    }

    public java.util.Date getNextAccrDate() {
        return nextAccrDate;
    }

    public void setNextAccrDate(java.util.Date nextAccrDate) {
        this.nextAccrDate = nextAccrDate;
    }

    public java.util.Date getLastAccrualDate() {
        return lastAccrualDate;
    }

    public void setLastAccrualDate(java.util.Date lastAccrualDate) {
        this.lastAccrualDate = lastAccrualDate;
    }

    public IndividualFlag getCycleFlag() {
        return cycleFlag;
    }

    public void setCycleFlag(IndividualFlag cycleFlag) {
        this.cycleFlag = cycleFlag;
    }

    public IndividualFlag getIntCapFlag() {
        return intCapFlag;
    }

    public void setIntCapFlag(IndividualFlag intCapFlag) {
        this.intCapFlag = intCapFlag;
    }

    public java.util.Date getNextCycleDate() {
        return nextCycleDate;
    }

    public void setNextCycleDate(java.util.Date nextCycleDate) {
        this.nextCycleDate = nextCycleDate;
    }

    public java.util.Date getLastCycleDate() {
        return lastCycleDate;
    }

    public void setLastCycleDate(java.util.Date lastCycleDate) {
        this.lastCycleDate = lastCycleDate;
    }

    public java.util.Date getLastTrueCycleDate() {
        return lastTrueCycleDate;
    }

    public void setLastTrueCycleDate(java.util.Date lastTrueCycleDate) {
        this.lastTrueCycleDate = lastTrueCycleDate;
    }

    public java.util.Date getLastCycleDatePre() {
        return lastCycleDatePre;
    }

    public void setLastCycleDatePre(java.util.Date lastCycleDatePre) {
        this.lastCycleDatePre = lastCycleDatePre;
    }

    public CycleFreq getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(CycleFreq cycleFreq) {
        this.cycleFreq = cycleFreq;
    }

    public String getIntDay() {
        return intDay;
    }

    public void setIntDay(String intDay) {
        this.intDay = intDay;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public FloatType getFloatType() {
        return floatType;
    }

    public void setFloatType(FloatType floatType) {
        this.floatType = floatType;
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
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

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }

    public IndividualFlag getSplitRateFlag() {
        return splitRateFlag;
    }

    public void setSplitRateFlag(IndividualFlag splitRateFlag) {
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

    public MonthBasis getMonthBasis() {
        return monthBasis;
    }

    public void setMonthBasis(MonthBasis monthBasis) {
        this.monthBasis = monthBasis;
    }

    public YearBasis getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(YearBasis yearBasis) {
        this.yearBasis = yearBasis;
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

    public IntCalcBal getIntCalcBal() {
        return intCalcBal;
    }

    public void setIntCalcBal(IntCalcBal intCalcBal) {
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

    public IndividualFlag getDiscntUiFlag() {
        return discntUiFlag;
    }

    public void setDiscntUiFlag(IndividualFlag discntUiFlag) {
        this.discntUiFlag = discntUiFlag;
    }

    public java.util.Date getCalcBeginDate() {
        return calcBeginDate;
    }

    public void setCalcBeginDate(java.util.Date calcBeginDate) {
        this.calcBeginDate = calcBeginDate;
    }

    public java.util.Date getCalcEndDate() {
        return calcEndDate;
    }

    public void setCalcEndDate(java.util.Date calcEndDate) {
        this.calcEndDate = calcEndDate;
    }

    public IntApplType getIntApplType() {
        return intApplType;
    }

    public void setIntApplType(IntApplType intApplType) {
        this.intApplType = intApplType;
    }

    public IntApplType getIntApplTypePrev() {
        return intApplTypePrev;
    }

    public void setIntApplTypePrev(IntApplType intApplTypePrev) {
        this.intApplTypePrev = intApplTypePrev;
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

    public IndividualFlag getCalcByInt() {
        return calcByInt;
    }

    public void setCalcByInt(IndividualFlag calcByInt) {
        this.calcByInt = calcByInt;
    }

    public java.util.Date getLastRollDate() {
        return lastRollDate;
    }

    public void setLastRollDate(java.util.Date lastRollDate) {
        this.lastRollDate = lastRollDate;
    }

    public java.util.Date getNextRollDate() {
        return nextRollDate;
    }

    public void setNextRollDate(java.util.Date nextRollDate) {
        this.nextRollDate = nextRollDate;
    }

    public Integer getTdIntNumDays() {
        return tdIntNumDays;
    }

    public void setTdIntNumDays(Integer tdIntNumDays) {
        this.tdIntNumDays = tdIntNumDays;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getLastIntPastDue() {
        return lastIntPastDue;
    }

    public void setLastIntPastDue(BigDecimal lastIntPastDue) {
        this.lastIntPastDue = lastIntPastDue;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
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

    public String getRetryFlag() {
        return retryFlag;
    }

    public void setRetryFlag(String retryFlag) {
        this.retryFlag = retryFlag;
    }

    public BigDecimal getAgreeAgg() {
        return agreeAgg;
    }

    public void setAgreeAgg(BigDecimal agreeAgg) {
        this.agreeAgg = agreeAgg;
    }

    public IntType getLayerAgreement() {
        return layerAgreement;
    }

    public void setLayerAgreement(IntType layerAgreement) {
        this.layerAgreement = layerAgreement;
    }

    public IndividualFlag getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(IndividualFlag intFlag) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public java.util.Date getAdjUpdLastDate() {
        return adjUpdLastDate;
    }

    public void setAdjUpdLastDate(java.util.Date adjUpdLastDate) {
        this.adjUpdLastDate = adjUpdLastDate;
    }

    public java.util.Date getAdvUpdLastDate() {
        return advUpdLastDate;
    }

    public void setAdvUpdLastDate(java.util.Date advUpdLastDate) {
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

    public java.util.Date getLastPreAccrualDate() {
        return lastPreAccrualDate;
    }

    public void setLastPreAccrualDate(java.util.Date lastPreAccrualDate) {
        this.lastPreAccrualDate = lastPreAccrualDate;
    }

    public java.util.Date getIntUpdLastDate() {
        return intUpdLastDate;
    }

    public void setIntUpdLastDate(java.util.Date intUpdLastDate) {
        this.intUpdLastDate = intUpdLastDate;
    }
}
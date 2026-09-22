package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.NearPeriodType;
import com.dcits.deposit.enums.YearBasis;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbIntLayerRateEO {
    /** 费率编号 */
    @NotNull
    private String irlSeqNo;
    /** 协议编号 */
    private String agreementId;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账户固定利率 */
    private BigDecimal acctFixedRate;
    /** 账户利率浮动百分比 */
    private BigDecimal acctPercentRate;
    /** 账户利率浮动百分点 */
    private BigDecimal acctSpreadRate;
    /** 分段周期 */
    private CycleFreq nearPeriod;
    /** 分段周期类型 */
    private NearPeriodType nearPeriodType;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 计提天数 */
    private Integer accrDays;
    /** 计提金额 */
    private BigDecimal accrAmt;
    /** 靠档金额 */
    private BigDecimal nearAmt;
    /** 利息分类 */
    private IntClass intClass;
    /** 利率类型 */
    private IntType intType;
    /** 执行利率 */
    private BigDecimal realRate;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 浮动利率 */
    private BigDecimal floatRate;
    /** 月基准 */
    private MonthBasis monthBasis;
    /** 年基准天数 */
    private YearBasis yearBasis;
    /** 系统编号 */
    private String systemId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
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

    public CycleFreq getNearPeriod() {
        return nearPeriod;
    }

    public void setNearPeriod(CycleFreq nearPeriod) {
        this.nearPeriod = nearPeriod;
    }

    public NearPeriodType getNearPeriodType() {
        return nearPeriodType;
    }

    public void setNearPeriodType(NearPeriodType nearPeriodType) {
        this.nearPeriodType = nearPeriodType;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}
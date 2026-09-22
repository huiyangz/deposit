package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.YearBasis;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbIntMatrixEO {
    /** 阶梯序号 */
    @NotNull
    private String matrixNo;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 币种 */
    private AcctCcy ccy;
    /** 利率类型 */
    private IntType intType;
    /** 年基准天数 */
    private YearBasis yearBasis;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 基准利率类型 */
    private IntBasis intBasis;
    /** 基础汇率 */
    private BigDecimal baseRate;
    /** 频率 */
    private CycleFreq periodFreq;
    /** 周期天数 */
    private Integer dayNum;
    /** 阶梯金额 */
    private BigDecimal matrixAmt;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 利率折扣比例 */
    private BigDecimal discRate;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 最大上浮百分比 */
    private BigDecimal maxPercent;
    /** 最小上浮百分比 */
    private BigDecimal minPercent;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最小利率浮动点数 */
    private BigDecimal minSpreadRate;
    /** 最小浮动比例 */
    private BigDecimal minSpreadPercent;
    /** 最大利率浮动点数 */
    private BigDecimal maxSpreadRate;
    /** 最大浮动比例 */
    private BigDecimal maxSpreadPercent;
    /** 参考行内利率类型 */
    private IntType peggedIntType;

    public String getMatrixNo() {
        return matrixNo;
    }

    public void setMatrixNo(String matrixNo) {
        this.matrixNo = matrixNo;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public YearBasis getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(YearBasis yearBasis) {
        this.yearBasis = yearBasis;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public IntBasis getIntBasis() {
        return intBasis;
    }

    public void setIntBasis(IntBasis intBasis) {
        this.intBasis = intBasis;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public CycleFreq getPeriodFreq() {
        return periodFreq;
    }

    public void setPeriodFreq(CycleFreq periodFreq) {
        this.periodFreq = periodFreq;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public BigDecimal getMatrixAmt() {
        return matrixAmt;
    }

    public void setMatrixAmt(BigDecimal matrixAmt) {
        this.matrixAmt = matrixAmt;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public BigDecimal getDiscRate() {
        return discRate;
    }

    public void setDiscRate(BigDecimal discRate) {
        this.discRate = discRate;
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

    public BigDecimal getMaxPercent() {
        return maxPercent;
    }

    public void setMaxPercent(BigDecimal maxPercent) {
        this.maxPercent = maxPercent;
    }

    public BigDecimal getMinPercent() {
        return minPercent;
    }

    public void setMinPercent(BigDecimal minPercent) {
        this.minPercent = minPercent;
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

    public BigDecimal getMinSpreadRate() {
        return minSpreadRate;
    }

    public void setMinSpreadRate(BigDecimal minSpreadRate) {
        this.minSpreadRate = minSpreadRate;
    }

    public BigDecimal getMinSpreadPercent() {
        return minSpreadPercent;
    }

    public void setMinSpreadPercent(BigDecimal minSpreadPercent) {
        this.minSpreadPercent = minSpreadPercent;
    }

    public BigDecimal getMaxSpreadRate() {
        return maxSpreadRate;
    }

    public void setMaxSpreadRate(BigDecimal maxSpreadRate) {
        this.maxSpreadRate = maxSpreadRate;
    }

    public BigDecimal getMaxSpreadPercent() {
        return maxSpreadPercent;
    }

    public void setMaxSpreadPercent(BigDecimal maxSpreadPercent) {
        this.maxSpreadPercent = maxSpreadPercent;
    }

    public IntType getPeggedIntType() {
        return peggedIntType;
    }

    public void setPeggedIntType(IntType peggedIntType) {
        this.peggedIntType = peggedIntType;
    }
}
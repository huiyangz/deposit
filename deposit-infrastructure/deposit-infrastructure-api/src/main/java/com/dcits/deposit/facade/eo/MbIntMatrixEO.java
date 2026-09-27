package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.YearBasisType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbIntMatrixEO {
    /** 参考行内利率类型 */
    private IntType peggedIntType;
    /** 最大利率浮动点数 */
    private BigDecimal maxSpreadRate;
    /** 币种 */
    @NotNull
    private Ccy ccy;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 阶梯金额 */
    @NotNull
    private BigDecimal matrixAmt;
    /** 法人 */
    @NotNull
    private String company;
    /** 最小浮动比例 */
    private BigDecimal minSpreadPercent;
    /** 浮动点数 */
    private BigDecimal spreadRate;
    /** 最大浮动比例 */
    private BigDecimal maxSpreadPercent;
    /** 基础汇率 */
    private BigDecimal baseRate;
    /** 最小利率浮动点数 */
    private BigDecimal minSpreadRate;
    /** 阶梯序号 */
    @NotNull
    private String matrixNo;
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 最大上浮百分比 */
    private BigDecimal maxPercent;
    /** 频率 */
    private RollFreq periodFreq;
    /** 利率类型 */
    @NotNull
    private IntType intType;
    /** 周期天数 */
    private Integer dayNum;
    /** 行内挂牌利率 */
    private BigDecimal actualRate;
    /** 基准利率类型 */
    private IntBasis intBasis;
    /** 利率浮动百分比 */
    private BigDecimal spreadPercent;
    /** 最大执行利率 */
    private BigDecimal maxRate;
    /** 生效日期 */
    @NotNull
    private java.util.Date effectDate;
    /** 最小上浮百分比 */
    private BigDecimal minPercent;
    /** 最小执行利率 */
    private BigDecimal minRate;
    /** 年基准天数 */
    @NotNull
    private YearBasisType yearBasis;
    /** 利率折扣比例 */
    private BigDecimal discRate;

    public IntType getPeggedIntType() {
        return peggedIntType;
    }

    public void setPeggedIntType(IntType peggedIntType) {
        this.peggedIntType = peggedIntType;
    }

    public BigDecimal getMaxSpreadRate() {
        return maxSpreadRate;
    }

    public void setMaxSpreadRate(BigDecimal maxSpreadRate) {
        this.maxSpreadRate = maxSpreadRate;
    }

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
        this.ccy = ccy;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public BigDecimal getMatrixAmt() {
        return matrixAmt;
    }

    public void setMatrixAmt(BigDecimal matrixAmt) {
        this.matrixAmt = matrixAmt;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getMinSpreadPercent() {
        return minSpreadPercent;
    }

    public void setMinSpreadPercent(BigDecimal minSpreadPercent) {
        this.minSpreadPercent = minSpreadPercent;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public BigDecimal getMaxSpreadPercent() {
        return maxSpreadPercent;
    }

    public void setMaxSpreadPercent(BigDecimal maxSpreadPercent) {
        this.maxSpreadPercent = maxSpreadPercent;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getMinSpreadRate() {
        return minSpreadRate;
    }

    public void setMinSpreadRate(BigDecimal minSpreadRate) {
        this.minSpreadRate = minSpreadRate;
    }

    public String getMatrixNo() {
        return matrixNo;
    }

    public void setMatrixNo(String matrixNo) {
        this.matrixNo = matrixNo;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public BigDecimal getMaxPercent() {
        return maxPercent;
    }

    public void setMaxPercent(BigDecimal maxPercent) {
        this.maxPercent = maxPercent;
    }

    public RollFreq getPeriodFreq() {
        return periodFreq;
    }

    public void setPeriodFreq(RollFreq periodFreq) {
        this.periodFreq = periodFreq;
    }

    public IntType getIntType() {
        return intType;
    }

    public void setIntType(IntType intType) {
        this.intType = intType;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public IntBasis getIntBasis() {
        return intBasis;
    }

    public void setIntBasis(IntBasis intBasis) {
        this.intBasis = intBasis;
    }

    public BigDecimal getSpreadPercent() {
        return spreadPercent;
    }

    public void setSpreadPercent(BigDecimal spreadPercent) {
        this.spreadPercent = spreadPercent;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
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

    public YearBasisType getYearBasis() {
        return yearBasis;
    }

    public void setYearBasis(YearBasisType yearBasis) {
        this.yearBasis = yearBasis;
    }

    public BigDecimal getDiscRate() {
        return discRate;
    }

    public void setDiscRate(BigDecimal discRate) {
        this.discRate = discRate;
    }
}
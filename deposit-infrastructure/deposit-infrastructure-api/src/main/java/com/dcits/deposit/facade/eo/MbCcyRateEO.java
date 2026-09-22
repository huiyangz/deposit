package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbCcyRateEO {
    /** 汇率类型 */
    @NotNull
    private RateType rateType;
    /** 币种 */
    @NotNull
    private AcctCcy ccy;
    /** 归属机构号 */
    @NotNull
    private AcctBranch branch;
    /** 国家 */
    private IssCountry country;
    /** 报价类型 */
    private QuoteType quoteType;
    /** 汇买价 */
    private BigDecimal exchBuyRate;
    /** 汇卖价汇率 */
    private BigDecimal exchSellRate;
    /** 汇率中间价 */
    private BigDecimal middleRate;
    /** 钞买价 */
    private BigDecimal notesBuyRate;
    /** 钞卖价 */
    private BigDecimal notesSellRate;
    /** 上浮最大点数 */
    private BigDecimal maxFloatRateUp;
    /** 下浮最大点数 */
    private BigDecimal maxFloatRateDown;
    /** 央行参考汇率 */
    private BigDecimal centralBankRate;
    /** 生效日期 */
    @NotNull
    private java.util.Date effectDate;
    /** 生效时间 */
    @NotNull
    private String effectTime;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;

    public RateType getRateType() {
        return rateType;
    }

    public void setRateType(RateType rateType) {
        this.rateType = rateType;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
    }

    public BigDecimal getExchBuyRate() {
        return exchBuyRate;
    }

    public void setExchBuyRate(BigDecimal exchBuyRate) {
        this.exchBuyRate = exchBuyRate;
    }

    public BigDecimal getExchSellRate() {
        return exchSellRate;
    }

    public void setExchSellRate(BigDecimal exchSellRate) {
        this.exchSellRate = exchSellRate;
    }

    public BigDecimal getMiddleRate() {
        return middleRate;
    }

    public void setMiddleRate(BigDecimal middleRate) {
        this.middleRate = middleRate;
    }

    public BigDecimal getNotesBuyRate() {
        return notesBuyRate;
    }

    public void setNotesBuyRate(BigDecimal notesBuyRate) {
        this.notesBuyRate = notesBuyRate;
    }

    public BigDecimal getNotesSellRate() {
        return notesSellRate;
    }

    public void setNotesSellRate(BigDecimal notesSellRate) {
        this.notesSellRate = notesSellRate;
    }

    public BigDecimal getMaxFloatRateUp() {
        return maxFloatRateUp;
    }

    public void setMaxFloatRateUp(BigDecimal maxFloatRateUp) {
        this.maxFloatRateUp = maxFloatRateUp;
    }

    public BigDecimal getMaxFloatRateDown() {
        return maxFloatRateDown;
    }

    public void setMaxFloatRateDown(BigDecimal maxFloatRateDown) {
        this.maxFloatRateDown = maxFloatRateDown;
    }

    public BigDecimal getCentralBankRate() {
        return centralBankRate;
    }

    public void setCentralBankRate(BigDecimal centralBankRate) {
        this.centralBankRate = centralBankRate;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
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
}
package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MbCcyRate {
    /** 汇率类型 */
    private String rateType;
    /** 币种 */
    private String ccy;
    /** 归属机构号 */
    private String branch;
    /** 国家 */
    private String country;
    /** 报价类型 */
    private String quoteType;
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
    private Date effectDate;
    /** 生效时间 */
    private String effectTime;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
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

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
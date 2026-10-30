package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbFeeAmortize {
    /** 应收费序号 */
    private String osdSeqNo;
    /** 生效日期 */
    private Date effectDate;
    /** 摊销期限类型 */
    private String amortizePeriodType;
    /** 收费模式 */
    private String chargeMode;
    /** 摊销月 */
    private String amortizeMonth;
    /** 结束日期 */
    private Date endDate;
    /** 摊销名称 */
    private String amortizeName;
    /** 下一摊销日期 */
    private Date nextAmortizeDate;
    /** 摊销状态 */
    private String amortizeStatus;
    /** 交易类型 */
    private String tranType;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 交易机构号 */
    private String tranBranch;
    /** 摊销日 */
    private String amortizeDay;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 业务编号 */
    private String busiNo;
    /** 摊销总次数 */
    private Integer amortizeTotalCnt;
    /** 剩余摊销次数 */
    private Integer remainAmortizeCnt;
    /** 摊销币种 */
    private String amortizeCcy;
    /** 合同流水号 */
    private String contractNo;
    /** 交易参考号 */
    private String reference;
    /** 摊销总金额 */
    private BigDecimal amortizeTotalAmt;
    /** 费用类型 */
    private String feeType;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 已摊销次数 */
    private Integer amortizedCnt;
    /** 已摊销金额 */
    private BigDecimal amortizedAmt;
    /** 渠道类型 */
    private String sourceType;
    /** 摊销编号 */
    private String amortizeId;
    /** 摊销时间类型 */
    private String amortizeTimeType;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 上一摊销日期 */
    private Date lastAmortizeDate;
    /** 剩余摊销金额 */
    private BigDecimal remainAmortizeAmt;
    /** 交易日期 */
    private Date tranDate;

    public String getOsdSeqNo() {
        return osdSeqNo;
    }

    public void setOsdSeqNo(String osdSeqNo) {
        this.osdSeqNo = osdSeqNo;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getAmortizePeriodType() {
        return amortizePeriodType;
    }

    public void setAmortizePeriodType(String amortizePeriodType) {
        this.amortizePeriodType = amortizePeriodType;
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getAmortizeMonth() {
        return amortizeMonth;
    }

    public void setAmortizeMonth(String amortizeMonth) {
        this.amortizeMonth = amortizeMonth;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAmortizeName() {
        return amortizeName;
    }

    public void setAmortizeName(String amortizeName) {
        this.amortizeName = amortizeName;
    }

    public Date getNextAmortizeDate() {
        return nextAmortizeDate;
    }

    public void setNextAmortizeDate(Date nextAmortizeDate) {
        this.nextAmortizeDate = nextAmortizeDate;
    }

    public String getAmortizeStatus() {
        return amortizeStatus;
    }

    public void setAmortizeStatus(String amortizeStatus) {
        this.amortizeStatus = amortizeStatus;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getAmortizeDay() {
        return amortizeDay;
    }

    public void setAmortizeDay(String amortizeDay) {
        this.amortizeDay = amortizeDay;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo;
    }

    public Integer getAmortizeTotalCnt() {
        return amortizeTotalCnt;
    }

    public void setAmortizeTotalCnt(Integer amortizeTotalCnt) {
        this.amortizeTotalCnt = amortizeTotalCnt;
    }

    public Integer getRemainAmortizeCnt() {
        return remainAmortizeCnt;
    }

    public void setRemainAmortizeCnt(Integer remainAmortizeCnt) {
        this.remainAmortizeCnt = remainAmortizeCnt;
    }

    public String getAmortizeCcy() {
        return amortizeCcy;
    }

    public void setAmortizeCcy(String amortizeCcy) {
        this.amortizeCcy = amortizeCcy;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getAmortizeTotalAmt() {
        return amortizeTotalAmt;
    }

    public void setAmortizeTotalAmt(BigDecimal amortizeTotalAmt) {
        this.amortizeTotalAmt = amortizeTotalAmt;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public Integer getAmortizedCnt() {
        return amortizedCnt;
    }

    public void setAmortizedCnt(Integer amortizedCnt) {
        this.amortizedCnt = amortizedCnt;
    }

    public BigDecimal getAmortizedAmt() {
        return amortizedAmt;
    }

    public void setAmortizedAmt(BigDecimal amortizedAmt) {
        this.amortizedAmt = amortizedAmt;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getAmortizeId() {
        return amortizeId;
    }

    public void setAmortizeId(String amortizeId) {
        this.amortizeId = amortizeId;
    }

    public String getAmortizeTimeType() {
        return amortizeTimeType;
    }

    public void setAmortizeTimeType(String amortizeTimeType) {
        this.amortizeTimeType = amortizeTimeType;
    }

    public String getBankSeqNo() {
        return bankSeqNo;
    }

    public void setBankSeqNo(String bankSeqNo) {
        this.bankSeqNo = bankSeqNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public Date getLastAmortizeDate() {
        return lastAmortizeDate;
    }

    public void setLastAmortizeDate(Date lastAmortizeDate) {
        this.lastAmortizeDate = lastAmortizeDate;
    }

    public BigDecimal getRemainAmortizeAmt() {
        return remainAmortizeAmt;
    }

    public void setRemainAmortizeAmt(BigDecimal remainAmortizeAmt) {
        this.remainAmortizeAmt = remainAmortizeAmt;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}
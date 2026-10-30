package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AmortizeStatus;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbFeeAmortizeEO {
    /** 应收费序号 */
    private String osdSeqNo;
    /** 生效日期 */
    @NotNull
    private java.util.Date effectDate;
    /** 摊销期限类型 */
    @NotNull
    private TermType amortizePeriodType;
    /** 收费模式 */
    private FeeTakenMode chargeMode;
    /** 摊销月 */
    private String amortizeMonth;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 摊销名称 */
    private String amortizeName;
    /** 下一摊销日期 */
    private java.util.Date nextAmortizeDate;
    /** 摊销状态 */
    @NotNull
    private AmortizeStatus amortizeStatus;
    /** 交易类型 */
    @NotNull
    private TranType tranType;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 交易机构号 */
    @NotNull
    private TranBranch tranBranch;
    /** 摊销日 */
    private String amortizeDay;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 业务编号 */
    private String busiNo;
    /** 摊销总次数 */
    private Integer amortizeTotalCnt;
    /** 剩余摊销次数 */
    private Integer remainAmortizeCnt;
    /** 摊销币种 */
    @NotNull
    private Ccy amortizeCcy;
    /** 合同流水号 */
    private String contractNo;
    /** 交易参考号 */
    private String reference;
    /** 摊销总金额 */
    @NotNull
    private BigDecimal amortizeTotalAmt;
    /** 费用类型 */
    @NotNull
    private FeeType feeType;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 已摊销次数 */
    private Integer amortizedCnt;
    /** 已摊销金额 */
    private BigDecimal amortizedAmt;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 摊销编号 */
    @NotNull
    private String amortizeId;
    /** 摊销时间类型 */
    private AmortizeTimeType amortizeTimeType;
    /** 银行交易序号 */
    private String bankSeqNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 上一摊销日期 */
    private java.util.Date lastAmortizeDate;
    /** 剩余摊销金额 */
    @NotNull
    private BigDecimal remainAmortizeAmt;
    /** 交易日期 */
    @NotNull
    private java.util.Date tranDate;

    public String getOsdSeqNo() {
        return osdSeqNo;
    }

    public void setOsdSeqNo(String osdSeqNo) {
        this.osdSeqNo = osdSeqNo;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public TermType getAmortizePeriodType() {
        return amortizePeriodType;
    }

    public void setAmortizePeriodType(TermType amortizePeriodType) {
        this.amortizePeriodType = amortizePeriodType;
    }

    public FeeTakenMode getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(FeeTakenMode chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getAmortizeMonth() {
        return amortizeMonth;
    }

    public void setAmortizeMonth(String amortizeMonth) {
        this.amortizeMonth = amortizeMonth;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public String getAmortizeName() {
        return amortizeName;
    }

    public void setAmortizeName(String amortizeName) {
        this.amortizeName = amortizeName;
    }

    public java.util.Date getNextAmortizeDate() {
        return nextAmortizeDate;
    }

    public void setNextAmortizeDate(java.util.Date nextAmortizeDate) {
        this.nextAmortizeDate = nextAmortizeDate;
    }

    public AmortizeStatus getAmortizeStatus() {
        return amortizeStatus;
    }

    public void setAmortizeStatus(AmortizeStatus amortizeStatus) {
        this.amortizeStatus = amortizeStatus;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
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

    public Ccy getAmortizeCcy() {
        return amortizeCcy;
    }

    public void setAmortizeCcy(Ccy amortizeCcy) {
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

    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getAmortizeId() {
        return amortizeId;
    }

    public void setAmortizeId(String amortizeId) {
        this.amortizeId = amortizeId;
    }

    public AmortizeTimeType getAmortizeTimeType() {
        return amortizeTimeType;
    }

    public void setAmortizeTimeType(AmortizeTimeType amortizeTimeType) {
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

    public java.util.Date getLastAmortizeDate() {
        return lastAmortizeDate;
    }

    public void setLastAmortizeDate(java.util.Date lastAmortizeDate) {
        this.lastAmortizeDate = lastAmortizeDate;
    }

    public BigDecimal getRemainAmortizeAmt() {
        return remainAmortizeAmt;
    }

    public void setRemainAmortizeAmt(BigDecimal remainAmortizeAmt) {
        this.remainAmortizeAmt = remainAmortizeAmt;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }
}
package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbDossTranHist {
    /** 序号 */
    private String seqNo;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 子流水号 */
    private String subSeqNo;
    /** 交易参考号 */
    private String reference;
    /** 客户号 */
    private String clientNo;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 账户序号 */
    private String acctSeqNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private String acctCcy;
    /** 交易日期 */
    private Date tranDate;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 业务处理状态 */
    private String tranStatus;
    /** 计息标志 */
    private String intIndFlag;
    /** 计提日期 */
    private Date accrDate;
    /** 计提利息 */
    private BigDecimal intAccr;
    /** 备注 */
    private String remark;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getSubSeqNo() {
        return subSeqNo;
    }

    public void setSubSeqNo(String subSeqNo) {
        this.subSeqNo = subSeqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getIntIndFlag() {
        return intIndFlag;
    }

    public void setIntIndFlag(String intIndFlag) {
        this.intIndFlag = intIndFlag;
    }

    public Date getAccrDate() {
        return accrDate;
    }

    public void setAccrDate(Date accrDate) {
        this.accrDate = accrDate;
    }

    public BigDecimal getIntAccr() {
        return intAccr;
    }

    public void setIntAccr(BigDecimal intAccr) {
        this.intAccr = intAccr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
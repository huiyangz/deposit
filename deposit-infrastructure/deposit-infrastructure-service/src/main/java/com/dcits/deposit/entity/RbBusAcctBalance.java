package com.dcits.deposit.entity;

import java.math.BigDecimal;

public class RbBusAcctBalance {
    /** 上日账户可用余额 */
    private BigDecimal acctAvailBalPrev;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 透支总金额 */
    private BigDecimal oddAmount;
    /** 透支金额 */
    private BigDecimal odAmount;
    /** 账户可用余额 */
    private BigDecimal acctAvailBal;
    /** 系统内理财余额 */
    private BigDecimal finregAmount;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 冻结金额 */
    private BigDecimal pldAmount;
    /** 汇总金额 */
    private BigDecimal totalAmount;
    /** 久悬户账户余额 */
    private BigDecimal dosAmount;

    public BigDecimal getAcctAvailBalPrev() {
        return acctAvailBalPrev;
    }

    public void setAcctAvailBalPrev(BigDecimal acctAvailBalPrev) {
        this.acctAvailBalPrev = acctAvailBalPrev;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public BigDecimal getOddAmount() {
        return oddAmount;
    }

    public void setOddAmount(BigDecimal oddAmount) {
        this.oddAmount = oddAmount;
    }

    public BigDecimal getOdAmount() {
        return odAmount;
    }

    public void setOdAmount(BigDecimal odAmount) {
        this.odAmount = odAmount;
    }

    public BigDecimal getAcctAvailBal() {
        return acctAvailBal;
    }

    public void setAcctAvailBal(BigDecimal acctAvailBal) {
        this.acctAvailBal = acctAvailBal;
    }

    public BigDecimal getFinregAmount() {
        return finregAmount;
    }

    public void setFinregAmount(BigDecimal finregAmount) {
        this.finregAmount = finregAmount;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public BigDecimal getPldAmount() {
        return pldAmount;
    }

    public void setPldAmount(BigDecimal pldAmount) {
        this.pldAmount = pldAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDosAmount() {
        return dosAmount;
    }

    public void setDosAmount(BigDecimal dosAmount) {
        this.dosAmount = dosAmount;
    }
}
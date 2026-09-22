package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbAcctBalance {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 汇总金额 */
    private BigDecimal totalAmount;
    /** 上日汇总金额 */
    private BigDecimal totalAmountPrev;
    /** 上上日汇总金额 */
    private BigDecimal totalAmountLastPrev;
    /** 冻结金额 */
    private BigDecimal pldAmount;
    /** 系统内理财余额 */
    private BigDecimal finregAmount;
    /** 久悬户账户余额 */
    private BigDecimal dosAmount;
    /** 透支金额 */
    private BigDecimal odAmount;
    /** 透支总金额 */
    private BigDecimal oddAmount;
    /** 上次余额更新日期 */
    private Date lastBalUpdDate;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 客户号 */
    private String clientNo;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 创建时间戳 */
    private String createTimestamp;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmountPrev() {
        return totalAmountPrev;
    }

    public void setTotalAmountPrev(BigDecimal totalAmountPrev) {
        this.totalAmountPrev = totalAmountPrev;
    }

    public BigDecimal getTotalAmountLastPrev() {
        return totalAmountLastPrev;
    }

    public void setTotalAmountLastPrev(BigDecimal totalAmountLastPrev) {
        this.totalAmountLastPrev = totalAmountLastPrev;
    }

    public BigDecimal getPldAmount() {
        return pldAmount;
    }

    public void setPldAmount(BigDecimal pldAmount) {
        this.pldAmount = pldAmount;
    }

    public BigDecimal getFinregAmount() {
        return finregAmount;
    }

    public void setFinregAmount(BigDecimal finregAmount) {
        this.finregAmount = finregAmount;
    }

    public BigDecimal getDosAmount() {
        return dosAmount;
    }

    public void setDosAmount(BigDecimal dosAmount) {
        this.dosAmount = dosAmount;
    }

    public BigDecimal getOdAmount() {
        return odAmount;
    }

    public void setOdAmount(BigDecimal odAmount) {
        this.odAmount = odAmount;
    }

    public BigDecimal getOddAmount() {
        return oddAmount;
    }

    public void setOddAmount(BigDecimal oddAmount) {
        this.oddAmount = oddAmount;
    }

    public Date getLastBalUpdDate() {
        return lastBalUpdDate;
    }

    public void setLastBalUpdDate(Date lastBalUpdDate) {
        this.lastBalUpdDate = lastBalUpdDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
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

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
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

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
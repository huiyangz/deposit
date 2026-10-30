package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TbCashBalance {
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 更新日期 */
    private Date updateDate;
    /** 归属机构号 */
    private String branch;
    /** 上日期末余额 */
    private BigDecimal eopdAmount;
    /** 尾箱编号 */
    private String tailboxId;
    /** 可用余额 */
    private BigDecimal availableAmt;
    /** 上日期初金额 */
    private BigDecimal sopdAmount;
    /** 锁定完整币金额 */
    private BigDecimal lockAmount;
    /** 法人 */
    private String company;
    /** 金额 */
    private BigDecimal amount;
    /** 币种 */
    private String ccy;
    /** 锁定残损币金额 */
    private BigDecimal lockSpallAmt;
    /** 现金主键 */
    private Integer cashId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getEopdAmount() {
        return eopdAmount;
    }

    public void setEopdAmount(BigDecimal eopdAmount) {
        this.eopdAmount = eopdAmount;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public BigDecimal getAvailableAmt() {
        return availableAmt;
    }

    public void setAvailableAmt(BigDecimal availableAmt) {
        this.availableAmt = availableAmt;
    }

    public BigDecimal getSopdAmount() {
        return sopdAmount;
    }

    public void setSopdAmount(BigDecimal sopdAmount) {
        this.sopdAmount = sopdAmount;
    }

    public BigDecimal getLockAmount() {
        return lockAmount;
    }

    public void setLockAmount(BigDecimal lockAmount) {
        this.lockAmount = lockAmount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getLockSpallAmt() {
        return lockSpallAmt;
    }

    public void setLockSpallAmt(BigDecimal lockSpallAmt) {
        this.lockSpallAmt = lockSpallAmt;
    }

    public Integer getCashId() {
        return cashId;
    }

    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
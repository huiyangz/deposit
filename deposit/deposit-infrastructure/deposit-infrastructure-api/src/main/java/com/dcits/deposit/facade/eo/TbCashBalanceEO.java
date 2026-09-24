package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TbCashBalanceEO {
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 更新日期 */
    @NotNull
    private java.util.Date updateDate;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 上日期末余额 */
    @NotNull
    private BigDecimal eopdAmount;
    /** 尾箱编号 */
    @NotNull
    private String tailboxId;
    /** 可用余额 */
    @NotNull
    private BigDecimal availableAmt;
    /** 上日期初金额 */
    @NotNull
    private BigDecimal sopdAmount;
    /** 锁定完整币金额 */
    @NotNull
    private BigDecimal lockAmount;
    /** 法人 */
    @NotNull
    private String company;
    /** 金额 */
    @NotNull
    private BigDecimal amount;
    /** 币种 */
    @NotNull
    private Ccy ccy;
    /** 锁定残损币金额 */
    @NotNull
    private BigDecimal lockSpallAmt;
    /** 现金主键 */
    @NotNull
    private Integer cashId;
    /** 最后修改日期 */
    @NotNull
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
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

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
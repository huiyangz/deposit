package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TbCashBalanceEO {
    /** 现金主键 */
    @NotNull
    private Integer cashId;
    /** 尾箱编号 */
    private String tailboxId;
    /** 归属机构号 */
    private AcctBranch branch;
    /** 币种 */
    private AcctCcy ccy;
    /** 金额 */
    private BigDecimal amount;
    /** 可用余额 */
    private BigDecimal availableAmt;
    /** 上日期末余额 */
    private BigDecimal eopdAmount;
    /** 上日期初金额 */
    private BigDecimal sopdAmount;
    /** 锁定完整币金额 */
    private BigDecimal lockAmount;
    /** 锁定残损币金额 */
    private BigDecimal lockSpallAmt;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public Integer getCashId() {
        return cashId;
    }

    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAvailableAmt() {
        return availableAmt;
    }

    public void setAvailableAmt(BigDecimal availableAmt) {
        this.availableAmt = availableAmt;
    }

    public BigDecimal getEopdAmount() {
        return eopdAmount;
    }

    public void setEopdAmount(BigDecimal eopdAmount) {
        this.eopdAmount = eopdAmount;
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

    public BigDecimal getLockSpallAmt() {
        return lockSpallAmt;
    }

    public void setLockSpallAmt(BigDecimal lockSpallAmt) {
        this.lockSpallAmt = lockSpallAmt;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
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

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
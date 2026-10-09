package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbOdBranchInfoEO {
    /** 最后修改日期 */
    @NotNull
    private java.util.Date lastChangeDate;
    /** 已使用额度 */
    @NotNull
    private BigDecimal usedAmt;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 法人 */
    @NotNull
    private String company;
    /** 总额度 */
    @NotNull
    private BigDecimal totalLimit;

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public BigDecimal getUsedAmt() {
        return usedAmt;
    }

    public void setUsedAmt(BigDecimal usedAmt) {
        this.usedAmt = usedAmt;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
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

    public BigDecimal getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(BigDecimal totalLimit) {
        this.totalLimit = totalLimit;
    }
}
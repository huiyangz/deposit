package com.dcits.depsit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbOdBranchInfo {
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 已使用额度 */
    private BigDecimal usedAmt;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 归属机构号 */
    private String branch;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 总额度 */
    private BigDecimal totalLimit;

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
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
package com.dcits.deposit.entity;

public class FmBranchCcy {
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 归属机构号 */
    private String branch;
    /** 币种 */
    private String ccy;

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
}
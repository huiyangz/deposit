package com.dcits.deposit.entity;

public class RbAcctNatureDef {
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 账户属性描述 */
    private String acctNatureDesc;
    /** 账户属性 */
    private String acctNatureNo;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 账户属性分类 */
    private String natureClass;

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getAcctNatureDesc() {
        return acctNatureDesc;
    }

    public void setAcctNatureDesc(String acctNatureDesc) {
        this.acctNatureDesc = acctNatureDesc;
    }

    public String getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(String acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getNatureClass() {
        return natureClass;
    }

    public void setNatureClass(String natureClass) {
        this.natureClass = natureClass;
    }
}
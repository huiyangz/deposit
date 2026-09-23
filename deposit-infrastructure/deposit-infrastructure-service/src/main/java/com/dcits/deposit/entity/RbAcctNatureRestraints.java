package com.dcits.deposit.entity;

public class RbAcctNatureRestraints {
    /** 周期类型 */
    private String termType;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 账户限制类型 */
    private String restraintType;
    /** 账户属性 */
    private String acctNatureNo;
    /** 存期期限 */
    private String term;

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(String acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
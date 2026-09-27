package com.dcits.deposit.entity;

public class RbCorpNatureDef {
    /** 账户属性 */
    private String acctNatureNo;
    /** 存期期限 */
    private String term;
    /** 账户核准类型 */
    private String natureProperty;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 周期类型 */
    private String termType;
    /** 账户限制类型 */
    private String restraintType;
    /** 是否为企业 */
    private String corporation;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 境内境外标志 */
    private String inlandOffshore;
    /** 账户操作类型 */
    private String acctOperateType;
    /** 序号 */
    private String seqNo;
    /** 对公存款账户用途 */
    private String rbBusAcctPurpose;
    /** 账户状态 */
    private String acctStatus;

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

    public String getNatureProperty() {
        return natureProperty;
    }

    public void setNatureProperty(String natureProperty) {
        this.natureProperty = natureProperty;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getInlandOffshore() {
        return inlandOffshore;
    }

    public void setInlandOffshore(String inlandOffshore) {
        this.inlandOffshore = inlandOffshore;
    }

    public String getAcctOperateType() {
        return acctOperateType;
    }

    public void setAcctOperateType(String acctOperateType) {
        this.acctOperateType = acctOperateType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getRbBusAcctPurpose() {
        return rbBusAcctPurpose;
    }

    public void setRbBusAcctPurpose(String rbBusAcctPurpose) {
        this.rbBusAcctPurpose = rbBusAcctPurpose;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }
}
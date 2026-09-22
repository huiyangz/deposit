package com.dcits.deposit.entity;

public class RbCorpNatureDef {
    /** 序号 */
    private String seqNo;
    /** 账户属性 */
    private String acctNature;
    /** 账户用途 */
    private String reasonCode;
    /** 账户操作类型 */
    private String acctOperateType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private String termType;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 账户状态 */
    private String acctStatus;
    /** 法人 */
    private String company;
    /** 账户限制类型 */
    private String restraintType;
    /** 境内境外标志 */
    private String inlandOffshore;
    /** 是否为企业 */
    private String corporation;
    /** 账户核准类型 */
    private String natureProperty;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(String acctNature) {
        this.acctNature = acctNature;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getAcctOperateType() {
        return acctOperateType;
    }

    public void setAcctOperateType(String acctOperateType) {
        this.acctOperateType = acctOperateType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getInlandOffshore() {
        return inlandOffshore;
    }

    public void setInlandOffshore(String inlandOffshore) {
        this.inlandOffshore = inlandOffshore;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getNatureProperty() {
        return natureProperty;
    }

    public void setNatureProperty(String natureProperty) {
        this.natureProperty = natureProperty;
    }
}
package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOperateType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.NatureProperty;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RbCorpNatureDefEO {
    /** 账户属性 */
    private AcctNatureNo acctNatureNo;
    /** 存期期限 */
    private String term;
    /** 账户核准类型 */
    private NatureProperty natureProperty;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 周期类型 */
    private TermType termType;
    /** 账户限制类型 */
    private RestraintType restraintType;
    /** 是否为企业 */
    private String corporation;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 境内境外标志 */
    private String inlandOffshore;
    /** 账户操作类型 */
    private AcctOperateType acctOperateType;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 对公存款账户用途 */
    private RbBusAcctPurpose rbBusAcctPurpose;
    /** 账户状态 */
    private AcctStatus acctStatus;

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public NatureProperty getNatureProperty() {
        return natureProperty;
    }

    public void setNatureProperty(NatureProperty natureProperty) {
        this.natureProperty = natureProperty;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
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

    public AcctOperateType getAcctOperateType() {
        return acctOperateType;
    }

    public void setAcctOperateType(AcctOperateType acctOperateType) {
        this.acctOperateType = acctOperateType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public RbBusAcctPurpose getRbBusAcctPurpose() {
        return rbBusAcctPurpose;
    }

    public void setRbBusAcctPurpose(RbBusAcctPurpose rbBusAcctPurpose) {
        this.rbBusAcctPurpose = rbBusAcctPurpose;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }
}
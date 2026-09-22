package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOperateType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.NatureProperty;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RbCorpNatureDefEO {
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 账户属性 */
    private AcctNature acctNature;
    /** 账户用途 */
    private ReasonCode reasonCode;
    /** 账户操作类型 */
    private AcctOperateType acctOperateType;
    /** 存期期限 */
    private String term;
    /** 周期类型 */
    private TermType termType;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 法人 */
    private Company company;
    /** 账户限制类型 */
    private RestraintType restraintType;
    /** 境内境外标志 */
    private IndividualFlag inlandOffshore;
    /** 是否为企业 */
    private IndividualFlag corporation;
    /** 账户核准类型 */
    private NatureProperty natureProperty;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public AcctNature getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(AcctNature acctNature) {
        this.acctNature = acctNature;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(ReasonCode reasonCode) {
        this.reasonCode = reasonCode;
    }

    public AcctOperateType getAcctOperateType() {
        return acctOperateType;
    }

    public void setAcctOperateType(AcctOperateType acctOperateType) {
        this.acctOperateType = acctOperateType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public IndividualFlag getInlandOffshore() {
        return inlandOffshore;
    }

    public void setInlandOffshore(IndividualFlag inlandOffshore) {
        this.inlandOffshore = inlandOffshore;
    }

    public IndividualFlag getCorporation() {
        return corporation;
    }

    public void setCorporation(IndividualFlag corporation) {
        this.corporation = corporation;
    }

    public NatureProperty getNatureProperty() {
        return natureProperty;
    }

    public void setNatureProperty(NatureProperty natureProperty) {
        this.natureProperty = natureProperty;
    }
}
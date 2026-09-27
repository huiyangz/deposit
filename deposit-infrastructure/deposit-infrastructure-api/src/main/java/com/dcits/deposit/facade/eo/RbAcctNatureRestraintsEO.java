package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;

public class RbAcctNatureRestraintsEO {
    /** 周期类型 */
    private TermType termType;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 账户属性 */
    @NotNull
    private AcctNatureNo acctNatureNo;
    /** 存期期限 */
    private String term;

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
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

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

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
}
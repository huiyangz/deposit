package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureClass;
import jakarta.validation.constraints.NotNull;

public class RbAcctNatureDefEO {
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 账户属性描述 */
    @NotNull
    private String acctNatureDesc;
    /** 账户属性 */
    @NotNull
    private AcctNatureNo acctNatureNo;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 账户属性分类 */
    private NatureClass natureClass;

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

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public NatureClass getNatureClass() {
        return natureClass;
    }

    public void setNatureClass(NatureClass natureClass) {
        this.natureClass = natureClass;
    }
}
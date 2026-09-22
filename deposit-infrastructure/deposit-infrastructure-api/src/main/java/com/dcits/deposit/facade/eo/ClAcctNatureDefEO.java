package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.NatureClass;
import jakarta.validation.constraints.NotNull;

public class ClAcctNatureDefEO {
    /** 账户属性 */
    @NotNull
    private AcctNature acctNature;
    /** 账户属性描述 */
    private String acctNatureDesc;
    /** 账户属性分类 */
    private NatureClass natureClass;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 结构属性描述 */
    private String description;

    public AcctNature getAcctNature() {
        return acctNature;
    }

    public void setAcctNature(AcctNature acctNature) {
        this.acctNature = acctNature;
    }

    public String getAcctNatureDesc() {
        return acctNatureDesc;
    }

    public void setAcctNatureDesc(String acctNatureDesc) {
        this.acctNatureDesc = acctNatureDesc;
    }

    public NatureClass getNatureClass() {
        return natureClass;
    }

    public void setNatureClass(NatureClass natureClass) {
        this.natureClass = natureClass;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
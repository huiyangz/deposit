package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Weekend1;
import jakarta.validation.constraints.NotNull;

public class FmStateEO {
    /** 国家 */
    @NotNull
    private IssCountry country;
    /** 省代码 */
    @NotNull
    private OthBranchRegionalismCode state;
    /** 省名称 */
    private String stateDesc;
    /** 周末1 */
    private Weekend1 weekend1;
    /** 周末2 */
    private Weekend1 weekend2;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public OthBranchRegionalismCode getState() {
        return state;
    }

    public void setState(OthBranchRegionalismCode state) {
        this.state = state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public Weekend1 getWeekend1() {
        return weekend1;
    }

    public void setWeekend1(Weekend1 weekend1) {
        this.weekend1 = weekend1;
    }

    public Weekend1 getWeekend2() {
        return weekend2;
    }

    public void setWeekend2(Weekend1 weekend2) {
        this.weekend2 = weekend2;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
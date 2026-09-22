package com.dcits.deposit.entity;

public class FmState {
    /** 国家 */
    private String country;
    /** 省代码 */
    private String state;
    /** 省名称 */
    private String stateDesc;
    /** 周末1 */
    private String weekend1;
    /** 周末2 */
    private String weekend2;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public String getWeekend1() {
        return weekend1;
    }

    public void setWeekend1(String weekend1) {
        this.weekend1 = weekend1;
    }

    public String getWeekend2() {
        return weekend2;
    }

    public void setWeekend2(String weekend2) {
        this.weekend2 = weekend2;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
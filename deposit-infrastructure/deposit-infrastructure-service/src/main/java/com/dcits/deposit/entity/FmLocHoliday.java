package com.dcits.deposit.entity;

import java.util.Date;

public class FmLocHoliday {
    /** 标准假日标志 */
    private String holidayType;
    /** 假日描述 */
    private String holidayDesc;
    /** 国家 */
    private String country;
    /** 省代码 */
    private String state;
    /** 节假日日期 */
    private Date holidayDate;
    /** 工作日标志 */
    private String workingHoliday;
    /** 适用范围 */
    private String applyInd;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    public String getHolidayDesc() {
        return holidayDesc;
    }

    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc;
    }

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

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getWorkingHoliday() {
        return workingHoliday;
    }

    public void setWorkingHoliday(String workingHoliday) {
        this.workingHoliday = workingHoliday;
    }

    public String getApplyInd() {
        return applyInd;
    }

    public void setApplyInd(String applyInd) {
        this.applyInd = applyInd;
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
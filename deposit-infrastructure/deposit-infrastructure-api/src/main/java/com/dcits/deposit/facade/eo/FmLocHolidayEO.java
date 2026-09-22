package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.WorkingHoliday;
import jakarta.validation.constraints.NotNull;

public class FmLocHolidayEO {
    /** 标准假日标志 */
    private HolidayType holidayType;
    /** 假日描述 */
    private String holidayDesc;
    /** 国家 */
    @NotNull
    private IssCountry country;
    /** 省代码 */
    @NotNull
    private OthBranchRegionalismCode state;
    /** 节假日日期 */
    @NotNull
    private java.util.Date holidayDate;
    /** 工作日标志 */
    private WorkingHoliday workingHoliday;
    /** 适用范围 */
    private ApplyInd applyInd;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

    public String getHolidayDesc() {
        return holidayDesc;
    }

    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc;
    }

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

    public java.util.Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(java.util.Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public WorkingHoliday getWorkingHoliday() {
        return workingHoliday;
    }

    public void setWorkingHoliday(WorkingHoliday workingHoliday) {
        this.workingHoliday = workingHoliday;
    }

    public ApplyInd getApplyInd() {
        return applyInd;
    }

    public void setApplyInd(ApplyInd applyInd) {
        this.applyInd = applyInd;
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
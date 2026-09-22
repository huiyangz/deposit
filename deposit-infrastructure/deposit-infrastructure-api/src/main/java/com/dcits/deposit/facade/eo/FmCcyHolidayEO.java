package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import jakarta.validation.constraints.NotNull;

public class FmCcyHolidayEO {
    /** 币种 */
    @NotNull
    private AcctCcy ccy;
    /** 标准假日标志 */
    private HolidayType holidayType;
    /** 假日描述 */
    private String holidayDesc;
    /** 适用范围 */
    private ApplyInd applyInd;
    /** 节假日日期 */
    @NotNull
    private java.util.Date holidayDate;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 标识HUB是否跑批的标识 */
    private String hubBatchFlag;

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

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

    public ApplyInd getApplyInd() {
        return applyInd;
    }

    public void setApplyInd(ApplyInd applyInd) {
        this.applyInd = applyInd;
    }

    public java.util.Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(java.util.Date holidayDate) {
        this.holidayDate = holidayDate;
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

    public String getHubBatchFlag() {
        return hubBatchFlag;
    }

    public void setHubBatchFlag(String hubBatchFlag) {
        this.hubBatchFlag = hubBatchFlag;
    }
}
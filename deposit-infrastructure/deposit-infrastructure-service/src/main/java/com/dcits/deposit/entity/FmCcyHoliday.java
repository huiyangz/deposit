package com.dcits.deposit.entity;

import java.util.Date;

public class FmCcyHoliday {
    /** 币种 */
    private String ccy;
    /** 标准假日标志 */
    private String holidayType;
    /** 假日描述 */
    private String holidayDesc;
    /** 适用范围 */
    private String applyInd;
    /** 节假日日期 */
    private Date holidayDate;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 标识HUB是否跑批的标识 */
    private String hubBatchFlag;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

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

    public String getApplyInd() {
        return applyInd;
    }

    public void setApplyInd(String applyInd) {
        this.applyInd = applyInd;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
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

    public String getHubBatchFlag() {
        return hubBatchFlag;
    }

    public void setHubBatchFlag(String hubBatchFlag) {
        this.hubBatchFlag = hubBatchFlag;
    }
}
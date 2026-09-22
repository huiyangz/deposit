package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.FtaNature;
import com.dcits.deposit.enums.FtaType;
import com.dcits.deposit.enums.RateType;
import jakarta.validation.constraints.NotNull;

public class FmFtaBranchEO {
    /** 自贸区代码 */
    @NotNull
    private String ftaCode;
    /** 自贸区名称 */
    private String ftaDesc;
    /** 自贸区类型 */
    private FtaType ftaType;
    /** 自贸区汇率类型 */
    private RateType ftaRateType;
    /** 自贸区属性 */
    private FtaNature ftaNature;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public String getFtaDesc() {
        return ftaDesc;
    }

    public void setFtaDesc(String ftaDesc) {
        this.ftaDesc = ftaDesc;
    }

    public FtaType getFtaType() {
        return ftaType;
    }

    public void setFtaType(FtaType ftaType) {
        this.ftaType = ftaType;
    }

    public RateType getFtaRateType() {
        return ftaRateType;
    }

    public void setFtaRateType(RateType ftaRateType) {
        this.ftaRateType = ftaRateType;
    }

    public FtaNature getFtaNature() {
        return ftaNature;
    }

    public void setFtaNature(FtaNature ftaNature) {
        this.ftaNature = ftaNature;
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
}
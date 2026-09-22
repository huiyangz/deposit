package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import jakarta.validation.constraints.NotNull;

public class FmDateEO {
    /** 法人 */
    @NotNull
    private Company company;
    /** 系统所处的阶段 */
    private String systemPhase;
    /** 账户日终阶段标志 */
    private String acctEodFlag;
    /** 联机批量挂起标志 */
    private IndividualFlag suspendFlag;
    /** 上一运行日期 */
    private java.util.Date lastRunDate;
    /** 核心运行日期 */
    private java.util.Date runDate;
    /** 下一运行日期 */
    private java.util.Date nextRunDate;
    /** 本月月末日期 */
    private java.util.Date mthEndDate;
    /** 季末日期 */
    private java.util.Date qurEndDate;
    /** 半年末日期 */
    private java.util.Date halfEndDate;
    /** 本年年末日期 */
    private java.util.Date yrEndDate;
    /** 交易时间戳 */
    private String tranTimestamp;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSystemPhase() {
        return systemPhase;
    }

    public void setSystemPhase(String systemPhase) {
        this.systemPhase = systemPhase;
    }

    public String getAcctEodFlag() {
        return acctEodFlag;
    }

    public void setAcctEodFlag(String acctEodFlag) {
        this.acctEodFlag = acctEodFlag;
    }

    public IndividualFlag getSuspendFlag() {
        return suspendFlag;
    }

    public void setSuspendFlag(IndividualFlag suspendFlag) {
        this.suspendFlag = suspendFlag;
    }

    public java.util.Date getLastRunDate() {
        return lastRunDate;
    }

    public void setLastRunDate(java.util.Date lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    public java.util.Date getRunDate() {
        return runDate;
    }

    public void setRunDate(java.util.Date runDate) {
        this.runDate = runDate;
    }

    public java.util.Date getNextRunDate() {
        return nextRunDate;
    }

    public void setNextRunDate(java.util.Date nextRunDate) {
        this.nextRunDate = nextRunDate;
    }

    public java.util.Date getMthEndDate() {
        return mthEndDate;
    }

    public void setMthEndDate(java.util.Date mthEndDate) {
        this.mthEndDate = mthEndDate;
    }

    public java.util.Date getQurEndDate() {
        return qurEndDate;
    }

    public void setQurEndDate(java.util.Date qurEndDate) {
        this.qurEndDate = qurEndDate;
    }

    public java.util.Date getHalfEndDate() {
        return halfEndDate;
    }

    public void setHalfEndDate(java.util.Date halfEndDate) {
        this.halfEndDate = halfEndDate;
    }

    public java.util.Date getYrEndDate() {
        return yrEndDate;
    }

    public void setYrEndDate(java.util.Date yrEndDate) {
        this.yrEndDate = yrEndDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
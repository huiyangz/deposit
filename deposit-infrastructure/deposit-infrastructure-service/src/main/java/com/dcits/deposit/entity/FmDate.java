package com.dcits.deposit.entity;

import java.util.Date;

public class FmDate {
    /** 法人 */
    private String company;
    /** 系统所处的阶段 */
    private String systemPhase;
    /** 账户日终阶段标志 */
    private String acctEodFlag;
    /** 联机批量挂起标志 */
    private String suspendFlag;
    /** 上一运行日期 */
    private Date lastRunDate;
    /** 核心运行日期 */
    private Date runDate;
    /** 下一运行日期 */
    private Date nextRunDate;
    /** 本月月末日期 */
    private Date mthEndDate;
    /** 季末日期 */
    private Date qurEndDate;
    /** 半年末日期 */
    private Date halfEndDate;
    /** 本年年末日期 */
    private Date yrEndDate;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
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

    public String getSuspendFlag() {
        return suspendFlag;
    }

    public void setSuspendFlag(String suspendFlag) {
        this.suspendFlag = suspendFlag;
    }

    public Date getLastRunDate() {
        return lastRunDate;
    }

    public void setLastRunDate(Date lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Date getNextRunDate() {
        return nextRunDate;
    }

    public void setNextRunDate(Date nextRunDate) {
        this.nextRunDate = nextRunDate;
    }

    public Date getMthEndDate() {
        return mthEndDate;
    }

    public void setMthEndDate(Date mthEndDate) {
        this.mthEndDate = mthEndDate;
    }

    public Date getQurEndDate() {
        return qurEndDate;
    }

    public void setQurEndDate(Date qurEndDate) {
        this.qurEndDate = qurEndDate;
    }

    public Date getHalfEndDate() {
        return halfEndDate;
    }

    public void setHalfEndDate(Date halfEndDate) {
        this.halfEndDate = halfEndDate;
    }

    public Date getYrEndDate() {
        return yrEndDate;
    }

    public void setYrEndDate(Date yrEndDate) {
        this.yrEndDate = yrEndDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}
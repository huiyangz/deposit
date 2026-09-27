package com.dcits.deposit.facade.bo;

import java.util.Date;

/**
 * ST044 设置账户开户日期 输入BO
 */
public class ST044InputBO {

    /** 核心运行日期，必填，来源系统日期表（FM_DATE） */
    private Date runDate;

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}

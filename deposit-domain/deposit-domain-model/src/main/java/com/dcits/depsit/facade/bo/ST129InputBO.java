package com.dcits.depsit.facade.bo;

import java.util.Date;

/**
 * ST129 检查增加限制起始日期 输入 BO。
 *
 * <p>三个判定入参均为具体时点值，与步骤描述中的占位符一一绑定：
 * {开始日期}→startDate、{系统日期}→runDate、{结束日期}→endDate。
 * 本步骤不使用 FM_DATE 的其它日期字段（如 nextRunDate、lastRunDate）参与判定。</p>
 */
public class ST129InputBO {

    /** 上送的开始日期；对应源需求步骤描述中的 {开始日期}，为判定对象（必填）。 */
    private Date startDate;

    /** 核心运行日期；对应源需求步骤描述中的 {系统日期}，源自系统日期表（FM_DATE）的 runDate（必填）。 */
    private Date runDate;

    /** 结束日期；对应源需求步骤描述中的 {结束日期}，作为判定上界（必填）。 */
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST045 检查限额场景配置是否有效 输出。
 *
 * <p>业务字段按正式 Spec（ST045）输出表声明；区间外输出限额场景编码为空的物理表示（null 还是
 * 空字符串）为 Spec 待确认事项，见 {@link com.dcits.deposit.step.ST045Pbc} 中 FIXME。</p>
 */
public class ST045OutputBO extends StepResult {

    /** 限额场景编码；仅在交易落在控制区间内时非空，否则为空 */
    private String limitSceneNo;

    /** 限额控制开始日期 */
    private java.util.Date limitCtrlBgnDate;

    /** 限额控制结束日期 */
    private java.util.Date limitCtrlEndDate;

    /** 限额控制开始时间 */
    private java.util.Date limitCtrlBgnTime;

    /** 限额控制结束时间 */
    private java.util.Date limitCtrlEndTime;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public java.util.Date getLimitCtrlBgnDate() {
        return limitCtrlBgnDate;
    }

    public void setLimitCtrlBgnDate(java.util.Date limitCtrlBgnDate) {
        this.limitCtrlBgnDate = limitCtrlBgnDate;
    }

    public java.util.Date getLimitCtrlEndDate() {
        return limitCtrlEndDate;
    }

    public void setLimitCtrlEndDate(java.util.Date limitCtrlEndDate) {
        this.limitCtrlEndDate = limitCtrlEndDate;
    }

    public java.util.Date getLimitCtrlBgnTime() {
        return limitCtrlBgnTime;
    }

    public void setLimitCtrlBgnTime(java.util.Date limitCtrlBgnTime) {
        this.limitCtrlBgnTime = limitCtrlBgnTime;
    }

    public java.util.Date getLimitCtrlEndTime() {
        return limitCtrlEndTime;
    }

    public void setLimitCtrlEndTime(java.util.Date limitCtrlEndTime) {
        this.limitCtrlEndTime = limitCtrlEndTime;
    }
}

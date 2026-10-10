package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST109 检查限额场景配置是否有效 的输出 BO。
 *
 * <p>五个业务字段均非必填：limitSceneNo 在配置有效时为入参原值、无效时为空值；
 * 四类控制区间字段在有效时按命中配置记录的原值回显（记录列可为空，不得以默认值替代）。</p>
 */
public class ST109OutputBO extends StepResult {

    /** 限额场景编码：有效时返回输入值；无效时为空 */
    private java.lang.String limitSceneNo;

    /** 限额控制开始日期：有效时回显所取配置记录的值 */
    private java.util.Date limitCtrlBgnDate;

    /** 限额控制结束日期：有效时回显所取配置记录的值 */
    private java.util.Date limitCtrlEndDate;

    /** 限额控制开始时间：有效时回显所取配置记录的值 */
    private java.util.Date limitCtrlBgnTime;

    /** 限额控制结束时间：有效时回显所取配置记录的值 */
    private java.util.Date limitCtrlEndTime;

    public java.lang.String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(java.lang.String limitSceneNo) {
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

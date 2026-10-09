package com.dcits.depsit.facade.bo;

import java.util.Date;

import com.dcits.common.step.StepResult;

/**
 * ST086 设置账户开户日期 输出 BO。
 *
 * <p>除本步骤的业务输出字段 {@code acctOpenDate}（账户开户日期）外，所有结果状态承载于工程基类
 * {@link StepResult}：本步骤无业务失败场景，正常完成时 {@code succeed = true}、
 * {@code errorCode} 与 {@code errorMessage} 均为 {@code null}。
 *
 * <p>源需求「## 输出」表把 {@code acctOpenDate} 标记为「非必填」，该标记为其可空性声明；
 * 本步骤唯一执行路径上该字段总被赋值，成功后不返回空值。
 */
public class ST086OutputBO extends StepResult {

    /** 账户开户日期，类型 {@link java.util.Date}，取值为步骤 1 赋值的 [系统日期]，原值传递不做归一化 */
    private Date acctOpenDate;

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }
}

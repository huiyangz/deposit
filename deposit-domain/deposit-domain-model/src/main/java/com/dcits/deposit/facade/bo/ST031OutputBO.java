package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST031 验证密码 步骤输出。
 *
 * <p>业务字段定义来源：正式 Spec ST031「输出」表（执行结果，String，非必填）。公共步骤结果
 * 状态（succeed、errorCode、errorMessage）由基类 {@link StepResult} 承载。</p>
 */
public class ST031OutputBO extends StepResult {

    /** 执行结果（非必填；取值语义见待确认事项 3，当前不赋值） */
    // FIXME 业务项:ST031/验证密码 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段「执行结果」取值语义未定义：「输出」表声明「执行结果」字段，而「步骤描述」第 2 条返回「检查结果」为「通过」，成功时字段承载检查结果「通过」还是《校验密码》返回的 [执行结果] 原值、失败时是否仍承载非「通过」值均未确认（Spec 待确认事项 3） - 影响:该字段当前不赋值，其承载语义与赋值时机未确定 - 待确认:成功/失败时输出字段「执行结果」应承载的取值
    private String executeResult;

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }
}

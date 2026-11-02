package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST032 检查交易金额 步骤输出。
 *
 * <p>需求未登记「输出」表，本步骤仅以公共步骤结果（succeed/errorCode/errorMessage）表达
 * 成功与业务失败；成功路径的检查结果"通过"的业务输出承载方式见待确认事项 TBD-2。</p>
 */
public class ST032OutputBO extends StepResult {

    // FIXME 业务项:ST032/检查交易金额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求未登记「输出」表，检查结果"通过"的业务输出承载方式（公共成功状态或业务输出字段）未确认（Spec 待确认事项 TBD-2） - 影响:成功路径当前仅以 succeed=true 表达检查结果为"通过"，无业务输出字段承载 - 待确认:"通过"仅以公共成功状态表达，还是需由业务输出字段承载及字段定义
}

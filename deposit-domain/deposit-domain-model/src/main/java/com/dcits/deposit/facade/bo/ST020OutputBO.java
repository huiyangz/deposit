package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST020 检查转账交易类型 输出 BO。
 *
 * <p>需求未登记业务输出字段（正式 Spec「输出」），检查结果「通过」由步骤框架成功状态承载
 * （{@code StepResult.succeed=true}，错误码与错误信息为空）；业务失败由错误码 ER0067 承载。</p>
 *
 * @see com.dcits.common.step.StepResult
 */
public class ST020OutputBO extends StepResult {

    // FIXME 业务项:ST020/检查转账交易类型 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求文档未登记「输出」表，检查结果「通过」暂由步骤框架成功状态（StepResult.succeed=true）承载，是否要求独立业务输出字段承载检查结果未确认 - 影响:独立业务输出字段的有无与含义未定，确认后需补充字段及对应断言 - 待确认:调用方是否要求独立业务输出字段承载检查结果「通过」（正式 Spec 待确认事项 TBD-3）
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST016 检查账户客户一致性 输出 BO。
 *
 * <p>继承项目步骤公共结果机制 {@link StepResult}，succeed/errorCode/errorMessage 由基类承载，
 * 本 BO 不重复声明。业务失败时 succeed=false 且 errorCode=ER0078；检查通过时 succeed=true
 * 且错误字段为空（正式 Spec「步骤结果契约」）。</p>
 */
public class ST016OutputBO extends StepResult {

    // FIXME 业务项:ST016/检查账户客户一致性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求无「输出」表，仅文字声明返回检查结果「通过」，检查结果「通过」是否有独立业务输出字段及物理取值（字面量「通过」还是其它编码）未确认（Spec TBD-2） - 影响:当前按 Spec「步骤结果契约」以 succeed=true 步骤成功状态承载检查通过结论，调用方读取/比较该结论的具体契约未确认 - 待确认:检查结果「通过」是否需要独立输出字段及其物理取值
}

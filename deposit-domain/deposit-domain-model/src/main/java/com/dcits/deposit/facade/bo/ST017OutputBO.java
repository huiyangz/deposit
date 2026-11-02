package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST017 检查币种一致性 输出 BO。
 *
 * <p>继承 {@link StepResult}，成功/失败状态与错误字段由基类提供。正式 Spec ST017 无
 * 「输出」表，检查结果「通过」落实为步骤成功状态（succeed=true、错误字段为 null）；
 * 「通过」是否另有字面业务值字段承载未确认（Spec 待确认事项 2），不新增未确认输出字段。</p>
 */
public class ST017OutputBO extends StepResult {
}

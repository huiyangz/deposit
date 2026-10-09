package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST017 检查币种一致性 输出 BO。
 *
 * <p>源需求未声明业务输出字段，检查结果以工程基类 {@link StepResult} 的状态字段表达：
 * 币种一致时 {@code succeed = true} 且错误码为空，币种不一致时 {@code succeed = false}
 * 且错误码为 {@code "ER0051"}；本类不新增业务字段。
 */
public class ST017OutputBO extends StepResult {
}

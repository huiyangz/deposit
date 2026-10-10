package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST130 登记账户限制信息 输出 BO。
 *
 * <p>源需求没有「## 输出」章节、未声明任何业务输出字段，本步骤不返回业务输出字段
 * （Spec「### 输出」与「验收范围与明确不覆盖的事项」第 7 项），因此本 BO 除继承自
 * {@link StepResult} 的执行结果外不声明业务字段。</p>
 *
 * <p>执行结果沿用既有 {@link StepResult} 契约：正常完成时 {@code succeed = true}、{@code errorCode}
 * 与 {@code errorMessage} 均为 {@code null}；本步骤无业务失败场景，失败仅由技术异常传播表达
 * （Spec REQ-005）。</p>
 */
public class ST130OutputBO extends StepResult {
}

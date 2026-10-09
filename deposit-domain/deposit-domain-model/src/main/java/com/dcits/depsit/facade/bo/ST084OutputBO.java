package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST084 检查联系人：步骤输出。
 *
 * <p>本步骤共有四个互斥的可达出口：检查结果“通过”，以及错误码 ER0036／ER0037／ER0038。
 * 正式 Spec 明确检查结果的字段名、类型、必填性与落库位源需求未定义，且不补写该字段契约
 * （见「输入、输出及依赖契约（输出）」说明与「验收范围与明确不覆盖的事项」第 1 项），
 * 故本 BO 不承载检查结果的业务字段。检查结果为“通过”时以继承的
 * {@link StepResult#isSucceed()} 为 true 且错误字段为 null 表达；业务失败时以
 * {@link StepResult#getErrorCode()} 表达对应错误码。</p>
 */
public class ST084OutputBO extends StepResult {
}

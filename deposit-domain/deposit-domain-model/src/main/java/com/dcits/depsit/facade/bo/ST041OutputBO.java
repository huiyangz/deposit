package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST041 检查存入交易类型 输出 BO。
 *
 * 源需求无输出章节，未定义「检查结果」与「错误码」的承载字段，二者由基类 {@link StepResult} 承载：
 * 判定为「现金存入」时 {@code succeed=true} 且错误字段为 null（检查结果为「通过」）；
 * 判定不为「现金存入」时 {@code succeed=false}、{@code errorCode="ER0049"}。
 */
public class ST041OutputBO extends StepResult {
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST020 检查交易金额 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；交易金额小于等于 0 时 succeed=false，
 * 错误码为 ER0050。SPEC 未定义其他业务输出字段。
 */
public class ST020OutputBO extends StepResult {

}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST006 检查存入交易类型 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；交易类型不等于“现金存入”时 succeed=false，
 * 错误码为 ER0049。SPEC 未定义其他业务输出字段。
 */
public class ST006OutputBO extends StepResult {

}

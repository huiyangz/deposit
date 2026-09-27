package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST022 检查现金项目编号 输出BO
 *
 * 检查结果“通过”以 succeed=true 体现；{现金项目编号}为空时 succeed=false，
 * 错误码为 ER0056。SPEC 未定义业务输出字段。
 */
public class ST022OutputBO extends StepResult {

}

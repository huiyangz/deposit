package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST099 检查利息资本化标志 输出 BO。
 *
 * <p>源需求无「## 输出」章节，未定义业务输出字段。检查结果按项目公共步骤框架以步骤结果的
 * 成功状态承载（「通过」＝{@code succeed = true} 且错误字段为空），失败以
 * {@code errorCode = "ER0034"} 承载；本 BO 因此不新增业务输出字段。</p>
 */
public class ST099OutputBO extends StepResult {
}

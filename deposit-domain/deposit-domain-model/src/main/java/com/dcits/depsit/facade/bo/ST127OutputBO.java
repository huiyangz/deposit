package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST127 检查限制类型 输出BO。
 *
 * <p>源需求未提供「## 输出」表，未定义检查结果的字段名与类型，故本 BO 不声明额外业务字段，
 * 检查结果由基类 {@link StepResult} 承载：{@code succeed=true} 表示检查结果「通过」，
 * {@code succeed=false} 表示检查结果「不通过」；两种情况均不产出错误码，错误字段保持 null。</p>
 */
public class ST127OutputBO extends StepResult {
}

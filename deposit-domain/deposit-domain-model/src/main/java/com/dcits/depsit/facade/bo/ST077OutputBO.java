package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST077 检查利率浮动类型 步骤输出。
 *
 * <p>源需求无「输出」章节，未声明业务输出字段名、类型与承载实体，故本 BO 除继承 {@link StepResult}
 * 的执行结果外不含业务字段：检查结果「通过」在工程对照上表现为 {@code succeed} 为 true 且
 * {@code errorCode}、{@code errorMessage} 为 null；错误码 {@code ER0032} 由 {@code errorCode} 承载。
 * 二者由同一次判定互斥产出。</p>
 */
public class ST077OutputBO extends StepResult {
}

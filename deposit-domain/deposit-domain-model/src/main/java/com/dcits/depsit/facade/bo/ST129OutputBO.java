package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST129 检查增加限制起始日期 输出 BO。
 *
 * <p>源需求无「输出」章节，未声明检查结果以外的产出字段，故除继承
 * {@link StepResult} 外不声明业务字段：检查结果「不通过」／「通过」由
 * 基类的 {@code succeed} 承载（true＝通过、false＝不通过），二者互斥；
 * 本步骤源需求未给出任何错误码，不通过时 {@code errorCode}、
 * {@code errorMessage} 保持 null。</p>
 */
public class ST129OutputBO extends StepResult {
}

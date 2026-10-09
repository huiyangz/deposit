package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST032 检查交易金额 输出。
 *
 * <p>源需求无「输出」章节，未声明任何业务输出字段，本步骤的可观察产出由
 * {@link StepResult} 承载，故本类不新增业务字段：</p>
 * <ul>
 *     <li>错误码 {@code ER0050}（交易金额小于等于 0 时）：{@code succeed} 为 false、
 *     {@code errorCode} 为 {@code "ER0050"}；</li>
 *     <li>检查结果「通过」（交易金额大于 0 时）：{@code succeed} 为 true，两个错误字段为 null。</li>
 * </ul>
 *
 * <p>两项产出互斥，由同一分支判定产出。</p>
 */
public class ST032OutputBO extends StepResult {
}

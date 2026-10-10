package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST098 检查账户用途 输出 BO。
 *
 * <p>继承项目公共步骤结果载体 {@link StepResult}，不新增业务输出字段：源需求无「## 输出」章节，
 * 也未声明任何业务输出字段，Spec「### 输出」只按基类既有契约表达结果状态，故本 BO 不重复声明
 * {@code succeed}／{@code errorCode}／{@code errorMessage}，也不补出「检查结果」字段。</p>
 *
 * <p>结果承载：「检查结果为『通过』」以成功状态表达（{@code succeed = true}，两个错误字段保持
 * {@code null}）；五个错误码分支以业务失败状态表达（{@code succeed = false}、{@code errorCode}
 * 为 {@code "ER0012"}～{@code "ER0016"} 中对应的一个）。{@code errorMessage} 的文本源需求未规定，
 * 取错误码注册表的登记文本，不作为断言对象。</p>
 */
public class ST098OutputBO extends StepResult {
}

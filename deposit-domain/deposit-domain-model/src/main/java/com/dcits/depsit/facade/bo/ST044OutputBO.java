package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST044 检查账户存在性 步骤输出 BO。
 *
 * <p>继承公共步骤结果 {@link StepResult}，检查结论由基类字段承载：检查结果为「通过」对应
 * {@code succeed = true}（错误字段为 {@code null}）；返回错误码 {@code ER0048} 对应
 * {@code succeed = false} 且 {@code errorCode = "ER0048"}。</p>
 *
 * <p>业务输出字段来源：正式 Spec「### 输出」表，只声明 {@code baseAcctNo}（非必填）一个字段。
 * 源需求未定义该输出字段的取值来源与出现条件，本步骤不新增输出字段，也不臆造其透传或赋值口径。</p>
 */
public class ST044OutputBO extends StepResult {

    /** 账号（非必填）。源需求未定义取值来源与出现条件 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

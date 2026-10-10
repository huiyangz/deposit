package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST126 检查是否存在现金止付限制 —— 步骤输出。
 *
 * <p>业务输出为 {@code cashStopPayFlag}（现金止付标志），取中文字面值：
 * 「是」表示存在现金止付限制，「否」表示不存在现金止付限制；已定义的业务路径
 * （步骤 1 零条生效限制信息、任一条限制命中、全部限制不满足）均有确定取值，
 * 不为空、不取「是」「否」之外的取值。</p>
 *
 * <p>本步骤无业务失败场景（源需求「## 失败处理」），检查结论不以错误码表达：
 * 各路径均以 {@code succeed=true} 返回，错误字段保持 null。</p>
 */
public class ST126OutputBO extends StepResult {

    /** 现金止付标志（非必填）："是"-存在现金止付限制，"否"-不存在现金止付限制 */
    private String cashStopPayFlag;

    public String getCashStopPayFlag() {
        return cashStopPayFlag;
    }

    public void setCashStopPayFlag(String cashStopPayFlag) {
        this.cashStopPayFlag = cashStopPayFlag;
    }
}

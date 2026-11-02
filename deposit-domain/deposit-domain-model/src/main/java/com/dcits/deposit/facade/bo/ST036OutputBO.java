package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DealFlow;

/**
 * ST036 检查黑名单 步骤输出。
 *
 * <p>继承 {@link StepResult}，业务输出字段来自正式 Spec「输出」表：dealFlow（非必填，
 * 来源名单限制规则参数表 RC_RULE_TYPE）。「通过」不设置 dealFlow；「拒绝/授权/提醒」
 * 通过 dealFlow 承载（对应 {@link DealFlow} 枚举值 B/A/D）。</p>
 */
public class ST036OutputBO extends StepResult {

    /** 处理方式（非必填）。 */
    private DealFlow dealFlow;

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }
}

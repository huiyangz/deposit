package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DealFlow;

/**
 * ST100 检查黑名单 输出 BO。
 *
 * <p>只承载正式 Spec（{@code docs/specs/ST100.md}「### 输出」表）声明的唯一业务字段 {@code dealFlow}；
 * 检查结果为「拒绝」「授权」「提醒」时取该次命中规则的 $处理方式$（{@code B}／{@code A}／{@code D}），
 * 检查结果为「通过」时不取得 $处理方式$、该字段无值。</p>
 */
public class ST100OutputBO extends StepResult {

    /** 处理方式（非必填）：承载本步骤的检查结果。 */
    private DealFlow dealFlow;

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DealFlow;

/**
 * ST041 处理限额 输出。
 *
 * <p>业务输出为处理方式（dealFlow）；除该字段外本步骤不产生其它业务输出。
 * succeed/errorCode/errorMessage 由基类 {@link StepResult} 提供。</p>
 */
public class ST041OutputBO extends StepResult {

    /** 处理方式（非必填，来源实体：限额控制配置） */
    private DealFlow dealFlow;

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }
}

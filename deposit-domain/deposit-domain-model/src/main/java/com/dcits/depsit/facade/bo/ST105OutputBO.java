package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DealFlow;

/**
 * ST105 处理限额 输出 BO。
 *
 * <p>继承项目公共步骤结果载体 {@link StepResult}；字段名、类型与业务名称照录 Spec「### 输出」表，
 * 唯一业务输出字段为 {@code dealFlow}（类型 {@code com.dcits.depsit.enums.DealFlow}，非字符串）。
 * 不新增「## 输出」表以外的业务输出字段，也不重复声明 {@code succeed}／{@code errorCode}／
 * {@code errorMessage}。</p>
 *
 * <p>取值映射（REQ-002／003／004／005）：「授权」↔ {@link DealFlow#A}、「拒绝」↔ {@link DealFlow#B}、
 * 「提醒」↔ {@link DealFlow#D}；输出为该枚举对象本身。表列「非必填」记的是实体列
 * {@code DEAL_FLOW} 的可空性。</p>
 */
public class ST105OutputBO extends StepResult {

    /** 处理方式（非必填；承载子步骤2 返回的检查结果：A-授权／B-拒绝／D-提醒） */
    private DealFlow dealFlow;

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }
}

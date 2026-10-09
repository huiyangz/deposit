package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import java.math.BigDecimal;

/**
 * ST096 设置账户执行利率 输出 BO。
 *
 * <p>业务字段仅 {@code realRate}（执行利率）一个，取值为本步骤设置到账户的执行利率取值，
 * 即输入 {@code realRate}（REQ-002）；步骤结果状态由工程基类 {@link StepResult} 承载。</p>
 *
 * <p>源需求「## 输出」表把 {@code realRate} 标记为「非必填」，该标记为其可空性声明；
 * 本步骤唯一执行路径上该字段总被赋值，成功后不返回空值。源需求输出表未声明落库实体与落库字段，
 * 本 BO 不据此指定落库位置（Spec 不覆盖事项 1）。</p>
 */
public class ST096OutputBO extends StepResult {

    /** 执行利率，本步骤取值为输入 {@code realRate}，作为设置到账户执行利率属性的取值，原值传递 */
    private BigDecimal realRate;

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }
}

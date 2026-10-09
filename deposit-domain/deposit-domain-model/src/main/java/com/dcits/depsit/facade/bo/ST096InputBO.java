package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST096 设置账户执行利率 输入 BO。
 *
 * <p>承载「## 输入」表的唯一字段 {@code realRate}（执行利率，类型 {@code java.math.BigDecimal}，
 * 必填），该值由调用方在同一次执行中直接提供，是本步骤赋值的唯一取值来源（REQ-001）。</p>
 *
 * <p>源需求输入表「来源实体」列为空，本 BO 不据此发起任何账户、产品、机构实体或数据查询；
 * 源需求未定义 {@code realRate} 未上送或为空（null）时的行为（Spec 不覆盖事项 2），
 * 本 BO 只按字段契约承载该值，不设默认值、不生成校验分支。</p>
 */
public class ST096InputBO {

    /** 执行利率，即步骤描述中的 [执行利率]，类型 {@link java.math.BigDecimal}，必填 */
    private BigDecimal realRate;

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }
}

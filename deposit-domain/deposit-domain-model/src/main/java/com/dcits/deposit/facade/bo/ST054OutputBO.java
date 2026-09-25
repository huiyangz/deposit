package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST054 设置账户执行利率 输出BO。
 *
 * <p>来源：《ST054 设置账户执行利率》门禁通过版 SPEC 输出表。
 * realRate 的来源实体为对公存款利息明细表（RB_BUS_ACCT_INT_DETAIL），
 * 本步骤仅完成赋值，不访问该实体。</p>
 */
public class ST054OutputBO extends StepResult {

    /** 执行利率 */
    private BigDecimal realRate;

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }
}

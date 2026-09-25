package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST054 设置账户执行利率 输入BO。
 *
 * <p>来源：《ST054 设置账户执行利率》门禁通过版 SPEC 输入表。</p>
 */
public class ST054InputBO {

    /** 执行利率（必填） */
    private BigDecimal realRate;

    public BigDecimal getRealRate() {
        return realRate;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = realRate;
    }
}

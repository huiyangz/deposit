package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST077 检查利率浮动类型 步骤输入。
 *
 * <p>本步骤依据上送的三个利率字段——账户固定利率（{@code acctFixedRate}）、账户利率浮动百分比
 * （{@code acctPercentRate}）、账户利率浮动百分点（{@code acctSpreadRate}）的必输性进行判定：
 * 三者中恰有一个不为空时检查结果为「通过」，否则产出错误码 {@code ER0032}。
 * 三个字段在判定中的作用完全对等，与数值大小、正负号、标度无关。</p>
 *
 * <p>三个字段均为 {@link java.math.BigDecimal} 且均标「非必填」；「空」即未上送（值为 {@code null}），
 * 本步骤不假定三者的取数出处（源需求输入表「来源实体」列为空），也不做取值合法性、精度与标度校验。</p>
 */
public class ST077InputBO {

    /** 账户固定利率，非必填，参与「不为空」计数 */
    private BigDecimal acctFixedRate;

    /** 账户利率浮动百分比，非必填，参与「不为空」计数 */
    private BigDecimal acctPercentRate;

    /** 账户利率浮动百分点，非必填，参与「不为空」计数 */
    private BigDecimal acctSpreadRate;

    public BigDecimal getAcctFixedRate() {
        return acctFixedRate;
    }

    public void setAcctFixedRate(BigDecimal acctFixedRate) {
        this.acctFixedRate = acctFixedRate;
    }

    public BigDecimal getAcctPercentRate() {
        return acctPercentRate;
    }

    public void setAcctPercentRate(BigDecimal acctPercentRate) {
        this.acctPercentRate = acctPercentRate;
    }

    public BigDecimal getAcctSpreadRate() {
        return acctSpreadRate;
    }

    public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
        this.acctSpreadRate = acctSpreadRate;
    }
}

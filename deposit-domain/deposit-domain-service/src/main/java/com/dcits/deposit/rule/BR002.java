package com.dcits.deposit.rule;

import java.math.BigDecimal;

/**
 * BR002 计算账户利率（计算类）
 *
 * a.账户利率浮动百分点不等于0时，执行利率=产品利率+账户利率浮动百分点；
 * b.账户利率浮动百分比不等于0时，执行利率=产品利率*(1+账户利率浮动百分比)；
 * c.账户固定利率不等于0时，执行利率=账户固定利率。
 * 条件按描述顺序 a→b→c 判定，先命中先返回；输入字段为空时视同0参与条件判定，
 * 不触发对应分支；产品利率为空时在 a、b 分支的计算中视同0；
 * 三个条件均不满足时执行利率未赋值，返回 null。
 */
public class BR002 {

    /**
     * 计算账户执行利率
     *
     * @param acctSpreadRate  账户利率浮动百分点，为空视同0参与条件判定
     * @param acctPercentRate 账户利率浮动百分比，为空视同0参与条件判定
     * @param acctFixedRate   账户固定利率，为空视同0参与条件判定
     * @param productRate     产品利率，为空时在a、b分支的计算中视同0
     * @return 执行利率；无分支触发时未赋值返回 null
     */
    public static BigDecimal execute(BigDecimal acctSpreadRate, BigDecimal acctPercentRate, BigDecimal acctFixedRate, BigDecimal productRate) {
        // a.账户利率浮动百分点不等于0：执行利率 = 产品利率 + 账户利率浮动百分点
        if (isNonZero(acctSpreadRate)) {
            return nullToZero(productRate).add(acctSpreadRate);
        }
        // b.账户利率浮动百分比不等于0：执行利率 = 产品利率 * (1 + 账户利率浮动百分比)
        if (isNonZero(acctPercentRate)) {
            return nullToZero(productRate).multiply(BigDecimal.ONE.add(acctPercentRate));
        }
        // c.账户固定利率不等于0：执行利率 = 账户固定利率
        if (isNonZero(acctFixedRate)) {
            return acctFixedRate;
        }
        // 三个条件均不满足，执行利率未赋值
        return null;
    }

    /** 条件判定：非空且数值不等于0 */
    private static boolean isNonZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) != 0;
    }

    /** 为空视同0（仅用于a、b分支计算中的产品利率） */
    private static BigDecimal nullToZero(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }
}

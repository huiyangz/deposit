package com.dcits.depsit.rule;

import java.math.BigDecimal;

/**
 * BR004 计算账户利率。
 *
 * <p>根据产品利率与账户级利率浮动要素，按 a → b → c → d 的优先级唯一确定执行利率：
 * <ul>
 *     <li>a：{@code acctSpreadRate} 不等于 0 时，{@code realRate} = {@code prodRate} + {@code acctSpreadRate}；</li>
 *     <li>b：{@code acctSpreadRate} 为 0 或为空，且 {@code acctPercentRate} 不等于 0 时，
 *     {@code realRate} = {@code prodRate} × (1 + {@code acctPercentRate})；</li>
 *     <li>c：前两项均为 0 或为空，且 {@code acctFixedRate} 不等于 0 时，{@code realRate} = {@code acctFixedRate}；</li>
 *     <li>d：三个浮动要素均为 0 或为空时，{@code realRate} = {@code prodRate}。</li>
 * </ul>
 * 三个浮动要素均非必填，空与 0 在分支判断中等价；分支互斥，命中首个成立条目即返回，不叠加。
 * {@code acctPercentRate} 以小数比率传入（上浮 10% 记 0.1），直接参与乘积计算。
 */
public class BR004 {

    /**
     * 计算账户执行利率。
     *
     * @param acctSpreadRate  账户利率浮动百分点，可为空
     * @param acctPercentRate 账户利率浮动百分比（小数比率），可为空
     * @param acctFixedRate   账户固定利率，可为空
     * @param prodRate        产品利率
     * @return 执行利率 realRate
     */
    public static BigDecimal execute(BigDecimal acctSpreadRate,
                                     BigDecimal acctPercentRate,
                                     BigDecimal acctFixedRate,
                                     BigDecimal prodRate) {
        if (notZero(acctSpreadRate)) {
            return prodRate.add(acctSpreadRate);
        }
        if (notZero(acctPercentRate)) {
            return prodRate.multiply(BigDecimal.ONE.add(acctPercentRate));
        }
        if (notZero(acctFixedRate)) {
            return acctFixedRate;
        }
        return prodRate;
    }

    /**
     * 判断浮动要素是否不等于 0；空值与 0 等价处理。
     */
    private static boolean notZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) != 0;
    }
}

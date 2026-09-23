package com.dcits.deposit.rule;

import java.math.BigDecimal;

/**
 * BR002 计算账户利率
 *
 * 规则类型：计算类。
 *
 * 按 a、b、c 顺序判断条件，首个命中的分支计算并返回执行利率：
 * a. {账户利率浮动百分点}不等于0，[执行利率]={产品利率}+{账户利率浮动百分点}；
 * b. {账户利率浮动百分比}不等于0，[执行利率]={产品利率}*（1+{账户利率浮动百分比}）；
 * c. {账户固定利率}不等于0，[执行利率]={账户固定利率}。
 */
public class BR002 {

    /**
     * 计算账户执行利率。
     *
     * @param acctSpreadRate  账户利率浮动百分点，非必填
     * @param acctPercentRate 账户利率浮动百分比，非必填
     * @param acctFixedRate   账户固定利率，非必填
     * @param productRate     产品利率，必填
     * @return realRate 执行利率
     */
    public static BigDecimal execute(BigDecimal acctSpreadRate, BigDecimal acctPercentRate, BigDecimal acctFixedRate, BigDecimal productRate) {
        //FIXME 规则:计算账户利率 - 问题大类:业务 - 问题分类:空值处理策略缺失 - 严重程度:错误 - 问题描述:三个浮动字段非必填，但字段为 null 时"不等于0"条件的判断策略 SPEC 未定义（测试用例阻断缺口 G2），不得自行按"null 视同 0"处理 - 修改建议（参考）：需求方确认 null 输入的分支判断策略后补充实现
        if (acctSpreadRate == null || acctPercentRate == null || acctFixedRate == null) {
            return null;
        }
        // a. 浮动百分点不等于0：执行利率 = 产品利率 + 浮动百分点
        if (acctSpreadRate.compareTo(BigDecimal.ZERO) != 0) {
            return productRate.add(acctSpreadRate);
        }
        // b. 浮动百分比不等于0：执行利率 = 产品利率 ×（1 + 浮动百分比）
        if (acctPercentRate.compareTo(BigDecimal.ZERO) != 0) {
            return productRate.multiply(BigDecimal.ONE.add(acctPercentRate));
        }
        // c. 固定利率不等于0：执行利率 = 固定利率
        if (acctFixedRate.compareTo(BigDecimal.ZERO) != 0) {
            return acctFixedRate;
        }
        //FIXME 规则:计算账户利率 - 问题大类:业务 - 问题分类:缺少默认分支定义 - 严重程度:错误 - 问题描述:三个浮动字段同时为0时 a/b/c 条件均不命中，执行利率的返回值 SPEC 未定义（测试用例阻断缺口 G1），不得自行返回产品利率等默认值 - 修改建议（参考）：需求方确认全0组合的执行利率后补充实现
        return null;
    }
}

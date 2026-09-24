package com.dcits.deposit.rule;

import java.math.BigDecimal;

/**
 * BR002 计算账户利率
 *
 * <p>规则类型：计算类。按 a＞b＞c 优先顺序计算执行利率：
 * a. 若账户利率浮动百分点不等于 0，执行利率 = 产品利率 + 账户利率浮动百分点；
 * b. 否则若账户利率浮动百分比不等于 0，执行利率 = 产品利率 ×（1 + 账户利率浮动百分比）；
 * c. 否则若账户固定利率不等于 0，执行利率 = 账户固定利率；
 * 否则（三者均为空或等于 0，空值视同 0）执行利率 = 产品利率。
 * 执行利率按公式计算结果精确返回，不进行位数规整与舍入。</p>
 */
public class BR002 {

	/**
	 * 计算账户执行利率。
	 *
	 * @param acctSpreadRate  账户利率浮动百分点，非必填，空值视同 0
	 * @param acctPercentRate 账户利率浮动百分比，非必填，空值视同 0
	 * @param acctFixedRate   账户固定利率，非必填，空值视同 0
	 * @param productRate     产品利率，必填
	 * @return realRate 执行利率
	 */
	public static BigDecimal execute(BigDecimal acctSpreadRate, BigDecimal acctPercentRate,
			BigDecimal acctFixedRate, BigDecimal productRate) {
		// 分支a：浮动百分点不等于0（按数值比较，0.00 视同 0），执行利率=产品利率+浮动百分点
		if (isNonZero(acctSpreadRate)) {
			return productRate.add(acctSpreadRate);
		}
		// 分支b：浮动百分比不等于0，执行利率=产品利率×(1+浮动百分比)
		if (isNonZero(acctPercentRate)) {
			return productRate.multiply(BigDecimal.ONE.add(acctPercentRate));
		}
		// 分支c：固定利率不等于0，执行利率=固定利率
		if (isNonZero(acctFixedRate)) {
			return acctFixedRate;
		}
		// 默认分支：三者均为空或等于0，执行利率=产品利率
		return productRate;
	}

	/**
	 * 判断利率值非空且数值上不等于 0（空值视同 0，不触发分支）。
	 */
	private static boolean isNonZero(BigDecimal value) {
		return value != null && value.compareTo(BigDecimal.ZERO) != 0;
	}
}

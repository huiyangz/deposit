package com.dcits.deposit.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BR002 计算账户利率
 *
 * <p>规则类型：计算类</p>
 *
 * <p>按 a、b、c、d 顺序取先命中的分支计算执行利率：</p>
 * <ol type="a">
 *   <li>账户利率浮动百分点不等于0：执行利率 = 产品利率 + 账户利率浮动百分点</li>
 *   <li>账户利率浮动百分比不等于0：执行利率 = 产品利率 ×（1 + 账户利率浮动百分比）</li>
 *   <li>账户固定利率不等于0：执行利率 = 账户固定利率</li>
 *   <li>以上条件均不满足：执行利率 = 产品利率</li>
 * </ol>
 *
 * <p>三个浮动字段空值视同0；结果保留小数点后6位，四舍五入。</p>
 */
public class BR002 {

	/** 执行利率保留小数位数 */
	private static final int REAL_RATE_SCALE = 6;

    /**
     * 计算账户执行利率
     *
	 * @param acctSpreadRate  账户利率浮动百分点，空值视同0
	 * @param acctPercentRate 账户利率浮动百分比，空值视同0
	 * @param acctFixedRate   账户固定利率，空值视同0
	 * @param productRate     产品利率，必填
	 * @return realRate 执行利率，保留小数点后6位，四舍五入
	 */
	public static BigDecimal execute(BigDecimal acctSpreadRate, BigDecimal acctPercentRate, BigDecimal acctFixedRate,
			BigDecimal productRate) {
		BigDecimal realRate;
		if (orZero(acctSpreadRate).compareTo(BigDecimal.ZERO) != 0) {
			// 分支a：产品利率 + 账户利率浮动百分点
			realRate = productRate.add(acctSpreadRate);
		} else if (orZero(acctPercentRate).compareTo(BigDecimal.ZERO) != 0) {
			// 分支b：产品利率 ×（1 + 账户利率浮动百分比）
			realRate = productRate.multiply(BigDecimal.ONE.add(acctPercentRate));
		} else if (orZero(acctFixedRate).compareTo(BigDecimal.ZERO) != 0) {
			// 分支c：账户固定利率
			realRate = acctFixedRate;
		} else {
			// 分支d：产品利率
			realRate = productRate;
		}
		return realRate.setScale(REAL_RATE_SCALE, RoundingMode.HALF_UP);
	}

	/**
	 * 空值视同0
	 */
	private static BigDecimal orZero(BigDecimal value) {
		return value == null ? BigDecimal.ZERO : value;
	}
}

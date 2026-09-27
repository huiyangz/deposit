package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;

/**
 * ST049 检查账户执行利率 步骤实现
 *
 * 步骤描述：
 * 1.获取产品的利率信息：根据{产品编号}访问业务组件《产品管理》的业务功能《查询产品利率信息》，
 *   获取$产品利率$、$最大执行利率$、$最小执行利率$
 * 2.检查账户执行利率：若[最大执行利率]或[最小执行利率]为空（未查询到产品利率信息），
 *   或者[执行利率]大于[最大执行利率]，或者小于[最小执行利率]，则返回错误码“ER0033”，
 *   否则继续执行。
 *
 * 输入BO的minRate/maxRate为非必填槽位，检查界限取值来自子步骤1的外部响应；
 * $产品利率$获取后在本步骤检查条件与输出中均无使用。
 */
@Service
public class ST049Pbc implements IST049 {

	/** 错误码：账户执行利率检查不通过 */
	private static final String ER0033 = "ER0033";

	/** 《查询产品利率信息》响应Map键：最小执行利率 */
	private static final String KEY_MIN_EXEC_RATE = "minExecRate";
	/** 《查询产品利率信息》响应Map键：最大执行利率 */
	private static final String KEY_MAX_EXEC_RATE = "maxExecRate";

	private final ExternalTaskClient externalTaskClient;

	public ST049Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST049OutputBO execute(ST049InputBO input) {
		ST049OutputBO output = new ST049OutputBO();

		// 子步骤1 获取产品的利率信息：根据{产品编号}访问《产品管理》《查询产品利率信息》，
		// 获取$产品利率$（响应键prodIntRate，本步骤无下游使用）、$最大执行利率$、$最小执行利率$
		Map<String, Object> prodIntInfo = externalTaskClient.queryProductInterestRate(input.getProdNo());
		BigDecimal maxRate = toBigDecimal(prodIntInfo.get(KEY_MAX_EXEC_RATE));
		BigDecimal minRate = toBigDecimal(prodIntInfo.get(KEY_MIN_EXEC_RATE));

		// 子步骤2 检查账户执行利率：[最大执行利率]或[最小执行利率]为空（未查询到产品利率信息），
		// 或[执行利率]大于[最大执行利率]，或小于[最小执行利率]，返回错误码ER0033，否则继续执行
		if (maxRate == null || minRate == null
				|| input.getRealRate().compareTo(maxRate) > 0
				|| input.getRealRate().compareTo(minRate) < 0) {
			output.setSucceed(false);
			output.setErrorCode(ER0033);
			output.setErrorMessage(ER0033 + "::账户执行利率检查不通过");
			return output;
		}

		// 检查通过，原样输出{执行利率}
		output.setRealRate(input.getRealRate());
		output.setSucceed(true);
		return output;
	}

	/**
	 * 将《查询产品利率信息》响应中的利率值转换为BigDecimal：客户端契约以字符串承载精确小数，
	 * 值为null（响应缺失该键）时保持null，对应“未查询到产品利率信息”。
	 */
	private BigDecimal toBigDecimal(Object value) {
		return value == null ? null : new BigDecimal((String) value);
	}
}

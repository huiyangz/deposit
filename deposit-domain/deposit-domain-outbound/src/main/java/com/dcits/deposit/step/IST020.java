package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查交易金额 步骤接口
 *
 * 检查{交易金额}是否大于 0：大于 0 则检查结果为“通过”，小于等于 0 则返回
 * 错误码 ER0050。本步骤为纯输入检查，不涉及本地数据库读写，无事务要求。
 */
public interface IST020 {

	/**
	 * 检查交易金额。
	 *
	 * @param input 输入BO，tranAmt 为必填交易金额
	 * @return 检查结果：通过时 succeed=true；交易金额小于等于 0 时
	 *         succeed=false，errorCode=ER0050
	 */
	ST020OutputBO execute(ST020InputBO input);
}

package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;

/**
 * ST006 检查存入交易类型 步骤接口
 *
 * 活期现金存入时检查{交易类型}是否等于“现金存入”：相等则检查结果为“通过”，
 * 不相等则返回错误码 ER0049。本步骤为纯输入检查，不涉及本地数据库读写，
 * 无事务要求。
 */
public interface IST006 {

	/**
	 * 检查存入交易类型。
	 *
	 * @param input 输入BO，tranType 为必填交易类型
	 * @return 检查结果：通过时 succeed=true；交易类型不等于“现金存入”时
	 *         succeed=false，errorCode=ER0049
	 */
	ST006OutputBO execute(ST006InputBO input);
}

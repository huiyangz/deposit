package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST003InputBO;
import com.dcits.deposit.facade.bo.ST003OutputBO;

/**
 * ST003 检查账户类型 步骤接口
 *
 * 按{账号}查询【对公存款账户主表（RB_BUS_ACCT）】获取存款账户类型：
 * [账户类型]不等于“T-定期账户”或“A-AIO账户”时检查结果为“通过”，
 * 否则返回错误码 ER0052。本步骤仅查询 RB_BUS_ACCT，不涉及数据库写入，
 * 无事务要求。
 */
public interface IST003 {

	/**
	 * 检查账户类型。
	 *
	 * @param input 输入BO，baseAcctNo 为必填账号
	 * @return 检查结果：通过时 succeed=true 且 rbAcctType 为查询到的存款账户类型；
	 *         账户类型为“T-定期账户”或“A-AIO账户”时 succeed=false，errorCode=ER0052
	 */
	ST003OutputBO execute(ST003InputBO input);
}

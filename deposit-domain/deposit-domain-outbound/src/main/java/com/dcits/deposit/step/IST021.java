package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;

/**
 * ST021 检查存入账户账户状态 步骤接口
 *
 * 只读查询步骤，无本地数据库写入，无事务要求。
 */
public interface IST021 {

	/**
	 * 检查存入账户账户状态。
	 *
	 * @param input 输入BO，账号必填
	 * @return 输出BO：检查通过时 succeed=true 并回写账户状态；
	 *         账户状态为 C-关闭/S-久悬/O-转营业外 时 succeed=false、errorCode=ER0046；
	 *         未查到账户记录时 succeed=false（错误码待业务补充确认）
	 */
	ST021OutputBO execute(ST021InputBO input);
}

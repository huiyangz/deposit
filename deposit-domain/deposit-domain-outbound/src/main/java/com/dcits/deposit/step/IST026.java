package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;

/** ST026 设置账户状态 步骤接口 */
public interface IST026 {

	/**
	 * 设置账户状态：根据{客户号}查询【客户信息】获取境内境外标识与客户细分类型，
	 * 按客户细分类型确定企业标志，执行规则《根据核准类型设置账户状态》获取账户状态；
	 * 账户状态为空值（null）时返回错误码 ER0063，否则赋值账户状态。
	 * 本步骤只读查询【客户信息】（客户副本表），不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 设置账户状态输出BO
	 */
	ST026OutputBO execute(ST026InputBO input);
}

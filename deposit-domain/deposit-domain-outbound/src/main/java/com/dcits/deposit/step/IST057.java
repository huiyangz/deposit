package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;

/** ST057 检查利息资本化标志 步骤接口 */
public interface IST057 {

	/**
	 * 检查利息资本化标志：{利息资本化标志}等于"N"时继续检查利息入账结算账户存在性，
	 * 上送的结算账户数组中存在{结算账户类型}为"INT"（利息入账账户）的账户时返回检查结果"通过"，
	 * 不存在时返回错误码 ER0034；{利息资本化标志}不等于"N"时直接返回检查结果"通过"。
	 * 本步骤为纯输入逻辑校验，不涉及本地数据库访问，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST057OutputBO execute(ST057InputBO input);
}

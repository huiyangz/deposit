package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;

/** ST035 检查利率浮动类型 步骤接口 */
public interface IST035 {

	/**
	 * 检查利率浮动类型：校验{账户利率浮动百分点}、{账户利率浮动百分比}、{账户固定利率}
	 * 三者只有一个不为空，通过时返回检查结果"通过"，否则返回错误码 ER0032。
	 * 本步骤为纯输入校验，不涉及本地数据库访问，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST035OutputBO execute(ST035InputBO input);
}

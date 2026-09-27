package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;

/**
 * ST022 检查现金项目编号 步骤接口
 *
 * 检查{现金项目编号}是否为空：为空则返回错误码 ER0056，非空则检查结果为“通过”。
 * 本步骤为纯输入检查，不涉及本地数据库读写，无事务要求。
 */
public interface IST022 {

	/**
	 * 检查现金项目编号。
	 *
	 * @param input 输入BO，tranType 为交易类型，cashItem 为待检查的现金项目编号
	 * @return 检查结果：通过时 succeed=true；{现金项目编号}为空时
	 *         succeed=false，errorCode=ER0056
	 */
	ST022OutputBO execute(ST022InputBO input);
}

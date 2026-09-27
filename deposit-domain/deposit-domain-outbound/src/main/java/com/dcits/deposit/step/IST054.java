package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/** ST054 设置账户执行利率 步骤接口 */
public interface IST054 {

	/**
	 * 设置账户执行利率：赋值账户$执行利率$为[执行利率]。
	 * 本步骤为纯赋值，不涉及本地数据库读写，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 设置账户执行利率输出BO
	 */
	ST054OutputBO execute(ST054InputBO input);
}

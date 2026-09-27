package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;

/**
 * ST052 检查支取方式 步骤接口
 */
public interface IST052 {

	/**
	 * 检查支取方式是否在产品配置范围内，并检查非代办支取密码。
	 * 本步骤只读，不写本地数据库，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 输出BO，检查通过时 succeed=true 且 checkResult=“通过”
	 */
	ST052OutputBO execute(ST052InputBO input);
}

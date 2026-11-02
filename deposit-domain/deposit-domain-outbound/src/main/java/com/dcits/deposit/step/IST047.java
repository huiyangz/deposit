package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;

/** ST047 检查客户是否存在限制 步骤接口 */
public interface IST047 {

	/** 依据上送客户号查询客户限制表获取限制状态为 A 的客户限制信息并返回 */
	ST047OutputBO execute(ST047InputBO input);
}

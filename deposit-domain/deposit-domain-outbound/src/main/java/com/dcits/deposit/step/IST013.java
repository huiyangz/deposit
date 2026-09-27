package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;

/** ST013 检查客户限制 步骤接口 */
public interface IST013 {

	/**
	 * 检查客户限制：按{客户号}调用检查限制组件《检查客户限制》步骤《检查客户是否存在限制》获取[客户限制信息]；
	 * [客户限制信息]等于空时返回检查结果"通过"（succeed=true 且输出字段均为空），
	 * 否则将限制状态、限制编号、账户限制类型映射至输出字段返回，客户是否存在限制由调用方依据输出字段判断。
	 * 本步骤只做跨组件查询，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST013OutputBO execute(ST013InputBO input);
}

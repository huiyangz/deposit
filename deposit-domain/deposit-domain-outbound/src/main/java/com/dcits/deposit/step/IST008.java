package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;

/**
 * ST008 检查客户类型 步骤接口
 *
 * 根据{客户号}查询【客户信息】获取客户类型，若[客户类型]不为“公司”则返回
 * 错误码 ER0042，否则返回检查结果为“通过”。本步骤为只读查询，不涉及本地
 * 数据库写入，无事务要求。
 */
public interface IST008 {

	/**
	 * 检查客户类型。
	 *
	 * @param input 输入BO，clientNo 为必填客户号
	 * @return 检查结果：客户类型为“公司”时 succeed=true；不为“公司”（含客户号
	 *         无对应记录）时 succeed=false，errorCode=ER0042
	 */
	ST008OutputBO execute(ST008InputBO input);
}

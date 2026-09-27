package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;

/**
 * ST010 检查账户存在性 步骤接口
 *
 * 根据{账号}查询【账户信息】（对公存款账户主表 RB_BUS_ACCT）并检查账户存在性：
 * [账户信息]存在则检查结果为“通过”并返回账号，不存在则返回错误码 ER0048。
 * 本步骤仅实体查询、无数据库写入，无事务要求。
 */
public interface IST010 {

	/**
	 * 检查账户存在性。
	 *
	 * @param input 输入BO，baseAcctNo 为必填账号
	 * @return 检查结果：账户存在时 succeed=true 且 baseAcctNo 取自查询记录；
	 *         账户不存在时 succeed=false，errorCode=ER0048
	 */
	ST010OutputBO execute(ST010InputBO input);
}

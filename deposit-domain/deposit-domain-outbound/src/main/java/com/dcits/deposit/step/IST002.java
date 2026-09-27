package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;

/**
 * ST002 检查交易币种 步骤接口
 *
 * 根据{账号}查询【账户信息】获取账户币种，若[账户币种]不等于{交易币种}返回错误码
 * ER0051，相等则检查结果为“通过”，业务输出账户币种。
 * 本步骤只读查询【对公存款账户主表】（RB_BUS_ACCT），不涉及本地数据库写入，
 * 无事务要求。
 */
public interface IST002 {

	/**
	 * 检查交易币种。
	 *
	 * @param input 输入BO，baseAcctNo 为必填账号，tranCcy 为必填交易币种
	 * @return 检查结果输出BO：通过时 succeed=true 且 acctCcy 为查询到的账户币种；
	 *         账户币种不等于交易币种时 succeed=false，errorCode=ER0051
	 */
	ST002OutputBO execute(ST002InputBO input);
}

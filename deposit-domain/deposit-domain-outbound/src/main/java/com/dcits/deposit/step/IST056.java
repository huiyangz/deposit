package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;

/**
 * ST056 检查账户用途 步骤接口
 *
 * 仅基于输入字段完成账户用途检查，不涉及本地数据库读写，无本地事务要求。
 */
public interface IST056 {

	/**
	 * 检查账户用途。
	 *
	 * 资本项下人民币账户先校验核准件编号与账户属性（为空分别返回 ER0012、ER0013），
	 * 再按账户属性分发：基本/一般存款账户校验用途（非空且不为"无特殊用途"返回 ER0014）、
	 * 验资户校验用途（不在{注册验资,增资验资,无特殊用途}内返回 ER0015）、
	 * 专用存款账户校验用途（不在{预算单位专用,非预算单位专用}内返回 ER0016）；
	 * 检查通过时 succeed=true，无业务输出字段。
	 *
	 * @param input 输入BO（rbBusAcctPurpose 对公存款账户用途、acctCcy 账户币种（必填）、
	 *              apprLetterNo 核准件编号、acctNatureNo 账户属性）
	 * @return 步骤输出BO（成功标志与错误码/错误信息）
	 */
	ST056OutputBO execute(ST056InputBO input);
}

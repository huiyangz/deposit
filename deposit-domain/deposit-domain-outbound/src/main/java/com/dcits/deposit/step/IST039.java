package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;

/**
 * ST039 登记账户计息信息 步骤接口
 *
 * 登记【利息明细信息】（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL）：利息分类固定为
 * "INT-正常利息"，账户内部键值、利率类型、执行利率、税率、利息资本化标志、计息开始日期、
 * 账户利率浮动百分比、账户利率浮动百分点、税率类型取输入。本步骤向本地数据库新增记录，
 * execute 使用 Spring 声明式事务（@Transactional），调用方须在具备事务管理的环境中调用；
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
public interface IST039 {

	/**
	 * 登记账户计息信息。
	 *
	 * @param input 输入BO，12 个字段，其中 clientNo、baseAcctNo、intIndFlag、internalKey、
	 *              intType、taxRate、intCapFlag、calcBeginDate、taxTypeNo、realRate 必填，
	 *              acctPercentRate、acctSpreadRate 非必填
	 * @return 登记结果：succeed=true 且错误字段为 null，internalKey、intType、taxRate、
	 *         intCapFlag、calcBeginDate、acctPercentRate、acctSpreadRate、realRate 为已登记
	 *         进 RB_BUS_ACCT_INT_DETAIL 的业务字段回显
	 */
	ST039OutputBO execute(ST039InputBO input);
}

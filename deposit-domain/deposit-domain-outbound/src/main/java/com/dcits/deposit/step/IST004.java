package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;

/**
 * ST004 登记交易流水 步骤接口
 *
 * 登记【交易流水】（对公存款账户金融交易流水表 RB_BUS_TRAN_JNL），记录交易类型、
 * 币种、借贷标志、交易金额。本步骤向本地数据库新增记录，execute 使用 Spring
 * 声明式事务（@Transactional），调用方须在具备事务管理的环境中调用；
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
public interface IST004 {

	/**
	 * 登记交易流水。
	 *
	 * @param input 输入BO，11 个字段（crDrInd、ccy、tranType、tranAmt、clientNo、
	 *              seqNo、tranDate、internalKey、othInternalKey、createTimestamp、
	 *              lastUpdTimestamp）均为必填
	 * @return 登记结果：succeed=true 且错误字段为 null，crDrInd、ccy、tranType、
	 *         tranAmt 为已登记进 RB_BUS_TRAN_JNL 的业务字段回显
	 */
	ST004OutputBO execute(ST004InputBO input);
}

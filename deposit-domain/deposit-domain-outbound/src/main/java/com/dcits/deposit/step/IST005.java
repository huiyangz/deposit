package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;

/**
 * ST005 登记现金交易明细 步骤接口
 *
 * 登记【现金交易明细】（对公存款账户金融交易流水表 RB_BUS_TRAN_JNL），
 * 记录交易类型、币种、借贷标志、交易金额，输出回显登记值。
 * 本步骤涉及本地数据库新增，execute 在事务中执行，由调用方管理事务边界；
 * SPEC 声明无业务失败场景，失败仅由技术异常传播表达。
 */
public interface IST005 {

	/**
	 * 登记现金交易明细。
	 *
	 * @param input 输入BO，tranType/ccy/crDrInd/tranAmt 为必填登记内容
	 * @return 登记结果：成功时 succeed=true 且错误字段为 null，四个业务字段回显登记值
	 */
	ST005OutputBO execute(ST005InputBO input);
}

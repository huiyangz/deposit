package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 设置贷记交易的借贷标志 步骤接口
 *
 * 为贷记交易赋值[借贷标志]为“C-贷方”。本步骤为纯赋值步骤，不涉及
 * 本地数据库读写，无事务要求，无业务失败场景。
 */
public interface IST017 {

	/**
	 * 设置贷记交易的借贷标志。
	 *
	 * @param input 输入BO，无业务输入字段
	 * @return 输出BO：succeed=true，crDrInd=CrDrInd.C（“C-贷方”）
	 */
	ST017OutputBO execute(ST017InputBO input);
}

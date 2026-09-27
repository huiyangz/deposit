package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST029InputBO;
import com.dcits.deposit.facade.bo.ST029OutputBO;

/**
 * ST029 设置通兑标志 步骤接口
 *
 * 根据产品编号、参数KEY值调用产品管理《查询产品信息》获取产品的通兑标志，
 * 输入通兑标志为空时赋产品的通兑标志，非空时保留输入值。
 *
 * 本步骤仅外部查询与内存赋值，无本地数据库写入，无事务要求；
 * 无业务失败场景，失败仅由技术异常传播表达。
 */
public interface IST029 {

	/**
	 * 设置通兑标志。
	 *
	 * @param input 输入BO（prodNo、attrKey、attrValue 必填，allDraInd 非必填）
	 * @return 输出BO（allDraInd 为本步骤最终的通兑标识）
	 */
	ST029OutputBO execute(ST029InputBO input);
}

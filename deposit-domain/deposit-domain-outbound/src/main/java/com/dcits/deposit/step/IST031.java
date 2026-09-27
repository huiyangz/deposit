package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST031InputBO;
import com.dcits.deposit.facade.bo.ST031OutputBO;

/** ST031 计算账户执行利率 步骤接口 */
public interface IST031 {

	/**
	 * 计算账户执行利率：根据{产品编号}访问业务组件《产品管理》的《查询产品利率信息》获取产品利率
	 * （取返回字段 prodIntRate），再按{账户利率浮动百分点}、{账户利率浮动百分比}、{账户固定利率}、
	 * 产品利率执行规则《计算账户利率》（BR002），返回[执行利率]。
	 * 本步骤无业务失败场景，失败仅由技术异常传播表达；
	 * 无本地数据库访问，不涉及事务。
	 *
	 * @param input 输入BO
	 * @return 执行利率输出BO
	 */
	ST031OutputBO execute(ST031InputBO input);
}

package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;

/** ST047 设置通存标志 步骤接口 */
public interface IST047 {

	/**
	 * 设置通存标志：根据{产品编号}、{参数KEY值}调用业务组件《产品管理》业务功能《查询产品信息》
	 * 获取产品通存标识；{通存标识}为空时输出取产品属性值，非空时沿用输入值。
	 * 本步骤仅跨组件查询与内存赋值，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 通存标识输出BO
	 */
	ST047OutputBO execute(ST047InputBO input);
}

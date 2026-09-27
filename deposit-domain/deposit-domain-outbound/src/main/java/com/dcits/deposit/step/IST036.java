package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;

/**
 * ST036 设置允许转久悬标志 步骤接口
 *
 * 根据{产品编号}、{参数KEY值}调用产品管理《查询产品信息》获取产品的[是否允许转久悬]，
 * 再与输入{允许账户转久悬标志}按空值组合规则设置[允许账户转久悬标志]。
 * 本步骤只调用跨组件接口，不涉及本地数据库读写，无事务要求。
 */
public interface IST036 {

	/**
	 * 设置允许转久悬标志。
	 *
	 * @param input 输入BO，prodNo、attrKey 为必填；allowSuspendFlag 非必填
	 * @return 允许账户转久悬标志；本步骤无业务失败场景，succeed=true 时错误字段为 null
	 */
	ST036OutputBO execute(ST036InputBO input);
}

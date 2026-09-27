package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;

/** ST040 检查允许转久悬标志 步骤接口 */
public interface IST040 {

	/**
	 * 检查允许转久悬标志：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的《查询产品信息》
	 * 获取产品的[是否允许转久悬]标志，结合{允许账户转久悬标志}执行规则《检查允许转久悬标志》（BR003），
	 * 执行结果为是时返回检查结果"通过"，否则返回错误码 ER0030。
	 * 本步骤只读校验（跨组件查询 + 规则判断），不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST040OutputBO execute(ST040InputBO input);
}

package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;

/** ST037 检查通兑标志 步骤接口 */
public interface IST037 {

	/**
	 * 检查通兑标志：根据产品编号、参数KEY值调用产品管理《查询产品信息》获取产品通兑标志，
	 * 账户通兑标志非空且产品通兑标志为“N-不允许通兑”而账户通兑标志不为“N-不允许通兑”时
	 * 返回错误码 ER0018；通兑标志为“D-指定机构通兑”且通兑机构编号为空时返回错误码 ER0019；
	 * 按通兑机构编号查询【机构币种信息】获取[机构币种列表]，仅当通兑标志为“分行间通兑”
	 * 或“指定机构间通兑”时检查币种是否在列表范围内，不在返回错误码 ER0020；其余情况检查通过。
	 * 本步骤对【机构币种信息】只读查询，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST037OutputBO execute(ST037InputBO input);
}

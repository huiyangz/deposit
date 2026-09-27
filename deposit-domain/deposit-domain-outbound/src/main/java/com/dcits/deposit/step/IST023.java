package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;

/** ST023 检查机构币种交易权限 步骤接口 */
public interface IST023 {

	/**
	 * 检查机构币种交易权限：根据{交易机构号}查询【机构币种信息】获取[机构币种列表]，
	 * {交易币种}在[机构币种列表]范围内则检查通过并输出命中币种，否则返回错误码 ER0047。
	 * 本步骤只读查询【机构币种信息】，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST023OutputBO execute(ST023InputBO input);
}

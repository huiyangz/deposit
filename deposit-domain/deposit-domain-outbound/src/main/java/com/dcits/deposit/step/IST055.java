package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;

/** ST055 设置账号 步骤接口 */
public interface IST055 {

	/**
	 * 设置账号：{定制账户标志}为"A-全账户定制"时[账号]取输入{账号}，否则按账号生成规则类型"AC"、
	 * {交易机构}、{产品编号}调用基础公共《生成账号》；再按{非居民账户标志}与{境内境外标志}加"NRA"前缀；
	 * 按{开户机构}查询【机构信息】获取自贸区机构标志，非自贸区机构直接返回[账号]，自贸区机构
	 * 按客户信息执行规则《设置自贸区种类》拼接 FTI/FTF/FTE/FTN/FTU 前缀后返回[账号]。
	 * 本步骤只读查询【机构信息】【客户信息】并调用外部生成账号接口，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 设置账号输出BO
	 */
	ST055OutputBO execute(ST055InputBO input);
}

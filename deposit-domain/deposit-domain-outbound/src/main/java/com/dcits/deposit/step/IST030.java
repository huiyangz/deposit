package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;

/** ST030 检查账号 步骤接口 */
public interface IST030 {

	/**
	 * 检查账号：{定制账户标志}为"N-非定制账户"时，已上送{账号}则按$预约状态$="S-预约成功"
	 * 查询【账号预约信息】，[预留账户信息]不为空返回检查结果"通过"，为空返回错误码 ER0025；
	 * 否则{定制账户标志}为"A-全账户定制"且{账号}不等于空时按{账号}查询【账户信息】，
	 * [账户信息]存在返回错误码 ER0026，不存在返回检查结果"通过"。
	 * 本步骤只读查询【账号预约信息】【账户信息】，不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 检查结果输出BO
	 */
	ST030OutputBO execute(ST030InputBO input);
}

package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST132InputBO;
import com.dcits.depsit.facade.bo.ST132OutputBO;

/**
 * ST132 计算账户解限可用余额 —— 步骤接口。
 *
 * <p>源需求「## 步骤描述」：先按 {账号} 查询【账户信息】取得账户内部键值，再按账户内部键值
 * 查询【账户余额信息】取得 $汇总金额$ 与 $透支金额$，赋值 [账户可用余额] = {汇总金额} 加 {透支金额}；
 * 查不到账户或该账户没有余额记录时，返回错误码 ER0048“账户不存在”并结束本步骤。</p>
 *
 * <p><b>事务要求</b>：本步骤只读取数据、不产生任何写操作，调用方无需为步骤本身开启事务。
 * 除上述两类业务失败外的其他失败由技术异常向上传播表达，本步骤不作捕获、转换或重试。</p>
 */
public interface IST132 {

	/**
	 * 执行本步骤。
	 *
	 * @param input 步骤输入，仅承载账号 {@code baseAcctNo}
	 * @return 步骤结果：成功时 {@code succeed=true}、错误字段为空、{@code acctAvailBal}
	 *         为汇总金额与透支金额之和；按账号查不到账户或该账户没有余额记录时
	 *         {@code succeed=false}、{@code errorCode="ER0048"} 且不产出 {@code acctAvailBal}
	 */
	ST132OutputBO execute(ST132InputBO input);
}

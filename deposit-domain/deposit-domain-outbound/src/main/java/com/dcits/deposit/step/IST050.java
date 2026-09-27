package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;

/** ST050 设置账户年检标志 步骤接口 */
public interface IST050 {

	/**
	 * 设置账户年检标志：[开户年]等于[系统年]或活期保证金账户（[账户类型]等于"C"且
	 * [账户属性分类]等于"保证金账户"）时设置并返回年检标志"否"，否则设置并返回年检标志"是"。
	 * 本步骤只读查询【账户属性定义(RB_ACCT_NATURE_DEF)】并调用产品管理《查询产品信息》，
	 * 不涉及本地数据库写入，无事务要求。
	 *
	 * @param input 输入BO
	 * @return 年检标志输出BO
	 */
	ST050OutputBO execute(ST050InputBO input);
}

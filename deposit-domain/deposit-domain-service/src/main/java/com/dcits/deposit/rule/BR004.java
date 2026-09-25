package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.TranBranch;

/**
 * BR004 检查交易机构和基本户开户机构互斥性
 *
 * <p>规则类型：断言类</p>
 *
 * <p>若交易机构号等于账户开立行行号且账户属性为“11002-一般存款账户”，
 * 则执行结果为“不通过”；否则执行结果为“通过”。</p>
 */
public class BR004 {

	/**
	 * 检查交易机构和基本户开户机构互斥性
	 *
	 * @param tranBranch 交易机构号
	 * @param acctNatureNo 账户属性
	 * @param acctBranch 客户基本存款账户的开户行行号
	 * @return 执行结果：true=通过，false=不通过
	 */
	public static boolean execute(TranBranch tranBranch, AcctNatureNo acctNatureNo, TranBranch acctBranch) {
		if (tranBranch == acctBranch && acctNatureNo == AcctNatureNo.VALUE_11002) {
			return false;
		}
		return true;
	}
}

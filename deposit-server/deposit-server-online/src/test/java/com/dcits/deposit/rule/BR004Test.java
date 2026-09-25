package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.TranBranch;

/**
 * BR004 检查交易机构和基本户开户机构互斥性 单元测试
 */
class BR004Test {

	// 场景：交易机构号等于账户开立行行号且账户属性为一般存款账户，命中互斥条件；预期：execute 返回 false（不通过）
	@Test
	void test_01() {
		TranBranch tranBranch = TranBranch.VALUE_351001;
		AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11002;
		TranBranch acctBranch = TranBranch.VALUE_351001;
		assertFalse(BR004.execute(tranBranch, acctNatureNo, acctBranch));
	}

	// 场景：交易机构号等于账户开立行行号，账户属性为基本存款账户（非11002），AND条件之一不成立；预期：execute 返回 true（通过）
	@Test
	void test_02() {
		TranBranch tranBranch = TranBranch.VALUE_351001;
		AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11001;
		TranBranch acctBranch = TranBranch.VALUE_351001;
		assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
	}

	// 场景：交易机构号不等于账户开立行行号，账户属性为一般存款账户，AND条件之一不成立；预期：execute 返回 true（通过）
	@Test
	void test_03() {
		TranBranch tranBranch = TranBranch.VALUE_351001;
		AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11002;
		TranBranch acctBranch = TranBranch.VALUE_351101;
		assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
	}

	// 场景：交易机构号不等于账户开立行行号，账户属性为基本存款账户，两条件均不成立；预期：execute 返回 true（通过）
	@Test
	void test_04() {
		TranBranch tranBranch = TranBranch.VALUE_351001;
		AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11001;
		TranBranch acctBranch = TranBranch.VALUE_351101;
		assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
	}
}

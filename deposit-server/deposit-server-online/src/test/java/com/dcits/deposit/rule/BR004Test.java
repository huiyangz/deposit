package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.TranBranch;
import org.junit.jupiter.api.Test;

/**
 * BR004 检查交易机构和基本户开户机构互斥性 单元测试
 */
class BR004Test {

    // 交易机构号等于账户开立行行号且账户属性为11002-一般存款账户，命中互斥条件，预期返回不通过（false）
    @Test
    void test_01() {
        TranBranch tranBranch = TranBranch.VALUE_351001;
        AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11002;
        TranBranch acctBranch = TranBranch.VALUE_351001;

        assertFalse(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 交易机构号等于账户开立行行号，账户属性为11001-基本存款账户（非11002），AND条件第二子条件不满足，预期返回通过（true）
    @Test
    void test_02() {
        TranBranch tranBranch = TranBranch.VALUE_351001;
        AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11001;
        TranBranch acctBranch = TranBranch.VALUE_351001;

        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 交易机构号不等于账户开立行行号，账户属性为11002-一般存款账户，AND条件第一子条件不满足，预期返回通过（true）
    @Test
    void test_03() {
        TranBranch tranBranch = TranBranch.VALUE_351001;
        AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11002;
        TranBranch acctBranch = TranBranch.VALUE_351002;

        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 交易机构号不等于账户开立行行号，账户属性为11003-临时存款账户（非11002），两个子条件均不满足，预期返回通过（true）
    @Test
    void test_04() {
        TranBranch tranBranch = TranBranch.VALUE_351001;
        AcctNatureNo acctNatureNo = AcctNatureNo.VALUE_11003;
        TranBranch acctBranch = TranBranch.VALUE_351002;

        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }
}

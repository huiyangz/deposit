package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.TranBranch;
import org.junit.jupiter.api.Test;

/**
 * BR004 检查交易机构和基本户开户机构互斥性 单元测试
 */
class BR004Test {

    // 场景：交易机构等于账户开立行行号（351155）且账户属性为一般存款账户（11002），两条件同时成立；预期返回 false（不通过）
    @Test
    void test_01() {
        TranBranch tranBranch = TranBranch.VALUE_351155;
        String acctNatureNo = "11002";
        TranBranch acctBranch = TranBranch.VALUE_351155;
        assertFalse(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 场景：交易机构等于账户开立行行号（351155）但账户属性编号不是 11002，AND 条件仅第一条成立；预期返回 true（通过）
    @Test
    void test_02() {
        TranBranch tranBranch = TranBranch.VALUE_351155;
        String acctNatureNo = "11001";
        TranBranch acctBranch = TranBranch.VALUE_351155;
        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 场景：交易机构（351155）不等于账户开立行行号（351156）且账户属性为一般存款账户（11002），AND 条件仅第二条成立；预期返回 true（通过）
    @Test
    void test_03() {
        TranBranch tranBranch = TranBranch.VALUE_351155;
        String acctNatureNo = "11002";
        TranBranch acctBranch = TranBranch.VALUE_351156;
        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }

    // 场景：交易机构（351155）不等于账户开立行行号（351156）且账户属性编号不是 11002，AND 两条件均不成立；预期返回 true（通过）
    @Test
    void test_04() {
        TranBranch tranBranch = TranBranch.VALUE_351155;
        String acctNatureNo = "11001";
        TranBranch acctBranch = TranBranch.VALUE_351156;
        assertTrue(BR004.execute(tranBranch, acctNatureNo, acctBranch));
    }
}

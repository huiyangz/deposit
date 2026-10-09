package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.TranBranch;

/**
 * BR006 检查交易机构和基本户开户机构互斥性 单元测试。
 *
 * <p>覆盖 Spec 判定真值表第 1–6 行：命中互斥条件（机构相同且账户属性为 11002）返回 false，
 * 其余合法取值组合（账户属性非 11002，或机构不同）返回 true。</p>
 */
class BR006Test {

    // REQ-002-S01：交易机构与基本存款账户开户行行号均为"351155"且账户属性为"11002-一般存款账户"，命中互斥条件，返回 false（不通过）
    @Test
    void test_01() {
        assertFalse(BR006.execute(TranBranch.VALUE_351155, AcctNatureNo.VALUE_11002, TranBranch.VALUE_351155));
    }

    // REQ-002-S02：另一组相等机构编号"352001"且账户属性为"11002"，判定只取决于两个机构输入是否相等，返回 false
    @Test
    void test_02() {
        assertFalse(BR006.execute(TranBranch.VALUE_352001, AcctNatureNo.VALUE_11002, TranBranch.VALUE_352001));
    }

    // REQ-003-S01：机构相同（"351155"）但账户属性为"11001-基本存款账户"，不满足第二判据，返回 true（通过）
    @Test
    void test_03() {
        assertTrue(BR006.execute(TranBranch.VALUE_351155, AcctNatureNo.VALUE_11001, TranBranch.VALUE_351155));
    }

    // REQ-003-S02：机构相同（"351155"）但账户属性为"11003-临时存款账户"，11002 之外的属性码值不触发不通过，返回 true
    @Test
    void test_04() {
        assertTrue(BR006.execute(TranBranch.VALUE_351155, AcctNatureNo.VALUE_11003, TranBranch.VALUE_351155));
    }

    // REQ-004-S01 / REQ-005-S01：账户属性为"11002"但交易机构（"351155"）与开户行行号（"351156"）为不同机构，不满足第一判据，返回 true（通过）
    @Test
    void test_05() {
        assertTrue(BR006.execute(TranBranch.VALUE_351155, AcctNatureNo.VALUE_11002, TranBranch.VALUE_351156));
    }

    // REQ-004-S02：机构不同（"351155" 与 "351156"）且账户属性非一般存款账户（"11001"），两个判定维度均不满足，返回 true
    @Test
    void test_06() {
        assertTrue(BR006.execute(TranBranch.VALUE_351155, AcctNatureNo.VALUE_11001, TranBranch.VALUE_351156));
    }
}

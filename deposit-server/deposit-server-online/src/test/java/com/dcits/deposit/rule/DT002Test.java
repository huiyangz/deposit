package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dcits.deposit.enums.AcctStatus;
import org.junit.jupiter.api.Test;

class DT002Test {

    @Test
    // REQ-001-S01 新建状态允许入账：acctStatus=N，止付/不收不付标志取「是」/「是」，命中规则 a，标志取值不产生影响
    void test_01() {
        assertEquals("允许", DT002.execute(AcctStatus.N, "是", "是"));
    }

    @Test
    // REQ-001-S01 新建状态允许入账（未提供变体）：两个标志均为 null，仍命中规则 a
    void test_02() {
        assertEquals("允许", DT002.execute(AcctStatus.N, null, null));
    }

    @Test
    // REQ-001-S02 新建且两标志为是/否允许入账：acctStatus=N，止付=是，不收不付=否，命中规则 b，与 a 结论一致
    void test_03() {
        assertEquals("允许", DT002.execute(AcctStatus.N, "是", "否"));
    }

    @Test
    // REQ-002-S01 待激活且两标志为是/否允许入账：acctStatus=H，止付=是，不收不付=否，命中规则 c
    void test_04() {
        assertEquals("允许", DT002.execute(AcctStatus.H, "是", "否"));
    }

    @Test
    // REQ-003-S01 活动且两标志为否/否允许入账：acctStatus=A，止付=否，不收不付=否，命中规则 d
    void test_05() {
        assertEquals("允许", DT002.execute(AcctStatus.A, "否", "否"));
    }

    @Test
    // REQ-004-S01 久悬且不收不付标志为否不允许入账：acctStatus=S，不收不付=否，止付=是（样本值，止付不关心），命中规则 e
    void test_06() {
        assertEquals("不允许", DT002.execute(AcctStatus.S, "是", "否"));
    }

    @Test
    // REQ-005-S01 转营业外且不收不付标志为否不允许入账：acctStatus=O，不收不付=否，止付=是（样本值，止付不关心），命中规则 f
    void test_07() {
        assertEquals("不允许", DT002.execute(AcctStatus.O, "是", "否"));
    }

    @Test
    // REQ-006-S01 待激活但标志组合不满足条件：acctStatus=H，两标志均为「否」，不满足规则 c，落入规则 g
    void test_08() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "否", "否"));
    }

    @Test
    // REQ-006-S01 待激活但任一标志未提供：acctStatus=H，止付未提供（null），不收不付=否，不满足规则 c，落入规则 g
    void test_09() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, null, "否"));
    }

    @Test
    // REQ-006-S02 活动但止付标志为「是」：acctStatus=A，止付=是，不收不付=否，不满足规则 d，落入规则 g
    void test_10() {
        assertEquals("不允许", DT002.execute(AcctStatus.A, "是", "否"));
    }

    @Test
    // REQ-006-S02 活动但不收不付标志为「是」：acctStatus=A，止付=否，不收不付=是，不满足规则 d，落入规则 g
    void test_11() {
        assertEquals("不允许", DT002.execute(AcctStatus.A, "否", "是"));
    }

    @Test
    // REQ-006-S03 久悬且不收不付标志为「是」：acctStatus=S，不收不付=是，止付=是（样本值，止付不关心），不满足规则 e，落入规则 g
    void test_12() {
        assertEquals("不允许", DT002.execute(AcctStatus.S, "是", "是"));
    }

    @Test
    // REQ-006-S03 久悬且不收不付标志未提供：acctStatus=S，不收不付未提供（null），止付=否（样本值，止付不关心），不满足规则 e，落入规则 g
    void test_13() {
        assertEquals("不允许", DT002.execute(AcctStatus.S, "否", null));
    }

    @Test
    // REQ-006-S04 转营业外且不收不付标志为「是」：acctStatus=O，不收不付=是，止付=是（样本值，止付不关心），不满足规则 f，落入规则 g
    void test_14() {
        assertEquals("不允许", DT002.execute(AcctStatus.O, "是", "是"));
    }

    @Test
    // REQ-006-S04 转营业外且不收不付标志未提供：acctStatus=O，不收不付未提供（null），止付=否（样本值，止付不关心），不满足规则 f，落入规则 g
    void test_15() {
        assertEquals("不允许", DT002.execute(AcctStatus.O, "否", null));
    }

    @Test
    // REQ-006-S05 未覆盖状态「关闭」不允许入账：acctStatus=C，止付=是，不收不付=否，落入规则 g
    void test_16() {
        assertEquals("不允许", DT002.execute(AcctStatus.C, "是", "否"));
    }

    @Test
    // REQ-006-S05 未覆盖状态「睡眠」不允许入账：acctStatus=D，止付=否，不收不付=是，落入规则 g
    void test_17() {
        assertEquals("不允许", DT002.execute(AcctStatus.D, "否", "是"));
    }

    @Test
    // REQ-006-S05 未覆盖状态「预开户」不允许入账：acctStatus=I，两标志均未提供（null），落入规则 g
    void test_18() {
        assertEquals("不允许", DT002.execute(AcctStatus.I, null, null));
    }

    @Test
    // REQ-006-S05 未覆盖状态「逾期」不允许入账：acctStatus=P，止付=是，不收不付=是，落入规则 g
    void test_19() {
        assertEquals("不允许", DT002.execute(AcctStatus.P, "是", "是"));
    }

    @Test
    // REQ-006-S05 未覆盖状态「预销户」不允许入账：acctStatus=R，止付=否，不收不付=否，落入规则 g
    void test_20() {
        assertEquals("不允许", DT002.execute(AcctStatus.R, "否", "否"));
    }

    @Test
    // REQ-006-S05 未覆盖状态「手工解除」不允许入账：acctStatus=U，止付未提供（null），不收不付=是，落入规则 g
    void test_21() {
        assertEquals("不允许", DT002.execute(AcctStatus.U, null, "是"));
    }

    @Test
    // REQ-006-S01 待激活但不收不付标志为「是」：acctStatus=H，止付=是，不收不付=是，不满足规则 c 的「不收不付=否」，落入规则 g
    void test_22() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "是", "是"));
    }

    @Test
    // REQ-006-S01 待激活但不收不付标志未提供：acctStatus=H，止付=是，不收不付未提供（null），不满足规则 c 的「不收不付=否」，落入规则 g
    void test_23() {
        assertEquals("不允许", DT002.execute(AcctStatus.H, "是", null));
    }
}

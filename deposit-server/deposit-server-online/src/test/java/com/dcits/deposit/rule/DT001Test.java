package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctStatus;

/**
 * DT001 检查账户是否能够出账 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001、REQ-003~REQ-007 已确认判定场景（测试用例
 * DT001-TC001~TC006）。规则 a/b 冲突组合（REQ-002）与未覆盖输入无已确认预期，
 * 不作为本套用例断言，见规则实现中 FIXME。</p>
 */
class DT001Test {

    // 场景：REQ-001-S01，账户状态「新建」（N），止付「否」、不收不付「否」，命中规则 a，判定允许出账
    @Test
    void test_01() {
        String result = DT001.execute(AcctStatus.N, "否", "否");
        assertEquals("允许", result);
    }

    // 场景：REQ-003-S01，账户状态「待激活」（H），止付「是」、不收不付「否」，命中规则 c，判定不允许出账
    @Test
    void test_02() {
        String result = DT001.execute(AcctStatus.H, "是", "否");
        assertEquals("不允许", result);
    }

    // 场景：REQ-004-S01，账户状态「活动」（A），止付「否」、不收不付「否」，命中规则 d，判定允许出账
    @Test
    void test_03() {
        String result = DT001.execute(AcctStatus.A, "否", "否");
        assertEquals("允许", result);
    }

    // 场景：REQ-005-S01，账户状态「久悬」（S），不收不付「是」（不约束止付标志，样本取「否」），命中规则 e，判定不允许出账
    @Test
    void test_04() {
        String result = DT001.execute(AcctStatus.S, "否", "是");
        assertEquals("不允许", result);
    }

    // 场景：REQ-006-S01，账户状态「转营业外」（O），不收不付「是」（不约束止付标志，样本取「否」），命中规则 f，判定不允许出账
    @Test
    void test_05() {
        String result = DT001.execute(AcctStatus.O, "否", "是");
        assertEquals("不允许", result);
    }

    // 场景：REQ-007-S01，账户状态「关闭」（C），止付「否」、不收不付「否」，命中规则 g，判定不允许出账
    @Test
    void test_06() {
        String result = DT001.execute(AcctStatus.C, "否", "否");
        assertEquals("不允许", result);
    }
}

package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dcits.deposit.enums.AcctStatus;
import org.junit.jupiter.api.Test;

/**
 * DT001 检查账户是否能够出账 单元测试（决策类规则）。
 *
 * <p>用例来源：`outputs/测试用例.md` DT001-TC001 至 DT001-TC007，覆盖规则描述条目 a–g 的 7 条判定分支。</p>
 *
 * <p>条目 a–g 未列出的合法输入组合（睡眠/预开户/逾期/预销户/手工解除等账户状态，或所列状态下的其他标志组合）
 * 已按正式需求"已接受的需求处理结论"放行，不属于本 Spec 定义范围，不设计用例。</p>
 */
class DT001Test {

    /** 条目 a：新建状态且两个标志均为"否"，返回出账标志"允许"（DT001-TC001，对应 REQ-001-S01）。 */
    @Test
    void test_01() {
        assertEquals("允许", DT001.execute(AcctStatus.N, "否", "否"));
    }

    /** 条目 b：新建状态、止付标志为"是"、不收不付标志为"否"，返回"不允许"（DT001-TC002，对应 REQ-001-S02）。 */
    @Test
    void test_02() {
        assertEquals("不允许", DT001.execute(AcctStatus.N, "是", "否"));
    }

    /** 条目 c：待激活状态、止付标志为"是"、不收不付标志为"否"，返回"不允许"（DT001-TC003，对应 REQ-001-S03）。 */
    @Test
    void test_03() {
        assertEquals("不允许", DT001.execute(AcctStatus.H, "是", "否"));
    }

    /** 条目 d：活动状态且两个标志均为"否"，返回出账标志"允许"（DT001-TC004，对应 REQ-001-S04）。 */
    @Test
    void test_04() {
        assertEquals("允许", DT001.execute(AcctStatus.A, "否", "否"));
    }

    /** 条目 e：久悬状态、不收不付标志为"是"，返回"不允许"（DT001-TC005，对应 REQ-001-S05）。 */
    @Test
    void test_05() {
        assertEquals("不允许", DT001.execute(AcctStatus.S, "否", "是"));
    }

    /** 条目 f：转营业外状态、不收不付标志为"是"，返回"不允许"（DT001-TC006，对应 REQ-001-S06）。 */
    @Test
    void test_06() {
        assertEquals("不允许", DT001.execute(AcctStatus.O, "否", "是"));
    }

    /** 条目 g：关闭状态，返回"不允许"（DT001-TC007，对应 REQ-001-S07）。 */
    @Test
    void test_07() {
        assertEquals("不允许", DT001.execute(AcctStatus.C, "否", "否"));
    }
}

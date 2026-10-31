package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctStatus;

/**
 * DT002 检查账户是否能够入账 单元测试。
 *
 * <p>覆盖本轮已确认用例：REQ-001-S01、REQ-002-S01（规则 c）、REQ-003-S01（规则 e）、REQ-003-S02（规则 f）。
 * 未覆盖事项：规则 d（"正常"状态对应枚举值未确认，TBD-2）、规则 a/b/g（"新建"状态，TBD-1）、
 * 未列状态与组合（TBD-6）、标志空值与非标取值（TBD-4/TBD-5），待业务确认后补充用例。</p>
 */
public class DT002Test {

    /** REQ-001-S01 输入输出契约可用性：待激活 + 止付=是 + 不收不付=否 → 入账标志"允许"，输出仅含入账标志字段（单一 String 输出直接断言返回值） */
    @Test
    public void test_01() {
        String result = DT002.execute(AcctStatus.H, "是", "否");
        assertEquals("允许", result);
    }

    /** REQ-002-S01（规则 c）：待激活 + 止付=是 + 不收不付=否 → 入账标志"允许" */
    @Test
    public void test_02() {
        String result = DT002.execute(AcctStatus.H, "是", "否");
        assertEquals("允许", result);
    }

    /** REQ-003-S01（规则 e）：久悬 + 不收不付=否 → 入账标志"不允许"；止付标志不属规则 e 条件，取样本值"否" */
    @Test
    public void test_03() {
        String result = DT002.execute(AcctStatus.S, "否", "否");
        assertEquals("不允许", result);
    }

    /** REQ-003-S02（规则 f）：转营业外 + 不收不付=否 → 入账标志"不允许"；止付标志不属规则 f 条件，取样本值"否" */
    @Test
    public void test_04() {
        String result = DT002.execute(AcctStatus.O, "否", "否");
        assertEquals("不允许", result);
    }
}

package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** BR003 检查允许转久悬标志 单元测试 */
class BR003Test {

    // 场景：条件 a 命中：允许账户转久悬标志为 Y，是否允许转久悬为 N；预期：execute 返回否（false）
    @Test
    void test_01() {
        assertFalse(BR003.execute("Y", "N"));
    }

    // 场景：条件 a 不成立（第二输入非 N）：标志为 Y，是否允许转久悬为 Y，落入分支 c；预期：execute 返回是（true）
    @Test
    void test_02() {
        assertTrue(BR003.execute("Y", "Y"));
    }

    // 场景：条件 a 不成立（第二输入为 null）：标志为 Y，是否允许转久悬为 null，落入分支 c；预期：execute 返回是（true）
    @Test
    void test_03() {
        assertTrue(BR003.execute("Y", null));
    }

    // 场景：条件 a 不成立（第二输入为空字符串）：标志为 Y，是否允许转久悬为 ""，落入分支 c；预期：execute 返回是（true）
    @Test
    void test_04() {
        assertTrue(BR003.execute("Y", ""));
    }

    // 场景：条件 b 命中（空取 null）：标志为 N，是否允许转久悬为 null；预期：execute 返回否（false）
    @Test
    void test_05() {
        assertFalse(BR003.execute("N", null));
    }

    // 场景：条件 b 命中（空取空字符串）：标志为 N，是否允许转久悬为 ""；预期：execute 返回否（false）
    @Test
    void test_06() {
        assertFalse(BR003.execute("N", ""));
    }

    // 场景：条件 b 不成立（第二输入非空）：标志为 N，是否允许转久悬为 Y，落入分支 c；预期：execute 返回是（true）
    @Test
    void test_07() {
        assertTrue(BR003.execute("N", "Y"));
    }

    // 场景：条件 a、b 均不成立的组合：标志为 N，是否允许转久悬为 N，落入分支 c；预期：execute 返回是（true）
    @Test
    void test_08() {
        assertTrue(BR003.execute("N", "N"));
    }
}

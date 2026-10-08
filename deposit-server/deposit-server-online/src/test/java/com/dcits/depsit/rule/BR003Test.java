package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * BR003 检查允许转久悬标志 单元测试。
 *
 * 期望结果取自正式 Spec 的判定真值表与需求场景，不根据实现反推。
 * 用例覆盖条件 a、条件 b（null 与空字符串两种空值）与条件 c 的各默认取值组合。
 */
class BR003Test {

    // 命中条件 a：允许账户转久悬标志为“是”且是否允许转久悬为“否”，返回否（false）。
    @Test
    void test_01() {
        assertFalse(BR003.execute("Y-是", "N-否"));
    }

    // 条件 c 默认分支：允许账户转久悬标志为“是”且是否允许转久悬为“是”，返回是（true）。
    @Test
    void test_02() {
        assertTrue(BR003.execute("Y-是", "Y-是"));
    }

    // 条件 c 默认分支：允许账户转久悬标志为“是”且是否允许转久悬未提供（null），返回是（true）。
    @Test
    void test_03() {
        assertTrue(BR003.execute("Y-是", null));
    }

    // 条件 c 默认分支：允许账户转久悬标志为“是”且是否允许转久悬为空字符串，返回是（true）。
    @Test
    void test_04() {
        assertTrue(BR003.execute("Y-是", ""));
    }

    // 条件 c 默认分支：允许账户转久悬标志为“否”且是否允许转久悬为“是”，返回是（true）。
    @Test
    void test_05() {
        assertTrue(BR003.execute("N-否", "Y-是"));
    }

    // 条件 c 默认分支：允许账户转久悬标志为“否”且是否允许转久悬为“否”，返回是（true）。
    @Test
    void test_06() {
        assertTrue(BR003.execute("N-否", "N-否"));
    }

    // 命中条件 b：允许账户转久悬标志为“否”且是否允许转久悬未提供（null），返回否（false）。
    @Test
    void test_07() {
        assertFalse(BR003.execute("N-否", null));
    }

    // 命中条件 b：允许账户转久悬标志为“否”且是否允许转久悬为空字符串，返回否（false）。
    @Test
    void test_08() {
        assertFalse(BR003.execute("N-否", ""));
    }

    // 条件 c 默认分支：取值不在条件 a、b 所列取值内（非 "Y-是"、"N-否"，亦非空），返回是（true）。
    @Test
    void test_09() {
        assertTrue(BR003.execute("X", "Y"));
    }
}

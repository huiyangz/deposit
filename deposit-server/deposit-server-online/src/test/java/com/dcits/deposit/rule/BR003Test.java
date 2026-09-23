package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * BR003 检查允许转久悬标志 单元测试
 */
class BR003Test {

    // 场景：账户允许转久悬且产品不允许转久悬（allowSuspendFlag="Y"，productAllowDormantFlag="N"），命中条件 a，预期返回否（false）
    @Test
    void test_01() {
        assertFalse(BR003.execute("Y", "N"));
    }

    // 场景：账户不允许转久悬且产品允许转久悬标志为空（allowSuspendFlag="N"，productAllowDormantFlag=""），命中条件 b，预期返回否（false）
    @Test
    void test_02() {
        assertFalse(BR003.execute("N", ""));
    }

    // 场景：账户允许且产品允许转久悬（allowSuspendFlag="Y"，productAllowDormantFlag="Y"），不命中条件 a、b，按条件 c 预期返回是（true）
    @Test
    void test_03() {
        assertTrue(BR003.execute("Y", "Y"));
    }

    // 场景：账户允许转久悬、产品标志为空（allowSuspendFlag="Y"，productAllowDormantFlag=""），空值不命中条件 a，按条件 c 预期返回是（true）
    @Test
    void test_04() {
        assertTrue(BR003.execute("Y", ""));
    }

    // 场景：账户不允许转久悬、产品不允许转久悬（allowSuspendFlag="N"，productAllowDormantFlag="N"），"N" 不命中条件 b，按条件 c 预期返回是（true）
    @Test
    void test_05() {
        assertTrue(BR003.execute("N", "N"));
    }

    // 场景：账户不允许、产品允许转久悬（allowSuspendFlag="N"，productAllowDormantFlag="Y"），不命中条件 a、b，按条件 c 预期返回是（true）
    @Test
    void test_06() {
        assertTrue(BR003.execute("N", "Y"));
    }
}

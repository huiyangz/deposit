package com.dcits.depsit.rule;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * BR004 计算账户利率 单元测试。
 *
 * <p>针对计算类规则，覆盖条目 a、b、c、d 四个分支、分支优先级互斥、空值与 0 等价、
 * 浮动百分点与浮动百分比的负值边界，以及浮动百分比的小数比率口径。
 * Spec 不约束精度与舍入，断言一律以 {@link BigDecimal#compareTo} 比较数值大小。
 */
class BR004Test {

    // 命中条目 a：acctSpreadRate 不等于 0，按 prodRate + acctSpreadRate 返回，不应用乘积或固定利率口径
    @Test
    void test_01() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0.005"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.035").compareTo(actual));
    }

    // 命中条目 b：acctSpreadRate 为 0 且 acctPercentRate 不等于 0，按 prodRate × (1 + acctPercentRate) 返回
    @Test
    void test_02() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0"), new BigDecimal("0.1"), new BigDecimal("0"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.033").compareTo(actual));
    }

    // 命中条目 c：前两项均为 0 且 acctFixedRate 不等于 0，直接返回固定利率，与 prodRate 取值无关
    @Test
    void test_03() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0.025"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.025").compareTo(actual));
    }

    // 命中条目 d：三个浮动要素均为 0，返回产品利率
    @Test
    void test_04() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.03").compareTo(actual));
    }

    // 优先级与互斥：三种浮动要素同时非 0，仅命中条目 a，不叠加也不改用其他口径
    @Test
    void test_05() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0.005"), new BigDecimal("0.1"), new BigDecimal("0.025"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.035").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.033").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.025").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.038").compareTo(actual));
    }

    // 条目 a 判定条件仅为「不等于 0」：浮动百分点为负值时仍命中条目 a，不落入条目 b
    @Test
    void test_06() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("-0.005"), new BigDecimal("0.1"), new BigDecimal("0"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.025").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.033").compareTo(actual));
    }

    // 空值与 0 等价：acctSpreadRate 为空时按 0 参与判断，落入条目 b 并正常返回
    @Test
    void test_07() {
        BigDecimal actual = BR004.execute(null, new BigDecimal("0.1"), null, new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.033").compareTo(actual));
    }

    // 显式 0 与空等价：acctSpreadRate 为 0.00、acctPercentRate 为空，均满足条目 c 前置条件
    @Test
    void test_08() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0.00"), null, new BigDecimal("0.025"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.025").compareTo(actual));
    }

    // 三个浮动要素均为空：非必填字段全部缺省时命中条目 d，返回产品利率
    @Test
    void test_09() {
        BigDecimal actual = BR004.execute(null, null, null, new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.03").compareTo(actual));
    }

    // 浮动百分比口径：0.1 表示上浮 10%，直接作为小数比率参与乘积，不作百分数换算或按字面百分比数值解释
    @Test
    void test_10() {
        BigDecimal actual = BR004.execute(null, new BigDecimal("0.1"), null, new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.033").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.03003").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.33").compareTo(actual));
    }

    // 条目 b 判定条件「acctPercentRate 不等于 0」的负值边界：负浮动百分比仍命中条目 b，不落入条目 c
    @Test
    void test_11() {
        BigDecimal actual = BR004.execute(
                new BigDecimal("0"), new BigDecimal("-0.1"), new BigDecimal("0.025"), new BigDecimal("0.03"));
        assertEquals(0, new BigDecimal("0.027").compareTo(actual));
        assertNotEquals(0, new BigDecimal("0.025").compareTo(actual));
    }
}

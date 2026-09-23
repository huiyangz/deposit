package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BR002 计算账户利率 单元测试。
 *
 * 覆盖 outputs/测试用例.md 用例 BR002-TC001～TC009：分支 a/b/c 单独命中、
 * 组合命中时按 SPEC 编号顺序 a＞b＞c 优先、负值与零值边界、分支 b 乘法精度。
 * 断言均按 BigDecimal 数值比较（compareTo），避免 scale 表示差异。
 */
class BR002Test {

    // 场景：分支 a 单独命中，浮动百分点 0.50 非 0，其余为 0；预期：执行利率=2.00+0.50=2.50
    @Test
    void test_01() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0.50"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("2.50").compareTo(result));
    }

    // 场景：分支 b 单独命中，浮动百分比 0.10 非 0，其余为 0；预期：执行利率=2.00×(1+0.10)=2.20
    @Test
    void test_02() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0"),
                new BigDecimal("0.10"),
                new BigDecimal("0"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("2.20").compareTo(result));
    }

    // 场景：分支 c 单独命中，固定利率 1.50 非 0，其余为 0；预期：执行利率=1.50，与产品利率无关
    @Test
    void test_03() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("1.50"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("1.50").compareTo(result));
    }

    // 场景：a、b 同时命中，按 SPEC 编号顺序 a 优先；预期：执行利率=2.00+0.30=2.30，不走 b 的 2.40
    @Test
    void test_04() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0.30"),
                new BigDecimal("0.20"),
                new BigDecimal("0"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("2.30").compareTo(result));
    }

    // 场景：b、c 同时命中，按 SPEC 编号顺序 b 优先；预期：执行利率=2.00×1.20=2.40，不走 c 的 1.50
    @Test
    void test_05() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0"),
                new BigDecimal("0.20"),
                new BigDecimal("1.50"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("2.40").compareTo(result));
    }

    // 场景：a、b、c 全部命中，按 SPEC 编号顺序 a 优先；预期：执行利率=2.00+0.30=2.30，不走 b 的 2.40、c 的 1.50
    @Test
    void test_06() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0.30"),
                new BigDecimal("0.20"),
                new BigDecimal("1.50"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("2.30").compareTo(result));
    }

    // 场景：分支 a 负值边界，浮动百分点 -0.25（利率下浮）"不等于0"成立；预期：执行利率=2.00+(-0.25)=1.75
    @Test
    void test_07() {
        BigDecimal result = BR002.execute(
                new BigDecimal("-0.25"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("2.00"));
        assertEquals(0, new BigDecimal("1.75").compareTo(result));
    }

    // 场景：分支 a 下产品利率零值边界，productRate 必填但取 0；预期：执行利率=0+0.50=0.50
    @Test
    void test_08() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0.50"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("0"));
        assertEquals(0, new BigDecimal("0.50").compareTo(result));
    }

    // 场景：分支 b 多位小数精度边界，乘积含 5 位小数须精确无损；预期：执行利率=1.75×1.025=1.79375
    @Test
    void test_09() {
        BigDecimal result = BR002.execute(
                new BigDecimal("0"),
                new BigDecimal("0.025"),
                new BigDecimal("0"),
                new BigDecimal("1.75"));
        assertEquals(0, new BigDecimal("1.79375").compareTo(result));
    }
}

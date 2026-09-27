package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * BR002 计算账户利率 单元测试
 * 用例来源：outputs/测试用例.md（BR002-TC001～TC017）
 * 断言约定：SPEC 未定义执行利率精度与舍入规则，数值断言统一使用 compareTo 比较数值相等，不断言 scale。
 */
class BR002Test {

    // 场景：仅账户利率浮动百分点非0，命中a分支，执行利率=产品利率+浮动百分点；预期 realRate=1.75
    @Test
    void test_01() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.25"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.75")));
    }

    // 场景：仅账户利率浮动百分比非0，命中b分支，执行利率=产品利率*(1+浮动百分比)；预期 realRate=2.20
    @Test
    void test_02() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0.10"), new BigDecimal("0"), new BigDecimal("2.00"));
        assertEquals(0, realRate.compareTo(new BigDecimal("2.20")));
    }

    // 场景：仅账户固定利率非0，命中c分支，执行利率直接取账户固定利率；预期 realRate=3.25
    @Test
    void test_03() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("3.25"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("3.25")));
    }

    // 场景：浮动百分点非0且其余条件字段为null，null视同0参与判定、不触发b、c分支；预期 realRate=2.00
    @Test
    void test_04() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.50"), null, null, new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("2.00")));
    }

    // 场景：a分支触发且productRate为null，productRate在a分支计算中视同0；预期 realRate=0.30
    @Test
    void test_05() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.30"), new BigDecimal("0"), new BigDecimal("0"), null);
        assertEquals(0, realRate.compareTo(new BigDecimal("0.30")));
    }

    // 场景：仅浮动百分比非0、其余输入全部为null，productRate在b分支计算中视同0；预期 realRate=0
    @Test
    void test_06() {
        BigDecimal realRate = BR002.execute(null, new BigDecimal("0.05"), null, null);
        assertEquals(0, realRate.compareTo(new BigDecimal("0")));
    }

    // 场景：四个输入全部为null，均视同0，无分支触发；预期 realRate 未赋值，返回 null
    @Test
    void test_07() {
        BigDecimal realRate = BR002.execute(null, null, null, null);
        assertNull(realRate);
    }

    // 场景：三个条件字段显式传0、productRate非0，无分支触发（productRate不构成触发条件）；预期返回 null
    @Test
    void test_08() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("1.50"));
        assertNull(realRate);
    }

    // 场景：浮动百分点为负数，不等于0同样触发a分支；预期 realRate=1.25
    @Test
    void test_09() {
        BigDecimal realRate = BR002.execute(new BigDecimal("-0.25"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.25")));
    }

    // 场景：浮动百分比为负数，不等于0同样触发b分支，产品利率向下浮动；预期 realRate=1.80
    @Test
    void test_10() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("-0.10"), new BigDecimal("0"), new BigDecimal("2.00"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.80")));
    }

    // 场景：账户固定利率为负数，不等于0同样触发c分支；预期 realRate=-3.25
    @Test
    void test_11() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("-3.25"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("-3.25")));
    }

    // 场景：浮动百分点与浮动百分比同时非0，按描述顺序a优先于b；预期 realRate=1.75（若误走b分支为1.65）
    @Test
    void test_12() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.25"), new BigDecimal("0.10"), new BigDecimal("0"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.75")));
    }

    // 场景：浮动百分比与固定利率同时非0（浮动百分点为0），b优先于c；预期 realRate=1.65（若误走c分支为3.25）
    @Test
    void test_13() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0.10"), new BigDecimal("3.25"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.65")));
    }

    // 场景：浮动百分点与固定利率同时非0，a优先于c；预期 realRate=1.75（若误走c分支为3.25）
    @Test
    void test_14() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.25"), new BigDecimal("0"), new BigDecimal("3.25"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.75")));
    }

    // 场景：三个条件字段全部非0，a优先级最高；预期 realRate=1.75
    @Test
    void test_15() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.25"), new BigDecimal("0.10"), new BigDecimal("3.25"), new BigDecimal("1.50"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.75")));
    }

    // 场景：a分支多位小数精确加法，不触发舍入；预期 realRate=1.580
    @Test
    void test_16() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0.025"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("1.555"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.580")));
    }

    // 场景：b分支多位小数精确乘法，不触发舍入；预期 realRate=1.26485
    @Test
    void test_17() {
        BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0.025"), new BigDecimal("0"), new BigDecimal("1.234"));
        assertEquals(0, realRate.compareTo(new BigDecimal("1.26485")));
    }
}

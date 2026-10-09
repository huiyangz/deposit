package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.facade.bo.ST077InputBO;
import com.dcits.depsit.facade.bo.ST077OutputBO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST077 检查利率浮动类型 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` / `outputs/测试用例.json` 的 ST077-TC001 至 ST077-TC014，
 * 与 Spec REQ-001 至 REQ-005 的 14 个场景一一对应。本步骤无任何依赖调用（Spec「依赖调用」节为「不适用」），
 * 故全部用例不设桩，被测实现保持真实执行。</p>
 *
 * <p>检查结果「通过」在源需求无独立承载字段，按 Spec「输出」表以工程对照断言：{@code isSucceed()} 为 true
 * 且 {@code errorCode}、{@code errorMessage} 为 null；失败路径只对 {@code errorCode} 做逐字等值断言，
 * 不对源需求未定义文案的 {@code errorMessage} 做等值断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST077PbcTest {

    /** 被测步骤实现，无依赖可注入 */
    @InjectMocks
    private ST077Pbc pbc;

    // REQ-001 「若」分支：三个入参中恰有一个不为空
    /** ST077-TC001 REQ-001-S01 仅 acctSpreadRate 不为空（非空个数 1）→ 检查结果为「通过」，不产出 ER0032。 */
    @Test
    void testST077T01() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctSpreadRate(new BigDecimal("1.50"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    /** ST077-TC002 REQ-001-S02 仅 acctPercentRate 不为空（非空个数 1）→ 命中浮动百分比不改变判定，检查通过。 */
    @Test
    void testST077T02() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctPercentRate(new BigDecimal("20.0000"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    /** ST077-TC003 REQ-001-S03 仅 acctFixedRate 不为空（非空个数 1）→ 命中固定利率不改变判定，检查通过。 */
    @Test
    void testST077T03() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("3.2500"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // REQ-002 「否则」分支：三者全未上送（非空个数 0）
    /** ST077-TC004 REQ-002-S01 三个入参全部未上送（非空个数 0）→ 产出错误码 ER0032。 */
    @Test
    void testST077T04() {
        ST077InputBO input = new ST077InputBO();

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }

    // REQ-003 「否则」分支：恰有两个入参不为空
    /** ST077-TC005 REQ-003-S01 acctFixedRate 与 acctPercentRate 同时上送 → 产出错误码 ER0032。 */
    @Test
    void testST077T05() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("3.2500"));
        input.setAcctPercentRate(new BigDecimal("20.0000"));

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }

    /** ST077-TC006 REQ-003-S02 acctFixedRate 与 acctSpreadRate 同时上送 → 产出错误码 ER0032。 */
    @Test
    void testST077T06() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("3.2500"));
        input.setAcctSpreadRate(new BigDecimal("1.50"));

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }

    /** ST077-TC007 REQ-003-S03 acctPercentRate 与 acctSpreadRate 同时上送 → 产出错误码 ER0032。 */
    @Test
    void testST077T07() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctPercentRate(new BigDecimal("20.0000"));
        input.setAcctSpreadRate(new BigDecimal("1.50"));

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }

    /** ST077-TC008 REQ-003-S04 三者全部上送（非空个数 3，「只能上送一个」的上界）→ 产出错误码 ER0032。 */
    @Test
    void testST077T08() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("3.2500"));
        input.setAcctPercentRate(new BigDecimal("20.0000"));
        input.setAcctSpreadRate(new BigDecimal("1.50"));

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }

    // REQ-004 空/非空判据：与数值大小、正负、标度无关
    /** ST077-TC009 REQ-004-S01 取值恰为 0 的入参计为「非空」→ 非空个数 1，检查通过。 */
    @Test
    void testST077T09() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("0"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(0, input.getAcctFixedRate().compareTo(BigDecimal.ZERO));
        assertEquals(0, input.getAcctFixedRate().scale());
    }

    /** ST077-TC010 REQ-004-S02 标度不同的 0.00、0.0 均已上送计为「非空」（个数 2）→ ER0032，且取值与标度未被规整。 */
    @Test
    void testST077T10() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctFixedRate(new BigDecimal("0.00"));
        input.setAcctSpreadRate(new BigDecimal("0.0"));

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
        assertEquals(2, input.getAcctFixedRate().scale());
        assertEquals(0, input.getAcctFixedRate().compareTo(new BigDecimal("0.00")));
        assertEquals(1, input.getAcctSpreadRate().scale());
        assertEquals(0, input.getAcctSpreadRate().compareTo(new BigDecimal("0.0")));
    }

    /** ST077-TC011 REQ-004-S03 取值为负数的入参计为「非空」→ 非空个数 1，检查通过，且不校验正负与范围。 */
    @Test
    void testST077T11() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctSpreadRate(new BigDecimal("-1.50"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(0, input.getAcctSpreadRate().compareTo(new BigDecimal("-1.50")));
        assertEquals(2, input.getAcctSpreadRate().scale());
    }

    // REQ-005 判定结果唯一且互斥
    /** ST077-TC012 REQ-005-S01 通过路径只产出检查结果「通过」（errorCode 为 null），且执行后入参不被修改。 */
    @Test
    void testST077T12() {
        ST077InputBO input = new ST077InputBO();
        input.setAcctPercentRate(new BigDecimal("20.0000"));

        ST077OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, input.getAcctPercentRate().compareTo(new BigDecimal("20.0000")));
        assertNull(input.getAcctFixedRate());
        assertNull(input.getAcctSpreadRate());
    }

    /** ST077-TC013 REQ-005-S02 失败路径只产出错误码 ER0032，三个入参执行后仍为空。 */
    @Test
    void testST077T13() {
        ST077InputBO input = new ST077InputBO();

        ST077OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
        assertNull(input.getAcctFixedRate());
        assertNull(input.getAcctPercentRate());
        assertNull(input.getAcctSpreadRate());
    }

    /** ST077-TC014 REQ-005-S03 判定域内 8 种非空/空组合逐一命中，无未覆盖组合、与枚举顺序无关。 */
    @Test
    void testST077T14() {
        // 组合①：三者全空，非空个数 0 → ER0032
        assertEr0032(new ST077InputBO());

        // 组合②：仅固定利率，非空个数 1 → 通过
        ST077InputBO onlyFixed = new ST077InputBO();
        onlyFixed.setAcctFixedRate(new BigDecimal("3.2500"));
        assertPassed(onlyFixed);

        // 组合③：仅浮动百分比，非空个数 1 → 通过
        ST077InputBO onlyPercent = new ST077InputBO();
        onlyPercent.setAcctPercentRate(new BigDecimal("20.0000"));
        assertPassed(onlyPercent);

        // 组合④：仅浮动百分点，非空个数 1 → 通过
        ST077InputBO onlySpread = new ST077InputBO();
        onlySpread.setAcctSpreadRate(new BigDecimal("1.50"));
        assertPassed(onlySpread);

        // 组合⑤：固定利率＋浮动百分比，非空个数 2 → ER0032
        ST077InputBO fixedAndPercent = new ST077InputBO();
        fixedAndPercent.setAcctFixedRate(new BigDecimal("3.2500"));
        fixedAndPercent.setAcctPercentRate(new BigDecimal("20.0000"));
        assertEr0032(fixedAndPercent);

        // 组合⑥：固定利率＋浮动百分点，非空个数 2 → ER0032
        ST077InputBO fixedAndSpread = new ST077InputBO();
        fixedAndSpread.setAcctFixedRate(new BigDecimal("3.2500"));
        fixedAndSpread.setAcctSpreadRate(new BigDecimal("1.50"));
        assertEr0032(fixedAndSpread);

        // 组合⑦：浮动百分比＋浮动百分点，非空个数 2 → ER0032
        ST077InputBO percentAndSpread = new ST077InputBO();
        percentAndSpread.setAcctPercentRate(new BigDecimal("20.0000"));
        percentAndSpread.setAcctSpreadRate(new BigDecimal("1.50"));
        assertEr0032(percentAndSpread);

        // 组合⑧：三者全部上送，非空个数 3 → ER0032
        ST077InputBO allRates = new ST077InputBO();
        allRates.setAcctFixedRate(new BigDecimal("3.2500"));
        allRates.setAcctPercentRate(new BigDecimal("20.0000"));
        allRates.setAcctSpreadRate(new BigDecimal("1.50"));
        assertEr0032(allRates);
    }

    /** 断言非空个数恰为 1 的路径：检查结果为「通过」，错误字段均为 null。 */
    private void assertPassed(ST077InputBO input) {
        ST077OutputBO result = pbc.execute(input);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    /** 断言非空个数不为 1 的路径：产出错误码 ER0032，不同时产出检查结果「通过」。 */
    private void assertEr0032(ST077InputBO input) {
        ST077OutputBO result = pbc.execute(input);
        assertFalse(result.isSucceed());
        assertEquals("ER0032", result.getErrorCode());
    }
}

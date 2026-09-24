package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * BR002 计算账户利率 单元测试
 *
 * <p>用例来源：outputs/测试用例.md（BR002-TC001 ~ BR002-TC013）。
 * SPEC 要求执行利率按公式计算结果精确返回、不进行位数规整与舍入，但未定义结果标度，
 * 因此统一以 {@code compareTo(...) == 0} 断言数值精确相等，不断言 BigDecimal 的 scale。</p>
 */
class BR002Test {

	// 场景：分支a——浮动百分点非0（正浮点），预期执行利率=产品利率+浮动百分点=1.85
	@Test
	void test_01() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0.35"), null, null, new BigDecimal("1.5"));
		assertEquals(0, new BigDecimal("1.85").compareTo(realRate));
	}

	// 场景：分支a——浮动百分点为负（利率下调），预期执行利率=2.0-0.25=1.75
	@Test
	void test_02() {
		BigDecimal realRate = BR002.execute(new BigDecimal("-0.25"), null, null, new BigDecimal("2.0"));
		assertEquals(0, new BigDecimal("1.75").compareTo(realRate));
	}

	// 场景：分支b——浮动百分比非0，预期执行利率=产品利率×(1+浮动百分比)=2.5×1.1=2.75
	@Test
	void test_03() {
		BigDecimal realRate = BR002.execute(null, new BigDecimal("0.1"), null, new BigDecimal("2.5"));
		assertEquals(0, new BigDecimal("2.75").compareTo(realRate));
	}

	// 场景：分支b——浮动百分比为负且百分点为字面0，预期执行利率=3.0×0.8=2.4
	@Test
	void test_04() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("-0.2"), null, new BigDecimal("3.0"));
		assertEquals(0, new BigDecimal("2.4").compareTo(realRate));
	}

	// 场景：分支c——固定利率非0，预期执行利率=固定利率=4.25，不使用产品利率
	@Test
	void test_05() {
		BigDecimal realRate = BR002.execute(null, null, new BigDecimal("4.25"), new BigDecimal("1.5"));
		assertEquals(0, new BigDecimal("4.25").compareTo(realRate));
	}

	// 场景：默认分支——三个非必填利率均为null（空值视同0），预期执行利率=产品利率=1.75
	@Test
	void test_06() {
		BigDecimal realRate = BR002.execute(null, null, null, new BigDecimal("1.75"));
		assertEquals(0, new BigDecimal("1.75").compareTo(realRate));
	}

	// 场景：默认分支——三个非必填利率均为0，预期执行利率=产品利率=1.75
	@Test
	void test_07() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("1.75"));
		assertEquals(0, new BigDecimal("1.75").compareTo(realRate));
	}

	// 场景：优先级交叠——三者同时非0，分支a优先，预期执行利率=2.0+0.5=2.5（不是2.4也不是3.0）
	@Test
	void test_08() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0.5"), new BigDecimal("0.2"), new BigDecimal("3.0"), new BigDecimal("2.0"));
		assertEquals(0, new BigDecimal("2.5").compareTo(realRate));
	}

	// 场景：优先级交叠——百分点为0、百分比与固定利率非0，分支b优先于c，预期执行利率=2.0×1.2=2.4（不是3.0）
	@Test
	void test_09() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0"), new BigDecimal("0.2"), new BigDecimal("3.0"), new BigDecimal("2.0"));
		assertEquals(0, new BigDecimal("2.4").compareTo(realRate));
	}

	// 场景：零值精度边界——浮动百分点为0.00，数值上等于0不触发分支a，落入分支b，预期执行利率=2.0×1.05=2.1
	@Test
	void test_10() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0.00"), new BigDecimal("0.05"), null, new BigDecimal("2.0"));
		assertEquals(0, new BigDecimal("2.1").compareTo(realRate));
	}

	// 场景：必填字段零值——产品利率为0，默认分支原样返回0
	@Test
	void test_11() {
		BigDecimal realRate = BR002.execute(null, null, null, new BigDecimal("0"));
		assertEquals(0, BigDecimal.ZERO.compareTo(realRate));
	}

	// 场景：精度边界——百分比乘法结果多于两位小数，按公式精确返回不舍入，预期2.666（而非2.67/2.66）
	@Test
	void test_12() {
		BigDecimal realRate = BR002.execute(null, new BigDecimal("0.333"), null, new BigDecimal("2.0"));
		assertEquals(0, new BigDecimal("2.666").compareTo(realRate));
	}

	// 场景：精度边界——百分点加法结果多于两位小数，按公式精确返回不舍入，预期1.1255（而非1.13）
	@Test
	void test_13() {
		BigDecimal realRate = BR002.execute(new BigDecimal("0.125"), null, null, new BigDecimal("1.0005"));
		assertEquals(0, new BigDecimal("1.1255").compareTo(realRate));
	}
}

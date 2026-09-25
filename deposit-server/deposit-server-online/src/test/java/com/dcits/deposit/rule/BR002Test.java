package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BR002 计算账户利率 单元测试
 *
 * <p>依据门禁通过版 SPEC 与《BR002 单元测试用例》，覆盖分支 a/b/c/d、
 * a→b→c 命中顺序、空值视同0、6位四舍五入边界、负值与零值标度等场景。</p>
 */
class BR002Test {

	// 分支a正常计算：浮动百分点不等于0，realRate=1.500000+0.250000=1.750000
	@Test
	void test_01() {
		BigDecimal result = BR002.execute(new BigDecimal("0.250000"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("1.500000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.750000")));
	}

	// 分支b正常计算：浮动百分比不等于0，realRate=2.000000×(1+0.100000)=2.200000
	@Test
	void test_02() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0.100000"), new BigDecimal("0"),
				new BigDecimal("2.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("2.200000")));
	}

	// 分支c正常计算：固定利率不等于0，realRate=3.250000，productRate 不参与
	@Test
	void test_03() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("3.250000"),
				new BigDecimal("1.500000"));
		assertEquals(0, result.compareTo(new BigDecimal("3.250000")));
	}

	// 分支d默认路径：三个浮动字段均为0，realRate=productRate 原值1.235711
	@Test
	void test_04() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("1.235711"));
		assertEquals(0, result.compareTo(new BigDecimal("1.235711")));
	}

	// 优先级a：a、b、c 三条件同时满足，命中分支a，realRate=1.000000+0.500000=1.500000
	@Test
	void test_05() {
		BigDecimal result = BR002.execute(new BigDecimal("0.500000"), new BigDecimal("0.200000"),
				new BigDecimal("4.000000"), new BigDecimal("1.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.500000")));
	}

	// 优先级b：b、c 两条件同时满足（浮动百分点为0），命中分支b，realRate=1.000000×(1+0.500000)=1.500000
	@Test
	void test_06() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0.500000"), new BigDecimal("4.000000"),
				new BigDecimal("1.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.500000")));
	}

	// 空值视同0：三个浮动字段均为 null，全部条件不命中，走分支d，realRate=1.500000
	@Test
	void test_07() {
		BigDecimal result = BR002.execute(null, null, null, new BigDecimal("1.500000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.500000")));
	}

	// 空值视同0：acctSpreadRate 为 null 不命中a，acctPercentRate 非0命中分支b，realRate=3.000000×1.100000=3.300000
	@Test
	void test_08() {
		BigDecimal result = BR002.execute(null, new BigDecimal("0.100000"), null, new BigDecimal("3.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("3.300000")));
	}

	// 空值视同0：浮动百分点、百分比均为 null，acctFixedRate 非0命中分支c，realRate=1.750000
	@Test
	void test_09() {
		BigDecimal result = BR002.execute(null, null, new BigDecimal("1.750000"), new BigDecimal("5.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.750000")));
	}

	// 分支a精度边界：和的第7位小数恰为5，四舍五入进位，realRate=1.111112
	@Test
	void test_10() {
		BigDecimal result = BR002.execute(new BigDecimal("0.0000005"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("1.111111"));
		assertEquals(0, result.compareTo(new BigDecimal("1.111112")));
		assertEquals(1, Integer.signum(result.compareTo(new BigDecimal("1.111111"))));
	}

	// 分支a精度边界：和的第7位小数为4（小于5），四舍五入舍去，realRate=1.111111
	@Test
	void test_11() {
		BigDecimal result = BR002.execute(new BigDecimal("0.0000004"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("1.111111"));
		assertEquals(0, result.compareTo(new BigDecimal("1.111111")));
		assertEquals(-1, Integer.signum(result.compareTo(new BigDecimal("1.111112"))));
	}

	// 分支b精度边界：乘积超出6位小数，四舍五入取6位，realRate=1.234566
	@Test
	void test_12() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0.0000005"), new BigDecimal("0"),
				new BigDecimal("1.234565"));
		assertEquals(0, result.compareTo(new BigDecimal("1.234566")));
	}

	// 分支c精度边界：固定利率第7位小数恰为5，四舍五入进位，realRate=0.123457，productRate 不参与
	@Test
	void test_13() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0.1234565"),
				new BigDecimal("9.999999"));
		assertEquals(0, result.compareTo(new BigDecimal("0.123457")));
	}

	// 分支d精度边界：productRate 透传7位小数，四舍五入到6位，realRate=1.234568
	@Test
	void test_14() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("1.2345678"));
		assertEquals(0, result.compareTo(new BigDecimal("1.234568")));
	}

	// 负值输入：浮动百分点为负且不等于0，命中分支a做减点计算，realRate=2.000000-0.250000=1.750000
	@Test
	void test_15() {
		BigDecimal result = BR002.execute(new BigDecimal("-0.250000"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("2.000000"));
		assertEquals(0, result.compareTo(new BigDecimal("1.750000")));
	}

	// 数值零不同标度：0.000000、0.00、0 均按数值0判断不命中，走分支d，realRate=0.500000
	@Test
	void test_16() {
		BigDecimal result = BR002.execute(new BigDecimal("0.000000"), new BigDecimal("0.00"), new BigDecimal("0"),
				new BigDecimal("0.500000"));
		assertEquals(0, result.compareTo(new BigDecimal("0.500000")));
	}

	// 零值计算：productRate 为0且三个浮动字段为0，分支d返回0
	@Test
	void test_17() {
		BigDecimal result = BR002.execute(new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("0"));
		assertEquals(0, result.compareTo(new BigDecimal("0.000000")));
	}
}

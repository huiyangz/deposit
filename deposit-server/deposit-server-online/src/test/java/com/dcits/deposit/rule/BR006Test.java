package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * BR006 设置自贸区种类 单元测试
 */
public class BR006Test {

	// 决策行a（OR左支）：100-个人 + 对私客户标志=Y + 税收居民标识=1-中国税收居民，预期返回 FTI
	@Test
	public void test_01() {
		String result = BR006.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "N");
		assertEquals("FTI", result);
	}

	// 决策行a（OR右支）：100-个人 + 对私客户标志=Y + 税收居民标识=3-既是中国税收居民又是其他国家（地区）税收居民，预期返回 FTI
	@Test
	public void test_02() {
		String result = BR006.execute("Y", TaxResidentFlag.VALUE_3, ClientType.VALUE_100, "N");
		assertEquals("FTI", result);
	}

	// 决策行b：100-个人 + 税收居民标识=2-非中国税收居民（行a仅被税收居民标识否决），预期返回 FTF
	@Test
	public void test_03() {
		String result = BR006.execute("Y", TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "N");
		assertEquals("FTF", result);
	}

	// 决策行c：200-对公 + 境内境外标志=Y-境内，预期返回 FTE
	@Test
	public void test_04() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y");
		assertEquals("FTE", result);
	}

	// 决策行d：200-对公 + 境内境外标志=N-境外，预期返回 FTN
	@Test
	public void test_05() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "N");
		assertEquals("FTN", result);
	}

	// 决策行e：300-同业 + 境内境外标志=N-境外，预期返回 FTU
	@Test
	public void test_06() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N");
		assertEquals("FTU", result);
	}

	// 决策行f默认：100-个人 但 对私客户标志=N（非对私）且税收居民标识=1，行a、行b均不命中，预期返回 null
	@Test
	public void test_07() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "N");
		assertNull(result);
	}

	// 决策行f默认：300-同业 且 境内境外标志=Y-境内（行e要求境外被否决），无其他匹配行，预期返回 null
	@Test
	public void test_08() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "Y");
		assertNull(result);
	}

	// 决策行f默认：客户类型=600-内部客户（不在决策行a–e的客户类型中），预期返回 null
	@Test
	public void test_09() {
		String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_600, "Y");
		assertNull(result);
	}
}

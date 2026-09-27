package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 设置自贸区种类 单元测试
 *
 * 依据 docs/specs/BR006.md（需求门禁通过版）与 outputs/测试用例.md。
 */
public class BR006Test {

	// 场景：命中SPEC条目a（税收居民标识=1臂）：客户类型100-个人、对私客户标志"Y-个人"、税收居民标识1-中国税收居民，预期返回FTI（3605-区内个人自由贸易账户）
	@Test
	public void test_01() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "N-境外");
		assertEquals(AcctNatureNo.VALUE_3605, result);
	}

	// 场景：命中SPEC条目a（税收居民标识=3臂，覆盖"或者"另一分支）：客户类型100-个人、对私客户标志"Y-个人"、税收居民标识3，预期返回FTI（3605）
	@Test
	public void test_02() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_3, ClientType.VALUE_100, "N-境外");
		assertEquals(AcctNatureNo.VALUE_3605, result);
	}

	// 场景：命中SPEC条目b、条目a因税收居民标识非1/3不命中：客户类型100-个人、税收居民标识2-非中国税收居民，预期返回FTF（3606-区内境外个人自由贸易账户）
	@Test
	public void test_03() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "N-境外");
		assertEquals(AcctNatureNo.VALUE_3606, result);
	}

	// 场景：命中SPEC条目c：客户类型200-对公、境内境外标志"Y-境内"，预期返回FTE（3603-区内机构自由贸易账户）
	@Test
	public void test_04() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y-境内");
		assertEquals(AcctNatureNo.VALUE_3603, result);
	}

	// 场景：命中SPEC条目d：客户类型200-对公、境内境外标志"N-境外"，预期返回FTN（3604-境外机构自由贸易账户），与test_04构成境内/境外互斥
	@Test
	public void test_05() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "N-境外");
		assertEquals(AcctNatureNo.VALUE_3604, result);
	}

	// 场景：命中SPEC条目e：客户类型300-同业、境内境外标志"N-境外"，预期返回FTU（3607-同业机构自由贸易账户），与test_05构成同标志下客户类型互斥
	@Test
	public void test_06() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N-境外");
		assertEquals(AcctNatureNo.VALUE_3607, result);
	}

	// 场景：条目b客户类型条件否定后落入条目c：客户类型200-对公、税收居民标识2-非中国税收居民、境内境外标志"Y-境内"，预期返回FTE（3603）而非FTF
	@Test
	public void test_07() {
		AcctNatureNo result = BR006.execute("Y-个人", TaxResidentFlag.VALUE_2, ClientType.VALUE_200, "Y-境内");
		assertEquals(AcctNatureNo.VALUE_3603, result);
	}
}

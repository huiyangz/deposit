package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * BR003 检查允许转久悬标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（BR003-TC001 ~ BR003-TC008）
 */
public class BR003Test {

	// 分支a：允许账户转久悬标志为Y且是否允许转久悬为N，断言不通过，预期返回否
	@Test
	public void test_01() {
		assertFalse(BR003.execute("Y", "N"));
	}

	// 分支b：允许账户转久悬标志为N且是否允许转久悬为null，断言不通过，预期返回否
	@Test
	public void test_02() {
		assertFalse(BR003.execute("N", null));
	}

	// 分支b：允许账户转久悬标志为N且是否允许转久悬为空字符串，断言不通过，预期返回否
	@Test
	public void test_03() {
		assertFalse(BR003.execute("N", ""));
	}

	// 分支c：允许账户转久悬标志为Y且是否允许转久悬为Y，预期返回是
	@Test
	public void test_04() {
		assertTrue(BR003.execute("Y", "Y"));
	}

	// 分支c：允许账户转久悬标志为N且是否允许转久悬为Y，预期返回是
	@Test
	public void test_05() {
		assertTrue(BR003.execute("N", "Y"));
	}

	// 分支c：允许账户转久悬标志为N且是否允许转久悬为N（非空，不满足分支b的空值条件），预期返回是
	@Test
	public void test_06() {
		assertTrue(BR003.execute("N", "N"));
	}

	// 分支c边界：允许账户转久悬标志为Y且是否允许转久悬为null（空值仅在与N组合时才返回否），预期返回是
	@Test
	public void test_07() {
		assertTrue(BR003.execute("Y", null));
	}

	// 分支c边界：允许账户转久悬标志为Y且是否允许转久悬为空字符串（空值仅在与N组合时才返回否），预期返回是
	@Test
	public void test_08() {
		assertTrue(BR003.execute("Y", ""));
	}
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查交易金额 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST020-TC001 ~ ST020-TC004）
 *
 * 本步骤为纯输入检查，无 BCC、规则或跨组件依赖，无需设桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST020PbcTest {

	@InjectMocks
	private ST020Pbc st020Pbc;

	// 场景：活期现金存入场景下交易金额为正常正数 1000.00，检查通过
	@Test
	public void testST020T01() {
		ST020InputBO input = new ST020InputBO();
		input.setTranAmt(new BigDecimal("1000.00"));

		ST020OutputBO result = st020Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
	}

	// 场景：交易金额为大于 0 的最小金额刻度 0.01，处于边界正侧，检查通过
	@Test
	public void testST020T02() {
		ST020InputBO input = new ST020InputBO();
		input.setTranAmt(new BigDecimal("0.01"));

		ST020OutputBO result = st020Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
	}

	// 场景：交易金额等于 0，命中“小于等于 0”的等号边界，检查不通过并返回错误码 ER0050
	@Test
	public void testST020T03() {
		ST020InputBO input = new ST020InputBO();
		input.setTranAmt(BigDecimal.ZERO);

		ST020OutputBO result = st020Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0050", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0050::"));
	}

	// 场景：交易金额为负数 -0.01，小于 0，检查不通过并返回错误码 ER0050
	@Test
	public void testST020T04() {
		ST020InputBO input = new ST020InputBO();
		input.setTranAmt(new BigDecimal("-0.01"));

		ST020OutputBO result = st020Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0050", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0050::"));
	}
}

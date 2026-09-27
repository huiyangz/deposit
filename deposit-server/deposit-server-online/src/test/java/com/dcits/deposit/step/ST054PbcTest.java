package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 设置账户执行利率 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST054-TC001 ~ ST054-TC002）
 */
@ExtendWith(MockitoExtension.class)
public class ST054PbcTest {

	@InjectMocks
	private ST054Pbc st054Pbc;

	private ST054InputBO buildInput(BigDecimal realRate) {
		ST054InputBO input = new ST054InputBO();
		input.setRealRate(realRate);
		return input;
	}

	// TC001 正常路径：典型执行利率3.5%（0.035000）赋值账户$执行利率$，成功返回输出realRate为输入值
	@Test
	public void testST054T01() {
		ST054InputBO input = buildInput(new BigDecimal("0.035000"));
		ST054OutputBO output = st054Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.035000"), output.getRealRate());
	}

	// TC002 边界：零值执行利率（0.000000）按赋值语义直传，零值不被改写或拒绝
	@Test
	public void testST054T02() {
		ST054InputBO input = buildInput(new BigDecimal("0.000000"));
		ST054OutputBO output = st054Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.000000"), output.getRealRate());
	}
}

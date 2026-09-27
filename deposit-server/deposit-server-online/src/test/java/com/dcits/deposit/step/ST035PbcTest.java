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

import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;

/**
 * ST035 检查利率浮动类型 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST035-TC001 ~ ST035-TC009）
 */
@ExtendWith(MockitoExtension.class)
public class ST035PbcTest {

	@InjectMocks
	private ST035Pbc st035Pbc;

	// TC001 正常路径：仅{账户利率浮动百分点}不为空，三者恰有一个不为空，返回检查结果"通过"
	@Test
	public void testST035T01() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctSpreadRate(new BigDecimal("1.25"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC002 正常路径：仅{账户利率浮动百分比}不为空，三者恰有一个不为空，返回检查结果"通过"
	@Test
	public void testST035T02() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctPercentRate(new BigDecimal("0.35"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC003 正常路径：仅{账户固定利率}不为空，三者恰有一个不为空，返回检查结果"通过"
	@Test
	public void testST035T03() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctFixedRate(new BigDecimal("2.85"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC004 边界否定路径：三个利率字段均为 null（0 个不为空），不满足"只有一个不为空"，返回错误码 ER0032
	@Test
	public void testST035T04() {
		ST035InputBO input = new ST035InputBO();
		ST035OutputBO output = st035Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0032", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0032::"));
	}

	// TC005 零值边界：仅{账户固定利率}为 BigDecimal 0.00，零值为合法非空值，计入"不为空"计数为 1，检查通过
	@Test
	public void testST035T05() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctFixedRate(new BigDecimal("0.00"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC006 错误码路径：{账户利率浮动百分点}与{账户利率浮动百分比}同时不为空（2 个不为空），返回错误码 ER0032
	@Test
	public void testST035T06() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctSpreadRate(new BigDecimal("1.25"));
		input.setAcctPercentRate(new BigDecimal("0.35"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0032", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0032::"));
	}

	// TC007 错误码路径：{账户利率浮动百分点}与{账户固定利率}同时不为空（2 个不为空），返回错误码 ER0032
	@Test
	public void testST035T07() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctSpreadRate(new BigDecimal("1.25"));
		input.setAcctFixedRate(new BigDecimal("2.85"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0032", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0032::"));
	}

	// TC008 错误码路径：{账户利率浮动百分比}与{账户固定利率}同时不为空（2 个不为空），返回错误码 ER0032
	@Test
	public void testST035T08() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctPercentRate(new BigDecimal("0.35"));
		input.setAcctFixedRate(new BigDecimal("2.85"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0032", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0032::"));
	}

	// TC009 错误码路径：三个利率字段均不为空（3 个不为空），返回错误码 ER0032
	@Test
	public void testST035T09() {
		ST035InputBO input = new ST035InputBO();
		input.setAcctSpreadRate(new BigDecimal("1.25"));
		input.setAcctPercentRate(new BigDecimal("0.35"));
		input.setAcctFixedRate(new BigDecimal("2.85"));
		ST035OutputBO output = st035Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0032", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0032::"));
	}
}

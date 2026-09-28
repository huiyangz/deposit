package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;

/**
 * ST056 检查账户用途 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST056-TC001 ~ ST056-TC020）。
 * 本步骤无 BCC、规则及跨组件调用依赖，无需 Mockito 桩，直接驱动被测实例。
 */
public class ST056PbcTest {

	private ST056InputBO buildInput(RbBusAcctPurpose purpose, AcctCcy ccy,
			String apprLetterNo, AcctNatureNo acctNatureNo) {
		ST056InputBO input = new ST056InputBO();
		input.setRbBusAcctPurpose(purpose);
		input.setAcctCcy(ccy);
		input.setApprLetterNo(apprLetterNo);
		input.setAcctNatureNo(acctNatureNo);
		return input;
	}

	// TC001：基本存款账户且用途为"无特殊用途"，币种虽为人民币元但用途非资本项下，子步骤1/2 条件不成立跳过，子步骤4 检查通过
	@Test
	public void testST056T01() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_0, AcctCcy.CNY, null, AcctNatureNo.VALUE_11001);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC002：一般存款账户且用途为"无特殊用途"，子步骤3a 经"一般存款账户"分支进入子步骤4，检查通过
	@Test
	public void testST056T02() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_0, AcctCcy.CNY, null, AcctNatureNo.VALUE_11002);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC003：基本存款账户且用途为空，子步骤4 条件"用途不为空"不成立，检查通过
	@Test
	public void testST056T03() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(null, AcctCcy.CNY, null, AcctNatureNo.VALUE_11001);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC004：验资户且用途为"注册验资"，子步骤5 允许集合内，检查通过
	@Test
	public void testST056T04() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_1, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC005：验资户且用途为"增资验资"，子步骤5 允许集合内，检查通过
	@Test
	public void testST056T05() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_2, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC006：验资户且用途为"无特殊用途"，"无特殊用途"属于子步骤5 允许集合，检查通过
	@Test
	public void testST056T06() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_0, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC007：专用存款账户且用途为"预算单位专用"，子步骤6 允许集合内，检查通过
	@Test
	public void testST056T07() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_4, AcctCcy.CNY, null, AcctNatureNo.VALUE_11004);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC008：专用存款账户且用途为"非预算单位专用"，子步骤6 允许集合内，检查通过
	@Test
	public void testST056T08() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_3, AcctCcy.CNY, null, AcctNatureNo.VALUE_11004);

		ST056OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC009：人民币元+资本项下且核准件编号为空串（非 null），按"为空"判定返回 ER0012，未进入子步骤2
	@Test
	public void testST056T09() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, "", AcctNatureNo.VALUE_11004);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0012", output.getErrorCode());
	}

	// TC010：人民币元+资本项下且核准件编号与账户属性同时为空，子步骤1 先于子步骤2 执行，返回 ER0012 而非 ER0013
	@Test
	public void testST056T10() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, null, null);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0012", output.getErrorCode());
	}

	// TC011：验资户用途为空，子步骤5 未设"不为空"豁免，空用途不等于任一允许值，按字面判定返回 ER0015
	@Test
	public void testST056T11() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(null, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0015", output.getErrorCode());
	}

	// TC012：币种为美元（非人民币元）时子步骤1/2 整体不执行，子步骤3a 进入子步骤4，资本项下用途非空且不为"无特殊用途"返回 ER0014
	@Test
	public void testST056T12() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.USD, null, AcctNatureNo.VALUE_11001);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0014", output.getErrorCode());
	}

	// TC013：人民币元+资本项下且核准件编号、账户属性均非空，子步骤1/2 通过后子步骤3b 进入子步骤5，资本项下不在允许集合内返回 ER0015
	@Test
	public void testST056T13() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, "ZP20260924001", AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0015", output.getErrorCode());
	}

	// TC014：人民币元+资本项下且核准件编号为 null，子步骤1 返回 ER0012（账户属性已填，排除 ER0013 干扰）
	@Test
	public void testST056T14() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0012", output.getErrorCode());
	}

	// TC015：人民币元+资本项下且核准件编号非空、账户属性为空，子步骤1 通过后子步骤2 返回 ER0013
	@Test
	public void testST056T15() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, "ZP20260924002", null);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0013", output.getErrorCode());
	}

	// TC016：基本存款账户用途为"结算性"，非空且不为"无特殊用途"，子步骤4 返回 ER0014
	@Test
	public void testST056T16() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_6, AcctCcy.CNY, null, AcctNatureNo.VALUE_11001);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0014", output.getErrorCode());
	}

	// TC017：一般存款账户用途为"投融资性"，经"一般存款账户"分支进入子步骤4，非空且不为"无特殊用途"返回 ER0014
	@Test
	public void testST056T17() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_5, AcctCcy.CNY, null, AcctNatureNo.VALUE_11002);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0014", output.getErrorCode());
	}

	// TC018：验资户用途为"结算性"，非空且不在{注册验资,增资验资,无特殊用途}内，子步骤5 返回 ER0015
	@Test
	public void testST056T18() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_6, AcctCcy.CNY, null, AcctNatureNo.VALUE_17);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0015", output.getErrorCode());
	}

	// TC019：人民币元+资本项下且核准件编号、账户属性均非空，子步骤1/2 通过后子步骤3c 进入子步骤6，资本项下不在允许集合内返回 ER0016
	@Test
	public void testST056T19() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_501, AcctCcy.CNY, "ZP20260924003", AcctNatureNo.VALUE_11004);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0016", output.getErrorCode());
	}

	// TC020：专用存款账户用途为"无特殊用途"，非空且不在{预算单位专用,非预算单位专用}内，子步骤6 返回 ER0016
	@Test
	public void testST056T20() {
		ST056Pbc step = new ST056Pbc();
		ST056InputBO input = buildInput(RbBusAcctPurpose.VALUE_0, AcctCcy.CNY, null, AcctNatureNo.VALUE_11004);

		ST056OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0016", output.getErrorCode());
	}
}

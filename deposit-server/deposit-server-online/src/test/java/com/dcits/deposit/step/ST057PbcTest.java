package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057InputBO.SettleAcctDTO;
import com.dcits.deposit.facade.bo.ST057OutputBO;

/**
 * ST057 检查利息资本化标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST057-TC001 ~ ST057-TC004）
 * 本步骤为纯输入逻辑校验，无 BCC/规则/跨组件依赖，无需依赖桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST057PbcTest {

	@InjectMocks
	private ST057Pbc st057Pbc;

	private SettleAcctDTO buildSettleAcct(SettleAcctClass settleAcctClass) {
		SettleAcctDTO settleAcct = new SettleAcctDTO();
		settleAcct.setSettleAcctClass(settleAcctClass);
		return settleAcct;
	}

	private ST057InputBO buildInput(String intCapFlag, List<SettleAcctDTO> settleAccts) {
		ST057InputBO input = new ST057InputBO();
		input.setIntCapFlag(intCapFlag);
		input.setSettleAccts(settleAccts);
		return input;
	}

	// TC001 利息资本化标志为"Y"（非"N"）：子步骤1走"否则"分支直接返回检查结果"通过"，子步骤2不执行（数组刻意不含INT账户）
	@Test
	public void testST057T01() {
		List<SettleAcctDTO> settleAccts = new ArrayList<>();
		settleAccts.add(buildSettleAcct(SettleAcctClass.PAY));
		ST057InputBO input = buildInput("Y", settleAccts);
		ST057OutputBO output = st057Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC002 利息资本化标志为"N"：子步骤2遍历命中位于非首位的利息入账账户（INT），返回检查结果"通过"
	@Test
	public void testST057T02() {
		List<SettleAcctDTO> settleAccts = new ArrayList<>();
		settleAccts.add(buildSettleAcct(SettleAcctClass.PAY));
		settleAccts.add(buildSettleAcct(SettleAcctClass.INT));
		settleAccts.add(buildSettleAcct(SettleAcctClass.REC));
		ST057InputBO input = buildInput("N", settleAccts);
		ST057OutputBO output = st057Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC003 利息资本化标志为"N"：数组非空但所有元素结算账户类型均非"INT"，子步骤2返回错误码 ER0034
	@Test
	public void testST057T03() {
		List<SettleAcctDTO> settleAccts = new ArrayList<>();
		settleAccts.add(buildSettleAcct(SettleAcctClass.PAY));
		settleAccts.add(buildSettleAcct(SettleAcctClass.REC));
		ST057InputBO input = buildInput("N", settleAccts);
		ST057OutputBO output = st057Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0034", output.getErrorCode());
	}

	// TC004 利息资本化标志为"N"：上送结算账户数组为空集合（非null），不存在INT账户，子步骤2返回错误码 ER0034
	@Test
	public void testST057T04() {
		List<SettleAcctDTO> settleAccts = new ArrayList<>();
		ST057InputBO input = buildInput("N", settleAccts);
		ST057OutputBO output = st057Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0034", output.getErrorCode());
	}
}

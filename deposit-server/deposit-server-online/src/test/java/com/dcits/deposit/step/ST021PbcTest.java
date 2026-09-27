package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST021 检查存入账户账户状态 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST021-TC001 ~ ST021-TC006）
 */
@ExtendWith(MockitoExtension.class)
public class ST021PbcTest {

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@InjectMocks
	private ST021Pbc st021Pbc;

	private ST021InputBO buildInput(String baseAcctNo) {
		ST021InputBO input = new ST021InputBO();
		input.setBaseAcctNo(baseAcctNo);
		return input;
	}

	private RbBusAcctEO buildAcct(String baseAcctNo, AcctStatus acctStatus) {
		RbBusAcctEO eo = new RbBusAcctEO();
		eo.setBaseAcctNo(baseAcctNo);
		eo.setAcctStatus(acctStatus);
		return eo;
	}

	// 场景：存入账户状态为A-活动，不在C/S/O禁止集合，检查通过并回写账户状态
	@Test
	public void testST021T01() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000101".equals(eo.getBaseAcctNo()))))
				.thenReturn(List.of(buildAcct("2000020000000101", AcctStatus.A)));

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000101"));

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.A, output.getAcctStatus());
	}

	// 场景：存入账户状态为D-睡眠，睡眠不在禁止集合（仅C/S/O不通过），检查通过并回写账户状态
	@Test
	public void testST021T02() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000102".equals(eo.getBaseAcctNo()))))
				.thenReturn(List.of(buildAcct("2000020000000102", AcctStatus.D)));

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000102"));

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.D, output.getAcctStatus());
	}

	// 场景：存入账户状态为C-关闭，命中禁止状态，返回错误码ER0046
	@Test
	public void testST021T03() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000103".equals(eo.getBaseAcctNo()))))
				.thenReturn(List.of(buildAcct("2000020000000103", AcctStatus.C)));

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000103"));

		assertFalse(output.isSucceed());
		assertEquals("ER0046", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0046::"));
	}

	// 场景：存入账户状态为S-久悬，命中禁止状态，返回错误码ER0046
	@Test
	public void testST021T04() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000104".equals(eo.getBaseAcctNo()))))
				.thenReturn(List.of(buildAcct("2000020000000104", AcctStatus.S)));

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000104"));

		assertFalse(output.isSucceed());
		assertEquals("ER0046", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0046::"));
	}

	// 场景：存入账户状态为O-转营业外，命中禁止状态，返回错误码ER0046
	@Test
	public void testST021T05() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000105".equals(eo.getBaseAcctNo()))))
				.thenReturn(List.of(buildAcct("2000020000000105", AcctStatus.O)));

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000105"));

		assertFalse(output.isSucceed());
		assertEquals("ER0046", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0046::"));
	}

	// 场景：按账号未查到账户记录，子步骤1检查不通过提前返回，子步骤2不执行，账户状态无来源为null
	@Test
	public void testST021T06() {
		lenient().when(rbBusAcctBcc.findByEo(argThat(eo -> "2000020000000106".equals(eo.getBaseAcctNo()))))
				.thenReturn(Collections.emptyList());

		ST021OutputBO output = st021Pbc.execute(buildInput("2000020000000106"));

		assertFalse(output.isSucceed());
		assertNull(output.getAcctStatus());
	}
}

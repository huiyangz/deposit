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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AppointmentStatus;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctAppointmentBcc;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctAppointmentEO;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST030 检查账号 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST030-TC001 ~ ST030-TC008）
 */
@ExtendWith(MockitoExtension.class)
public class ST030PbcTest {

	private static final String BASE_ACCT_NO = "62000002000000001234";
	private static final String CARD_NO = "6222020200112233445";

	@Mock
	private IRbBusAcctAppointmentBcc rbBusAcctAppointmentBcc;

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@InjectMocks
	private ST030Pbc st030Pbc;

	private ST030InputBO buildInput(SpecAcctFlag specAcctFlag, String baseAcctNo) {
		ST030InputBO input = new ST030InputBO();
		input.setSpecAcctFlag(specAcctFlag);
		input.setBaseAcctNo(baseAcctNo);
		input.setCardNo(CARD_NO);
		return input;
	}

	private RbBusAcctAppointmentEO buildAppointment() {
		RbBusAcctAppointmentEO eo = new RbBusAcctAppointmentEO();
		eo.setOrderNo("ORD20260924000001");
		eo.setBaseAcctNo(BASE_ACCT_NO);
		eo.setAppointmentStatus(AppointmentStatus.S);
		return eo;
	}

	private RbBusAcctEO buildAcct() {
		RbBusAcctEO eo = new RbBusAcctEO();
		eo.setInternalKey(1001);
		eo.setBaseAcctNo(BASE_ACCT_NO);
		eo.setSpecAcctFlag(SpecAcctFlag.A);
		return eo;
	}

	// TC001 非定制账户且已上送账号，预约信息存在：按{账号}+$预约状态$=S查询【账号预约信息】返回1条，子步骤4判定不为空，返回"通过"
	@Test
	public void testST030T01() {
		List<RbBusAcctAppointmentEO> appointmentList = new ArrayList<>();
		appointmentList.add(buildAppointment());
		Mockito.lenient().when(rbBusAcctAppointmentBcc.findByEo(Mockito.argThat(eo ->
				BASE_ACCT_NO.equals(eo.getBaseAcctNo()) && eo.getAppointmentStatus() == AppointmentStatus.S)))
				.thenReturn(appointmentList);
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.N, BASE_ACCT_NO));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC002 非定制账户且已上送账号，预约信息为空：查询【账号预约信息】返回空列表，[预留账户信息]为空，子步骤4返回错误码 ER0025
	@Test
	public void testST030T02() {
		Mockito.lenient().when(rbBusAcctAppointmentBcc.findByEo(Mockito.argThat(eo ->
				BASE_ACCT_NO.equals(eo.getBaseAcctNo()) && eo.getAppointmentStatus() == AppointmentStatus.S)))
				.thenReturn(new ArrayList<>());
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.N, BASE_ACCT_NO));
		assertFalse(output.isSucceed());
		assertEquals("ER0025", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0025::"));
		assertNull(output.getCheckResult());
	}

	// TC003 非定制账户且未上送账号：子步骤2判定未上送{账号}，直接返回"通过"，不触达预约查询
	@Test
	public void testST030T03() {
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.N, null));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC004 全账户定制且账号非空，账户信息不存在：按{账号}查询【账户信息】返回空列表，子步骤6判定不存在，返回"通过"
	@Test
	public void testST030T04() {
		Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.argThat(eo ->
				BASE_ACCT_NO.equals(eo.getBaseAcctNo()))))
				.thenReturn(new ArrayList<>());
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.A, BASE_ACCT_NO));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC005 全账户定制且账号非空，定制账号已存在：查询【账户信息】返回1条记录，子步骤6判定[账户信息]存在，返回错误码 ER0026
	@Test
	public void testST030T05() {
		List<RbBusAcctEO> acctList = new ArrayList<>();
		acctList.add(buildAcct());
		Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.argThat(eo ->
				BASE_ACCT_NO.equals(eo.getBaseAcctNo()))))
				.thenReturn(acctList);
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.A, BASE_ACCT_NO));
		assertFalse(output.isSucceed());
		assertEquals("ER0026", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0026::"));
		assertNull(output.getCheckResult());
	}

	// TC006 定制账户（Y，非N非A）且已上送账号：子步骤5"{定制账户标志}=A"不成立，返回"通过"，不查询【账户信息】
	@Test
	public void testST030T06() {
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.Y, BASE_ACCT_NO));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC007 全账户定制但账号为空串：子步骤5条件"{账号}不等于空"不成立，返回"通过"，不查询【账户信息】
	@Test
	public void testST030T07() {
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.A, ""));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC008 指定账户顺序号（P，非N非A）且已上送账号：子步骤5条件不成立，返回"通过"
	@Test
	public void testST030T08() {
		ST030OutputBO output = st030Pbc.execute(buildInput(SpecAcctFlag.P, BASE_ACCT_NO));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}
}

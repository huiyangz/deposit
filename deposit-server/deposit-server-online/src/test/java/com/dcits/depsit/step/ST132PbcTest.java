package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST132InputBO;
import com.dcits.depsit.facade.bo.ST132OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST132 计算账户解限可用余额的单元测试。
 *
 * <p>用例依据：Spec REQ-001～REQ-005 与 `outputs/测试用例.md` ST132-TC001～TC007。
 * 【账户信息】的数据源绑定（{@code IRbBusAcctBcc#findByEo}）与【账户余额信息】的取数方式
 * （按主键 {@code findByPrimaryKey}）在 Spec 中为不覆盖事项，本测试仅作为执行载体，
 * 断言只落在两段查询条件取值、计算取值与最终步骤结论上；不使用 verify/never/times/InOrder。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST132PbcTest {

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@Mock
	private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

	@InjectMocks
	private ST132Pbc pbc;

	@Captor
	private ArgumentCaptor<RbBusAcctEO> acctConditionCaptor;

	@Captor
	private ArgumentCaptor<Integer> balanceKeyCaptor;

	// ST132-TC001：REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-004-S01 完整成功链路——
	// 账号 6217000000000001 命中账户取得键值 1001，按键值 1001 命中余额取得 1000.00 与 200.00，
	// 相加得 1200.00 作为输出，并核对两段查询条件的字段映射
	@Test
	void testST132T01() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6217000000000001");
		acctEo.setInternalKey(1001);
		RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
		balEo.setInternalKey(1001);
		balEo.setTotalAmount(new BigDecimal("1000.00"));
		balEo.setOdAmount(new BigDecimal("200.00"));
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(balEo);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000001");
		ST132OutputBO out = pbc.execute(input);

		assertTrue(out.isSucceed());
		assertNull(out.getErrorCode());
		assertNull(out.getErrorMessage());
		assertNotNull(out.getAcctAvailBal());
		assertEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("1200.00")));
		assertEquals("6217000000000001", acctConditionCaptor.getValue().getBaseAcctNo());
		assertEquals(Integer.valueOf(1001), balanceKeyCaptor.getValue());
	}

	// ST132-TC002：REQ-003-S02 计算口径——余额记录中原有 acctAvailBal = 0.00，
	// 结果仍由两个加数决定为 1200.00，既不取用原有可用余额也不等于单个加数 1000.00
	@Test
	void testST132T02() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6217000000000001");
		acctEo.setInternalKey(1001);
		RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
		balEo.setInternalKey(1001);
		balEo.setTotalAmount(new BigDecimal("1000.00"));
		balEo.setOdAmount(new BigDecimal("200.00"));
		balEo.setAcctAvailBal(new BigDecimal("0.00"));
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(balEo);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000001");
		ST132OutputBO out = pbc.execute(input);

		assertTrue(out.isSucceed());
		assertNull(out.getErrorCode());
		assertNotNull(out.getAcctAvailBal());
		assertEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("1200.00")));
		assertNotEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("0.00")));
		assertNotEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("1000.00")));
	}

	// ST132-TC003：REQ-001-S01、REQ-002-S01 取值映射——账号 6222000000000007 与账户内部键值 2002
	// 可区分，第二段取数使用的是账户内部键值而非账号字面，结果 5000.00 + 100.00 = 5100.00
	@Test
	void testST132T03() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6222000000000007");
		acctEo.setInternalKey(2002);
		RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
		balEo.setInternalKey(2002);
		balEo.setTotalAmount(new BigDecimal("5000.00"));
		balEo.setOdAmount(new BigDecimal("100.00"));
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(balEo);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6222000000000007");
		ST132OutputBO out = pbc.execute(input);

		assertTrue(out.isSucceed());
		assertNull(out.getErrorCode());
		assertEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("5100.00")));
		assertEquals("6222000000000007", acctConditionCaptor.getValue().getBaseAcctNo());
		assertEquals(Integer.valueOf(2002), balanceKeyCaptor.getValue());
	}

	// ST132-TC004：REQ-003、REQ-004 零值边界——汇总金额与透支金额均为 0.00，
	// 加法结果为 0.00，成功路径恒产出输出，零值不视为未产出
	@Test
	void testST132T04() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6217000000000003");
		acctEo.setInternalKey(1003);
		RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
		balEo.setInternalKey(1003);
		balEo.setTotalAmount(new BigDecimal("0.00"));
		balEo.setOdAmount(new BigDecimal("0.00"));
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(balEo);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000003");
		ST132OutputBO out = pbc.execute(input);

		assertTrue(out.isSucceed());
		assertNull(out.getErrorCode());
		assertNotNull(out.getAcctAvailBal());
		assertEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("0.00")));
	}

	// ST132-TC005：REQ-001-S02 失败路径——按账号查询【账户信息】未命中（空集合），
	// 返回 ER0048 并结束本步骤，不进入余额取数与计算，不产出输出
	@Test
	void testST132T05() {
		stubAccountQuery(Collections.emptyList());

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000009");
		ST132OutputBO out = pbc.execute(input);

		assertFalse(out.isSucceed());
		assertEquals("ER0048", out.getErrorCode());
		assertNull(out.getAcctAvailBal());
		assertEquals("6217000000000009", acctConditionCaptor.getValue().getBaseAcctNo());
	}

	// ST132-TC006：REQ-002-S02 失败路径——账户存在并取得内部键值 1004，
	// 但该账户没有余额记录（查询返回 null），返回 ER0048 并结束本步骤，不执行计算、不产出输出
	@Test
	void testST132T06() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6217000000000004");
		acctEo.setInternalKey(1004);
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(null);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000004");
		ST132OutputBO out = pbc.execute(input);

		assertFalse(out.isSucceed());
		assertEquals("ER0048", out.getErrorCode());
		assertNull(out.getAcctAvailBal());
		assertEquals(Integer.valueOf(1004), balanceKeyCaptor.getValue());
	}

	// ST132-TC007：REQ-003、REQ-004 加数为零的边界——汇总金额 0.00、透支金额 200.00，
	// 第二个加数照常参与加法得 200.00，不因另一加数为零而跳过计算或返回空
	@Test
	void testST132T07() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6217000000000005");
		acctEo.setInternalKey(1005);
		RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
		balEo.setInternalKey(1005);
		balEo.setTotalAmount(new BigDecimal("0.00"));
		balEo.setOdAmount(new BigDecimal("200.00"));
		stubAccountQuery(List.of(acctEo));
		stubBalanceQuery(balEo);

		ST132InputBO input = new ST132InputBO();
		input.setBaseAcctNo("6217000000000005");
		ST132OutputBO out = pbc.execute(input);

		assertTrue(out.isSucceed());
		assertNull(out.getErrorCode());
		assertNotNull(out.getAcctAvailBal());
		assertEquals(0, out.getAcctAvailBal().compareTo(new BigDecimal("200.00")));
		assertEquals(Integer.valueOf(1005), balanceKeyCaptor.getValue());
	}

	/**
	 * 按账号查询【账户信息】的桩：捕获查询实参并返回给定账户记录集合。
	 * 该数据源绑定属 Spec 不覆盖的实现选择，仅作为本步骤的执行载体。
	 */
	private void stubAccountQuery(List<RbBusAcctEO> result) {
		lenient().when(rbBusAcctBcc.findByEo(acctConditionCaptor.capture())).thenReturn(result);
	}

	/**
	 * 按账户内部键值查询【账户余额信息】的桩：捕获查询实参并返回给定余额记录（null 表示无记录）。
	 */
	private void stubBalanceQuery(RbBusAcctBalanceEO result) {
		lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(balanceKeyCaptor.capture())).thenReturn(result);
	}
}

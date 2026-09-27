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

import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST003InputBO;
import com.dcits.deposit.facade.bo.ST003OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST003 检查账户类型 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST003-TC001 ~ ST003-TC004）
 */
@ExtendWith(MockitoExtension.class)
public class ST003PbcTest {

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@InjectMocks
	private ST003Pbc st003Pbc;

	/** 按账号设桩：findByEo 返回该账号的单条【对公存款账户主表】记录 */
	private void stubRbBusAcctByBaseAcctNo(String baseAcctNo, RbAcctType rbAcctType) {
		RbBusAcctEO rbBusAcct = new RbBusAcctEO();
		rbBusAcct.setBaseAcctNo(baseAcctNo);
		rbBusAcct.setRbAcctType(rbAcctType);
		List<RbBusAcctEO> rbBusAcctList = new ArrayList<>();
		rbBusAcctList.add(rbBusAcct);
		Mockito.lenient()
				.when(rbBusAcctBcc.findByEo(Mockito.argThat(eo -> baseAcctNo.equals(eo.getBaseAcctNo()))))
				.thenReturn(rbBusAcctList);
	}

	// TC001 账户类型为 C-结算账户：不等于“T-定期账户”、“A-AIO账户”，检查结果“通过”，输出查询到的存款账户类型
	@Test
	public void testST003T01() {
		stubRbBusAcctByBaseAcctNo("2000010001", RbAcctType.C);
		ST003InputBO input = new ST003InputBO();
		input.setBaseAcctNo("2000010001");
		ST003OutputBO output = st003Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(RbAcctType.C, output.getRbAcctType());
	}

	// TC002 账户类型为 S-储蓄账户（枚举域内另一合法通过取值），检查结果“通过”
	@Test
	public void testST003T02() {
		stubRbBusAcctByBaseAcctNo("2000010002", RbAcctType.S);
		ST003InputBO input = new ST003InputBO();
		input.setBaseAcctNo("2000010002");
		ST003OutputBO output = st003Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(RbAcctType.S, output.getRbAcctType());
	}

	// TC003 账户类型为 T-定期账户，子步骤2 条件不成立，返回错误码 ER0052
	@Test
	public void testST003T03() {
		stubRbBusAcctByBaseAcctNo("2000010003", RbAcctType.T);
		ST003InputBO input = new ST003InputBO();
		input.setBaseAcctNo("2000010003");
		ST003OutputBO output = st003Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0052", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0052::"));
	}

	// TC004 账户类型为 A-AIO账户（SPEC 条件中另一个被拒字面量），返回错误码 ER0052
	@Test
	public void testST003T04() {
		stubRbBusAcctByBaseAcctNo("2000010004", RbAcctType.A);
		ST003InputBO input = new ST003InputBO();
		input.setBaseAcctNo("2000010004");
		ST003OutputBO output = st003Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0052", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0052::"));
	}
}

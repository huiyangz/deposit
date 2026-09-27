package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;

/**
 * ST026 设置账户状态 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST026-TC001 ~ ST026-TC012）
 */
@ExtendWith(MockitoExtension.class)
public class ST026PbcTest {

	@Mock
	private IFmClientCopyBcc fmClientCopyBcc;

	@InjectMocks
	private ST026Pbc st026Pbc;

	/** 按精确客户号设桩【客户信息】，并构造输入；桩以具体 clientNo 实参匹配 */
	private ST026InputBO buildCase(String clientNo, CategoryType categoryType, String inlandOffshore,
			AcctNatureNo acctNatureNo, RbBusAcctPurpose rbBusAcctPurpose) {
		FmClientCopyEO clientCopy = new FmClientCopyEO();
		clientCopy.setCategoryType(categoryType);
		clientCopy.setInlandOffshore(inlandOffshore);
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey(clientNo)).thenReturn(clientCopy);

		ST026InputBO input = new ST026InputBO();
		input.setClientNo(clientNo);
		input.setAcctNatureNo(acctNatureNo);
		input.setRbBusAcctPurpose(rbBusAcctPurpose);
		return input;
	}

	// TC001 基本存款账户、境内、一人公司→企业标志=是，用途未填；规则1.a 返回"新建"
	@Test
	public void testST026T01() {
		ST026InputBO input = buildCase("CL100000001", CategoryType.VALUE_204, "境内",
				AcctNatureNo.VALUE_11001, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}

	// TC002 基本存款账户、境内、有限责任公司（列举外）→企业标志=否；规则1.b 返回"预开户"
	@Test
	public void testST026T02() {
		ST026InputBO input = buildCase("CL100000002", CategoryType.VALUE_201, "境内",
				AcctNatureNo.VALUE_11001, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.I, output.getAcctStatus());
	}

	// TC003 基本存款账户、境外、非法人企业→企业标志=是；规则1.c 返回"预开户"
	@Test
	public void testST026T03() {
		ST026InputBO input = buildCase("CL100000003", CategoryType.VALUE_205, "境外",
				AcctNatureNo.VALUE_11001, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.I, output.getAcctStatus());
	}

	// TC004 临时存款账户、境内、有字号的个体工商户→企业标志=是；规则4.a 返回"新建"
	@Test
	public void testST026T04() {
		ST026InputBO input = buildCase("CL100000004", CategoryType.VALUE_207, "境内",
				AcctNatureNo.VALUE_11003, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}

	// TC005 临时存款账户、境内、个体工商户（VALUE_206，名称相近但不在列举内）→企业标志=否；规则4.b 返回"预开户"
	@Test
	public void testST026T05() {
		ST026InputBO input = buildCase("CL100000005", CategoryType.VALUE_206, "境内",
				AcctNatureNo.VALUE_11003, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.I, output.getAcctStatus());
	}

	// TC006 专用存款账户、用途=非预算单位专用、境外、无字号的个体工商户→企业标志=是；规则3.2 返回"新建"
	@Test
	public void testST026T06() {
		ST026InputBO input = buildCase("CL100000006", CategoryType.VALUE_208, "境外",
				AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_3);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}

	// TC007 一般存款账户、境外、机关、事业单位→企业标志=否；规则2 不依赖标志与用途，返回"新建"
	@Test
	public void testST026T07() {
		ST026InputBO input = buildCase("CL100000007", CategoryType.VALUE_209, "境外",
				AcctNatureNo.VALUE_11002, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}

	// TC008 专用存款账户、用途未填（null）、境内、个人－普通客户→企业标志=否；规则3.3（含用途为空值）返回"新建"
	@Test
	public void testST026T08() {
		ST026InputBO input = buildCase("CL100000008", CategoryType.VALUE_101, "境内",
				AcctNatureNo.VALUE_11004, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}

	// TC009 专用存款账户、用途=预算单位专用、境内、一人公司→企业标志=是；规则3.1.a 返回空值，子步骤4 返回错误码 ER0063
	@Test
	public void testST026T09() {
		ST026InputBO input = buildCase("CL100000009", CategoryType.VALUE_204, "境内",
				AcctNatureNo.VALUE_11004, RbBusAcctPurpose.VALUE_4);
		ST026OutputBO output = st026Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0063", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0063::"));
		assertNull(output.getAcctStatus());
	}

	// TC010 临时存款账户、境外、非法人企业→企业标志=是；规则4.c 返回空值，子步骤4 返回错误码 ER0063
	@Test
	public void testST026T10() {
		ST026InputBO input = buildCase("CL100000010", CategoryType.VALUE_205, "境外",
				AcctNatureNo.VALUE_11003, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0063", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0063::"));
		assertNull(output.getAcctStatus());
	}

	// TC011 验资户、境外、有字号的个体工商户→企业标志=是；规则5.c 返回空值，子步骤4 返回错误码 ER0063
	@Test
	public void testST026T11() {
		ST026InputBO input = buildCase("CL100000011", CategoryType.VALUE_207, "境外",
				AcctNatureNo.VALUE_17, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0063", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0063::"));
		assertNull(output.getAcctStatus());
	}

	// TC012 其他账户属性（对公人民币定期存款账户）、境内、有限责任公司→企业标志=否；规则6 返回"新建"
	@Test
	public void testST026T12() {
		ST026InputBO input = buildCase("CL100000012", CategoryType.VALUE_201, "境内",
				AcctNatureNo.VALUE_11005, null);
		ST026OutputBO output = st026Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AcctStatus.N, output.getAcctStatus());
	}
}

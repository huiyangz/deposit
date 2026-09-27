package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureClass;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.components.IRbAcctNatureDefBcc;
import com.dcits.deposit.facade.eo.RbAcctNatureDefEO;

/**
 * ST050 设置账户年检标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST050-TC001 ~ ST050-TC005）
 *
 * 本步骤无业务失败场景（SPEC 失败处理：失败仅由技术异常传播表达），所有用例均以 succeed=true 返回。
 *
 * 工程约束：当前 JVM（Java 26）携带的 Byte Buddy 仅官方支持到 Java 24，Mockito inline
 * mock maker 对任何具体类的桩化都需重转换 java.lang.Object（类文件版本 70），全部失败；
 * 仅接口桩化可用（ST042/ST006 等既有测试均为接口桩）。因此 IRbAcctNatureDefBcc 仍用
 * Mockito 桩，ExternalTaskClient（具体类）改用测试内匿名子类按真实签名
 * {@code queryProductInfo(String, String)} 覆写：断言精确请求值（产品编号、参数KEY值）
 * 并返回用例设定的账户类型，语义与用例设计的精确参数匹配桩一致。不改 POM、不加依赖。
 */
@ExtendWith(MockitoExtension.class)
public class ST050PbcTest {

	@Mock
	private IRbAcctNatureDefBcc rbAcctNatureDefBcc;

	private RbAcctNatureDefEO buildNatureDef(NatureClass natureClass) {
		RbAcctNatureDefEO eo = new RbAcctNatureDefEO();
		eo.setNatureClass(natureClass);
		return eo;
	}

	private ST050InputBO buildInput(AcctNatureNo acctNatureNo, String acctOpenDate, String runDate) {
		ST050InputBO input = new ST050InputBO();
		input.setAcctNatureNo(acctNatureNo);
		input.setAcctOpenDate(Date.valueOf(acctOpenDate));
		input.setClientNo("CL20000012345");
		input.setProdNo("PD0001");
		input.setAttrKey("ACCT_TYPE");
		input.setRunDate(Date.valueOf(runDate));
		return input;
	}

	/**
	 * 构造被测实例：产品管理《查询产品信息》客户端按真实签名覆写，
	 * 精确匹配 {产品编号}="PD0001"、{参数KEY值}="ACCT_TYPE" 后返回指定账户类型。
	 * 覆写方法不触达 RestTemplate，构造参数传 null 仅为满足真实构造器签名。
	 */
	private ST050Pbc newSt050Pbc(final String acctType) {
		ExternalTaskClient externalTaskClient = new ExternalTaskClient(null) {
			@Override
			public String queryProductInfo(String prodNo, String attrKey) {
				assertEquals("PD0001", prodNo, "queryProductInfo {产品编号} 请求值");
				assertEquals("ACCT_TYPE", attrKey, "queryProductInfo {参数KEY值} 请求值");
				return acctType;
			}
		};
		return new ST050Pbc(externalTaskClient, rbAcctNatureDefBcc);
	}

	// TC001 非活期非保证金账户（账户类型"D"、账户属性分类基本户），开户年2025早于系统年2026，子步骤6、7条件均不成立，年检标志"是"
	@Test
	public void testST050T01() {
		ST050Pbc st050Pbc = newSt050Pbc("D");
		Mockito.lenient().when(rbAcctNatureDefBcc.findByAcctNatureNo(AcctNatureNo.VALUE_11001))
				.thenReturn(buildNatureDef(NatureClass.VALUE_1));
		ST050InputBO input = buildInput(AcctNatureNo.VALUE_11001, "2025-03-10", "2026-09-28");
		ST050OutputBO output = st050Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("是", output.getAnnualFlag());
	}

	// TC002 活期保证金账户（账户类型"C"且账户属性分类保证金账户），标志"是"；开户年2024早于系统年2026，条件B单独成立，年检标志"否"
	@Test
	public void testST050T02() {
		ST050Pbc st050Pbc = newSt050Pbc("C");
		Mockito.lenient().when(rbAcctNatureDefBcc.findByAcctNatureNo(AcctNatureNo.VALUE_99001))
				.thenReturn(buildNatureDef(NatureClass.VALUE_3));
		ST050InputBO input = buildInput(AcctNatureNo.VALUE_99001, "2024-01-15", "2026-09-28");
		ST050OutputBO output = st050Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getAnnualFlag());
	}

	// TC003 当年开户（开户年2026等于系统年2026）且活期非保证金（账户类型"C"但账户属性分类基本户），条件A单独成立，年检标志"否"
	@Test
	public void testST050T03() {
		ST050Pbc st050Pbc = newSt050Pbc("C");
		Mockito.lenient().when(rbAcctNatureDefBcc.findByAcctNatureNo(AcctNatureNo.VALUE_11001))
				.thenReturn(buildNatureDef(NatureClass.VALUE_1));
		ST050InputBO input = buildInput(AcctNatureNo.VALUE_11001, "2026-05-20", "2026-09-28");
		ST050OutputBO output = st050Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getAnnualFlag());
	}

	// TC004 账户属性定义无记录：findByAcctNatureNo返回null，账户属性分类为空，即使账户类型"C"也不构成活期保证金；2025≠2026，年检标志"是"
	@Test
	public void testST050T04() {
		ST050Pbc st050Pbc = newSt050Pbc("C");
		Mockito.lenient().when(rbAcctNatureDefBcc.findByAcctNatureNo(AcctNatureNo.VALUE_99001))
				.thenReturn(null);
		ST050InputBO input = buildInput(AcctNatureNo.VALUE_99001, "2025-11-08", "2026-09-28");
		ST050OutputBO output = st050Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("是", output.getAnnualFlag());
	}

	// TC005 当年开户（2026==2026）的活期保证金账户（账户类型"C"且账户属性分类保证金账户），条件A、B同时成立，年检标志"否"
	@Test
	public void testST050T05() {
		ST050Pbc st050Pbc = newSt050Pbc("C");
		Mockito.lenient().when(rbAcctNatureDefBcc.findByAcctNatureNo(AcctNatureNo.VALUE_99001))
				.thenReturn(buildNatureDef(NatureClass.VALUE_3));
		ST050InputBO input = buildInput(AcctNatureNo.VALUE_99001, "2026-02-10", "2026-09-28");
		ST050OutputBO output = st050Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getAnnualFlag());
	}
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;

/**
 * ST052 检查支取方式 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST052-TC001 ~ ST052-TC012）
 *
 * 工程约束：测试节点以 JDK 26 运行，Spring Boot 3.4.3 管理的 Byte Buddy
 * 最高支持 Java 24，Mockito 无法创建 mock（outputs/test-results.md：
 * "Java 26 (70) is not supported by the current version of Byte Buddy"），
 * 且本节点不得修改 POM 或新增依赖。因此不使用 Mockito，改为继承
 * ExternalTaskClient 并按真实签名覆写 queryProductInfo 的手写桩；
 * 桩记录收到的 prodNo/attrKey，等价实现用例表中 Mockito 精确参数匹配
 * 对输入到客户端参数映射的核对。
 */
public class ST052PbcTest {

	/**
	 * 产品支取方式查询桩：按真实签名覆写 queryProductInfo，返回构造时给定的集合原值。
	 * RestTemplate 传 null：被测路径只触达已覆写的方法，若误入未覆写的真实调用将快速失败。
	 */
	private static class StubExternalTaskClient extends ExternalTaskClient {

		/** queryProductInfo 固定返回的产品支取方式集合原值 */
		private final String withdrawalTypes;

		/** 桩收到的产品编号 */
		String requestedProdNo;

		/** 桩收到的参数KEY值 */
		String requestedAttrKey;

		StubExternalTaskClient(String withdrawalTypes) {
			super(null);
			this.withdrawalTypes = withdrawalTypes;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			this.requestedProdNo = prodNo;
			this.requestedAttrKey = attrKey;
			return withdrawalTypes;
		}
	}

	// 凭密码支取、密码已填、非代办，完整走通子步骤1→2→3，预期检查通过
	@Test
	public void testST052T01() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOP");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword("860512");
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}

	// 凭印鉴和密码支取、密码已填、非代办，走通子步骤1→2→3，预期检查通过
	@Test
	public void testST052T02() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOPS");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.B);
		input.setPassword("475920");
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}

	// 无密码无印鉴支取（W）、密码为空、非代办：支取方式不属于“凭密码/凭印鉴和密码”，不触发密码检查，预期检查通过
	@Test
	public void testST052T03() {
		StubExternalTaskClient client = new StubExternalTaskClient("OPSW");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.W);
		input.setPassword(null);
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}

	// 代办支取：凭密码支取但代办人名称非空，密码为空不返回ER0022，预期检查通过
	@Test
	public void testST052T04() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOP");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword(null);
		input.setCommissionClientName("赵六");
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}

	// 产品支取方式集合最小形态：仅配置单一支取方式P，输入命中且密码已填，预期检查通过
	@Test
	public void testST052T05() {
		StubExternalTaskClient client = new StubExternalTaskClient("P");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword("316842");
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}

	// 支取方式S（凭印鉴支取）不在产品配置集合内，预期返回ER0021
	@Test
	public void testST052T06() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOPW");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.S);
		input.setPassword("907163");
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0021", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0021::"));
	}

	// 凭密码支取、非代办、密码为null：子步骤3三条件同时成立，预期返回ER0022
	@Test
	public void testST052T07() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOP");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword(null);
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0022", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0022::"));
	}

	// 凭印鉴和密码支取、非代办、密码为null：子步骤3另一支取方式分支，预期返回ER0022
	@Test
	public void testST052T08() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOS");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.B);
		input.setPassword(null);
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0022", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0022::"));
	}

	// 支取方式R不在集合内且密码同时为空：子步骤2先判定并提前返回ER0021，子步骤3不执行（非ER0022）
	@Test
	public void testST052T09() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOPS");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.R);
		input.setPassword(null);
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0021", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0021::"));
	}

	// 产品支取方式集合为空（返回空串，产品未配置任何支取方式）：空集合不包含任何支取方式，预期返回ER0021
	@Test
	public void testST052T10() {
		StubExternalTaskClient client = new StubExternalTaskClient("");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword("860512");
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0021", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0021::"));
	}

	// 凭密码支取、非代办，密码与代办人名称均为空字符串：空串按“为空/等于空”处理，预期返回ER0022
	@Test
	public void testST052T11() {
		StubExternalTaskClient client = new StubExternalTaskClient("BOP");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.P);
		input.setPassword("");
		input.setCommissionClientName("");
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertFalse(result.isSucceed());
		assertEquals("ER0022", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0022::"));
	}

	// 支取方式R（支付密码器和印鉴）在集合内、密码为空、非代办：R不属于“凭密码/凭印鉴和密码”两类，不触发密码检查，预期检查通过
	@Test
	public void testST052T12() {
		StubExternalTaskClient client = new StubExternalTaskClient("BRW");
		ST052Pbc st052Pbc = new ST052Pbc(client);
		ST052InputBO input = new ST052InputBO();
		input.setWithdrawalType(WithdrawalType.R);
		input.setPassword(null);
		input.setCommissionClientName(null);
		input.setProdNo("17300001");
		input.setAttrKey("支取方式");
		ST052OutputBO result = st052Pbc.execute(input);
		assertEquals("17300001", client.requestedProdNo);
		assertEquals("支取方式", client.requestedAttrKey);
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("通过", result.getCheckResult());
	}
}

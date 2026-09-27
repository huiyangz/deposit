package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;

/**
 * ST036 设置允许转久悬标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST036-TC001 ~ ST036-TC004）
 *
 * 工程约束（outputs/test-results.md 反馈）：测试环境 JVM 为 Java 26，Spring Boot 3.4.3
 * 自带的 Byte Buddy 最高支持 Java 24，Mockito inline mockmaker 无法 mock
 * ExternalTaskClient 等具体类（mock 接口不受影响）。故不使用 @Mock，改为测试内
 * 子类桩重写 queryProductInfo 固定返回值并记录实参，不触达真实网络。
 */
public class ST036PbcTest {

	/**
	 * ExternalTaskClient 测试桩：按构造值返回产品[是否允许转久悬]，并记录调用实参
	 */
	private static class StubExternalTaskClient extends ExternalTaskClient {

		private final String prodAllowSuspendFlag;
		private String invokedProdNo;
		private String invokedAttrKey;

		StubExternalTaskClient(String prodAllowSuspendFlag) {
			super(null);
			this.prodAllowSuspendFlag = prodAllowSuspendFlag;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			this.invokedProdNo = prodNo;
			this.invokedAttrKey = attrKey;
			return prodAllowSuspendFlag;
		}
	}

	private ST036InputBO buildInput(String allowSuspendFlag) {
		ST036InputBO input = new ST036InputBO();
		input.setProdNo("PD0001");
		input.setAttrKey("ALLOW_SUSPEND_FLAG");
		input.setAllowSuspendFlag(allowSuspendFlag);
		return input;
	}

	private ST036OutputBO executeWithProductFlag(String prodAllowSuspendFlag, String allowSuspendFlag) {
		StubExternalTaskClient externalTaskClient = new StubExternalTaskClient(prodAllowSuspendFlag);
		ST036Pbc st036Pbc = new ST036Pbc(externalTaskClient);
		ST036OutputBO output = st036Pbc.execute(buildInput(allowSuspendFlag));
		// 子步骤1：prodNo/attrKey 原样透传给产品管理《查询产品信息》（对应用例表的精确匹配实参）
		assertEquals("PD0001", externalTaskClient.invokedProdNo);
		assertEquals("ALLOW_SUSPEND_FLAG", externalTaskClient.invokedAttrKey);
		return output;
	}

	// TC001 子步骤2a：输入{允许账户转久悬标志}与产品[是否允许转久悬]均为空，默认赋值“Y-是”编码部分"Y"
	@Test
	public void testST036T01() {
		ST036OutputBO output = executeWithProductFlag(null, null);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("Y", output.getAllowSuspendFlag());
	}

	// TC002 子步骤2b：输入{允许账户转久悬标志}为空且产品[是否允许转久悬]="N"，回填产品值
	@Test
	public void testST036T02() {
		ST036OutputBO output = executeWithProductFlag("N", null);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("N", output.getAllowSuspendFlag());
	}

	// TC003 子步骤2c：输入{允许账户转久悬标志}="N"与产品[是否允许转久悬]="Y"均非空，输入优先保留输入值
	@Test
	public void testST036T03() {
		ST036OutputBO output = executeWithProductFlag("Y", "N");
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("N", output.getAllowSuspendFlag());
	}

	// TC004 子步骤2d：输入{允许账户转久悬标志}="N"非空且产品[是否允许转久悬]为空，保留输入值
	@Test
	public void testST036T04() {
		ST036OutputBO output = executeWithProductFlag(null, "N");
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("N", output.getAllowSuspendFlag());
	}
}

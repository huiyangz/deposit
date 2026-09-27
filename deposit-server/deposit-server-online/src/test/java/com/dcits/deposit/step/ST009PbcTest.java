package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;

/**
 * ST009 检查现金存入账户限制 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST009-TC001 ~ ST009-TC008）。
 * 仅对当前路径实际触达的外部方法设桩，跳转、提前返回未触达的方法不设桩；
 * 请求字段核对通过桩内记录请求后断言业务数据实现。
 *
 * 桩实现说明：outputs/test-results.md 证据显示测试节点 JDK 26 上 Mockito 5.14.2
 * （ByteBuddy 1.15.11）无法模拟具体类 ExternalTaskClient（inline mock maker 需
 * retransform JDK 26 的 java.lang.Object，超出该 ByteBuddy 支持的类文件版本，
 * 报 "Mockito cannot mock this class"）。工程约定不改 POM 与依赖版本，
 * 故以手写桩子类覆写六个检查限制组件方法代替 @Mock：不发起真实 HTTP 调用，
 * 设桩、请求记录与响应语义与 Mockito 桩一致；未设桩方法被触达时直接失败。
 */
public class ST009PbcTest {

	private final StubExternalTaskClient externalTaskClient = new StubExternalTaskClient();

	private final ST009Pbc st009Pbc = new ST009Pbc(externalTaskClient);

	private ST009InputBO buildInput() {
		ST009InputBO input = new ST009InputBO();
		input.setBaseAcctNo("2000010035981");
		input.setTranType(TranType.VALUE_1000);
		input.setChannelNo("01");
		input.setProdNo("P2026001");
		input.setNarrativeCode("N001");
		return input;
	}

	/** 按键值对构建外部响应Map */
	private Map<String, Object> resp(Object... keyValues) {
		Map<String, Object> map = new HashMap<>();
		for (int i = 0; i < keyValues.length; i += 2) {
			map.put((String) keyValues[i], keyValues[i + 1]);
		}
		return map;
	}

	/**
	 * ExternalTaskClient 测试桩：覆写本步骤触达的六个检查限制组件方法，
	 * 按步骤编号设桩并记录请求；未设桩方法被触达时抛 AssertionError 使测试失败。
	 * 不经过 RestTemplate，不发起真实调用。
	 */
	private static final class StubExternalTaskClient extends ExternalTaskClient {

		/** 按步骤编号设定的响应 */
		private final Map<String, Map<String, Object>> responses = new HashMap<>();
		/** 按步骤编号记录的实际请求 */
		private final Map<String, Map<String, Object>> requests = new HashMap<>();

		StubExternalTaskClient() {
			super(null);
		}

		/** 为指定外部步骤设桩响应 */
		void stub(String stepId, Map<String, Object> response) {
			responses.put(stepId, response);
		}

		/** 读取指定外部步骤实际收到的请求 */
		Map<String, Object> capturedRequest(String stepId) {
			return requests.get(stepId);
		}

		private Map<String, Object> handle(String stepId, Map<String, Object> bo) {
			requests.put(stepId, bo);
			Map<String, Object> response = responses.get(stepId);
			if (response == null) {
				throw new AssertionError("触达未设桩的外部调用: /steps/" + stepId);
			}
			return response;
		}

		@Override
		public Map<String, Object> executeValidationST005(Map<String, Object> bo) {
			return handle("ST005", bo);
		}

		@Override
		public Map<String, Object> executeValidationST014(Map<String, Object> bo) {
			return handle("ST014", bo);
		}

		@Override
		public Map<String, Object> executeValidationST008(Map<String, Object> bo) {
			return handle("ST008", bo);
		}

		@Override
		public Map<String, Object> executeValidationST015(Map<String, Object> bo) {
			return handle("ST015", bo);
		}

		@Override
		public Map<String, Object> executeValidationST011(Map<String, Object> bo) {
			return handle("ST011", bo);
		}

		@Override
		public Map<String, Object> executeValidationST002(Map<String, Object> bo) {
			return handle("ST002", bo);
		}
	}

	// TC001 账户无限制记录：《检查账户是否存在限制》返回[账户限制信息]为空，子步骤2提前返回检查结果通过
	@Test
	public void testST009T01() {
		externalTaskClient.stub("ST005", resp("succeed", Boolean.TRUE));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getCashNonReceiptNonPaymentFlag());
		assertNull(output.getCashStopReceiptFlag());
		assertNull(output.getNatureRestraintFlag());
		assertNull(output.getRestraintType());
		assertNull(output.getRestraintsStatus());
	}

	// TC002 存在现金不收不付限制：[账户限制信息]非空（可疑账户处置-不收不付/已批准），现金不收不付限制标志=是，子步骤4返回 ER0043
	@Test
	public void testST009T02() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "17", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "是"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertFalse(output.isSucceed());
		assertEquals("ER0043", output.getErrorCode());
		assertEquals("是", output.getCashNonReceiptNonPaymentFlag());
		assertEquals(RestraintType.VALUE_17, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		assertNull(output.getCashStopReceiptFlag());
		assertNull(output.getNatureRestraintFlag());
	}

	// TC003 存在现金止收限制：现金不收不付限制标志=否、现金止收标志=是，子步骤6返回 ER0044
	@Test
	public void testST009T03() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "13", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "是"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertFalse(output.isSucceed());
		assertEquals("ER0044", output.getErrorCode());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("是", output.getCashStopReceiptFlag());
		assertEquals(RestraintType.VALUE_13, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		assertNull(output.getNatureRestraintFlag());
	}

	// TC004 属性限制跳转后豁免通过：属性限制标志=是跳转至《获取限制豁免信息》（跳过子步骤9、10），《检查限制豁免》返回执行结果=豁免，返回通过
	@Test
	public void testST009T04() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "21", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "否"));
		externalTaskClient.stub("ST015",
				resp("succeed", Boolean.TRUE, "natureRestraintFlag", "是"));
		externalTaskClient.stub("ST002",
				resp("succeed", Boolean.TRUE, "executeResult", "豁免"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("否", output.getCashStopReceiptFlag());
		assertEquals("是", output.getNatureRestraintFlag());
		assertEquals(RestraintType.VALUE_21, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		// 断言《检查是否存在属性限制》请求携带[账户限制信息]（限制类型=21、限制状态=A）
		assertEquals("21", externalTaskClient.capturedRequest("ST015").get("restraintType"));
		assertEquals("A", externalTaskClient.capturedRequest("ST015").get("restraintsStatus"));
	}

	// TC005 属性限制跳转后未豁免：属性限制标志=是跳转至《获取限制豁免信息》，《检查限制豁免》返回执行结果=不豁免，子步骤12返回 ER0045
	@Test
	public void testST009T05() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "21", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "否"));
		externalTaskClient.stub("ST015",
				resp("succeed", Boolean.TRUE, "natureRestraintFlag", "是"));
		externalTaskClient.stub("ST002",
				resp("succeed", Boolean.TRUE, "executeResult", "不豁免"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertFalse(output.isSucceed());
		assertEquals("ER0045", output.getErrorCode());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("否", output.getCashStopReceiptFlag());
		assertEquals("是", output.getNatureRestraintFlag());
		assertEquals(RestraintType.VALUE_21, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
	}

	// TC006 无属性限制且不需检查限制：属性限制标志=否继续执行，《检查限制优先级》返回检查结果=不检查限制，子步骤10提前返回通过
	@Test
	public void testST009T06() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "6", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "否"));
		externalTaskClient.stub("ST015",
				resp("succeed", Boolean.TRUE, "natureRestraintFlag", "否"));
		externalTaskClient.stub("ST011",
				resp("succeed", Boolean.TRUE, "checkResult", "不检查限制"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("否", output.getCashStopReceiptFlag());
		assertEquals("否", output.getNatureRestraintFlag());
		assertEquals(RestraintType.VALUE_6, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
	}

	// TC007 全流程最长成功路径：属性限制标志=否，《检查限制优先级》返回检查结果=检查限制，《检查限制豁免》返回执行结果=豁免，返回通过（触达全部子步骤1→12）
	@Test
	public void testST009T07() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "6", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "否"));
		externalTaskClient.stub("ST015",
				resp("succeed", Boolean.TRUE, "natureRestraintFlag", "否"));
		externalTaskClient.stub("ST011",
				resp("succeed", Boolean.TRUE, "checkResult", "检查限制"));
		externalTaskClient.stub("ST002",
				resp("succeed", Boolean.TRUE, "executeResult", "豁免"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("否", output.getCashStopReceiptFlag());
		assertEquals("否", output.getNatureRestraintFlag());
		assertEquals(RestraintType.VALUE_6, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		// 断言《检查限制优先级》请求携带 交易类型=1000 与 限制类型=6
		assertEquals("1000", externalTaskClient.capturedRequest("ST011").get("tranType"));
		assertEquals("6", externalTaskClient.capturedRequest("ST011").get("restraintType"));
		// 断言《检查限制豁免》请求携带 限制类型=6、交易类型=1000、交易渠道编号=01、产品编号=P2026001、摘要码=N001
		assertEquals("6", externalTaskClient.capturedRequest("ST002").get("restraintType"));
		assertEquals("1000", externalTaskClient.capturedRequest("ST002").get("tranType"));
		assertEquals("01", externalTaskClient.capturedRequest("ST002").get("channelNo"));
		assertEquals("P2026001", externalTaskClient.capturedRequest("ST002").get("prodNo"));
		assertEquals("N001", externalTaskClient.capturedRequest("ST002").get("narrativeCode"));
	}

	// TC008 优先级检查后未豁免：检查结果=检查限制继续执行，《检查限制豁免》返回执行结果=不豁免，子步骤12返回 ER0045（触达全部子步骤1→12）
	@Test
	public void testST009T08() {
		externalTaskClient.stub("ST005",
				resp("succeed", Boolean.TRUE, "restraintType", "6", "restraintsStatus", "A"));
		externalTaskClient.stub("ST014",
				resp("succeed", Boolean.TRUE, "cashNonReceiptNonPaymentFlag", "否"));
		externalTaskClient.stub("ST008",
				resp("succeed", Boolean.TRUE, "cashStopReceiptFlag", "否"));
		externalTaskClient.stub("ST015",
				resp("succeed", Boolean.TRUE, "natureRestraintFlag", "否"));
		externalTaskClient.stub("ST011",
				resp("succeed", Boolean.TRUE, "checkResult", "检查限制"));
		externalTaskClient.stub("ST002",
				resp("succeed", Boolean.TRUE, "executeResult", "不豁免"));
		ST009OutputBO output = st009Pbc.execute(buildInput());
		assertFalse(output.isSucceed());
		assertEquals("ER0045", output.getErrorCode());
		assertEquals("否", output.getCashNonReceiptNonPaymentFlag());
		assertEquals("否", output.getCashStopReceiptFlag());
		assertEquals("否", output.getNatureRestraintFlag());
		assertEquals(RestraintType.VALUE_6, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
	}
}

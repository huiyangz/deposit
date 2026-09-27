package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;

/**
 * ST040 检查允许转久悬标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST040-TC001 ~ ST040-TC008）
 *
 * 桩边界说明：按 outputs/test-results.md 两轮反馈，本机 JDK 26 下工程内 Mockito
 * inline mock 无法 instrument 具体类——第一轮 @Mock ExternalTaskClient、第二轮
 * @Mock RestTemplate 均报 "Mockito cannot mock this class"，同批仅 mock 接口的
 * ST042PbcTest 全部通过；工程约束不允许改 POM 升级依赖，且 ExternalTaskClient
 * 无对应接口。故改为测试内桩子类覆写 queryProductInfo：仅当（产品编号、参数KEY值）
 * 精确等于（PD0001、ALLOW_DORMANT_FLAG）时返回预设值，否则返回 null。与用例集
 * "按精确参数设桩"语义一致：被测实现传参映射错误时桩不命中（返回 null），
 * 仍可暴露产品编号/参数KEY值映射缺陷。
 */
@ExtendWith(MockitoExtension.class)
public class ST040PbcTest {

	/**
	 * 跨组件客户端桩：真实继承 ExternalTaskClient，仅覆写《查询产品信息》调用，
	 * 按精确参数返回预设的[是否允许转久悬]标志。
	 */
	private static class StubExternalTaskClient extends ExternalTaskClient {

		/** 《查询产品信息》预设返回值（是否允许转久悬），可取 Y/N/null/空字符串 */
		private final String queryResult;

		StubExternalTaskClient(String queryResult) {
			super(new RestTemplate());
			this.queryResult = queryResult;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			if ("PD0001".equals(prodNo) && "ALLOW_DORMANT_FLAG".equals(attrKey)) {
				return queryResult;
			}
			return null;
		}
	}

	private ST040InputBO buildInput(String allowSuspendFlag) {
		ST040InputBO input = new ST040InputBO();
		input.setAllowSuspendFlag(allowSuspendFlag);
		input.setProdNo("PD0001");
		input.setAttrKey("ALLOW_DORMANT_FLAG");
		return input;
	}

	private ST040Pbc buildPbc(String allowDormantFlag) {
		return new ST040Pbc(new StubExternalTaskClient(allowDormantFlag));
	}

	// TC001 账户允许转久悬（Y）且产品允许转久悬（Y），BR003 分支 c 返回是，返回检查结果"通过"
	@Test
	public void testST040T01() {
		ST040OutputBO output = buildPbc("Y").execute(buildInput("Y"));
		assertTrue(output.isSucceed());
		assertEquals("通过", output.getCheckResult());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC002 账户不允许转久悬（N）且产品属性为 N（非空，不命中 BR003 分支 b），BR003 分支 c 返回是，返回检查结果"通过"
	@Test
	public void testST040T02() {
		ST040OutputBO output = buildPbc("N").execute(buildInput("N"));
		assertTrue(output.isSucceed());
		assertEquals("通过", output.getCheckResult());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC003 账户不允许转久悬（N）且产品允许转久悬（Y），BR003 分支 c 返回是，返回检查结果"通过"
	@Test
	public void testST040T03() {
		ST040OutputBO output = buildPbc("Y").execute(buildInput("N"));
		assertTrue(output.isSucceed());
		assertEquals("通过", output.getCheckResult());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC004 跨组件查询返回 null（空值边界），账户允许转久悬（Y）不命中分支 a/b，BR003 分支 c 返回是，返回检查结果"通过"
	@Test
	public void testST040T04() {
		ST040OutputBO output = buildPbc(null).execute(buildInput("Y"));
		assertTrue(output.isSucceed());
		assertEquals("通过", output.getCheckResult());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC005 跨组件查询返回空字符串（空值边界，产品定义查不到该参数KEY），账户允许转久悬（Y），BR003 分支 c 返回是，返回检查结果"通过"
	@Test
	public void testST040T05() {
		ST040OutputBO output = buildPbc("").execute(buildInput("Y"));
		assertTrue(output.isSucceed());
		assertEquals("通过", output.getCheckResult());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC006 账户允许转久悬（Y）但产品不允许转久悬（N），命中 BR003 分支 a 返回否，返回错误码 ER0030
	@Test
	public void testST040T06() {
		ST040OutputBO output = buildPbc("N").execute(buildInput("Y"));
		assertFalse(output.isSucceed());
		assertEquals("ER0030", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0030::"));
		assertNull(output.getCheckResult());
	}

	// TC007 账户不允许转久悬（N）且查询返回 null，命中 BR003 分支 b（空-null）返回否，返回错误码 ER0030
	@Test
	public void testST040T07() {
		ST040OutputBO output = buildPbc(null).execute(buildInput("N"));
		assertFalse(output.isSucceed());
		assertEquals("ER0030", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0030::"));
		assertNull(output.getCheckResult());
	}

	// TC008 账户不允许转久悬（N）且查询返回空字符串，命中 BR003 分支 b（空-空字符串）返回否，返回错误码 ER0030
	@Test
	public void testST040T08() {
		ST040OutputBO output = buildPbc("").execute(buildInput("N"));
		assertFalse(output.isSucceed());
		assertEquals("ER0030", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0030::"));
		assertNull(output.getCheckResult());
	}
}

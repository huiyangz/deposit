package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;

/**
 * ST049 检查账户执行利率 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST049-TC001 ~ ST049-TC008）。
 *
 * 工程约束：测试节点 JVM（OpenJDK 26，class file 70）高于工程 Mockito/Byte Buddy
 * 支持上限（Java 24），任何 Mockito mock 创建即失败（历史 outputs/test-results.md
 * 结论，ST029/ST052 测试同因），且本节点不得修改 POM 或新增依赖。故不使用 Mockito，
 * 以手写 {@link ExternalTaskClient} 桩子类隔离外部依赖：按真实签名覆写
 * queryProductInterestRate，参数与既定产品编号精确匹配时返回构造时给定的响应Map，
 * 等价实现用例表中 Mockito 精确参数设桩对请求仅按{产品编号}映射的核对；桩同时
 * 记录收到的产品编号，由各用例断言请求字段映射。
 */
public class ST049PbcTest {

	/**
	 * ExternalTaskClient 手写桩：仅重写 queryProductInterestRate，参数与既定产品编号
	 * 精确匹配时返回既定响应Map，否则返回 null（等价于用例表中
	 * when(queryProductInterestRate("8800001")).thenReturn(响应) 的精确参数桩）。
	 * 被重写方法不触及 restTemplate，父类构造器传入 null 不影响本测试。
	 */
	private static class ExternalTaskClientStub extends ExternalTaskClient {

		/** 既定的产品编号参数 */
		private final String expectedProdNo;

		/** 参数精确匹配时返回的《查询产品利率信息》响应 */
		private final Map<String, Object> returnedResponse;

		/** 桩收到的产品编号 */
		String requestedProdNo;

		ExternalTaskClientStub(String expectedProdNo, Map<String, Object> returnedResponse) {
			super(null);
			this.expectedProdNo = expectedProdNo;
			this.returnedResponse = returnedResponse;
		}

		@Override
		public Map<String, Object> queryProductInterestRate(String prodNo) {
			this.requestedProdNo = prodNo;
			if (Objects.equals(expectedProdNo, prodNo)) {
				return returnedResponse;
			}
			return null;
		}
	}

	/**
	 * 构造《查询产品利率信息》响应Map：intTypeList=[DR1]、产品利率 0.013500 固定，
	 * 最小/最大执行利率按入参放置，传 null 表示响应缺失该键（取值为空）。
	 */
	private static Map<String, Object> rateResponse(String minExecRate, String maxExecRate) {
		Map<String, Object> response = new HashMap<>();
		response.put("intTypeList", Arrays.asList("DR1"));
		response.put("prodIntRate", "0.013500");
		if (minExecRate != null) {
			response.put("minExecRate", minExecRate);
		}
		if (maxExecRate != null) {
			response.put("maxExecRate", maxExecRate);
		}
		return response;
	}

	// 产品8800001已配置利率（下限0.012000、上限0.015000），执行利率0.013500落在区间内，检查通过并原样输出执行利率
	@Test
	public void testST049T01() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.013500"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.013500"), output.getRealRate());
	}

	// 执行利率0.012000等于最小执行利率（同值同标度），“小于最小执行利率”不成立，边界通过
	@Test
	public void testST049T02() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.012000"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.012000"), output.getRealRate());
	}

	// 执行利率0.015000等于最大执行利率（同值同标度），“大于最大执行利率”不成立，边界通过
	@Test
	public void testST049T03() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.015000"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.015000"), output.getRealRate());
	}

	// 执行利率0.016000大于最大执行利率0.015000（且大于下限，隔离“大于上限”分支），预期返回ER0033
	@Test
	public void testST049T04() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.016000"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertFalse(output.isSucceed());
		assertEquals("ER0033", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0033::"));
	}

	// 执行利率0.011000小于最小执行利率0.012000（隔离“小于下限”分支），预期返回ER0033
	@Test
	public void testST049T05() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.011000"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertFalse(output.isSucceed());
		assertEquals("ER0033", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0033::"));
	}

	// 产品8800099无利率配置，查询返回空Map，最大、最小执行利率均为空（未查询到产品利率信息），预期返回ER0033
	@Test
	public void testST049T06() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800099",
				new HashMap<String, Object>());
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.013500"));
		input.setProdNo("8800099");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800099", client.requestedProdNo);
		assertFalse(output.isSucceed());
		assertEquals("ER0033", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0033::"));
	}

	// 响应含maxExecRate但缺失minExecRate键（执行利率0.013500在已有界限内），“最小执行利率为空”单独成立，预期返回ER0033
	@Test
	public void testST049T07() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse(null, "0.015000"));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.013500"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertFalse(output.isSucceed());
		assertEquals("ER0033", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0033::"));
	}

	// 响应含minExecRate但缺失maxExecRate键（执行利率0.013500在已有界限内），“最大执行利率为空”单独成立，预期返回ER0033
	@Test
	public void testST049T08() {
		ExternalTaskClientStub client = new ExternalTaskClientStub("8800001",
				rateResponse("0.012000", null));
		ST049Pbc st049Pbc = new ST049Pbc(client);
		ST049InputBO input = new ST049InputBO();
		input.setRealRate(new BigDecimal("0.013500"));
		input.setProdNo("8800001");
		input.setIntType(IntType.DR1);
		ST049OutputBO output = st049Pbc.execute(input);
		assertEquals("8800001", client.requestedProdNo);
		assertFalse(output.isSucceed());
		assertEquals("ER0033", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0033::"));
	}
}

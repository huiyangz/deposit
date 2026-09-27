package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.facade.bo.ST029InputBO;
import com.dcits.deposit.facade.bo.ST029OutputBO;

/**
 * ST029 设置通兑标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST029-TC001 ~ ST029-TC003）。
 *
 * 工程约束：outputs/test-results.md 三例失败根因是测试 JVM（OpenJDK 26.0.2，
 * class file 70）高于工程自带 Mockito/Byte Buddy 支持上限（Java 24），
 * 任何 Mockito mock 在重转换 java.lang.Object 时即失败；本机亦无可用的更低版本
 * JDK。故不使用 Mockito，以手写 {@link ExternalTaskClient} 桩子类隔离外部依赖，
 * 按用例表的输入构造、桩返回值与断言执行，桩保持真实方法签名与精确参数匹配语义。
 */
public class ST029PbcTest {

	/**
	 * ExternalTaskClient 手写桩：仅重写 queryProductInfo，参数与既定产品编号、
	 * 参数KEY值精确匹配时返回既定属性值，否则返回 null（等价于用例表中
	 * when(queryProductInfo("P2026001", "ALL_DRA_IND")).thenReturn(值) 的精确参数桩）。
	 * 被重写方法不触及 restTemplate，父类构造器传入 null 不影响本测试。
	 */
	private static class ExternalTaskClientStub extends ExternalTaskClient {

		/** 既定的产品编号参数 */
		private final String expectedProdNo;

		/** 既定的参数KEY值参数 */
		private final String expectedAttrKey;

		/** 参数精确匹配时的返回属性值 */
		private final String returnedAttrValue;

		ExternalTaskClientStub(String expectedProdNo, String expectedAttrKey, String returnedAttrValue) {
			super(null);
			this.expectedProdNo = expectedProdNo;
			this.expectedAttrKey = expectedAttrKey;
			this.returnedAttrValue = returnedAttrValue;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			if (Objects.equals(expectedProdNo, prodNo) && Objects.equals(expectedAttrKey, attrKey)) {
				return returnedAttrValue;
			}
			return null;
		}
	}

	// 输入通兑标志为空，产品管理返回有效属性值 N002，子步骤2条件成立，输出赋产品通兑标志，预期成功且错误字段为空
	@Test
	public void testST029T01() {
		ST029Pbc st029Pbc = new ST029Pbc(new ExternalTaskClientStub("P2026001", "ALL_DRA_IND", "N002"));
		ST029InputBO input = new ST029InputBO();
		input.setAllDraInd(null);
		input.setProdNo("P2026001");
		input.setAttrKey("ALL_DRA_IND");
		input.setAttrValue("N002");
		ST029OutputBO output = st029Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AllDraInd.N002, output.getAllDraInd());
	}

	// 输入通兑标志非空（N001），子步骤2条件不成立不执行赋值，输出保留输入值，产品返回值 N003 不被采用
	@Test
	public void testST029T02() {
		ST029Pbc st029Pbc = new ST029Pbc(new ExternalTaskClientStub("P2026001", "ALL_DRA_IND", "N003"));
		ST029InputBO input = new ST029InputBO();
		input.setAllDraInd(AllDraInd.N001);
		input.setProdNo("P2026001");
		input.setAttrKey("ALL_DRA_IND");
		input.setAttrValue("N003");
		ST029OutputBO output = st029Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AllDraInd.N001, output.getAllDraInd());
	}

	// 输入通兑标志为空且产品属性未配置（外部返回 null），赋值结果为 null，无业务失败场景仍返回成功
	@Test
	public void testST029T03() {
		ST029Pbc st029Pbc = new ST029Pbc(new ExternalTaskClientStub("P2026001", "ALL_DRA_IND", null));
		ST029InputBO input = new ST029InputBO();
		input.setAllDraInd(null);
		input.setProdNo("P2026001");
		input.setAttrKey("ALL_DRA_IND");
		input.setAttrValue("N002");
		ST029OutputBO output = st029Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getAllDraInd());
	}
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;

/**
 * ST025 检查币种 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST025-TC001 ~ ST025-TC005）
 */
public class ST025PbcTest {

	static {
		// 工程约束：测试 JVM 为 Java 26（class 文件版本 70），Boot 3.4.3 随带的 Byte Buddy 1.15.11
		// 官方仅支持到 Java 24（68），inline mock 重转换 java.lang.Object 时被拒并报
		// "Java 26 (70) is not supported ... set net.bytebuddy.experimental as a VM property"。
		// 该开关由 OpenedClassReader 在类初始化时惰性读取，须在首个 Mockito.mock 之前设置；
		// 不改 POM、不加依赖，桩配置与断言保持不变。
		System.setProperty("net.bytebuddy.experimental", "true");
	}

	// TC001：产品配置多币种集合（CNY,USD,EUR），输入币种USD为其中非首位元素，检查通过
	@Test
	public void testST025T01() {
		ExternalTaskClient client = Mockito.mock(ExternalTaskClient.class);
		Mockito.when(client.queryProductInfo("PD0001", "CCY")).thenReturn("CNY,USD,EUR");
		ST025Pbc step = new ST025Pbc(client);

		ST025InputBO input = new ST025InputBO();
		input.setCcy(Ccy.USD);
		input.setProdNo("PD0001");
		input.setAttrKey("CCY");

		ST025OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC002：产品仅配置单一币种CNY且与输入币种一致（最小非空集合命中），检查通过
	@Test
	public void testST025T02() {
		ExternalTaskClient client = Mockito.mock(ExternalTaskClient.class);
		Mockito.when(client.queryProductInfo("PD0001", "CCY")).thenReturn("CNY");
		ST025Pbc step = new ST025Pbc(client);

		ST025InputBO input = new ST025InputBO();
		input.setCcy(Ccy.CNY);
		input.setProdNo("PD0001");
		input.setAttrKey("CCY");

		ST025OutputBO output = step.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC003：产品币种集合（CNY,USD,EUR）不含输入币种JPY，检查失败返回错误码ER0023
	@Test
	public void testST025T03() {
		ExternalTaskClient client = Mockito.mock(ExternalTaskClient.class);
		Mockito.when(client.queryProductInfo("PD0002", "CCY")).thenReturn("CNY,USD,EUR");
		ST025Pbc step = new ST025Pbc(client);

		ST025InputBO input = new ST025InputBO();
		input.setCcy(Ccy.JPY);
		input.setProdNo("PD0002");
		input.setAttrKey("CCY");

		ST025OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0023", output.getErrorCode());
	}

	// TC004：产品未配置该参数KEY，依赖按契约返回空串即空集合，不含输入币种，检查失败返回错误码ER0023
	@Test
	public void testST025T04() {
		ExternalTaskClient client = Mockito.mock(ExternalTaskClient.class);
		Mockito.when(client.queryProductInfo("PD0003", "CCY")).thenReturn("");
		ST025Pbc step = new ST025Pbc(client);

		ST025InputBO input = new ST025InputBO();
		input.setCcy(Ccy.CNY);
		input.setProdNo("PD0003");
		input.setAttrKey("CCY");

		ST025OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0023", output.getErrorCode());
	}

	// TC005：输入币种USD仅与集合元素USDD构成子串关系而非相同元素，「集合包含」按元素精确匹配判定为不包含，检查失败返回错误码ER0023
	@Test
	public void testST025T05() {
		ExternalTaskClient client = Mockito.mock(ExternalTaskClient.class);
		Mockito.when(client.queryProductInfo("PD0004", "CCY")).thenReturn("CNY,USDD,EUR");
		ST025Pbc step = new ST025Pbc(client);

		ST025InputBO input = new ST025InputBO();
		input.setCcy(Ccy.USD);
		input.setProdNo("PD0004");
		input.setAttrKey("CCY");

		ST025OutputBO output = step.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0023", output.getErrorCode());
	}
}

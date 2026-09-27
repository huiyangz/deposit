package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;

/**
 * ST006 检查存入交易类型 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST006-TC001 ~ ST006-TC003）
 *
 * 本步骤为纯输入检查，无 BCC、规则或跨组件依赖，无需设桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST006PbcTest {

	@InjectMocks
	private ST006Pbc st006Pbc;

	// 场景：活期现金存入场景下交易类型等于“现金存入”（VALUE_1000），检查通过
	@Test
	public void testST006T01() {
		ST006InputBO input = new ST006InputBO();
		input.setTranType(TranType.VALUE_1000);

		ST006OutputBO result = st006Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
	}

	// 场景：交易类型为现金支取（VALUE_1003），不等于“现金存入”，返回错误码 ER0049
	@Test
	public void testST006T02() {
		ST006InputBO input = new ST006InputBO();
		input.setTranType(TranType.VALUE_1003);

		ST006OutputBO result = st006Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0049", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0049::"));
	}

	// 场景：交易类型为现金存入-冲销（VALUE_1001），编码与名称均邻近“现金存入”但不是该类型，同样返回错误码 ER0049
	@Test
	public void testST006T03() {
		ST006InputBO input = new ST006InputBO();
		input.setTranType(TranType.VALUE_1001);

		ST006OutputBO result = st006Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0049", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0049::"));
	}
}

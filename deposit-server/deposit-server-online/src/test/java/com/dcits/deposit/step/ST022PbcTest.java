package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;

/**
 * ST022 检查现金项目编号 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST022-TC001 ~ ST022-TC003）
 *
 * 本步骤为纯输入检查，无 BCC、规则或跨组件依赖，无需设桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST022PbcTest {

	@InjectMocks
	private ST022Pbc st022Pbc;

	// 场景：现金存入交易携带现金项目“储蓄存款收入”，cashItem 非空，检查通过
	@Test
	public void testST022T01() {
		ST022InputBO input = new ST022InputBO();
		input.setTranType(TranType.VALUE_1000);
		input.setCashItem(CashItem.VALUE_5);

		ST022OutputBO result = st022Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
	}

	// 场景：现金项目编号为空（cashItem=null，枚举无“空”常量，为空即 null 引用），返回错误码 ER0056
	@Test
	public void testST022T02() {
		ST022InputBO input = new ST022InputBO();
		input.setTranType(TranType.VALUE_1000);
		input.setCashItem(null);

		ST022OutputBO result = st022Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0056", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0056::"));
	}

	// 场景：现金支取交易携带支出现金项目“储蓄存款支出”，验证通过判断仅依据 cashItem 非空、与现金项目取值方向无关
	@Test
	public void testST022T03() {
		ST022InputBO input = new ST022InputBO();
		input.setTranType(TranType.VALUE_1003);
		input.setCashItem(CashItem.VALUE_29);

		ST022OutputBO result = st022Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
	}
}

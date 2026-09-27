package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 设置贷记交易的借贷标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST017-TC001）
 *
 * 本步骤为纯赋值步骤，无 BCC、规则或跨组件依赖，无需设桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST017PbcTest {

	@InjectMocks
	private ST017Pbc st017Pbc;

	// 场景：贷记交易设置借贷标志，执行子步骤1 赋值借贷标志，输出 crDrInd 为“C-贷方”，步骤成功返回
	@Test
	public void testST017T01() {
		ST017InputBO input = new ST017InputBO();

		ST017OutputBO result = st017Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals(CrDrInd.C, result.getCrDrInd());
		// 编码值须为“C”（贷方）而非“D”（借方），验证贷方绑定
		assertEquals("C", result.getCrDrInd().getValue());
	}
}

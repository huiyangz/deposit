package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockMakers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;

/**
 * ST013 检查客户限制 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST013-TC001 ~ ST013-TC003）
 */
@ExtendWith(MockitoExtension.class)
public class ST013PbcTest {

	// ExternalTaskClient 为具体类：默认内联 mock maker 需改造类层次（含 JDK 26 的 java.lang.Object），
	// 本工程 ByteBuddy 1.15.11 不支持该类文件版本；子类 maker 只生成代理子类、不做类改造，可正常设桩
	@Mock(mockMaker = MockMakers.SUBCLASS)
	private ExternalTaskClient externalTaskClient;

	@InjectMocks
	private ST013Pbc st013Pbc;

	private ST013InputBO buildInput(String clientNo) {
		ST013InputBO input = new ST013InputBO();
		input.setClientNo(clientNo);
		return input;
	}

	// TC001 客户存在限制：子步骤1返回含限制三键的记录（状态"F"未生效、编号 RS20260920000123、类型"13"挂失止付），子步骤2映射至输出字段返回
	@Test
	public void testST013T01() {
		Map<String, Object> capturedRequest = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		response.put("succeed", true);
		response.put("restraintsStatus", "F");
		response.put("resSeqNo", "RS20260920000123");
		response.put("restraintType", "13");
		Mockito.lenient().when(externalTaskClient.executeValidationST001(Mockito.anyMap())).thenAnswer(invocation -> {
			capturedRequest.putAll(invocation.getArgument(0));
			return response;
		});
		ST013OutputBO output = st013Pbc.execute(buildInput("C1080001234567"));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(RestraintsStatus.F, output.getRestraintsStatus());
		assertEquals("RS20260920000123", output.getResSeqNo());
		assertEquals(RestraintType.VALUE_13, output.getRestraintType());
		assertEquals("C1080001234567", capturedRequest.get("clientNo"));
	}

	// TC002 客户无限制：子步骤1返回的记录不含限制三键，子步骤2判定[客户限制信息]等于空，返回检查结果"通过"，输出字段均为空
	@Test
	public void testST013T02() {
		Map<String, Object> response = new HashMap<>();
		response.put("succeed", true);
		Mockito.lenient().when(externalTaskClient.executeValidationST001(Mockito.anyMap())).thenReturn(response);
		ST013OutputBO output = st013Pbc.execute(buildInput("C1080007654321"));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getRestraintsStatus());
		assertNull(output.getResSeqNo());
		assertNull(output.getRestraintType());
	}

	// TC003 客户存在限制（另一组编码组合）：状态"A"已批准、编号 RS20260925000456、类型"4"统一查控平台全额止付，验证编码到枚举的映射不依赖单一常量
	@Test
	public void testST013T03() {
		Map<String, Object> response = new HashMap<>();
		response.put("succeed", true);
		response.put("restraintsStatus", "A");
		response.put("resSeqNo", "RS20260925000456");
		response.put("restraintType", "4");
		Mockito.lenient().when(externalTaskClient.executeValidationST001(Mockito.anyMap())).thenReturn(response);
		ST013OutputBO output = st013Pbc.execute(buildInput("C1080009998888"));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		assertEquals("RS20260925000456", output.getResSeqNo());
		assertEquals(RestraintType.VALUE_4, output.getRestraintType());
	}
}

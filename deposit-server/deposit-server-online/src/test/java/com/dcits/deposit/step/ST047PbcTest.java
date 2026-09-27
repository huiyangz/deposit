package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;

/**
 * ST047 设置通存标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST047-TC001 ~ ST047-TC003）
 *
 * 工程约束（test-results.md 反馈）：当前 JDK 下 Mockito 内联 mock 无法改写具体类
 * com.dcits.client.ExternalTaskClient（同批接口 mock 均通过，仅类 mock 失败），且约定
 * 不改 POM、不新增依赖。故不 mock 客户端，改为构造真实 ExternalTaskClient 并注入覆写
 * getForObject 的 RestTemplate 桩：以普通匿名子类实现，不经 Mockito/ByteBuddy 运行时
 * 改写；按「产品编号:参数KEY值」精确匹配返回属性值，未匹配返回空串，对齐《查询产品
 * 信息》查不到返回空串的接口契约。全程无真实网络访问。
 */
public class ST047PbcTest {

	/** 构造被测实例：RestTemplate 桩按「产品编号:参数KEY值」精确返回产品属性值 */
	private ST047Pbc newSt047Pbc(Map<String, String> productAttrValues) {
		RestTemplate restTemplate = new RestTemplate() {
			@Override
			public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) {
				String key = uriVariables[0] + ":" + uriVariables[1];
				String attrValue = productAttrValues.get(key);
				return responseType.cast(attrValue == null ? "" : attrValue);
			}
		};
		return new ST047Pbc(new ExternalTaskClient(restTemplate));
	}

	private ST047InputBO buildInput(AllDepInd allDepInd, String prodNo, String attrKey) {
		ST047InputBO input = new ST047InputBO();
		input.setAllDepInd(allDepInd);
		input.setProdNo(prodNo);
		input.setAttrKey(attrKey);
		return input;
	}

	// TC001 输入通存标识为空，取产品属性值：《查询产品信息》按 PD0001+ALL_DEP_IND 返回 "N001"，子步骤2空分支赋输出 AllDepInd.N001
	@Test
	public void testST047T01() {
		Map<String, String> attrValues = new HashMap<>();
		attrValues.put("PD0001:ALL_DEP_IND", "N001");
		ST047InputBO input = buildInput(null, "PD0001", "ALL_DEP_IND");
		ST047OutputBO output = newSt047Pbc(attrValues).execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AllDepInd.N001, output.getAllDepInd());
	}

	// TC002 输入通存标识非空，沿用输入值：远端返回 "N001" 仅作中间变量不采用，子步骤2非空分支赋输出为输入值 AllDepInd.N004
	@Test
	public void testST047T02() {
		Map<String, String> attrValues = new HashMap<>();
		attrValues.put("PD0002:ALL_DEP_IND", "N001");
		ST047InputBO input = buildInput(AllDepInd.N004, "PD0002", "ALL_DEP_IND");
		ST047OutputBO output = newSt047Pbc(attrValues).execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(AllDepInd.N004, output.getAllDepInd());
	}

	// TC003 输入通存标识为空且产品属性查询为空：《查询产品信息》按契约返回空串，经 AllDepInd.byValue 映射为 null，输出为空且步骤成功
	@Test
	public void testST047T03() {
		Map<String, String> attrValues = new HashMap<>();
		attrValues.put("PD0003:ALL_DEP_IND", "");
		ST047InputBO input = buildInput(null, "PD0003", "ALL_DEP_IND");
		ST047OutputBO output = newSt047Pbc(attrValues).execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getAllDepInd());
	}
}

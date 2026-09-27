package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/**
 * ST032 检查账户机构 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST032-TC001 ~ ST032-TC005）
 *
 * 工程约束：本工程 Mockito（Spring Boot 3.4.3，Mockito 5.14.x + Byte Buddy 1.15.x）在当前
 * JDK 26 下无法 mock 具体类（outputs/test-results.md：Mockito cannot mock this class:
 * com.dcits.client.ExternalTaskClient），mock 接口不受影响。不改 POM、不改共享客户端，
 * 对该具体类依赖改用手写桩子类，按真实方法签名以精确参数固定返回，用例输入与断言不变。
 */
public class ST032PbcTest {

	/**
	 * 《查询产品信息》客户端桩：按精确参数（prodNo、attrKey）固定返回属性值原值，
	 * 参数映射不符时以断言失败暴露
	 */
	private static final class StubExternalTaskClient extends ExternalTaskClient {

		private final String expectedProdNo;
		private final String expectedAttrKey;
		private final String attrValue;

		private StubExternalTaskClient(String expectedProdNo, String expectedAttrKey, String attrValue) {
			super(null);
			this.expectedProdNo = expectedProdNo;
			this.expectedAttrKey = expectedAttrKey;
			this.attrValue = attrValue;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			assertEquals(expectedProdNo, prodNo, "queryProductInfo 参数 prodNo 映射不符");
			assertEquals(expectedAttrKey, attrKey, "queryProductInfo 参数 attrKey 映射不符");
			return attrValue;
		}
	}

	private ST032Pbc newPbc(String prodNo, String attrKey, String attrValue) {
		return new ST032Pbc(new StubExternalTaskClient(prodNo, attrKey, attrValue));
	}

	private ST032InputBO buildInput(TranBranch tranBranch, String prodNo, String attrKey, String attrValue) {
		ST032InputBO input = new ST032InputBO();
		input.setTranBranch(tranBranch);
		input.setProdNo(prodNo);
		input.setAttrKey(attrKey);
		input.setAttrValue(attrValue);
		return input;
	}

	// TC001 产品配置多机构列表包含交易机构（VALUE_351155，机构编号与列表元素精确相等），检查通过
	@Test
	public void testST032T01() {
		ST032Pbc st032Pbc = newPbc("PD0001", "BRANCH_LIST", "351155,351156,351157");
		ST032InputBO input = buildInput(TranBranch.VALUE_351155, "PD0001", "BRANCH_LIST", "351155,351156,351157");
		ST032OutputBO output = st032Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC002 产品配置多机构列表不包含交易机构（VALUE_351158），返回错误码 ER0005
	@Test
	public void testST032T02() {
		ST032Pbc st032Pbc = newPbc("PD0001", "BRANCH_LIST", "351155,351156,351157");
		ST032InputBO input = buildInput(TranBranch.VALUE_351158, "PD0001", "BRANCH_LIST", "351155,351156,351157");
		ST032OutputBO output = st032Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0005", output.getErrorCode());
	}

	// TC003 产品定义表无该产品编号与参数KEY记录，外部接口按契约返回空串，机构列表为空，返回错误码 ER0005
	@Test
	public void testST032T03() {
		ST032Pbc st032Pbc = newPbc("PD9999", "BRANCH_LIST", "");
		ST032InputBO input = buildInput(TranBranch.VALUE_351155, "PD9999", "BRANCH_LIST", "");
		ST032OutputBO output = st032Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0005", output.getErrorCode());
	}

	// TC004 产品仅配置单个机构（无分隔符单元素）且等于交易机构（VALUE_351155），检查通过
	@Test
	public void testST032T04() {
		ST032Pbc st032Pbc = newPbc("PD0001", "BRANCH_LIST", "351155");
		ST032InputBO input = buildInput(TranBranch.VALUE_351155, "PD0001", "BRANCH_LIST", "351155");
		ST032OutputBO output = st032Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC005 交易机构编号（虚拟总行"0"）为列表元素"351155"的子串但不是任何列表元素，元素精确相等判断不通过，返回错误码 ER0005
	@Test
	public void testST032T05() {
		ST032Pbc st032Pbc = newPbc("PD0001", "BRANCH_LIST", "351155,351156");
		ST032InputBO input = buildInput(TranBranch.VALUE_0, "PD0001", "BRANCH_LIST", "351155,351156");
		ST032OutputBO output = st032Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0005", output.getErrorCode());
	}
}

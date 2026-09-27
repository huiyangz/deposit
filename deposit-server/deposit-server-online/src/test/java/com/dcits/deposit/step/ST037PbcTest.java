package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.components.IFmBranchCcyBcc;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;

/**
 * ST037 检查通兑标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST037-TC001 ~ ST037-TC005）。
 *
 * 工程约束（前续步骤 test-results 反馈沉淀）：测试 JVM 为 OpenJDK 26（class file 70），
 * Spring Boot 3.4.3 管理的 Mockito/Byte Buddy 最高支持 Java 24，具体类
 * com.dcits.client.ExternalTaskClient 的 Mockito mock 无法创建；且本节点不得修改
 * POM 或新增依赖。因此不使用 Mockito，改为手写桩子类/实现类并经构造器注入：
 * 产品客户端桩按真实签名覆写 queryProductInfo 并记录收到的 prodNo、attrKey，
 * 机构币种 BCC 桩按真实签名实现 findByEo 并记录收到的查询 EO 归属机构号，
 * 等价实现用例表中 Mockito 精确参数匹配对输入到依赖请求字段映射的核对。
 */
public class ST037PbcTest {

	/**
	 * 产品管理《查询产品信息》手写桩：仅覆写 queryProductInfo，记录收到的
	 * 产品编号、参数KEY值并返回构造时给定的属性值。RestTemplate 传 null：
	 * 被测路径只触达已覆写的方法，若误入未覆写的真实调用将快速失败。
	 */
	private static class StubExternalTaskClient extends ExternalTaskClient {

		/** queryProductInfo 固定返回的产品属性值 */
		private final String attrValue;

		/** 桩收到的产品编号 */
		private String requestedProdNo;

		/** 桩收到的参数KEY值 */
		private String requestedAttrKey;

		StubExternalTaskClient(String attrValue) {
			super(null);
			this.attrValue = attrValue;
		}

		@Override
		public String queryProductInfo(String prodNo, String attrKey) {
			this.requestedProdNo = prodNo;
			this.requestedAttrKey = attrKey;
			return attrValue;
		}
	}

	/**
	 * 机构币种 BCC 手写桩：仅实现 findByEo，记录收到的查询 EO 归属机构号并返回
	 * 构造时给定的[机构币种列表]；其余方法被测路径不触达，误入即快速失败。
	 */
	private static class StubFmBranchCcyBcc implements IFmBranchCcyBcc {

		/** findByEo 固定返回的机构币种列表 */
		private final List<FmBranchCcyEO> branchCcyList;

		/** 桩收到的查询 EO 的归属机构号 */
		private TranBranch requestedBranch;

		StubFmBranchCcyBcc(List<FmBranchCcyEO> branchCcyList) {
			this.branchCcyList = branchCcyList;
		}

		@Override
		public List<FmBranchCcyEO> findByEo(FmBranchCcyEO eo) {
			this.requestedBranch = eo.getBranch();
			return branchCcyList;
		}

		@Override
		public long countByEo(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 countByEo");
		}

		@Override
		public int removeByEo(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 removeByEo");
		}

		@Override
		public int removeByPrimaryKey(String branch, String ccy) {
			throw new UnsupportedOperationException("本测试不触达 removeByPrimaryKey");
		}

		@Override
		public int create(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 create");
		}

		@Override
		public int createSelective(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 createSelective");
		}

		@Override
		public FmBranchCcyEO findByPrimaryKey(String branch, String ccy) {
			throw new UnsupportedOperationException("本测试不触达 findByPrimaryKey");
		}

		@Override
		public int modifyByPrimaryKeySelective(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 modifyByPrimaryKeySelective");
		}

		@Override
		public int modifyByPrimaryKey(FmBranchCcyEO eo) {
			throw new UnsupportedOperationException("本测试不触达 modifyByPrimaryKey");
		}
	}

	/** 构造[机构币种列表]桩数据（仅设置业务判断使用的 branch、ccy 字段） */
	private static List<FmBranchCcyEO> branchCcyList(TranBranch branch, Ccy... ccys) {
		List<FmBranchCcyEO> list = new ArrayList<>();
		for (Ccy ccy : ccys) {
			FmBranchCcyEO eo = new FmBranchCcyEO();
			eo.setBranch(branch);
			eo.setCcy(ccy);
			list.add(eo);
		}
		return list;
	}

	/** 构造输入：attrValue 按用例基线保持 null（SPEC 未定义其使用场景） */
	private ST037InputBO buildInput(Ccy ccy, AllDraInd allDraInd, TranBranch allDraIntBranch) {
		ST037InputBO input = new ST037InputBO();
		input.setCcy(ccy);
		input.setAllDraInd(allDraInd);
		input.setAllDraIntBranch(allDraIntBranch);
		input.setProdNo("PD0001");
		input.setAttrKey("ALL_DRA_IND");
		return input;
	}

	// TC001 账户通兑标志非空（N001）且产品属性值非“N”：1→2a(继续)→3→4→5(其余情况) 全流程通过
	@Test
	public void testST037T01() {
		StubExternalTaskClient client = new StubExternalTaskClient("N001");
		StubFmBranchCcyBcc bcc = new StubFmBranchCcyBcc(
				branchCcyList(TranBranch.VALUE_351001, Ccy.CNY, Ccy.USD));
		ST037Pbc st037Pbc = new ST037Pbc(client, bcc);
		ST037InputBO input = buildInput(Ccy.CNY, AllDraInd.N001, TranBranch.VALUE_351001);
		ST037OutputBO output = st037Pbc.execute(input);
		assertEquals("PD0001", client.requestedProdNo);
		assertEquals("ALL_DRA_IND", client.requestedAttrKey);
		assertEquals(TranBranch.VALUE_351001, bcc.requestedBranch);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC002 产品[通兑标志]为“N-不允许通兑”（编码“N”）且账户通兑标志非空、不为不允许值（N003）：第2步a返回 ER0018，第3~5步不执行
	@Test
	public void testST037T02() {
		StubExternalTaskClient client = new StubExternalTaskClient("N");
		StubFmBranchCcyBcc bcc = new StubFmBranchCcyBcc(Collections.emptyList());
		ST037Pbc st037Pbc = new ST037Pbc(client, bcc);
		ST037InputBO input = buildInput(Ccy.CNY, AllDraInd.N003, TranBranch.VALUE_351001);
		ST037OutputBO output = st037Pbc.execute(input);
		assertEquals("PD0001", client.requestedProdNo);
		assertEquals("ALL_DRA_IND", client.requestedAttrKey);
		assertFalse(output.isSucceed());
		assertEquals("ER0018", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0018::"));
	}

	// TC003 账户{通兑标志}为空：第2步走 b 分支跳过产品通兑标志比较（产品侧即使为“N”也不返回 ER0018），1→2b→3→4→5 全流程通过
	@Test
	public void testST037T03() {
		StubExternalTaskClient client = new StubExternalTaskClient("N");
		StubFmBranchCcyBcc bcc = new StubFmBranchCcyBcc(
				branchCcyList(TranBranch.VALUE_351001, Ccy.CNY));
		ST037Pbc st037Pbc = new ST037Pbc(client, bcc);
		ST037InputBO input = buildInput(Ccy.CNY, null, TranBranch.VALUE_351001);
		ST037OutputBO output = st037Pbc.execute(input);
		assertEquals("PD0001", client.requestedProdNo);
		assertEquals("ALL_DRA_IND", client.requestedAttrKey);
		assertEquals(TranBranch.VALUE_351001, bcc.requestedBranch);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC004 机构币种查询返回空列表且账户{通兑标志}为空（不属第5步币种匹配范围）：检查通过（BCC 空结果边界）
	@Test
	public void testST037T04() {
		StubExternalTaskClient client = new StubExternalTaskClient("N001");
		StubFmBranchCcyBcc bcc = new StubFmBranchCcyBcc(Collections.emptyList());
		ST037Pbc st037Pbc = new ST037Pbc(client, bcc);
		ST037InputBO input = buildInput(Ccy.CNY, null, TranBranch.VALUE_351888);
		ST037OutputBO output = st037Pbc.execute(input);
		assertEquals(TranBranch.VALUE_351888, bcc.requestedBranch);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// TC005 账户{通兑标志}=N004（不属“分行间通兑/指定机构间通兑”检查范围）：账户币种 CNY 不在列表 [USD] 内，第5步不执行币种匹配，检查通过
	@Test
	public void testST037T05() {
		StubExternalTaskClient client = new StubExternalTaskClient("N001");
		StubFmBranchCcyBcc bcc = new StubFmBranchCcyBcc(
				branchCcyList(TranBranch.VALUE_351888, Ccy.USD));
		ST037Pbc st037Pbc = new ST037Pbc(client, bcc);
		ST037InputBO input = buildInput(Ccy.CNY, AllDraInd.N004, TranBranch.VALUE_351888);
		ST037OutputBO output = st037Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;
import com.dcits.deposit.facade.components.IFmBranchCcyBcc;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;

/**
 * ST023 检查机构币种交易权限 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST023-TC001 ~ ST023-TC005）
 */
@ExtendWith(MockitoExtension.class)
public class ST023PbcTest {

	@Mock
	private IFmBranchCcyBcc fmBranchCcyBcc;

	@InjectMocks
	private ST023Pbc st023Pbc;

	// 桩：findByEo 按查询条件 branch 精确匹配，返回该机构配置的币种记录列表（仅设置业务判断使用的 branch、ccy 字段）
	private void stubBranchCcyList(TranBranch branch, Ccy... ccys) {
		List<FmBranchCcyEO> branchCcyList = new ArrayList<>();
		for (Ccy ccy : ccys) {
			FmBranchCcyEO eo = new FmBranchCcyEO();
			eo.setBranch(branch);
			eo.setCcy(ccy);
			branchCcyList.add(eo);
		}
		Mockito.lenient()
				.when(fmBranchCcyBcc.findByEo(Mockito.argThat(eo -> eo.getBranch() == branch)))
				.thenReturn(branchCcyList);
	}

	private ST023InputBO buildInput(TranBranch tranBranch, Ccy tranCcy) {
		ST023InputBO input = new ST023InputBO();
		input.setTranBranch(tranBranch);
		input.setTranCcy(tranCcy);
		return input;
	}

	// TC001 总行(351001)配置 CNY、USD 两个币种，交易币种 CNY 命中[机构币种列表]首项，检查通过，输出币种 CNY
	@Test
	public void testST023T01() {
		stubBranchCcyList(TranBranch.VALUE_351001, Ccy.CNY, Ccy.USD);
		ST023InputBO input = buildInput(TranBranch.VALUE_351001, Ccy.CNY);
		ST023OutputBO output = st023Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(Ccy.CNY, output.getCcy());
	}

	// TC002 太原晋阳支行(351101)仅配置 USD 单一币种（列表最小规模边界），交易币种 USD 命中，检查通过，输出币种 USD
	@Test
	public void testST023T02() {
		stubBranchCcyList(TranBranch.VALUE_351101, Ccy.USD);
		ST023InputBO input = buildInput(TranBranch.VALUE_351101, Ccy.USD);
		ST023OutputBO output = st023Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(Ccy.USD, output.getCcy());
	}

	// TC003 总行(351001)配置 CNY、USD 两个币种，交易币种 EUR 不在[机构币种列表]范围内，返回错误码 ER0047
	@Test
	public void testST023T03() {
		stubBranchCcyList(TranBranch.VALUE_351001, Ccy.CNY, Ccy.USD);
		ST023InputBO input = buildInput(TranBranch.VALUE_351001, Ccy.EUR);
		ST023OutputBO output = st023Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0047", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0047::"));
		assertNull(output.getCcy());
	}

	// TC004 太原综改示范区支行(351102)未配置任何币种，查询【机构币种信息】返回空列表，交易币种必不在范围内，返回错误码 ER0047
	@Test
	public void testST023T04() {
		stubBranchCcyList(TranBranch.VALUE_351102);
		ST023InputBO input = buildInput(TranBranch.VALUE_351102, Ccy.CNY);
		ST023OutputBO output = st023Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0047", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0047::"));
		assertNull(output.getCcy());
	}

	// TC005 清徐神州数码村镇银行(351888)配置 CNY、USD、HKD 三个币种，交易币种 HKD 命中[机构币种列表]末项，检查通过，输出币种 HKD
	@Test
	public void testST023T05() {
		stubBranchCcyList(TranBranch.VALUE_351888, Ccy.CNY, Ccy.USD, Ccy.HKD);
		ST023InputBO input = buildInput(TranBranch.VALUE_351888, Ccy.HKD);
		ST023OutputBO output = st023Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(Ccy.HKD, output.getCcy());
	}
}

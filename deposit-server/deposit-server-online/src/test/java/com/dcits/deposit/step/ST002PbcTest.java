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

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST002 检查交易币种 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST002-TC001 ~ ST002-TC002）
 */
@ExtendWith(MockitoExtension.class)
public class ST002PbcTest {

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@InjectMocks
	private ST002Pbc st002Pbc;

	/** 构造查询命中的账户记录：baseAcctNo="2000010000001234"、acctCcy=人民币元 */
	private RbBusAcctEO buildAcct() {
		RbBusAcctEO eo = new RbBusAcctEO();
		eo.setBaseAcctNo("2000010000001234");
		eo.setAcctCcy(AcctCcy.CNY);
		return eo;
	}

	// TC001 人民币账户现金交易：按账号查询对公存款账户主表查到账户，账户币种 CNY 与交易币种 CNY 一致，检查结果“通过”
	@Test
	public void testST002T01() {
		// 以 thenAnswer 在返回前记录收到的查询 EO，用于核对账号到查询条件的映射
		final RbBusAcctEO[] receivedQueryEo = new RbBusAcctEO[1];
		Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
				.thenAnswer(invocation -> {
					receivedQueryEo[0] = invocation.getArgument(0);
					List<RbBusAcctEO> acctList = new ArrayList<>();
					acctList.add(buildAcct());
					return acctList;
				});

		ST002InputBO input = new ST002InputBO();
		input.setBaseAcctNo("2000010000001234");
		input.setTranCcy(Ccy.CNY);

		ST002OutputBO result = st002Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals(AcctCcy.CNY, result.getAcctCcy());
		// {账号}映射到查询条件 EO.baseAcctNo（不校验调用次数或顺序）
		assertEquals("2000010000001234", receivedQueryEo[0].getBaseAcctNo());
	}

	// TC002 外币交易落人民币账户：账户币种 CNY 与交易币种 USD 不一致，返回错误码 ER0051
	@Test
	public void testST002T02() {
		List<RbBusAcctEO> acctList = new ArrayList<>();
		acctList.add(buildAcct());
		Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
				.thenReturn(acctList);

		ST002InputBO input = new ST002InputBO();
		input.setBaseAcctNo("2000010000001234");
		input.setTranCcy(Ccy.USD);

		ST002OutputBO result = st002Pbc.execute(input);

		assertFalse(result.isSucceed());
		assertEquals("ER0051", result.getErrorCode());
		assertTrue(result.getErrorMessage().startsWith("ER0051::"));
	}
}

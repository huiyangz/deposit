package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;

/**
 * ST005 登记现金交易明细 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST005-TC001 ~ ST005-TC003）
 *
 * 本步骤唯一路径为登记 RB_BUS_TRAN_JNL，依赖 IRbBusTranJnlBcc 设桩；
 * SPEC 声明无业务失败场景，无错误码可断言。
 */
@ExtendWith(MockitoExtension.class)
public class ST005PbcTest {

	@Mock
	private IRbBusTranJnlBcc rbBusTranJnlBcc;

	@InjectMocks
	private ST005Pbc st005Pbc;

	private ST005InputBO buildInput(TranType tranType, Ccy ccy, CrDrInd crDrInd, BigDecimal tranAmt) {
		ST005InputBO input = new ST005InputBO();
		input.setTranType(tranType);
		input.setCcy(ccy);
		input.setCrDrInd(crDrInd);
		input.setTranAmt(tranAmt);
		return input;
	}

	// TC001 场景：现金存入登记：交易类型现金存入（VALUE_1000）、币种人民币（CNY）、借贷标志贷（C）、金额 50000.00，成功写入并回显登记值
	@Test
	public void testST005T01() {
		final RbBusTranJnlEO[] capturedEo = new RbBusTranJnlEO[1];
		Mockito.lenient().when(rbBusTranJnlBcc.createSelective(Mockito.any(RbBusTranJnlEO.class)))
				.thenAnswer(invocation -> {
					capturedEo[0] = invocation.getArgument(0);
					return 1;
				});
		ST005InputBO input = buildInput(TranType.VALUE_1000, Ccy.CNY, CrDrInd.C, new BigDecimal("50000.00"));

		ST005OutputBO result = st005Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals(TranType.VALUE_1000, result.getTranType());
		assertEquals(Ccy.CNY, result.getCcy());
		assertEquals(CrDrInd.C, result.getCrDrInd());
		assertEquals(0, result.getTranAmt().compareTo(new BigDecimal("50000.00")));
		assertEquals(TranType.VALUE_1000, capturedEo[0].getTranType());
		assertEquals(Ccy.CNY, capturedEo[0].getCcy());
		assertEquals(CrDrInd.C, capturedEo[0].getCrDrInd());
		assertEquals(0, capturedEo[0].getTranAmt().compareTo(new BigDecimal("50000.00")));
	}

	// TC002 场景：现金支取登记：交易类型现金支取（VALUE_1003）、币种美元（USD）、借贷标志借（D）、金额 1200.55，成功写入并回显
	@Test
	public void testST005T02() {
		final RbBusTranJnlEO[] capturedEo = new RbBusTranJnlEO[1];
		Mockito.lenient().when(rbBusTranJnlBcc.createSelective(Mockito.any(RbBusTranJnlEO.class)))
				.thenAnswer(invocation -> {
					capturedEo[0] = invocation.getArgument(0);
					return 1;
				});
		ST005InputBO input = buildInput(TranType.VALUE_1003, Ccy.USD, CrDrInd.D, new BigDecimal("1200.55"));

		ST005OutputBO result = st005Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals(TranType.VALUE_1003, result.getTranType());
		assertEquals(Ccy.USD, result.getCcy());
		assertEquals(CrDrInd.D, result.getCrDrInd());
		assertEquals(0, result.getTranAmt().compareTo(new BigDecimal("1200.55")));
		assertEquals(TranType.VALUE_1003, capturedEo[0].getTranType());
		assertEquals(Ccy.USD, capturedEo[0].getCcy());
		assertEquals(CrDrInd.D, capturedEo[0].getCrDrInd());
		assertEquals(0, capturedEo[0].getTranAmt().compareTo(new BigDecimal("1200.55")));
	}

	// TC003 场景：金额零值边界：交易金额 BigDecimal.ZERO（SPEC 未定义金额范围校验），现金存入、CNY、贷，登记成功并回显 0
	@Test
	public void testST005T03() {
		final RbBusTranJnlEO[] capturedEo = new RbBusTranJnlEO[1];
		Mockito.lenient().when(rbBusTranJnlBcc.createSelective(Mockito.any(RbBusTranJnlEO.class)))
				.thenAnswer(invocation -> {
					capturedEo[0] = invocation.getArgument(0);
					return 1;
				});
		ST005InputBO input = buildInput(TranType.VALUE_1000, Ccy.CNY, CrDrInd.C, BigDecimal.ZERO);

		ST005OutputBO result = st005Pbc.execute(input);

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals(TranType.VALUE_1000, result.getTranType());
		assertEquals(Ccy.CNY, result.getCcy());
		assertEquals(CrDrInd.C, result.getCrDrInd());
		assertEquals(0, result.getTranAmt().compareTo(BigDecimal.ZERO));
		assertEquals(TranType.VALUE_1000, capturedEo[0].getTranType());
		assertEquals(Ccy.CNY, capturedEo[0].getCcy());
		assertEquals(CrDrInd.C, capturedEo[0].getCrDrInd());
		assertEquals(0, capturedEo[0].getTranAmt().compareTo(BigDecimal.ZERO));
	}
}

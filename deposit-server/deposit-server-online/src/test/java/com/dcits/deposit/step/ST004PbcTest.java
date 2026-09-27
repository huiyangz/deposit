package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;

/**
 * ST004 登记交易流水 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST004-TC001 ~ ST004-TC003）
 */
@ExtendWith(MockitoExtension.class)
public class ST004PbcTest {

	@Mock
	private IRbBusTranJnlBcc rbBusTranJnlBcc;

	@InjectMocks
	private ST004Pbc st004Pbc;

	/** create 桩捕获的入参 EO */
	private RbBusTranJnlEO capturedTranJnl;

	// 桩配置：create 写入一行并捕获入参 EO，全部用例复用
	private void stubCreateSuccess() {
		Mockito.lenient().when(rbBusTranJnlBcc.create(Mockito.any(RbBusTranJnlEO.class))).thenAnswer(invocation -> {
			capturedTranJnl = invocation.getArgument(0);
			return 1;
		});
	}

	private ST004InputBO buildInput(CrDrInd crDrInd, Ccy ccy, TranType tranType, BigDecimal tranAmt,
			String clientNo, String seqNo, Date tranDate, Integer internalKey, Integer othInternalKey,
			String createTimestamp, String lastUpdTimestamp) {
		ST004InputBO input = new ST004InputBO();
		input.setCrDrInd(crDrInd);
		input.setCcy(ccy);
		input.setTranType(tranType);
		input.setTranAmt(tranAmt);
		input.setClientNo(clientNo);
		input.setSeqNo(seqNo);
		input.setTranDate(tranDate);
		input.setInternalKey(internalKey);
		input.setOthInternalKey(othInternalKey);
		input.setCreateTimestamp(createTimestamp);
		input.setLastUpdTimestamp(lastUpdTimestamp);
		return input;
	}

	// TC001 活期现金存入交易登记成功：借贷标志为贷，人民币现金存入 1000.00 元写入交易流水，捕获 EO 完整反映 11 个输入字段
	@Test
	public void testST004T01() {
		stubCreateSuccess();
		Date tranDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 24).getTime();
		ST004InputBO input = buildInput(CrDrInd.C, Ccy.CNY, TranType.VALUE_1000, new BigDecimal("1000.00"),
				"C202609240001", "SEQ20260924000001", tranDate, 1001, 2001,
				"20260924095800001", "20260924095800001");
		ST004OutputBO output = st004Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(CrDrInd.C, output.getCrDrInd());
		assertEquals(Ccy.CNY, output.getCcy());
		assertEquals(TranType.VALUE_1000, output.getTranType());
		assertEquals(new BigDecimal("1000.00"), output.getTranAmt());
		assertEquals(CrDrInd.C, capturedTranJnl.getCrDrInd());
		assertEquals(Ccy.CNY, capturedTranJnl.getCcy());
		assertEquals(TranType.VALUE_1000, capturedTranJnl.getTranType());
		assertEquals(new BigDecimal("1000.00"), capturedTranJnl.getTranAmt());
		assertEquals("C202609240001", capturedTranJnl.getClientNo());
		assertEquals("SEQ20260924000001", capturedTranJnl.getSeqNo());
		assertEquals(tranDate, capturedTranJnl.getTranDate());
		assertEquals(Integer.valueOf(1001), capturedTranJnl.getInternalKey());
		assertEquals(Integer.valueOf(2001), capturedTranJnl.getOthInternalKey());
		assertEquals("20260924095800001", capturedTranJnl.getCreateTimestamp());
		assertEquals("20260924095800001", capturedTranJnl.getLastUpdTimestamp());
	}

	// TC002 现金支取交易登记成功：借贷标志为借，美元现金支取 500.50，覆盖另一借贷标志与币种、交易类型组合
	@Test
	public void testST004T02() {
		stubCreateSuccess();
		Date tranDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 24).getTime();
		ST004InputBO input = buildInput(CrDrInd.D, Ccy.USD, TranType.VALUE_1003, new BigDecimal("500.50"),
				"C202609240002", "SEQ20260924000002", tranDate, 1002, 2002,
				"20260924100500002", "20260924100500002");
		ST004OutputBO output = st004Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(CrDrInd.D, output.getCrDrInd());
		assertEquals(Ccy.USD, output.getCcy());
		assertEquals(TranType.VALUE_1003, output.getTranType());
		assertEquals(new BigDecimal("500.50"), output.getTranAmt());
		assertEquals(CrDrInd.D, capturedTranJnl.getCrDrInd());
		assertEquals(Ccy.USD, capturedTranJnl.getCcy());
		assertEquals(TranType.VALUE_1003, capturedTranJnl.getTranType());
		assertEquals(new BigDecimal("500.50"), capturedTranJnl.getTranAmt());
		assertEquals("SEQ20260924000002", capturedTranJnl.getSeqNo());
		assertEquals(Integer.valueOf(1002), capturedTranJnl.getInternalKey());
		assertEquals(Integer.valueOf(2002), capturedTranJnl.getOthInternalKey());
	}

	// TC003 零值金额边界：交易金额为 0 的现金存入流水仍按定义登记成功并原样回显
	@Test
	public void testST004T03() {
		stubCreateSuccess();
		Date tranDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 24).getTime();
		ST004InputBO input = buildInput(CrDrInd.C, Ccy.CNY, TranType.VALUE_1000, BigDecimal.ZERO,
				"C202609240003", "SEQ20260924000003", tranDate, 1003, 2003,
				"20260924101200003", "20260924101200003");
		ST004OutputBO output = st004Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(CrDrInd.C, output.getCrDrInd());
		assertEquals(Ccy.CNY, output.getCcy());
		assertEquals(TranType.VALUE_1000, output.getTranType());
		assertEquals(BigDecimal.ZERO, output.getTranAmt());
		assertEquals(BigDecimal.ZERO, capturedTranJnl.getTranAmt());
	}
}

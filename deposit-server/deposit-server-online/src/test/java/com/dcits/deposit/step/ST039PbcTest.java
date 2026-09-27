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

import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctIntDetailBcc;
import com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO;

/**
 * ST039 登记账户计息信息 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST039-TC001 ~ ST039-TC003）
 */
@ExtendWith(MockitoExtension.class)
public class ST039PbcTest {

	@Mock
	private IRbBusAcctIntDetailBcc rbBusAcctIntDetailBcc;

	@InjectMocks
	private ST039Pbc st039Pbc;

	/** createSelective 桩捕获的入参 EO */
	private RbBusAcctIntDetailEO capturedIntDetail;

	// 桩配置：createSelective 写入一行并捕获入参 EO，全部用例复用；主表 BCC 无已定义读取，不设桩
	private void stubCreateSelectiveSuccess() {
		Mockito.lenient().when(rbBusAcctIntDetailBcc.createSelective(Mockito.any(RbBusAcctIntDetailEO.class)))
				.thenAnswer(invocation -> {
					capturedIntDetail = invocation.getArgument(0);
					return 1;
				});
	}

	private ST039InputBO buildInput(String clientNo, String baseAcctNo, IntIndFlag intIndFlag,
			Integer internalKey, IntType intType, BigDecimal taxRate, String intCapFlag, Date calcBeginDate,
			BigDecimal acctPercentRate, BigDecimal acctSpreadRate, String taxTypeNo, BigDecimal realRate) {
		ST039InputBO input = new ST039InputBO();
		input.setClientNo(clientNo);
		input.setBaseAcctNo(baseAcctNo);
		input.setIntIndFlag(intIndFlag);
		input.setInternalKey(internalKey);
		input.setIntType(intType);
		input.setTaxRate(taxRate);
		input.setIntCapFlag(intCapFlag);
		input.setCalcBeginDate(calcBeginDate);
		input.setAcctPercentRate(acctPercentRate);
		input.setAcctSpreadRate(acctSpreadRate);
		input.setTaxTypeNo(taxTypeNo);
		input.setRealRate(realRate);
		return input;
	}

	// TC001 正常路径：输入字段齐全（含两个可选浮动利率字段），登记利息明细成功，利息分类固定 INT-正常利息
	@Test
	public void testST039T01() {
		stubCreateSelectiveSuccess();
		Date calcBeginDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 24).getTime();
		ST039InputBO input = buildInput("C20260001", "2000010001", IntIndFlag.Y, 1000001, IntType.DR2,
				new BigDecimal("0.20"), "N", calcBeginDate, new BigDecimal("10.00"), new BigDecimal("0.50"),
				"TAX001", new BigDecimal("1.650"));
		ST039OutputBO output = st039Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(IntClass.INT, capturedIntDetail.getIntClass());
		assertEquals(Integer.valueOf(1000001), capturedIntDetail.getInternalKey());
		assertEquals(IntType.DR2, capturedIntDetail.getIntType());
		assertEquals(new BigDecimal("1.650"), capturedIntDetail.getRealRate());
		assertEquals(new BigDecimal("0.20"), capturedIntDetail.getTaxRate());
		assertEquals("N", capturedIntDetail.getIntCapFlag());
		assertEquals(calcBeginDate, capturedIntDetail.getCalcBeginDate());
		assertEquals(new BigDecimal("10.00"), capturedIntDetail.getAcctPercentRate());
		assertEquals(new BigDecimal("0.50"), capturedIntDetail.getAcctSpreadRate());
		assertEquals("TAX001", capturedIntDetail.getTaxTypeNo());
		assertEquals(Integer.valueOf(1000001), output.getInternalKey());
		assertEquals(IntType.DR2, output.getIntType());
		assertEquals(new BigDecimal("0.20"), output.getTaxRate());
		assertEquals("N", output.getIntCapFlag());
		assertEquals(calcBeginDate, output.getCalcBeginDate());
		assertEquals(new BigDecimal("10.00"), output.getAcctPercentRate());
		assertEquals(new BigDecimal("0.50"), output.getAcctSpreadRate());
		assertEquals(new BigDecimal("1.650"), output.getRealRate());
	}

	// TC002 正常路径：可选字段 acctPercentRate、acctSpreadRate 合法缺省为 null，登记成功且明细不写入该两字段
	@Test
	public void testST039T02() {
		stubCreateSelectiveSuccess();
		Date calcBeginDate = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
		ST039InputBO input = buildInput("C20260002", "2000010002", IntIndFlag.Y, 1000002, IntType.HQC,
				new BigDecimal("0.20"), "N", calcBeginDate, null, null, "TAX001", new BigDecimal("0.300"));
		ST039OutputBO output = st039Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(IntClass.INT, capturedIntDetail.getIntClass());
		assertEquals(Integer.valueOf(1000002), capturedIntDetail.getInternalKey());
		assertEquals(IntType.HQC, capturedIntDetail.getIntType());
		assertEquals(new BigDecimal("0.300"), capturedIntDetail.getRealRate());
		assertEquals(new BigDecimal("0.20"), capturedIntDetail.getTaxRate());
		assertEquals("N", capturedIntDetail.getIntCapFlag());
		assertEquals(calcBeginDate, capturedIntDetail.getCalcBeginDate());
		assertEquals("TAX001", capturedIntDetail.getTaxTypeNo());
		assertNull(capturedIntDetail.getAcctPercentRate());
		assertNull(capturedIntDetail.getAcctSpreadRate());
		assertEquals(Integer.valueOf(1000002), output.getInternalKey());
		assertEquals(IntType.HQC, output.getIntType());
		assertEquals(new BigDecimal("0.20"), output.getTaxRate());
		assertEquals("N", output.getIntCapFlag());
		assertEquals(calcBeginDate, output.getCalcBeginDate());
		assertEquals(new BigDecimal("0.300"), output.getRealRate());
		assertNull(output.getAcctPercentRate());
		assertNull(output.getAcctSpreadRate());
	}

	// TC003 边界否定路径：零值边界（税率 0、执行利率 0、浮动 0.00，零利率 HQ0），无拒绝校验，零值原样登记
	@Test
	public void testST039T03() {
		stubCreateSelectiveSuccess();
		Date calcBeginDate = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
		ST039InputBO input = buildInput("C20260003", "2000010003", IntIndFlag.Y, 1000003, IntType.HQ0,
				new BigDecimal("0"), "N", calcBeginDate, new BigDecimal("0.00"), new BigDecimal("0.00"),
				"TAX001", new BigDecimal("0"));
		ST039OutputBO output = st039Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(IntClass.INT, capturedIntDetail.getIntClass());
		assertEquals(Integer.valueOf(1000003), capturedIntDetail.getInternalKey());
		assertEquals(IntType.HQ0, capturedIntDetail.getIntType());
		assertEquals(new BigDecimal("0"), capturedIntDetail.getRealRate());
		assertEquals(new BigDecimal("0"), capturedIntDetail.getTaxRate());
		assertEquals(new BigDecimal("0.00"), capturedIntDetail.getAcctPercentRate());
		assertEquals(new BigDecimal("0.00"), capturedIntDetail.getAcctSpreadRate());
		assertEquals("N", capturedIntDetail.getIntCapFlag());
		assertEquals(calcBeginDate, capturedIntDetail.getCalcBeginDate());
		assertEquals(Integer.valueOf(1000003), output.getInternalKey());
		assertEquals(IntType.HQ0, output.getIntType());
		assertEquals(new BigDecimal("0"), output.getTaxRate());
		assertEquals("N", output.getIntCapFlag());
		assertEquals(calcBeginDate, output.getCalcBeginDate());
		assertEquals(new BigDecimal("0.00"), output.getAcctPercentRate());
		assertEquals(new BigDecimal("0.00"), output.getAcctSpreadRate());
		assertEquals(new BigDecimal("0"), output.getRealRate());
	}
}

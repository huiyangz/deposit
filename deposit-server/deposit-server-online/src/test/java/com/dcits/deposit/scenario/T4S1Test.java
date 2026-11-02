package com.dcits.deposit.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;
import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.bo.ST043InputBO;
import com.dcits.deposit.facade.bo.ST043OutputBO;
import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;
import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.step.IST037;
import com.dcits.deposit.step.IST038;
import com.dcits.deposit.step.IST039;
import com.dcits.deposit.step.IST040;
import com.dcits.deposit.step.IST041;
import com.dcits.deposit.step.IST042;
import com.dcits.deposit.step.IST043;
import com.dcits.deposit.step.IST044;
import com.dcits.deposit.step.IST045;
import com.dcits.deposit.step.IST046;
import com.dcits.deposit.task.dto.T4S1InputDTO;
import com.dcits.deposit.task.dto.T4S1OutputDTO;
import com.dcits.deposit.task.scenario.T4S1;

/** T4S1 检查限额 交易接口场景单元测试 */
@ExtendWith(MockitoExtension.class)
class T4S1Test {

	@Mock
	private IST037 ist037;

	@Mock
	private IST038 ist038;

	@Mock
	private IST039 ist039;

	@Mock
	private IST040 ist040;

	@Mock
	private IST041 ist041;

	@Mock
	private IST042 ist042;

	@Mock
	private IST043 ist043;

	@Mock
	private IST044 ist044;

	@Mock
	private IST045 ist045;

	@Mock
	private IST046 ist046;

	@InjectMocks
	private T4S1 t4S1;

	@Captor
	private ArgumentCaptor<ST037InputBO> st037Captor;

	@Captor
	private ArgumentCaptor<ST038InputBO> st038Captor;

	@Captor
	private ArgumentCaptor<ST039InputBO> st039Captor;

	@Captor
	private ArgumentCaptor<ST040InputBO> st040Captor;

	@Captor
	private ArgumentCaptor<ST041InputBO> st041Captor;

	@Captor
	private ArgumentCaptor<ST042InputBO> st042Captor;

	@Captor
	private ArgumentCaptor<ST043InputBO> st043Captor;

	@Captor
	private ArgumentCaptor<ST044InputBO> st044Captor;

	@Captor
	private ArgumentCaptor<ST045InputBO> st045Captor;

	@Captor
	private ArgumentCaptor<ST046InputBO> st046Captor;

	// T4S1-TC001（REQ-001-S01）：10 个步骤 ST037→ST046 全部成功执行，最后执行 ST046；复用带旧错误的响应头验证成功路径清理错误字段并置成功；ST037 首步承接接口输入，ST041/ST044/ST046 桩捕获到非空 InputBO 作为步骤触达证据；返回输出 DTO 非空
	@Test
	void testT4S1T01() {
		stubAllStepsSucceed();

		// 复用带旧失败状态的响应头，验证全成功时错误字段被清理
		RespHeader header = new RespHeader();
		header.setSucceed(false);
		header.setErrorCode("OLD_ERROR");
		header.setErrorMessage("旧错误");
		T4S1InputDTO input = buildInput();

		T4S1OutputDTO output = t4S1.execute(header, input);

		assertNotNull(output);
		assertEquals(input.getBaseAcctNo(), st037Captor.getValue().getBaseAcctNo());
		assertEquals(input.getClientNo(), st037Captor.getValue().getClientNo());
		assertEquals(input.getLimitSceneNo(), st037Captor.getValue().getLimitSceneNo());
		assertEquals(input.getTranDate(), st037Captor.getValue().getTranDate());
		assertNotNull(st041Captor.getValue());
		assertNotNull(st044Captor.getValue());
		assertNotNull(st046Captor.getValue());
		assertTrue(header.isSucceed());
		assertNull(header.getErrorCode());
		assertNull(header.getErrorMessage());
	}

	// T4S1-TC002（REQ-002-S01）：提供全部 12 个必填输入（含 4 个「待定」输入行按类型约束构造）后进入步骤编排，自 ST037 开始执行，ST037 捕获入参与接口输入逐项一致；4 个「待定」输入行无已定义消费者与映射（TBD-1），仅按类型约束构造
	@Test
	void testT4S1T02() {
		stubAllStepsSucceed();

		RespHeader header = new RespHeader();
		T4S1InputDTO input = buildInput();

		T4S1OutputDTO output = t4S1.execute(header, input);

		assertEquals("6222020200000001", st037Captor.getValue().getBaseAcctNo());
		assertEquals("C00001", st037Captor.getValue().getClientNo());
		assertEquals("LS001", st037Captor.getValue().getLimitSceneNo());
		assertEquals(input.getTranDate(), st037Captor.getValue().getTranDate());
		assertTrue(header.isSucceed());
		assertNull(header.getErrorCode());
		assertNull(header.getErrorMessage());
		assertNotNull(output);
	}

	// T4S1-TC003（REQ-003-S01，含前序数据传递）：编排正常完成后返回输出 DTO 非空且含唯一声明输出字段 限额检查结果（结构层面，取值不断言，TBD-2、TBD-8）；核对确定型跨步骤数据流：ST038.baseAcctNo←ST037 回显、ST039.tranAmt←接口输入、ST040.limitSumAmt/limitSumNum←ST039 输出、ST042.clientNo←ST037 回显、ST043.factorName←接口输入、ST044.tranAmt←接口输入、ST045.tranDate/tranTimestamp←接口输入
	@Test
	void testT4S1T03() {
		stubAllStepsSucceed();

		RespHeader header = new RespHeader();
		T4S1InputDTO input = buildInput();

		T4S1OutputDTO output = t4S1.execute(header, input);

		assertEquals("6222020200000001", st038Captor.getValue().getBaseAcctNo());
		assertEquals(0, st039Captor.getValue().getTranAmt().compareTo(new BigDecimal("1000.00")));
		assertEquals(0, st040Captor.getValue().getLimitSumAmt().compareTo(new BigDecimal("600.00")));
		assertEquals(Integer.valueOf(3), st040Captor.getValue().getLimitSumNum());
		assertEquals("C00001", st042Captor.getValue().getClientNo());
		assertEquals("FACTOR001", st043Captor.getValue().getFactorName());
		assertEquals(input.getTranAmt(), st044Captor.getValue().getTranAmt());
		assertEquals(input.getTranDate(), st045Captor.getValue().getTranDate());
		assertEquals("20261102103000", st045Captor.getValue().getTranTimestamp());
		assertTrue(header.isSucceed());
		assertNull(header.getErrorCode());
		assertNull(header.getErrorMessage());
		assertNotNull(output);
	}

	/** 构造全 12 字段必填输入：4 个「待定」输入行按类型约束给字符串（业务含义未定义，见 TBD-1） */
	private T4S1InputDTO buildInput() {
		T4S1InputDTO input = new T4S1InputDTO();
		input.setSumInfoSceneNo("RSV_SUM_SCENE_NO");
		input.setRestrictAcctNo("RSV_RESTRICT_ACCT_NO");
		input.setCtrlSceneNo("RSV_CTRL_SCENE_NO");
		input.setSumInfoCustNo("RSV_SUM_CUST_NO");
		input.setBaseAcctNo("6222020200000001");
		input.setLimitSceneNo("LS001");
		input.setClientNo("C00001");
		input.setTranDate(new GregorianCalendar(2026, Calendar.NOVEMBER, 2).getTime());
		input.setTranTimestamp("20261102103000");
		input.setFactorName("FACTOR001");
		input.setTranAmt(new BigDecimal("1000.00"));
		input.setLimitCheckResult("未超限");
		return input;
	}

	/** 10 个步骤接口全部设桩返回真实成功 OutputBO（均显式 setSucceed(true)），正常路径每步均被调用 */
	private void stubAllStepsSucceed() {
		ST037OutputBO st037Output = new ST037OutputBO();
		st037Output.setSucceed(true);
		st037Output.setLimitSceneNo("LS001");
		st037Output.setBaseAcctNo("6222020200000001");
		st037Output.setClientNo("C00001");
		Mockito.lenient().when(ist037.execute(st037Captor.capture())).thenReturn(st037Output);

		ST038OutputBO st038Output = new ST038OutputBO();
		st038Output.setSucceed(true);
		st038Output.setLimitSceneNo("LS001");
		st038Output.setBaseAcctNo("6222020200000001");
		st038Output.setValidFlag("Y");
		Mockito.lenient().when(ist038.execute(st038Captor.capture())).thenReturn(st038Output);

		ST039OutputBO st039Output = new ST039OutputBO();
		st039Output.setSucceed(true);
		st039Output.setLimitSumAmt(new BigDecimal("600.00"));
		st039Output.set限额累计笔数(3);
		Mockito.lenient().when(ist039.execute(st039Captor.capture())).thenReturn(st039Output);

		ST040OutputBO st040Output = new ST040OutputBO();
		st040Output.setSucceed(true);
		st040Output.setLimitCtrlAmt(new BigDecimal("2000.00"));
		st040Output.setLimitCtrlNum(10);
		st040Output.setLimitSumAmt(new BigDecimal("600.00"));
		st040Output.setLimitSumNum(3);
		st040Output.setLimitCheckResult("未超限");
		Mockito.lenient().when(ist040.execute(st040Captor.capture())).thenReturn(st040Output);

		ST041OutputBO st041Output = new ST041OutputBO();
		st041Output.setSucceed(true);
		Mockito.lenient().when(ist041.execute(st041Captor.capture())).thenReturn(st041Output);

		ST042OutputBO st042Output = new ST042OutputBO();
		st042Output.setSucceed(true);
		st042Output.setLimitSumAmt(new BigDecimal("600.00"));
		st042Output.set否(3);
		st042Output.setClientNo("C00001");
		st042Output.setLimitSceneNo("LS001");
		Mockito.lenient().when(ist042.execute(st042Captor.capture())).thenReturn(st042Output);

		ST043OutputBO st043Output = new ST043OutputBO();
		st043Output.setSucceed(true);
		st043Output.setLimitSceneNo("LS001");
		st043Output.setRuleRelationExpr("EXPR_001");
		st043Output.setValidFlag("Y");
		Mockito.lenient().when(ist043.execute(st043Captor.capture())).thenReturn(st043Output);

		ST044OutputBO st044Output = new ST044OutputBO();
		st044Output.setSucceed(true);
		st044Output.setLimitSceneNo("LS001");
		st044Output.setCheckObjVal("6222020200000001");
		st044Output.setLimitSumAmt(new BigDecimal("1000.00"));
		st044Output.set否(1);
		st044Output.setEffectDate(new GregorianCalendar(2026, Calendar.NOVEMBER, 2).getTime());
		Mockito.lenient().when(ist044.execute(st044Captor.capture())).thenReturn(st044Output);

		ST045OutputBO st045Output = new ST045OutputBO();
		st045Output.setSucceed(true);
		st045Output.setLimitSceneNo("LS001");
		Mockito.lenient().when(ist045.execute(st045Captor.capture())).thenReturn(st045Output);

		ST046OutputBO st046Output = new ST046OutputBO();
		st046Output.setSucceed(true);
		Mockito.lenient().when(ist046.execute(st046Captor.capture())).thenReturn(st046Output);
	}
}

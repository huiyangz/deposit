package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;
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

/**
 * ST022 检查对手账户限额 单元测试。
 *
 * <p>按正式 Spec 步骤描述与用例 ST022-TC001~TC012 覆盖：ST043 匹配限额场景→ST038/ST045/ST037 任一返回
 * 空[限额场景编码]的「通过」提前结束、ST042/ST039 累计值、ST040「未超限」→步骤 12 按累计情况更新（ST046）
 * 或登记（ST044）、「超限」→ST041 处理方式 B/A/D 三分支（拒绝 ER0058 业务失败、授权返回授权标志「需授权」、
 * 提示正常结束）。被跳过的子步骤不设桩，误触达将因 Mockito 默认返回 null 导致用例失败，以业务结果验证路径。
 * 未确认业务（TBD-01~TBD-12）不写为断言期望值。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST022PbcTest {

    @Mock
    private IST043 st043;

    @Mock
    private IST038 st038;

    @Mock
    private IST045 st045;

    @Mock
    private IST037 st037;

    @Mock
    private IST042 st042;

    @Mock
    private IST039 st039;

    @Mock
    private IST040 st040;

    @Mock
    private IST041 st041;

    @Mock
    private IST046 st046;

    @Mock
    private IST044 st044;

    @InjectMocks
    private ST022Pbc st022Pbc;

    // 场景 TC001：ST043 匹配场景后全链路执行，ST040="超限"、ST041 处理方式=提醒（D），
    // 步骤正常成功；ST043 入参因子名称=SCENE_FACTOR，ST041 入参限额场景编码=LS001
    @Test
    void testST022T01() throws Exception {
        ST022InputBO input = buildInput();

        ArgumentCaptor<ST043InputBO> captorSt043 = ArgumentCaptor.forClass(ST043InputBO.class);
        lenient().when(st043.execute(captorSt043.capture())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("超限"));

        ArgumentCaptor<ST041InputBO> captorSt041 = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(captorSt041.capture())).thenReturn(buildSt041Result(DealFlow.D));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("SCENE_FACTOR", captorSt043.getValue().getFactorName());
        assertEquals("LS001", captorSt041.getValue().getLimitSceneNo());
    }

    // 场景 TC002：ST043 匹配后 ST038 返回空[限额场景编码]，步骤以「通过」提前结束，
    // 后续 ST045 不被触达；ST038 入参对手账号=62010000001234
    @Test
    void testST022T02() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());

        ArgumentCaptor<ST038InputBO> captorSt038 = ArgumentCaptor.forClass(ST038InputBO.class);
        lenient().when(st038.execute(captorSt038.capture())).thenReturn(buildSt038Result(null));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("62010000001234", captorSt038.getValue().getBaseAcctNo());
    }

    // 场景 TC003：ST038 返回 LS001，ST045 返回空[限额场景编码]，步骤以「通过」提前结束，
    // 后续 ST037 不被触达；ST045 入参限额场景编码=LS001、交易日期=2026-10-31、交易时间戳=10:00:00
    @Test
    void testST022T03() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));

        ArgumentCaptor<ST045InputBO> captorSt045 = ArgumentCaptor.forClass(ST045InputBO.class);
        lenient().when(st045.execute(captorSt045.capture())).thenReturn(buildSt045Result(null));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS001", captorSt045.getValue().getLimitSceneNo());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-31"), captorSt045.getValue().getTranDate());
        assertEquals("10:00:00", captorSt045.getValue().getTranTimestamp());
    }

    // 场景 TC004：ST038、ST045 均返回 LS001，ST037 返回空[限额场景编码]，步骤以「通过」提前结束，
    // 后续 ST042 不被触达；ST037 入参限额场景编码=LS001、对手账号=62010000001234、对手客户号=10000001
    @Test
    void testST022T04() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));

        ArgumentCaptor<ST037InputBO> captorSt037 = ArgumentCaptor.forClass(ST037InputBO.class);
        lenient().when(st037.execute(captorSt037.capture())).thenReturn(buildSt037Result(null));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS001", captorSt037.getValue().getLimitSceneNo());
        assertEquals("62010000001234", captorSt037.getValue().getBaseAcctNo());
        assertEquals("10000001", captorSt037.getValue().getClientNo());
    }

    // 场景 TC005：全链路执行，ST040="未超限"、累计金额=500.00>0，进入步骤 12 金额分支调 ST046（成功）；
    // ST041、ST044 不被触达；ST042 入参限额场景编码=LS001、对手账号、对手客户号，ST039 入参限额场景编码=LS001
    @Test
    void testST022T05() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));

        ArgumentCaptor<ST042InputBO> captorSt042 = ArgumentCaptor.forClass(ST042InputBO.class);
        lenient().when(st042.execute(captorSt042.capture())).thenReturn(buildSt042Result("500.00", 2));

        ArgumentCaptor<ST039InputBO> captorSt039 = ArgumentCaptor.forClass(ST039InputBO.class);
        lenient().when(st039.execute(captorSt039.capture())).thenReturn(buildSt039Result("500.00", 2));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("未超限"));
        lenient().when(st046.execute(any())).thenReturn(buildSt046Result());

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS001", captorSt042.getValue().getLimitSceneNo());
        assertEquals("62010000001234", captorSt042.getValue().getBaseAcctNo());
        assertEquals("10000001", captorSt042.getValue().getClientNo());
        assertEquals("LS001", captorSt039.getValue().getLimitSceneNo());
    }

    // 场景 TC006：ST040="未超限"、累计金额=600.00>0 且笔数=3>0，进入步骤 12 金额分支调 ST046（成功）；
    // ST041 不被触达；ST040 入参限额场景编码=LS001、限额累计金额=600.00、限额累计笔数=3
    @Test
    void testST022T06() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));

        ArgumentCaptor<ST040InputBO> captorSt040 = ArgumentCaptor.forClass(ST040InputBO.class);
        lenient().when(st040.execute(captorSt040.capture())).thenReturn(buildSt040Result("未超限"));
        lenient().when(st046.execute(any())).thenReturn(buildSt046Result());

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS001", captorSt040.getValue().getLimitSceneNo());
        assertEquals(0, captorSt040.getValue().getLimitSumAmt().compareTo(new BigDecimal("600.00")));
        assertEquals(3, captorSt040.getValue().getLimitSumNum());
    }

    // 场景 TC007：ST040="超限"，ST041 处理方式=拒绝（B），步骤业务失败，错误码=ER0058，
    // 错误信息为"ER0058::交易超出限额控制"格式；ST041 入参限额场景编码=LS001
    @Test
    void testST022T07() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("超限"));

        ArgumentCaptor<ST041InputBO> captorSt041 = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(captorSt041.capture())).thenReturn(buildSt041Result(DealFlow.B));

        ST022OutputBO result = st022Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0058", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0058::"));
        assertTrue(result.getErrorMessage().contains("交易超出限额控制"));
        assertEquals("LS001", captorSt041.getValue().getLimitSceneNo());
    }

    // 场景 TC008：ST040="超限"，ST041 处理方式=授权（A），步骤成功，输出授权标志="需授权"；
    // ST041 入参限额场景编码=LS001
    @Test
    void testST022T08() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("超限"));

        ArgumentCaptor<ST041InputBO> captorSt041 = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(captorSt041.capture())).thenReturn(buildSt041Result(DealFlow.A));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("需授权", result.get授权标志());
        assertEquals("LS001", captorSt041.getValue().getLimitSceneNo());
    }

    // 场景 TC009：ST040="超限"，ST041 处理方式=提醒（D），步骤正常成功；ST041 入参限额场景编码=LS001
    @Test
    void testST022T09() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("超限"));

        ArgumentCaptor<ST041InputBO> captorSt041 = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(captorSt041.capture())).thenReturn(buildSt041Result(DealFlow.D));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS001", captorSt041.getValue().getLimitSceneNo());
    }

    // 场景 TC010：ST040="未超限"、累计金额=500.00>0，进入步骤 12 金额分支调 ST046（成功）；
    // ST046 入参限额检查结果=未超限、对手账号、限额场景编码=LS001、对手客户号、限额累计金额=500.00、限额累计笔数=2
    @Test
    void testST022T10() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("500.00", 2));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("500.00", 2));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("未超限"));

        ArgumentCaptor<ST046InputBO> captorSt046 = ArgumentCaptor.forClass(ST046InputBO.class);
        lenient().when(st046.execute(captorSt046.capture())).thenReturn(buildSt046Result());

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("未超限", captorSt046.getValue().get限额检查结果());
        assertEquals("62010000001234", captorSt046.getValue().getBaseAcctNo());
        assertEquals("LS001", captorSt046.getValue().getLimitSceneNo());
        assertEquals("10000001", captorSt046.getValue().getClientNo());
        assertEquals(0, captorSt046.getValue().getLimitSumAmt().compareTo(new BigDecimal("500.00")));
        assertEquals(2, captorSt046.getValue().get否());
    }

    // 场景 TC011：ST040="未超限"、累计金额=0.00 且笔数=0，金额与笔数均不大于 0，
    // 进入步骤 12 登记分支调 ST044（成功）；ST041、ST046 不被触达；
    // ST044 入参限额检查结果=未超限、对手账号、限额场景编码=LS001、对手客户号、限额累计金额=0.00、限额累计笔数=0
    @Test
    void testST022T11() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("0.00", 0));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("0.00", 0));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("未超限"));

        ArgumentCaptor<ST044InputBO> captorSt044 = ArgumentCaptor.forClass(ST044InputBO.class);
        lenient().when(st044.execute(captorSt044.capture())).thenReturn(buildSt044Result());

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("未超限", captorSt044.getValue().get限额检查结果());
        assertEquals("62010000001234", captorSt044.getValue().getBaseAcctNo());
        assertEquals("LS001", captorSt044.getValue().getLimitSceneNo());
        assertEquals("10000001", captorSt044.getValue().getClientNo());
        assertEquals(0, captorSt044.getValue().getLimitSumAmt().compareTo(new BigDecimal("0.00")));
        assertEquals(0, captorSt044.getValue().get否());
    }

    // 场景 TC012：ST040="超限"，ST041 处理方式=提醒（D），步骤正常成功；输出 BO 各业务字段
    // 类型契约可用（TBD-07/TBD-10/TBD-12 未确认取值，仅做类型收口，不做值断言）
    @Test
    void testST022T12() throws Exception {
        ST022InputBO input = buildInput();

        lenient().when(st043.execute(any())).thenReturn(buildSt043Result());
        lenient().when(st038.execute(any())).thenReturn(buildSt038Result("LS001"));
        lenient().when(st045.execute(any())).thenReturn(buildSt045Result("LS001"));
        lenient().when(st037.execute(any())).thenReturn(buildSt037Result("LS001"));
        lenient().when(st042.execute(any())).thenReturn(buildSt042Result("600.00", 3));
        lenient().when(st039.execute(any())).thenReturn(buildSt039Result("600.00", 3));
        lenient().when(st040.execute(any())).thenReturn(buildSt040Result("超限"));
        lenient().when(st041.execute(any())).thenReturn(buildSt041Result(DealFlow.D));

        ST022OutputBO result = st022Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 按用例 TC012 断言点以类型化局部变量承接各输出字段访问器，验证访问器存在且类型一致
        // （类型契约；字段取值与空值口径见 TBD-07/TBD-10/TBD-12，本用例不做值断言）
        TranStatus tranStatus = result.getTranStatus();
        String limitSceneNo = result.getLimitSceneNo();
        BigDecimal limitSumAmt = result.getLimitSumAmt();
        Integer 否 = result.get否();
        String 限额检查结果 = result.get限额检查结果();
        String 授权标志 = result.get授权标志();
    }

    private ST022InputBO buildInput() throws Exception {
        ST022InputBO input = new ST022InputBO();
        input.setOthBaseAcctNo("62010000001234");
        input.set因子名称("SCENE_FACTOR");
        input.setOthClientNo("10000001");
        input.setTranDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-31"));
        input.setTranTimestamp("10:00:00");
        return input;
    }

    /** 构造 ST043 成功输出：已匹配到限额场景 LS001（ST043 正式 Spec TBD-5 前按用例给定的取值）。 */
    private ST043OutputBO buildSt043Result() {
        ST043OutputBO result = new ST043OutputBO();
        result.setLimitSceneNo("LS001");
        result.setRuleRelationExpr("EXPR_001");
        result.setValidFlag("Y-启用");
        result.setSucceed(true);
        return result;
    }

    private ST038OutputBO buildSt038Result(String limitSceneNo) {
        ST038OutputBO result = new ST038OutputBO();
        result.setLimitSceneNo(limitSceneNo);
        result.setSucceed(true);
        return result;
    }

    private ST045OutputBO buildSt045Result(String limitSceneNo) {
        ST045OutputBO result = new ST045OutputBO();
        result.setLimitSceneNo(limitSceneNo);
        result.setSucceed(true);
        return result;
    }

    private ST037OutputBO buildSt037Result(String limitSceneNo) {
        ST037OutputBO result = new ST037OutputBO();
        result.setLimitSceneNo(limitSceneNo);
        result.setSucceed(true);
        return result;
    }

    private ST042OutputBO buildSt042Result(String limitSumAmt, int 否) {
        ST042OutputBO result = new ST042OutputBO();
        result.setLimitSumAmt(new BigDecimal(limitSumAmt));
        result.set否(否);
        result.setSucceed(true);
        return result;
    }

    private ST039OutputBO buildSt039Result(String limitSumAmt, int limitSumNum) {
        ST039OutputBO result = new ST039OutputBO();
        result.setLimitSumAmt(new BigDecimal(limitSumAmt));
        result.set限额累计笔数(limitSumNum);
        result.setSucceed(true);
        return result;
    }

    private ST040OutputBO buildSt040Result(String limitCheckResult) {
        ST040OutputBO result = new ST040OutputBO();
        result.setLimitCheckResult(limitCheckResult);
        result.setSucceed(true);
        return result;
    }

    private ST041OutputBO buildSt041Result(DealFlow dealFlow) {
        ST041OutputBO result = new ST041OutputBO();
        result.setDealFlow(dealFlow);
        result.setSucceed(true);
        return result;
    }

    private ST046OutputBO buildSt046Result() {
        ST046OutputBO result = new ST046OutputBO();
        result.setSucceed(true);
        return result;
    }

    private ST044OutputBO buildSt044Result() {
        ST044OutputBO result = new ST044OutputBO();
        result.setSucceed(true);
        return result;
    }
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;
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

/** ST005 检查支取账户限额 步骤单元测试，对应正式 Spec REQ-001~REQ-012 场景及用例 ST005-TC001~TC020。 */
@ExtendWith(MockitoExtension.class)
class ST005PbcTest {

    private static final BigDecimal AMT_500 = new BigDecimal("500.00");
    private static final BigDecimal AMT_1000 = new BigDecimal("1000.00");
    private static final BigDecimal AMT_1500 = new BigDecimal("1500.00");
    private static final BigDecimal AMT_0 = new BigDecimal("0.00");

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
    private ST005Pbc st005Pbc;

    // ST005-TC001（REQ-001-S01）：六项必填输入，全流程未超限→更新累计限额正常完成，输出契约字段与类型核对
    @Test
    void testST005T01() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class)))
                .thenReturn(st038Scene("S001", TranBranch.VALUE_351155));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 输出契约字段：逐一核对 getter 存在；更新路径除 limitBranchId 外输出均未赋值（TBD-11），limitBranchId 断言待 TBD-11 确认
        result.getTranStatus();
        assertNull(result.getTranStatus());
        assertNull(result.getLimitSumAmt());
        assertNull(result.get否());
        assertNull(result.get限额检查结果());
        result.getLimitBranchId();
        assertNull(result.getLimitSceneNo());
        assertNull(result.getCheckObjVal());
        assertNull(result.getEffectDate());
        assertNull(result.getExpireDate());
    }

    // ST005-TC002（REQ-002-S01→REQ-003-S02）：已匹配继续执行步骤3（ST038 以 baseAcctNo 调用），本次限额场景编码为空返回「通过」
    @Test
    void testST005T02() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        ArgumentCaptor<ST038InputBO> st038Captor = ArgumentCaptor.forClass(ST038InputBO.class);
        lenient().when(st038.execute(st038Captor.capture())).thenReturn(st038Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("ACC9001", st038Captor.getValue().getBaseAcctNo());
    }

    // ST005-TC003（REQ-002-S02）：未匹配返回「通过」正常提前结束，不执行步骤3及后续
    @Test
    void testST005T03() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(false));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC004（REQ-003-S01→REQ-004-S02）：取到限额场景编码继续步骤4（ST045 以 tranDate/tranTimestamp/limitSceneNo 调用），返回为空返回「通过」
    @Test
    void testST005T04() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        ArgumentCaptor<ST045InputBO> st045Captor = ArgumentCaptor.forClass(ST045InputBO.class);
        lenient().when(st045.execute(st045Captor.capture())).thenReturn(st045Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st045Captor.getValue().getLimitSceneNo());
        assertEquals(input.getTranDate(), st045Captor.getValue().getTranDate());
        assertEquals("101530", st045Captor.getValue().getTranTimestamp());
    }

    // ST005-TC005（REQ-003-S02）：限额场景编码为空返回「通过」，不执行步骤4及后续
    @Test
    void testST005T05() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC006（REQ-004-S01→REQ-005-S02）：配置有效继续步骤5（ST037 以 limitSceneNo/baseAcctNo/clientNo 调用），返回为空返回「通过」
    @Test
    void testST005T06() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        ArgumentCaptor<ST037InputBO> st037Captor = ArgumentCaptor.forClass(ST037InputBO.class);
        lenient().when(st037.execute(st037Captor.capture())).thenReturn(st037Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st037Captor.getValue().getLimitSceneNo());
        assertEquals("ACC9001", st037Captor.getValue().getBaseAcctNo());
        assertEquals("C1001", st037Captor.getValue().getClientNo());
    }

    // ST005-TC007（REQ-004-S02）：限额场景编码为空（交易不处于控制范围）返回「通过」，不执行步骤5及后续
    @Test
    void testST005T07() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC008（REQ-005-S01→REQ-006-S01）：取到场景编码继续步骤6（ST042 以 limitSceneNo/baseAcctNo/clientNo 调用），全流程未超限更新累计限额正常完成
    @Test
    void testST005T08() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        ArgumentCaptor<ST042InputBO> st042Captor = ArgumentCaptor.forClass(ST042InputBO.class);
        lenient().when(st042.execute(st042Captor.capture())).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st042Captor.getValue().getLimitSceneNo());
        assertEquals("ACC9001", st042Captor.getValue().getBaseAcctNo());
        assertEquals("C1001", st042Captor.getValue().getClientNo());
    }

    // ST005-TC009（REQ-005-S02）：限额场景编码为空返回「通过」，不执行步骤6及后续
    @Test
    void testST005T09() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene(null));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC010（REQ-006-S01→REQ-007-S01）：取得既有累计值 1000.00/5，继续步骤7（ST039 以 tranAmt/limitSceneNo 调用）
    @Test
    void testST005T10() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        ArgumentCaptor<ST039InputBO> st039Captor = ArgumentCaptor.forClass(ST039InputBO.class);
        lenient().when(st039.execute(st039Captor.capture())).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(0, st039Captor.getValue().getTranAmt().compareTo(AMT_500));
        assertEquals("S001", st039Captor.getValue().getLimitSceneNo());
    }

    // ST005-TC011（REQ-007-S01→REQ-008-S01）：ST039 计算后值 1500.00/6 供步骤8 检查（ST040 以 limitSceneNo/limitSumAmt/limitSumNum 调用）
    @Test
    void testST005T11() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        ArgumentCaptor<ST040InputBO> st040Captor = ArgumentCaptor.forClass(ST040InputBO.class);
        lenient().when(st040.execute(st040Captor.capture())).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st040Captor.getValue().getLimitSceneNo());
        assertEquals(0, st040Captor.getValue().getLimitSumAmt().compareTo(AMT_1500));
        assertEquals(Integer.valueOf(6), st040Captor.getValue().getLimitSumNum());
    }

    // ST005-TC012（REQ-008-S01）：未超限跳转步骤12 更新分支，不执行步骤10/11
    @Test
    void testST005T12() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        ArgumentCaptor<ST040InputBO> st040Captor = ArgumentCaptor.forClass(ST040InputBO.class);
        lenient().when(st040.execute(st040Captor.capture())).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st040Captor.getValue().getLimitSceneNo());
        assertEquals(0, st040Captor.getValue().getLimitSumAmt().compareTo(AMT_1500));
        assertEquals(Integer.valueOf(6), st040Captor.getValue().getLimitSumNum());
    }

    // ST005-TC013（REQ-008-S02→REQ-009-S03）：超限继续步骤10（ST041 以 limitSceneNo 调用），提示（DealFlow.D）返回「超限，但可继续交易」
    @Test
    void testST005T13() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("超限"));
        ArgumentCaptor<ST041InputBO> st041Captor = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(st041Captor.capture())).thenReturn(st041Flow(DealFlow.D));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st041Captor.getValue().getLimitSceneNo());
    }

    // ST005-TC014（REQ-009-S01）：拒绝（DealFlow.B）返回错误码 ER0058，步骤业务失败
    @Test
    void testST005T14() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("超限"));
        ArgumentCaptor<ST041InputBO> st041Captor = ArgumentCaptor.forClass(ST041InputBO.class);
        lenient().when(st041.execute(st041Captor.capture())).thenReturn(st041Flow(DealFlow.B));

        ST005OutputBO result = st005Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0058", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().contains("ER0058::交易超出限额控制"));
        assertEquals("S001", st041Captor.getValue().getLimitSceneNo());
    }

    // ST005-TC015（REQ-009-S02）：授权（DealFlow.A）返回「需授权」正常结论
    @Test
    void testST005T15() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("超限"));
        lenient().when(st041.execute(any(ST041InputBO.class))).thenReturn(st041Flow(DealFlow.A));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC016（REQ-009-S03）：提示（DealFlow.D）返回「超限，但可继续交易」正常结论
    @Test
    void testST005T16() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("超限"));
        lenient().when(st041.execute(any(ST041InputBO.class))).thenReturn(st041Flow(DealFlow.D));

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC017（REQ-010-S01）：金额 1500.00>0（或笔数 6>0）判定继续步骤13 更新累计限额
    @Test
    void testST005T17() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        lenient().when(st046.execute(any(ST046InputBO.class))).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC018（REQ-010-S02）：金额与笔数均为0 判定跳转步骤14 登记累计限额，不执行步骤13
    @Test
    void testST005T18() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_0, 0));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_0, 0));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        // 登记路径不执行步骤13（REQ-010-S02）：st046 设哨兵桩，若登记分支错误调用 ST046 则步骤执行抛异常使用例失败（行为级可观测，不使用 verify/never/times 计数交互）
        lenient().when(st046.execute(any(ST046InputBO.class)))
                .thenThrow(new IllegalStateException("ST005 登记路径不应调用 ST046（REQ-010-S02 不执行步骤13）"));
        lenient().when(st044.execute(any(ST044InputBO.class))).thenReturn(st044Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST005-TC019（REQ-011-S01）：以 S001/C1001/ACC9001 调用 ST046 更新累计限额
    @Test
    void testST005T19() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_1000, 5));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_1500, 6));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        ArgumentCaptor<ST046InputBO> st046Captor = ArgumentCaptor.forClass(ST046InputBO.class);
        lenient().when(st046.execute(st046Captor.capture())).thenReturn(st046Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st046Captor.getValue().getLimitSceneNo());
        assertEquals("C1001", st046Captor.getValue().getClientNo());
        assertEquals("ACC9001", st046Captor.getValue().getBaseAcctNo());
    }

    // ST005-TC020（REQ-012-S01）：以 S001/C1001/ACC9001 调用 ST044 登记累计限额
    @Test
    void testST005T20() {
        ST005InputBO input = buildInput();
        lenient().when(st043.execute(any(ST043InputBO.class))).thenReturn(st043Scene(true));
        lenient().when(st038.execute(any(ST038InputBO.class))).thenReturn(st038Scene("S001"));
        lenient().when(st045.execute(any(ST045InputBO.class))).thenReturn(st045Scene("S001"));
        lenient().when(st037.execute(any(ST037InputBO.class))).thenReturn(st037Scene("S001"));
        lenient().when(st042.execute(any(ST042InputBO.class))).thenReturn(st042Result(AMT_0, 0));
        lenient().when(st039.execute(any(ST039InputBO.class))).thenReturn(st039Result(AMT_0, 0));
        lenient().when(st040.execute(any(ST040InputBO.class))).thenReturn(st040Result("未超限"));
        // 登记路径不执行步骤13（REQ-010-S02/REQ-012-S01）：st046 设哨兵桩，若登记分支错误调用 ST046 则步骤执行抛异常使用例失败（行为级可观测，不使用 verify/never/times 计数交互）
        lenient().when(st046.execute(any(ST046InputBO.class)))
                .thenThrow(new IllegalStateException("ST005 登记路径不应调用 ST046（REQ-010-S02 不执行步骤13）"));
        ArgumentCaptor<ST044InputBO> st044Captor = ArgumentCaptor.forClass(ST044InputBO.class);
        lenient().when(st044.execute(st044Captor.capture())).thenReturn(st044Pass());

        ST005OutputBO result = st005Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("S001", st044Captor.getValue().getLimitSceneNo());
        assertEquals("C1001", st044Captor.getValue().getClientNo());
        assertEquals("ACC9001", st044Captor.getValue().getBaseAcctNo());
    }

    private ST005InputBO buildInput() {
        ST005InputBO input = new ST005InputBO();
        input.setClientNo("C1001");
        input.setBaseAcctNo("ACC9001");
        input.set因子名称("FD001");
        input.setTranDate(buildTranDate());
        input.setTranTimestamp("101530");
        input.setTranAmt(AMT_500);
        return input;
    }

    private Date buildTranDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2026, Calendar.NOVEMBER, 2);
        return calendar.getTime();
    }

    private ST043OutputBO st043Scene(boolean matched) {
        ST043OutputBO result = new ST043OutputBO();
        result.setSucceed(true);
        if (matched) {
            result.setLimitSceneNo("S001");
        }
        return result;
    }

    private ST038OutputBO st038Scene(String sceneNo) {
        return st038Scene(sceneNo, null);
    }

    private ST038OutputBO st038Scene(String sceneNo, TranBranch limitBranchId) {
        ST038OutputBO result = new ST038OutputBO();
        result.setSucceed(true);
        result.setLimitSceneNo(sceneNo);
        result.setLimitBranchId(limitBranchId);
        return result;
    }

    private ST045OutputBO st045Scene(String sceneNo) {
        ST045OutputBO result = new ST045OutputBO();
        result.setSucceed(true);
        result.setLimitSceneNo(sceneNo);
        return result;
    }

    private ST037OutputBO st037Scene(String sceneNo) {
        ST037OutputBO result = new ST037OutputBO();
        result.setSucceed(true);
        result.setLimitSceneNo(sceneNo);
        return result;
    }

    private ST042OutputBO st042Result(BigDecimal limitSumAmt, Integer limitSumNum) {
        ST042OutputBO result = new ST042OutputBO();
        result.setSucceed(true);
        result.setLimitSumAmt(limitSumAmt);
        result.set否(limitSumNum);
        return result;
    }

    private ST039OutputBO st039Result(BigDecimal limitSumAmt, Integer limitSumNum) {
        ST039OutputBO result = new ST039OutputBO();
        result.setSucceed(true);
        result.setLimitSumAmt(limitSumAmt);
        result.set限额累计笔数(limitSumNum);
        return result;
    }

    private ST040OutputBO st040Result(String limitCheckResult) {
        ST040OutputBO result = new ST040OutputBO();
        result.setSucceed(true);
        result.setLimitCheckResult(limitCheckResult);
        return result;
    }

    private ST041OutputBO st041Flow(DealFlow dealFlow) {
        ST041OutputBO result = new ST041OutputBO();
        result.setSucceed(true);
        result.setDealFlow(dealFlow);
        return result;
    }

    private ST046OutputBO st046Pass() {
        ST046OutputBO result = new ST046OutputBO();
        result.setSucceed(true);
        return result;
    }

    private ST044OutputBO st044Pass() {
        ST044OutputBO result = new ST044OutputBO();
        result.setSucceed(true);
        return result;
    }
}

package com.dcits.deposit.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.common.step.StepResult;
import com.dcits.common.task.RespHeader;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST048InputBO;
import com.dcits.deposit.facade.bo.ST048OutputBO;
import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST053InputBO;
import com.dcits.deposit.facade.bo.ST053OutputBO;
import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;
import com.dcits.deposit.facade.bo.ST059InputBO;
import com.dcits.deposit.facade.bo.ST059OutputBO;
import com.dcits.deposit.facade.bo.ST060InputBO;
import com.dcits.deposit.facade.bo.ST060OutputBO;
import com.dcits.deposit.facade.bo.ST061InputBO;
import com.dcits.deposit.facade.bo.ST061OutputBO;
import com.dcits.deposit.facade.bo.ST062InputBO;
import com.dcits.deposit.facade.bo.ST062OutputBO;
import com.dcits.deposit.step.IST048;
import com.dcits.deposit.step.IST049;
import com.dcits.deposit.step.IST050;
import com.dcits.deposit.step.IST051;
import com.dcits.deposit.step.IST052;
import com.dcits.deposit.step.IST053;
import com.dcits.deposit.step.IST054;
import com.dcits.deposit.step.IST055;
import com.dcits.deposit.step.IST056;
import com.dcits.deposit.step.IST057;
import com.dcits.deposit.step.IST058;
import com.dcits.deposit.step.IST059;
import com.dcits.deposit.step.IST060;
import com.dcits.deposit.step.IST061;
import com.dcits.deposit.step.IST062;
import com.dcits.deposit.task.dto.T2S1InputDTO;
import com.dcits.deposit.task.dto.T2S1OutputDTO;
import com.dcits.deposit.task.scenario.T2S1;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * T2S1 检查账户限制 单元测试，覆盖测试用例 T2S1-TC001 至 TC006。
 *
 * <p>步骤接口全部以 {@code @Mock} 桩替身，成功桩显式 {@code setSucceed(true)}；按用例
 * 要求通过 {@code thenAnswer} 捕获步骤收到的 InputBO 断言输入映射与字段传递，不使用
 * verify/times/InOrder（技能约束）。同一桩后续重新以 lenient 覆盖时后写桩生效。</p>
 */
@ExtendWith(MockitoExtension.class)
class T2S1Test {

    @Mock
    private IST048 ist048;
    @Mock
    private IST049 ist049;
    @Mock
    private IST050 ist050;
    @Mock
    private IST051 ist051;
    @Mock
    private IST052 ist052;
    @Mock
    private IST053 ist053;
    @Mock
    private IST054 ist054;
    @Mock
    private IST055 ist055;
    @Mock
    private IST056 ist056;
    @Mock
    private IST057 ist057;
    @Mock
    private IST058 ist058;
    @Mock
    private IST059 ist059;
    @Mock
    private IST060 ist060;
    @Mock
    private IST061 ist061;
    @Mock
    private IST062 ist062;

    @InjectMocks
    private T2S1 t2s1;

    /**
     * 构造用例入参：四个必填输入。
     */
    private static T2S1InputDTO newInput() {
        T2S1InputDTO input = new T2S1InputDTO();
        input.setBaseAcctNo("6221000000000001");
        input.setTranType("1000");
        input.setSourceType("MT");
        input.setRestraintType("13");
        return input;
    }

    /**
     * 将步骤输出 BO 置为成功并返回自身。
     */
    private static <T extends StepResult> T success(T bo) {
        bo.setSucceed(true);
        bo.setErrorCode(null);
        bo.setErrorMessage(null);
        return bo;
    }

    /**
     * 捕获步骤收到的输入 BO。
     */
    private static <T> AtomicReference<T> capture() {
        return new AtomicReference<>();
    }

    /**
     * 15 个步骤全部以 lenient 桩返回成功输出；需差异化或捕获参数的测试在调用本方法后重新覆盖对应桩。
     */
    private void stubAllSucceed() {
        Mockito.lenient().when(ist048.execute(any(ST048InputBO.class))).thenReturn(success(new ST048OutputBO()));
        Mockito.lenient().when(ist049.execute(any(ST049InputBO.class))).thenReturn(success(new ST049OutputBO()));
        Mockito.lenient().when(ist050.execute(any(ST050InputBO.class))).thenReturn(success(new ST050OutputBO()));
        Mockito.lenient().when(ist051.execute(any(ST051InputBO.class))).thenReturn(success(new ST051OutputBO()));
        Mockito.lenient().when(ist052.execute(any(ST052InputBO.class))).thenReturn(success(new ST052OutputBO()));
        Mockito.lenient().when(ist053.execute(any(ST053InputBO.class))).thenReturn(success(new ST053OutputBO()));
        Mockito.lenient().when(ist054.execute(any(ST054InputBO.class))).thenReturn(success(new ST054OutputBO()));
        Mockito.lenient().when(ist055.execute(any(ST055InputBO.class))).thenReturn(success(new ST055OutputBO()));
        Mockito.lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(success(new ST056OutputBO()));
        Mockito.lenient().when(ist057.execute(any(ST057InputBO.class))).thenReturn(success(new ST057OutputBO()));
        Mockito.lenient().when(ist058.execute(any(ST058InputBO.class))).thenReturn(success(new ST058OutputBO()));
        Mockito.lenient().when(ist059.execute(any(ST059InputBO.class))).thenReturn(success(new ST059OutputBO()));
        Mockito.lenient().when(ist060.execute(any(ST060InputBO.class))).thenReturn(success(new ST060OutputBO()));
        Mockito.lenient().when(ist061.execute(any(ST061InputBO.class))).thenReturn(success(new ST061OutputBO()));
        Mockito.lenient().when(ist062.execute(any(ST062InputBO.class))).thenReturn(success(new ST062OutputBO()));
    }

    @Test
    void testT2S1T01() {
        // TC001 提供四个必填输入，15 个步骤全部正常完成后接口成功结束，四个输入按 REQ-003 映射传递至首步 ST048
        stubAllSucceed();
        ST048OutputBO st048Output = success(new ST048OutputBO());
        st048Output.setProdNo("P0001");
        st048Output.setTranTypeLink("1000");
        st048Output.setChannelMuster("MT");
        st048Output.setNarrativeCode("N0001");
        AtomicReference<ST048InputBO> st048InputRef = capture();
        Mockito.lenient().when(ist048.execute(any(ST048InputBO.class))).thenAnswer(invocation -> {
            st048InputRef.set(invocation.getArgument(0));
            return st048Output;
        });

        RespHeader header = new RespHeader();
        T2S1OutputDTO output = t2s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertNotNull(output);
        ST048InputBO st048Input = st048InputRef.get();
        assertNotNull(st048Input);
        assertEquals(SourceType.MT, st048Input.getSourceType());
        assertEquals(RestraintType.VALUE_13, st048Input.getRestraintType());
        assertEquals(TranType.VALUE_1000, st048Input.getTranType());
    }

    @Test
    void testT2S1T02() {
        // TC002 15 个步骤按「执行步骤」表顺序依次执行，ST051 先于 ST059 完成，其[账户限制信息]作为 ST059 输入集合（REQ-002-S01、REQ-004-S01）
        stubAllSucceed();
        ST051OutputBO st051Output = success(new ST051OutputBO());
        st051Output.setResSeqNo("R0001");
        st051Output.setRestraintType(RestraintType.VALUE_13);
        st051Output.setRestraintsStatus(RestraintsStatus.A);
        st051Output.setBaseAcctNo("622200001234");
        st051Output.setLeadAcctFlag("Y");
        Mockito.lenient().when(ist051.execute(any(ST051InputBO.class))).thenReturn(st051Output);
        ST059OutputBO st059Output = success(new ST059OutputBO());
        st059Output.setAllowCloseFlag("N");
        AtomicReference<ST059InputBO> st059InputRef = capture();
        Mockito.lenient().when(ist059.execute(any(ST059InputBO.class))).thenAnswer(invocation -> {
            st059InputRef.set(invocation.getArgument(0));
            return st059Output;
        });

        RespHeader header = new RespHeader();
        t2s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        ST059InputBO st059Input = st059InputRef.get();
        assertNotNull(st059Input);
        assertNotNull(st059Input.getRestraintList());
        assertFalse(st059Input.getRestraintList().isEmpty());
    }

    @Test
    void testT2S1T03() {
        // TC003 baseAcctNo 传递至以账号为必填输入的 12 个步骤（REQ-003-S01）
        stubAllSucceed();
        AtomicReference<ST049InputBO> st049InputRef = capture();
        Mockito.lenient().when(ist049.execute(any(ST049InputBO.class))).thenAnswer(invocation -> {
            st049InputRef.set(invocation.getArgument(0));
            return success(new ST049OutputBO());
        });
        AtomicReference<ST050InputBO> st050InputRef = capture();
        Mockito.lenient().when(ist050.execute(any(ST050InputBO.class))).thenAnswer(invocation -> {
            st050InputRef.set(invocation.getArgument(0));
            return success(new ST050OutputBO());
        });
        AtomicReference<ST051InputBO> st051InputRef = capture();
        Mockito.lenient().when(ist051.execute(any(ST051InputBO.class))).thenAnswer(invocation -> {
            st051InputRef.set(invocation.getArgument(0));
            return success(new ST051OutputBO());
        });
        AtomicReference<ST052InputBO> st052InputRef = capture();
        Mockito.lenient().when(ist052.execute(any(ST052InputBO.class))).thenAnswer(invocation -> {
            st052InputRef.set(invocation.getArgument(0));
            return success(new ST052OutputBO());
        });
        AtomicReference<ST053InputBO> st053InputRef = capture();
        Mockito.lenient().when(ist053.execute(any(ST053InputBO.class))).thenAnswer(invocation -> {
            st053InputRef.set(invocation.getArgument(0));
            return success(new ST053OutputBO());
        });
        AtomicReference<ST054InputBO> st054InputRef = capture();
        Mockito.lenient().when(ist054.execute(any(ST054InputBO.class))).thenAnswer(invocation -> {
            st054InputRef.set(invocation.getArgument(0));
            return success(new ST054OutputBO());
        });
        AtomicReference<ST055InputBO> st055InputRef = capture();
        Mockito.lenient().when(ist055.execute(any(ST055InputBO.class))).thenAnswer(invocation -> {
            st055InputRef.set(invocation.getArgument(0));
            return success(new ST055OutputBO());
        });
        AtomicReference<ST056InputBO> st056InputRef = capture();
        Mockito.lenient().when(ist056.execute(any(ST056InputBO.class))).thenAnswer(invocation -> {
            st056InputRef.set(invocation.getArgument(0));
            return success(new ST056OutputBO());
        });
        AtomicReference<ST058InputBO> st058InputRef = capture();
        Mockito.lenient().when(ist058.execute(any(ST058InputBO.class))).thenAnswer(invocation -> {
            st058InputRef.set(invocation.getArgument(0));
            return success(new ST058OutputBO());
        });
        AtomicReference<ST060InputBO> st060InputRef = capture();
        Mockito.lenient().when(ist060.execute(any(ST060InputBO.class))).thenAnswer(invocation -> {
            st060InputRef.set(invocation.getArgument(0));
            return success(new ST060OutputBO());
        });
        AtomicReference<ST061InputBO> st061InputRef = capture();
        Mockito.lenient().when(ist061.execute(any(ST061InputBO.class))).thenAnswer(invocation -> {
            st061InputRef.set(invocation.getArgument(0));
            return success(new ST061OutputBO());
        });
        AtomicReference<ST062InputBO> st062InputRef = capture();
        Mockito.lenient().when(ist062.execute(any(ST062InputBO.class))).thenAnswer(invocation -> {
            st062InputRef.set(invocation.getArgument(0));
            return success(new ST062OutputBO());
        });

        RespHeader header = new RespHeader();
        t2s1.execute(header, newInput());

        assertEquals("6221000000000001", st049InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st050InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st051InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st052InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st053InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st054InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st055InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st056InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st058InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st060InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st061InputRef.get().getBaseAcctNo());
        assertEquals("6221000000000001", st062InputRef.get().getBaseAcctNo());
        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
    }

    @Test
    void testT2S1T04() {
        // TC004 tranType/sourceType/restraintType 映射为枚举取值传递至 ST048 与 ST057（REQ-003-S02），narrativeCode/产品类型无接口来源（TBD-1）不作断言
        stubAllSucceed();
        AtomicReference<ST048InputBO> st048InputRef = capture();
        Mockito.lenient().when(ist048.execute(any(ST048InputBO.class))).thenAnswer(invocation -> {
            st048InputRef.set(invocation.getArgument(0));
            return success(new ST048OutputBO());
        });
        ST057OutputBO st057Output = success(new ST057OutputBO());
        st057Output.setResPriority("1");
        AtomicReference<ST057InputBO> st057InputRef = capture();
        Mockito.lenient().when(ist057.execute(any(ST057InputBO.class))).thenAnswer(invocation -> {
            st057InputRef.set(invocation.getArgument(0));
            return st057Output;
        });

        RespHeader header = new RespHeader();
        t2s1.execute(header, newInput());

        ST048InputBO st048Input = st048InputRef.get();
        assertNotNull(st048Input);
        assertEquals(SourceType.MT, st048Input.getSourceType());
        assertEquals(RestraintType.VALUE_13, st048Input.getRestraintType());
        assertEquals(TranType.VALUE_1000, st048Input.getTranType());
        ST057InputBO st057Input = st057InputRef.get();
        assertNotNull(st057Input);
        assertEquals(TranType.VALUE_1000, st057Input.getTranType());
        assertEquals(RestraintType.VALUE_13, st057Input.getRestraintType());
        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
    }

    @Test
    void testT2S1T05() {
        // TC005 ST051 返回的[账户限制信息]作为 ST059 输入集合中的单条记录，逐字段与 ST051 输出一致（REQ-004-S01），restraintLevel 来源未定义（TBD-5）不作断言
        stubAllSucceed();
        ST051OutputBO st051Output = success(new ST051OutputBO());
        st051Output.setResSeqNo("R0001");
        st051Output.setRestraintType(RestraintType.VALUE_13);
        st051Output.setRestraintsStatus(RestraintsStatus.A);
        st051Output.setBaseAcctNo("622200001234");
        st051Output.setLeadAcctFlag("Y");
        Mockito.lenient().when(ist051.execute(any(ST051InputBO.class))).thenReturn(st051Output);
        ST059OutputBO st059Output = success(new ST059OutputBO());
        st059Output.setAllowCloseFlag("N");
        AtomicReference<ST059InputBO> st059InputRef = capture();
        Mockito.lenient().when(ist059.execute(any(ST059InputBO.class))).thenAnswer(invocation -> {
            st059InputRef.set(invocation.getArgument(0));
            return st059Output;
        });

        RespHeader header = new RespHeader();
        t2s1.execute(header, newInput());

        ST059InputBO st059Input = st059InputRef.get();
        assertNotNull(st059Input);
        assertNotNull(st059Input.getRestraintList());
        assertEquals(1, st059Input.getRestraintList().size());
        ST059InputBO.RestraintInfo restraintInfo = st059Input.getRestraintList().get(0);
        assertEquals("R0001", restraintInfo.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, restraintInfo.getRestraintType());
        assertEquals(RestraintsStatus.A, restraintInfo.getRestraintsStatus());
        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
    }

    @Test
    void testT2S1T06() {
        // TC006 全部步骤正常完成时输出 DTO 携带 12 个已确认业务输出字段，取值与对应步骤输出一致，成功响应（REQ-005-S01）；其余 19 个字段（TBD-4/6/7）不作断言
        stubAllSucceed();
        ST061OutputBO st061Output = success(new ST061OutputBO());
        st061Output.set属性限制标志("是");
        Mockito.lenient().when(ist061.execute(any(ST061InputBO.class))).thenReturn(st061Output);
        ST055OutputBO st055Output = success(new ST055OutputBO());
        st055Output.setStopFlag("是");
        Mockito.lenient().when(ist055.execute(any(ST055InputBO.class))).thenReturn(st055Output);
        ST058OutputBO st058Output = success(new ST058OutputBO());
        st058Output.setNoCreditNoDebitFlag("是");
        Mockito.lenient().when(ist058.execute(any(ST058InputBO.class))).thenReturn(st058Output);
        ST060OutputBO st060Output = success(new ST060OutputBO());
        st060Output.setCashNoReceiveNoPayFlag("是");
        Mockito.lenient().when(ist060.execute(any(ST060InputBO.class))).thenReturn(st060Output);
        ST056OutputBO st056Output = success(new ST056OutputBO());
        st056Output.setTransferNoCreditNoDebitFlag("是");
        Mockito.lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(st056Output);
        ST048OutputBO st048Output = success(new ST048OutputBO());
        st048Output.setProdNo("P0001");
        st048Output.setTranTypeLink("1000");
        st048Output.setChannelMuster("MT");
        st048Output.setNarrativeCode("N0001");
        Mockito.lenient().when(ist048.execute(any(ST048InputBO.class))).thenReturn(st048Output);
        ST051OutputBO st051Output = success(new ST051OutputBO());
        st051Output.setBaseAcctNo("622200001234");
        st051Output.setLeadAcctFlag("Y");
        st051Output.setResSeqNo("R0001");
        st051Output.setRestraintType(RestraintType.VALUE_13);
        st051Output.setRestraintsStatus(RestraintsStatus.A);
        Mockito.lenient().when(ist051.execute(any(ST051InputBO.class))).thenReturn(st051Output);
        ST053OutputBO st053Output = success(new ST053OutputBO());
        st053Output.setPledgedFlag("Y");
        Mockito.lenient().when(ist053.execute(any(ST053InputBO.class))).thenReturn(st053Output);

        RespHeader header = new RespHeader();
        T2S1OutputDTO output = t2s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("是", output.get属性限制标志());
        assertEquals("是", output.getStopFlag());
        assertEquals("是", output.get不收不付标志());
        assertEquals("是", output.get现金不收不付限制标志());
        assertEquals("是", output.get转账不收不付标志());
        assertEquals("622200001234", output.getBaseAcctNo());
        assertEquals("Y", output.getLeadAcctFlag());
        assertEquals("P0001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT", output.getChannelMuster());
        assertEquals("N0001", output.getNarrativeCode());
        assertEquals("Y", output.getPledgedFlag());
    }
}

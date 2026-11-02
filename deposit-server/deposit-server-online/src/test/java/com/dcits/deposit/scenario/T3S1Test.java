package com.dcits.deposit.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.common.step.StepResult;
import com.dcits.common.task.RespHeader;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.step.IST036;
import com.dcits.deposit.task.dto.T3S1InputDTO;
import com.dcits.deposit.task.dto.T3S1OutputDTO;
import com.dcits.deposit.task.scenario.T3S1;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * T3S1 检查黑名单 交易接口场景单元测试。
 *
 * <p>对应正式 Spec T3S1 的 REQ-001（15 个输入字段映射到 ST036InputBO 并调用唯一执行
 * 步骤 IST036.execute）、REQ-002（业务输出 dealFlow 原样传递）、REQ-003（步骤执行状态
 * 原样传递为响应执行状态，失败时短路）。接口层 String↔枚举转换口径见 Spec TBD-1，
 * 必填输入缺失行为见 Spec TBD-2，均不作为已确认断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class T3S1Test {

    @Mock
    private IST036 ist036;

    @InjectMocks
    private T3S1 t3s1;

    @Test
    void testT3S1T01() {
        // T3S1-TC001：十五个输入字段按业务含义映射到 ST036InputBO 并调用唯一执行步骤 IST036.execute；ST036 返回「通过」（succeed=true、错误字段为 null、未设置 dealFlow），响应执行状态为成功，业务输出 dealFlow 为空（REQ-001-S01、REQ-002-S01、REQ-003-S01）
        ST036OutputBO st036Output = success(new ST036OutputBO());
        AtomicReference<ST036InputBO> st036InputRef = capture();
        Mockito.lenient().when(ist036.execute(any(ST036InputBO.class))).thenAnswer(invocation -> {
            st036InputRef.set(invocation.getArgument(0));
            return st036Output;
        });

        RespHeader header = new RespHeader();
        T3S1OutputDTO output = t3s1.execute(header, newInput());

        assertNotNull(output);
        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());

        ST036InputBO st036Input = st036InputRef.get();
        assertNotNull(st036Input);
        assertEquals(DocClass.DCT, st036Input.getDocClass());
        assertEquals("RB1000000001", st036Input.getBaseAcctNo());
        assertEquals(TranBranch.VALUE_351155, st036Input.getAcctBranch());
        assertEquals(SourceType.CIP, st036Input.getSourceType());
        assertEquals("TRD0001", st036Input.getProgramId());
        assertEquals(TranType.VALUE_4308, st036Input.getTranType());
        assertEquals("T01", st036Input.getEventType());
        assertEquals("SVC0001", st036Input.getServiceCode());
        assertEquals("TRD", st036Input.getMessageType());
        assertEquals("CIFDP0001", st036Input.getMessageCode());
        assertEquals("Y-是", st036Input.getBlacklistCheckFlag());
        assertEquals("A-生效", st036Input.getServiceStatus());
        assertEquals("C000000001", st036Input.getClientNo());
        assertEquals("110101199001011234", st036Input.getDocumentId());
        assertEquals(DocumentType.VALUE_110001, st036Input.getDocumentType());
        assertNull(output.getDealFlow());
    }

    @Test
    void testT3S1T02() {
        // T3S1-TC002：ST036 返回「拒绝」（dealFlow=DealFlow.B），交易接口业务输出 dealFlow 取「拒绝」对应处理方式（String 值 "B"），响应执行状态成功（REQ-002-S02、REQ-003-S01）
        ST036OutputBO st036Output = success(new ST036OutputBO());
        st036Output.setDealFlow(DealFlow.B);
        Mockito.lenient().when(ist036.execute(any(ST036InputBO.class))).thenReturn(st036Output);

        RespHeader header = new RespHeader();
        T3S1OutputDTO output = t3s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals(DealFlow.B.getValue(), output.getDealFlow());
    }

    @Test
    void testT3S1T03() {
        // T3S1-TC003：ST036 返回「授权」（dealFlow=DealFlow.A），交易接口业务输出 dealFlow 取「授权」对应处理方式（String 值 "A"），响应执行状态成功（REQ-002-S03、REQ-003-S01）
        ST036OutputBO st036Output = success(new ST036OutputBO());
        st036Output.setDealFlow(DealFlow.A);
        Mockito.lenient().when(ist036.execute(any(ST036InputBO.class))).thenReturn(st036Output);

        RespHeader header = new RespHeader();
        T3S1OutputDTO output = t3s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals(DealFlow.A.getValue(), output.getDealFlow());
    }

    @Test
    void testT3S1T04() {
        // T3S1-TC004：ST036 返回「提醒」（dealFlow=DealFlow.D），交易接口业务输出 dealFlow 取「提醒」对应处理方式（String 值 "D"），响应执行状态成功（REQ-002-S04、REQ-003-S01）
        ST036OutputBO st036Output = success(new ST036OutputBO());
        st036Output.setDealFlow(DealFlow.D);
        Mockito.lenient().when(ist036.execute(any(ST036InputBO.class))).thenReturn(st036Output);

        RespHeader header = new RespHeader();
        T3S1OutputDTO output = t3s1.execute(header, newInput());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals(DealFlow.D.getValue(), output.getDealFlow());
    }

    @Test
    void testT3S1T05() {
        // T3S1-TC005：ST036 返回 succeed=false 及 errorCode/errorMessage，交易接口短路，以失败执行状态原样透传 errorCode/errorMessage，不设置业务输出 dealFlow（REQ-003-S02）
        ST036OutputBO st036Output = new ST036OutputBO();
        st036Output.setSucceed(false);
        st036Output.setErrorCode("ST036-ERR-0001");
        st036Output.setErrorMessage("blacklist check step execution failed");
        Mockito.lenient().when(ist036.execute(any(ST036InputBO.class))).thenReturn(st036Output);

        RespHeader header = new RespHeader();
        T3S1OutputDTO output = t3s1.execute(header, newInput());

        assertFalse(header.isSucceed());
        assertEquals("ST036-ERR-0001", header.getErrorCode());
        assertEquals("blacklist check step execution failed", header.getErrorMessage());
        assertNull(output.getDealFlow());
    }

    private static <T extends StepResult> T success(T bo) {
        bo.setSucceed(true);
        bo.setErrorCode(null);
        bo.setErrorMessage(null);
        return bo;
    }

    private static <T> AtomicReference<T> capture() {
        return new AtomicReference<>();
    }

    private static T3S1InputDTO newInput() {
        T3S1InputDTO input = new T3S1InputDTO();
        input.setDocClass("DCT");
        input.setBaseAcctNo("RB1000000001");
        input.setAcctBranch("351155");
        input.setSourceType("CIP");
        input.setProgramId("TRD0001");
        input.setTranType("4308");
        input.setEventType("T01");
        input.setServiceCode("SVC0001");
        input.setMessageType("TRD");
        input.setMessageCode("CIFDP0001");
        input.setBlacklistCheckFlag("Y-是");
        input.setServiceStatus("A-生效");
        input.setClientNo("C000000001");
        input.setDocumentId("110101199001011234");
        input.setDocumentType("110001");
        return input;
    }
}

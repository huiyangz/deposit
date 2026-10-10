package com.dcits.depsit.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.common.task.RespHeader;
import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST100InputBO;
import com.dcits.depsit.facade.bo.ST100OutputBO;
import com.dcits.depsit.step.IST100;
import com.dcits.depsit.task.dto.T5S1InputDTO;
import com.dcits.depsit.task.dto.T5S1OutputDTO;
import com.dcits.depsit.task.scenario.T5S1;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * T5S1 检查黑名单 —— 单元测试。
 *
 * <p>调用签名：{@code T5S1OutputDTO execute(RespHeader header, T5S1InputDTO input)}。用例依据本轮
 * 正式 Spec 与 {@code outputs/测试用例.md}／{@code .json} 的 9 个用例设计：命中「拒绝」「授权」
 * 「提醒」三条有值路径、「通过」无值路径、枚举入参按业务码值转换、输入与输出契约（字段集合与
 * 类型）、依赖声明结构、复用响应头的成功清理。</p>
 *
 * <p>唯一被调步骤 {@link IST100} 整体桩化：{@code execute} 按用例返回构造好的
 * {@link ST100OutputBO}；需要核对入参映射的用例用 {@link AtomicReference} 捕获实参并逐字段断言
 * （桩不忽略入参，避免「传值被丢弃」的实现仍通过）。按技能约定不 mock／spy 被测场景，不使用
 * {@code verify}／{@code never}／{@code times}／{@code InOrder}，不模拟技术异常，也不访问数据库
 * 或网络。</p>
 *
 * <p>本交易唯一被调步骤声明无业务失败场景（Spec REQ-007；不覆盖事项 4：步骤返回
 * {@code succeed = false} 在可达路径下不发生），需求亦无「## 失败处理」章节与已确认错误码来源，
 * 故未设计失败短路用例、未读取任何 {@code errorcodes.properties} 键。</p>
 */
@ExtendWith(MockitoExtension.class)
class T5S1Test {

    @Mock
    private IST100 st100;

    @InjectMocks
    private T5S1 t5s1;

    // T5S1-TC001：REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-004-S01、REQ-005-S01、REQ-006-S01 ——
    // 命中「拒绝」：15 个交易入参逐字段传入 ST100InputBO（5 个枚举按码值转换），
    // 步骤输出 DealFlow.B 映射为交易输出 "B"，返回成功响应
    @Test
    void testT5S1T01() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.B);
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("CHK", "6222021234567890123", "351155", "CH", "T0001", "31",
                "EV01", "SVC01", "RQ", "MB1001", "Y", "A", "C000000001", "140101199001011234", "110001");

        T5S1OutputDTO output = t5s1.execute(header, input);

        ST100InputBO captured = capturedInputBo.get();
        assertNotNull(captured);
        assertEquals("6222021234567890123", captured.getBaseAcctNo());
        assertEquals("T0001", captured.getProgramId());
        assertEquals("EV01", captured.getEventType());
        assertEquals("SVC01", captured.getServiceCode());
        assertEquals("RQ", captured.getMessageType());
        assertEquals("MB1001", captured.getMessageCode());
        assertEquals("Y", captured.getBlacklistCheckFlag());
        assertEquals("A", captured.getServiceStatus());
        assertEquals("C000000001", captured.getClientNo());
        assertEquals("140101199001011234", captured.getDocumentId());
        assertSame(DocClass.CHK, captured.getDocClass());
        assertSame(TranBranch.VALUE_351155, captured.getAcctBranch());
        assertSame(SourceType.CH, captured.getSourceType());
        assertSame(TranType.VALUE_31, captured.getTranType());
        assertSame(DocumentType.VALUE_110001, captured.getDocumentType());

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("B", output.getDealFlow());
        assertNotEquals("A", output.getDealFlow());
        assertNotEquals("D", output.getDealFlow());
    }

    // T5S1-TC002：REQ-004-S02 —— 命中「授权」：步骤输出 DealFlow.A 映射为交易输出 "A"，
    // 与步骤输出一致；入参映射按码值转换（TranBranch）且桩未忽略入参
    @Test
    void testT5S1T02() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.A);
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("BNK", "6222021234567890456", "351156", "BC", "T0002", "32",
                "EV02", "SVC02", "RQ", "MB1002", "Y", "A", "C000000002", "310101198505054321", "110003");

        T5S1OutputDTO output = t5s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("A", output.getDealFlow());
        assertNotEquals("B", output.getDealFlow());
        assertNotEquals("D", output.getDealFlow());
        assertSame(TranBranch.VALUE_351156, capturedInputBo.get().getAcctBranch());
        assertEquals("MB1002", capturedInputBo.get().getMessageCode());
    }

    // T5S1-TC003：REQ-004-S02 —— 命中「提醒」：步骤输出 DealFlow.D 映射为交易输出 "D"，
    // 与步骤输出一致；另一支取值（A 与 B）均不出现
    @Test
    void testT5S1T03() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.D);
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("CHQ", "6222021234567890789", "351157", "CA", "T0003", "34",
                "EV03", "SVC03", "RQ", "MB1003", "Y", "A", "C000000003", "440101199203031111", "110005");

        T5S1OutputDTO output = t5s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("D", output.getDealFlow());
        assertNotEquals("A", output.getDealFlow());
        assertNotEquals("B", output.getDealFlow());
        assertSame(SourceType.CA, capturedInputBo.get().getSourceType());
        assertSame(TranType.VALUE_34, capturedInputBo.get().getTranType());
    }

    // T5S1-TC004：REQ-004-S03、REQ-006-S02、REQ-007-S01 —— 检查结果为「通过」（边界否定路径）：
    // 步骤正常完成但 dealFlow 无值，交易输出保持无取值、不以业务常量占位、不改写为 B／A／D，
    // 且仍返回成功响应；无值形态（null 或空字符串）按 Spec 不覆盖事项 2 不作断言
    @Test
    void testT5S1T04() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            ST100OutputBO outputBo = new ST100OutputBO();
            outputBo.setSucceed(true);
            return outputBo;
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("CRD", "6222021234567890111", "351158", "AB", "T0004", "35",
                "EV04", "SVC04", "RQ", "MB1004", "N", "A", "C000000004", "510101197705056666", "110007");

        T5S1OutputDTO output = t5s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertNotNull(output);
        assertTrue(output.getDealFlow() == null || output.getDealFlow().isEmpty());
        assertNotEquals("B", output.getDealFlow());
        assertNotEquals("A", output.getDealFlow());
        assertNotEquals("D", output.getDealFlow());
        assertNotEquals("N", output.getDealFlow());
        assertNotEquals("无", output.getDealFlow());
        assertNotEquals("0", output.getDealFlow());
        assertEquals("N", capturedInputBo.get().getBlacklistCheckFlag());
        assertSame(DocumentType.VALUE_110007, capturedInputBo.get().getDocumentType());
    }

    // T5S1-TC005：REQ-005-S01、REQ-005-S02 —— 交易业务输出契约：T5S1OutputDTO 声明的业务字段
    // 恰为 dealFlow 一项且为 String，不含响应头或步骤基类字段；响应头与业务输出为两个独立对象
    @Test
    void testT5S1T05() {
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenReturn(hit(DealFlow.B));

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("DCT", "6222021234567890222", "351159", "AS", "T0005", "36",
                "EV05", "SVC05", "RQ", "MB1005", "Y", "A", "C000000005", "120101199901019999", "110009");

        T5S1OutputDTO output = t5s1.execute(header, input);

        assertInstanceOf(T5S1OutputDTO.class, output);
        Set<String> names = declaredFieldNames(output.getClass());
        assertEquals(Set.of("dealFlow"), names);
        for (Field field : declaredFields(output.getClass())) {
            assertSame(String.class, field.getType());
        }
        assertFalse(names.contains("succeed"));
        assertFalse(names.contains("errorCode"));
        assertFalse(names.contains("errorMessage"));
        assertFalse(names.contains("header"));
        assertNotSame(header, output);
        assertEquals("B", output.getDealFlow());
    }

    // T5S1-TC006：REQ-001-S01、REQ-001-S02 —— 交易对外输入契约：T5S1InputDTO 声明的业务字段恰为
    // 需求「## 输入」表的 15 项且均为 String（不含响应头字段），上送值被完整接收并进入步骤编排
    @Test
    void testT5S1T06() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.B);
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("DFT", "6222021234567890333", "351160", "BD", "T0006", "37",
                "EV06", "SVC06", "RQ", "MB1006", "Y", "A", "C000000006", "610101198001012222", "110011");

        T5S1OutputDTO output = t5s1.execute(header, input);

        Set<String> names = declaredFieldNames(input.getClass());
        assertEquals(15, names.size());
        assertEquals(Set.of("docClass", "baseAcctNo", "acctBranch", "sourceType", "programId", "tranType",
                "eventType", "serviceCode", "messageType", "messageCode", "blacklistCheckFlag",
                "serviceStatus", "clientNo", "documentId", "documentType"), names);
        for (Field field : declaredFields(input.getClass())) {
            assertSame(String.class, field.getType());
        }
        ST100InputBO captured = capturedInputBo.get();
        assertEquals("6222021234567890333", captured.getBaseAcctNo());
        assertEquals("BD", captured.getSourceType().getValue());
        assertEquals("T0006", captured.getProgramId());
        assertEquals("37", captured.getTranType().getValue());
        assertEquals("EV06", captured.getEventType());
        assertEquals("SVC06", captured.getServiceCode());
        assertEquals("RQ", captured.getMessageType());
        assertEquals("MB1006", captured.getMessageCode());
        assertEquals("Y", captured.getBlacklistCheckFlag());
        assertEquals("A", captured.getServiceStatus());
        assertEquals("C000000006", captured.getClientNo());
        assertEquals("610101198001012222", captured.getDocumentId());
        assertEquals("DFT", captured.getDocClass().getValue());
        assertEquals("351160", captured.getAcctBranch().getValue());
        assertEquals("110011", captured.getDocumentType().getValue());
        assertNotEquals("VALUE_351160", input.getAcctBranch());
        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
    }

    // T5S1-TC007：REQ-003-S01、REQ-003-S02 —— 枚举类入参按业务码值承载并转换：5 个字段经各自
    // byValue(String) 以码值匹配转换，MUST NOT 以常量名、toString() 或未定义取值替代业务编码
    @Test
    void testT5S1T07() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.B);
        });

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("OTH", "6222021234567890444", "351161", "BE", "T0007", "38",
                "EV07", "SVC07", "RQ", "MB1007", "Y", "A", "C000000007", "140101199001011234", "110013");

        t5s1.execute(header, input);

        ST100InputBO captured = capturedInputBo.get();
        assertSame(DocClass.OTH, captured.getDocClass());
        assertSame(TranBranch.VALUE_351161, captured.getAcctBranch());
        assertSame(SourceType.BE, captured.getSourceType());
        assertSame(TranType.VALUE_38, captured.getTranType());
        assertSame(DocumentType.VALUE_110013, captured.getDocumentType());
        assertEquals("OTH", captured.getDocClass().getValue());
        assertEquals("351161", captured.getAcctBranch().getValue());
        assertEquals("BE", captured.getSourceType().getValue());
        assertEquals("38", captured.getTranType().getValue());
        assertEquals("110013", captured.getDocumentType().getValue());
        assertNotEquals("VALUE_351161", captured.getAcctBranch().getValue());
        assertNotEquals("VALUE_110013", captured.getDocumentType().getValue());
        assertEquals("OTH", input.getDocClass());
        assertEquals("351161", input.getAcctBranch());
        assertEquals("BE", input.getSourceType());
        assertEquals("38", input.getTranType());
        assertEquals("110013", input.getDocumentType());
        assertTrue(header.isSucceed());
    }

    // T5S1-TC008：REQ-002-S02 —— 不存在需求未声明的其它步骤或外部组件调用：交易场景类声明的
    // 非静态、非合成字段恰为 1 个且类型为 IST100，本次执行的全部业务输出取自该唯一步骤的返回。
    // 局限：本阶段不使用 verify／times／never／InOrder，「恰好调用 1 次」与「未调用其它组件」
    // 无法用交互断言证明，以依赖声明结构为证
    @Test
    void testT5S1T08() {
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenReturn(hit(DealFlow.B));

        RespHeader header = new RespHeader();
        T5S1InputDTO input = sampleInput("BAT", "6222021234567890555", "351162", "BF", "T0008", "39",
                "EV08", "SVC08", "RQ", "MB1008", "Y", "A", "C000000008", "140101199001011234", "110015");

        T5S1OutputDTO output = t5s1.execute(header, input);

        List<Field> fields = declaredFields(T5S1.class);
        assertEquals(1, fields.size());
        assertSame(IST100.class, fields.get(0).getType());
        assertEquals("B", output.getDealFlow());
        assertTrue(header.isSucceed());
    }

    // T5S1-TC009：REQ-006-S01、REQ-007-S01 —— 命中结果不构成业务失败：调用方传入的响应头携带
    // 前次调用残留的未成功状态时，命中「提醒」仍被显式置为成功、残留失败信息被归零，
    // 交易自身不产生业务失败结论，输出侧无失败承载字段
    @Test
    void testT5S1T09() {
        AtomicReference<ST100InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st100.execute(Mockito.any(ST100InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit(DealFlow.D);
        });

        RespHeader header = new RespHeader();
        header.setSucceed(false);
        header.setErrorMessage("上一次调用未完成");
        T5S1InputDTO input = sampleInput("CFT", "6222021234567890666", "351163", "BG", "T0009", "40",
                "EV09", "SVC09", "RQ", "MB1009", "Y", "A", "C000000009", "140101199001011234", "110017");

        T5S1OutputDTO output = t5s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("D", output.getDealFlow());
        assertFalse(declaredFieldNames(T5S1OutputDTO.class).contains("errorCode"));
        assertEquals("MB1009", capturedInputBo.get().getMessageCode());
    }

    /** 构造步骤 {@link ST100OutputBO} 桩返回值：正常完成（{@code succeed = true}）并携带处理方式。 */
    private ST100OutputBO hit(DealFlow dealFlow) {
        ST100OutputBO outputBo = new ST100OutputBO();
        outputBo.setSucceed(true);
        outputBo.setDealFlow(dealFlow);
        return outputBo;
    }

    /** 按 Spec「### 输入（交易对外）」表的 15 项构造交易输入 DTO（枚举字段以业务码值承载）。 */
    private T5S1InputDTO sampleInput(String docClass, String baseAcctNo, String acctBranch, String sourceType,
            String programId, String tranType, String eventType, String serviceCode, String messageType,
            String messageCode, String blacklistCheckFlag, String serviceStatus, String clientNo,
            String documentId, String documentType) {
        T5S1InputDTO input = new T5S1InputDTO();
        input.setDocClass(docClass);
        input.setBaseAcctNo(baseAcctNo);
        input.setAcctBranch(acctBranch);
        input.setSourceType(sourceType);
        input.setProgramId(programId);
        input.setTranType(tranType);
        input.setEventType(eventType);
        input.setServiceCode(serviceCode);
        input.setMessageType(messageType);
        input.setMessageCode(messageCode);
        input.setBlacklistCheckFlag(blacklistCheckFlag);
        input.setServiceStatus(serviceStatus);
        input.setClientNo(clientNo);
        input.setDocumentId(documentId);
        input.setDocumentType(documentType);
        return input;
    }

    /** 取类自身声明的非静态、非合成字段（反射核对对外 DTO 的业务字段集合）。 */
    private static List<Field> declaredFields(Class<?> type) {
        return Arrays.stream(type.getDeclaredFields())
                .filter(field -> !field.isSynthetic() && !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toList());
    }

    /** 取类自身声明的非静态、非合成字段名集合。 */
    private static Set<String> declaredFieldNames(Class<?> type) {
        return declaredFields(type).stream().map(Field::getName).collect(Collectors.toSet());
    }
}

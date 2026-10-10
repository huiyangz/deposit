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
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.facade.bo.ST111InputBO;
import com.dcits.depsit.facade.bo.ST111OutputBO;
import com.dcits.depsit.step.IST111;
import com.dcits.depsit.task.dto.T7S1InputDTO;
import com.dcits.depsit.task.dto.T7S1OutputDTO;
import com.dcits.depsit.task.scenario.T7S1;
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
 * T7S1 检查客户限制 —— 单元测试。
 *
 * <p>调用签名：{@code T7S1OutputDTO execute(RespHeader header, T7S1InputDTO input)}。用例依据本轮
 * 正式 Spec 与 {@code outputs/测试用例.md}／{@code .json} 的 6 个用例设计：命中一条生效限制记录、
 * 多条记录映射步骤升序首条、查询结果为空三字段空值、枚举按业务码值承载、输出契约（字段集合与类型）、
 * 输入契约与客户号原值传递。</p>
 *
 * <p>唯一被调步骤 {@link IST111} 整体桩化：{@code execute} 按用例返回构造好的
 * {@link ST111OutputBO}；需要核对入参映射的用例用 {@link AtomicReference} 捕获实参。按技能约定
 * 不 mock／spy 被测场景，不使用 {@code verify}／{@code never}／{@code times}／{@code InOrder}，
 * 不模拟技术异常，也不访问数据库或网络。</p>
 *
 * <p>本交易唯一被调步骤声明无业务失败场景（Spec REQ-006），{@code succeed = false} 在可达路径下
 * 不发生，需求亦无「## 失败处理」章节与已确认错误码来源，故未设计失败短路用例、未读取任何
 * {@code errorcodes.properties} 键。</p>
 */
@ExtendWith(MockitoExtension.class)
class T7S1Test {

    @Mock
    private IST111 st111;

    @InjectMocks
    private T7S1 t7s1;

    // T7S1-TC001：REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-004-S01、REQ-005-S01 ——
    // 命中一条生效限制记录：客户号原样传入 ST111InputBO，步骤三字段逐字段映射为交易输出，返回成功响应
    @Test
    void testT7S1T01() {
        AtomicReference<ST111InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit("R202610100001", RestraintType.VALUE_13, RestraintsStatus.A);
        });

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100001");

        T7S1OutputDTO output = t7s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("C202610100001", capturedInputBo.get().getClientNo());
        assertEquals("R202610100001", output.getResSeqNo());
        assertEquals("13", output.getRestraintType());
        assertEquals("A", output.getRestraintsStatus());
    }

    // T7S1-TC002：REQ-003-S02 —— 多条记录路径：步骤按其自身规则按限制编号升序取首条并返回该条，
    // 交易只映射步骤返回的该条；同批其它记录（"68" 不允许转借、"22" 单位账户未核准）取值不出现
    @Test
    void testT7S1T02() {
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class)))
                .thenReturn(hit("R202610100001", RestraintType.VALUE_13, RestraintsStatus.A));

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100001");

        T7S1OutputDTO output = t7s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertEquals("R202610100001", output.getResSeqNo());
        assertEquals("13", output.getRestraintType());
        assertNotEquals("68", output.getRestraintType());
        assertNotEquals("22", output.getRestraintType());
        assertEquals("A", output.getRestraintsStatus());
    }

    // T7S1-TC003：REQ-003-S03、REQ-005-S02、REQ-006-S01 —— 查询结果为空路径：步骤正常完成但三字段
    // 均为空值，交易三字段保持空值、对象存在且不以业务常量占位，仍返回成功响应、不产生业务失败结论
    @Test
    void testT7S1T03() {
        ST111OutputBO emptyResult = new ST111OutputBO();
        emptyResult.setSucceed(true);
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class))).thenReturn(emptyResult);

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100999");

        T7S1OutputDTO output = t7s1.execute(header, input);

        assertTrue(header.isSucceed());
        assertNull(header.getErrorCode());
        assertNull(header.getErrorMessage());
        assertNotNull(output);
        assertTrue(output.getResSeqNo() == null || output.getResSeqNo().isEmpty());
        assertTrue(output.getRestraintType() == null || output.getRestraintType().isEmpty());
        assertTrue(output.getRestraintsStatus() == null || output.getRestraintsStatus().isEmpty());
        assertNotEquals("N", output.getResSeqNo());
        assertNotEquals("无", output.getResSeqNo());
        assertNotEquals("0", output.getResSeqNo());
        assertNotEquals("VALUE_13", output.getRestraintType());
    }

    // T7S1-TC004：REQ-004-S03 —— 枚举字段按业务码值承载：步骤输出 VALUE_68／E，
    // 交易输出码值字符串 "68"／"E"，运行时类型为 java.lang.String，不输出常量名
    @Test
    void testT7S1T04() {
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class)))
                .thenReturn(hit("R202610100004", RestraintType.VALUE_68, RestraintsStatus.E));

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100001");

        T7S1OutputDTO output = t7s1.execute(header, input);

        assertEquals("R202610100004", output.getResSeqNo());
        assertEquals("68", output.getRestraintType());
        assertNotEquals("VALUE_68", output.getRestraintType());
        assertEquals("E", output.getRestraintsStatus());
        assertInstanceOf(String.class, output.getRestraintType());
        assertInstanceOf(String.class, output.getRestraintsStatus());
    }

    // T7S1-TC005：REQ-004-S02、REQ-005 —— 交易业务输出契约：T7S1OutputDTO 声明的业务字段恰为
    // resSeqNo／restraintType／restraintsStatus 三项且均为 String，不含响应头或步骤基类字段，
    // 响应头与业务输出为两个独立对象
    @Test
    void testT7S1T05() {
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class)))
                .thenReturn(hit("R202610100001", RestraintType.VALUE_13, RestraintsStatus.A));

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100001");

        T7S1OutputDTO output = t7s1.execute(header, input);

        assertInstanceOf(T7S1OutputDTO.class, output);
        Set<String> names = declaredFieldNames(output.getClass());
        assertEquals(Set.of("resSeqNo", "restraintType", "restraintsStatus"), names);
        for (Field field : declaredFields(output.getClass())) {
            assertSame(String.class, field.getType());
        }
        assertFalse(names.contains("succeed"));
        assertFalse(names.contains("errorCode"));
        assertFalse(names.contains("errorMessage"));
        assertFalse(names.contains("header"));
        assertNotSame(header, output);
    }

    // T7S1-TC006：REQ-001-S02 —— 交易对外输入契约：T7S1InputDTO 声明的业务字段恰为 clientNo 一项
    // 且为 String（不含响应头字段），客户号按原值传入步骤入参，交易输出映射步骤返回值
    @Test
    void testT7S1T06() {
        AtomicReference<ST111InputBO> capturedInputBo = new AtomicReference<>();
        Mockito.lenient().when(st111.execute(Mockito.any(ST111InputBO.class))).thenAnswer(invocation -> {
            capturedInputBo.set(invocation.getArgument(0));
            return hit("R202610100006", RestraintType.VALUE_13, RestraintsStatus.F);
        });

        RespHeader header = new RespHeader();
        T7S1InputDTO input = new T7S1InputDTO();
        input.setClientNo("C202610100006");

        T7S1OutputDTO output = t7s1.execute(header, input);

        Set<String> names = declaredFieldNames(input.getClass());
        assertEquals(Set.of("clientNo"), names);
        for (Field field : declaredFields(input.getClass())) {
            assertSame(String.class, field.getType());
        }
        assertEquals("C202610100006", capturedInputBo.get().getClientNo());
        assertEquals("F", output.getRestraintsStatus());
        assertTrue(header.isSucceed());
    }

    /**
     * 构造步骤 {@link ST111OutputBO} 桩返回值：正常完成（{@code succeed = true}）并携带三项业务输出。
     */
    private ST111OutputBO hit(String resSeqNo, RestraintType restraintType, RestraintsStatus restraintsStatus) {
        ST111OutputBO outputBo = new ST111OutputBO();
        outputBo.setSucceed(true);
        outputBo.setResSeqNo(resSeqNo);
        outputBo.setRestraintType(restraintType);
        outputBo.setRestraintsStatus(restraintsStatus);
        return outputBo;
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

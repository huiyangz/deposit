package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST125InputBO;
import com.dcits.depsit.facade.bo.ST125OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;

/**
 * ST125 检查是否存在属性限制的单元测试。
 *
 * <p>调用签名：{@code ST125OutputBO execute(ST125InputBO input)}。本步骤唯一依赖为
 * {@code IRbBusRestraintsBcc.findByEo}（返回已按账号与两个筛选条件过滤后的结果集），
 * 无业务失败场景，故各用例均断言 {@code isSucceed()==true} 且错误字段为 null。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST125PbcTest {

    /** 用例统一使用的账号 */
    private static final String ACCT_NO = "6217000012345678901";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST125Pbc st125Pbc;

    private static ST125InputBO input(String baseAcctNo) {
        ST125InputBO input = new ST125InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private static RbBusRestraintsEO record(String resSeqNo, RestraintType restraintType) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo(ACCT_NO);
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintLevel(RestraintLevel.NATURE);
        return eo;
    }

    // ST125-TC001：REQ-002-S01 命中一条满足「限制状态=A 且 限制级别=NATURE」的记录，返回「是」并回显该条四项
    @Test
    void testST125T01() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        RbBusRestraintsEO rec1 = record("RS20261009001", RestraintType.VALUE_13);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of(rec1);
        });

        ST125OutputBO result = st125Pbc.execute(input(ACCT_NO));

        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNatureRestraintFlag());
        assertEquals("RS20261009001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertInstanceOf(RestraintType.class, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertInstanceOf(RestraintsStatus.class, result.getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, result.getRestraintLevel());
        assertInstanceOf(RestraintLevel.class, result.getRestraintLevel());
        // 查询条件以入参账号为查询键，并同时承载「限制状态=A」与「限制级别=NATURE」两个筛选取值
        assertEquals(ACCT_NO, captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, captured.get().getRestraintLevel());
    }

    // ST125-TC002：REQ-004-S01 三条记录均满足筛选条件，按限制编号升序取第一条 RS20261009001 并回显其四项
    @Test
    void testST125T02() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        RbBusRestraintsEO rec1 = record("RS20261009001", RestraintType.VALUE_17);
        RbBusRestraintsEO rec2 = record("RS20261009002", RestraintType.VALUE_13);
        RbBusRestraintsEO rec3 = record("RS20261009003", RestraintType.VALUE_22);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of(rec2, rec1, rec3);
        });

        ST125OutputBO result = st125Pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNatureRestraintFlag());
        assertEquals("RS20261009001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, result.getRestraintLevel());
        assertEquals(ACCT_NO, captured.get().getBaseAcctNo());
    }

    // ST125-TC003：REQ-004-S02 同一组三条记录换为另一返回顺序，选中结果仍为 RS20261009001，与返回顺序无关
    @Test
    void testST125T03() {
        RbBusRestraintsEO rec1 = record("RS20261009001", RestraintType.VALUE_17);
        RbBusRestraintsEO rec2 = record("RS20261009002", RestraintType.VALUE_13);
        RbBusRestraintsEO rec3 = record("RS20261009003", RestraintType.VALUE_22);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(rec3, rec1, rec2));

        ST125OutputBO result = st125Pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getNatureRestraintFlag());
        assertEquals("RS20261009001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, result.getRestraintLevel());
    }

    // ST125-TC004：REQ-002-S02 三个筛选取值同时承载，仅同时满足两个条件的 RS20261009005 被取回并回显
    @Test
    void testST125T04() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        RbBusRestraintsEO rec5 = record("RS20261009005", RestraintType.VALUE_22);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of(rec5);
        });

        ST125OutputBO result = st125Pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getNatureRestraintFlag());
        assertEquals("RS20261009005", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_22, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, result.getRestraintLevel());
        // 不满足筛选条件的记录（状态非 A 或级别非 NATURE）由查询条件的两个筛选取值排除
        assertEquals(ACCT_NO, captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, captured.get().getRestraintLevel());
    }

    // ST125-TC005：REQ-003-S01 账号在表中无任何记录，四项回显为空值，返回「否」，不产出错误码
    @Test
    void testST125T05() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        String acctNo = "6217000099999999999";
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of();
        });

        ST125OutputBO result = st125Pbc.execute(input(acctNo));

        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getNatureRestraintFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertNull(result.getRestraintLevel());
        assertEquals(acctNo, captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, captured.get().getRestraintLevel());
    }

    // ST125-TC006：REQ-003-S02 有记录但均不满足两个筛选条件，结果集为空，四项为空值、标志为「否」
    @Test
    void testST125T06() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of();
        });

        ST125OutputBO result = st125Pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getNatureRestraintFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertNull(result.getRestraintLevel());
        assertEquals(ACCT_NO, captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertEquals(RestraintLevel.NATURE, captured.get().getRestraintLevel());
    }

    // ST125-TC007：REQ-006-S01 三条已定义获取路径终点各执行一次，标志恒为「是」「否」之一且与路径一一对应
    @Test
    void testST125T07() {
        ST125InputBO request = input(ACCT_NO);
        Set<String> flagValues = Set.of("是", "否");

        // (a) 未查到记录：标志「否」，四项回显均为空值
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of());
        ST125OutputBO empty = st125Pbc.execute(request);
        assertTrue(empty.isSucceed());
        assertNull(empty.getErrorCode());
        assertNull(empty.getErrorMessage());
        assertInstanceOf(String.class, empty.getNatureRestraintFlag());
        assertFalse(empty.getNatureRestraintFlag().isEmpty());
        assertTrue(flagValues.contains(empty.getNatureRestraintFlag()));
        assertEquals("否", empty.getNatureRestraintFlag());
        assertNull(empty.getResSeqNo());
        assertNull(empty.getRestraintType());
        assertNull(empty.getRestraintsStatus());
        assertNull(empty.getRestraintLevel());

        // (b) 单条命中：标志「是」，回显该条限制编号
        RbBusRestraintsEO rec1 = record("RS20261009001", RestraintType.VALUE_13);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(rec1));
        ST125OutputBO single = st125Pbc.execute(request);
        assertTrue(single.isSucceed());
        assertNull(single.getErrorCode());
        assertNull(single.getErrorMessage());
        assertInstanceOf(String.class, single.getNatureRestraintFlag());
        assertFalse(single.getNatureRestraintFlag().isEmpty());
        assertTrue(flagValues.contains(single.getNatureRestraintFlag()));
        assertEquals("是", single.getNatureRestraintFlag());
        assertEquals("RS20261009001", single.getResSeqNo());

        // (c) 多条命中按限制编号升序取第一条：标志「是」，回显升序第一条的限制编号
        RbBusRestraintsEO rec1ForMulti = record("RS20261009001", RestraintType.VALUE_17);
        RbBusRestraintsEO rec2 = record("RS20261009002", RestraintType.VALUE_13);
        RbBusRestraintsEO rec3 = record("RS20261009003", RestraintType.VALUE_22);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(rec2, rec1ForMulti, rec3));
        ST125OutputBO multi = st125Pbc.execute(request);
        assertTrue(multi.isSucceed());
        assertNull(multi.getErrorCode());
        assertNull(multi.getErrorMessage());
        assertInstanceOf(String.class, multi.getNatureRestraintFlag());
        assertFalse(multi.getNatureRestraintFlag().isEmpty());
        assertTrue(flagValues.contains(multi.getNatureRestraintFlag()));
        assertEquals("是", multi.getNatureRestraintFlag());
        assertEquals("RS20261009001", multi.getResSeqNo());
    }
}

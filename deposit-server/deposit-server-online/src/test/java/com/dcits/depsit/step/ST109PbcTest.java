package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST109InputBO;
import com.dcits.depsit.facade.bo.ST109OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST109 检查限额场景配置是否有效 的单元测试。
 *
 * <p>被测实例经构造注入 mock 的 {@link IRbLimitCtrlConfBcc}，查询统一桩为
 * {@code findByEo(RbLimitCtrlConfEO)}；被测步骤本身不打桩，结论由业务输出断言。
 * 桩对象仅设置 limitSceneNo 与四类控制区间字段，limitBranchId、validFlag 等 Spec 声明
 * 不参与判定的字段保持 null。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST109PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @InjectMocks
    private ST109Pbc st109Pbc;

    // ST109-TC001：单条配置记录日期侧与时间侧均覆盖本次交易，判定有效并返回场景编码、回显四类区间值
    @Test
    void testST109T01() {
        RbLimitCtrlConfEO record = conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0));
        RbLimitCtrlConfEO[] captured = new RbLimitCtrlConfEO[1];
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenAnswer(invocation -> {
                    captured[0] = invocation.getArgument(0);
                    return List.of(record);
                });

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 1, 1), output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
        // 查询条件仅含限额场景编码：限额机构编码、启用标志均不参与
        assertEquals("LS0001", captured[0].getLimitSceneNo());
        assertNull(captured[0].getLimitBranchId());
        assertNull(captured[0].getValidFlag());
    }

    // ST109-TC002：同一场景编码查出 2 条记录，查询条件仅含场景编码，仅记录 A 覆盖本次交易，判定有效
    @Test
    void testST109T02() {
        RbLimitCtrlConfEO recordA = conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0));
        RbLimitCtrlConfEO recordB = conf("LS0001", date(2026, 7, 1), date(2026, 7, 31), time(8, 0, 0), time(12, 0, 0));
        RbLimitCtrlConfEO[] captured = new RbLimitCtrlConfEO[1];
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenAnswer(invocation -> {
                    captured[0] = invocation.getArgument(0);
                    return List.of(recordA, recordB);
                });

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 1, 1), output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
        assertEquals("LS0001", captured[0].getLimitSceneNo());
        assertNull(captured[0].getLimitBranchId());
    }

    // ST109-TC003：多条记录中恰有一条覆盖（记录 B），判定有效且不要求全部记录覆盖
    @Test
    void testST109T03() {
        RbLimitCtrlConfEO recordA = conf("LS0001", date(2026, 7, 1), date(2026, 7, 31), time(9, 0, 0), time(17, 0, 0));
        RbLimitCtrlConfEO recordB = conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0));
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(recordA, recordB));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 1, 1), output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC004：交易日期等于配置开始日期，起止日期含边界，判定有效
    @Test
    void testST109T04() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 1, 1), "2026-01-01 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 1, 1), output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
    }

    // ST109-TC005：交易日期等于配置结束日期，起止日期含边界，判定有效
    @Test
    void testST109T05() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 12, 31), "2026-12-31 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
    }

    // ST109-TC006：交易时间等于配置开始时间，起止时间含边界，判定有效
    @Test
    void testST109T06() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 09:00:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC007：交易时间等于配置结束时间，起止时间含边界，判定有效
    @Test
    void testST109T07() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 17:00:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC008：仅设置开始日期，交易日期不早于该日期，判定有效且回显保留空值
    @Test
    void testST109T08() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), null, time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 1, 1), output.getLimitCtrlBgnDate());
        assertNull(output.getLimitCtrlEndDate());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC009：仅设置结束日期，交易日期不晚于该日期，判定有效且回显保留空值
    @Test
    void testST109T09() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", null, date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertNull(output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 12, 31), output.getLimitCtrlEndDate());
    }

    // ST109-TC010：起止日期均未设置，日期侧视为满足，判定有效
    @Test
    void testST109T10() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", null, null, time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertNull(output.getLimitCtrlBgnDate());
        assertNull(output.getLimitCtrlEndDate());
    }

    // ST109-TC011：仅设置开始时间，交易时间不早于该时间，判定有效且回显保留空值
    @Test
    void testST109T11() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), null)));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertNull(output.getLimitCtrlEndTime());
    }

    // ST109-TC012：仅设置结束时间，交易时间不晚于该时间，判定有效且回显保留空值
    @Test
    void testST109T12() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), null, time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertNull(output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC013：起止时间均未设置，时间侧视为满足，判定有效
    @Test
    void testST109T13() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), null, null)));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertEquals("LS0001", output.getLimitSceneNo());
        assertNull(output.getLimitCtrlBgnTime());
        assertNull(output.getLimitCtrlEndTime());
    }

    // ST109-TC014：四个区间字段均未设置，两侧均视为满足，判定有效并按原值回显空值
    @Test
    void testST109T14() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0002", null, null, null, null)));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS0002"));

        assertTrue(output.isSucceed());
        assertEquals("LS0002", output.getLimitSceneNo());
        assertNull(output.getLimitCtrlBgnDate());
        assertNull(output.getLimitCtrlEndDate());
        assertNull(output.getLimitCtrlBgnTime());
        assertNull(output.getLimitCtrlEndTime());
    }

    // ST109-TC015：交易日期早于配置开始日期，日期侧不满足，判定无效（时间侧满足不能替代）
    @Test
    void testST109T15() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2025, 12, 31), "2025-12-31 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC016：交易日期晚于配置结束日期，日期侧不满足，判定无效
    @Test
    void testST109T16() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2027, 1, 1), "2027-01-01 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC017：仅设置开始日期且交易日期早于该日期，日期侧不满足，判定无效
    @Test
    void testST109T17() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), null, time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2025, 12, 31), "2025-12-31 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC018：仅设置结束日期且交易日期晚于该日期，日期侧不满足，判定无效
    @Test
    void testST109T18() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", null, date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2027, 1, 1), "2027-01-01 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC019：交易时间早于配置开始时间，日期侧满足但时间侧不满足，判定无效
    @Test
    void testST109T19() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 08:59:59", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC020：交易时间晚于配置结束时间，时间侧不满足，判定无效
    @Test
    void testST109T20() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 17:00:01", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC021：仅设置开始时间且交易时间早于该时间，时间侧不满足，判定无效
    @Test
    void testST109T21() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), null)));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 08:59:59", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC022：仅设置结束时间且交易时间晚于该时间，时间侧不满足，判定无效
    @Test
    void testST109T22() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), null, time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 17:00:01", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC023：按场景编码查无配置记录，判定无效且不抛业务异常
    @Test
    void testST109T23() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(new ArrayList<RbLimitCtrlConfEO>());

        ST109OutputBO output = assertDoesNotThrow(
                () -> st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 10:30:00", "LS9999")));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC024：多条记录全部未覆盖（A 仅时间侧不满足、B 仅日期侧不满足），判定无效且不交叉组合
    @Test
    void testST109T24() {
        RbLimitCtrlConfEO recordA = conf("LS0001", date(2026, 1, 1), date(2026, 12, 31), time(9, 0, 0), time(17, 0, 0));
        RbLimitCtrlConfEO recordB = conf("LS0001", date(2026, 7, 1), date(2026, 7, 31), null, null);
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(recordA, recordB));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-06-15 18:00:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST109-TC025：交易日期与交易时间戳的日期部分不同，日期侧取自 tranDate 且落在区间内，判定有效
    @Test
    void testST109T25() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 7, 1), date(2026, 7, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 7, 1), "2026-06-15 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 日期侧按 tranDate（2026-07-01 落在 2026-07-01 至 2026-07-31 内）判定，而非 tranTimestamp 的日期部分（2026-06-15）
        assertEquals("LS0001", output.getLimitSceneNo());
        assertEquals(date(2026, 7, 1), output.getLimitCtrlBgnDate());
        assertEquals(date(2026, 7, 31), output.getLimitCtrlEndDate());
        assertEquals(time(9, 0, 0), output.getLimitCtrlBgnTime());
        assertEquals(time(17, 0, 0), output.getLimitCtrlEndTime());
    }

    // ST109-TC026：交易日期与交易时间戳的日期部分不同，日期侧按 tranDate 判定为不满足，判定无效
    @Test
    void testST109T26() {
        lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf("LS0001", date(2026, 7, 1), date(2026, 7, 31), time(9, 0, 0), time(17, 0, 0))));

        ST109OutputBO output = st109Pbc.execute(input(date(2026, 6, 15), "2026-07-01 10:30:00", "LS0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // tranDate（2026-06-15）早于开始日期即日期侧不满足；tranTimestamp 的日期部分落在区间内不得替代 tranDate 的判定
        assertNull(output.getLimitSceneNo());
    }

    /**
     * 构造输入 BO。
     *
     * @param tranDate      交易日期
     * @param tranTimestamp 交易时间戳
     * @param limitSceneNo  限额场景编码
     * @return 输入 BO
     */
    private static ST109InputBO input(Date tranDate, String tranTimestamp, String limitSceneNo) {
        ST109InputBO input = new ST109InputBO();
        input.setTranDate(tranDate);
        input.setTranTimestamp(tranTimestamp);
        input.setLimitSceneNo(limitSceneNo);
        return input;
    }

    /**
     * 构造配置记录桩，仅设置限额场景编码与四类控制区间字段。
     *
     * @param limitSceneNo     限额场景编码
     * @param limitCtrlBgnDate 限额控制开始日期
     * @param limitCtrlEndDate 限额控制结束日期
     * @param limitCtrlBgnTime 限额控制开始时间
     * @param limitCtrlEndTime 限额控制结束时间
     * @return 配置记录
     */
    private static RbLimitCtrlConfEO conf(String limitSceneNo, Date limitCtrlBgnDate, Date limitCtrlEndDate,
            Date limitCtrlBgnTime, Date limitCtrlEndTime) {
        RbLimitCtrlConfEO eo = new RbLimitCtrlConfEO();
        eo.setLimitSceneNo(limitSceneNo);
        eo.setLimitCtrlBgnDate(limitCtrlBgnDate);
        eo.setLimitCtrlEndDate(limitCtrlEndDate);
        eo.setLimitCtrlBgnTime(limitCtrlBgnTime);
        eo.setLimitCtrlEndTime(limitCtrlEndTime);
        return eo;
    }

    /**
     * 构造表示 y-M-d 00:00:00.000 的日期。
     *
     * @param year  年
     * @param month 月（1 起）
     * @param day   日
     * @return 日期
     */
    private static Date date(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day, 0, 0, 0);
        return calendar.getTime();
    }

    /**
     * 构造基准日 2026-06-15 上 H:m:s.000 的时间点，与 tranTimestamp 的解析基准日一致。
     *
     * @param hour   时
     * @param minute 分
     * @param second 秒
     * @return 时间点
     */
    private static Date time(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2026, Calendar.JUNE, 15, hour, minute, second);
        return calendar.getTime();
    }
}

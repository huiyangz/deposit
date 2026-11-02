package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST045 检查限额场景配置是否有效 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01（ST045-TC001）、REQ-002-S01（ST045-TC002）、
 * REQ-002-S02（ST045-TC003）。区间判定组合口径、边界包含语义、交易时间戳格式、查询无记录/
 * 多条记录、必填输入缺失及输出空值物理表示为 Spec 待确认事项，不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST045PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc limitCtrlConfBcc;

    @InjectMocks
    private ST045Pbc st045Pbc;

    // 场景 REQ-001-S01：按限额场景编码「LMT001」查询命中一条记录，输出四个控制区间字段，步骤正常完成
    @Test
    void testST045T01() {
        RbLimitCtrlConfEO record = buildLimitCtrlConfRecord();
        when(limitCtrlConfBcc.findByEo(argThat(eo -> "LMT001".equals(eo.getLimitSceneNo()))))
                .thenReturn(Collections.singletonList(record));

        ST045InputBO input = new ST045InputBO();
        input.setLimitSceneNo("LMT001");
        input.setTranDate(Date.valueOf("2026-06-15"));
        input.setTranTimestamp("10:00:00");

        ST045OutputBO outputBO = st045Pbc.execute(input);

        assertTrue(outputBO.isSucceed());
        assertNull(outputBO.getErrorCode());
        assertNull(outputBO.getErrorMessage());
        assertEquals(record.getLimitCtrlBgnDate(), outputBO.getLimitCtrlBgnDate());
        assertEquals(record.getLimitCtrlEndDate(), outputBO.getLimitCtrlEndDate());
        assertEquals(record.getLimitCtrlBgnTime(), outputBO.getLimitCtrlBgnTime());
        assertEquals(record.getLimitCtrlEndTime(), outputBO.getLimitCtrlEndTime());
    }

    // 场景 REQ-002-S01：交易日期 2026-06-15 与交易时间「10:00:00」均落在控制区间内，输出限额场景编码非空且等于「LMT001」，步骤正常完成
    @Test
    void testST045T02() {
        RbLimitCtrlConfEO record = buildLimitCtrlConfRecord();
        when(limitCtrlConfBcc.findByEo(argThat(eo -> "LMT001".equals(eo.getLimitSceneNo()))))
                .thenReturn(Collections.singletonList(record));

        ST045InputBO input = new ST045InputBO();
        input.setLimitSceneNo("LMT001");
        input.setTranDate(Date.valueOf("2026-06-15"));
        input.setTranTimestamp("10:00:00");

        ST045OutputBO outputBO = st045Pbc.execute(input);

        assertTrue(outputBO.isSucceed());
        assertNull(outputBO.getErrorCode());
        assertNull(outputBO.getErrorMessage());
        assertEquals("LMT001", outputBO.getLimitSceneNo());
        assertEquals(record.getLimitCtrlBgnDate(), outputBO.getLimitCtrlBgnDate());
        assertEquals(record.getLimitCtrlEndDate(), outputBO.getLimitCtrlEndDate());
        assertEquals(record.getLimitCtrlBgnTime(), outputBO.getLimitCtrlBgnTime());
        assertEquals(record.getLimitCtrlEndTime(), outputBO.getLimitCtrlEndTime());
    }

    // 场景 REQ-002-S02：交易日期 2027-03-01 与交易时间「20:00:00」均落在控制区间外，输出限额场景编码为空（正常业务结果），步骤正常完成
    @Test
    void testST045T03() {
        RbLimitCtrlConfEO record = buildLimitCtrlConfRecord();
        when(limitCtrlConfBcc.findByEo(argThat(eo -> "LMT001".equals(eo.getLimitSceneNo()))))
                .thenReturn(Collections.singletonList(record));

        ST045InputBO input = new ST045InputBO();
        input.setLimitSceneNo("LMT001");
        input.setTranDate(Date.valueOf("2027-03-01"));
        input.setTranTimestamp("20:00:00");

        ST045OutputBO outputBO = st045Pbc.execute(input);

        assertTrue(outputBO.isSucceed());
        assertNull(outputBO.getErrorCode());
        assertNull(outputBO.getErrorMessage());
        // 区间外输出为空，物理表示（null 或空字符串）见 Spec 待确认事项 7，断言兼容两种表示
        assertTrue(outputBO.getLimitSceneNo() == null || "".equals(outputBO.getLimitSceneNo()));
        assertEquals(record.getLimitCtrlBgnDate(), outputBO.getLimitCtrlBgnDate());
        assertEquals(record.getLimitCtrlEndDate(), outputBO.getLimitCtrlEndDate());
        assertEquals(record.getLimitCtrlBgnTime(), outputBO.getLimitCtrlBgnTime());
        assertEquals(record.getLimitCtrlEndTime(), outputBO.getLimitCtrlEndTime());
    }

    /**
     * 构造查询命中记录：限额场景编码「LMT001」，控制区间为 2026-01-01~2026-12-31、08:30:00~17:30:00。
     */
    private RbLimitCtrlConfEO buildLimitCtrlConfRecord() {
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitSceneNo("LMT001");
        record.setLimitCtrlBgnDate(Date.valueOf("2026-01-01"));
        record.setLimitCtrlEndDate(Date.valueOf("2026-12-31"));
        record.setLimitCtrlBgnTime(Time.valueOf("08:30:00"));
        record.setLimitCtrlEndTime(Time.valueOf("17:30:00"));
        return record;
    }
}

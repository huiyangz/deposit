package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST041 处理限额 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01～S03 已确认分支（测试用例 ST041-TC001～TC003）：
 * 处理方式为拒绝/提醒/授权时，输出对应 DealFlow 枚举且步骤成功。
 * 查询无记录、处理方式为空、limitSceneNo 未提供等未定义情形（TBD-1～TBD-4）
 * 不作为本套用例断言，见实现中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST041PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @InjectMocks
    private ST041Pbc st041Pbc;

    // 场景：REQ-001-S01（ST041-TC001），处理方式为「拒绝」（DealFlow.B），输出检查结果「拒绝」并成功
    @Test
    void testST041T01() {
        // 桩：findByEo 返回单条配置记录，处理方式为 DealFlow.B（拒绝处理）
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitSceneNo("LMT1001");
        record.setDealFlow(DealFlow.B);
        when(rbLimitCtrlConfBcc.findByEo(any())).thenReturn(List.of(record));

        ST041InputBO input = new ST041InputBO();
        input.setLimitSceneNo("LMT1001");

        ST041OutputBO output = st041Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getDealFlow());
        assertEquals(DealFlow.B, output.getDealFlow());
    }

    // 场景：REQ-001-S02（ST041-TC002），处理方式为「提醒」（DealFlow.D），输出检查结果「提醒」并成功
    @Test
    void testST041T02() {
        // 桩：findByEo 返回单条配置记录，处理方式为 DealFlow.D（提醒处理）
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitSceneNo("LMT1001");
        record.setDealFlow(DealFlow.D);
        when(rbLimitCtrlConfBcc.findByEo(any())).thenReturn(List.of(record));

        ST041InputBO input = new ST041InputBO();
        input.setLimitSceneNo("LMT1001");

        ST041OutputBO output = st041Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getDealFlow());
        assertEquals(DealFlow.D, output.getDealFlow());
    }

    // 场景：REQ-001-S03（ST041-TC003），处理方式为「授权」（DealFlow.A），输出检查结果「授权」并成功
    @Test
    void testST041T03() {
        // 桩：findByEo 返回单条配置记录，处理方式为 DealFlow.A（授权处理）
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitSceneNo("LMT1001");
        record.setDealFlow(DealFlow.A);
        when(rbLimitCtrlConfBcc.findByEo(any())).thenReturn(List.of(record));

        ST041InputBO input = new ST041InputBO();
        input.setLimitSceneNo("LMT1001");

        ST041OutputBO output = st041Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getDealFlow());
        assertEquals(DealFlow.A, output.getDealFlow());
    }
}

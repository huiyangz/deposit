package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.facade.bo.ST061InputBO;
import com.dcits.deposit.facade.bo.ST061OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;

/**
 * ST061 检查是否存在属性限制 步骤实现单元测试。
 *
 * <p>对应用例：ST061-TC001（命中 1 条 → 标志"是"）、ST061-TC002（空集合 → 标志"否"）、
 * ST061-TC003（命中 2 条 → 标志"是"）。均验证步骤正常完成（无错误码与错误信息）及
 * 查询条件构成（账号等值 + 限制状态=RestraintsStatus.A + 限制级别=RestraintLevel.NATURE，
 * 其余 EO 字段不参与查询）。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST061PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST061Pbc st061Pbc;

    private static final String BASE_ACCT_NO = "6227001234567890123";

    /**
     * ST061-TC001：查询命中 1 条属性级限制记录，属性限制标志返回"是"。
     */
    @Test
    void testST061T01() {
        AtomicReference<RbBusRestraintsEO> capturedEo = new AtomicReference<>();
        RbBusRestraintsEO hit = new RbBusRestraintsEO();
        hit.setResSeqNo("RES2026101000001");
        hit.setRestraintType(RestraintType.VALUE_6);
        hit.setRestraintsStatus(RestraintsStatus.A);
        hit.setRestraintLevel(RestraintLevel.NATURE);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo.set(invocation.getArgument(0));
                    return Collections.singletonList(hit);
                });

        ST061OutputBO output = st061Pbc.execute(buildInput(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.get属性限制标志());
        assertCapturedQueryEo(capturedEo.get());
    }

    /**
     * ST061-TC002：查询无命中，属性限制标志返回"否"。
     */
    @Test
    void testST061T02() {
        AtomicReference<RbBusRestraintsEO> capturedEo = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo.set(invocation.getArgument(0));
                    return Collections.emptyList();
                });

        ST061OutputBO output = st061Pbc.execute(buildInput(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.get属性限制标志());
        assertCapturedQueryEo(capturedEo.get());
    }

    /**
     * ST061-TC003：查询命中 2 条属性级限制记录，属性限制标志返回"是"。
     */
    @Test
    void testST061T03() {
        AtomicReference<RbBusRestraintsEO> capturedEo = new AtomicReference<>();
        RbBusRestraintsEO hit1 = new RbBusRestraintsEO();
        hit1.setResSeqNo("RES2026101000001");
        hit1.setRestraintType(RestraintType.VALUE_6);
        hit1.setRestraintsStatus(RestraintsStatus.A);
        hit1.setRestraintLevel(RestraintLevel.NATURE);
        RbBusRestraintsEO hit2 = new RbBusRestraintsEO();
        hit2.setResSeqNo("RES2026101000002");
        hit2.setRestraintType(RestraintType.VALUE_8);
        hit2.setRestraintsStatus(RestraintsStatus.A);
        hit2.setRestraintLevel(RestraintLevel.NATURE);
        List<RbBusRestraintsEO> hits = Arrays.asList(hit1, hit2);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo.set(invocation.getArgument(0));
                    return hits;
                });

        ST061OutputBO output = st061Pbc.execute(buildInput(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.get属性限制标志());
        assertCapturedQueryEo(capturedEo.get());
    }

    private ST061InputBO buildInput(String baseAcctNo) {
        ST061InputBO input = new ST061InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private void assertCapturedQueryEo(RbBusRestraintsEO eo) {
        // 查询条件 = 账号等值 + 限制状态=RestraintsStatus.A 等值 + 限制级别=RestraintLevel.NATURE 等值，
        // 其余 EO 字段保持 null（eoToEntityExample 仅对非空字段生成等值查询条件）
        assertEquals(BASE_ACCT_NO, eo.getBaseAcctNo());
        assertSame(RestraintsStatus.A, eo.getRestraintsStatus());
        assertSame(RestraintLevel.NATURE, eo.getRestraintLevel());
        assertNull(eo.getRestraintType());
        assertNull(eo.getResSeqNo());
    }
}

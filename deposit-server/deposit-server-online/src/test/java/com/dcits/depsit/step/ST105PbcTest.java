package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST105InputBO;
import com.dcits.depsit.facade.bo.ST105OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST105 处理限额 单元测试。
 *
 * <p>用例与 {@code outputs/测试用例.md} / {@code outputs/测试用例.json} 的 ST105-TC001～TC006
 * 一一对应，经被测实例的 {@code execute(input)} 验证业务结果，不断言交互次数与顺序。</p>
 *
 * <p>桩说明：子步骤1 的查询桩绑定在 {@code IRbLimitCtrlConfBcc#findByEo(RbLimitCtrlConfEO)} 上
 * （输入只含 {@code limitSceneNo}，无 {@code limitBranchId}，主键查询无从确定），且所有桩一律只返回
 * <b>恰好一条</b>配置行——对应 REQ-001-S01「存在一条配置记录」，不预设多条取舍口径。查询不到记录、
 * 多条记录、{@code DEAL_FLOW} 取值不在 {A, B, D} 内、{@code limitSceneNo} 为空分别属 Spec
 * 「验收范围与明确不覆盖的事项」1～4，本测试不为其构造用例、不设断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST105PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @InjectMocks
    private ST105Pbc st105Pbc;

    // TC001：REQ-001-S01＋REQ-002-S01 —— 按 limitSceneNo="LS0001" 命中唯一一条配置行（DEAL_FLOW=B），取得 DealFlow.B 后返回检查结果「拒绝」
    @Test
    void testST105T01() {
        stubFindByEo(conf("LS0001", DealFlow.B, TranBranch.VALUE_351155, LimitBranchRange.A, "N", "2026-10-09 09:00:00"));

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0001");

        ST105OutputBO output = st105Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(DealFlow.B, output.getDealFlow());
        assertNotEquals(DealFlow.D, output.getDealFlow());
        assertNotEquals(DealFlow.A, output.getDealFlow());
    }

    // TC002：REQ-001-S02 —— 以 limitSceneNo="LS0002" 执行子步骤1，查询入参携带该限额场景编码，并取得命中行的 DEAL_FLOW=D
    @Test
    void testST105T02() {
        AtomicReference<RbLimitCtrlConfEO> capturedEo = new AtomicReference<>();
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenAnswer(invocation -> {
            capturedEo.set(invocation.getArgument(0));
            return Collections.singletonList(conf("LS0002", DealFlow.D, TranBranch.VALUE_351155,
                    LimitBranchRange.A, "N", "2026-10-09 09:00:00"));
        });

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0002");

        ST105OutputBO output = st105Pbc.execute(input);

        assertEquals("LS0002", capturedEo.get().getLimitSceneNo());
        assertEquals(DealFlow.D, output.getDealFlow());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // TC003：REQ-003-S01 —— 子步骤1 取得的处理方式为 DealFlow.D，子步骤2 返回检查结果「提醒」
    @Test
    void testST105T03() {
        stubFindByEo(conf("LS0003", DealFlow.D, TranBranch.VALUE_351156, LimitBranchRange.A, "N", "2026-10-09 10:15:00"));

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0003");

        ST105OutputBO output = st105Pbc.execute(input);

        assertEquals(DealFlow.D, output.getDealFlow());
        assertNotEquals(DealFlow.B, output.getDealFlow());
        assertNotEquals(DealFlow.A, output.getDealFlow());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // TC004：REQ-004-S01 —— 子步骤1 取得的处理方式为 DealFlow.A，子步骤2 返回检查结果「授权」
    @Test
    void testST105T04() {
        stubFindByEo(conf("LS0004", DealFlow.A, TranBranch.VALUE_351157, LimitBranchRange.B, "Y", "2026-10-09 11:30:00"));

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0004");

        ST105OutputBO output = st105Pbc.execute(input);

        assertEquals(DealFlow.A, output.getDealFlow());
        assertNotEquals(DealFlow.B, output.getDealFlow());
        assertNotEquals(DealFlow.D, output.getDealFlow());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // TC005：REQ-005-S01 —— DEAL_FLOW="A" 时输出 dealFlow 为 DealFlow 枚举对象本身，而非字符串 "A"
    @Test
    void testST105T05() {
        stubFindByEo(conf("LS0005", DealFlow.A, TranBranch.VALUE_351158, LimitBranchRange.A, "N", "2026-10-09 14:00:00"));

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0005");

        ST105OutputBO output = st105Pbc.execute(input);

        assertInstanceOf(DealFlow.class, output.getDealFlow());
        assertSame(DealFlow.A, output.getDealFlow());
        assertEquals("A", output.getDealFlow().getValue());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // TC006：REQ-005-S02 —— DEAL_FLOW="D" 时确认输出仅含 dealFlow 一个业务字段（无其他结果字段）
    @Test
    void testST105T06() {
        stubFindByEo(conf("LS0006", DealFlow.D, TranBranch.VALUE_351159, LimitBranchRange.A, "N", "2026-10-09 15:45:00"));

        ST105InputBO input = new ST105InputBO();
        input.setLimitSceneNo("LS0006");

        ST105OutputBO output = st105Pbc.execute(input);

        Set<String> declaredFields = Arrays.stream(ST105OutputBO.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toSet());
        assertEquals(Set.of("dealFlow"), declaredFields);
        assertEquals(DealFlow.D, output.getDealFlow());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /**
     * 按 Spec REQ-001-S01 的桩数据构造单条配置行（恰好一条，不涉及多条记录取舍）。
     */
    private void stubFindByEo(RbLimitCtrlConfEO conf) {
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(Collections.singletonList(conf));
    }

    /**
     * 构造一条【限额控制配置】记录：以 limitSceneNo 与 dealFlow 承载本用例的被测取值，
     * 其余字段按表主键与非空约束填合法的固定值（非业务断言对象）。
     */
    private RbLimitCtrlConfEO conf(String limitSceneNo, DealFlow dealFlow, TranBranch limitBranchId,
            LimitBranchRange limitBranchRange, String allowCustomFlag, String timestamp) {
        RbLimitCtrlConfEO conf = new RbLimitCtrlConfEO();
        conf.setLimitSceneNo(limitSceneNo);
        conf.setDealFlow(dealFlow);
        conf.setLimitBranchId(limitBranchId);
        conf.setLimitBranchRange(limitBranchRange);
        conf.setAllowCustomFlag(allowCustomFlag);
        conf.setCreateTimestamp(timestamp);
        conf.setLastUpdTimestamp(timestamp);
        return conf;
    }
}

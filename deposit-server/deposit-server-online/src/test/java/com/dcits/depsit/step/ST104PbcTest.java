package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Field;
import java.math.BigDecimal;
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

import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST104InputBO;
import com.dcits.depsit.facade.bo.ST104OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST104 检查限额 单元测试。
 *
 * <p>用例与 {@code outputs/测试用例.md} / {@code outputs/测试用例.json} 的 ST104-TC001～TC013
 * 一一对应，经被测实例的 {@code execute(input)} 验证业务结果，不断言交互次数与顺序。</p>
 *
 * <p>桩说明：子步骤1 的查询桩绑定在 {@code IRbLimitCtrlConfBcc#findByEo(RbLimitCtrlConfEO)} 上
 * （输入只含 {@code limitSceneNo}，无 {@code limitBranchId}，主键查询无从确定），且所有桩一律只返回
 * <b>恰好一条</b>配置行。查询不到记录、多条记录、累计值（必填输入）取到空值、金额比较精度分别属
 * Spec「验收范围与明确不覆盖的事项」1～3、7，本测试不为其构造用例、不设断言；结论字段的枚举码值
 * 同样无定义（第 4 项），故按字面值精确断言「超限」／「未超限」。本步骤不持有【限额累计信息表】的
 * BCC，无其它依赖需设桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST104PbcTest {

    private static final String SCENE_NO = "LIMIT001";

    private static final String TIMESTAMP = "2026-10-10 09:00:00";

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @InjectMocks
    private ST104Pbc st104Pbc;

    // TC001：REQ-001-S01＋REQ-002-S01＋REQ-005-S01/S02/S03＋REQ-006-S01 —— 按 LIMIT001 取得控制值（100000.00／10），
    // 金额维度 120000.00 严格大于 100000.00 而笔数 8 不大于 10，返回「超限」；超限不构成业务失败
    @Test
    void testST104T01() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 8));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitCtrlAmt().compareTo(new BigDecimal("100000.00")));
        assertEquals(Integer.valueOf(10), output.getLimitCtrlNum());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("120000.00")));
        assertEquals(Integer.valueOf(8), output.get否());

        // 输出字段名、类型与「## 输出」表逐字一致（字段名照录，取值为输入值而非派生值）
        Set<String> declaredFields = Arrays.stream(ST104OutputBO.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toSet());
        assertEquals(Set.of("limitCtrlAmt", "limitCtrlNum", "limitSumAmt", "否", "limitCheckResult"),
                declaredFields);
        assertInstanceOf(BigDecimal.class, output.getLimitCtrlAmt());
        assertInstanceOf(Integer.class, output.getLimitCtrlNum());
        assertInstanceOf(BigDecimal.class, output.getLimitSumAmt());
        assertInstanceOf(Integer.class, output.get否());
        assertInstanceOf(String.class, output.getLimitCheckResult());
    }

    // TC002：REQ-002-S02 —— 「或」关系的第二支单独成立：金额 80000.00 不大于 100000.00，笔数 12 严格大于 10，返回「超限」
    @Test
    void testST104T02() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "80000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("超限", output.getLimitCheckResult());
        assertEquals(Integer.valueOf(10), output.getLimitCtrlNum());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("80000.00")));
        assertEquals(Integer.valueOf(12), output.get否());
    }

    // TC003：REQ-002-S03 —— 两维度同时超出，结论与单维度超出时一致（不区分单／双维度返回差异）
    @Test
    void testST104T03() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("超限", output.getLimitCheckResult());
        assertEquals(Integer.valueOf(10), output.getLimitCtrlNum());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("120000.00")));
        assertEquals(Integer.valueOf(12), output.get否());
    }

    // TC004：REQ-003-S01＋REQ-005-S02/S03 —— 两维度均不成立，落入「否则」返回「未超限」；
    // 回显值（80000.00／8）与控制值（100000.00／10）不同，证明输出为本次输入回显而非由控制值派生
    @Test
    void testST104T04() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "80000.00", 8));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitCtrlAmt().compareTo(new BigDecimal("100000.00")));
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("80000.00")));
        assertEquals(Integer.valueOf(8), output.get否());
    }

    // TC005：REQ-003-S02 —— 相等边界：金额 100000.00 等于控制金额，严格「大于」不成立，笔数亦不成立，返回「未超限」
    @Test
    void testST104T05() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "100000.00", 8));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("100000.00")));
        assertEquals(0, output.getLimitCtrlAmt().compareTo(output.getLimitSumAmt()));
        assertEquals(Integer.valueOf(8), output.get否());
    }

    // TC006：REQ-003-S03 —— 相等边界：笔数 10 等于控制笔数，严格「大于」不成立，金额亦不成立，返回「未超限」
    @Test
    void testST104T06() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "80000.00", 10));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertEquals(Integer.valueOf(10), output.getLimitCtrlNum());
        assertEquals(Integer.valueOf(10), output.get否());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("80000.00")));
    }

    // TC007：REQ-003-S04 —— 相等边界：两维度均等于各自控制值，两个「大于」均不成立，返回「未超限」
    @Test
    void testST104T07() {
        stubFindByEo(conf(SCENE_NO, "100000.00", 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "100000.00", 10));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitCtrlAmt().compareTo(output.getLimitSumAmt()));
        assertEquals(output.getLimitCtrlNum(), output.get否());
    }

    // TC008：REQ-004-S01 —— 控制金额无值（null）时不比较金额维度，仅由笔数维度判定，12 大于 10，返回「超限」
    @Test
    void testST104T08() {
        stubFindByEo(conf(SCENE_NO, null, 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("超限", output.getLimitCheckResult());
        assertNull(output.getLimitCtrlAmt());
        assertEquals(Integer.valueOf(10), output.getLimitCtrlNum());
        assertEquals(Integer.valueOf(12), output.get否());
    }

    // TC009：REQ-004-S02 —— 控制金额无值时金额取值不参与判定，累计金额 120000.00 再大也不得返回「超限」；
    // 笔数 8 不大于 10，故返回「未超限」
    @Test
    void testST104T09() {
        stubFindByEo(conf(SCENE_NO, null, 10));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 8));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertNull(output.getLimitCtrlAmt());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("120000.00")));
        assertEquals(Integer.valueOf(8), output.get否());
    }

    // TC010：REQ-004-S03 —— 控制笔数无值（null）时不比较笔数维度，仅由金额维度判定，120000.00 大于 100000.00，返回「超限」
    @Test
    void testST104T10() {
        stubFindByEo(conf(SCENE_NO, "100000.00", null));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitCtrlAmt().compareTo(new BigDecimal("100000.00")));
        assertNull(output.getLimitCtrlNum());
        assertEquals(Integer.valueOf(12), output.get否());
    }

    // TC011：REQ-004-S04 —— 控制笔数无值时笔数取值不参与判定，累计笔数 12 再大也不得返回「超限」；
    // 金额 80000.00 不大于 100000.00，故返回「未超限」
    @Test
    void testST104T11() {
        stubFindByEo(conf(SCENE_NO, "100000.00", null));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "80000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertNull(output.getLimitCtrlNum());
        assertEquals(Integer.valueOf(12), output.get否());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("80000.00")));
    }

    // TC012：REQ-004-S05 —— 两个控制值都无值：不进行任何比较、不抛异常，直接返回「未超限」，
    // 累计值取较大值（120000.00／12）亦不影响结论
    @Test
    void testST104T12() {
        stubFindByEo(conf(SCENE_NO, null, null));

        ST104OutputBO output = st104Pbc.execute(input(SCENE_NO, "120000.00", 12));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertNull(output.getLimitCtrlAmt());
        assertNull(output.getLimitCtrlNum());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("120000.00")));
        assertEquals(Integer.valueOf(12), output.get否());
    }

    // TC013：REQ-001-S02＋REQ-005-S01 —— 子步骤1 的查询请求仅携带[限额场景编码] LIMIT002，
    // 不携带「限额机构编码」等额外条件；控制值取自该场景配置（50000.00／5），累计值 40000.00／3 均不超出，返回「未超限」
    @Test
    void testST104T13() {
        AtomicReference<RbLimitCtrlConfEO> capturedEo = new AtomicReference<>();
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo.set(invocation.getArgument(0));
                    return Collections.singletonList(conf("LIMIT002", "50000.00", 5));
                });

        ST104OutputBO output = st104Pbc.execute(input("LIMIT002", "40000.00", 3));

        assertEquals("LIMIT002", capturedEo.get().getLimitSceneNo());
        assertNull(capturedEo.get().getLimitBranchId());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("未超限", output.getLimitCheckResult());
        assertEquals(0, output.getLimitCtrlAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(5), output.getLimitCtrlNum());
        assertEquals(0, output.getLimitSumAmt().compareTo(new BigDecimal("40000.00")));
        assertEquals(Integer.valueOf(3), output.get否());
    }

    /**
     * 构造步骤输入：三个字段来自 Spec「### 输入」表，无机构类入参。
     */
    private ST104InputBO input(String limitSceneNo, String limitSumAmt, Integer limitSumNum) {
        ST104InputBO input = new ST104InputBO();
        input.setLimitSceneNo(limitSceneNo);
        input.setLimitSumAmt(new BigDecimal(limitSumAmt));
        input.setLimitSumNum(limitSumNum);
        return input;
    }

    /**
     * 按 Spec REQ-001-S01 的桩数据构造单条配置行（恰好一条，不涉及多条记录取舍）。
     */
    private void stubFindByEo(RbLimitCtrlConfEO conf) {
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(Collections.singletonList(conf));
    }

    /**
     * 构造一条【限额控制配置】记录：以 {@code limitSceneNo} 与被测的两个控制值承载本轮取值，
     * {@code limitCtrlAmt}、{@code limitCtrlNum} 传 {@code null} 表示该列未赋值（对应空值裁剪场景）；
     * 其余字段按表主键与非空约束填合法的固定值（非业务断言对象）。
     */
    private RbLimitCtrlConfEO conf(String limitSceneNo, String limitCtrlAmt, Integer limitCtrlNum) {
        RbLimitCtrlConfEO conf = new RbLimitCtrlConfEO();
        conf.setLimitSceneNo(limitSceneNo);
        if (limitCtrlAmt != null) {
            conf.setLimitCtrlAmt(new BigDecimal(limitCtrlAmt));
        }
        conf.setLimitCtrlNum(limitCtrlNum);
        conf.setLimitBranchId(TranBranch.VALUE_351155);
        conf.setLimitBranchRange(LimitBranchRange.A);
        conf.setAllowCustomFlag("N");
        conf.setCreateTimestamp(TIMESTAMP);
        conf.setLastUpdTimestamp(TIMESTAMP);
        return conf;
    }
}

package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST112InputBO;
import com.dcits.depsit.facade.bo.ST112OutputBO;
import com.dcits.depsit.facade.components.IFmChannelBcc;
import com.dcits.depsit.facade.components.IRbRestraintControlDetailsBcc;
import com.dcits.depsit.facade.eo.FmChannelEO;
import com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST112 检查限制豁免的单元测试。
 *
 * <p>调用签名：{@code ST112OutputBO execute(ST112InputBO input)}。子步骤 1 用过滤型桩模拟
 * 【渠道类型定义表】按「渠道」取单条（无匹配返回 null）；子步骤 2 用过滤型桩按查询条件中
 * 已赋值的字段过滤【限制控制明细表】记录，状态 {@code "A"} 的筛选既可由 BCC 条件也可由
 * 步骤内过滤实现。检查结果四种常量在 Spec 下无承载字段（不覆盖项 2），故用例只对成功标志、
 * 错误字段、7 个回显字段与查询键作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST112PbcTest {

    @Mock
    private IFmChannelBcc fmChannelBcc;

    @Mock
    private IRbRestraintControlDetailsBcc rbRestraintControlDetailsBcc;

    @InjectMocks
    private ST112Pbc st112Pbc;

    /** 捕获子步骤 1 的渠道查询键（「渠道」字段值）。 */
    private SourceType capturedChannel;

    /** 捕获子步骤 2 的明细查询条件 EO。 */
    private RbRestraintControlDetailsEO capturedDetailCondition;

    // ST112-TC001：柜面渠道豁免路径，渠道命中「Y」、1 条状态「A」明细柜面标志「Y」，三字段同时匹配 → 子步骤 4「不检查限制」
    @Test
    void testST112T01() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "1001", "MC", LimitBranchRange.C, "Y"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000001", result.getProdNo());
        assertEquals("31", result.getTranTypeLink());
        assertEquals("MC", result.getChannelMuster());
        assertEquals("1001", result.getNarrativeCode());
        assertEquals(LimitBranchRange.C, result.getResBranchRange());
        assertEquals("Y", result.getCounterFlag());
        assertEquals(SourceType.MC, capturedChannel);
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC002：命中 3 条「A」明细全部取回不截断，首条「N」、第二条「Y」⇒ 汇总「Y」，三字段同时匹配 → 子步骤 4「不检查限制」
    @Test
    void testST112T02() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "1001", "MC", LimitBranchRange.C, "N"));
        rows.add(detail(Status.A, "1000002", "359", "1009", "MC", LimitBranchRange.C, "Y"));
        rows.add(detail(Status.A, "1000003", "361", "1002", "MC", LimitBranchRange.C, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        // 集合各条状态均为 "A"，任一承载形态下均成立；不按条数或行序断言其余字段（Spec 不覆盖项 3）
        assertEquals(Status.A, result.getStatus());
        assertEquals(SourceType.MC, capturedChannel);
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC003：渠道命中「N」；状态「F」「C」明细不进入集合，仅剩 1 条「Y」⇒ 汇总「Y」，路由（N 与 Y）走子步骤 5 →「豁免」
    @Test
    void testST112T03() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.EB, channel(SourceType.EB, "N"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "1001", "MC", LimitBranchRange.C, "Y"));
        rows.add(detail(Status.F, "1000002", "359", "1009", null, null, "N"));
        rows.add(detail(Status.C, "1000003", "361", "1002", null, null, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.EB, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        // 7 个字段回显唯一进入集合的状态 "A" 记录；"F"/"C" 记录若进入回显该组断言即失败
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000001", result.getProdNo());
        assertEquals("31", result.getTranTypeLink());
        assertEquals("MC", result.getChannelMuster());
        assertEquals("1001", result.getNarrativeCode());
        assertEquals(LimitBranchRange.C, result.getResBranchRange());
        assertEquals("Y", result.getCounterFlag());
        assertEquals(SourceType.EB, capturedChannel);
    }

    // ST112-TC004：渠道查不到记录按「N」处理且该账户限制类型无「A」明细 ⇒ 空集合汇总「N」，路由（N 与 N）走子步骤 5 →「不豁免」，7 字段均为空值
    @Test
    void testST112T04() {
        stubChannel(new HashMap<>());
        stubDetails(new ArrayList<>());

        ST112OutputBO result = st112Pbc.execute(input(SourceType.CP, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertNull(result.getStatus());
        assertNull(result.getProdNo());
        assertNull(result.getTranTypeLink());
        assertNull(result.getChannelMuster());
        assertNull(result.getNarrativeCode());
        assertNull(result.getResBranchRange());
        assertNull(result.getCounterFlag());
        assertEquals(SourceType.CP, capturedChannel);
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC005：渠道命中「Y」但该账户限制类型仅有「F」「C」明细 ⇒ 集合为空、汇总「N」，路由（Y 与 N）走子步骤 5 →「不豁免」，7 字段为空值
    @Test
    void testST112T05() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.F, "1000001", "31", "1001", null, null, "Y"));
        rows.add(detail(Status.C, "1000002", "359", "1009", null, null, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        // 无状态 "A" 记录时集合为空；"F"/"C" 记录若进入回显该组断言即失败
        assertNull(result.getStatus());
        assertNull(result.getProdNo());
        assertNull(result.getTranTypeLink());
        assertNull(result.getChannelMuster());
        assertNull(result.getNarrativeCode());
        assertNull(result.getResBranchRange());
        assertNull(result.getCounterFlag());
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC006：渠道查不到记录按「N」而明细 1 条「Y」⇒ 汇总「Y」，路由（N 与 Y）走子步骤 5 →「豁免」并回显该条
    @Test
    void testST112T06() {
        stubChannel(new HashMap<>());

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "1001", "MC", LimitBranchRange.C, "Y"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.CP, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000001", result.getProdNo());
        assertEquals("31", result.getTranTypeLink());
        assertEquals("MC", result.getChannelMuster());
        assertEquals("1001", result.getNarrativeCode());
        assertEquals(LimitBranchRange.C, result.getResBranchRange());
        assertEquals("Y", result.getCounterFlag());
        assertEquals(SourceType.CP, capturedChannel);
    }

    // ST112-TC007：渠道命中「Y」，明细 2 条柜面标志均为「N」⇒ 汇总「N」，路由（Y 与 N）走子步骤 5 → 首条三字段同时匹配「豁免」
    @Test
    void testST112T07() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "1001", "MC", LimitBranchRange.C, "N"));
        rows.add(detail(Status.A, "1000002", "359", "1009", "EB", LimitBranchRange.C, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals(SourceType.MC, capturedChannel);
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC008：两标志均为「Y」走子步骤 4；唯一明细交易类型「359」与入参「31」不匹配 ⇒「需检查限制」，输出仍回显该条
    @Test
    void testST112T08() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "359", "1001", "MC", LimitBranchRange.C, "Y"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        // 输出回显与检查结果相互独立：不因检查结果为「需检查限制」而置空
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000001", result.getProdNo());
        assertEquals("359", result.getTranTypeLink());
        assertEquals("MC", result.getChannelMuster());
        assertEquals("1001", result.getNarrativeCode());
        assertEquals(LimitBranchRange.C, result.getResBranchRange());
        assertEquals("Y", result.getCounterFlag());
    }

    // ST112-TC009：子步骤 4 的三项条件分别落在 3 条不同记录上（无单条同时满足）⇒「需检查限制」
    @Test
    void testST112T09() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "2000002", "31", "2002", "MC", LimitBranchRange.C, "Y"));
        rows.add(detail(Status.A, "2000002", "359", "1001", "MC", LimitBranchRange.C, "N"));
        rows.add(detail(Status.A, "1000001", "359", "2002", "MC", LimitBranchRange.C, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals(SourceType.MC, capturedChannel);
        assertEquals(RestraintType.VALUE_13, capturedDetailCondition.getRestraintType());
    }

    // ST112-TC010：子步骤 5 的三项条件分别落在 2 条不同记录上（后一条仅摘要码、产品类型匹配）⇒「不豁免」
    @Test
    void testST112T10() {
        stubChannel(new HashMap<>());

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "2000002", "31", "2002", "MC", LimitBranchRange.C, "N"));
        rows.add(detail(Status.A, "1000001", "359", "1001", "MC", LimitBranchRange.C, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.CP, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals(SourceType.CP, capturedChannel);
    }

    // ST112-TC011：输出契约核对，ST112OutputBO 声明的字段恰为 Spec 输出表 7 个、两中间值不写入输出，同时走柜面豁免路径回显
    @Test
    void testST112T11() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000003", "361", "1002", "EB", LimitBranchRange.B, "Y"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_361, "1002", "1000003"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000003", result.getProdNo());
        assertEquals("361", result.getTranTypeLink());
        assertEquals("EB", result.getChannelMuster());
        assertEquals("1002", result.getNarrativeCode());
        assertEquals(LimitBranchRange.B, result.getResBranchRange());
        assertEquals("Y", result.getCounterFlag());

        Set<String> declaredFieldNames = Arrays.stream(ST112OutputBO.class.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .map(Field::getName)
                .collect(Collectors.toSet());
        assertEquals(Set.of("status", "prodNo", "tranTypeLink", "channelMuster", "narrativeCode",
                "resBranchRange", "counterFlag"), declaredFieldNames);
    }

    // ST112-TC012：渠道命中「Y」、明细 1 条「N」⇒ 汇总「N」，路由（Y 与 N）走子步骤 5；摘要码「2002」与入参「1001」不匹配 ⇒「不豁免」
    @Test
    void testST112T12() {
        Map<SourceType, FmChannelEO> channels = new HashMap<>();
        channels.put(SourceType.MC, channel(SourceType.MC, "Y"));
        stubChannel(channels);

        List<RbRestraintControlDetailsEO> rows = new ArrayList<>();
        rows.add(detail(Status.A, "1000001", "31", "2002", "MC", LimitBranchRange.C, "N"));
        stubDetails(rows);

        ST112OutputBO result = st112Pbc.execute(input(SourceType.MC, TranType.VALUE_31, "1001", "1000001"));

        assertSuccessWithoutError(result);
        assertEquals(Status.A, result.getStatus());
        assertEquals("1000001", result.getProdNo());
        assertEquals("31", result.getTranTypeLink());
        assertEquals("MC", result.getChannelMuster());
        assertEquals("2002", result.getNarrativeCode());
        assertEquals(LimitBranchRange.C, result.getResBranchRange());
        assertEquals("N", result.getCounterFlag());
    }

    /**
     * 桩 1：过滤型渠道桩。[渠道类型定义表] 按「渠道」取单条，预置数据未命中的键返回 null
     * （模拟实现「无匹配返回 null」）；同时对按主键取单条的写法设 lenient 备用桩，二者写入同一
     * capturedChannel，均按「渠道」字段匹配。
     */
    private void stubChannel(Map<SourceType, FmChannelEO> channelData) {
        Mockito.when(fmChannelBcc.findByChannel(any(SourceType.class))).thenAnswer(invocation -> {
            SourceType channel = invocation.getArgument(0);
            capturedChannel = channel;
            return channelData.get(channel);
        });
        Mockito.lenient().when(fmChannelBcc.findByPrimaryKey(anyString())).thenAnswer(invocation -> {
            SourceType channel = SourceType.byValue(invocation.getArgument(0));
            capturedChannel = channel;
            return channel == null ? null : channelData.get(channel);
        });
    }

    /**
     * 桩 2：过滤型明细桩。记录查询条件 EO，再按条件中已赋值的 restraintType、status 过滤预置记录
     * （未赋值的字段不作过滤）：实现把状态 "A" 作为查询条件时只返回 "A" 行；实现不带状态条件时
     * 返回该限制类型全部行，须由步骤内过滤剔除非 "A" 行。
     */
    private void stubDetails(List<RbRestraintControlDetailsEO> rows) {
        Mockito.when(rbRestraintControlDetailsBcc.findByEo(any(RbRestraintControlDetailsEO.class)))
                .thenAnswer(invocation -> {
                    RbRestraintControlDetailsEO condition = invocation.getArgument(0);
                    capturedDetailCondition = condition;
                    List<RbRestraintControlDetailsEO> matched = new ArrayList<>();
                    for (RbRestraintControlDetailsEO row : rows) {
                        if (condition.getRestraintType() != null
                                && !condition.getRestraintType().equals(row.getRestraintType())) {
                            continue;
                        }
                        if (condition.getStatus() != null && !condition.getStatus().equals(row.getStatus())) {
                            continue;
                        }
                        matched.add(row);
                    }
                    return matched;
                });
    }

    private static FmChannelEO channel(SourceType channel, String counterFlag) {
        FmChannelEO eo = new FmChannelEO();
        eo.setChannel(channel);
        eo.setCounterFlag(counterFlag);
        return eo;
    }

    private static RbRestraintControlDetailsEO detail(Status status, String prodNo, String tranTypeLink,
            String narrativeCode, String channelMuster, LimitBranchRange resBranchRange, String counterFlag) {
        RbRestraintControlDetailsEO eo = new RbRestraintControlDetailsEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(status);
        eo.setProdNo(prodNo);
        eo.setTranTypeLink(tranTypeLink);
        eo.setNarrativeCode(narrativeCode);
        eo.setChannelMuster(channelMuster);
        eo.setResBranchRange(resBranchRange);
        eo.setCounterFlag(counterFlag);
        return eo;
    }

    private static ST112InputBO input(SourceType sourceType, TranType tranType, String narrativeCode, String prodType) {
        ST112InputBO input = new ST112InputBO();
        input.setSourceType(sourceType);
        input.setRestraintType(RestraintType.VALUE_13);
        input.setTranType(tranType);
        input.setNarrativeCode(narrativeCode);
        input.setProdType(prodType);
        return input;
    }

    private static void assertSuccessWithoutError(ST112OutputBO result) {
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}

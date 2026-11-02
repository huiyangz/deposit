package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST048InputBO;
import com.dcits.deposit.facade.bo.ST048OutputBO;
import com.dcits.deposit.facade.components.IFmChannelBcc;
import com.dcits.deposit.facade.components.IRbRestraintControlDetailsBcc;
import com.dcits.deposit.facade.eo.FmChannelEO;
import com.dcits.deposit.facade.eo.RbRestraintControlDetailsEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST048 检查限制豁免 步骤实现单元测试。
 */
@ExtendWith(MockitoExtension.class)
class ST048PbcTest {

    /** 渠道类型表(FM_CHANNEL)数据服务 */
    @Mock
    IFmChannelBcc fmChannelBcc;

    /** 限制控制明细表(RB_RESTRAINT_CONTROL_DETAILS)数据服务 */
    @Mock
    IRbRestraintControlDetailsBcc rbRestraintControlDetailsBcc;

    /** 被测步骤实现 */
    @InjectMocks
    ST048Pbc st048Pbc;

    /**
     * 构造步骤输入：除摘要码外其余四个必填输入按用例固定取值。
     *
     * @param sourceType    渠道类型
     * @param narrativeCode 摘要码
     * @return 步骤输入
     */
    private ST048InputBO buildInput(SourceType sourceType, String narrativeCode) {
        ST048InputBO input = new ST048InputBO();
        input.setSourceType(sourceType);
        input.setRestraintType(RestraintType.VALUE_6);
        input.setTranType(TranType.VALUE_1000);
        input.setNarrativeCode(narrativeCode);
        input.setProductType("1001001");
        return input;
    }

    /**
     * 构造渠道类型记录。
     *
     * @param sourceType 渠道类型
     * @param channelDesc 渠道描述
     * @return 渠道类型记录
     */
    private FmChannelEO buildChannelEO(SourceType sourceType, String channelDesc) {
        FmChannelEO channelEO = new FmChannelEO();
        channelEO.setChannel(sourceType);
        channelEO.setChannelDesc(channelDesc);
        return channelEO;
    }

    /**
     * 构造限制控制明细记录：业务字段与用例一致，摘要码、柜面标志、最后更新时间按参数取值。
     *
     * @param narrativeCode    摘要码
     * @param counterFlag      柜面标志
     * @param lastUpdTimestamp 最后更新时间
     * @return 限制控制明细记录
     */
    private RbRestraintControlDetailsEO buildDetailEO(String narrativeCode, String counterFlag, String lastUpdTimestamp) {
        RbRestraintControlDetailsEO detailEO = new RbRestraintControlDetailsEO();
        detailEO.setChannelMuster("MT,EB");
        detailEO.setProdNo("1001001");
        detailEO.setNarrativeCode(narrativeCode);
        detailEO.setTranTypeLink("1000");
        detailEO.setResBranchRange(LimitBranchRange.A);
        detailEO.setCounterFlag(counterFlag);
        detailEO.setStatus(Status.A);
        detailEO.setRestraintType(RestraintType.VALUE_6);
        detailEO.setExpression("*");
        detailEO.setBatchFlag("N");
        detailEO.setCreateTimestamp("20261010120000");
        detailEO.setLastUpdTimestamp(lastUpdTimestamp);
        return detailEO;
    }

    // 柜面渠道(MT)且明细柜面标志=「Y」：跳转柜面豁免检查，明细存在交易类型、摘要码、产品类型同时匹配记录 → 成功，输出与查询结果一致
    @Test
    void testST048T01() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.MT))
                .thenReturn(buildChannelEO(SourceType.MT, "Teller9综合柜员前端柜面系统"));
        RbRestraintControlDetailsEO detailEO = buildDetailEO("1000A", "Y", "20261010120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detailEO));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.MT, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("1000A", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("Y", output.getCounterFlag());
    }

    // 柜面渠道(MT)且明细柜面标志=「Y」：跳转柜面豁免检查，明细不存在同时匹配记录（仅摘要码不匹配）→ 成功，输出与查询结果一致
    @Test
    void testST048T02() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.MT))
                .thenReturn(buildChannelEO(SourceType.MT, "Teller9综合柜员前端柜面系统"));
        RbRestraintControlDetailsEO detailEO = buildDetailEO("2000B", "Y", "20261010120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detailEO));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.MT, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("2000B", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("Y", output.getCounterFlag());
    }

    // 非柜面渠道(EB)且明细柜面标志=「N」（非 Y，走步骤 3 else 分支）：跳转非柜面豁免检查，明细存在交易类型、摘要码、产品类型同时匹配记录 → 成功，输出与查询结果一致
    @Test
    void testST048T03() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.EB))
                .thenReturn(buildChannelEO(SourceType.EB, "个人网上银行系统"));
        RbRestraintControlDetailsEO detailEO = buildDetailEO("1000A", "N", "20261010120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detailEO));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.EB, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("1000A", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("N", output.getCounterFlag());
    }

    // 非柜面渠道(EB)且明细柜面标志=「N」（非 Y，走步骤 3 else 分支）：跳转非柜面豁免检查，明细不存在同时匹配记录（仅摘要码不匹配）→ 不豁免，成功，输出与查询结果一致
    @Test
    void testST048T04() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.EB))
                .thenReturn(buildChannelEO(SourceType.EB, "个人网上银行系统"));
        RbRestraintControlDetailsEO detailEO = buildDetailEO("2000B", "N", "20261010120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detailEO));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.EB, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("2000B", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("N", output.getCounterFlag());
    }

    // 柜面渠道(MT)：明细查询返回两条状态=A 记录且业务取值一致、柜面标志均「Y」，跳转柜面豁免检查存在同时匹配记录 → 成功，输出与查询结果一致
    @Test
    void testST048T05() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.MT))
                .thenReturn(buildChannelEO(SourceType.MT, "Teller9综合柜员前端柜面系统"));
        RbRestraintControlDetailsEO detail1 = buildDetailEO("1000A", "Y", "20261010120000");
        RbRestraintControlDetailsEO detail2 = buildDetailEO("1000A", "Y", "20261011120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detail1, detail2));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.MT, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("1000A", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("Y", output.getCounterFlag());
    }

    // 非柜面渠道(EB)且明细柜面标志=「N」（均非 Y，走步骤 3 else 分支）：跳转非柜面豁免检查存在同时匹配记录 → 成功，输出与查询结果一致
    @Test
    void testST048T06() {
        Mockito.lenient().when(fmChannelBcc.findByChannel(SourceType.EB))
                .thenReturn(buildChannelEO(SourceType.EB, "个人网上银行系统"));
        RbRestraintControlDetailsEO detailEO = buildDetailEO("1000A", "N", "20261010120000");
        Mockito.lenient().when(rbRestraintControlDetailsBcc.findByEo(Mockito.any(RbRestraintControlDetailsEO.class)))
                .thenReturn(List.of(detailEO));

        ST048OutputBO output = st048Pbc.execute(buildInput(SourceType.EB, "1000A"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Status.A, output.getStatus());
        assertEquals("1001001", output.getProdNo());
        assertEquals("1000", output.getTranTypeLink());
        assertEquals("MT,EB", output.getChannelMuster());
        assertEquals("1000A", output.getNarrativeCode());
        assertEquals(LimitBranchRange.A, output.getResBranchRange());
        assertEquals("N", output.getCounterFlag());
    }
}

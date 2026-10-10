package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST126InputBO;
import com.dcits.depsit.facade.bo.ST126OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST126 检查是否存在现金止付限制的单元测试。
 *
 * <p>调用签名：{@code ST126OutputBO execute(ST126InputBO input)}。依赖为两个只读数据服务：
 * 步骤 1 的 {@code IRbBusRestraintsBcc.findByEo(RbBusRestraintsEO)}（零条命中返回空列表）
 * 与步骤 2 的 {@code IRbRestraintTypeBcc.findByRestraintType(RestraintType)}（无匹配返回 null），
 * 均由桩按账户限制类型返回预设配置。不 mock 被测步骤的 execute，不使用 verify/never/times
 * 验证交互，也不为被跳过子步骤提前设桩。</p>
 *
 * <p>本步骤无业务失败场景、无错误码（源需求「## 失败处理」），故全部用例断言
 * {@code succeed} 为 true 且两个错误字段为 null；检查结论由 {@code cashStopPayFlag}
 * 承载，取中文字面值「是」/「否」。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST126PbcTest {

    /** 用例统一使用的账号 */
    private static final String ACCT_NO = "6222020200112233";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST126Pbc st126Pbc;

    /** 本次执行的【账户限制信息】查询结果，桩按此返回（零条为空列表） */
    private List<RbBusRestraintsEO> restraintsResult = Collections.emptyList();

    /** 步骤 1 实际传入的查询条件，由桩捕获，供用例核对 */
    private RbBusRestraintsEO capturedQueryCondition;

    /** 步骤 2 实际传入的账户限制类型，由桩捕获，供用例核对 */
    private RestraintType capturedRestraintType;

    // ST126-TC001：REQ-001-S01 按账号 + 限制状态 A 查到 1 条记录，其类型配置为 {D,"N"} → 「是」
    @Test
    void testST126T01() {
        restraintsResult = Arrays.asList(record(RestraintType.SF1, "R202610100001"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
        assertEquals(ACCT_NO, capturedQueryCondition.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedQueryCondition.getRestraintsStatus());
    }

    // ST126-TC002：REQ-001-S02 查到 3 条生效限制，逐条判断后第 3 条命中 → 「是」
    @Test
    void testST126T02() {
        restraintsResult = Arrays.asList(
                record(RestraintType.SF1, "R202610100001"),
                record(RestraintType.SK1, "R202610100002"),
                record(RestraintType.YC1, "R202610100003"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.C, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.A, DrCrCtlFlag.A, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(config(RestraintType.YC1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
        assertEquals(RestraintsStatus.A, capturedQueryCondition.getRestraintsStatus());
    }

    // ST126-TC003：REQ-001-S03 零条生效限制信息 → 直接返回「否」，不为【限制类型表】设桩
    @Test
    void testST126T03() {
        restraintsResult = Collections.emptyList();
        stubRestraintsQuery();

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("否", result.getCashStopPayFlag());
        assertEquals(ACCT_NO, capturedQueryCondition.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedQueryCondition.getRestraintsStatus());
    }

    // ST126-TC004：REQ-002-S01 按账户限制类型取到 A-生效 配置并命中 → 「是」，查询键为该记录的类型
    @Test
    void testST126T04() {
        restraintsResult = Arrays.asList(record(RestraintType.SF1, "R202610100001"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(Mockito.any(RestraintType.class)))
                .thenAnswer(invocation -> {
                    capturedRestraintType = invocation.getArgument(0);
                    return config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "N");
                });

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
        assertEquals(RestraintType.SF1, capturedRestraintType);
    }

    // ST126-TC005：REQ-002-S02 第 1 条无 A-生效 配置不构成现金止付，继续判断第 2 条命中 → 「是」
    @Test
    void testST126T05() {
        restraintsResult = Arrays.asList(
                record(RestraintType.SK1, "R202610100002"),
                record(RestraintType.SF1, "R202610100001"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.F, DrCrCtlFlag.D, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
    }

    // ST126-TC006：REQ-003-S01 A-生效 配置为 {D,"N"}，两条件合取成立 → 「是」
    @Test
    void testST126T06() {
        restraintsResult = Arrays.asList(record(RestraintType.YC1, "R202610100003"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(config(RestraintType.YC1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
    }

    // ST126-TC007：REQ-003-S02 配置为 {D,"Y"}，现金标志非 N，唯一记录不满足 → 「否」
    @Test
    void testST126T07() {
        restraintsResult = Arrays.asList(record(RestraintType.YC1, "R202610100003"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(config(RestraintType.YC1, Status.A, DrCrCtlFlag.D, "Y"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("否", result.getCashStopPayFlag());
    }

    // ST126-TC008：REQ-003-S03 配置为 {C,"N"}，借贷方控制标志非 D，唯一记录不满足 → 「否」
    @Test
    void testST126T08() {
        restraintsResult = Arrays.asList(record(RestraintType.YC1, "R202610100003"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(config(RestraintType.YC1, Status.A, DrCrCtlFlag.C, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("否", result.getCashStopPayFlag());
    }

    // ST126-TC009：REQ-004-S01 第 1 条不满足、第 2 条满足，任一条命中即返回「是」
    @Test
    void testST126T09() {
        restraintsResult = Arrays.asList(
                record(RestraintType.SF2, "R202610100004"),
                record(RestraintType.SF1, "R202610100001"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.A, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("是", result.getCashStopPayFlag());
    }

    // ST126-TC010：REQ-004-S02 3 条均不满足（含一条其类型无 A-生效 配置）→ 「否」
    @Test
    void testST126T10() {
        restraintsResult = Arrays.asList(
                record(RestraintType.SK1, "R202610100002"),
                record(RestraintType.SF1, "R202610100001"),
                record(RestraintType.YC1, "R202610100003"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.A, DrCrCtlFlag.C, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(config(RestraintType.YC1, Status.F, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("否", result.getCashStopPayFlag());
    }

    // ST126-TC011：REQ-005-S01 三条已定义路径终点（零条 / 命中 / 全部不满足）返回「否」「是」「否」，均为非空字符串
    @Test
    void testST126T11() {
        // （a）零条生效限制信息：不查询【限制类型表】，直接返回「否」
        restraintsResult = Collections.emptyList();
        stubRestraintsQuery();

        ST126OutputBO emptyResult = st126Pbc.execute(inputOf());

        assertSucceed(emptyResult);
        assertInstanceOf(String.class, emptyResult.getCashStopPayFlag());
        assertFalse(emptyResult.getCashStopPayFlag().isEmpty());
        assertEquals("否", emptyResult.getCashStopPayFlag());

        // （b）1 条记录、配置 {D,"N"}：命中返回「是」
        restraintsResult = Arrays.asList(record(RestraintType.SF1, "R202610100001"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.D, "N"));

        ST126OutputBO hitResult = st126Pbc.execute(inputOf());

        assertSucceed(hitResult);
        assertInstanceOf(String.class, hitResult.getCashStopPayFlag());
        assertFalse(hitResult.getCashStopPayFlag().isEmpty());
        assertEquals("是", hitResult.getCashStopPayFlag());

        // （c）同一记录、配置改为 {C,"N"}：不满足返回「否」
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.A, DrCrCtlFlag.C, "N"));

        ST126OutputBO missResult = st126Pbc.execute(inputOf());

        assertSucceed(missResult);
        assertInstanceOf(String.class, missResult.getCashStopPayFlag());
        assertFalse(missResult.getCashStopPayFlag().isEmpty());
        assertEquals("否", missResult.getCashStopPayFlag());
    }

    // ST126-TC012：REQ-004-S02 括注——两条类型的配置状态均为非 A，即使 {D,"N"} 也不构成现金止付 → 「否」
    @Test
    void testST126T12() {
        restraintsResult = Arrays.asList(
                record(RestraintType.SF1, "R202610100001"),
                record(RestraintType.SF2, "R202610100004"));
        stubRestraintsQuery();
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF1))
                .thenReturn(config(RestraintType.SF1, Status.F, DrCrCtlFlag.D, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.F, DrCrCtlFlag.D, "N"));

        ST126OutputBO result = st126Pbc.execute(inputOf());

        assertSucceed(result);
        assertEquals("否", result.getCashStopPayFlag());
    }

    /**
     * 为步骤 1 的【账户限制信息】查询设桩：捕获实际传入的查询条件，
     * 并按本次设定的 {@code restraintsResult} 返回（零条为空列表）。
     */
    private void stubRestraintsQuery() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryCondition = invocation.getArgument(0);
                    return restraintsResult;
                });
    }

    /** 构造【账户限制信息】中的一条生效记录（限制状态为 A）。 */
    private static RbBusRestraintsEO record(RestraintType restraintType, String resSeqNo) {
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setBaseAcctNo(ACCT_NO);
        record.setRestraintsStatus(RestraintsStatus.A);
        record.setRestraintType(restraintType);
        record.setResSeqNo(resSeqNo);
        return record;
    }

    /** 构造【限制类型表】中的一条配置。 */
    private static RbRestraintTypeEO config(RestraintType restraintType, Status status,
            DrCrCtlFlag drCrCtlFlag, String cashFlag) {
        RbRestraintTypeEO config = new RbRestraintTypeEO();
        config.setRestraintType(restraintType);
        config.setStatus(status);
        config.setDrCrCtlFlag(drCrCtlFlag);
        config.setCashFlag(cashFlag);
        return config;
    }

    /** 构造步骤输入：账号。 */
    private static ST126InputBO inputOf() {
        ST126InputBO input = new ST126InputBO();
        input.setBaseAcctNo(ACCT_NO);
        return input;
    }

    /** 断言已定义业务路径的成功结论：succeed 为 true、两个错误字段为 null。 */
    private static void assertSucceed(ST126OutputBO result) {
        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}

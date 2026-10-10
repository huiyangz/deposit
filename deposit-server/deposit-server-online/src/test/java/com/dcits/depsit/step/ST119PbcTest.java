package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST119InputBO;
import com.dcits.depsit.facade.bo.ST119OutputBO;
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
 * ST119 检查是否存在止付限制的单元测试。
 *
 * <p>调用签名：{@code ST119OutputBO execute(ST119InputBO input)}。依赖为两个只读数据服务：
 * 子步骤 1 的 {@code IRbBusRestraintsBcc.findByEo(RbBusRestraintsEO)}（零条命中返回空列表）
 * 与子步骤 2 的 {@code IRbRestraintTypeBcc.findByRestraintType(RestraintType)}（无匹配返回 null），
 * 均由桩按账户限制类型返回预设配置。不 mock 被测步骤的 execute，不使用 verify/never/times
 * 验证交互，也不为被跳过的子步骤提前设桩。</p>
 *
 * <p>本步骤无业务失败场景、无错误码（源需求「## 失败处理」），故全部用例断言
 * {@code succeed} 为 true；检查结论由 {@code stopFlag} 承载，取中文字面值「是」/「否」。
 * 「有生效记录但无一条命中」分支的 5 个回显字段取值 Spec 未明文规定，相关用例不作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST119PbcTest {

    /** 用例统一使用的账号 */
    private static final String ACCT_NO = "6222020200000001";

    /** ST119-TC016 使用的另一账号 */
    private static final String OTHER_ACCT_NO = "6222020200000002";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST119Pbc st119Pbc;

    // ST119-TC001：REQ-001-S01/REQ-002-S01/REQ-004-S01/REQ-005-S01/REQ-006-S01/REQ-007-S03③
    // 单条生效记录，其类型配置为 {A-生效, D-禁止借方} → 命中「是」并回显该条记录
    @Test
    void testST119T01() {
        stubRestraintsQuery(Arrays.asList(record("0001", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_4, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC002：REQ-003-S01/REQ-001-S02/REQ-007-S03①
    // 账号无「A-生效」记录（库表中只有一条「F-未生效」记录）→ 「否」且 5 个回显字段为空值；
    // 桩按查询条件区分生效/非生效记录，漏掉限制状态过滤的实现会取到非生效记录；
    // 本条路径不触达【限制类型表】，故不为其设桩；仅提供 baseAcctNo 一个入参即完成执行
    @Test
    void testST119T02() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    RbBusRestraintsEO condition = invocation.getArgument(0);
                    if (RestraintsStatus.A.equals(condition.getRestraintsStatus())) {
                        return Collections.emptyList();
                    }
                    // 库表中该账号只有一条限制状态为「F-未生效」的记录
                    return Arrays.asList(
                            record("0009", RestraintType.VALUE_4, RestraintsStatus.F));
                });

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
    }

    // ST119-TC003：REQ-002-S03/REQ-003-S03
    // 账号下只有「F-未生效」「E-已终止」记录 → 同属无记录分支，非「A-生效」记录不参与判定与回显；
    // 桩仅在有「A-生效」条件时返回空列表；为 VALUE_4 预置标志为「D」的生效配置，
    // 漏掉限制状态过滤的实现会取到非生效记录并误判为「是」（本路径不应触达该桩）
    @Test
    void testST119T03() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    RbBusRestraintsEO condition = invocation.getArgument(0);
                    if (RestraintsStatus.A.equals(condition.getRestraintsStatus())) {
                        return Collections.emptyList();
                    }
                    return Arrays.asList(
                            record("0009", RestraintType.VALUE_4, RestraintsStatus.F),
                            record("0008", RestraintType.VALUE_13, RestraintsStatus.E));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
    }

    // ST119-TC004：REQ-004-S02/REQ-007-S03②
    // 该账户限制类型在【限制类型表】中无记录 → 该条不构成止付限制、不参与判定，
    // drCrCtlFlag 与 status 输出空值；结论为「否」
    @Test
    void testST119T04() {
        stubRestraintsQuery(Arrays.asList(record("0001", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, null);

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
    }

    // ST119-TC005：REQ-004-S03
    // 该类型有记录但状态为 F（无效）→ 视为无「生效」配置：不参与判定，
    // status 输出空值而非 F，即使标志为 D 也不构成止付限制
    @Test
    void testST119T05() {
        stubRestraintsQuery(Arrays.asList(record("0001", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.F, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
    }

    // ST119-TC006：REQ-005-S05/REQ-007-S03②
    // 2 条生效记录（VALUE_4、VALUE_16）的类型在【限制类型表】中均无「A-生效」配置，
    // 全部不参与判定 → 「否」，两条的 drCrCtlFlag/status 均为空值
    @Test
    void testST119T06() {
        stubRestraintsQuery(Arrays.asList(
                record("0001", RestraintType.VALUE_4, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_16, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, null);
        stubTypeInfo(RestraintType.VALUE_16, null);

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
    }

    // ST119-TC007：REQ-002-S02/REQ-005-S02
    // 3 条生效记录逐条处理，命中出现在最后一条（"0001"→C、"0002"→无生效配置、"0003"→D）：
    // 多条为合法结果、前两条不命中或无法判定不结束检查 → 「是」并回显最后一条
    @Test
    void testST119T07() {
        stubRestraintsQuery(Arrays.asList(
                record("0001", RestraintType.VALUE_6, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_7, RestraintsStatus.A),
                record("0003", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_6, config(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C));
        stubTypeInfo(RestraintType.VALUE_7, null);
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0003", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_4, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC008：REQ-005-S03/REQ-008-S01
    // 2 条生效记录的标志分别为 C（禁止贷方）与 A（禁止借贷方），均不等于「D-禁止借方」→ 「否」；
    // 该分支 5 个回显字段取值 Spec 未明文，不断言
    @Test
    void testST119T08() {
        stubRestraintsQuery(Arrays.asList(
                record("0001", RestraintType.VALUE_6, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_7, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_6, config(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C));
        stubTypeInfo(RestraintType.VALUE_7, config(RestraintType.VALUE_7, Status.A, DrCrCtlFlag.A));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
    }

    // ST119-TC009：REQ-005-S06
    // 单条生效记录的配置标志为 A（禁止借贷方），「D-禁止借方」之外的码值落入「否则」分支 → 「否」
    @Test
    void testST119T09() {
        stubRestraintsQuery(Arrays.asList(record("0001", RestraintType.VALUE_13, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_13,
                config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.A));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("否", result.getStopFlag());
    }

    // ST119-TC010：REQ-005-S04
    // 2 条生效记录：第 1 条 C 不命中，「否则」不结束检查；第 2 条 D 命中 → 「是」并回显第 2 条
    @Test
    void testST119T10() {
        stubRestraintsQuery(Arrays.asList(
                record("0001", RestraintType.VALUE_6, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_6, config(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_4, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC011：REQ-004-S04/REQ-006
    // 2 条记录分别按各自限制类型取配置：VALUE_4 无生效配置不参与判定，VALUE_13 命中 → 「是」，
    // 回显命中的 VALUE_13 记录（"0002"），不得误回显无生效配置的 "0001"
    @Test
    void testST119T11() {
        stubRestraintsQuery(Arrays.asList(
                record("0001", RestraintType.VALUE_4, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_13, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, null);
        stubTypeInfo(RestraintType.VALUE_13,
                config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC012：REQ-006-S02
    // 3 条记录均命中，编号位数相同（"0002"、"0001"、"0003"）→ 取编号最小的一条回显（"0001"），
    // 限制类型与限制状态同取该条记录的值（VALUE_13）
    @Test
    void testST119T12() {
        stubRestraintsQuery(Arrays.asList(
                record("0002", RestraintType.VALUE_4, RestraintsStatus.A),
                record("0001", RestraintType.VALUE_13, RestraintsStatus.A),
                record("0003", RestraintType.VALUE_16, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));
        stubTypeInfo(RestraintType.VALUE_13,
                config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D));
        stubTypeInfo(RestraintType.VALUE_16,
                config(RestraintType.VALUE_16, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC013：REQ-006-S03
    // 2 条记录均命中 → 回显三字段必须同取限制编号最小的那条记录（"0002" 及其类型 VALUE_13），
    // 不得出现限制编号取 "0002" 而限制类型取另一条记录值的情形
    @Test
    void testST119T13() {
        stubRestraintsQuery(Arrays.asList(
                record("0005", RestraintType.VALUE_4, RestraintsStatus.A),
                record("0002", RestraintType.VALUE_13, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));
        stubTypeInfo(RestraintType.VALUE_13,
                config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC014：REQ-006-S04（边界）
    // 命中多条且限制编号位数不同（"10" 与 "9"）→ 按编号所表示的数字大小取最小的一条回显 "9"；
    // 按字典序会误取 "10"
    @Test
    void testST119T14() {
        stubRestraintsQuery(Arrays.asList(
                record("10", RestraintType.VALUE_4, RestraintsStatus.A),
                record("9", RestraintType.VALUE_13, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));
        stubTypeInfo(RestraintType.VALUE_13,
                config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("9", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST119-TC015：REQ-007-S01/REQ-007-S02
    // 6 个输出字段的名称与类型：命中路径 6 字段均有值，类型分别为
    // String/String/RestraintType/RestraintsStatus/DrCrCtlFlag/Status；
    // 同一 stopFlag 字段在无记录路径取「否」
    @Test
    void testST119T15() {
        // （a）命中路径：单条记录命中，6 个字段均有值
        stubRestraintsQuery(Arrays.asList(record("0001", RestraintType.VALUE_4, RestraintsStatus.A)));
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO hit = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(hit);
        assertInstanceOf(String.class, hit.getStopFlag());
        assertInstanceOf(String.class, hit.getResSeqNo());
        assertInstanceOf(RestraintType.class, hit.getRestraintType());
        assertInstanceOf(RestraintsStatus.class, hit.getRestraintsStatus());
        assertInstanceOf(DrCrCtlFlag.class, hit.getDrCrCtlFlag());
        assertInstanceOf(Status.class, hit.getStatus());
        assertEquals("是", hit.getStopFlag());

        // （b）无记录路径：同一 stopFlag 字段取「否」
        stubRestraintsQuery(Collections.emptyList());

        ST119OutputBO empty = st119Pbc.execute(inputOf(ACCT_NO));

        assertSucceed(empty);
        assertInstanceOf(String.class, empty.getStopFlag());
        assertEquals("否", empty.getStopFlag());
    }

    // ST119-TC016：REQ-001-S02/REQ-002-S01/REQ-002-S03
    // 以另一账号执行：账号值原样作为子步骤 1 的查询条件传递（桩仅在账号与限制状态同时匹配时
    // 返回记录），且仅提供 baseAcctNo 一个入参即完成执行
    @Test
    void testST119T16() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    RbBusRestraintsEO condition = invocation.getArgument(0);
                    if (OTHER_ACCT_NO.equals(condition.getBaseAcctNo())
                            && RestraintsStatus.A.equals(condition.getRestraintsStatus())) {
                        return Arrays.asList(
                                record(OTHER_ACCT_NO, "0001", RestraintType.VALUE_4,
                                        RestraintsStatus.A));
                    }
                    return Collections.emptyList();
                });
        stubTypeInfo(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.D));

        ST119OutputBO result = st119Pbc.execute(inputOf(OTHER_ACCT_NO));

        assertSucceed(result);
        assertEquals("是", result.getStopFlag());
        assertEquals("0001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_4, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    /** 为子步骤 1 的【账户限制信息】查询设桩，返回本次设定的记录列表（零条为空列表）。 */
    private void stubRestraintsQuery(List<RbBusRestraintsEO> result) {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenReturn(result);
    }

    /** 为子步骤 2 的【限制类型表】查询设桩，按账户限制类型返回预设配置（null 表示无该类型记录）。 */
    private void stubTypeInfo(RestraintType restraintType, RbRestraintTypeEO typeInfo) {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(restraintType))
                .thenReturn(typeInfo);
    }

    /** 构造【账户限制信息】中归属于用例账号的一条限制记录。 */
    private static RbBusRestraintsEO record(String resSeqNo, RestraintType restraintType,
            RestraintsStatus restraintsStatus) {
        return record(ACCT_NO, resSeqNo, restraintType, restraintsStatus);
    }

    /** 构造【账户限制信息】中指定账号的一条限制记录。 */
    private static RbBusRestraintsEO record(String baseAcctNo, String resSeqNo,
            RestraintType restraintType, RestraintsStatus restraintsStatus) {
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setBaseAcctNo(baseAcctNo);
        record.setResSeqNo(resSeqNo);
        record.setRestraintType(restraintType);
        record.setRestraintsStatus(restraintsStatus);
        return record;
    }

    /** 构造【限制类型表】中的一条配置。 */
    private static RbRestraintTypeEO config(RestraintType restraintType, Status status,
            DrCrCtlFlag drCrCtlFlag) {
        RbRestraintTypeEO config = new RbRestraintTypeEO();
        config.setRestraintType(restraintType);
        config.setStatus(status);
        config.setDrCrCtlFlag(drCrCtlFlag);
        return config;
    }

    /** 构造步骤输入：仅账号一个入参。 */
    private static ST119InputBO inputOf(String baseAcctNo) {
        ST119InputBO input = new ST119InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    /** 断言已定义业务路径的成功结论：succeed 为 true、两个错误字段为 null。 */
    private static void assertSucceed(ST119OutputBO result) {
        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}

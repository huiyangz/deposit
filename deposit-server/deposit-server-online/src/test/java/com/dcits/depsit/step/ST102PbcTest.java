package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.HierarchyCode;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST102InputBO;
import com.dcits.depsit.facade.bo.ST102OutputBO;
import com.dcits.depsit.facade.components.IFmBranchBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.FmBranchEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST102 检查账户机构是否可匹配到限额场景配置 步骤单元测试。
 *
 * <p>真实 {@link ST102Pbc}；仅对三个依赖数据服务接口 {@link IRbBusAcctBcc}、{@link IRbLimitCtrlConfBcc}、
 * {@link IFmBranchBcc} 设桩，不访问数据库、网络或外部服务，不模拟技术异常，也不验证交互次数与顺序。</p>
 *
 * <p>桩按业务数据分派返回：账户桩记录收到的查询条件后返回给定记录；配置桩按收到的
 * {@code limitBranchId} 取该机构候选记录、再按收到的 {@code validFlag}（非空时）过滤后返回；
 * 机构桩按入参机构号返回给定记录、未登记机构号返回 {@code null}。请求对象经桩记录后在用例内断言，
 * 用于核对查询键与「不追加缩窄条件」。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST102PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @Mock
    private IFmBranchBcc fmBranchBcc;

    @InjectMocks
    private ST102Pbc st102Pbc;

    /** 账户桩收到的查询条件对象。 */
    private final List<RbBusAcctEO> capturedAcctConditions = new ArrayList<>();

    /** 配置桩收到的查询条件对象。 */
    private final List<RbLimitCtrlConfEO> capturedConfConditions = new ArrayList<>();

    // ST102-TC001：REQ-001-S01/S02、REQ-002-S01、REQ-003-S01、REQ-004-S01、REQ-007-S03
    // 账号唯一命中一条账户记录，账户开立行唯一启用配置命中，子步骤 3 非空直接返回并短路，不查询机构信息表
    @Test
    void testST102T01() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        stubConfCandidates(Map.of(TranBranch.VALUE_352105, List.of(
                conf(TranBranch.VALUE_352105, "LSN1001", "Y", "2026-09-20 10:00:00.000000"))));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertInstanceOf(String.class, output.getLimitSceneNo());
        assertEquals("LSN1001", output.getLimitSceneNo());
        // 子步骤 1 的账户查询仅以输入 baseAcctNo 为条件，未追加缩窄条件
        assertEquals(1, capturedAcctConditions.size());
        assertEquals("6201000000001234", capturedAcctConditions.get(0).getBaseAcctNo());
        assertNull(capturedAcctConditions.get(0).getAcctBranch());
        // 子步骤 2 的配置查询恰为「限额机构编码＝账户开立行行号」与「启用标志＝Y」两项，未追加其它定位条件
        assertEquals(1, capturedConfConditions.size());
        assertEquals(TranBranch.VALUE_352105, capturedConfConditions.get(0).getLimitBranchId());
        assertEquals("Y", capturedConfConditions.get(0).getValidFlag());
        assertNull(capturedConfConditions.get(0).getLimitSceneNo());
    }

    // ST102-TC002：REQ-003-S02 账户开立行同一机构存在两条启用配置与一条未启用配置，
    // 按最后修改时间戳取最近维护的一条启用配置的限额场景编码并返回，未启用记录不参与取用
    @Test
    void testST102T02() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        stubConfCandidates(Map.of(TranBranch.VALUE_352105, List.of(
                conf(TranBranch.VALUE_352105, "LSN1001", "Y", "2026-09-20 10:00:00.000000"),
                conf(TranBranch.VALUE_352105, "LSN1002", "Y", "2026-10-05 09:30:00.000000"),
                conf(TranBranch.VALUE_352105, "LSN1003", "N", "2026-10-08 08:00:00.000000"))));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("LSN1002", output.getLimitSceneNo());
        assertNotEquals("LSN1001", output.getLimitSceneNo());
        assertNotEquals("LSN1003", output.getLimitSceneNo());
        assertEquals("Y", capturedConfConditions.get(0).getValidFlag());
    }

    // ST102-TC003：REQ-004-S02、REQ-005-S01、REQ-006-S01、REQ-007-S01、REQ-009-S02
    // 账户开立行无启用配置，跳转子步骤 4 沿归属上级机构号逐级构建上级机构集合（不含账户开立行自身），
    // 再按机构层级从高到低遍历，总行首个命中即中断遍历并返回
    @Test
    void testST102T03() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        Map<TranBranch, List<RbLimitCtrlConfEO>> candidates = new HashMap<>();
        candidates.put(TranBranch.VALUE_352105, List.of(
                conf(TranBranch.VALUE_352105, "LSN1003", "N", "2026-10-08 08:00:00.000000")));
        candidates.put(TranBranch.VALUE_351001, List.of(
                conf(TranBranch.VALUE_351001, "LSN2001", "Y", "2026-09-18 09:00:00.000000")));
        candidates.put(TranBranch.VALUE_352001, List.of(
                conf(TranBranch.VALUE_352001, "LSN3001", "Y", "2026-09-22 10:00:00.000000")));
        stubConfCandidates(candidates);
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, TranBranch.VALUE_352001, HierarchyCode.VALUE_2),
                TranBranch.VALUE_352001, org(TranBranch.VALUE_352001, TranBranch.VALUE_351001, HierarchyCode.VALUE_1),
                TranBranch.VALUE_351001, org(TranBranch.VALUE_351001, null, HierarchyCode.VALUE_0)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("LSN2001", output.getLimitSceneNo());
        // 总行 351001 命中即中断，分行 352001 的配置不被返回，体现「总行 → 分行 → 支行」的遍历顺序
        assertNotEquals("LSN3001", output.getLimitSceneNo());
        // 子步骤 5 以遍历元素自身的机构号为查询键，而非账户开立行行号
        assertTrue(requestedLimitBranches().contains(TranBranch.VALUE_351001));
    }

    // ST102-TC004：REQ-006-S02 最高层级机构未命中限额场景，继续遍历下一条元素，分行命中后中断遍历并返回
    @Test
    void testST102T04() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        Map<TranBranch, List<RbLimitCtrlConfEO>> candidates = new HashMap<>();
        candidates.put(TranBranch.VALUE_352105, Collections.emptyList());
        candidates.put(TranBranch.VALUE_351001, Collections.emptyList());
        candidates.put(TranBranch.VALUE_352001, List.of(
                conf(TranBranch.VALUE_352001, "LSN3001", "Y", "2026-09-22 10:00:00.000000")));
        stubConfCandidates(candidates);
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, TranBranch.VALUE_352001, HierarchyCode.VALUE_2),
                TranBranch.VALUE_352001, org(TranBranch.VALUE_352001, TranBranch.VALUE_351001, HierarchyCode.VALUE_1),
                TranBranch.VALUE_351001, org(TranBranch.VALUE_351001, null, HierarchyCode.VALUE_0)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("LSN3001", output.getLimitSceneNo());
        // 总行未命中后继续遍历至分行命中
        assertTrue(requestedLimitBranches().contains(TranBranch.VALUE_351001));
        assertTrue(requestedLimitBranches().contains(TranBranch.VALUE_352001));
    }

    // ST102-TC005：REQ-006-S04 某上级机构存在两条启用配置与一条未启用配置，
    // 按最后修改时间戳取最近维护的一条并中断遍历返回
    @Test
    void testST102T05() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        Map<TranBranch, List<RbLimitCtrlConfEO>> candidates = new HashMap<>();
        candidates.put(TranBranch.VALUE_352105, Collections.emptyList());
        candidates.put(TranBranch.VALUE_351001, Collections.emptyList());
        candidates.put(TranBranch.VALUE_352001, List.of(
                conf(TranBranch.VALUE_352001, "LSN3002", "Y", "2026-09-25 14:00:00.000000"),
                conf(TranBranch.VALUE_352001, "LSN3001", "Y", "2026-10-06 11:20:00.000000"),
                conf(TranBranch.VALUE_352001, "LSN3003", "N", "2026-10-09 09:00:00.000000")));
        stubConfCandidates(candidates);
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, TranBranch.VALUE_352001, HierarchyCode.VALUE_2),
                TranBranch.VALUE_352001, org(TranBranch.VALUE_352001, TranBranch.VALUE_351001, HierarchyCode.VALUE_1),
                TranBranch.VALUE_351001, org(TranBranch.VALUE_351001, null, HierarchyCode.VALUE_0)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("LSN3001", output.getLimitSceneNo());
        assertNotEquals("LSN3002", output.getLimitSceneNo());
        assertNotEquals("LSN3003", output.getLimitSceneNo());
    }

    // ST102-TC006：REQ-003-S03、REQ-004-S02、REQ-005-S02、REQ-006-S03
    // 账户开立行无任何配置记录，跳转子步骤 4 后机构信息表查不到该机构记录，上级机构集合为空，
    // 子步骤 5 遍历零次并返回空值，且不判为业务失败
    @Test
    void testST102T06() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        stubConfCandidates(Map.of(TranBranch.VALUE_352105, Collections.<RbLimitCtrlConfEO>emptyList()));
        // 机构桩本路径不设桩：未登记机构号即返回 null（FM_BRANCH 无 branch=352105 记录）

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // ST102-TC007：REQ-003-S03、REQ-005-S03 账户开立行仅有非启用配置，跳转子步骤 4 后机构记录存在
    // 但归属上级机构号为空，上级机构集合为空，返回空值且不判为业务失败
    @Test
    void testST102T07() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        stubConfCandidates(Map.of(TranBranch.VALUE_352105, List.of(
                conf(TranBranch.VALUE_352105, "LSN1003", "N", "2026-10-08 08:00:00.000000"))));
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, null, HierarchyCode.VALUE_2)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getLimitSceneNo());
    }

    // ST102-TC008：REQ-006-S03 上级机构集合含总行与分行两个元素，遍历全部元素均未取到启用配置的
    // 限额场景编码，结束遍历并返回空值，正常结束
    @Test
    void testST102T08() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        Map<TranBranch, List<RbLimitCtrlConfEO>> candidates = new HashMap<>();
        candidates.put(TranBranch.VALUE_352105, Collections.emptyList());
        candidates.put(TranBranch.VALUE_351001, Collections.emptyList());
        candidates.put(TranBranch.VALUE_352001, List.of(
                conf(TranBranch.VALUE_352001, "LSN3003", "N", "2026-10-09 09:00:00.000000")));
        stubConfCandidates(candidates);
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, TranBranch.VALUE_352001, HierarchyCode.VALUE_2),
                TranBranch.VALUE_352001, org(TranBranch.VALUE_352001, TranBranch.VALUE_351001, HierarchyCode.VALUE_1),
                TranBranch.VALUE_351001, org(TranBranch.VALUE_351001, null, HierarchyCode.VALUE_0)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getLimitSceneNo());
        assertNotEquals("LSN3003", output.getLimitSceneNo());
    }

    // ST102-TC009：REQ-002-S02、REQ-007-S02、REQ-008-S01 按输入账号查询账户信息返回 0 条记录，
    // 步骤返回错误码 ER0048 并结束，不产出限额场景编码（后续子步骤的依赖未设桩）
    @Test
    void testST102T09() {
        stubAccount(Collections.emptyList());

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertFalse(output.isSucceed());
        assertEquals("ER0048", output.getErrorCode());
        assertNull(output.getLimitSceneNo());
    }

    // ST102-TC010：REQ-002-S03、REQ-007-S02、REQ-008-S01 按输入账号查询账户信息返回多于 1 条记录，
    // 与查无记录按同一错误码 ER0048 处理并结束，不取用任一记录的账户开立行行号
    @Test
    void testST102T10() {
        stubAccount(List.of(
                acct("6201000000001234", TranBranch.VALUE_352105, 1001),
                acct("6201000000001234", TranBranch.VALUE_351155, 1002)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertFalse(output.isSucceed());
        assertEquals("ER0048", output.getErrorCode());
        assertNull(output.getLimitSceneNo());
    }

    // ST102-TC011：REQ-005-S01、REQ-006-S02 归属链仅有一层上级机构，上级机构集合含 1 个元素，
    // 逐级向上在首轮即终止（该元素归属上级机构号为空），遍历单项即命中并返回
    @Test
    void testST102T11() {
        stubAccount(List.of(acct("6201000000001234", TranBranch.VALUE_352105, 1001)));
        Map<TranBranch, List<RbLimitCtrlConfEO>> candidates = new HashMap<>();
        candidates.put(TranBranch.VALUE_352105, Collections.emptyList());
        candidates.put(TranBranch.VALUE_352001, List.of(
                conf(TranBranch.VALUE_352001, "LSN3001", "Y", "2026-09-22 10:00:00.000000")));
        stubConfCandidates(candidates);
        stubBranches(Map.of(
                TranBranch.VALUE_352105, org(TranBranch.VALUE_352105, TranBranch.VALUE_352001, HierarchyCode.VALUE_2),
                TranBranch.VALUE_352001, org(TranBranch.VALUE_352001, null, HierarchyCode.VALUE_1)));

        ST102OutputBO output = st102Pbc.execute(input("6201000000001234"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("LSN3001", output.getLimitSceneNo());
    }

    /** 账户桩：记录收到的查询条件，返回给定账户记录。 */
    private void stubAccount(List<RbBusAcctEO> records) {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            capturedAcctConditions.add(invocation.getArgument(0));
            return records;
        });
    }

    /** 配置桩：记录收到的查询条件，按其中的机构号取候选记录、再按其中的启用标志（非空时）过滤后返回。 */
    private void stubConfCandidates(Map<TranBranch, List<RbLimitCtrlConfEO>> candidates) {
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenAnswer(invocation -> {
            RbLimitCtrlConfEO condition = invocation.getArgument(0);
            capturedConfConditions.add(condition);
            List<RbLimitCtrlConfEO> matched = candidates.get(condition.getLimitBranchId());
            if (matched == null) {
                return Collections.<RbLimitCtrlConfEO>emptyList();
            }
            if (condition.getValidFlag() == null) {
                return matched;
            }
            List<RbLimitCtrlConfEO> enabled = new ArrayList<>();
            for (RbLimitCtrlConfEO conf : matched) {
                if (condition.getValidFlag().equals(conf.getValidFlag())) {
                    enabled.add(conf);
                }
            }
            return enabled;
        });
    }

    /** 机构桩：按入参机构号返回给定机构记录，未登记机构号返回 null。 */
    private void stubBranches(Map<TranBranch, FmBranchEO> branches) {
        Mockito.lenient().when(fmBranchBcc.findByBranch(any(TranBranch.class))).thenAnswer(
                invocation -> branches.get(invocation.getArgument(0)));
    }

    /** 配置桩收到的查询键机构号（按调用先后），用于核对子步骤 5 以遍历元素自身机构号为键。 */
    private List<TranBranch> requestedLimitBranches() {
        List<TranBranch> requested = new ArrayList<>();
        for (RbLimitCtrlConfEO condition : capturedConfConditions) {
            requested.add(condition.getLimitBranchId());
        }
        return requested;
    }

    /** 构造账户记录：仅填本步骤使用的账号、账户开立行行号与主键。 */
    private static RbBusAcctEO acct(String baseAcctNo, TranBranch acctBranch, Integer internalKey) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setBaseAcctNo(baseAcctNo);
        eo.setAcctBranch(acctBranch);
        eo.setInternalKey(internalKey);
        return eo;
    }

    /** 构造限额控制配置记录：仅填本步骤判定与取用所需的字段。 */
    private static RbLimitCtrlConfEO conf(TranBranch limitBranchId, String limitSceneNo, String validFlag,
                                          String lastUpdTimestamp) {
        RbLimitCtrlConfEO eo = new RbLimitCtrlConfEO();
        eo.setLimitBranchId(limitBranchId);
        eo.setLimitSceneNo(limitSceneNo);
        eo.setValidFlag(validFlag);
        eo.setLastUpdTimestamp(lastUpdTimestamp);
        eo.setLimitBranchRange(LimitBranchRange.C);
        return eo;
    }

    /** 构造机构记录：仅填本步骤使用的归属机构号、归属上级机构号与机构层级。 */
    private static FmBranchEO org(TranBranch branch, TranBranch attachedTo, HierarchyCode hierarchyCode) {
        FmBranchEO eo = new FmBranchEO();
        eo.setBranch(branch);
        eo.setAttachedTo(attachedTo);
        eo.setHierarchyCode(hierarchyCode);
        return eo;
    }

    /** 构造步骤输入：账号（本步骤唯一业务入参）。 */
    private static ST102InputBO input(String baseAcctNo) {
        ST102InputBO input = new ST102InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }
}

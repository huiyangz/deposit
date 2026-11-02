package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IRbBusClientAcctBcc;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST038 检查账户机构是否可匹配到限额场景配置 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01/S02、REQ-004-S01/S02、
 * REQ-005-S01、REQ-006-S01/S02/S03（ST038-TC001~TC005）。
 * 查询表与字段绑定（TBD-1/TBD-2）、启用标志物理取值（TBD-3）、多条命中取数规则（TBD-4）、
 * 上级机构集合构成与排序方向（TBD-5）、必填缺失与查无记录行为（TBD-6）为 Spec 待确认事项，
 * 相关桩按需求原文或工程可行绑定表述，不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST038PbcTest {

    @Mock
    private IRbBusClientAcctBcc rbBusClientAcctBcc;

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @Mock
    private IFmBranchBcc fmBranchBcc;

    @InjectMocks
    private ST038Pbc st038Pbc;

    // 场景 REQ-001-S01/REQ-002-S01/REQ-003-S01/REQ-004-S01（ST038-TC001 正常主路径）：账号存在且账户开立行存在启用限额配置，
    // 在限额控制配置表命中 limitSceneNo 非空直接返回并正常结束，不进入《获取上级机构集合》（branch/attachedTo 为 null）
    @Test
    void testST038T01() {
        RbBusClientAcctEO acctRecord = buildAcctRecord(TranBranch.VALUE_351001);
        when(rbBusClientAcctBcc.findByEo(argThat(eo -> "6221000000000012345".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctRecord));

        RbLimitCtrlConfEO confRecord = buildLimitCtrlConfRecord(TranBranch.VALUE_351001, "SCENE_Y_01", LimitBranchRange.A);
        when(rbLimitCtrlConfBcc.findByEo(argThat(eo -> eo.getLimitBranchId() == TranBranch.VALUE_351001
                && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(Collections.singletonList(confRecord));

        ST038InputBO input = new ST038InputBO();
        input.setBaseAcctNo("6221000000000012345");

        ST038OutputBO output = st038Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("SCENE_Y_01", output.getLimitSceneNo());
        assertEquals(TranBranch.VALUE_351001, output.getLimitBranchId());
        assertEquals(LimitBranchRange.A, output.getLimitBranchRange());
        assertEquals("Y-启用", output.getValidFlag());
        assertEquals(TranBranch.VALUE_351001, output.getAcctBranch());
        assertEquals(input.getBaseAcctNo(), output.getBaseAcctNo());
        assertNull(output.getBranch());
        assertNull(output.getAttachedTo());
    }

    // 场景 REQ-003-S02/REQ-004-S02/REQ-005-S01/REQ-006-S01（ST038-TC002 跳转路径）：账户开立行无启用配置，limitSceneNo 为空
    // 跳转《获取上级机构集合》，遍历首个机构命中启用场景，中断遍历返回该 limitSceneNo
    @Test
    void testST038T02() {
        RbBusClientAcctEO acctRecord = buildAcctRecord(TranBranch.VALUE_352102);
        when(rbBusClientAcctBcc.findByEo(argThat(eo -> "6221000000000023456".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctRecord));

        // 步骤 2 与步骤 5 均经 IRbLimitCtrlConfBcc.findByEo 查询，按查询条件的限额机构编码分别返回：
        // 账户开立行 VALUE_352102 无启用配置（空集合），机构 VALUE_352001 命中启用场景（单条记录）
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenAnswer(invocation -> {
            RbLimitCtrlConfEO query = invocation.getArgument(0);
            if (query.getLimitBranchId() == TranBranch.VALUE_352102) {
                return Collections.emptyList();
            }
            if (query.getLimitBranchId() == TranBranch.VALUE_352001) {
                return Collections.singletonList(
                        buildLimitCtrlConfRecord(TranBranch.VALUE_352001, "SCENE_HQ_001", null));
            }
            return Collections.emptyList();
        });

        FmBranchEO branchRecord = buildFmBranchRecord(TranBranch.VALUE_352001, TranBranch.VALUE_351001);
        when(fmBranchBcc.findByEo(argThat(eo -> eo.getBranch() == TranBranch.VALUE_352102)))
                .thenReturn(Collections.singletonList(branchRecord));

        ST038InputBO input = new ST038InputBO();
        input.setBaseAcctNo("6221000000000023456");

        ST038OutputBO output = st038Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("SCENE_HQ_001", output.getLimitSceneNo());
    }

    // 场景 REQ-006-S02/REQ-006-S01（ST038-TC003 正常路径）：上级机构集合含多条机构（分行→总行，机构层级从大到小遍历），
    // 首条机构未命中启用场景继续遍历下一条，第二条命中中断遍历返回
    @Test
    void testST038T03() {
        RbBusClientAcctEO acctRecord = buildAcctRecord(TranBranch.VALUE_352102);
        when(rbBusClientAcctBcc.findByEo(argThat(eo -> "6221000000000034567".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctRecord));

        // 步骤 2 与步骤 5 均经 IRbLimitCtrlConfBcc.findByEo 查询，按查询条件的限额机构编码分别返回：
        // 账户开立行 VALUE_352102 无启用配置；机构 VALUE_352001 未命中；机构 VALUE_351001 命中启用场景（单条记录）
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenAnswer(invocation -> {
            RbLimitCtrlConfEO query = invocation.getArgument(0);
            if (query.getLimitBranchId() == TranBranch.VALUE_352102) {
                return Collections.emptyList();
            }
            if (query.getLimitBranchId() == TranBranch.VALUE_352001) {
                return Collections.emptyList();
            }
            if (query.getLimitBranchId() == TranBranch.VALUE_351001) {
                return Collections.singletonList(
                        buildLimitCtrlConfRecord(TranBranch.VALUE_351001, "SCENE_HQ_002", null));
            }
            return Collections.emptyList();
        });

        FmBranchEO branchRecord1 = buildFmBranchRecord(TranBranch.VALUE_352001, TranBranch.VALUE_351001);
        FmBranchEO branchRecord2 = buildFmBranchRecord(TranBranch.VALUE_351001, null);
        when(fmBranchBcc.findByEo(argThat(eo -> eo.getBranch() == TranBranch.VALUE_352102)))
                .thenReturn(Arrays.asList(branchRecord1, branchRecord2));

        ST038InputBO input = new ST038InputBO();
        input.setBaseAcctNo("6221000000000034567");

        ST038OutputBO output = st038Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("SCENE_HQ_002", output.getLimitSceneNo());
    }

    // 场景 REQ-006-S03（ST038-TC004 边界否定路径）：上级机构集合全部机构遍历结束均未命中启用场景，返回 limitSceneNo 为空
    @Test
    void testST038T04() {
        RbBusClientAcctEO acctRecord = buildAcctRecord(TranBranch.VALUE_352102);
        when(rbBusClientAcctBcc.findByEo(argThat(eo -> "6221000000000045678".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctRecord));

        // 步骤 2 与步骤 5 均经 IRbLimitCtrlConfBcc.findByEo 查询：账户开立行 VALUE_352102 无启用配置，
        // 机构 VALUE_352001、VALUE_351001 均未命中，全部返回空集合
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(Collections.emptyList());

        FmBranchEO branchRecord1 = buildFmBranchRecord(TranBranch.VALUE_352001, TranBranch.VALUE_351001);
        FmBranchEO branchRecord2 = buildFmBranchRecord(TranBranch.VALUE_351001, null);
        when(fmBranchBcc.findByEo(argThat(eo -> eo.getBranch() == TranBranch.VALUE_352102)))
                .thenReturn(Arrays.asList(branchRecord1, branchRecord2));

        ST038InputBO input = new ST038InputBO();
        input.setBaseAcctNo("6221000000000045678");

        ST038OutputBO output = st038Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    // 场景 REQ-003-S02/REQ-005-S01/REQ-006-S03（ST038-TC005 边界否定路径）：账户开立行无启用配置且机构信息表查无上级机构记录
    // （上级机构集合为空），遍历空集合结束，返回 limitSceneNo 为空
    @Test
    void testST038T05() {
        RbBusClientAcctEO acctRecord = buildAcctRecord(TranBranch.VALUE_351001);
        when(rbBusClientAcctBcc.findByEo(argThat(eo -> "6221000000000056789".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acctRecord));

        when(rbLimitCtrlConfBcc.findByEo(argThat(eo -> eo.getLimitBranchId() == TranBranch.VALUE_351001
                && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(Collections.emptyList());

        when(fmBranchBcc.findByEo(argThat(eo -> eo.getBranch() == TranBranch.VALUE_351001)))
                .thenReturn(Collections.emptyList());

        ST038InputBO input = new ST038InputBO();
        input.setBaseAcctNo("6221000000000056789");

        ST038OutputBO output = st038Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
    }

    /**
     * 构造账户信息查询命中记录，开立行为指定机构。
     */
    private RbBusClientAcctEO buildAcctRecord(TranBranch acctBranch) {
        RbBusClientAcctEO record = new RbBusClientAcctEO();
        record.setAcctBranch(acctBranch);
        return record;
    }

    /**
     * 构造限额控制配置查询命中记录，启用标志按需求原文字面量"Y-启用"。
     */
    private RbLimitCtrlConfEO buildLimitCtrlConfRecord(TranBranch limitBranchId, String limitSceneNo, LimitBranchRange limitBranchRange) {
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitBranchId(limitBranchId);
        record.setLimitSceneNo(limitSceneNo);
        record.setLimitBranchRange(limitBranchRange);
        record.setValidFlag("Y-启用");
        return record;
    }

    /**
     * 构造机构信息表记录（上级机构集合元素）。
     */
    private FmBranchEO buildFmBranchRecord(TranBranch branch, TranBranch attachedTo) {
        FmBranchEO record = new FmBranchEO();
        record.setBranch(branch);
        record.setAttachedTo(attachedTo);
        return record;
    }
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;

/**
 * ST049 检查转账止收限制 单元测试。
 *
 * <p>覆盖 Spec REQ-001-S01、REQ-002-S01 与 REQ-003-S01、REQ-004-S01~S03；判定结果「是/否」的直接断言受 TBD-6
 * 输出载体未定限制，以判定输入数据（drCrCtlFlag、transferFlag）与可观察输出验证。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST049PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST049Pbc st049Pbc;

    /** 构造 ST049InputBO，仅设置必填账号 baseAcctNo="6222020000012345678"（Spec REQ-001-S01 示例值）。 */
    private ST049InputBO buildInput() {
        ST049InputBO input = new ST049InputBO();
        input.setBaseAcctNo("6222020000012345678");
        return input;
    }

    /** 构造对公存款账户限制表单条记录：resSeqNo="R202610310001"、restraintType=VALUE_54、restraintsStatus=A。 */
    private RbBusRestraintsEO buildRestraint() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setResSeqNo("R202610310001");
        restraint.setRestraintType(RestraintType.VALUE_54);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        return restraint;
    }

    /** 构造存款限制类型表单条记录：restraintType=VALUE_54、status=A、指定借贷方控制标志与转账标志、stopFlag="Y"。 */
    private RbRestraintTypeEO buildType(DrCrCtlFlag drCrCtlFlag, String transferFlag) {
        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_54);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(drCrCtlFlag);
        type.setTransferFlag(transferFlag);
        type.setStopFlag("Y");
        return type;
    }

    // ST049-TC001 主成功路径：按账号与限制状态 A 查得账户限制信息，再按账户限制类型与状态 A 查得限制类型信息，
    // 借贷方控制标志 C 且转账标志 N → 转账止收标志「是」，本步骤正常完成（REQ-001-S01、REQ-002-S01、REQ-003-S01）
    @Test
    void testST049T01() {
        RbBusRestraintsEO restraint = buildRestraint();
        RbRestraintTypeEO type = buildType(DrCrCtlFlag.C, "N");
        AtomicReference<RbBusRestraintsEO> capturedRestraintQuery = new AtomicReference<>();
        AtomicReference<RbRestraintTypeEO> capturedTypeQuery = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedRestraintQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(restraint);
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByEo(Mockito.any(RbRestraintTypeEO.class)))
                .thenAnswer(invocation -> {
                    capturedTypeQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(type);
                });

        ST049OutputBO out = st049Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        // 输出 BO 各业务字段与桩返回一致
        assertEquals("R202610310001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_54, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("N", out.getTransferFlag());
        assertEquals("Y", out.getStopFlag());
        // 捕获查询 EO 验证账户限制查询条件：baseAcctNo 与 restraintsStatus=A
        assertEquals("6222020000012345678", capturedRestraintQuery.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedRestraintQuery.get().getRestraintsStatus());
        // 捕获查询 EO 验证限制类型查询条件：restraintType 与 status=A
        assertEquals(RestraintType.VALUE_54, capturedTypeQuery.get().getRestraintType());
        assertEquals(Status.A, capturedTypeQuery.get().getStatus());
        // 判定结果「是」的直接断言受 TBD-6 载体未定限制，以判定输入数据（drCrCtlFlag=C、transferFlag=N）验证
    }

    // ST049-TC002 借贷方控制标志 C 但转账标志为不等于 "N" 的示例值 "Y" → 转账止收标志「否」，本步骤正常完成（REQ-004-S01）
    @Test
    void testST049T02() {
        RbBusRestraintsEO restraint = buildRestraint();
        RbRestraintTypeEO type = buildType(DrCrCtlFlag.C, "Y");
        AtomicReference<RbBusRestraintsEO> capturedRestraintQuery = new AtomicReference<>();
        AtomicReference<RbRestraintTypeEO> capturedTypeQuery = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedRestraintQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(restraint);
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByEo(Mockito.any(RbRestraintTypeEO.class)))
                .thenAnswer(invocation -> {
                    capturedTypeQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(type);
                });

        ST049OutputBO out = st049Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        // 输出 BO 各业务字段与桩返回一致
        assertEquals("R202610310001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_54, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("Y", out.getTransferFlag());
        assertEquals("Y", out.getStopFlag());
        // 捕获查询 EO 验证账户限制查询条件：baseAcctNo 与 restraintsStatus=A
        assertEquals("6222020000012345678", capturedRestraintQuery.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedRestraintQuery.get().getRestraintsStatus());
        // 捕获查询 EO 验证限制类型查询条件：restraintType 与 status=A
        assertEquals(RestraintType.VALUE_54, capturedTypeQuery.get().getRestraintType());
        assertEquals(Status.A, capturedTypeQuery.get().getStatus());
        // 判定结果「否」的直接断言受 TBD-6 载体未定限制，以判定输入数据（drCrCtlFlag=C、transferFlag=Y）验证
    }

    // ST049-TC003 借贷方控制标志 A（非禁止贷方）且转账标志 "N" → 转账止收标志「否」，本步骤正常完成（REQ-004-S02）
    @Test
    void testST049T03() {
        RbBusRestraintsEO restraint = buildRestraint();
        RbRestraintTypeEO type = buildType(DrCrCtlFlag.A, "N");
        AtomicReference<RbBusRestraintsEO> capturedRestraintQuery = new AtomicReference<>();
        AtomicReference<RbRestraintTypeEO> capturedTypeQuery = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedRestraintQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(restraint);
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByEo(Mockito.any(RbRestraintTypeEO.class)))
                .thenAnswer(invocation -> {
                    capturedTypeQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(type);
                });

        ST049OutputBO out = st049Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        // 输出 BO 各业务字段与桩返回一致
        assertEquals("R202610310001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_54, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("N", out.getTransferFlag());
        assertEquals("Y", out.getStopFlag());
        // 捕获查询 EO 验证账户限制查询条件：baseAcctNo 与 restraintsStatus=A
        assertEquals("6222020000012345678", capturedRestraintQuery.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedRestraintQuery.get().getRestraintsStatus());
        // 捕获查询 EO 验证限制类型查询条件：restraintType 与 status=A
        assertEquals(RestraintType.VALUE_54, capturedTypeQuery.get().getRestraintType());
        assertEquals(Status.A, capturedTypeQuery.get().getStatus());
        // 判定结果「否」的直接断言受 TBD-6 载体未定限制，以判定输入数据（drCrCtlFlag=A、transferFlag=N）验证
    }

    // ST049-TC004 借贷方控制标志 A（非禁止贷方）且转账标志为不等于 "N" 的示例值 "Y" → 转账止收标志「否」，本步骤正常完成（REQ-004-S03）
    @Test
    void testST049T04() {
        RbBusRestraintsEO restraint = buildRestraint();
        RbRestraintTypeEO type = buildType(DrCrCtlFlag.A, "Y");
        AtomicReference<RbBusRestraintsEO> capturedRestraintQuery = new AtomicReference<>();
        AtomicReference<RbRestraintTypeEO> capturedTypeQuery = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedRestraintQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(restraint);
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByEo(Mockito.any(RbRestraintTypeEO.class)))
                .thenAnswer(invocation -> {
                    capturedTypeQuery.set(invocation.getArgument(0));
                    return Collections.singletonList(type);
                });

        ST049OutputBO out = st049Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        // 输出 BO 各业务字段与桩返回一致
        assertEquals("R202610310001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_54, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("Y", out.getTransferFlag());
        assertEquals("Y", out.getStopFlag());
        // 捕获查询 EO 验证账户限制查询条件：baseAcctNo 与 restraintsStatus=A
        assertEquals("6222020000012345678", capturedRestraintQuery.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedRestraintQuery.get().getRestraintsStatus());
        // 捕获查询 EO 验证限制类型查询条件：restraintType 与 status=A
        assertEquals(RestraintType.VALUE_54, capturedTypeQuery.get().getRestraintType());
        assertEquals(Status.A, capturedTypeQuery.get().getStatus());
        // 判定结果「否」的直接断言受 TBD-6 载体未定限制，以判定输入数据（drCrCtlFlag=A、transferFlag=Y）验证
    }
}

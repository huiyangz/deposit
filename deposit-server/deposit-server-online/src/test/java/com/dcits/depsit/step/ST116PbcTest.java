package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.List;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST116InputBO;
import com.dcits.depsit.facade.bo.ST116OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST116 检查是否存在转账止付限制的单元测试。
 *
 * <p>调用签名：{@code ST116OutputBO execute(ST116InputBO input)}。
 * 步骤 1 按账号 + 限制状态码值 {@code "A"} 查【账户限制信息】，步骤 2 按账户限制类型取状态为
 * {@code "A"} 的【限制类型表】配置，步骤 3 以借贷方控制标志 {@code "D"} 与转账标志 {@code "N"}
 * 的合取判定；结论 {@code transferStopPayFlag} 取中文字面值「是」/「否」。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST116PbcTest {

    /** 用例统一使用的账号 */
    private static final String ACCT_NO = "6222020200112233";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST116Pbc step;

    // ST116-TC001：REQ-001-S01、REQ-003-S01、REQ-005-S01、REQ-006-S01、REQ-007-S02
    // 单条 A-生效 限制，其类型命中 A-生效 配置（D + N），返回「是」并回显命中条与配置值
    @Test
    void testST116T01() {
        RbBusRestraintsEO r1 = restraints(RestraintType.SF2, "R202610100001");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.getTransferStopPayFlag());
        assertEquals("R202610100001", output.getResSeqNo());
        assertSame(RestraintType.SF2, output.getRestraintType());
        assertSame(RestraintsStatus.A, output.getRestraintsStatus());
        assertSame(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertSame(Status.A, output.getStatus());
        assertEquals("N", output.getTransferFlag());
    }

    // ST116-TC002：REQ-006-S01 取回 2 条记录，第 1 条即满足条件，返回「是」并回显第 1 条后立即结束；
    // 第 2 条亦满足时回显仍为第 1 条（以回显值区分「命中首条即结束」与「取到最后一条」）
    @Test
    void testST116T02() {
        RbBusRestraintsEO r1 = restraints(RestraintType.SF2, "R202610100001");
        RbBusRestraintsEO r2 = restraints(RestraintType.VALUE_13, "R202610100002");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1, r2));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "N"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("是", output.getTransferStopPayFlag());
        assertEquals("R202610100001", output.getResSeqNo());
        assertSame(RestraintType.SF2, output.getRestraintType());
        assertSame(RestraintsStatus.A, output.getRestraintsStatus());
        assertSame(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertSame(Status.A, output.getStatus());
        assertEquals("N", output.getTransferFlag());
    }

    // ST116-TC003：REQ-001-S02、REQ-004-S01、REQ-005-S02、REQ-006-S02、REQ-007-S02
    // 3 条记录中第 1 条类型无配置、第 2 条转账标志非 N 均不满足，第 3 条命中并回显第 3 条
    @Test
    void testST116T03() {
        RbBusRestraintsEO r1 = restraints(RestraintType.VALUE_21, "R202610100001");
        RbBusRestraintsEO r2 = restraints(RestraintType.VALUE_13, "R202610100002");
        RbBusRestraintsEO r3 = restraints(RestraintType.SF2, "R202610100003");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1, r2, r3));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_21)).thenReturn(null);
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D, "Y"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("是", output.getTransferStopPayFlag());
        assertEquals("R202610100003", output.getResSeqNo());
        assertSame(RestraintType.SF2, output.getRestraintType());
        assertSame(RestraintsStatus.A, output.getRestraintsStatus());
        assertSame(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertEquals("N", output.getTransferFlag());
    }

    // ST116-TC004：REQ-005-S02、REQ-006-S03 唯一一条限制的配置为 D + "Y"，合取条件不成立，返回「否」
    @Test
    void testST116T04() {
        RbBusRestraintsEO r1 = restraints(RestraintType.SF2, "R202610100001");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "Y"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getTransferStopPayFlag());
    }

    // ST116-TC005：REQ-005-S03、REQ-006-S03 两条配置借贷方控制标志分别为 C 与 A（均非 D）而转账标志均为 N，
    // 单条件成立不构成命中，返回「否」
    @Test
    void testST116T05() {
        RbBusRestraintsEO r1 = restraints(RestraintType.SF2, "R202610100001");
        RbBusRestraintsEO r2 = restraints(RestraintType.VALUE_13, "R202610100002");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1, r2));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.C, "N"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.A, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("否", output.getTransferStopPayFlag());
    }

    // ST116-TC006：REQ-002-S01、REQ-007-S01 按账号 + 限制状态 A 未查询到任何记录，直接返回「否」并结束，
    // 其余 6 个输出字段为空值
    @Test
    void testST116T06() {
        // 以请求字段为键设桩：本用例该账号无任何限制信息记录，任何取数条件的查询结果均为空集合
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of());

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("否", output.getTransferStopPayFlag());
        assertNull(output.getResSeqNo());
        assertNull(output.getRestraintType());
        assertNull(output.getRestraintsStatus());
        assertNull(output.getDrCrCtlFlag());
        assertNull(output.getStatus());
        assertNull(output.getTransferFlag());
    }

    // ST116-TC007：REQ-001-S02、REQ-002-S02、REQ-007-S01 账号仅存在限制状态为 E 的记录，
    // 按限制状态 A 的取数条件视为未查询到记录，返回「否」且其余输出字段为空值
    @Test
    void testST116T07() {
        RbBusRestraintsEO rE = new RbBusRestraintsEO();
        rE.setBaseAcctNo(ACCT_NO);
        rE.setRestraintsStatus(RestraintsStatus.E);
        rE.setRestraintType(RestraintType.SF2);
        rE.setResSeqNo("R202610100004");
        // 以请求字段（账号 + 限制状态）为键设桩：按限制状态 A 收窄取数时命中空结果；
        // 未按 A 收窄（或漏设限制状态）则取回 E 记录，下述「否」的断言即失败
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            RbBusRestraintsEO query = invocation.getArgument(0);
            if (ACCT_NO.equals(query.getBaseAcctNo()) && RestraintsStatus.A.equals(query.getRestraintsStatus())) {
                return List.<RbBusRestraintsEO>of();
            }
            return List.of(rE);
        });
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("否", output.getTransferStopPayFlag());
        assertNull(output.getResSeqNo());
        assertNull(output.getRestraintType());
        assertNull(output.getRestraintsStatus());
        assertNull(output.getDrCrCtlFlag());
        assertNull(output.getStatus());
        assertNull(output.getTransferFlag());
    }

    // ST116-TC008：REQ-003-S02、REQ-004-S01、REQ-004-S02、REQ-005-S01、REQ-006-S02、REQ-007-S02
    // 第 1 条类型存在配置但状态为 F（非 A-生效），不构成转账止付限制且不提前返回「否」；
    // 继续判断第 2 条并命中，返回「是」并回显第 2 条
    @Test
    void testST116T08() {
        RbBusRestraintsEO r1 = restraints(RestraintType.VALUE_21, "R202610100001");
        RbBusRestraintsEO r2 = restraints(RestraintType.SF2, "R202610100002");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1, r2));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_21))
                .thenReturn(config(RestraintType.VALUE_21, Status.F, DrCrCtlFlag.D, "N"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertEquals("是", output.getTransferStopPayFlag());
        assertEquals("R202610100002", output.getResSeqNo());
        assertSame(RestraintType.SF2, output.getRestraintType());
        assertSame(RestraintsStatus.A, output.getRestraintsStatus());
        assertSame(Status.A, output.getStatus());
        assertEquals("N", output.getTransferFlag());
    }

    // ST116-TC009：REQ-004、REQ-005-S02、REQ-005-S03、REQ-006-S03、REQ-007-S01
    // 3 条限制逐条判断后全部不满足（借贷方控制标志非 D、转账标志非 N、无 A-生效 配置各一条），返回「否」
    @Test
    void testST116T09() {
        RbBusRestraintsEO r1 = restraints(RestraintType.SF2, "R202610100001");
        RbBusRestraintsEO r2 = restraints(RestraintType.VALUE_13, "R202610100002");
        RbBusRestraintsEO r3 = restraints(RestraintType.VALUE_21, "R202610100003");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> ACCT_NO.equals(eo.getBaseAcctNo())
                && RestraintsStatus.A.equals(eo.getRestraintsStatus())))).thenReturn(List.of(r1, r2, r3));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.C, "N"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.D, "Y"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_21))
                .thenReturn(config(RestraintType.VALUE_21, Status.F, DrCrCtlFlag.D, "N"));

        ST116OutputBO output = step.execute(input(ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getTransferStopPayFlag());
    }

    /** 构造步骤入参。 */
    private static ST116InputBO input(String baseAcctNo) {
        ST116InputBO input = new ST116InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    /** 构造一条限制状态为 A-生效 的账户限制信息。 */
    private static RbBusRestraintsEO restraints(RestraintType restraintType, String resSeqNo) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(restraintType);
        eo.setResSeqNo(resSeqNo);
        return eo;
    }

    /** 构造一条限制类型配置。 */
    private static RbRestraintTypeEO config(RestraintType restraintType, Status status,
            DrCrCtlFlag drCrCtlFlag, String transferFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setTransferFlag(transferFlag);
        return eo;
    }
}

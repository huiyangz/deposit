package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST120InputBO;
import com.dcits.depsit.facade.bo.ST120OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST120 检查是否存在转账不收不付限制的单元测试。
 *
 * <p>调用签名：{@code ST120OutputBO execute(ST120InputBO input)}；被测实例
 * {@link ST120Pbc} 以两个 BCC mock 按构造注入后真实执行 {@code execute}。</p>
 *
 * <p>结论字段 {@code acctTranNoRecvNoPayFlag} 取中文字面值「是」/「否」；结论为「否」的各用例
 * 不断言回显字段取值（Spec「验收范围与明确不覆盖的事项」第 3 项未规定），
 * {@code stopFlag}（止付标志）为放行事项，不设桩、不断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST120PbcTest {

    /** 用例入参账号。 */
    private static final String BASE_ACCT_NO = "6222020000000001";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST120Pbc st120Pbc;

    // ST120-TC001：REQ-001-S01 账号下无生效限制记录（返回 0 条），直接得出「否」，不查询【限制类型表】
    @Test
    void testST120T01() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(Collections.emptyList());

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
        // 步骤 1 的查询条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST120-TC002：REQ-001-S02 + REQ-002-S01 + REQ-003-S01 + REQ-004-S01 唯一一条生效限制记录命中，回显该条记录与配置字段
    @Test
    void testST120T02() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of(restraints(RestraintType.DX2, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.A, DrCrCtlFlag.A, "N"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getAcctTranNoRecvNoPayFlag());
        assertEquals("R0001", result.getResSeqNo());
        assertEquals(RestraintType.DX2, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getTransferFlag());
        // 步骤 1 的查询条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST120-TC003：REQ-004-S02 两条记录中仅第 2 条命中（第 1 条转账标志非 "N" 不构成），回显命中的第 2 条
    @Test
    void testST120T03() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.DX2, "R0001"),
                        restraints(RestraintType.SK1, "R0002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.A, DrCrCtlFlag.A, "Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.A, DrCrCtlFlag.A, "N"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getAcctTranNoRecvNoPayFlag());
        assertEquals("R0002", result.getResSeqNo());
        assertEquals(RestraintType.SK1, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getTransferFlag());
    }

    // ST120-TC004：REQ-003-S03 + REQ-003-S04 + REQ-004-S03 两条记录全部不构成（借贷方控制标志非 "A" / 转账标志非 "N"），返回「否」
    @Test
    void testST120T04() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.DX2, "R0001"),
                        restraints(RestraintType.SK1, "R0002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.A, DrCrCtlFlag.C, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.A, DrCrCtlFlag.A, "Y"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    // ST120-TC005：REQ-002-S02 + REQ-002-S03 + REQ-004-S04 前两条不构成（无配置记录 / 配置状态非 "A"），第 3 条命中
    @Test
    void testST120T05() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.YC1, "R0001"),
                        restraints(RestraintType.DX2, "R0002"),
                        restraints(RestraintType.SK1, "R0003")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC1))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.F, DrCrCtlFlag.A, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SK1))
                .thenReturn(config(RestraintType.SK1, Status.A, DrCrCtlFlag.A, "N"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getAcctTranNoRecvNoPayFlag());
        assertEquals("R0003", result.getResSeqNo());
        assertEquals(RestraintType.SK1, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getTransferFlag());
    }

    // ST120-TC006：REQ-003-S02 借贷方控制标志为 "A" 但转账标志非 "N"，构成条件不成立，返回「否」
    @Test
    void testST120T06() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.DX2, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.A, DrCrCtlFlag.A, "Y"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    // ST120-TC007：REQ-003-S03 转账标志为 "N" 但借贷方控制标志非 "A"（"C"），构成条件不成立，返回「否」
    @Test
    void testST120T07() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.SF2, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.SF2))
                .thenReturn(config(RestraintType.SF2, Status.A, DrCrCtlFlag.C, "N"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    // ST120-TC008：REQ-003-S04 借贷方控制标志（"D"）与转账标志（非 "N"）均不满足，返回「否」
    @Test
    void testST120T08() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.EMR, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.EMR))
                .thenReturn(config(RestraintType.EMR, Status.A, DrCrCtlFlag.D, "Y"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    // ST120-TC009：REQ-002-S03 限制类型存在配置但状态非生效（"F"），该条不构成，返回「否」
    @Test
    void testST120T09() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.DX2, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.DX2))
                .thenReturn(config(RestraintType.DX2, Status.F, DrCrCtlFlag.A, "N"));

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    // ST120-TC010：REQ-002-S02 限制类型查不到配置记录（返回 null），该条不构成，返回「否」
    @Test
    void testST120T10() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.YC2, "R0001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.YC2))
                .thenReturn(null);

        ST120OutputBO result = st120Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getAcctTranNoRecvNoPayFlag());
    }

    private static ST120InputBO input(String baseAcctNo) {
        ST120InputBO input = new ST120InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private static RbBusRestraintsEO restraints(RestraintType restraintType, String resSeqNo) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo(BASE_ACCT_NO);
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(restraintType);
        eo.setResSeqNo(resSeqNo);
        return eo;
    }

    private static RbRestraintTypeEO config(
            RestraintType restraintType, Status status, DrCrCtlFlag drCrCtlFlag, String transferFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setTransferFlag(transferFlag);
        return eo;
    }
}

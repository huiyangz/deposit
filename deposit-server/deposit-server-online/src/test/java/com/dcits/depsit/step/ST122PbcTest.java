package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST122InputBO;
import com.dcits.depsit.facade.bo.ST122OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST122 检查是否存在不收不付限制的单元测试。
 *
 * <p>调用签名：{@code ST122OutputBO execute(ST122InputBO input)}；依据正式 Spec 的
 * REQ-001～REQ-004 与 8 个用例（测试用例 ST122-TC001～TC008）构造输入、桩返回与期望值。
 * 桩统一使用 {@code Mockito.lenient()}，与同仓库既有步骤测试口径一致。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST122PbcTest {

    /** 用例统一的账号取值。 */
    private static final String ACCT_NO = "6217000012345678";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST122Pbc pbc;

    /** 捕获 findByEo 的入参 EO，用于核对查询条件。 */
    private RbBusRestraintsEO capturedQueryEo;

    // ST122-TC001：单条生效限制记录的 A-生效 配置为 A-禁止借贷方，判定构成不收不付并回显该条记录
    @Test
    void testST122T01() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Collections.singletonList(
                            restraint("RES20261009001", RestraintType.VALUE_17));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(Status.A, DrCrCtlFlag.A));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNoRecvNoPayFlag());
        assertEquals("RES20261009001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals(ACCT_NO, capturedQueryEo.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedQueryEo.getRestraintsStatus());
    }

    // ST122-TC002：两条生效记录，首条 D-禁止借方不满足且不提前返回，末条 A-禁止借贷方满足，回显命中的末条
    @Test
    void testST122T02() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Arrays.asList(
                            restraint("RES20261009001", RestraintType.VALUE_6),
                            restraint("RES20261009002", RestraintType.VALUE_17));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(config(Status.A, DrCrCtlFlag.D));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(Status.A, DrCrCtlFlag.A));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNoRecvNoPayFlag());
        assertEquals("RES20261009002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST122-TC003：两条生效记录的控制标志分别为 D-禁止借方、C-禁止贷方，全部不满足，聚合为"否"且三字段为空值
    @Test
    void testST122T03() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Arrays.asList(
                            restraint("RES20261009001", RestraintType.VALUE_6),
                            restraint("RES20261009002", RestraintType.VALUE_7));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(config(Status.A, DrCrCtlFlag.D));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_7))
                .thenReturn(config(Status.A, DrCrCtlFlag.C));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST122-TC004：账号下无状态为 A 的生效限制记录（0 条），直接返回"否"且三字段为空值，不触达限制类型表
    @Test
    void testST122T04() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Collections.emptyList();
                });

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertEquals(ACCT_NO, capturedQueryEo.getBaseAcctNo());
        assertEquals(RestraintsStatus.A, capturedQueryEo.getRestraintsStatus());
    }

    // ST122-TC005：首条限制类型在【限制类型表】无记录，该条不构成且不结束判定；末条配置为 A 命中
    @Test
    void testST122T05() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Arrays.asList(
                            restraint("RES20261009011", RestraintType.VALUE_17),
                            restraint("RES20261009012", RestraintType.VALUE_6));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(config(Status.A, DrCrCtlFlag.A));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNoRecvNoPayFlag());
        assertEquals("RES20261009012", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_6, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST122-TC006：首条配置 status=F 非 A-生效，其 A 控制标志被弃用；末条配置 status=A、drCrCtlFlag=A 命中
    @Test
    void testST122T06() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Arrays.asList(
                            restraint("RES20261009021", RestraintType.VALUE_17),
                            restraint("RES20261009022", RestraintType.VALUE_6));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(Status.F, DrCrCtlFlag.A));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(config(Status.A, DrCrCtlFlag.A));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNoRecvNoPayFlag());
        assertEquals("RES20261009022", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_6, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // ST122-TC007：单条生效记录的限制类型无 A-生效 配置，该条不构成，全部不满足返回"否"且三字段为空值
    @Test
    void testST122T07() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Collections.singletonList(
                            restraint("RES20261009031", RestraintType.VALUE_17));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(null);

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST122-TC008：首条（VALUE_17 配置 A）即命中，末条（VALUE_6 配置 D）不满足，聚合回显命中的首条记录
    @Test
    void testST122T08() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    capturedQueryEo = invocation.getArgument(0);
                    return Arrays.asList(
                            restraint("RES20261009041", RestraintType.VALUE_17),
                            restraint("RES20261009042", RestraintType.VALUE_6));
                });
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(Status.A, DrCrCtlFlag.A));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(config(Status.A, DrCrCtlFlag.D));

        ST122OutputBO result = pbc.execute(input(ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getNoRecvNoPayFlag());
        assertEquals("RES20261009041", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    /** 构造输入 BO：仅含账号一个字段。 */
    private static ST122InputBO input(String baseAcctNo) {
        ST122InputBO input = new ST122InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    /** 构造【账户限制信息】查询结果记录：状态为 A-生效。 */
    private static RbBusRestraintsEO restraint(String resSeqNo, RestraintType restraintType) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setBaseAcctNo(ACCT_NO);
        return eo;
    }

    /** 构造【限制类型表】配置记录。 */
    private static RbRestraintTypeEO config(Status status, DrCrCtlFlag drCrCtlFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        return eo;
    }
}

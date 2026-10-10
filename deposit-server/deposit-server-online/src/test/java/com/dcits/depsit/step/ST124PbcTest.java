package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST124InputBO;
import com.dcits.depsit.facade.bo.ST124OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST124 检查是否存在现金不收不付限制的单元测试。
 *
 * <p>调用签名：{@code ST124OutputBO execute(ST124InputBO input)}；被测实例
 * {@link ST124Pbc} 以两个 BCC mock 按构造注入后真实执行 {@code execute}。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST124PbcTest {

    /** 用例入参账号。 */
    private static final String BASE_ACCT_NO = "6222020200112233";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST124Pbc st124Pbc;

    // ST124-TC001：REQ-001-S01 + REQ-002-S01 + REQ-003-S01 + REQ-005-S01 单条生效限制命中，返回「是」并输出七个字段
    @Test
    void testST124T01() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of(restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals("R202610100002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_62, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getCashFlag());
        // 步骤 1 的查询条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST124-TC002：REQ-001-S02 + REQ-004-S01 三条生效限制逐条判断，末条命中，回显该条三字段
    @Test
    void testST124T02() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_17, "R202610100003"),
                        restraints(RestraintType.VALUE_4, "R202610100004"),
                        restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.C, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.A, "Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals("R202610100002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_62, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST124-TC003：REQ-004-S01 第 1 条不满足、第 2 条满足，回显值取自命中的第 2 条记录
    @Test
    void testST124T03() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_4, "R202610100001"),
                        restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.A, "Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals("R202610100002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_62, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getCashFlag());
    }

    // ST124-TC004：REQ-002-S01 步骤 2 以该条记录自身的账户限制类型为键查询【限制类型表】
    @Test
    void testST124T04() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_17, "R202610100005")));
        ArgumentCaptor<RestraintType> keyCaptor = ArgumentCaptor.forClass(RestraintType.class);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(keyCaptor.capture()))
                .thenReturn(config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals(RestraintType.VALUE_17, keyCaptor.getValue());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals("R202610100005", result.getResSeqNo());
    }

    // ST124-TC005：REQ-002-S02 第 1 条配置状态非 "A" 不构成限制，继续判断第 2 条并命中
    @Test
    void testST124T05() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_4, "R202610100004"),
                        restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(config(RestraintType.VALUE_4, Status.F, DrCrCtlFlag.A, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals("R202610100002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_62, result.getRestraintType());
    }

    // ST124-TC006：REQ-002 某条在【限制类型表】无对应记录（返回 null），继续判断第 2 条并命中
    @Test
    void testST124T06() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_95, "R202610100006"),
                        restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_95))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getCashNoRecvNoPayFlag());
        assertEquals("R202610100002", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_62, result.getRestraintType());
    }

    // ST124-TC007：REQ-003-S02 + REQ-004-S02 现金标志非 "N" 合取不成立，返回「否」且三字段空值
    @Test
    void testST124T07() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "Y"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST124-TC008：REQ-003-S03 + REQ-004-S02 借贷方控制标志非 "A" 合取不成立，返回「否」且三字段空值
    @Test
    void testST124T08() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.D, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("否", result.getCashNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST124-TC009：REQ-004-S02 + REQ-005-S03 三条均不满足，返回「否」且三字段空值（另三字段不作断言）
    @Test
    void testST124T09() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_17, "R202610100003"),
                        restraints(RestraintType.VALUE_4, "R202610100004"),
                        restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.D, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.A, "Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.F, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST124-TC010：REQ-001-S03 + REQ-005-S02 零条生效限制直接返回「否」，六个回显/配置字段无取值
    @Test
    void testST124T10() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of());

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getStatus());
        assertNull(result.getCashFlag());
        // 步骤 1 的查询条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST124-TC011：REQ-004-S02 + REQ-002-S02 两条类型均无 A-生效 配置，返回「否」且三字段空值
    @Test
    void testST124T11() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_62, "R202610100002"),
                        restraints(RestraintType.VALUE_17, "R202610100003")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.F, DrCrCtlFlag.A, "N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_17))
                .thenReturn(config(RestraintType.VALUE_17, Status.F, DrCrCtlFlag.A, "N"));

        ST124OutputBO result = st124Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("否", result.getCashNoRecvNoPayFlag());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST124-TC012：REQ-005-S04 三条业务路径终点的结论均为非空的 java.lang.String 且取值为「是」或「否」
    @Test
    void testST124T12() {
        // (a) 零条生效限制：直接返回「否」
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of());
        ST124OutputBO notFound = st124Pbc.execute(input(BASE_ACCT_NO));
        assertTrue(notFound.isSucceed());
        assertNull(notFound.getErrorCode());
        assertNull(notFound.getErrorMessage());
        assertInstanceOf(String.class, notFound.getCashNoRecvNoPayFlag());
        assertFalse(notFound.getCashNoRecvNoPayFlag().isEmpty());
        assertEquals("否", notFound.getCashNoRecvNoPayFlag());

        // (b) 任一条命中：返回「是」
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "N"));
        ST124OutputBO hit = st124Pbc.execute(input(BASE_ACCT_NO));
        assertTrue(hit.isSucceed());
        assertNull(hit.getErrorCode());
        assertNull(hit.getErrorMessage());
        assertInstanceOf(String.class, hit.getCashNoRecvNoPayFlag());
        assertFalse(hit.getCashNoRecvNoPayFlag().isEmpty());
        assertEquals("是", hit.getCashNoRecvNoPayFlag());

        // (c) 取到配置但合取不成立：全部不满足，返回「否」
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_62, "R202610100002")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(config(RestraintType.VALUE_62, Status.A, DrCrCtlFlag.A, "Y"));
        ST124OutputBO notSatisfied = st124Pbc.execute(input(BASE_ACCT_NO));
        assertTrue(notSatisfied.isSucceed());
        assertNull(notSatisfied.getErrorCode());
        assertNull(notSatisfied.getErrorMessage());
        assertInstanceOf(String.class, notSatisfied.getCashNoRecvNoPayFlag());
        assertFalse(notSatisfied.getCashNoRecvNoPayFlag().isEmpty());
        assertEquals("否", notSatisfied.getCashNoRecvNoPayFlag());
    }

    private static ST124InputBO input(String baseAcctNo) {
        ST124InputBO input = new ST124InputBO();
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
            RestraintType restraintType, Status status, DrCrCtlFlag drCrCtlFlag, String cashFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setCashFlag(cashFlag);
        return eo;
    }
}

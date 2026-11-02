package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST062InputBO;
import com.dcits.deposit.facade.bo.ST062OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST062 检查是否存在现金止付限制 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001~REQ-004 与用例 ST062-TC001~TC007。本步骤无已声明业务失败路径，
 * 所有用例均为成功结果（succeed=true，errorCode/errorMessage 为 null）。
 * 多条记录时输出中间字段归属需求未定义（Spec 待确认事项 3），TC002/TC005/TC007 仅断言现金止付标志。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST062PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST062Pbc st062Pbc;

    /** ST062-TC001 正常路径：单条账户限制记录，配置为 D-禁止借方且 N-不允许现金，命中返回「是」并结束遍历（REQ-001-S01、REQ-002-S01、REQ-003-S01） */
    @Test
    void testST062T01() {
        RbBusRestraintsEO accountRestraint = buildBusRestraints(RestraintType.VALUE_6, "RST0000000001", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(accountRestraint));
        RbRestraintTypeEO config = buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.D, "N");
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(config));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getCashStopFlag());
        assertEquals(RestraintType.VALUE_6, result.getRestraintType());
        assertEquals("RST0000000001", result.getResSeqNo());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals("N", result.getCashFlag());
    }

    /** ST062-TC002 正常路径：两条限制记录，第一条配置 C-禁止贷方不命中，第二条 D-禁止借方且 N 命中，返回「是」（REQ-003-S02） */
    @Test
    void testST062T02() {
        RbBusRestraintsEO first = buildBusRestraints(RestraintType.VALUE_7, "RST0000000001", RestraintsStatus.A);
        RbBusRestraintsEO second = buildBusRestraints(RestraintType.VALUE_6, "RST0000000002", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Arrays.asList(first, second));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_7 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_7, Status.A, DrCrCtlFlag.C, "N")));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.D, "N")));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getCashStopFlag());
    }

    /** ST062-TC003 边界否定路径：单条记录配置为 C-禁止贷方、N-不允许现金，不满足命中条件，遍历结束返回「否」（REQ-004-S01） */
    @Test
    void testST062T03() {
        RbBusRestraintsEO accountRestraint = buildBusRestraints(RestraintType.VALUE_6, "RST0000000001", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(accountRestraint));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C, "N")));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashStopFlag());
        assertEquals(DrCrCtlFlag.C, result.getDrCrCtlFlag());
        assertEquals("N", result.getCashFlag());
    }

    /** ST062-TC004 边界否定路径：账户限制信息查询返回空集合，不执行限制类型配置查询，返回「否」（REQ-004-S02） */
    @Test
    void testST062T04() {
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.emptyList());

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashStopFlag());
    }

    /** ST062-TC005 边界否定路径：两条记录均不满足命中条件（C+N、A+非N），遍历完所有记录返回「否」（REQ-004-S03） */
    @Test
    void testST062T05() {
        RbBusRestraintsEO first = buildBusRestraints(RestraintType.VALUE_6, "RST0000000001", RestraintsStatus.A);
        RbBusRestraintsEO second = buildBusRestraints(RestraintType.VALUE_7, "RST0000000002", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Arrays.asList(first, second));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C, "N")));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_7 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_7, Status.A, DrCrCtlFlag.A, "Y")));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashStopFlag());
    }

    /** ST062-TC006 边界否定路径：单条记录配置为 D-禁止借方但现金标志不为 N（字面量 Y），不满足命中条件，返回「否」（REQ-004 现金标志否定分支） */
    @Test
    void testST062T06() {
        RbBusRestraintsEO accountRestraint = buildBusRestraints(RestraintType.VALUE_6, "RST0000000001", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(accountRestraint));
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.D, "Y")));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getCashStopFlag());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals("Y", result.getCashFlag());
    }

    /** ST062-TC007 边界否定路径：限制类型配置查询返回两条记录，按单条结果查询统一约定取结果集第一条（D+N）参与命中判定，返回「是」 */
    @Test
    void testST062T07() {
        RbBusRestraintsEO accountRestraint = buildBusRestraints(RestraintType.VALUE_6, "RST0000000001", RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> eo != null
                && "1101000012345678".equals(eo.getBaseAcctNo()) && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(accountRestraint));
        RbRestraintTypeEO firstConfig = buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.D, "N");
        RbRestraintTypeEO secondConfig = buildRestraintType(RestraintType.VALUE_6, Status.A, DrCrCtlFlag.C, "N");
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo != null
                && eo.getRestraintType() == RestraintType.VALUE_6 && eo.getStatus() == Status.A)))
                .thenReturn(Arrays.asList(firstConfig, secondConfig));

        ST062OutputBO result = st062Pbc.execute(buildInput("1101000012345678"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getCashStopFlag());
    }

    private ST062InputBO buildInput(String baseAcctNo) {
        ST062InputBO input = new ST062InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private RbBusRestraintsEO buildBusRestraints(RestraintType restraintType, String resSeqNo, RestraintsStatus restraintsStatus) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setRestraintType(restraintType);
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintsStatus(restraintsStatus);
        return eo;
    }

    private RbRestraintTypeEO buildRestraintType(RestraintType restraintType, Status status, DrCrCtlFlag drCrCtlFlag, String cashFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setCashFlag(cashFlag);
        return eo;
    }
}

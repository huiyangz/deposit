package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST114InputBO;
import com.dcits.depsit.facade.bo.ST114OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST114 检查转账止收限制 的单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST114-TC001 至 ST114-TC012，覆盖 Spec REQ-001 至 REQ-010 的
 * 已定义分支：0 条 / 1 条 / 多条生效记录、每条按自身账户限制类型取配置、限制类型无「A-生效」配置
 * （无记录 / 状态非 A）、判定条件「且」的四种组合、结果聚合与输出字段契约。</p>
 *
 * <p>本步骤无业务失败场景（REQ-010），失败仅由技术异常传播表达，故不生成失败码断言；
 * 多条记录时回显字段的绑定口径、REQ-003 结束路径下其余 6 字段取值、REQ-005 情形下 status 取值、
 * 输入为空等均为 Spec「明确不覆盖」事项，不作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST114PbcTest {

    /** 测试账号 */
    private static final String ACCT_NO = "6222021234567890123";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST114Pbc st114Pbc;

    /** 构造一条「A-生效」的账户限制记录 */
    private RbBusRestraintsEO restraint(String resSeqNo, RestraintType restraintType) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setResSeqNo(resSeqNo);
        eo.setBaseAcctNo(ACCT_NO);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(RestraintsStatus.A);
        return eo;
    }

    /** 构造【限制类型表】配置 */
    private RbRestraintTypeEO typeConfig(RestraintType restraintType, Status status, DrCrCtlFlag drCrCtlFlag,
            String transferFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setTransferFlag(transferFlag);
        return eo;
    }

    private ST114InputBO input() {
        ST114InputBO input = new ST114InputBO();
        input.setBaseAcctNo(ACCT_NO);
        return input;
    }

    // ST114-TC001：REQ-004-S01/REQ-006-S01/REQ-007-S03/REQ-008-S01/REQ-009-S02
    // 单条生效记录配置为禁止贷方且不允许转账，命中转账止收限制，并核对各输出字段取值路径
    @Test
    void testST114T01() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint("RES20261009000001", RestraintType.VALUE_68)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getStopCreditFlag());
        assertEquals("RES20261009000001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_68, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getTransferFlag());
    }

    // ST114-TC002：REQ-001-S01/REQ-001-S02/REQ-002-S01
    // 步骤 1 以账号为唯一入参、限制状态为步骤内固定常量「A」，请求 EO 不带入限制类型等其它条件
    @Test
    void testST114T02() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return List.of(restraint("RES20261009000001", RestraintType.VALUE_68));
        });
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertEquals(ACCT_NO, captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertNull(captured.get().getRestraintType());
        assertTrue(result.isSucceed());
        assertEquals("是", result.getStopCreditFlag());
    }

    // ST114-TC003：REQ-002-S02/REQ-004-S02
    // 两条记录各自按自身账户限制类型取配置，首条（13：C+N）命中，聚合为「是」
    @Test
    void testST114T03() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(
                restraint("RES20261009000001", RestraintType.VALUE_13),
                restraint("RES20261009000002", RestraintType.VALUE_69)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(typeConfig(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.C, "N"));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_69))
                .thenReturn(typeConfig(RestraintType.VALUE_69, Status.A, DrCrCtlFlag.C, "Y"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertEquals("是", result.getStopCreditFlag());
    }

    // ST114-TC004：REQ-007-S01
    // 前条不构成（13：C+Y）、后条构成（68：C+N），任一条命中即返回「是」
    @Test
    void testST114T04() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(
                restraint("RES20261009000001", RestraintType.VALUE_13),
                restraint("RES20261009000002", RestraintType.VALUE_68)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(typeConfig(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.C, "Y"));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertEquals("是", result.getStopCreditFlag());
    }

    // ST114-TC005：REQ-006-S02/REQ-006-S03/REQ-007-S02/REQ-008-S02
    // 三条记录全部不构成：转账标志非「N」（C+Y）与借贷方控制标志非「C」（D+N、A+N），最终返回「否」
    @Test
    void testST114T05() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(
                restraint("RES20261009000001", RestraintType.VALUE_13),
                restraint("RES20261009000002", RestraintType.VALUE_68),
                restraint("RES20261009000003", RestraintType.VALUE_69)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(typeConfig(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.C, "Y"));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.D, "N"));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_69))
                .thenReturn(typeConfig(RestraintType.VALUE_69, Status.A, DrCrCtlFlag.A, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("否", result.getStopCreditFlag());
    }

    // ST114-TC006：REQ-007-S04
    // 三条记录中间一条命中（68：C+N），最终为「是」；只断言最终结果，不约束是否短路与遍历顺序
    @Test
    void testST114T06() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(
                restraint("RES20261009000001", RestraintType.VALUE_13),
                restraint("RES20261009000002", RestraintType.VALUE_68),
                restraint("RES20261009000003", RestraintType.VALUE_69)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(typeConfig(RestraintType.VALUE_13, Status.A, DrCrCtlFlag.C, "Y"));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.C, "N"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_69))
                .thenReturn(typeConfig(RestraintType.VALUE_69, Status.A, DrCrCtlFlag.D, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertEquals("是", result.getStopCreditFlag());
    }

    // ST114-TC007：REQ-002-S03/REQ-003-S01/REQ-008-S02/REQ-010-S01
    // 账号无任何账户限制记录：取回 0 条，返回「否」并结束本步骤，不产生业务失败
    @Test
    void testST114T07() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(Collections.emptyList());

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getStopCreditFlag());
    }

    // ST114-TC008：REQ-003-S02/REQ-010-S01
    // 账号仅存在非生效状态记录：按生效记录 0 条处理（查询条件含「A」），返回「否」并结束
    @Test
    void testST114T08() {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return Collections.<RbBusRestraintsEO>emptyList();
        });

        ST114OutputBO result = st114Pbc.execute(input());

        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertTrue(result.isSucceed());
        assertEquals("否", result.getStopCreditFlag());
    }

    // ST114-TC009：REQ-005-S01/REQ-005-S03/REQ-006-S04
    // 首条类型在【限制类型表】无配置：两标志空值、视同不构成且不中止，后条（68：C+N）命中，返回「是」
    @Test
    void testST114T09() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenReturn(List.of(
                restraint("RES20261009000001", RestraintType.VALUE_13),
                restraint("RES20261009000002", RestraintType.VALUE_68)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(null);
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_68))
                .thenReturn(typeConfig(RestraintType.VALUE_68, Status.A, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("是", result.getStopCreditFlag());
    }

    // ST114-TC010：REQ-004-S03/REQ-009-S03
    // 类型表存在记录但状态为「F-无效」：配置不可用，两标志按空值处理（不取具值），该条不构成，返回「否」
    @Test
    void testST114T10() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint("RES20261009000001", RestraintType.VALUE_14)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_14))
                .thenReturn(typeConfig(RestraintType.VALUE_14, Status.F, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertEquals("否", result.getStopCreditFlag());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getTransferFlag());
    }

    // ST114-TC011：REQ-005-S02
    // 类型表存在记录但状态为「D-删除」且标志为 C/N：配置不可用，不判为「是」，返回「否」，两标志空值
    @Test
    void testST114T11() {
        when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint("RES20261009000001", RestraintType.VALUE_13)));
        when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(typeConfig(RestraintType.VALUE_13, Status.D, DrCrCtlFlag.C, "N"));

        ST114OutputBO result = st114Pbc.execute(input());

        assertTrue(result.isSucceed());
        assertEquals("否", result.getStopCreditFlag());
        assertNull(result.getDrCrCtlFlag());
        assertNull(result.getTransferFlag());
    }

    // ST114-TC012：REQ-001-S02/REQ-009-S01
    // 输入与输出字段契约：字段名、Java 类型与来源实体与 Spec「输入」「输出」表逐行一致
    @Test
    void testST114T12() throws Exception {
        Set<String> inputFields = Arrays.stream(ST114InputBO.class.getDeclaredFields())
                .map(Field::getName).collect(Collectors.toSet());
        assertEquals(Set.of("baseAcctNo"), inputFields);
        assertEquals(String.class, ST114InputBO.class.getDeclaredField("baseAcctNo").getType());

        Set<String> outputFields = Arrays.stream(ST114OutputBO.class.getDeclaredFields())
                .map(Field::getName).collect(Collectors.toSet());
        assertEquals(Set.of("resSeqNo", "restraintType", "restraintsStatus", "drCrCtlFlag", "status", "transferFlag",
                "stopCreditFlag"), outputFields);
        assertEquals(String.class, ST114OutputBO.class.getDeclaredField("resSeqNo").getType());
        assertEquals(RestraintType.class, ST114OutputBO.class.getDeclaredField("restraintType").getType());
        assertEquals(RestraintsStatus.class, ST114OutputBO.class.getDeclaredField("restraintsStatus").getType());
        assertEquals(DrCrCtlFlag.class, ST114OutputBO.class.getDeclaredField("drCrCtlFlag").getType());
        assertEquals(Status.class, ST114OutputBO.class.getDeclaredField("status").getType());
        assertEquals(String.class, ST114OutputBO.class.getDeclaredField("transferFlag").getType());
        assertEquals(String.class, ST114OutputBO.class.getDeclaredField("stopCreditFlag").getType());
    }
}

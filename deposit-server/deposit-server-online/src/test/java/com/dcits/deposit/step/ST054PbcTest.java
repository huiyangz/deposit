package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST054 检查是否存在现金止收限制 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01/S02、REQ-002-S01、REQ-003-S01/S02/S03、REQ-004-S01
 * 已确认场景（测试用例 ST054-TC001~TC004）。多条生效限制聚合（TBD-1）、现金止收标志输出字段
 * 去向（TBD-2）、步骤 2 查询无记录（TBD-5）、必填输入为空（TBD-6）及输出表同名字段区分（TBD-7）
 * 无已确认预期，不作为本套用例断言，见 {@link ST054Pbc} 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST054PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;
    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;
    @InjectMocks
    private ST054Pbc st054Pbc;

    @Captor
    private ArgumentCaptor<RbBusRestraintsEO> restraintQueryCaptor;
    @Captor
    private ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor;

    // 场景：REQ-001-S01/REQ-002-S01/REQ-003-S01/REQ-004-S01（ST054-TC001），账号存在限制状态=A-生效的账户限制信息，以账户限制类型=6查询到状态=A-生效的限制类型记录，借贷方控制标志=C且现金标志=N，命中现金止收限制（现金止收标志=是，物理输出字段去向见 TBD-2），按「输出」表输出两次查询字段
    @Test
    void testST054T01() {
        lenient().when(rbBusRestraintsBcc.findByEo(restraintQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(typeRecord(DrCrCtlFlag.C, "N")));

        ST054OutputBO output = st054Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("6222020000000000001", restraintQueryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, restraintQueryCaptor.getValue().getRestraintsStatus());
        assertEquals(RestraintType.VALUE_6, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("R10001", output.getResSeqNo());
        // 输出表两个来源的 restraintType 取值均为 RestraintType.VALUE_6，以单一字段断言（两同名字段区分见 TBD-7）
        assertEquals(RestraintType.VALUE_6, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(Status.A, output.getStatus());
        assertEquals(DrCrCtlFlag.C, output.getDrCrCtlFlag());
        assertEquals("N", output.getCashFlag());
        assertNull(output.getStopFlag());
    }

    // 场景：REQ-001-S02（ST054-TC002），账号在对公存款账户限制表无限制状态=A-生效的记录（或无任何记录），未取得账户限制信息，现金止收标志=否（落入"否则"分支，物理输出字段去向见 TBD-2），不执行限制类型表查询，本步骤正常提前结束，两来源输出字段均无记录可取
    @Test
    void testST054T02() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.emptyList());

        ST054OutputBO output = st054Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getResSeqNo());
        assertNull(output.getRestraintType());
        assertNull(output.getRestraintsStatus());
        assertNull(output.getStatus());
        assertNull(output.getDrCrCtlFlag());
        assertNull(output.getCashFlag());
        assertNull(output.getStopFlag());
    }

    // 场景：REQ-003-S02（ST054-TC003），限制类型记录存在且状态=A-生效，但借贷方控制标志=D（不等于C），现金止收限制判定不成立（现金止收标志=否，物理输出字段去向见 TBD-2），输出表字段按两记录取值
    @Test
    void testST054T03() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(typeRecord(DrCrCtlFlag.D, "N")));

        ST054OutputBO output = st054Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("R10001", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_6, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(Status.A, output.getStatus());
        assertEquals(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertEquals("N", output.getCashFlag());
        assertNull(output.getStopFlag());
    }

    // 场景：REQ-003-S03（ST054-TC004），限制类型记录存在且状态=A-生效，借贷方控制标志=C，但现金标志=Y（示例数据，不等于"N-不允许现金"），现金止收限制判定不成立（现金止收标志=否，物理输出字段去向见 TBD-2），输出表字段按两记录取值
    @Test
    void testST054T04() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(typeRecord(DrCrCtlFlag.C, "Y")));

        ST054OutputBO output = st054Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("R10001", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_6, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(Status.A, output.getStatus());
        assertEquals(DrCrCtlFlag.C, output.getDrCrCtlFlag());
        assertEquals("Y", output.getCashFlag());
        assertNull(output.getStopFlag());
    }

    private ST054InputBO inputWithBaseAcctNo() {
        ST054InputBO input = new ST054InputBO();
        input.setBaseAcctNo("6222020000000000001");
        return input;
    }

    private RbBusRestraintsEO restraintRecord() {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo("6222020000000000001");
        eo.setResSeqNo("R10001");
        eo.setRestraintType(RestraintType.VALUE_6);
        eo.setRestraintsStatus(RestraintsStatus.A);
        return eo;
    }

    private RbRestraintTypeEO typeRecord(DrCrCtlFlag drCrCtlFlag, String cashFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_6);
        eo.setStatus(Status.A);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setCashFlag(cashFlag);
        // stopFlag 取值域未定义，桩记录不设置（输出断言 stopFlag==null）
        return eo;
    }
}

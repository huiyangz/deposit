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

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST053InputBO;
import com.dcits.deposit.facade.bo.ST053OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST053 检查质押类限制 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01~REQ-004-S01 已确认场景（测试用例 ST053-TC001~TC004）。
 * 查询无记录（TBD-2）、必填输入为空（TBD-1）、多记录选取（TBD-3）、质押标志取值口径（TBD-4）
 * 及输出表同名字段区分（TBD-6）无已确认预期，不作为本套用例断言，见 {@link ST053Pbc} 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST053PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;
    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;
    @InjectMocks
    private ST053Pbc st053Pbc;

    @Captor
    private ArgumentCaptor<RbBusRestraintsEO> restraintQueryCaptor;
    @Captor
    private ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor;

    // 场景：REQ-001-S01（ST053-TC001），调用方提供必填输入 baseAcctNo，步骤以该账号作为步骤 1 查询【对公存款账户限制表】的账号条件，步骤 1、步骤 2 均取得记录并正常完成，pledgedFlag 为赋值并返回的业务结果
    @Test
    void testST053T01() {
        lenient().when(rbBusRestraintsBcc.findByEo(restraintQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(typeRecord()));

        ST053OutputBO output = st053Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("6222000000000000000", restraintQueryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, restraintQueryCaptor.getValue().getRestraintsStatus());
        assertEquals("Y", output.getPledgedFlag());
    }

    // 场景：REQ-002-S01（ST053-TC002），输入账号存在限制状态为 A-生效的生效限制记录，步骤 1 以「baseAcctNo 等于输入账号 且 restraintsStatus 等于 RestraintsStatus.A」查询，取得含账户限制类型 "12" 与限制编号的账户限制信息，步骤正常完成
    @Test
    void testST053T02() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(typeRecord()));

        ST053OutputBO output = st053Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("20261031000001", output.getResSeqNo());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(RestraintType.VALUE_12, output.getRestraintType());
        assertEquals("Y", output.getPledgedFlag());
    }

    // 场景：REQ-003-S01（ST053-TC003），步骤 1 取得的账户限制类型为 "12"，步骤 2 以「restraintType 等于 "12" 且 status 等于 Status.A」查询【存款限制类型表】，取得质押标志 "Y" 并赋值作为业务结果返回，步骤正常完成
    @Test
    void testST053T03() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(typeRecord()));

        ST053OutputBO output = st053Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RestraintType.VALUE_12, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("Y", output.getPledgedFlag());
        assertEquals(Status.A, output.getStatus());
    }

    // 场景：REQ-004-S01（ST053-TC004），步骤正常完成时输出字段的类型与来源符合需求「输出」表声明（resSeqNo、restraintType、restraintsStatus、restraintType、pledgedFlag、status），质押标志为赋值并返回的业务结果，其余声明字段按输出表对外提供（两同名 restraintType 字段区分方式待 TBD-6 确认，本用例两来源取值均为 RestraintType.VALUE_12）
    @Test
    void testST053T04() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(typeRecord()));

        ST053OutputBO output = st053Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("20261031000001", output.getResSeqNo());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals("Y", output.getPledgedFlag());
        assertEquals(Status.A, output.getStatus());
        assertEquals(RestraintType.VALUE_12, output.getRestraintType());
    }

    private ST053InputBO inputWithBaseAcctNo() {
        ST053InputBO input = new ST053InputBO();
        input.setBaseAcctNo("6222000000000000000");
        return input;
    }

    private RbBusRestraintsEO restraintRecord() {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo("6222000000000000000");
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(RestraintType.VALUE_12);
        eo.setResSeqNo("20261031000001");
        return eo;
    }

    private RbRestraintTypeEO typeRecord() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_12);
        eo.setStatus(Status.A);
        eo.setPledgedFlag("Y");
        return eo;
    }
}

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
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST050 检查有权机关冻结限制 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01 已确认场景（测试用例 ST050-TC001、ST050-TC002）。
 * 查询无记录（TBD-2）、必填输入为空（TBD-5）、多记录选取（TBD-1）及 ahBuFlag 取值编码
 * （TBD-4）无已确认预期，不作为本套用例断言，见 {@link ST050Pbc} 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST050PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;
    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;
    @InjectMocks
    private ST050Pbc st050Pbc;

    @Captor
    private ArgumentCaptor<RbBusRestraintsEO> restraintQueryCaptor;
    @Captor
    private ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor;

    // 场景：REQ-001-S01（ST050-TC001），步骤 1 以「baseAcctNo 等于输入账号 且 restraintsStatus 等于 RestraintsStatus.A」查询账户限制信息，取得含账户限制类型 SF2 与限制编号的账户限制信息（限制状态编码非 "A" 的记录不返回，由查询条件限制状态="A" 保证）；步骤 2 以该账户限制类型与 Status.A 查询限制类型表，取有权机关冻结标志 "Y" 赋值返回，步骤正常完成
    @Test
    void testST050T01() {
        lenient().when(rbBusRestraintsBcc.findByEo(restraintQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(restraintRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(typeRecord()));

        ST050OutputBO output = st050Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("6222020200000000001", restraintQueryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, restraintQueryCaptor.getValue().getRestraintsStatus());
        assertEquals(RestraintType.SF2, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("Y", output.getAhBuFlag());
    }

    // 场景：REQ-002-S01（ST050-TC002），步骤 1 取得的账户限制类型为「48小时紧急止付」（RestraintType.EMR），步骤 2 查询所用的账户限制类型来自步骤 1 查询结果（未写死 SF2），取该记录有权机关冻结标志 "N" 赋值返回，步骤正常完成
    @Test
    void testST050T02() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(restraintRecordEmr()));
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(Collections.singletonList(typeRecordEmr()));

        ST050OutputBO output = st050Pbc.execute(inputWithBaseAcctNo());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RestraintType.EMR, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("N", output.getAhBuFlag());
    }

    private ST050InputBO inputWithBaseAcctNo() {
        ST050InputBO input = new ST050InputBO();
        input.setBaseAcctNo("6222020200000000001");
        return input;
    }

    private RbBusRestraintsEO restraintRecord() {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo("6222020200000000001");
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(RestraintType.SF2);
        eo.setResSeqNo("R0000000001");
        return eo;
    }

    private RbRestraintTypeEO typeRecord() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.SF2);
        eo.setStatus(Status.A);
        eo.setAhBuFlag("Y");
        return eo;
    }

    private RbBusRestraintsEO restraintRecordEmr() {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo("6222020200000000001");
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(RestraintType.EMR);
        eo.setResSeqNo("R0000000002");
        return eo;
    }

    private RbRestraintTypeEO typeRecordEmr() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.EMR);
        eo.setStatus(Status.A);
        eo.setAhBuFlag("N");
        return eo;
    }
}

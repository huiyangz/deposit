package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST056 检查是否存在转账不收不付限制 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景 REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-003-S02、
 * REQ-003-S03（测试用例 ST056-TC001～ST056-TC003）。多条匹配记录的选择与判定口径
 * （待确认事项 1）、查询无匹配记录行为（待确认事项 2、3）、baseAcctNo 空/缺失处理
 * （待确认事项 7）及标志为「否」时其余字段口径（待确认事项 6）不作为本套用例断言，
 * 见 Spec 待确认事项。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST056PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST056Pbc st056Pbc;

    // 场景：REQ-001-S01 + REQ-002-S01 + REQ-003-S01，全流程命中：A 限制记录（VALUE_17）→ A 类型记录（drCrCtlFlag=A、transferFlag=N）→ 标志「是」，八字段完整输出且步骤成功
    @Test
    void testST056T01() {
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "6222000000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(List.of(restraintRecord()));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_17);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.A);
        type.setTransferFlag("N");
        type.setStopFlag("N");
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_17
                && eo.getStatus() == Status.A)))
                .thenReturn(List.of(type));

        ST056InputBO input = new ST056InputBO();
        input.setBaseAcctNo("6222000000000001");

        ST056OutputBO result = st056Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getTransferNoCreditNoDebitFlag());
        assertEquals("RES000001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("N", result.getTransferFlag());
        assertEquals("N", result.getStopFlag());
    }

    // 场景：REQ-001-S01 + REQ-002-S01 + REQ-003-S02，类型记录 drCrCtlFlag=C（非 A-禁止借贷方）、transferFlag=N，判定不成立返回标志「否」，步骤正常完成
    @Test
    void testST056T02() {
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "6222000000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(List.of(restraintRecord()));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_17);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.C);
        type.setTransferFlag("N");
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_17
                && eo.getStatus() == Status.A)))
                .thenReturn(List.of(type));

        ST056InputBO input = new ST056InputBO();
        input.setBaseAcctNo("6222000000000001");

        ST056OutputBO result = st056Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getTransferNoCreditNoDebitFlag());
    }

    // 场景：REQ-001-S01 + REQ-002-S01 + REQ-003-S03，类型记录 drCrCtlFlag=A、transferFlag=Y（非 N-禁止转账），判定不成立返回标志「否」，步骤正常完成
    @Test
    void testST056T03() {
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "6222000000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(List.of(restraintRecord()));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_17);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.A);
        type.setTransferFlag("Y");
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_17
                && eo.getStatus() == Status.A)))
                .thenReturn(List.of(type));

        ST056InputBO input = new ST056InputBO();
        input.setBaseAcctNo("6222000000000001");

        ST056OutputBO result = st056Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("否", result.getTransferNoCreditNoDebitFlag());
    }

    // 构造单条限制状态为 A 的账户限制记录（resSeqNo=RES000001、restraintType=VALUE_17），供三个用例的步骤1桩共用
    private RbBusRestraintsEO restraintRecord() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("6222000000000001");
        restraint.setResSeqNo("RES000001");
        restraint.setRestraintType(RestraintType.VALUE_17);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        return restraint;
    }
}

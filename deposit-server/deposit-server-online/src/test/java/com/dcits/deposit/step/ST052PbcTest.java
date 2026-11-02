package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

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
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST052 检查是否存在转账止付限制 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景（测试用例 ST052-TC001~TC004）：REQ-001-S01、REQ-002-S01、
 * REQ-003-S01~S04。查询无记录（TBD-1）、多条生效限制记录（TBD-2）、stopFlag 承载与物理值
 * （TBD-3）、「A-生效」标签口径（TBD-4）、baseAcctNo 缺失行为（TBD-5）无已确认预期，
 * 不作为本套用例断言，见 ST052Pbc 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST052PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST052Pbc st052Pbc;

    /** 构造桩1返回的对公存款账户限制表生效限制记录（挂失止付，限制编号 R202610100001） */
    private RbBusRestraintsEO buildRestraintsRecord() {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo("622800000001");
        eo.setRestraintsStatus(RestraintsStatus.A);
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setResSeqNo("R202610100001");
        return eo;
    }

    /** 构造桩2返回的存款限制类型表生效记录（指定借贷方控制标志与转账标志） */
    private RbRestraintTypeEO buildRestraintTypeRecord(DrCrCtlFlag drCrCtlFlag, String transferFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(Status.A);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setTransferFlag(transferFlag);
        return eo;
    }

    /** 构造输入 BO：baseAcctNo="622800000001" */
    private ST052InputBO buildInput() {
        ST052InputBO input = new ST052InputBO();
        input.setBaseAcctNo("622800000001");
        return input;
    }

    // 场景 ST052-TC001（REQ-001-S01、REQ-002-S01、REQ-003-S01）：限制类型表记录 drCrCtlFlag=D、
    // transferFlag="N"，满足「D-禁止借方且 N-不允许转账」，判定转账止付标志为「是」
    @Test
    void testST052T01() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintsRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintTypeRecord(DrCrCtlFlag.D, "N")));

        ST052OutputBO out = st052Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("R202610100001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("N", out.getTransferFlag());
        assertEquals("是", out.getStopFlag());
    }

    // 场景 ST052-TC002（REQ-003-S02）：限制类型表记录 drCrCtlFlag=C（禁止贷方）、transferFlag="N"，
    // 不满足「D-禁止借方」，判定转账止付标志为「否」
    @Test
    void testST052T02() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintsRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintTypeRecord(DrCrCtlFlag.C, "N")));

        ST052OutputBO out = st052Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("R202610100001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("N", out.getTransferFlag());
        assertEquals("否", out.getStopFlag());
    }

    // 场景 ST052-TC003（REQ-003-S03）：限制类型表记录 drCrCtlFlag=D（禁止借方）、transferFlag="Y"
    // （不等于 N），不满足「转账标志等于 N-不允许转账」，判定转账止付标志为「否」
    @Test
    void testST052T03() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintsRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintTypeRecord(DrCrCtlFlag.D, "Y")));

        ST052OutputBO out = st052Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("R202610100001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("Y", out.getTransferFlag());
        assertEquals("否", out.getStopFlag());
    }

    // 场景 ST052-TC004（REQ-003-S04）：限制类型表记录 drCrCtlFlag=C（禁止贷方）、transferFlag="Y"
    // （不等于 N），两条件均不满足「D-禁止借方且 N-不允许转账」，判定转账止付标志为「否」
    @Test
    void testST052T04() {
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintsRecord()));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(Collections.singletonList(buildRestraintTypeRecord(DrCrCtlFlag.C, "Y")));

        ST052OutputBO out = st052Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("R202610100001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals(Status.A, out.getStatus());
        assertEquals("Y", out.getTransferFlag());
        assertEquals("否", out.getStopFlag());
    }
}

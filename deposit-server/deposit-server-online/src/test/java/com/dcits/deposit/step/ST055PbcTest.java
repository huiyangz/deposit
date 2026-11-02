package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST055 检查是否存在止付限制 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景 REQ-001-S01、REQ-002-S01、REQ-002-S02、REQ-003-S01、
 * REQ-003-S02、REQ-004-S01、REQ-004-S02（测试用例 ST055-TC001～ST055-TC007）。
 * 多条匹配记录的选择与判定口径（待确认事项 1）、查询无匹配记录行为（待确认事项 2）、
 * baseAcctNo 空/缺失处理（待确认事项 3）不作为本套用例断言，见 Spec 待确认事项。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST055PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST055Pbc st055Pbc;

    // 场景：REQ-001-S01 + REQ-002-S01 + REQ-003-S01 + REQ-004-S01，全流程命中：A 限制记录（VALUE_13）→ A 类型记录（drCrCtlFlag=D）→ stopFlag=「是」，六字段完整输出且步骤成功
    @Test
    void testST055T01() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010001");
        restraint.setRestraintType(RestraintType.VALUE_13);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_13);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.D);
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getStopFlag());
        assertEquals("RST20261010001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
    }

    // 场景：REQ-002-S01 + REQ-003-S01，捕获两次查询 EO：账户限制查询条件为 baseAcctNo + restraintsStatus=A，类型查询条件为 restraintType + status=A
    @Test
    void testST055T02() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010001");
        restraint.setRestraintType(RestraintType.VALUE_13);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        ArgumentCaptor<RbBusRestraintsEO> restraintQueryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        lenient().when(rbBusRestraintsBcc.findByEo(restraintQueryCaptor.capture()))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_13);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.D);
        ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor = ArgumentCaptor.forClass(RbRestraintTypeEO.class);
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals("622200001234", restraintQueryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, restraintQueryCaptor.getValue().getRestraintsStatus());
        assertEquals(RestraintType.VALUE_13, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("RST20261010001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertTrue(result.isSucceed());
    }

    // 场景：REQ-002-S02，同账号两条限制记录（E 在前、A 在后），仅限制状态 A 的记录作为后续判定输入（不以首条为准），类型查询由 A 记录限制类型驱动
    @Test
    void testST055T03() {
        RbBusRestraintsEO eRecord = new RbBusRestraintsEO();
        eRecord.setBaseAcctNo("622200001234");
        eRecord.setResSeqNo("RST20261010099");
        eRecord.setRestraintType(RestraintType.VALUE_16);
        eRecord.setRestraintsStatus(RestraintsStatus.E);
        RbBusRestraintsEO aRecord = new RbBusRestraintsEO();
        aRecord.setBaseAcctNo("622200001234");
        aRecord.setResSeqNo("RST20261010001");
        aRecord.setRestraintType(RestraintType.VALUE_13);
        aRecord.setRestraintsStatus(RestraintsStatus.A);
        ArgumentCaptor<RbBusRestraintsEO> restraintQueryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        lenient().when(rbBusRestraintsBcc.findByEo(restraintQueryCaptor.capture()))
                .thenReturn(List.of(eRecord, aRecord));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_13);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.D);
        ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor = ArgumentCaptor.forClass(RbRestraintTypeEO.class);
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals("622200001234", restraintQueryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, restraintQueryCaptor.getValue().getRestraintsStatus());
        assertEquals(RestraintType.VALUE_13, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals("RST20261010001", result.getResSeqNo());
        assertEquals(RestraintType.VALUE_13, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals("是", result.getStopFlag());
        assertTrue(result.isSucceed());
    }

    // 场景：REQ-003-S01，捕获类型查询 EO：以步骤1取得的限制类型（VALUE_13）与状态 A 为查询条件，取得借贷方控制标志 D 作为止付判定输入
    @Test
    void testST055T04() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010001");
        restraint.setRestraintType(RestraintType.VALUE_13);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_13);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.D);
        ArgumentCaptor<RbRestraintTypeEO> typeQueryCaptor = ArgumentCaptor.forClass(RbRestraintTypeEO.class);
        lenient().when(rbRestraintTypeBcc.findByEo(typeQueryCaptor.capture()))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals(RestraintType.VALUE_13, typeQueryCaptor.getValue().getRestraintType());
        assertEquals(Status.A, typeQueryCaptor.getValue().getStatus());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("是", result.getStopFlag());
        assertTrue(result.isSucceed());
    }

    // 场景：REQ-003-S02，同限制类型两条类型记录（C 在前、A 在后），仅状态 A 记录的借贷方控制标志作为判定输入（不以首条为准），C 记录 drCrCtlFlag 不参与判定
    @Test
    void testST055T05() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010001");
        restraint.setRestraintType(RestraintType.VALUE_13);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO cRecord = new RbRestraintTypeEO();
        cRecord.setRestraintType(RestraintType.VALUE_13);
        cRecord.setStatus(Status.C);
        cRecord.setDrCrCtlFlag(DrCrCtlFlag.C);
        RbRestraintTypeEO aRecord = new RbRestraintTypeEO();
        aRecord.setRestraintType(RestraintType.VALUE_13);
        aRecord.setStatus(Status.A);
        aRecord.setDrCrCtlFlag(DrCrCtlFlag.D);
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(List.of(cRecord, aRecord));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(Status.A, result.getStatus());
        assertEquals("是", result.getStopFlag());
        assertTrue(result.isSucceed());
    }

    // 场景：REQ-004-S01，限制类型 VALUE_70 的有效类型记录借贷方控制标志为 D（禁止借方），返回 stopFlag=「是」
    @Test
    void testST055T06() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010002");
        restraint.setRestraintType(RestraintType.VALUE_70);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_70);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.D);
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals("是", result.getStopFlag());
        assertEquals(DrCrCtlFlag.D, result.getDrCrCtlFlag());
        assertEquals(RestraintType.VALUE_70, result.getRestraintType());
        assertEquals("RST20261010002", result.getResSeqNo());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：REQ-004-S02，限制类型 VALUE_71 的有效类型记录借贷方控制标志为 C（禁止贷方，非禁止借方），命中「否则返回『否』」分支并正常完成
    @Test
    void testST055T07() {
        RbBusRestraintsEO restraint = new RbBusRestraintsEO();
        restraint.setBaseAcctNo("622200001234");
        restraint.setResSeqNo("RST20261010003");
        restraint.setRestraintType(RestraintType.VALUE_71);
        restraint.setRestraintsStatus(RestraintsStatus.A);
        lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraint));

        RbRestraintTypeEO type = new RbRestraintTypeEO();
        type.setRestraintType(RestraintType.VALUE_71);
        type.setStatus(Status.A);
        type.setDrCrCtlFlag(DrCrCtlFlag.C);
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class)))
                .thenReturn(List.of(type));

        ST055InputBO input = new ST055InputBO();
        input.setBaseAcctNo("622200001234");

        ST055OutputBO result = st055Pbc.execute(input);

        assertEquals("否", result.getStopFlag());
        assertEquals(DrCrCtlFlag.C, result.getDrCrCtlFlag());
        assertEquals(RestraintType.VALUE_71, result.getRestraintType());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}

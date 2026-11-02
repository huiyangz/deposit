package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST060InputBO;
import com.dcits.deposit.facade.bo.ST060OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST060 检查是否存在现金不收不付限制 单元测试。
 *
 * <p>覆盖已确认用例 ST060-TC001~ST060-TC003（REQ-001-S01、REQ-002-S01、REQ-003-S01~S03、REQ-004-S01）。
 * 多条生效限制记录（TBD-1）、无匹配记录（TBD-2）、现金标志其它取值（TBD-4）、
 * 标志字段物理字段名与编码（TBD-5）、baseAcctNo 缺失（TBD-6）在澄清前不作为已确认断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST060PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST060Pbc st060Pbc;

    // ST060-TC001 正常路径：账号存在生效限制记录且限制类型存在生效记录，借贷方控制标志=禁止借贷方且现金标志=禁止现金，命中现金不收不付限制，返回「是」并携带完整输出成功结束
    @Test
    void testST060T01() {
        ST060InputBO input = new ST060InputBO();
        input.setBaseAcctNo("6205000001234567");

        RbBusRestraintsEO restraintsRecord = new RbBusRestraintsEO();
        restraintsRecord.setResSeqNo("RES20261001000001");
        restraintsRecord.setRestraintType(RestraintType.VALUE_70);
        restraintsRecord.setRestraintsStatus(RestraintsStatus.A);
        when(rbBusRestraintsBcc.findByEo(argThat(eo ->
                eo != null
                        && "6205000001234567".equals(eo.getBaseAcctNo())
                        && RestraintsStatus.A.equals(eo.getRestraintsStatus()))))
                .thenReturn(List.of(restraintsRecord));

        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.A);
        typeRecord.setCashFlag("N");
        when(rbRestraintTypeBcc.findByEo(argThat(eo ->
                eo != null
                        && RestraintType.VALUE_70.equals(eo.getRestraintType())
                        && Status.A.equals(eo.getStatus()))))
                .thenReturn(List.of(typeRecord));

        ST060OutputBO output = st060Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.getCashNoReceiveNoPayFlag());
        assertEquals("RES20261001000001", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_70, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
        assertEquals("N", output.getCashFlag());
    }

    // ST060-TC002 边界否定路径：判定第一条件不成立，限制类型生效记录 drCrCtlFlag=禁止借方（DrCrCtlFlag.D）而现金标志=N，返回「否」；以不同 restraintType/resSeqNo 验证步骤1到步骤2的数据传递
    @Test
    void testST060T02() {
        ST060InputBO input = new ST060InputBO();
        input.setBaseAcctNo("6205000001234567");

        RbBusRestraintsEO restraintsRecord = new RbBusRestraintsEO();
        restraintsRecord.setResSeqNo("RES20261001000002");
        restraintsRecord.setRestraintType(RestraintType.VALUE_73);
        restraintsRecord.setRestraintsStatus(RestraintsStatus.A);
        when(rbBusRestraintsBcc.findByEo(argThat(eo ->
                eo != null
                        && "6205000001234567".equals(eo.getBaseAcctNo())
                        && RestraintsStatus.A.equals(eo.getRestraintsStatus()))))
                .thenReturn(List.of(restraintsRecord));

        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.D);
        typeRecord.setCashFlag("N");
        when(rbRestraintTypeBcc.findByEo(argThat(eo ->
                eo != null
                        && RestraintType.VALUE_73.equals(eo.getRestraintType())
                        && Status.A.equals(eo.getStatus()))))
                .thenReturn(List.of(typeRecord));

        ST060OutputBO output = st060Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getCashNoReceiveNoPayFlag());
        assertEquals("RES20261001000002", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_73, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
        assertEquals("N", output.getCashFlag());
    }

    // ST060-TC003 边界否定路径：判定第二条件不成立，限制类型生效记录 drCrCtlFlag=禁止借贷方（DrCrCtlFlag.A）而现金标志不为N（示例值 Y），返回「否」
    @Test
    void testST060T03() {
        ST060InputBO input = new ST060InputBO();
        input.setBaseAcctNo("6205000001234567");

        RbBusRestraintsEO restraintsRecord = new RbBusRestraintsEO();
        restraintsRecord.setResSeqNo("RES20261001000003");
        restraintsRecord.setRestraintType(RestraintType.VALUE_72);
        restraintsRecord.setRestraintsStatus(RestraintsStatus.A);
        when(rbBusRestraintsBcc.findByEo(argThat(eo ->
                eo != null
                        && "6205000001234567".equals(eo.getBaseAcctNo())
                        && RestraintsStatus.A.equals(eo.getRestraintsStatus()))))
                .thenReturn(List.of(restraintsRecord));

        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.A);
        typeRecord.setCashFlag("Y");
        when(rbRestraintTypeBcc.findByEo(argThat(eo ->
                eo != null
                        && RestraintType.VALUE_72.equals(eo.getRestraintType())
                        && Status.A.equals(eo.getStatus()))))
                .thenReturn(List.of(typeRecord));

        ST060OutputBO output = st060Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getCashNoReceiveNoPayFlag());
        assertEquals("RES20261001000003", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_72, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
        assertEquals("Y", output.getCashFlag());
    }
}

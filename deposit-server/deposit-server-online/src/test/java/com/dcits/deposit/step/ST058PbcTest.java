package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST058 检查是否存在不收不付限制 单元测试。
 *
 * <p>覆盖本轮已确认用例 ST058-TC001~TC003（REQ-001-S01、REQ-002-S01、
 * REQ-003-S01/S02、REQ-004-S01 的单条记录路径）。
 * 未覆盖事项：多记录聚合、查询无记录、不收不付标志物理编码、baseAcctNo 缺失行为
 * （Spec 待确认事项 1/2/4/5），待业务确认后补充用例。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST058PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST058Pbc st058Pbc;

    // 正常路径 ST058-TC001：单条生效账户限制记录且对应限制类型记录状态 A、借贷方控制标志为禁止借贷方（DrCrCtlFlag.A），不收不付标志为「是」，六项输出均取自对应记录
    @Test
    void testST058T01() {
        // 构造输入：账号
        ST058InputBO input = new ST058InputBO();
        input.setBaseAcctNo("100000000001");

        // 桩：账户限制查询（账号 + 限制状态 A）返回单条生效记录（限制类型 52、限制编号 REST00001）
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setBaseAcctNo("100000000001");
        record.setRestraintsStatus(RestraintsStatus.A);
        record.setRestraintType(RestraintType.VALUE_52);
        record.setResSeqNo("REST00001");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "100000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(record));

        // 桩：限制类型查询（限制类型 + 状态 A）返回单条记录（状态 A、借贷方控制标志 A）
        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        // 限制类型记录的 restraintType 设为区分值 VALUE_55（账户限制记录为 VALUE_52），用于校验输出 restraintType 取自账户限制记录而非限制类型记录
        typeRecord.setRestraintType(RestraintType.VALUE_55);
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.A);
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_52
                && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(typeRecord));

        // 执行
        ST058OutputBO output = st058Pbc.execute(input);

        // 断言：成功、错误字段为 null，六项输出均取自对应记录
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.getNoCreditNoDebitFlag());
        assertEquals("REST00001", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_52, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.A, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
    }

    // 正常路径 ST058-TC002：借贷方控制标志为禁止贷方（DrCrCtlFlag.C），不收不付标志为「否」，其余输出仍取自对应记录
    @Test
    void testST058T02() {
        // 构造输入：账号
        ST058InputBO input = new ST058InputBO();
        input.setBaseAcctNo("100000000001");

        // 桩：账户限制查询（账号 + 限制状态 A）返回单条生效记录（限制类型 52、限制编号 REST00002）
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setBaseAcctNo("100000000001");
        record.setRestraintsStatus(RestraintsStatus.A);
        record.setRestraintType(RestraintType.VALUE_52);
        record.setResSeqNo("REST00002");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "100000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(record));

        // 桩：限制类型查询（限制类型 + 状态 A）返回单条记录（状态 A、借贷方控制标志 C）
        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        // 限制类型记录的 restraintType 设为区分值 VALUE_55（账户限制记录为 VALUE_52），用于校验输出 restraintType 取自账户限制记录而非限制类型记录
        typeRecord.setRestraintType(RestraintType.VALUE_55);
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.C);
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_52
                && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(typeRecord));

        // 执行
        ST058OutputBO output = st058Pbc.execute(input);

        // 断言：成功、错误字段为 null，不收不付标志为「否」，其余输出取自对应记录
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getNoCreditNoDebitFlag());
        assertEquals("REST00002", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_52, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.C, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
    }

    // 正常路径 ST058-TC003：借贷方控制标志为禁止借方（DrCrCtlFlag.D），不收不付标志为「否」，输出 drCrCtlFlag=DrCrCtlFlag.D
    @Test
    void testST058T03() {
        // 构造输入：账号
        ST058InputBO input = new ST058InputBO();
        input.setBaseAcctNo("100000000001");

        // 桩：账户限制查询（账号 + 限制状态 A）返回单条生效记录（限制类型 52、限制编号 REST00003）
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setBaseAcctNo("100000000001");
        record.setRestraintsStatus(RestraintsStatus.A);
        record.setRestraintType(RestraintType.VALUE_52);
        record.setResSeqNo("REST00003");
        lenient().when(rbBusRestraintsBcc.findByEo(argThat(eo -> "100000000001".equals(eo.getBaseAcctNo())
                && eo.getRestraintsStatus() == RestraintsStatus.A)))
                .thenReturn(Collections.singletonList(record));

        // 桩：限制类型查询（限制类型 + 状态 A）返回单条记录（状态 A、借贷方控制标志 D）
        RbRestraintTypeEO typeRecord = new RbRestraintTypeEO();
        // 限制类型记录的 restraintType 设为区分值 VALUE_55（账户限制记录为 VALUE_52），用于校验输出 restraintType 取自账户限制记录而非限制类型记录
        typeRecord.setRestraintType(RestraintType.VALUE_55);
        typeRecord.setStatus(Status.A);
        typeRecord.setDrCrCtlFlag(DrCrCtlFlag.D);
        lenient().when(rbRestraintTypeBcc.findByEo(argThat(eo -> eo.getRestraintType() == RestraintType.VALUE_52
                && eo.getStatus() == Status.A)))
                .thenReturn(Collections.singletonList(typeRecord));

        // 执行
        ST058OutputBO output = st058Pbc.execute(input);

        // 断言：成功、错误字段为 null，不收不付标志为「否」，其余输出取自对应记录
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getNoCreditNoDebitFlag());
        assertEquals("REST00003", output.getResSeqNo());
        assertEquals(RestraintType.VALUE_52, output.getRestraintType());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(DrCrCtlFlag.D, output.getDrCrCtlFlag());
        assertEquals(Status.A, output.getStatus());
    }
}

package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.lenient;

import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.facade.bo.ST059InputBO;
import com.dcits.deposit.facade.bo.ST059OutputBO;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST059 检查账户是否存在不允许销户的限制 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-003-S02、REQ-004-S01、
 * REQ-004-S02（用例 ST059-TC001~TC006）。TBD-1~TBD-6 对应行为无已确认验收断言，不作为
 * 本套用例预期。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST059PbcTest {

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST059Pbc st059Pbc;

    // 场景：REQ-001-S01 单条限制命中不允许销户（restraintType=VALUE_13 挂失止付，销户标志"N"），输出"不允许销户"
    @Test
    void testST059T01() {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(closeAcctFlagEO("N"));

        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(List.of(restraintInfo("RES001", RestraintType.VALUE_13)));

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("不允许销户", output.getAllowCloseFlag());
    }

    // 场景：REQ-002-S01 单条限制销户标志非"N-否"（示例值"Y"），继续遍历后输出"允许销户"
    @Test
    void testST059T02() {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_16))
                .thenReturn(closeAcctFlagEO("Y"));

        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(List.of(restraintInfo("RES001", RestraintType.VALUE_16)));

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("允许销户", output.getAllowCloseFlag());
    }

    // 场景：REQ-003-S01 单条限制销户标志为"N-否"（VALUE_4 统一查控平台全额止付），输出"不允许销户"并结束步骤
    @Test
    void testST059T03() {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(closeAcctFlagEO("N"));

        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(List.of(restraintInfo("RES001", RestraintType.VALUE_4)));

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("不允许销户", output.getAllowCloseFlag());
    }

    // 场景：REQ-003-S02 四条限制中第 3 条命中"N-否"（VALUE_16→"Y"、VALUE_6→"Y"、VALUE_13→"N"、第 4 条 VALUE_7 中断后不触达不设桩），输出"不允许销户"
    @Test
    void testST059T04() {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_16))
                .thenReturn(closeAcctFlagEO("Y"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_6))
                .thenReturn(closeAcctFlagEO("Y"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(closeAcctFlagEO("N"));

        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(List.of(
                restraintInfo("RES001", RestraintType.VALUE_16),
                restraintInfo("RES002", RestraintType.VALUE_6),
                restraintInfo("RES003", RestraintType.VALUE_13),
                restraintInfo("RES004", RestraintType.VALUE_7)));

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("不允许销户", output.getAllowCloseFlag());
    }

    // 场景：REQ-004-S01 两条限制销户标志均非"N-否"（VALUE_16→"Y"、VALUE_4→"Y"），遍历结束输出"允许销户"
    @Test
    void testST059T05() {
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_16))
                .thenReturn(closeAcctFlagEO("Y"));
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4))
                .thenReturn(closeAcctFlagEO("Y"));

        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(List.of(
                restraintInfo("RES001", RestraintType.VALUE_16),
                restraintInfo("RES002", RestraintType.VALUE_4)));

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("允许销户", output.getAllowCloseFlag());
    }

    // 场景：REQ-004-S02 [账户限制信息]为空集合，遍历直接结束，输出"允许销户"（无依赖调用，不设桩）
    @Test
    void testST059T06() {
        ST059InputBO input = new ST059InputBO();
        input.setRestraintList(Collections.emptyList());

        ST059OutputBO output = st059Pbc.execute(input);

        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("允许销户", output.getAllowCloseFlag());
    }

    /**
     * 构造[账户限制信息]集合元素：restraintType 为步骤判定的必填输入；
     * resSeqNo、restraintsStatus（A 已批准）、restraintLevel（ACCT 账户级别）按 Spec
     * 输入契约提供有效值。
     */
    private ST059InputBO.RestraintInfo restraintInfo(String resSeqNo, RestraintType restraintType) {
        ST059InputBO.RestraintInfo info = new ST059InputBO.RestraintInfo();
        info.setResSeqNo(resSeqNo);
        info.setRestraintType(restraintType);
        info.setRestraintsStatus(RestraintsStatus.A);
        info.setRestraintLevel(RestraintLevel.ACCT);
        return info;
    }

    /** 构造【限制类型信息】记录，仅设置[销户标志]，其余字段不参与判定、不赋值 */
    private RbRestraintTypeEO closeAcctFlagEO(String closeAcctFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setCloseAcctFlag(closeAcctFlag);
        return eo;
    }
}

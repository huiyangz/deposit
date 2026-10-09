package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.facade.bo.ST123InputBO;
import com.dcits.depsit.facade.bo.ST123OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST123 检查账户是否存在不允许销户的限制的单元测试。
 *
 * <p>调用签名：{@code ST123OutputBO execute(ST123InputBO input)}。唯一依赖为
 * {@code IRbRestraintTypeBcc.findByRestraintType(RestraintType)}（无匹配时返回 null），
 * 逐条以记录自身的账户限制类型为查询键设桩，不 mock 被测步骤的 execute，
 * 不使用 verify/times 验证交互。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST123PbcTest {

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST123Pbc st123Pbc;

    // ST123-TC001：两条记录均查得 $销户标志$＝"Y"，遍历自然结束，末行返回「允许销户」
    @Test
    void testST123T01() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_8))
                .thenReturn(config("Y"));

        ST123InputBO input = inputOf(
                record("RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT),
                record("RS20261009002", RestraintType.VALUE_8, RestraintsStatus.E, RestraintLevel.NATURE));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC002：单条记录查得 $销户标志$＝"N"，步骤 2）返回「不允许销户」
    @Test
    void testST123T02() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("N"));

        ST123InputBO input = inputOf(
                record("RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("不允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC003：两条记录各以自身限制类型为查询键（"13"→"Y" 继续、"8"→"N" 中断），不跨记录复用
    @Test
    void testST123T03() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_8))
                .thenReturn(config("N"));

        ST123InputBO input = inputOf(
                record("RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT),
                record("RS20261009002", RestraintType.VALUE_8, RestraintsStatus.A, RestraintLevel.NATURE));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("不允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC004：触发 "N" 的记录位于集合首位，其后仍有 "Y" 记录与无配置记录，结论不被末行覆盖
    @Test
    void testST123T04() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("N"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_8))
                .thenReturn(config("Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(null);

        ST123InputBO input = inputOf(
                record("RS20261009011", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT),
                record("RS20261009012", RestraintType.VALUE_8, RestraintsStatus.A, RestraintLevel.NATURE),
                record("RS20261009013", RestraintType.VALUE_62, RestraintsStatus.E, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("不允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC005：首条查询不到【限制类型信息】（不影响销户、继续遍历），第二条查得 "N" 后返回「不允许销户」
    @Test
    void testST123T05() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("N"));

        ST123InputBO input = inputOf(
                record("RS20261009021", RestraintType.VALUE_62, RestraintsStatus.A, RestraintLevel.ACCT),
                record("RS20261009022", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("不允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC006：全部记录的限制类型均无配置记录，遍历正常结束后末行给出「允许销户」
    @Test
    void testST123T06() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_95))
                .thenReturn(null);

        ST123InputBO input = inputOf(
                record("RS20261009031", RestraintType.VALUE_62, RestraintsStatus.A, RestraintLevel.ACCT),
                record("RS20261009032", RestraintType.VALUE_95, RestraintsStatus.E, RestraintLevel.NATURE));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC007：查得配置但 $销户标志$ 无值（null），无值不等于 "N" 而继续遍历 → 「允许销户」
    @Test
    void testST123T07() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config(null));

        ST123InputBO input = inputOf(
                record("RS20261009041", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC008：$销户标志$ 取 "N" 之外的其它文案（"Z"），落入「否则继续遍历」 → 「允许销户」
    @Test
    void testST123T08() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("Z"));

        ST123InputBO input = inputOf(
                record("RS20261009051", RestraintType.VALUE_13, RestraintsStatus.A, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC009：[账户限制信息] 为空集，遍历立即结束，末行给出「允许销户」（空集不触达查询，不设桩）
    @Test
    void testST123T09() {
        ST123InputBO input = new ST123InputBO();
        input.setAccountRestraintInfoList(Collections.emptyList());

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC010：记录限制状态为 E、限制级别为 NATURE 仍参与判定并触发 "N"（遍历无过滤条件）
    @Test
    void testST123T10() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13))
                .thenReturn(config("N"));

        ST123InputBO input = inputOf(
                record("RS20261009061", RestraintType.VALUE_13, RestraintsStatus.E, RestraintLevel.NATURE));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("不允许销户", result.getAllowCloseAcctFlag());
    }

    // ST123-TC011：一条 "Y" 记录与一条无配置记录均不触发中断，遍历结束返回「允许销户」
    @Test
    void testST123T11() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_8))
                .thenReturn(config("Y"));
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62))
                .thenReturn(null);

        ST123InputBO input = inputOf(
                record("RS20261009071", RestraintType.VALUE_8, RestraintsStatus.A, RestraintLevel.NATURE),
                record("RS20261009072", RestraintType.VALUE_62, RestraintsStatus.A, RestraintLevel.ACCT));

        ST123OutputBO result = st123Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("允许销户", result.getAllowCloseAcctFlag());
    }

    /** 构造【限制类型信息】记录，仅设置本步骤使用的销户标志字段。 */
    private static RbRestraintTypeEO config(String closeAcctFlag) {
        RbRestraintTypeEO restraintTypeInfo = new RbRestraintTypeEO();
        restraintTypeInfo.setCloseAcctFlag(closeAcctFlag);
        return restraintTypeInfo;
    }

    /** 构造 [账户限制信息] 中的一条限制记录。 */
    private static ST123InputBO.RestraintRecord record(String resSeqNo, RestraintType restraintType,
            RestraintsStatus restraintsStatus, RestraintLevel restraintLevel) {
        ST123InputBO.RestraintRecord record = new ST123InputBO.RestraintRecord();
        record.setResSeqNo(resSeqNo);
        record.setRestraintType(restraintType);
        record.setRestraintsStatus(restraintsStatus);
        record.setRestraintLevel(restraintLevel);
        return record;
    }

    /** 构造以给定记录为 [账户限制信息] 的步骤输入。 */
    private static ST123InputBO inputOf(ST123InputBO.RestraintRecord... records) {
        ST123InputBO input = new ST123InputBO();
        List<ST123InputBO.RestraintRecord> restraintList = Arrays.asList(records);
        input.setAccountRestraintInfoList(restraintList);
        return input;
    }
}

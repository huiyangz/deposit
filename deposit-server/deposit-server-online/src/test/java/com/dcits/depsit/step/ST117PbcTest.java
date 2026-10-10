package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST117InputBO;
import com.dcits.depsit.facade.bo.ST117OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST117 检查质押类限制的单元测试。
 *
 * <p>调用签名：{@code ST117OutputBO execute(ST117InputBO input)}；被测实例
 * {@link ST117Pbc} 以两个 BCC mock 按构造注入后真实执行 {@code execute}。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST117PbcTest {

    /** 用例入参账号。 */
    private static final String BASE_ACCT_NO = "6222020200112233";

    /** 质押标志示例值：表示存在质押（Spec 明确标注为示例数据，非规范常量）。 */
    private static final String PLEDGED = "Y";

    /** 质押标志示例值：不表示存在质押（Spec 明确标注为示例数据，非规范常量）。 */
    private static final String NOT_PLEDGED = "N";

    /** 质押标志示例值：表示存在质押以外的其它取值（用于锁定判定边界）。 */
    private static final String OTHER_FLAG = "X";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST117Pbc st117Pbc;

    // ST117-TC001：REQ-001-S01 + REQ-003-S01 + REQ-004-S01 + REQ-006-S01 + REQ-007-S01
    // 单条生效限制（类型 "12"）命中，质押标志原值返回，其余回显字段按来源承载
    @Test
    void testST117T01() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of(restraints(RestraintType.VALUE_12, "R202610100001")));
        ArgumentCaptor<String> keyCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(keyCaptor.capture()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertNotNull(result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 命中路径：质押标志取配置记录原值，不得折算为「是」/「否」
        assertEquals(PLEDGED, result.getPledgedFlag());
        assertNotEquals("是", result.getPledgedFlag());
        // 回显字段的取值来源
        assertEquals(RestraintType.VALUE_12, result.getRestraintType());
        assertEquals(RestraintsStatus.A, result.getRestraintsStatus());
        assertEquals("R202610100001", result.getResSeqNo());
        assertEquals(Status.A, result.getStatus());
        // 子步骤 1 的取数条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
        // 子步骤 2 的查询键：当前记录的账户限制类型码值
        assertEquals(RestraintType.VALUE_12.getValue(), keyCaptor.getValue());
    }

    // ST117-TC002：REQ-001-S02 + REQ-004-S02 + REQ-005-S01
    // 两条生效记录，第 1 条不表示存在质押→不命中并继续，第 2 条命中→取该值返回
    @Test
    void testST117T02() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_13, "R202610100002"),
                        restraints(RestraintType.VALUE_12, "R202610100001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, NOT_PLEDGED));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(PLEDGED, result.getPledgedFlag());
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC003：REQ-003-S02 + REQ-003-S03 + REQ-004-S01 + REQ-005-S01
    // 三条生效记录：第 1 条无配置、第 2 条配置非 "A"，两条均不参与判定且不提前结束；第 3 条命中
    @Test
    void testST117T03() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_13, "R202610100003"),
                        restraints(RestraintType.VALUE_14, "R202610100004"),
                        restraints(RestraintType.VALUE_12, "R202610100001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_14.getValue()))
                .thenReturn(config(RestraintType.VALUE_14, Status.F, PLEDGED));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC004：REQ-002-S01 + REQ-006-S02
    // 账号下不存在限制状态为 "A" 的记录→不执行子步骤 2，[质押标志] 不赋值并直接返回
    @Test
    void testST117T04() {
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture()))
                .thenReturn(List.of());

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getPledgedFlag());
        // 不赋值，不得以 "N"/"否" 或其它取值替代
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
        // 子步骤 1 的取数条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST117-TC005：REQ-003-S02 + REQ-005-S03
    // 限制记录的类型 "13" 在【限制类型表】无记录→该条不参与判定，全部处理完毕后 [质押标志] 不赋值
    @Test
    void testST117T05() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_13, "R202610100003")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(null);

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getPledgedFlag());
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC006：REQ-003-S03 + REQ-006
    // 类型 "13" 有配置但状态码值为 "F"（非 "A"）→配置不被取用，即使质押标志表示存在质押也不取用
    @Test
    void testST117T06() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_13, "R202610100003")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(config(RestraintType.VALUE_13, Status.F, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getPledgedFlag());
        assertNotEquals(PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC007：REQ-004-S02 + REQ-005-S02 + REQ-006-S03
    // 两条生效记录均有 "A" 状态配置但质押标志均不表示存在质押→均不命中，[质押标志] 不赋值
    @Test
    void testST117T07() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_13, "R202610100003"),
                        restraints(RestraintType.VALUE_12, "R202610100001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, NOT_PLEDGED));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, NOT_PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getPledgedFlag());
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
        assertNotEquals("否", result.getPledgedFlag());
    }

    // ST117-TC008：REQ-003-S02 + REQ-003-S03 + REQ-005-S03
    // 两条生效记录的类型均无 "A" 状态配置（"13" 无记录、"14" 状态为 "F"）→[质押标志] 不赋值
    @Test
    void testST117T08() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(
                        restraints(RestraintType.VALUE_13, "R202610100003"),
                        restraints(RestraintType.VALUE_14, "R202610100004")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_14.getValue()))
                .thenReturn(config(RestraintType.VALUE_14, Status.F, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getPledgedFlag());
        assertNotEquals(PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC009：REQ-001-S02 + REQ-005-S02
    // 账号下 "A" 与 "E" 记录并存，仅 "A" 记录参与判定："A" 的两条均不表示存在质押，故不赋值；
    // "E" 记录（若被误纳入）对应配置表示存在质押，桩按请求条件过滤可暴露该误取数
    @Test
    void testST117T09() {
        List<RbBusRestraintsEO> stored = List.of(
                restraints(RestraintType.VALUE_13, RestraintsStatus.A, "R202610100003"),
                restraints(RestraintType.VALUE_12, RestraintsStatus.A, "R202610100001"),
                restraints(RestraintType.VALUE_14, RestraintsStatus.E, "R202610100004"));
        ArgumentCaptor<RbBusRestraintsEO> queryCaptor = ArgumentCaptor.forClass(RbBusRestraintsEO.class);
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(queryCaptor.capture())).thenAnswer(invocation -> {
            RbBusRestraintsEO query = invocation.getArgument(0);
            List<RbBusRestraintsEO> matched = new ArrayList<>();
            for (RbBusRestraintsEO row : stored) {
                if (Objects.equals(query.getBaseAcctNo(), row.getBaseAcctNo())
                        && Objects.equals(query.getRestraintsStatus(), row.getRestraintsStatus())) {
                    matched.add(row);
                }
            }
            return matched;
        });
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_13.getValue()))
                .thenReturn(config(RestraintType.VALUE_13, Status.A, NOT_PLEDGED));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, NOT_PLEDGED));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_14.getValue()))
                .thenReturn(config(RestraintType.VALUE_14, Status.A, PLEDGED));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getPledgedFlag());
        // 子步骤 1 的取数条件：账号 + 限制状态码值 "A"
        assertEquals(BASE_ACCT_NO, queryCaptor.getValue().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, queryCaptor.getValue().getRestraintsStatus());
    }

    // ST117-TC010：REQ-004-S02 + REQ-005-S02（判定边界：非约定取值）
    // 配置记录状态为 "A" 但质押标志取值为项目约定「表示存在质押」以外的其它取值（示例 "X"）
    // → 按「不表示存在质押」处理：不命中、[质押标志] 不赋值，也不得把该取值当作结论返回
    @Test
    void testST117T10() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_12, "R202610100001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, OTHER_FLAG));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getPledgedFlag());
        assertNotEquals(OTHER_FLAG, result.getPledgedFlag());
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
    }

    // ST117-TC011：REQ-004-S02 + REQ-005-S02 + REQ-006-S03（判定边界：空值）
    // 配置记录状态为 "A" 但质押标志为空（该列可空）→ 不表示存在质押：不命中、[质押标志] 不赋值
    @Test
    void testST117T11() {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class)))
                .thenReturn(List.of(restraints(RestraintType.VALUE_12, "R202610100001")));
        Mockito.lenient().when(rbRestraintTypeBcc.findByPrimaryKey(RestraintType.VALUE_12.getValue()))
                .thenReturn(config(RestraintType.VALUE_12, Status.A, null));

        ST117OutputBO result = st117Pbc.execute(input(BASE_ACCT_NO));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getPledgedFlag());
        assertNotEquals(NOT_PLEDGED, result.getPledgedFlag());
        assertNotEquals("否", result.getPledgedFlag());
    }

    private static ST117InputBO input(String baseAcctNo) {
        ST117InputBO input = new ST117InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private static RbBusRestraintsEO restraints(RestraintType restraintType, String resSeqNo) {
        return restraints(restraintType, RestraintsStatus.A, resSeqNo);
    }

    private static RbBusRestraintsEO restraints(
            RestraintType restraintType, RestraintsStatus restraintsStatus, String resSeqNo) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo(BASE_ACCT_NO);
        eo.setRestraintsStatus(restraintsStatus);
        eo.setRestraintType(restraintType);
        eo.setResSeqNo(resSeqNo);
        return eo;
    }

    private static RbRestraintTypeEO config(RestraintType restraintType, Status status, String pledgedFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setPledgedFlag(pledgedFlag);
        return eo;
    }
}

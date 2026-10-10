package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.facade.bo.ST131InputBO;
import com.dcits.depsit.facade.bo.ST131OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * ST131 检查账户限制编号是否存在的单元测试。
 *
 * <p>调用签名：{@code ST131OutputBO execute(ST131InputBO input)}。唯一依赖为
 * {@code IRbBusRestraintsBcc.findByEo(RbBusRestraintsEO)}（零条命中返回空列表），
 * 以「限制编号＋限制状态」两个条件在桩内过滤实例字段 {@code restraintsTable}，
 * 不 mock 被测步骤的 execute，不使用 verify/never/times 验证交互。</p>
 *
 * <p>本步骤无业务失败场景、无错误码，故全部用例断言 {@code succeed} 为 true
 * 且两个错误字段为 null；检查结果的承载字段为 {@code checkResult}。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST131PbcTest {

    /** 检查结果规范常量：限制编号存在 */
    private static final String CHECK_RESULT_EXISTS = "限制编号存在";

    /** 检查结果规范常量：限制编号不存在 */
    private static final String CHECK_RESULT_NOT_EXISTS = "限制编号不存在";

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST131Pbc st131Pbc;

    /** 本次执行的【限制信息】表内容，桩在调用时按此过滤，TC008 在两次执行之间替换 */
    private List<RbBusRestraintsEO> restraintsTable = Collections.emptyList();

    // ST131-TC001：限制编号非空、限制状态为「A-生效」（码值 A），查询命中 1 条 → 「限制编号存在」
    @Test
    void testST131T01() {
        restraintsTable = Arrays.asList(record("RS20261009001", RestraintsStatus.A));
        stubQuery("RS20261009001", RestraintsStatus.A, false);

        ST131InputBO input = inputOf("RS20261009001", RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC002：限制状态为「F-未生效」（码值 F），查询命中 1 条 → 「限制编号存在」，与 A 无优先级差异
    @Test
    void testST131T02() {
        restraintsTable = Arrays.asList(record("RS20261009002", RestraintsStatus.F));
        stubQuery("RS20261009002", RestraintsStatus.F, false);

        ST131InputBO input = inputOf("RS20261009002", RestraintsStatus.F);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC003：表内该编号记录的状态为 E（不属查询状态 A、F），状态条件不满足、零条命中 → 「限制编号不存在」
    @Test
    void testST131T03() {
        restraintsTable = Arrays.asList(record("RS20261009003", RestraintsStatus.E));
        stubQuery("RS20261009003", RestraintsStatus.A, false);

        ST131InputBO input = inputOf("RS20261009003", RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_NOT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC004：表内另有其它限制编号的记录，只按两个条件过滤；请求 EO 除两条件外不带其它过滤字段 → 「限制编号存在」
    @Test
    void testST131T04() {
        restraintsTable = Arrays.asList(
                record("RS20261009001", RestraintsStatus.A),
                record("RS20261009004", RestraintsStatus.A));
        stubQuery("RS20261009001", RestraintsStatus.A, true);

        ST131InputBO input = inputOf("RS20261009001", RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC005：编号非空但表中不存在该编号，零条命中 → 「限制编号不存在」，不产出错误码
    @Test
    void testST131T05() {
        restraintsTable = Arrays.asList(record("RS20261009001", RestraintsStatus.A));
        stubQuery("RS20261009999", RestraintsStatus.A, false);

        ST131InputBO input = inputOf("RS20261009999", RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_NOT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC006：限制编号无值（null）→ 步骤 1 不执行查询、[限制信息] 为空 → 「限制编号不存在」
    @Test
    void testST131T06() {
        restraintsTable = Arrays.asList(record("RS20261009001", RestraintsStatus.A));
        stubQuery("RS20261009001", RestraintsStatus.A, false);

        ST131InputBO input = inputOf(null, RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_NOT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC007：限制编号为空字符串（长度 0）→ 与 null 同样按「无值」处理，不执行查询 → 「限制编号不存在」
    @Test
    void testST131T07() {
        restraintsTable = Arrays.asList(record("RS20261009001", RestraintsStatus.A));
        stubQuery("RS20261009001", RestraintsStatus.A, false);

        ST131InputBO input = inputOf("", RestraintsStatus.A);

        ST131OutputBO result = st131Pbc.execute(input);

        assertEquals(CHECK_RESULT_NOT_EXISTS, result.getCheckResult());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST131-TC008：命中记录的其它字段取两组不同取值，结论仍只取决于 [限制信息] 是否为空 → 两次均「限制编号存在」
    @Test
    void testST131T08() {
        RbBusRestraintsEO firstRecord = record("RS20261009005", RestraintsStatus.A);
        firstRecord.setRestraintType(RestraintType.VALUE_13);
        firstRecord.setRestraintLevel(RestraintLevel.NATURE);
        firstRecord.setPledgedAmt(new BigDecimal("0"));
        firstRecord.setBaseAcctNo(null);
        restraintsTable = Arrays.asList(firstRecord);
        stubQuery("RS20261009005", RestraintsStatus.A, false);

        ST131OutputBO firstResult = st131Pbc.execute(inputOf("RS20261009005", RestraintsStatus.A));

        assertEquals(CHECK_RESULT_EXISTS, firstResult.getCheckResult());
        assertTrue(firstResult.isSucceed());
        assertNull(firstResult.getErrorCode());
        assertNull(firstResult.getErrorMessage());

        // 第二次执行前替换【限制信息】表内容：同编号同状态，记录的其它字段取另一组取值
        RbBusRestraintsEO secondRecord = record("RS20261009005", RestraintsStatus.A);
        secondRecord.setRestraintType(RestraintType.VALUE_8);
        secondRecord.setRestraintLevel(RestraintLevel.ACCT);
        secondRecord.setPledgedAmt(new BigDecimal("999.99"));
        secondRecord.setBaseAcctNo("6217000000000001");
        restraintsTable = Arrays.asList(secondRecord);

        ST131OutputBO secondResult = st131Pbc.execute(inputOf("RS20261009005", RestraintsStatus.A));

        assertEquals(CHECK_RESULT_EXISTS, secondResult.getCheckResult());
        assertTrue(secondResult.isSucceed());
        assertNull(secondResult.getErrorCode());
        assertNull(secondResult.getErrorMessage());
    }

    /**
     * 以「限制编号＋限制状态」两个条件为查询桩：桩内先核对请求 EO 的两个条件，
     * 再按这两个条件过滤本次的 {@code restraintsTable} 并返回命中列表
     * （零条命中返回空列表）。
     *
     * @param assertOnlyTwoConditions 为 true 时额外断言请求 EO 除两个条件字段外其余字段均为 null（TC004）
     */
    private void stubQuery(String expectedResSeqNo, RestraintsStatus expectedRestraintsStatus,
            boolean assertOnlyTwoConditions) {
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    RbBusRestraintsEO condition = invocation.getArgument(0);
                    assertEquals(expectedResSeqNo, condition.getResSeqNo());
                    assertEquals(expectedRestraintsStatus, condition.getRestraintsStatus());
                    if (assertOnlyTwoConditions) {
                        assertOnlyTwoConditionFields(condition);
                    }
                    List<RbBusRestraintsEO> matched = new ArrayList<>();
                    for (RbBusRestraintsEO record : restraintsTable) {
                        if (condition.getResSeqNo().equals(record.getResSeqNo())
                                && condition.getRestraintsStatus() == record.getRestraintsStatus()) {
                            matched.add(record);
                        }
                    }
                    return matched;
                });
    }

    /** 断言请求 EO 仅承载限制编号与限制状态两个条件，其余字段均为 null（不附加其它过滤条件）。 */
    private static void assertOnlyTwoConditionFields(RbBusRestraintsEO condition) {
        for (Field field : RbBusRestraintsEO.class.getDeclaredFields()) {
            if ("resSeqNo".equals(field.getName()) || "restraintsStatus".equals(field.getName())) {
                continue;
            }
            try {
                field.setAccessible(true);
                assertNull(field.get(condition), "查询条件不应携带其它字段：" + field.getName());
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("无法读取查询条件字段：" + field.getName(), e);
            }
        }
    }

    /** 构造【限制信息】中的一条限制记录，仅设置作为查询条件的两个字段。 */
    private static RbBusRestraintsEO record(String resSeqNo, RestraintsStatus restraintsStatus) {
        RbBusRestraintsEO record = new RbBusRestraintsEO();
        record.setResSeqNo(resSeqNo);
        record.setRestraintsStatus(restraintsStatus);
        return record;
    }

    /** 构造步骤输入：限制编号与限制状态两个字段。 */
    private static ST131InputBO inputOf(String resSeqNo, RestraintsStatus restraintsStatus) {
        ST131InputBO input = new ST131InputBO();
        input.setResSeqNo(resSeqNo);
        input.setRestraintsStatus(restraintsStatus);
        return input;
    }
}

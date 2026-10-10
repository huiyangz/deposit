package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST115InputBO;
import com.dcits.depsit.facade.bo.ST115OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;

/**
 * ST115 检查账户是否存在限制 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（ST115-TC001 ~ ST115-TC011），期望值取自正式 Spec。
 * 真实 {@link ST115Pbc}；仅对两个依赖数据服务接口 {@link IRbBusAcctBcc}、{@link IRbBusRestraintsBcc}
 * 设桩，不访问数据库、不设技术异常、不使用规则桩或跨组件客户端桩。</p>
 *
 * <p>否定性路径（不回查、短路后不再查询）按技能要求不使用 {@code verify}／{@code never}／{@code times}：
 * 对未触达依赖设置「返回存在记录」的桩并另设一组会造成取值冲突的夹具，使实现若错误地继续执行
 * 将产出与断言冲突的非空回显，从而可失败。</p>
 *
 * <p>两个 {@code findByEo} 均用应答式桩（按入参 EO 的 {@code baseAcctNo} 过滤；限制查询在入参
 * {@code restraintsStatus} 非空时再按状态相等过滤），不写死返回值，避免掩盖条件传错；同时记录
 * 收到的查询条件 EO 供断言（TC001 断言 1a 只用账号条件，TC002／TC005／TC011 断言限制查询账号条件）。</p>
 *
 * <p>{@code leadAcctFlag} 的夹具取值 {@code "Y"}（是主账户）／{@code "N"}（不是主账户）属
 * **待确认假定**（Spec 不覆盖项 2 未给出码值域，按项目码值书写口径 DT002 取值），仅用于触发
 * REQ-003／REQ-004 的语义分支，不作业务码值断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST115PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST115Pbc step;

    /**
     * 设桩子步骤 1a：按入参 EO 的 {@code baseAcctNo} 过滤账户夹具，返回命中集合（可表达查无／多条）。
     *
     * @param fixtures 账户夹具
     * @return 捕获到的 1a 查询条件 EO
     */
    private AtomicReference<RbBusAcctEO> stubAccountQuery(RbBusAcctEO... fixtures) {
        AtomicReference<RbBusAcctEO> captured = new AtomicReference<>();
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            RbBusAcctEO condition = invocation.getArgument(0);
            captured.set(condition);
            List<RbBusAcctEO> hits = new ArrayList<>();
            for (RbBusAcctEO fixture : fixtures) {
                if (Objects.equals(fixture.getBaseAcctNo(), condition.getBaseAcctNo())) {
                    hits.add(fixture);
                }
            }
            return hits;
        });
        return captured;
    }

    /**
     * 设桩子步骤 1b：按主键（账户内部键值）返回单条账户记录。
     *
     * @param internalKey 上级账户内部键
     * @param result      回查得到的账户记录
     */
    private void stubAccountByPrimaryKey(Integer internalKey, RbBusAcctEO result) {
        Mockito.lenient().when(rbBusAcctBcc.findByPrimaryKey(internalKey)).thenReturn(result);
    }

    /**
     * 设桩子步骤 3：应答式桩，按入参 EO 的 {@code baseAcctNo} 过滤，入参 {@code restraintsStatus}
     * 非空时再按状态相等过滤（模拟查询条件本身生效，漏传条件将返回多余记录而可失败）。
     *
     * @param fixtures 限制信息夹具
     * @return 捕获到的限制查询条件 EO
     */
    private AtomicReference<RbBusRestraintsEO> stubRestraintsQuery(RbBusRestraintsEO... fixtures) {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(any(RbBusRestraintsEO.class))).thenAnswer(invocation -> {
            RbBusRestraintsEO condition = invocation.getArgument(0);
            captured.set(condition);
            List<RbBusRestraintsEO> hits = new ArrayList<>();
            for (RbBusRestraintsEO fixture : fixtures) {
                if (!Objects.equals(fixture.getBaseAcctNo(), condition.getBaseAcctNo())) {
                    continue;
                }
                if (condition.getRestraintsStatus() != null
                        && fixture.getRestraintsStatus() != condition.getRestraintsStatus()) {
                    continue;
                }
                hits.add(fixture);
            }
            return hits;
        });
        return captured;
    }

    /** 构造一条【账户信息】记录：仅填本步骤使用的账号、主账户标志、上级账户内部键与账户内部键值。 */
    private static RbBusAcctEO acct(Integer internalKey, String baseAcctNo, String leadAcctFlag,
            Integer parentInternalKey) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setInternalKey(internalKey);
        eo.setBaseAcctNo(baseAcctNo);
        eo.setLeadAcctFlag(leadAcctFlag);
        eo.setParentInternalKey(parentInternalKey);
        return eo;
    }

    /** 构造一条【账户限制信息表】记录：仅填本步骤使用的账号、限制编号、账户限制类型与限制状态。 */
    private static RbBusRestraintsEO restraints(String baseAcctNo, String resSeqNo, RestraintType restraintType,
            RestraintsStatus restraintsStatus) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setBaseAcctNo(baseAcctNo);
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(restraintsStatus);
        return eo;
    }

    /** 构造步骤入参（账号）。 */
    private static ST115InputBO input(String baseAcctNo) {
        ST115InputBO input = new ST115InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    /** 断言正常完成：成功且两个错误字段为 null。 */
    private static void assertSucceed(ST115OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** 断言三个限制回显字段为空值。 */
    private static void assertEchoFieldsNull(ST115OutputBO output) {
        assertNull(output.getResSeqNo());
        assertNull(output.getRestraintType());
        assertNull(output.getRestraintsStatus());
    }

    /** 读取类中非静态、非合成声明字段的名称与类型（用于核对输入／输出字段契约）。 */
    private static Map<String, Class<?>> instanceFields(Class<?> type) {
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        for (Field field : type.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !field.isSynthetic()) {
                fields.put(field.getName(), field.getType());
            }
        }
        return fields;
    }

    // ST115-TC001：REQ-001-S01/S02、REQ-002-S01、REQ-004-S02、REQ-005-S01、REQ-005-S03、REQ-008-S02/S03/S04、REQ-009-S01
    // 主账户唯一命中：[待查账户] = {账号}，按该账号命中一条「A-生效」限制记录，回显该条三字段与 1a 记录的账号、主账户标志
    @Test
    void testST115T01() {
        AtomicReference<RbBusAcctEO> acctCondition = stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        // 回查桩仅为使「误执行回查」可观察，正确路径不触达
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraints("6201000000000001", "RS20261009011", RestraintType.VALUE_7, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        // 两个账户输出回显 1a 命中记录（＝上送 {账号}）
        assertEquals("6201000000001234", out.getBaseAcctNo());
        assertEquals("Y", out.getLeadAcctFlag());
        // 若限制查询误用主账户账号，将命中 RS20261009011／VALUE_7 而失败
        assertEquals("RS20261009001", out.getResSeqNo());
        assertSame(RestraintType.VALUE_13, out.getRestraintType());
        assertSame(RestraintsStatus.A, out.getRestraintsStatus());
        // 1a 查询只用账号条件，不附加其它账户字段
        assertEquals("6201000000001234", acctCondition.get().getBaseAcctNo());
        assertNull(acctCondition.get().getLeadAcctFlag());
        assertNull(acctCondition.get().getParentInternalKey());
        assertNull(acctCondition.get().getInternalKey());
        // 限制查询以 [待查账户]（＝入参账号）+ 限制状态码值 "A" 为条件，不附加其它过滤条件
        assertEquals("6201000000001234", captured.get().getBaseAcctNo());
        assertSame(RestraintsStatus.A, captured.get().getRestraintsStatus());
        assertNull(captured.get().getRestraintType());
        assertNull(captured.get().getRestraintLevel());
        assertNull(captured.get().getPledgedAmt());
        assertNull(captured.get().getStartDate());
        assertNull(captured.get().getEndDate());
    }

    // ST115-TC002：REQ-003-S01/S03、REQ-004-S01、REQ-005-S01、REQ-005-S03、REQ-008-S02/S03/S04、REQ-009-S02
    // 非主账户：按上级账户内部键 100200 回查取主账户账号，[待查账户] = 主账户账号，回显主账户账号名下记录；
    // 两个账户输出仍取 1a 命中记录，不取回查记录
    @Test
    void testST115T02() {
        stubAccountQuery(acct(100001, "6201000000001234", "N", 100200));
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraints("6201000000000001", "RS20261009011", RestraintType.VALUE_7, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        // 若两个账户输出误取回查记录，将变为 "6201000000000001"／"Y" 而失败
        assertEquals("6201000000001234", out.getBaseAcctNo());
        assertEquals("N", out.getLeadAcctFlag());
        // 若限制查询误用原 {账号}，将命中 RS20261009001／VALUE_13 而失败
        assertEquals("RS20261009011", out.getResSeqNo());
        assertSame(RestraintType.VALUE_7, out.getRestraintType());
        assertSame(RestraintsStatus.A, out.getRestraintsStatus());
        // $主账户账号$ 取自回查记录的账号字段，并传递为第 3 条查询的账号条件
        assertEquals("6201000000000001", captured.get().getBaseAcctNo());
    }

    // ST115-TC003：REQ-003-S02、REQ-004-S02、REQ-008-S03/S04、REQ-009-S01
    // 是主账户：不执行回查；回查桩与「主账户账号名下记录」仅为使「误执行回查」可观察
    @Test
    void testST115T03() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraints("6201000000000001", "RS20261009011", RestraintType.VALUE_7, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        assertEquals("6201000000001234", out.getBaseAcctNo());
        assertEquals("Y", out.getLeadAcctFlag());
        // 若误执行回查并改用「6201000000000001」取数，回显将变为 RS20261009011／VALUE_7 而失败
        assertEquals("RS20261009001", out.getResSeqNo());
        assertSame(RestraintType.VALUE_13, out.getRestraintType());
        assertSame(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals("6201000000001234", captured.get().getBaseAcctNo());
    }

    // ST115-TC004：REQ-006-S01、REQ-008-S03/S04、REQ-010-S02
    // 该账号名下无任何命中记录（夹具仅他账号）：三字段空值、步骤成功且无错误码，不补默认值；
    // 两个账户输出仍按 1a 命中记录回显
    @Test
    void testST115T04() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        stubRestraintsQuery(
                restraints("6201000000009999", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        assertEchoFieldsNull(out);
        assertEquals("6201000000001234", out.getBaseAcctNo());
        assertEquals("Y", out.getLeadAcctFlag());
    }

    // ST115-TC005：REQ-005-S02、REQ-006-S02、REQ-010-S02
    // 同账号存在记录但状态均非「A-生效」（E、F），且状态非 A 的编号最小：过滤后零条命中，三字段空值
    @Test
    void testST115T05() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009000", RestraintType.VALUE_68, RestraintsStatus.E),
                restraints("6201000000001234", "RS20261009004", RestraintType.VALUE_22, RestraintsStatus.F));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        // 若未按限制状态过滤，将回显编号最小的 RS20261009000／VALUE_68 而失败
        assertEchoFieldsNull(out);
        assertSame(RestraintsStatus.A, captured.get().getRestraintsStatus());
    }

    // ST115-TC006：REQ-007-S01、REQ-007-S02、REQ-010-S02
    // 3 条「A-生效」记录按 003→001→002 返回：按限制编号升序取第一条并回显该条三字段（同源、非拼接）
    @Test
    void testST115T06() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009003", RestraintType.VALUE_68, RestraintsStatus.A),
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraints("6201000000001234", "RS20261009002", RestraintType.VALUE_22, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        assertEquals("RS20261009001", out.getResSeqNo());
        assertSame(RestraintType.VALUE_13, out.getRestraintType());
        assertSame(RestraintsStatus.A, out.getRestraintsStatus());
    }

    // ST115-TC007：REQ-007-S01
    // 依赖返回顺序为降序：取升序第一条与依赖返回顺序无关
    @Test
    void testST115T07() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009002", RestraintType.VALUE_22, RestraintsStatus.A),
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        // 若按返回顺序直接取首条将回显 RS20261009002／VALUE_22 而失败
        assertEquals("RS20261009001", out.getResSeqNo());
        assertSame(RestraintType.VALUE_13, out.getRestraintType());
        assertSame(RestraintsStatus.A, out.getRestraintsStatus());
    }

    // ST115-TC008：REQ-001-S01、REQ-008-S01
    // 输出契约：结果实例为 ST115OutputBO；输入 1 个字段、输出 5 个业务字段，名称与类型符合契约与枚举归属
    @Test
    void testST115T08() {
        stubAccountQuery(acct(100001, "6201000000001234", "Y", 100200));
        stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertInstanceOf(ST115OutputBO.class, out);
        assertTrue(out.isSucceed());
        assertSame(StepResult.class, ST115OutputBO.class.getSuperclass());

        Map<String, Class<?>> expectedInputFields = new LinkedHashMap<>();
        expectedInputFields.put("baseAcctNo", String.class);
        assertEquals(expectedInputFields, instanceFields(ST115InputBO.class));

        Map<String, Class<?>> expectedOutputFields = new LinkedHashMap<>();
        expectedOutputFields.put("baseAcctNo", String.class);
        expectedOutputFields.put("leadAcctFlag", String.class);
        expectedOutputFields.put("resSeqNo", String.class);
        expectedOutputFields.put("restraintType", RestraintType.class);
        expectedOutputFields.put("restraintsStatus", RestraintsStatus.class);
        assertEquals(expectedOutputFields, instanceFields(ST115OutputBO.class));
    }

    // ST115-TC009：REQ-002-S02、REQ-008-S03/S04、REQ-009-S03、REQ-010-S01
    // 账号查无记录 → ER0048 短路：不执行回查、不设置 [待查账户]、不查询限制表、不产出任何回显
    @Test
    void testST115T09() {
        stubAccountQuery(acct(100999, "6201000000009999", "Y", null));
        // 回查桩与限制表 A-生效 夹具仅为使「若错误地继续执行」可观察
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertFalse(out.isSucceed());
        assertEquals("ER0048", out.getErrorCode());
        assertNotNull(out.getErrorMessage());
        assertTrue(out.getErrorMessage().contains("账户不存在"));
        // 无查得记录，两个账户输出无回显来源
        assertNull(out.getBaseAcctNo());
        assertNull(out.getLeadAcctFlag());
        assertEchoFieldsNull(out);
    }

    // ST115-TC010：REQ-002-S03、REQ-008-S03/S04、REQ-009-S03、REQ-010-S01
    // 账号查到多条记录 → 与查无同码 ER0048 短路：不取其中任一条的主账户标志或上级账户内部键，不产出回显
    @Test
    void testST115T10() {
        stubAccountQuery(
                acct(100001, "6201000000001234", "Y", null),
                acct(100002, "6201000000001234", "N", 100200));
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertFalse(out.isSucceed());
        assertEquals("ER0048", out.getErrorCode());
        assertNotNull(out.getErrorMessage());
        assertTrue(out.getErrorMessage().contains("账户不存在"));
        // 不据 2 条中的任一条回显账户字段
        assertNull(out.getBaseAcctNo());
        assertNull(out.getLeadAcctFlag());
        assertEchoFieldsNull(out);
    }

    // ST115-TC011：REQ-004-S01、REQ-006-S01、REQ-008-S03/S04
    // 非主账户路径下限制查询零条命中：[待查账户]＝主账户账号但主账户名下无「A-生效」记录，
    // 三个限制字段空值，两个账户输出仍取 1a 命中记录（不取回查记录）
    @Test
    void testST115T11() {
        stubAccountQuery(acct(100001, "6201000000001234", "N", 100200));
        stubAccountByPrimaryKey(100200, acct(100200, "6201000000000001", "Y", null));
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(
                restraints("6201000000001234", "RS20261009001", RestraintType.VALUE_13, RestraintsStatus.A));

        ST115OutputBO out = step.execute(input("6201000000001234"));

        assertSucceed(out);
        // 若误用原 {账号} 取数将回显 RS20261009001／VALUE_13 而失败
        assertEchoFieldsNull(out);
        // 零条命中路径下两个账户输出仍取 1a 命中记录
        assertEquals("6201000000001234", out.getBaseAcctNo());
        assertEquals("N", out.getLeadAcctFlag());
        assertEquals("6201000000000001", captured.get().getBaseAcctNo());
    }
}

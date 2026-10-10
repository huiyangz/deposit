package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST118InputBO;
import com.dcits.depsit.facade.bo.ST118OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST118 检查是否存在现金止收限制 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（ST118-TC001 ~ ST118-TC008），期望值取自正式 Spec。</p>
 *
 * <p>步骤 2 的取用方式源需求未区分（Spec「依赖的数据访问契约」同时列出按主键取单条的
 * {@code findByRestraintType} 与条件查询 {@code findByEo}），本测试以 {@code findByRestraintType}
 * 为主桩，并以 {@code lenient()} 对 {@code findByEo} 设同数据备用桩，两种取用方式下断言一致。</p>
 *
 * <p>本步骤无业务失败场景（Spec REQ-006），无错误码路径可覆盖；否定性交互（零条时不查询
 * 限制类型表、命中后不再判断其余限制）按技能要求不使用 {@code verify}/{@code never}/{@code times}，
 * 以最终输出体现。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST118PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST118Pbc step;

    /**
     * 设桩步骤 1：捕获查询入参并返回给定的限制信息记录。
     *
     * @param records 步骤 1 返回的限制信息记录（无参表示零条）
     * @return 捕获到的查询条件 EO
     */
    private AtomicReference<RbBusRestraintsEO> stubRestraintsQuery(RbBusRestraintsEO... records) {
        AtomicReference<RbBusRestraintsEO> captured = new AtomicReference<>();
        doAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return Arrays.asList(records);
        }).when(rbBusRestraintsBcc).findByEo(any(RbBusRestraintsEO.class));
        return captured;
    }

    /**
     * 设桩步骤 2：主桩为按账户限制类型取单条的 {@code findByRestraintType}，
     * 并以 {@code lenient()} 备用桩 {@code findByEo} 返回同数据（源需求未区分取用方式）。
     *
     * @param configs 账户限制类型到限制类型配置的映射，值为 {@code null} 表示该类型无记录
     */
    private void stubRestraintTypeConfigs(Map<RestraintType, RbRestraintTypeEO> configs) {
        configs.forEach((type, config) -> when(rbRestraintTypeBcc.findByRestraintType(type)).thenReturn(config));
        lenient().when(rbRestraintTypeBcc.findByEo(any(RbRestraintTypeEO.class))).thenAnswer(invocation -> {
            RbRestraintTypeEO query = invocation.getArgument(0);
            RbRestraintTypeEO config = configs.get(query.getRestraintType());
            return config == null ? Collections.emptyList() : Collections.singletonList(config);
        });
    }

    /** 构造一条【账户限制信息】记录。 */
    private static RbBusRestraintsEO restraints(String resSeqNo, RestraintType restraintType) {
        RbBusRestraintsEO eo = new RbBusRestraintsEO();
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(RestraintsStatus.A);
        return eo;
    }

    /** 构造一条【限制类型表】配置。 */
    private static RbRestraintTypeEO config(RestraintType restraintType, Status status, DrCrCtlFlag drCrCtlFlag,
            String cashFlag) {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(restraintType);
        eo.setStatus(status);
        eo.setDrCrCtlFlag(drCrCtlFlag);
        eo.setCashFlag(cashFlag);
        return eo;
    }

    /** 构造步骤入参（账号）。 */
    private static ST118InputBO input(String baseAcctNo) {
        ST118InputBO input = new ST118InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    /** 断言成功且无错误码、错误信息。 */
    private static void assertSucceed(ST118OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** 断言三个回显字段为空值。 */
    private static void assertEchoFieldsNull(ST118OutputBO output) {
        assertNull(output.getResSeqNo());
        assertNull(output.getRestraintType());
        assertNull(output.getRestraintsStatus());
    }

    /** 读取类中非静态声明字段的名称与类型。 */
    private static Map<String, Class<?>> instanceFields(Class<?> type) {
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        for (Field field : type.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                fields.put(field.getName(), field.getType());
            }
        }
        return fields;
    }

    /** REQ-001-S01 + REQ-002-S01 + REQ-003-S01 + REQ-005-S01：单条生效限制命中 C+N 配置，返回「是」并回填七个输出。 */
    @Test
    void testST118T01() {
        RbBusRestraintsEO record = restraints("R202610100001", RestraintType.VALUE_17);
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery(record);
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_17, config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("是", out.getCashStopCreditFlag());
        assertEquals("R202610100001", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals(Status.A, out.getStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals("N", out.getCashFlag());
        assertEquals("6222020200112233", captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
    }

    /** REQ-004-S01 + REQ-003-S02：2 条限制逐条判断，第 1 条现金标志非「N」不满足，第 2 条命中并回显第 2 条。 */
    @Test
    void testST118T02() {
        stubRestraintsQuery(restraints("R202610100001", RestraintType.VALUE_4),
                restraints("R202610100002", RestraintType.VALUE_17));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.C, "Y"));
        configs.put(RestraintType.VALUE_17, config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("是", out.getCashStopCreditFlag());
        assertEquals("R202610100002", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_17, out.getRestraintType());
        assertEquals(RestraintsStatus.A, out.getRestraintsStatus());
        assertEquals("N", out.getCashFlag());
    }

    /** REQ-003-S03：第 1 条现金标志为「N」但借贷方控制标志为「A」不满足（合取判定），第 2 条命中返回「是」。 */
    @Test
    void testST118T03() {
        stubRestraintsQuery(restraints("R202610100003", RestraintType.VALUE_4),
                restraints("R202610100004", RestraintType.VALUE_5));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.A, "N"));
        configs.put(RestraintType.VALUE_5, config(RestraintType.VALUE_5, Status.A, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("是", out.getCashStopCreditFlag());
        assertEquals("R202610100004", out.getResSeqNo());
        assertEquals(RestraintType.VALUE_5, out.getRestraintType());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals("N", out.getCashFlag());
    }

    /** REQ-002-S02：第 1 条限制类型无 A-生效 配置（状态为 F），不提前返回「否」，继续判断并命中第 2 条。 */
    @Test
    void testST118T04() {
        stubRestraintsQuery(restraints("R202610100005", RestraintType.VALUE_4),
                restraints("R202610100006", RestraintType.VALUE_17));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.F, DrCrCtlFlag.C, "N"));
        configs.put(RestraintType.VALUE_17, config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("是", out.getCashStopCreditFlag());
        assertEquals("R202610100006", out.getResSeqNo());
        assertEquals(Status.A, out.getStatus());
        assertEquals(DrCrCtlFlag.C, out.getDrCrCtlFlag());
        assertEquals("N", out.getCashFlag());
    }

    /** REQ-001-S02 + REQ-004-S02 + REQ-005-S03：3 条生效限制逐条均不满足，返回「否」且三个回显字段为空值。 */
    @Test
    void testST118T05() {
        AtomicReference<RbBusRestraintsEO> captured =
                stubRestraintsQuery(restraints("R202610100007", RestraintType.VALUE_4),
                        restraints("R202610100008", RestraintType.VALUE_5),
                        restraints("R202610100009", RestraintType.VALUE_17));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_4, config(RestraintType.VALUE_4, Status.A, DrCrCtlFlag.A, "N"));
        configs.put(RestraintType.VALUE_5, config(RestraintType.VALUE_5, Status.A, DrCrCtlFlag.C, "Y"));
        configs.put(RestraintType.VALUE_17, config(RestraintType.VALUE_17, Status.F, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("否", out.getCashStopCreditFlag());
        assertEchoFieldsNull(out);
        assertEquals("6222020200112233", captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
    }

    /** REQ-001-S03 + REQ-005-S02：该账号未查询到生效的限制信息（零条），直接返回「否」且七个输出均无业务取值。 */
    @Test
    void testST118T06() {
        AtomicReference<RbBusRestraintsEO> captured = stubRestraintsQuery();

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("否", out.getCashStopCreditFlag());
        assertEchoFieldsNull(out);
        assertNull(out.getStatus());
        assertNull(out.getDrCrCtlFlag());
        assertNull(out.getCashFlag());
        assertEquals("6222020200112233", captured.get().getBaseAcctNo());
        assertEquals(RestraintsStatus.A, captured.get().getRestraintsStatus());
    }

    /** REQ-005 + REQ-005-S04：单条 A+N 不满足返回「否」，并核对输入输出字段契约（1 个入参、7 个输出）。 */
    @Test
    void testST118T07() {
        stubRestraintsQuery(restraints("R202610100010", RestraintType.VALUE_17));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_17, config(RestraintType.VALUE_17, Status.A, DrCrCtlFlag.A, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("否", out.getCashStopCreditFlag());
        assertInstanceOf(String.class, out.getCashStopCreditFlag());
        assertNotNull(out.getCashStopCreditFlag());
        assertEchoFieldsNull(out);

        Map<String, Class<?>> expectedInputFields = new LinkedHashMap<>();
        expectedInputFields.put("baseAcctNo", String.class);
        assertEquals(expectedInputFields, instanceFields(ST118InputBO.class));

        Map<String, Class<?>> expectedOutputFields = new LinkedHashMap<>();
        expectedOutputFields.put("resSeqNo", String.class);
        expectedOutputFields.put("restraintType", RestraintType.class);
        expectedOutputFields.put("restraintsStatus", RestraintsStatus.class);
        expectedOutputFields.put("status", Status.class);
        expectedOutputFields.put("drCrCtlFlag", DrCrCtlFlag.class);
        expectedOutputFields.put("cashFlag", String.class);
        expectedOutputFields.put("cashStopCreditFlag", String.class);
        assertEquals(expectedOutputFields, instanceFields(ST118OutputBO.class));
    }

    /** REQ-002 + REQ-004：全部账户限制类型均无 A-生效 配置（无记录与状态非 A 两种形态），返回「否」。 */
    @Test
    void testST118T08() {
        stubRestraintsQuery(restraints("R202610100011", RestraintType.VALUE_4),
                restraints("R202610100012", RestraintType.VALUE_5));
        Map<RestraintType, RbRestraintTypeEO> configs = new LinkedHashMap<>();
        configs.put(RestraintType.VALUE_4, null);
        configs.put(RestraintType.VALUE_5, config(RestraintType.VALUE_5, Status.F, DrCrCtlFlag.C, "N"));
        stubRestraintTypeConfigs(configs);

        ST118OutputBO out = step.execute(input("6222020200112233"));

        assertSucceed(out);
        assertEquals("否", out.getCashStopCreditFlag());
        assertEchoFieldsNull(out);
    }
}

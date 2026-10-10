package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST101InputBO;
import com.dcits.depsit.facade.bo.ST101OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.components.IRbLimitCtrlCustomInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.depsit.facade.eo.RbLimitCtrlCustomInfoEO;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST101 获取限额场景编码的单元测试。
 *
 * <p>调用签名：{@code ST101OutputBO execute(ST101InputBO input)}，被测实例 {@link ST101Pbc}；
 * 依赖 {@link IRbLimitCtrlConfBcc}（子步骤1 按 [限额场景编码] 单键查询）与
 * {@link IRbLimitCtrlCustomInfoBcc}（子步骤3 按 [客户号]＋[限额场景编码] 定位）两个 BCC，
 * 均按 Spec 指定的查询载体 {@code findByEo} 设桩。</p>
 *
 * <p>全部用例只通过 {@code execute} 的业务结果断言路径，不校验交互次数与顺序；本步骤无业务失败场景，
 * 技术异常（REQ-012-S02）不在 Mock 用例中模拟。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST101PbcTest {

    /** 用例中的示例账号。 */
    private static final String BASE_ACCT_NO = "1100602112345678";

    /** 用例中的示例客户号。 */
    private static final String CLIENT_NO = "C0000001234";

    /** 用例中的示例限额场景编码。 */
    private static final String LIMIT_SCENE_NO = "LSN0001";

    /** 配置记录的时间戳列取值。 */
    private static final String TIMESTAMP = "20261001000000000000000001";

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @Mock
    private IRbLimitCtrlCustomInfoBcc rbLimitCtrlCustomInfoBcc;

    @InjectMocks
    private ST101Pbc pbc;

    // ST101-TC001：REQ-002-S01、REQ-005-S01、REQ-008-S01、REQ-011-S01 主成功路径——命中唯一配置（Y／N）
    // 且允许自定义标识非 N 故进入子步骤3，命中一条生效日期不晚于交易日期的 [自定义限额]（临时限额标志 N），
    // 判定项 2 返回场景编码；同时核对输出取值映射与读取到的记录未被改写
    @Test
    void testST101T01() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals("Y", output.getAllowCustomFlag());
        assertEquals("N", output.getOnlyCustom());
        assertEquals("N", output.getTempLimitFlag());
        assertEquals(day(Calendar.SEPTEMBER, 1), output.getEffectDate());
        assertEquals(day(Calendar.SEPTEMBER, 30), output.getExpireDate());
        // 只读：读取到的记录字段未被改写
        assertEquals("Y", confRec.getAllowCustomFlag());
        assertEquals("N", customRec.getTempLimitFlag());
    }

    // ST101-TC002：REQ-005-S03 子步骤3 命中两条满足「生效日期小于等于交易日期」的记录，
    // 取生效日期离交易日期最近的一条作为 [自定义限额]，另一条不得被取用
    @Test
    void testST101T02() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO recAlpha = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 15), "N");
        RbLimitCtrlCustomInfoEO recBeta = customRecord(CLIENT_NO + "-B", CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.OCTOBER, 1), day(Calendar.SEPTEMBER, 25), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(recAlpha, recBeta));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        // 取 recBeta；若误取 recAlpha 则为 2026-09-01／2026-09-15，断言失败
        assertEquals(day(Calendar.OCTOBER, 1), output.getEffectDate());
        assertEquals(day(Calendar.SEPTEMBER, 25), output.getExpireDate());
    }

    // ST101-TC003：REQ-007-S01、REQ-011-S01 判定项 1 的未失效分支——临时限额标志 Y 且交易日期早于失效日期，
    // 返回场景编码并带出 [自定义限额] 的取值
    @Test
    void testST101T03() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.NOVEMBER, 30), "Y");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals(day(Calendar.SEPTEMBER, 1), output.getEffectDate());
        assertEquals(day(Calendar.NOVEMBER, 30), output.getExpireDate());
        assertEquals("Y", output.getTempLimitFlag());
    }

    // ST101-TC004：REQ-010-S01、REQ-011-S02 子步骤3 查无记录（空集合）且仅检查客户自定义标志为 N，
    // 判定项 4 返回场景编码；[自定义限额] 派生字段无取值来源
    @Test
    void testST101T04() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of());

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals("Y", output.getAllowCustomFlag());
        assertEquals("N", output.getOnlyCustom());
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
    }

    // ST101-TC005：REQ-001-S01 输入契约——输入 BO 的业务字段名与类型按「## 输入」表照录（4 个字段）；
    // 「必填」标记取空行为未定义，故不断言校验规则
    @Test
    void testST101T05() {
        Map<String, Class<?>> fields = declaredBusinessFields(ST101InputBO.class);

        assertEquals(Set.of("baseAcctNo", "clientNo", "limitSceneNo", "tranDate"), fields.keySet());
        assertEquals(String.class, fields.get("baseAcctNo"));
        assertEquals(String.class, fields.get("clientNo"));
        assertEquals(String.class, fields.get("limitSceneNo"));
        assertEquals(Date.class, fields.get("tranDate"));
    }

    // ST101-TC006：REQ-011、REQ-011-S03 输出契约——输出表 11 行按字段名照录（同名两行合并为 1 个字段，
    // 共 9 个业务字段）、不新增表外字段；值来源未定义的字段只断言名与类型
    @Test
    void testST101T06() {
        Map<String, Class<?>> fields = declaredBusinessFields(ST101OutputBO.class);

        assertEquals(9, fields.size());
        assertEquals(Set.of("limitSceneNo", "allowCustomFlag", "onlyCustom", "tempLimitFlag",
                "tempLimitValidTerm", "effectDate", "expireDate", "baseAcctNo", "clientNo"),
                fields.keySet());
        assertEquals(String.class, fields.get("limitSceneNo"));
        assertEquals(String.class, fields.get("allowCustomFlag"));
        assertEquals(String.class, fields.get("onlyCustom"));
        assertEquals(String.class, fields.get("tempLimitFlag"));
        assertEquals(String.class, fields.get("tempLimitValidTerm"));
        assertEquals(Date.class, fields.get("effectDate"));
        assertEquals(Date.class, fields.get("expireDate"));
        assertEquals(String.class, fields.get("baseAcctNo"));
        assertEquals(String.class, fields.get("clientNo"));
        assertTrue(StepResult.class.isAssignableFrom(ST101OutputBO.class));
    }

    // ST101-TC007：REQ-001-S03 baseAcctNo 未被「## 步骤描述」使用——同一其它入参下换用不同的 baseAcctNo，
    // 两次执行结果逐字段一致
    @Test
    void testST101T07() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO first = pbc.execute(input(BASE_ACCT_NO));
        ST101OutputBO second = pbc.execute(input("9999000011112222"));

        assertTrue(first.isSucceed());
        assertTrue(second.isSucceed());
        assertEquals(first.getErrorCode(), second.getErrorCode());
        assertEquals(first.getLimitSceneNo(), second.getLimitSceneNo());
        assertEquals(LIMIT_SCENE_NO, second.getLimitSceneNo());
        assertEquals(first.getEffectDate(), second.getEffectDate());
        assertEquals(day(Calendar.SEPTEMBER, 1), second.getEffectDate());
        assertEquals(day(Calendar.SEPTEMBER, 30), second.getExpireDate());
        assertEquals("N", second.getTempLimitFlag());
    }

    // ST101-TC008：REQ-004-S01、REQ-004-S02 子步骤2 的返回分支——允许自定义标识为 N 时返回场景编码（入参值），
    // 不进入子步骤3／子步骤4；判定按码值 N，不依赖「-否」含义后缀
    @Test
    void testST101T08() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "N", "Y", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        // lenient：提前返回成立时该桩不被使用，避免 UnnecessaryStubbingException 造成假失败；
        // 仅用于使「未进入子步骤3」在结果上可证伪
        lenient().when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals("N", output.getAllowCustomFlag());
        assertEquals("Y", output.getOnlyCustom());
        // 子步骤3 未执行；若误进入则 effectDate 为 2026-09-01，断言失败
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
        assertNull(output.getTempLimitFlag());
    }

    // ST101-TC009：REQ-004-S02 的补集语义、REQ-005-S01——允许自定义标识取非「Y」「N」的其它值 X 时视为非 N，
    // 跳转至子步骤3 并按其结果返回
    @Test
    void testST101T09() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "X", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        // 子步骤3 确被执行
        assertEquals(day(Calendar.SEPTEMBER, 1), output.getEffectDate());
        assertEquals("N", output.getTempLimitFlag());
    }

    // ST101-TC010：REQ-001-S02、REQ-002-S02、REQ-005-S02 定位键与占位符绑定——子步骤1 仅以 limitSceneNo
    // 单键定位、子步骤3 以 clientNo＋limitSceneNo 两键定位；不匹配定位键的记录不被取用
    @Test
    void testST101T10() {
        List<RbLimitCtrlConfEO> confCandidates = List.of(
                confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001),
                confRecord("LSN0009", "N", "N", TranBranch.VALUE_351002));
        AtomicReference<RbLimitCtrlConfEO> capturedConfEo = new AtomicReference<>();
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenAnswer(invocation -> {
            RbLimitCtrlConfEO query = invocation.getArgument(0);
            capturedConfEo.set(query);
            return confCandidates.stream()
                    .filter(record -> query.getLimitSceneNo() == null
                            || query.getLimitSceneNo().equals(record.getLimitSceneNo()))
                    .collect(Collectors.toList());
        });

        List<RbLimitCtrlCustomInfoEO> customCandidates = List.of(
                customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                        day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "N"),
                customRecord("C0000009999", "C0000009999", LIMIT_SCENE_NO,
                        day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "Y"),
                customRecord(CLIENT_NO + "-G", CLIENT_NO, "LSN0009",
                        day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "Y"));
        AtomicReference<RbLimitCtrlCustomInfoEO> capturedCustomEo = new AtomicReference<>();
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenAnswer(invocation -> {
            RbLimitCtrlCustomInfoEO query = invocation.getArgument(0);
            capturedCustomEo.set(query);
            return customCandidates.stream()
                    .filter(record -> query.getClientNo() == null
                            || query.getClientNo().equals(record.getClientNo()))
                    .filter(record -> query.getLimitSceneNo() == null
                            || query.getLimitSceneNo().equals(record.getLimitSceneNo()))
                    .collect(Collectors.toList());
        });

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        // 仅 recAlpha 可被取用（recBeta 客户号不同、recGamma 场景编码不同）
        assertEquals("N", output.getTempLimitFlag());
        // 子步骤1 的请求 EO 只带限额场景编码，其余条件字段均为空；该表 EO 不承载客户号（无 CLIENT_NO 列），
        // 故客户号不可能成为子步骤1 的定位条件
        assertEquals(LIMIT_SCENE_NO, capturedConfEo.get().getLimitSceneNo());
        assertNull(capturedConfEo.get().getAllowCustomFlag());
        assertNull(capturedConfEo.get().getOnlyCustom());
        // 子步骤3 的请求 EO 带两个定位键；生效日期条件施加于命中记录，不以等值条件缩小查询
        assertEquals(CLIENT_NO, capturedCustomEo.get().getClientNo());
        assertEquals(LIMIT_SCENE_NO, capturedCustomEo.get().getLimitSceneNo());
        assertNull(capturedCustomEo.get().getEffectDate());
    }

    // ST101-TC011：REQ-008-S02 判定项 2 的「包括为空」分支——临时限额标志为空且失效日期已早于交易日期，
    // 仍返回场景编码（本分支不检查失效日期）
    @Test
    void testST101T11() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), null);
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals(day(Calendar.SEPTEMBER, 30), output.getExpireDate());
        assertNull(output.getTempLimitFlag());
    }

    // ST101-TC012：REQ-007-S02 判定项 1 的相等边界——交易日期等于失效日期时不满足「交易日期大于失效日期」，
    // 命中「小于等于」分支返回场景编码
    @Test
    void testST101T12() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.OCTOBER, 10), "Y");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals(day(Calendar.OCTOBER, 10), output.getExpireDate());
        assertEquals("Y", output.getTempLimitFlag());
    }

    // ST101-TC013：REQ-007-S03 判定项 1 的空值分支——临时限额标志 Y 且失效日期为空，不视为已失效，
    // 返回场景编码
    @Test
    void testST101T13() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), null, "Y");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertEquals(day(Calendar.SEPTEMBER, 1), output.getEffectDate());
        assertNull(output.getExpireDate());
        assertEquals("Y", output.getTempLimitFlag());
    }

    // ST101-TC014：REQ-006-S01、REQ-011-S02 判定项 1 的失效分支——临时限额标志 Y 且交易日期大于失效日期，
    // 返回场景编码为空；该情形正常结束、不返回业务错误码
    @Test
    void testST101T14() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "Y");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
        assertEquals("Y", output.getAllowCustomFlag());
        assertEquals("N", output.getOnlyCustom());
        assertEquals(day(Calendar.SEPTEMBER, 1), output.getEffectDate());
        assertEquals(day(Calendar.SEPTEMBER, 30), output.getExpireDate());
        assertEquals("Y", output.getTempLimitFlag());
    }

    // ST101-TC015：REQ-006-S02 存在路径的分支优先级——已失效时仅检查客户自定义标志为 N，
    // 也不得改按判定项 4 返回场景编码
    @Test
    void testST101T15() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "N", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.SEPTEMBER, 1), day(Calendar.SEPTEMBER, 30), "Y");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        // 若误按判定项 4 返回则为 LSN0001，断言失败
        assertNull(output.getLimitSceneNo());
        assertEquals("N", output.getOnlyCustom());
    }

    // ST101-TC016：REQ-005-S04、REQ-009-S02 子步骤3 只存在生效日期晚于交易日期的记录，
    // [自定义限额] 视为不存在；仅检查客户自定义标志为 Y，判定项 3 返回场景编码为空
    @Test
    void testST101T16() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "Y", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                day(Calendar.NOVEMBER, 1), null, "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getLimitSceneNo());
        assertEquals("Y", output.getOnlyCustom());
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
    }

    // ST101-TC017：REQ-005-S04、REQ-009-S02 子步骤3 只存在生效日期为空的记录——不满足
    // 「生效日期小于等于交易日期」、不参与候选，[自定义限额] 视为不存在；返回为空
    @Test
    void testST101T17() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "Y", TranBranch.VALUE_351001);
        RbLimitCtrlCustomInfoEO customRec = customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                null, day(Calendar.SEPTEMBER, 30), "N");
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRec));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getLimitSceneNo());
        assertNull(output.getEffectDate());
        assertEquals("Y", output.getOnlyCustom());
    }

    // ST101-TC018：REQ-009-S01、REQ-011-S02 子步骤3 查无记录（空集合）且仅检查客户自定义标志为 Y，
    // 判定项 3 返回场景编码为空
    @Test
    void testST101T18() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", "Y", TranBranch.VALUE_351001);
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of());

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
        assertEquals("Y", output.getAllowCustomFlag());
        assertEquals("Y", output.getOnlyCustom());
        assertNull(output.getEffectDate());
    }

    // ST101-TC019：REQ-010-S02 判定项 4 的「包括为空」分支——子步骤3 查无记录且仅检查客户自定义标志为空，
    // 返回场景编码
    @Test
    void testST101T19() {
        RbLimitCtrlConfEO confRec = confRecord(LIMIT_SCENE_NO, "Y", null, TranBranch.VALUE_351001);
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of(confRec));
        when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of());

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals(LIMIT_SCENE_NO, output.getLimitSceneNo());
        assertNull(output.getOnlyCustom());
        assertEquals("Y", output.getAllowCustomFlag());
    }

    // ST101-TC020：REQ-003-S01、REQ-003-S03、REQ-012-S01 子步骤1 查询到多条配置记录，
    // 返回场景编码为空并不再执行子步骤2～4；多条不判为失败
    @Test
    void testST101T20() {
        RbLimitCtrlConfEO confRec1 = confRecord(LIMIT_SCENE_NO, "Y", "Y", TranBranch.VALUE_351001);
        RbLimitCtrlConfEO confRec2 = confRecord(LIMIT_SCENE_NO, "N", "N", TranBranch.VALUE_351002);
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(confRec1, confRec2));
        // lenient：提前返回成立时该桩不被使用，仅用于使「未进入子步骤3」在结果上可证伪
        lenient().when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                        day(Calendar.SEPTEMBER, 1), day(Calendar.NOVEMBER, 30), "N")));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getLimitSceneNo());
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
    }

    // ST101-TC021：REQ-003-S02、REQ-003-S03、REQ-011-S02、REQ-012-S01 子步骤1 查询不到配置记录，
    // 返回场景编码为空并不再执行子步骤2～4；查无不判为失败、不返回业务错误码
    @Test
    void testST101T21() {
        when(rbLimitCtrlConfBcc.findByEo(any(RbLimitCtrlConfEO.class))).thenReturn(List.of());
        // lenient：提前返回成立时该桩不被使用，仅用于使「未进入子步骤3」在结果上可证伪
        lenient().when(rbLimitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class)))
                .thenReturn(List.of(customRecord(CLIENT_NO, CLIENT_NO, LIMIT_SCENE_NO,
                        day(Calendar.SEPTEMBER, 1), day(Calendar.NOVEMBER, 30), "N")));

        ST101OutputBO output = pbc.execute(input(BASE_ACCT_NO));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
    }

    /**
     * 构造用例输入：交易日期固定为 2026-10-10，客户号与限额场景编码取用例示例值。
     */
    private static ST101InputBO input(String baseAcctNo) {
        ST101InputBO input = new ST101InputBO();
        input.setBaseAcctNo(baseAcctNo);
        input.setClientNo(CLIENT_NO);
        input.setLimitSceneNo(LIMIT_SCENE_NO);
        input.setTranDate(day(Calendar.OCTOBER, 10));
        return input;
    }

    /**
     * 构造 2026 年指定月日的交易日期（时分秒为 0），用于比较边界取同一时刻。
     */
    private static Date day(int month, int dayOfMonth) {
        return new GregorianCalendar(2026, month, dayOfMonth).getTime();
    }

    /**
     * 构造【限额控制配置表】记录（REQ-002 定位键与两项标志）。
     */
    private static RbLimitCtrlConfEO confRecord(String limitSceneNo, String allowCustomFlag,
            String onlyCustom, TranBranch limitBranchId) {
        RbLimitCtrlConfEO record = new RbLimitCtrlConfEO();
        record.setLimitSceneNo(limitSceneNo);
        record.setAllowCustomFlag(allowCustomFlag);
        record.setOnlyCustom(onlyCustom);
        record.setLimitBranchId(limitBranchId);
        record.setCreateTimestamp(TIMESTAMP);
        record.setLastUpdTimestamp(TIMESTAMP);
        return record;
    }

    /**
     * 构造【限额控制客户自定义配置表】记录（子步骤3 的定位键与 REQ-005～REQ-008 所用取值）。
     */
    private static RbLimitCtrlCustomInfoEO customRecord(String checkObjVal, String clientNo,
            String limitSceneNo, Date effectDate, Date expireDate, String tempLimitFlag) {
        RbLimitCtrlCustomInfoEO record = new RbLimitCtrlCustomInfoEO();
        record.setCheckObjVal(checkObjVal);
        record.setClientNo(clientNo);
        record.setLimitSceneNo(limitSceneNo);
        record.setEffectDate(effectDate);
        record.setExpireDate(expireDate);
        record.setTempLimitFlag(tempLimitFlag);
        return record;
    }

    /**
     * 反射读取类型自身声明的业务字段（排除 static 与合成字段）的名字与类型。
     */
    private static Map<String, Class<?>> declaredBusinessFields(Class<?> type) {
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        for (Field field : type.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.isSynthetic()) {
                continue;
            }
            fields.put(field.getName(), field.getType());
        }
        return fields;
    }
}

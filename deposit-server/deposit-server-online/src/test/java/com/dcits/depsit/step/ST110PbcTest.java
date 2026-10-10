package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.dcits.depsit.facade.bo.ST110InputBO;
import com.dcits.depsit.facade.bo.ST110OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST110 更新累计限额的单元测试。
 *
 * <p>调用签名：{@code ST110OutputBO execute(ST110InputBO input)}；依赖仅
 * {@link IRbLimitSumInfoBcc}（定位 {@code findByPrimaryKey(checkObjVal, limitSceneNo)}、
 * 写回 {@code modifyByPrimaryKeySelective(eo)}）。本步骤无业务错误码与跳转分支。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST110PbcTest {

    /** 测试账号（限额检查对象值）。 */
    private static final String ACCT_NO = "1100602112345678";

    /** 另一测试账号（状态 B 用）。 */
    private static final String ACCT_NO_B = "1100602112345677";

    /** 未命中定位的测试账号。 */
    private static final String ACCT_NO_MISS = "1100609999999999";

    /** 测试限额场景编码。 */
    private static final String SCENE_NO = "LSN0001";

    /** 测试客户号（REQ-003：不参与定位，也不被写入）。 */
    private static final String CLIENT_NO = "C0000001234";

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @InjectMocks
    private ST110Pbc st110Pbc;

    // ST110-TC001：REQ-002-S01（金额=1000.00>0、笔数=0 ⇒ 仅「或者」左支成立即触发）+ REQ-003-S01 命中写回两列 + REQ-005-S01 输出＝写入值；覆盖 REQ-001-S01／S02 输入契约与占位符绑定
    @Test
    void testST110T01() {
        RbLimitSumInfoEO record = new RbLimitSumInfoEO();
        record.setCheckObjVal(ACCT_NO);
        record.setLimitSceneNo(SCENE_NO);
        record.setLimitSumAmt(new BigDecimal("300.00"));
        record.set否(Integer.valueOf(2));
        record.setLimitSumContent("日累计限额");
        record.setClientNo(CLIENT_NO);
        record.setReference("REF0001");
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO, SCENE_NO)).thenReturn(record);

        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(0));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 写入 EO：两键与两列被写回，其余属性保持为空（写入字段范围仅这两列）
        assertNotNull(updateArg.get());
        assertEquals(ACCT_NO, updateArg.get().getCheckObjVal());
        assertEquals(SCENE_NO, updateArg.get().getLimitSceneNo());
        assertNotNull(updateArg.get().getLimitSumAmt());
        assertEquals(0, updateArg.get().getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        // 笔数取 0 仍须写回（两列 MUST 均被写回），且触发仅靠金额>0 这一支
        assertEquals(Integer.valueOf(0), updateArg.get().get否());
        assertNull(updateArg.get().getClientNo());
        assertNull(updateArg.get().getLimitSumContent());
        assertNull(updateArg.get().getEffectDate());
        assertNull(updateArg.get().getExpireDate());
        assertNull(updateArg.get().getTranCcy());
        assertNull(updateArg.get().getPreReference());
        assertNull(updateArg.get().getReference());
        assertNull(updateArg.get().getCreateTimestamp());
        assertNull(updateArg.get().getLastUpdTimestamp());
        // 输出＝本次写入的限额累计金额，不是记录原值 300.00
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
    }

    // ST110-TC002：REQ-002-S02（笔数>0 右支）+ REQ-003-S01：金额取值为 0 也须写回，验证「两列 MUST 均被写回」
    @Test
    void testST110T02() {
        RbLimitSumInfoEO record = new RbLimitSumInfoEO();
        record.setCheckObjVal(ACCT_NO);
        record.setLimitSceneNo("LSN0002");
        record.setLimitSumAmt(new BigDecimal("88.88"));
        record.set否(Integer.valueOf(9));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO, "LSN0002")).thenReturn(record);

        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO, "LSN0002",
                new BigDecimal("0.00"), Integer.valueOf(3));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNotNull(updateArg.get());
        assertNotNull(updateArg.get().getLimitSumAmt());
        assertEquals(0, updateArg.get().getLimitSumAmt().compareTo(new BigDecimal("0.00")));
        assertEquals(Integer.valueOf(3), updateArg.get().get否());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("0.00")));
    }

    // ST110-TC003：REQ-002-S03 两个数值均大于 0（「或者」两支同真）不改变触发结论与写入取值
    @Test
    void testST110T03() {
        RbLimitSumInfoEO record = new RbLimitSumInfoEO();
        record.setCheckObjVal(ACCT_NO);
        record.setLimitSceneNo(SCENE_NO);
        record.setLimitSumAmt(new BigDecimal("0.00"));
        record.set否(Integer.valueOf(0));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO, SCENE_NO)).thenReturn(record);

        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO, SCENE_NO,
                new BigDecimal("2500.50"), Integer.valueOf(7));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNotNull(updateArg.get());
        assertNotNull(updateArg.get().getLimitSumAmt());
        assertEquals(0, updateArg.get().getLimitSumAmt().compareTo(new BigDecimal("2500.50")));
        assertEquals(Integer.valueOf(7), updateArg.get().get否());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("2500.50")));
    }

    // ST110-TC004：REQ-003-S02 定位条件为「限额检查对象值＝baseAcctNo」与「限额场景编码＝limitSceneNo」的合取，只有记录 α 被写入
    @Test
    void testST110T04() {
        RbLimitSumInfoEO alpha = new RbLimitSumInfoEO();
        alpha.setCheckObjVal(ACCT_NO);
        alpha.setLimitSceneNo(SCENE_NO);
        alpha.setLimitSumAmt(new BigDecimal("300.00"));
        alpha.set否(Integer.valueOf(2));
        // 记录 β（同对象值、异场景编码）与 γ（异对象值、同场景编码）不构成返回
        AtomicReference<String[]> findArgs = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    String checkObjVal = invocation.getArgument(0);
                    String limitSceneNo = invocation.getArgument(1);
                    findArgs.set(new String[] {checkObjVal, limitSceneNo});
                    return ACCT_NO.equals(checkObjVal) && SCENE_NO.equals(limitSceneNo) ? alpha : null;
                });

        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(5));
        ST110OutputBO result = st110Pbc.execute(input);

        // 定位入参恰为（baseAcctNo, limitSceneNo），不含 clientNo 等其它字段
        assertNotNull(findArgs.get());
        assertEquals(ACCT_NO, findArgs.get()[0]);
        assertEquals(SCENE_NO, findArgs.get()[1]);
        // 写入目标唯一为记录 α 的两键
        assertNotNull(updateArg.get());
        assertEquals(ACCT_NO, updateArg.get().getCheckObjVal());
        assertEquals(SCENE_NO, updateArg.get().getLimitSceneNo());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
    }

    // ST110-TC005：REQ-002-S04 限额检查结果不等于「未超限」⇒ 条件 (a) 不成立，不定位不更新，正常结束（REQ-004-S02 情形 1）
    @Test
    void testST110T05() {
        // 定位键 (ACCT_NO, SCENE_NO) 上桩一条已存在记录：若实现丢掉条件 (a) 的判定，将定位并更新它而使下方断言失败
        AtomicReference<String[]> findArgs = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    findArgs.set(new String[] {invocation.getArgument(0), invocation.getArgument(1)});
                    return existingRecord(ACCT_NO, SCENE_NO);
                });
        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("已超限", ACCT_NO, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(5));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 条件 (a) 不成立（REQ-002）：MUST NOT 发起定位，MUST NOT 修改本表
        assertNull(findArgs.get());
        assertNull(updateArg.get());
    }

    // ST110-TC006：REQ-002-S05 边界「未超限」但金额与笔数均为 0 ⇒「大于 0」为严格大于，条件 (b) 不成立，不更新且正常结束
    @Test
    void testST110T06() {
        // 定位键上桩一条已存在记录：若「大于 0」被误写成「大于等于 0」，将定位并更新它而使下方断言失败
        AtomicReference<String[]> findArgs = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(anyString(), anyString()))
                .thenAnswer(invocation -> {
                    findArgs.set(new String[] {invocation.getArgument(0), invocation.getArgument(1)});
                    return existingRecord(ACCT_NO, SCENE_NO);
                });
        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO, SCENE_NO,
                new BigDecimal("0.00"), Integer.valueOf(0));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 条件 (b) 不成立（严格大于，等于 0 不满足）：MUST NOT 发起定位，MUST NOT 修改本表
        assertNull(findArgs.get());
        assertNull(updateArg.get());
    }

    // ST110-TC007：REQ-004-S01 触发条件成立但按两键匹配不到记录 ⇒ 不更新本表，步骤正常结束（非业务失败）
    @Test
    void testST110T07() {
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO_MISS, SCENE_NO)).thenReturn(null);
        AtomicReference<RbLimitSumInfoEO> updateArg = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    updateArg.set(invocation.getArgument(0));
                    return 1;
                });

        ST110InputBO input = buildInput("未超限", ACCT_NO_MISS, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(5));
        ST110OutputBO result = st110Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 未命中：不更新、不新增、不删除，也不改以其它条件重新定位
        assertNull(updateArg.get());
    }

    // ST110-TC008：REQ-004-S02 情形 1（触发条件不成立）与情形 2（触发成立但未命中）结论与数据状态影响一致
    @Test
    void testST110T08() {
        // 情形 1 的定位键桩上已存在记录，情形 2 的定位键桩为 null；分别捕获两段是否发起定位与写入
        AtomicReference<String[]> findArgsNotTriggered = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO, SCENE_NO))
                .thenAnswer(invocation -> {
                    findArgsNotTriggered.set(
                            new String[] {invocation.getArgument(0), invocation.getArgument(1)});
                    return existingRecord(ACCT_NO, SCENE_NO);
                });
        AtomicReference<String[]> findArgsMissed = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO_MISS, "LSN0003"))
                .thenAnswer(invocation -> {
                    findArgsMissed.set(
                            new String[] {invocation.getArgument(0), invocation.getArgument(1)});
                    return null;
                });
        AtomicReference<RbLimitSumInfoEO> updateArgNotTriggered = new AtomicReference<>();
        AtomicReference<RbLimitSumInfoEO> updateArgMissed = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    RbLimitSumInfoEO eo = invocation.getArgument(0);
                    if (ACCT_NO.equals(eo.getCheckObjVal())) {
                        updateArgNotTriggered.set(eo);
                    } else {
                        updateArgMissed.set(eo);
                    }
                    return 1;
                });

        ST110InputBO notTriggered = buildInput("已超限", ACCT_NO, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(5));
        ST110OutputBO first = st110Pbc.execute(notTriggered);

        ST110InputBO missed = buildInput("未超限", ACCT_NO_MISS, "LSN0003",
                new BigDecimal("1000.00"), Integer.valueOf(5));
        ST110OutputBO second = st110Pbc.execute(missed);

        assertTrue(first.isSucceed());
        assertTrue(second.isSucceed());
        assertNull(first.getErrorCode());
        assertNull(second.getErrorCode());
        assertNull(first.getErrorMessage());
        assertNull(second.getErrorMessage());
        // 情形 1：条件不成立 ⇒ 不发起定位，也不写入，两段对本表数据状态的影响一致（均无变更）
        assertNull(findArgsNotTriggered.get());
        assertNull(updateArgNotTriggered.get());
        // 情形 2：发起定位（实参为两键）但未命中 ⇒ 同样不写入
        assertNotNull(findArgsMissed.get());
        assertEquals(ACCT_NO_MISS, findArgsMissed.get()[0]);
        assertEquals("LSN0003", findArgsMissed.get()[1]);
        assertNull(updateArgMissed.get());
    }

    // ST110-TC009：REQ-003-S03 写入取值等于本次入参、不依赖被更新记录原值（状态 A 原值 0.00／0，状态 B 原值 1000.00／5 与入参同值）
    @Test
    void testST110T09() {
        RbLimitSumInfoEO stateA = new RbLimitSumInfoEO();
        stateA.setCheckObjVal(ACCT_NO);
        stateA.setLimitSceneNo(SCENE_NO);
        stateA.setLimitSumAmt(new BigDecimal("0.00"));
        stateA.set否(Integer.valueOf(0));
        RbLimitSumInfoEO stateB = new RbLimitSumInfoEO();
        stateB.setCheckObjVal(ACCT_NO_B);
        stateB.setLimitSceneNo("LSN0002");
        stateB.setLimitSumAmt(new BigDecimal("1000.00"));
        stateB.set否(Integer.valueOf(5));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO, SCENE_NO)).thenReturn(stateA);
        Mockito.lenient().when(rbLimitSumInfoBcc.findByPrimaryKey(ACCT_NO_B, "LSN0002")).thenReturn(stateB);

        AtomicReference<RbLimitSumInfoEO> updateArgA = new AtomicReference<>();
        AtomicReference<RbLimitSumInfoEO> updateArgB = new AtomicReference<>();
        Mockito.lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class)))
                .thenAnswer(invocation -> {
                    RbLimitSumInfoEO eo = invocation.getArgument(0);
                    if (ACCT_NO.equals(eo.getCheckObjVal())) {
                        updateArgA.set(eo);
                    } else {
                        updateArgB.set(eo);
                    }
                    return 1;
                });

        ST110OutputBO resultA = st110Pbc.execute(buildInput("未超限", ACCT_NO, SCENE_NO,
                new BigDecimal("1000.00"), Integer.valueOf(5)));
        ST110OutputBO resultB = st110Pbc.execute(buildInput("未超限", ACCT_NO_B, "LSN0002",
                new BigDecimal("1000.00"), Integer.valueOf(5)));

        assertTrue(resultA.isSucceed());
        assertNull(resultA.getErrorCode());
        assertTrue(resultB.isSucceed());
        assertNull(resultB.getErrorCode());
        // 两种状态下的写入取值均为本次入参，与执行前原值无关
        assertNotNull(updateArgA.get());
        assertNotNull(updateArgA.get().getLimitSumAmt());
        assertEquals(0, updateArgA.get().getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertEquals(Integer.valueOf(5), updateArgA.get().get否());
        assertNotNull(updateArgB.get());
        assertNotNull(updateArgB.get().getLimitSumAmt());
        assertEquals(0, updateArgB.get().getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertEquals(Integer.valueOf(5), updateArgB.get().get否());
        assertNotNull(resultA.getLimitSumAmt());
        assertEquals(0, resultA.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
        assertNotNull(resultB.getLimitSumAmt());
        assertEquals(0, resultB.getLimitSumAmt().compareTo(new BigDecimal("1000.00")));
    }

    /**
     * 构造一条已存在的限额累计信息表记录，供「未触发／未命中即不得写入」的用例设桩：
     * 只要实现错误地发起定位并写回，捕获到的写入入参即非 null 而使断言失败。
     */
    private RbLimitSumInfoEO existingRecord(String checkObjVal, String limitSceneNo) {
        RbLimitSumInfoEO record = new RbLimitSumInfoEO();
        record.setCheckObjVal(checkObjVal);
        record.setLimitSceneNo(limitSceneNo);
        record.setLimitSumAmt(new BigDecimal("300.00"));
        record.set否(Integer.valueOf(2));
        return record;
    }

    /**
     * 构造步骤输入：六个必填输入照录 Spec「### 输入」表。
     */
    private ST110InputBO buildInput(String checkResult, String baseAcctNo, String limitSceneNo,
            BigDecimal limitSumAmt, Integer limitSumNum) {
        ST110InputBO input = new ST110InputBO();
        input.set限额检查结果(checkResult);
        input.setBaseAcctNo(baseAcctNo);
        input.setLimitSceneNo(limitSceneNo);
        input.setClientNo(CLIENT_NO);
        input.setLimitSumAmt(limitSumAmt);
        input.setLimitSumNum(limitSumNum);
        return input;
    }
}

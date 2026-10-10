package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;

import com.dcits.depsit.enums.CheckObjType;
import com.dcits.depsit.facade.bo.ST108InputBO;
import com.dcits.depsit.facade.bo.ST108OutputBO;
import com.dcits.depsit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.depsit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitSceneDefEO;
import com.dcits.depsit.facade.eo.RbLimitSumInfoEO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST108 登记累计限额 的单元测试。
 *
 * <p>调用签名：{@code ST108OutputBO execute(ST108InputBO input)}。各用例依据正式 Spec
 * （docs/specs/ST108.md）与 outputs/测试用例.md 构造输入、桩返回与期望值，通过真实步骤实例执行，
 * 不 mock 被测步骤自身的条件判定与输出映射。</p>
 *
 * <p>{@code create} 与 {@code createSelective} 的取用方式源需求未区分，故两处都设 lenient 捕获桩，
 * 实现择一即被记录；对【限额累计信息表】的查询不设桩（Spec 第 6 项：本步骤未描述登记前查询）。
 * 更新与删除方法同样设 lenient 捕获桩，使「不更新、不删除既有记录」与「条件不成立不写入」这类
 * 负向行为有可失败断言（观察捕获集合为空，不使用 {@code verify}／{@code never}／{@code times}）。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST108PbcTest {

    @Mock
    private IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @InjectMocks
    private ST108Pbc pbc;

    // ST108-TC001：REQ-002-S01 或组左支（limitSumAmt=0）成立触发登记；REQ-004-S01「LS0001」配置 ACCT ⇒ 限额检查对象值取账号；REQ-003-S01/REQ-005/REQ-006 写入 5 项可确定内容且只写 1 条；REQ-007-S01 输出与登记一致；REQ-008-S01 返回成功
    @Test
    void testST108T01() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0001");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0001")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0001");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("0"));
        input.setLimitSumCnt(Integer.valueOf(3));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1, records.size());
        RbLimitSumInfoEO written = records.get(0);
        assertEquals("LS0001", written.getLimitSceneNo());
        assertEquals("1100101001000000123", written.getCheckObjVal());
        assertNotNull(written.getLimitSumAmt());
        assertEquals(0, written.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), written.get否());
        assertNotNull(written.getEffectDate());
        assertEquals(input.getRunDate().getTime(), written.getEffectDate().getTime());
        // 输出 5 个有值字段与登记记录一致；expireDate 与「系统规则自动生成」各列不作断言
        assertEquals(written.getLimitSceneNo(), result.getLimitSceneNo());
        assertEquals(written.getCheckObjVal(), result.getCheckObjVal());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), result.get否());
        assertNotNull(result.getEffectDate());
        assertEquals(input.getRunDate().getTime(), result.getEffectDate().getTime());
    }

    // ST108-TC002：REQ-002-S02 或组右支（limitSumCnt=0）成立触发登记；REQ-004-S02「LS0003」配置 CUST ⇒ 限额检查对象值取客户号；REQ-005 累计金额取 tranAmt、累计笔数为常量 1（不取输入的 100000.00 与 0）
    @Test
    void testST108T02() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0003");
        sceneDef.setCheckObjType(CheckObjType.CUST);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0003")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0003");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("100000.00"));
        input.setLimitSumCnt(Integer.valueOf(0));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1, records.size());
        RbLimitSumInfoEO written = records.get(0);
        assertEquals("LS0003", written.getLimitSceneNo());
        assertEquals("10000000001", written.getCheckObjVal());
        assertNotEquals("1100101001000000123", written.getCheckObjVal());
        assertNotNull(written.getLimitSumAmt());
        assertEquals(0, written.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), written.get否());
        assertNotEquals(Integer.valueOf(0), written.get否());
        assertNotNull(written.getEffectDate());
        assertEquals(input.getRunDate().getTime(), written.getEffectDate().getTime());
        assertEquals(written.getLimitSceneNo(), result.getLimitSceneNo());
        assertEquals(written.getCheckObjVal(), result.getCheckObjVal());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), result.get否());
    }

    // ST108-TC003：REQ-002-S03 或组两支同时为 0 均成立 ⇒ 登记只发生一次（records 恰 1 条），不重复登记；同时覆盖 REQ-003-S01 与 REQ-007-S01
    @Test
    void testST108T03() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0001");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0001")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0001");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("0"));
        input.setLimitSumCnt(Integer.valueOf(0));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1, records.size());
        RbLimitSumInfoEO written = records.get(0);
        assertEquals("LS0001", written.getLimitSceneNo());
        assertEquals("1100101001000000123", written.getCheckObjVal());
        assertNotNull(written.getLimitSumAmt());
        assertEquals(0, written.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), written.get否());
        assertNotNull(written.getEffectDate());
        assertEquals(input.getRunDate().getTime(), written.getEffectDate().getTime());
        assertEquals(written.getLimitSceneNo(), result.getLimitSceneNo());
        assertEquals(written.getCheckObjVal(), result.getCheckObjVal());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), result.get否());
        assertNotNull(result.getEffectDate());
        assertEquals(input.getRunDate().getTime(), result.getEffectDate().getTime());
    }

    // ST108-TC004：REQ-002-S04 金额与笔数均非 0 ⇒ 条件不成立，不登记、不产生占位记录，仍按正常结果返回成功（REQ-008-S01）；不登记时 6 个输出取值未定义，不作断言
    // 说明：场景配置桩按正常路径设好（「LS0001」配置 ACCT 且记录存在），写入桩照常为捕获桩，再断言捕获集合为空——
    // 使「条件不成立仍写库（含占位记录）」的错误实现在此判负，而非依赖未设桩的 NPE 或不可失败的成功断言；
    // 观察捕获集合而非 verify/never/times，可失败断言成立
    @Test
    void testST108T04() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0001");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0001")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0001");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("100000.00"));
        input.setLimitSumCnt(Integer.valueOf(3));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        // 条件不成立 ⇒ 不产生任何登记写入，也不产生占位记录
        assertTrue(records.isEmpty());
    }

    // ST108-TC005：REQ-003-S02 本次登记只新增该笔记录、不改写其它数据——假登记表已存在 "10000000002|LS0002"，登记后共 2 条且既有记录取值与条数不变
    @Test
    void testST108T05() {
        Map<String, RbLimitSumInfoEO> ledger = new LinkedHashMap<String, RbLimitSumInfoEO>();
        RbLimitSumInfoEO existing = new RbLimitSumInfoEO();
        existing.setCheckObjVal("10000000002");
        existing.setLimitSceneNo("LS0002");
        existing.setLimitSumAmt(new BigDecimal("888.88"));
        existing.set否(Integer.valueOf(9));
        existing.setEffectDate(Timestamp.valueOf("2026-10-01 00:00:00.000"));
        ledger.put(existing.getCheckObjVal() + "|" + existing.getLimitSceneNo(), existing);

        lenient().when(rbLimitSumInfoBcc.create(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            RbLimitSumInfoEO eo = inv.getArgument(0);
            ledger.put(eo.getCheckObjVal() + "|" + eo.getLimitSceneNo(), eo);
            return 1;
        });
        lenient().when(rbLimitSumInfoBcc.createSelective(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            RbLimitSumInfoEO eo = inv.getArgument(0);
            ledger.put(eo.getCheckObjVal() + "|" + eo.getLimitSceneNo(), eo);
            return 1;
        });
        // 更新与删除方法的捕获桩：本次登记 MUST NOT 触达它们，末尾以「未捕获到任何调用」作可失败断言
        List<String> otherWrites = new ArrayList<String>();
        lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKeySelective(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            otherWrites.add("modifyByPrimaryKeySelective");
            return 1;
        });
        lenient().when(rbLimitSumInfoBcc.modifyByPrimaryKey(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            otherWrites.add("modifyByPrimaryKey");
            return 1;
        });
        lenient().when(rbLimitSumInfoBcc.removeByEo(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            otherWrites.add("removeByEo");
            return 1;
        });
        lenient().when(rbLimitSumInfoBcc.removeByPrimaryKey(any(String.class), any(String.class))).thenAnswer(inv -> {
            otherWrites.add("removeByPrimaryKey");
            return 1;
        });
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0001");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0001")).thenReturn(sceneDef);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0001");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("0"));
        input.setLimitSumCnt(Integer.valueOf(0));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(2, ledger.size());
        // 本次登记未触达任何更新或删除方法（观察捕获结果，不使用 verify/never/times）
        assertTrue(otherWrites.isEmpty());
        RbLimitSumInfoEO added = ledger.get("1100101001000000123|LS0001");
        assertNotNull(added);
        assertEquals("LS0001", added.getLimitSceneNo());
        assertEquals("1100101001000000123", added.getCheckObjVal());
        assertNotNull(added.getLimitSumAmt());
        assertEquals(0, added.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), added.get否());
        assertNotNull(added.getEffectDate());
        assertEquals(input.getRunDate().getTime(), added.getEffectDate().getTime());
        // 既有记录的条数与取值保持不变
        RbLimitSumInfoEO kept = ledger.get("10000000002|LS0002");
        assertNotNull(kept);
        assertEquals("10000000002", kept.getCheckObjVal());
        assertEquals("LS0002", kept.getLimitSceneNo());
        assertNotNull(kept.getLimitSumAmt());
        assertEquals(0, kept.getLimitSumAmt().compareTo(new BigDecimal("888.88")));
        assertEquals(Integer.valueOf(9), kept.get否());
        assertNotNull(kept.getEffectDate());
        assertEquals(Timestamp.valueOf("2026-10-01 00:00:00.000").getTime(), kept.getEffectDate().getTime());
        assertEquals(added.getLimitSceneNo(), result.getLimitSceneNo());
        assertEquals(added.getCheckObjVal(), result.getCheckObjVal());
    }

    // ST108-TC006：REQ-001-S01/S02 与 REQ-007-S01/S02 的字段契约——以反射断言 InputBO 恰 8 个字段（含中文名 限额检查结果）、OutputBO 恰 6 个字段（含 否），并在正常登记路径上核对 5 个有值输出
    @Test
    void testST108T06() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0001");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0001")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("50000.00"));
        input.setLimitSceneNo("LS0001");
        input.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        input.setLimitSumAmt(new BigDecimal("0"));
        input.setLimitSumCnt(Integer.valueOf(3));

        ST108OutputBO result = pbc.execute(input);

        Map<String, Class<?>> expectedInputFields = new LinkedHashMap<String, Class<?>>();
        expectedInputFields.put("限额检查结果", String.class);
        expectedInputFields.put("baseAcctNo", String.class);
        expectedInputFields.put("clientNo", String.class);
        expectedInputFields.put("tranAmt", BigDecimal.class);
        expectedInputFields.put("limitSceneNo", String.class);
        expectedInputFields.put("runDate", Date.class);
        expectedInputFields.put("limitSumAmt", BigDecimal.class);
        expectedInputFields.put("limitSumCnt", Integer.class);
        Map<String, Class<?>> actualInputFields = Stream.of(ST108InputBO.class.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toMap(Field::getName, Field::getType));
        assertEquals(expectedInputFields, actualInputFields);

        Map<String, Class<?>> expectedOutputFields = new LinkedHashMap<String, Class<?>>();
        expectedOutputFields.put("limitSceneNo", String.class);
        expectedOutputFields.put("checkObjVal", String.class);
        expectedOutputFields.put("limitSumAmt", BigDecimal.class);
        expectedOutputFields.put("否", Integer.class);
        expectedOutputFields.put("effectDate", Date.class);
        expectedOutputFields.put("expireDate", Date.class);
        Map<String, Class<?>> actualOutputFields = Stream.of(ST108OutputBO.class.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toMap(Field::getName, Field::getType));
        assertEquals(expectedOutputFields, actualOutputFields);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("LS0001", result.getLimitSceneNo());
        assertEquals("1100101001000000123", result.getCheckObjVal());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("50000.00")));
        assertEquals(Integer.valueOf(1), result.get否());
        assertInstanceOf(Integer.class, result.get否());
        assertNotNull(result.getEffectDate());
        assertEquals(input.getRunDate().getTime(), result.getEffectDate().getTime());
    }

    // ST108-TC007：REQ-004 检查对象类型的取值来源与分支——同一账号/客户号下两次分别以 "LS0001"（ACCT）与 "LS0003"（CUST）执行，查询键恰为输入的限额场景编码，未跨场景复用配置
    @Test
    void testST108T07() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        List<String> queryKeys = new ArrayList<String>();
        RbLimitSceneDefEO sceneAcct = new RbLimitSceneDefEO();
        sceneAcct.setLimitSceneNo("LS0001");
        sceneAcct.setCheckObjType(CheckObjType.ACCT);
        RbLimitSceneDefEO sceneCust = new RbLimitSceneDefEO();
        sceneCust.setLimitSceneNo("LS0003");
        sceneCust.setCheckObjType(CheckObjType.CUST);
        doAnswer(inv -> {
            queryKeys.add(inv.getArgument(0));
            if ("LS0001".equals(inv.getArgument(0))) {
                return sceneAcct;
            }
            if ("LS0003".equals(inv.getArgument(0))) {
                return sceneCust;
            }
            return null;
        }).when(rbLimitSceneDefBcc).findByPrimaryKey(any(String.class));
        stubLimitSumWrite(records);

        ST108InputBO firstInput = new ST108InputBO();
        firstInput.set限额检查结果("未超限");
        firstInput.setBaseAcctNo("1100101001000000123");
        firstInput.setClientNo("10000000001");
        firstInput.setTranAmt(new BigDecimal("50000.00"));
        firstInput.setLimitSceneNo("LS0001");
        firstInput.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        firstInput.setLimitSumAmt(new BigDecimal("0"));
        firstInput.setLimitSumCnt(Integer.valueOf(3));

        ST108InputBO secondInput = new ST108InputBO();
        secondInput.set限额检查结果("未超限");
        secondInput.setBaseAcctNo("1100101001000000123");
        secondInput.setClientNo("10000000001");
        secondInput.setTranAmt(new BigDecimal("50000.00"));
        secondInput.setLimitSceneNo("LS0003");
        secondInput.setRunDate(Timestamp.valueOf("2026-10-10 00:00:00.000"));
        secondInput.setLimitSumAmt(new BigDecimal("0"));
        secondInput.setLimitSumCnt(Integer.valueOf(3));

        ST108OutputBO first = pbc.execute(firstInput);
        ST108OutputBO second = pbc.execute(secondInput);

        assertTrue(first.isSucceed());
        assertTrue(second.isSucceed());
        assertNull(first.getErrorCode());
        assertNull(second.getErrorCode());
        assertEquals(List.of("LS0001", "LS0003"), queryKeys);
        assertEquals(2, records.size());
        assertEquals("LS0001", records.get(0).getLimitSceneNo());
        assertEquals("1100101001000000123", records.get(0).getCheckObjVal());
        assertEquals("LS0003", records.get(1).getLimitSceneNo());
        assertEquals("10000000001", records.get(1).getCheckObjVal());
        assertEquals("1100101001000000123", first.getCheckObjVal());
        assertEquals("10000000001", second.getCheckObjVal());
        assertNotEquals(first.getCheckObjVal(), second.getCheckObjVal());
    }

    // ST108-TC008：REQ-003「写入取值 MUST NOT 改写输入值」的否定边界——tranAmt 标度 2 与尾随零、runDate 毫秒 123 均原样登记，限额累计笔数仍为常量 1（不取输入的 7）
    @Test
    void testST108T08() {
        List<RbLimitSumInfoEO> records = new ArrayList<RbLimitSumInfoEO>();
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setLimitSceneNo("LS0007");
        sceneDef.setCheckObjType(CheckObjType.ACCT);
        lenient().when(rbLimitSceneDefBcc.findByPrimaryKey("LS0007")).thenReturn(sceneDef);
        stubLimitSumWrite(records);

        ST108InputBO input = new ST108InputBO();
        input.set限额检查结果("未超限");
        input.setBaseAcctNo("1100101001000000123");
        input.setClientNo("10000000001");
        input.setTranAmt(new BigDecimal("12.30"));
        input.setLimitSceneNo("LS0007");
        input.setRunDate(Timestamp.valueOf("2026-10-10 09:30:15.123"));
        input.setLimitSumAmt(new BigDecimal("0.00"));
        input.setLimitSumCnt(Integer.valueOf(7));

        ST108OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1, records.size());
        RbLimitSumInfoEO written = records.get(0);
        assertNotNull(written.getLimitSumAmt());
        assertEquals(0, written.getLimitSumAmt().compareTo(new BigDecimal("12.30")));
        assertEquals(2, written.getLimitSumAmt().scale());
        assertNotNull(written.getEffectDate());
        assertEquals(input.getRunDate().getTime(), written.getEffectDate().getTime());
        assertEquals(123L, written.getEffectDate().getTime() % 1000L);
        assertEquals(Integer.valueOf(1), written.get否());
        assertEquals("LS0007", written.getLimitSceneNo());
        assertEquals(written.getLimitSceneNo(), result.getLimitSceneNo());
        assertNotNull(result.getLimitSumAmt());
        assertEquals(0, result.getLimitSumAmt().compareTo(new BigDecimal("12.30")));
        assertEquals(2, result.getLimitSumAmt().scale());
        assertEquals(Integer.valueOf(1), result.get否());
        assertNotNull(result.getEffectDate());
        assertEquals(input.getRunDate().getTime(), result.getEffectDate().getTime());
    }

    /**
     * 对 {@code create} 与 {@code createSelective} 都设捕获桩（Spec「依赖调用」同时列出两者、源需求
     * 未区分取用方式），把入参登记记录按调用顺序记入 {@code records} 并返回 1。
     */
    private void stubLimitSumWrite(List<RbLimitSumInfoEO> records) {
        lenient().when(rbLimitSumInfoBcc.create(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            records.add(inv.getArgument(0));
            return 1;
        });
        lenient().when(rbLimitSumInfoBcc.createSelective(any(RbLimitSumInfoEO.class))).thenAnswer(inv -> {
            records.add(inv.getArgument(0));
            return 1;
        });
    }
}

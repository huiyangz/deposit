package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.facade.bo.ST133InputBO;
import com.dcits.depsit.facade.bo.ST133OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

/**
 * ST133 登记账户限制登记簿 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST133-TC001 至 ST133-TC010，覆盖 Spec REQ-001 至 REQ-005 的
 * 10 个场景（REQ-005-S02 见该文件的「设计局限与未决问题」第 1 条）。本步骤无子步骤、无分支、无跳转、
 * 无循环，全部用例走同一条执行路径：14 个输入字段 → 一次登记写入 → 14 个输出字段，
 * 差异只在输入取值与断言侧重。</p>
 *
 * <p>桩点：本步骤唯一被触达的依赖是登记写入 {@link IRbBusRestraintsBcc}。Spec「### 依赖调用」的
 * 技术核对同时列出 {@code create} 与 {@code createSelective}，源需求不区分二者，故对两者设置同一
 * 捕获式 {@code doAnswer}（共用同一捕获容器与假登记簿），使断言不随实现的方法选择变化。
 * 不使用 {@code verify}/{@code never}/{@code times} 验证交互次数或顺序；登记写入返回的影响行数在本
 * Spec 中无业务语义（Spec「验收范围与明确不覆盖的事项」第 1、3、7 项），故固定返回 1 且不据其分支。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST133PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST133Pbc st133Pbc;

    /** 「## 输入」表与「## 输出」表的 14 个字段名（REQ-001、REQ-003） */
    private static final Set<String> FIELD14 = Set.of(
            "resSeqNo", "pledgedAmt", "startDate", "endDate",
            "judiciaryDocumentType", "judiciaryDocumentType2",
            "judiciaryOthDocumentType", "judiciaryOthDocumentType2",
            "deductionJudiciaryName", "deductionLawNo",
            "judiciaryDocumentId", "judiciaryDocumentId2",
            "judiciaryOthDocumentId", "judiciaryOthDocumentId2");

    /**
     * 对登记写入设捕获式桩：记录收到的 EO（可同时写入假登记簿）并返回影响行数 1。
     *
     * @param captured 长度为 1 的数组，用于回传实现构造的登记 EO
     * @param ledger   假登记簿，为 {@code null} 时不记录
     */
    private void stubRegister(RbBusRestraintsEO[] captured, Map<String, RbBusRestraintsEO> ledger) {
        Answer<Integer> answer = invocation -> {
            RbBusRestraintsEO eo = invocation.getArgument(0);
            captured[0] = eo;
            if (ledger != null) {
                ledger.put(eo.getResSeqNo(), eo);
            }
            return 1;
        };
        lenient().when(rbBusRestraintsBcc.createSelective(any(RbBusRestraintsEO.class))).thenAnswer(answer);
        lenient().when(rbBusRestraintsBcc.create(any(RbBusRestraintsEO.class))).thenAnswer(answer);
    }

    /** 只记录登记请求体，不维护假登记簿。 */
    private void stubRegister(RbBusRestraintsEO[] captured) {
        stubRegister(captured, null);
    }

    /** 按 Spec REQ-001-S01 的示例取值构造 14 个输入字段。 */
    private ST133InputBO sampleInput() {
        ST133InputBO input = new ST133InputBO();
        input.setResSeqNo("RES20261010001");
        input.setPledgedAmt(new BigDecimal("100000.00"));
        input.setStartDate(Timestamp.valueOf("2026-10-10 09:00:00"));
        input.setEndDate(Timestamp.valueOf("2027-10-10 09:00:00"));
        input.setJudiciaryDocumentType(DocumentType.VALUE_110001);
        input.setJudiciaryDocumentType2(DocumentType.VALUE_110003);
        input.setJudiciaryOthDocumentType(DocumentType.VALUE_610001);
        input.setJudiciaryOthDocumentType2(DocumentType.VALUE_110023);
        input.setDeductionJudiciaryName("XX市中级人民法院");
        input.setDeductionLawNo("（2026）X法执字第123号");
        input.setJudiciaryDocumentId("110101199001011234");
        input.setJudiciaryDocumentId2("110101199002022345");
        input.setJudiciaryOthDocumentId("91110000XXXXXXXXXX");
        input.setJudiciaryOthDocumentId2("E12345678");
        return input;
    }

    /** 断言成功状态与登记请求体、输出 BO 的 14 个字段均等于输入取值。 */
    private void assertRegistered(ST133InputBO input, RbBusRestraintsEO registered, ST133OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(input.getResSeqNo(), registered.getResSeqNo());
        assertEquals(input.getPledgedAmt(), registered.getPledgedAmt());
        assertEquals(input.getStartDate(), registered.getStartDate());
        assertEquals(input.getEndDate(), registered.getEndDate());
        assertEquals(input.getJudiciaryDocumentType(), registered.getJudiciaryDocumentType());
        assertEquals(input.getJudiciaryDocumentType2(), registered.getJudiciaryDocumentType2());
        assertEquals(input.getJudiciaryOthDocumentType(), registered.getJudiciaryOthDocumentType());
        assertEquals(input.getJudiciaryOthDocumentType2(), registered.getJudiciaryOthDocumentType2());
        assertEquals(input.getDeductionJudiciaryName(), registered.getDeductionJudiciaryName());
        assertEquals(input.getDeductionLawNo(), registered.getDeductionLawNo());
        assertEquals(input.getJudiciaryDocumentId(), registered.getJudiciaryDocumentId());
        assertEquals(input.getJudiciaryDocumentId2(), registered.getJudiciaryDocumentId2());
        assertEquals(input.getJudiciaryOthDocumentId(), registered.getJudiciaryOthDocumentId());
        assertEquals(input.getJudiciaryOthDocumentId2(), registered.getJudiciaryOthDocumentId2());
        assertEquals(input.getResSeqNo(), output.getResSeqNo());
        assertEquals(input.getPledgedAmt(), output.getPledgedAmt());
        assertEquals(input.getStartDate(), output.getStartDate());
        assertEquals(input.getEndDate(), output.getEndDate());
        assertEquals(input.getJudiciaryDocumentType(), output.getJudiciaryDocumentType());
        assertEquals(input.getJudiciaryDocumentType2(), output.getJudiciaryDocumentType2());
        assertEquals(input.getJudiciaryOthDocumentType(), output.getJudiciaryOthDocumentType());
        assertEquals(input.getJudiciaryOthDocumentType2(), output.getJudiciaryOthDocumentType2());
        assertEquals(input.getDeductionJudiciaryName(), output.getDeductionJudiciaryName());
        assertEquals(input.getDeductionLawNo(), output.getDeductionLawNo());
        assertEquals(input.getJudiciaryDocumentId(), output.getJudiciaryDocumentId());
        assertEquals(input.getJudiciaryDocumentId2(), output.getJudiciaryDocumentId2());
        assertEquals(input.getJudiciaryOthDocumentId(), output.getJudiciaryOthDocumentId());
        assertEquals(input.getJudiciaryOthDocumentId2(), output.getJudiciaryOthDocumentId2());
    }

    /** 取类型自身声明的非静态字段名集合。 */
    private Set<String> declaredFieldNames(Class<?> type) {
        return Arrays.stream(type.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .map(Field::getName)
                .collect(Collectors.toSet());
    }

    /** REQ-001-S01 + REQ-005-S01：按输入表提供 14 个字段，正常完成登记且结果状态为成功（ST133-TC001）。 */
    @Test
    void testST133T01() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertRegistered(input, captured[0], output);
    }

    /** REQ-002-S01：14 个字段作为一条记录写入，金额标度与日期时刻逐位保留、不被改写（ST133-TC002）。 */
    @Test
    void testST133T02() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals("RES20261010001", captured[0].getResSeqNo());
        assertEquals(new BigDecimal("100000.00"), captured[0].getPledgedAmt());
        assertEquals(2, captured[0].getPledgedAmt().scale());
        assertEquals(input.getStartDate().getTime(), captured[0].getStartDate().getTime());
        assertEquals(input.getEndDate().getTime(), captured[0].getEndDate().getTime());
        assertRegistered(input, captured[0], output);
    }

    /** REQ-002-S02：既有记录 RES20260101009 的取值与条数不变，本次只新增自己这一条（ST133-TC003）。 */
    @Test
    void testST133T03() {
        Map<String, RbBusRestraintsEO> ledger = new LinkedHashMap<>();
        RbBusRestraintsEO existing = new RbBusRestraintsEO();
        existing.setResSeqNo("RES20260101009");
        existing.setPledgedAmt(new BigDecimal("5000.00"));
        existing.setStartDate(Timestamp.valueOf("2026-01-01 08:30:00"));
        existing.setEndDate(Timestamp.valueOf("2026-01-01 18:00:00"));
        existing.setJudiciaryDocumentType(DocumentType.VALUE_110001);
        ledger.put(existing.getResSeqNo(), existing);

        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured, ledger);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals(2, ledger.size());
        assertNotNull(ledger.get("RES20261010001"));
        assertRegistered(input, ledger.get("RES20261010001"), output);
        assertEquals("RES20260101009", existing.getResSeqNo());
        assertEquals(new BigDecimal("5000.00"), existing.getPledgedAmt());
        assertEquals(Timestamp.valueOf("2026-01-01 08:30:00").getTime(), existing.getStartDate().getTime());
        assertEquals(DocumentType.VALUE_110001, existing.getJudiciaryDocumentType());
    }

    /** REQ-002-S03：六类登记信息（1＋1＋1＋1＋8＋2＝14）全部落到登记字段，无遗漏、无表外字段（ST133-TC004）。 */
    @Test
    void testST133T04() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        // {限制编号} 1 个
        assertEquals("RES20261010001", captured[0].getResSeqNo());
        // {限制金额} 1 个
        assertEquals(new BigDecimal("100000.00"), captured[0].getPledgedAmt());
        // {开始日期}、{结束日期} 2 个
        assertEquals(input.getStartDate().getTime(), captured[0].getStartDate().getTime());
        assertEquals(input.getEndDate().getTime(), captured[0].getEndDate().getTime());
        // {执法人信息} 8 个
        assertEquals(DocumentType.VALUE_110001, captured[0].getJudiciaryDocumentType());
        assertEquals(DocumentType.VALUE_110003, captured[0].getJudiciaryDocumentType2());
        assertEquals(DocumentType.VALUE_610001, captured[0].getJudiciaryOthDocumentType());
        assertEquals(DocumentType.VALUE_110023, captured[0].getJudiciaryOthDocumentType2());
        assertEquals("110101199001011234", captured[0].getJudiciaryDocumentId());
        assertEquals("110101199002022345", captured[0].getJudiciaryDocumentId2());
        assertEquals("91110000XXXXXXXXXX", captured[0].getJudiciaryOthDocumentId());
        assertEquals("E12345678", captured[0].getJudiciaryOthDocumentId2());
        // {法律文书} 2 个
        assertEquals("XX市中级人民法院", captured[0].getDeductionJudiciaryName());
        assertEquals("（2026）X法执字第123号", captured[0].getDeductionLawNo());
        assertTrue(output.isSucceed());
    }

    /** REQ-003-S01：登记成功后返回 14 个字段，每个输出取值等于本次登记值并与输入一致（ST133-TC005）。 */
    @Test
    void testST133T05() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals(captured[0].getResSeqNo(), output.getResSeqNo());
        assertEquals(captured[0].getPledgedAmt(), output.getPledgedAmt());
        assertEquals(captured[0].getStartDate(), output.getStartDate());
        assertEquals(captured[0].getEndDate(), output.getEndDate());
        assertEquals(captured[0].getJudiciaryDocumentType(), output.getJudiciaryDocumentType());
        assertEquals(captured[0].getJudiciaryDocumentType2(), output.getJudiciaryDocumentType2());
        assertEquals(captured[0].getJudiciaryOthDocumentType(), output.getJudiciaryOthDocumentType());
        assertEquals(captured[0].getJudiciaryOthDocumentType2(), output.getJudiciaryOthDocumentType2());
        assertEquals(captured[0].getDeductionJudiciaryName(), output.getDeductionJudiciaryName());
        assertEquals(captured[0].getDeductionLawNo(), output.getDeductionLawNo());
        assertEquals(captured[0].getJudiciaryDocumentId(), output.getJudiciaryDocumentId());
        assertEquals(captured[0].getJudiciaryDocumentId2(), output.getJudiciaryDocumentId2());
        assertEquals(captured[0].getJudiciaryOthDocumentId(), output.getJudiciaryOthDocumentId());
        assertEquals(captured[0].getJudiciaryOthDocumentId2(), output.getJudiciaryOthDocumentId2());
        assertRegistered(input, captured[0], output);
    }

    /** REQ-003-S02：输出字段恰为「## 输出」表 14 个，无表外字段，且成功路径上 14 个字段均非空（ST133-TC006）。 */
    @Test
    void testST133T06() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertInstanceOf(StepResult.class, output);
        assertEquals(FIELD14, declaredFieldNames(ST133OutputBO.class));
        assertNotNull(output.getResSeqNo());
        assertNotNull(output.getPledgedAmt());
        assertNotNull(output.getStartDate());
        assertNotNull(output.getEndDate());
        assertNotNull(output.getJudiciaryDocumentType());
        assertNotNull(output.getJudiciaryDocumentType2());
        assertNotNull(output.getJudiciaryOthDocumentType());
        assertNotNull(output.getJudiciaryOthDocumentType2());
        assertNotNull(output.getDeductionJudiciaryName());
        assertNotNull(output.getDeductionLawNo());
        assertNotNull(output.getJudiciaryDocumentId());
        assertNotNull(output.getJudiciaryDocumentId2());
        assertNotNull(output.getJudiciaryOthDocumentId());
        assertNotNull(output.getJudiciaryOthDocumentId2());
        assertTrue(output.isSucceed());
    }

    /** REQ-001-S02：输入 BO 恰为「## 输入」表 14 个字段，登记请求体全部来自这 14 个输入（ST133-TC007）。 */
    @Test
    void testST133T07() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals(FIELD14, declaredFieldNames(ST133InputBO.class));
        assertRegistered(input, captured[0], output);
    }

    /** REQ-004-S01：4 个证件类型字段以 DocumentType 常量登记并原样返回，均为枚举代码值（ST133-TC008）。 */
    @Test
    void testST133T08() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals(DocumentType.VALUE_110001, captured[0].getJudiciaryDocumentType());
        assertEquals(DocumentType.VALUE_110003, captured[0].getJudiciaryDocumentType2());
        assertEquals(DocumentType.VALUE_610001, captured[0].getJudiciaryOthDocumentType());
        assertEquals(DocumentType.VALUE_110023, captured[0].getJudiciaryOthDocumentType2());
        assertEquals("110001", captured[0].getJudiciaryDocumentType().getValue());
        assertEquals("110003", captured[0].getJudiciaryDocumentType2().getValue());
        assertEquals("610001", captured[0].getJudiciaryOthDocumentType().getValue());
        assertEquals("110023", captured[0].getJudiciaryOthDocumentType2().getValue());
        assertEquals(captured[0].getJudiciaryDocumentType(), output.getJudiciaryDocumentType());
        assertEquals(captured[0].getJudiciaryDocumentType2(), output.getJudiciaryDocumentType2());
        assertEquals(captured[0].getJudiciaryOthDocumentType(), output.getJudiciaryOthDocumentType());
        assertEquals(captured[0].getJudiciaryOthDocumentType2(), output.getJudiciaryOthDocumentType2());
        assertInstanceOf(DocumentType.class, output.getJudiciaryDocumentType());
        assertInstanceOf(DocumentType.class, output.getJudiciaryDocumentType2());
        assertInstanceOf(DocumentType.class, output.getJudiciaryOthDocumentType());
        assertInstanceOf(DocumentType.class, output.getJudiciaryOthDocumentType2());
        assertTrue(output.isSucceed());
    }

    /** REQ-004-S02：4 个证件号码字段以字符串原值登记并原样返回，不转换、不补位、不截断（ST133-TC009）。 */
    @Test
    void testST133T09() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = sampleInput();
        input.setJudiciaryDocumentId("110101199001011234");
        input.setJudiciaryDocumentId2("E12345678");
        input.setJudiciaryOthDocumentId("91110000XXXXXXXXXX");
        input.setJudiciaryOthDocumentId2("Z0000001");

        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals("110101199001011234", captured[0].getJudiciaryDocumentId());
        assertEquals("E12345678", captured[0].getJudiciaryDocumentId2());
        assertEquals("91110000XXXXXXXXXX", captured[0].getJudiciaryOthDocumentId());
        assertEquals("Z0000001", captured[0].getJudiciaryOthDocumentId2());
        assertEquals(captured[0].getJudiciaryDocumentId(), output.getJudiciaryDocumentId());
        assertEquals(captured[0].getJudiciaryDocumentId2(), output.getJudiciaryDocumentId2());
        assertEquals(captured[0].getJudiciaryOthDocumentId(), output.getJudiciaryOthDocumentId());
        assertEquals(captured[0].getJudiciaryOthDocumentId2(), output.getJudiciaryOthDocumentId2());
        assertEquals(18, output.getJudiciaryDocumentId().length());
        assertTrue(output.isSucceed());
    }

    /** REQ-002-S01 否定边界：尾随零、毫秒、全角括号与中文均逐位保留，不被改写或格式化（ST133-TC010）。 */
    @Test
    void testST133T10() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubRegister(captured);

        ST133InputBO input = new ST133InputBO();
        input.setResSeqNo("RES20261010010");
        input.setPledgedAmt(new BigDecimal("12.30"));
        input.setStartDate(Timestamp.valueOf("2026-10-10 09:00:00.123"));
        input.setEndDate(Timestamp.valueOf("2027-10-10 23:59:59.999"));
        input.setJudiciaryDocumentType(DocumentType.VALUE_120000);
        input.setJudiciaryDocumentType2(DocumentType.Z00000);
        input.setJudiciaryOthDocumentType(DocumentType.VALUE_619999);
        input.setJudiciaryOthDocumentType2(DocumentType.VALUE_110023);
        input.setDeductionJudiciaryName("XX市朝阳区人民法院");
        input.setDeductionLawNo("（2026）X法执字第007号");
        input.setJudiciaryDocumentId("110101199001011234");
        input.setJudiciaryDocumentId2("E12345678");
        input.setJudiciaryOthDocumentId("91110000YYYYYYYYYY");
        input.setJudiciaryOthDocumentId2("G1234567X");

        ST133OutputBO output = st133Pbc.execute(input);

        assertEquals(new BigDecimal("12.30"), captured[0].getPledgedAmt());
        assertEquals(2, captured[0].getPledgedAmt().scale());
        assertEquals(input.getStartDate().getTime(), captured[0].getStartDate().getTime());
        assertEquals(123, captured[0].getStartDate().getTime() % 1000);
        assertEquals(input.getEndDate().getTime(), captured[0].getEndDate().getTime());
        assertEquals(DocumentType.VALUE_120000, captured[0].getJudiciaryDocumentType());
        assertEquals(DocumentType.Z00000, captured[0].getJudiciaryDocumentType2());
        assertEquals(DocumentType.VALUE_619999, captured[0].getJudiciaryOthDocumentType());
        assertEquals(DocumentType.VALUE_110023, captured[0].getJudiciaryOthDocumentType2());
        assertEquals("（2026）X法执字第007号", output.getDeductionLawNo());
        assertEquals("XX市朝阳区人民法院", output.getDeductionJudiciaryName());
        assertRegistered(input, captured[0], output);
    }
}

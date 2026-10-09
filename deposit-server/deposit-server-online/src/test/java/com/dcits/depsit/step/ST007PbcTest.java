package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.facade.bo.ST007InputBO;
import com.dcits.depsit.facade.bo.ST007OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST007 检查对手账户是否存在 —— 单元测试。
 *
 * <p>调用签名：{@code ST007OutputBO execute(ST007InputBO input)}。用例依据本轮正式 Spec
 * 与 {@code outputs/测试用例.md}／{@code .json} 的 9 个用例设计：两条互斥结论分支
 * （[对手账户信息] 非空 → 检查结果为「通过」；为空 → 错误码 {@code ER0081}）各有用例，
 * 另有输入／输出契约与枚举绑定的结构核对用例。</p>
 *
 * <p>【账户信息】的数据源未被源需求绑定，本测试对 {@link IRbBusAcctBcc#findByEo(RbBusAcctEO)}
 * 设桩仅用于驱动步骤 1 的执行路径，属 Spec「### 依赖调用」的非规范性观察，不作为业务断言对象。
 * 按技能约定不使用 {@code verify}/{@code never}/{@code times}/{@code InOrder} 验证交互。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST007PbcTest {

    @Mock
    private IRbBusAcctBcc irBusAcctBcc;

    @InjectMocks
    private ST007Pbc st007Pbc;

    // ST007-TC001：REQ-001-S02、REQ-002-S01、REQ-004-S01、REQ-006-S01 —— 对手账号对应 1 条记录，
    // 以该对手账号为查询条件取得 [对手账户信息]，判定非空后返回检查结果为「通过」
    @Test
    void testST007T01() {
        AtomicReference<RbBusAcctEO> queryCondition = new AtomicReference<>();
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(acct(1001, "1100602187654321", AcctStatus.A));
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            queryCondition.set(invocation.getArgument(0));
            return records;
        });

        ST007InputBO bo = new ST007InputBO();
        bo.setOthBaseAcctNo("1100602187654321");

        ST007OutputBO result = st007Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNotNull(queryCondition.get());
        assertEquals("1100602187654321", queryCondition.get().getBaseAcctNo());
    }

    // ST007-TC002：REQ-004-S02 —— 同一对手账号对应 2 条记录，[对手账户信息] 非空，
    // 按第 2 步「若为空…否则…」二分条件的直接读法返回「通过」
    @Test
    void testST007T02() {
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(acct(1001, "1100602187654321", AcctStatus.A));
        records.add(acct(1002, "1100602187654321", AcctStatus.C));
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(records);

        ST007InputBO bo = new ST007InputBO();
        bo.setOthBaseAcctNo("1100602187654321");

        ST007OutputBO result = st007Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST007-TC003：REQ-004-S01 后半 —— 记录存在但账户状态为 C-关闭，存在性判定只依据
    // 「是否存在记录」，不依赖记录中其它字段取值，仍返回「通过」
    @Test
    void testST007T03() {
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(acct(1003, "1100602187654321", AcctStatus.C));
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(records);

        ST007InputBO bo = new ST007InputBO();
        bo.setOthBaseAcctNo("1100602187654321");

        ST007OutputBO result = st007Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST007-TC004：REQ-002-S02、REQ-003-S01、REQ-006-S02 —— 对手账号无对应记录，
    // [对手账户信息] 为空，返回错误码 ER0081；不以抛出异常表达该结论
    @Test
    void testST007T04() {
        AtomicReference<RbBusAcctEO> queryCondition = new AtomicReference<>();
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            queryCondition.set(invocation.getArgument(0));
            return Collections.emptyList();
        });

        ST007InputBO bo = new ST007InputBO();
        bo.setOthBaseAcctNo("1100609900000000");

        ST007OutputBO result = assertDoesNotThrow(() -> st007Pbc.execute(bo));

        assertFalse(result.isSucceed());
        assertEquals("ER0081", result.getErrorCode());
        assertNotNull(queryCondition.get());
        assertEquals("1100609900000000", queryCondition.get().getBaseAcctNo());
    }

    // ST007-TC005：REQ-001-S01 —— 输入契约：输入 BO 以字段名 othBaseAcctNo、类型 java.lang.String
    // 接收对手账号，且不声明「## 输入」表以外的业务入参字段
    @Test
    void testST007T05() throws Exception {
        Field field = ST007InputBO.class.getDeclaredField("othBaseAcctNo");
        assertNotNull(field);
        assertEquals(String.class, field.getType());

        Set<String> declaredNames = Arrays.stream(ST007InputBO.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toCollection(HashSet::new));
        assertEquals(Set.of("othBaseAcctNo"), declaredNames);
    }

    // ST007-TC006：REQ-005-S01 —— 输出契约：输出 BO 继承 StepResult，自身声明
    // internalKey／baseAcctNo／acctStatus 三个字段，不新增输出字段、不把检查结果作为输出字段
    @Test
    void testST007T06() throws Exception {
        assertTrue(StepResult.class.isAssignableFrom(ST007OutputBO.class));
        assertEquals(Integer.class, ST007OutputBO.class.getDeclaredField("internalKey").getType());
        assertEquals(String.class, ST007OutputBO.class.getDeclaredField("baseAcctNo").getType());
        assertEquals(AcctStatus.class, ST007OutputBO.class.getDeclaredField("acctStatus").getType());

        Set<String> declaredNames = Arrays.stream(ST007OutputBO.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toCollection(HashSet::new));
        assertEquals(Set.of("internalKey", "baseAcctNo", "acctStatus"), declaredNames);
    }

    // ST007-TC007：REQ-005-S02 —— acctStatus 的枚举绑定与取值域：字段类型为 AcctStatus，
    // Spec 列举的 11 个码值均可由该枚举解析且 getValue() 返回同名码值
    @Test
    void testST007T07() throws Exception {
        assertEquals(AcctStatus.class, ST007OutputBO.class.getDeclaredField("acctStatus").getType());

        String[] codes = {"A", "C", "D", "H", "I", "N", "O", "P", "R", "S", "U"};
        for (String code : codes) {
            AcctStatus status = AcctStatus.byValue(code);
            assertNotNull(status, code);
            assertEquals(code, status.getValue());
        }
    }

    // ST007-TC008：REQ-005-S03、REQ-006-S01 —— 三个输出字段均为「非必填」，
    // 不施加输出取值期望时步骤结果仍为「通过」；不对三个输出字段的取值作断言
    @Test
    void testST007T08() {
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(acct(1004, "1100602187654321", AcctStatus.A));
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(records);

        ST007InputBO bo = new ST007InputBO();
        bo.setOthBaseAcctNo("1100602187654321");

        ST007OutputBO result = st007Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST007-TC009：REQ-006-S03 —— 只读检查：在【账户信息】有记录与无记录两种数据状态下各执行一次，
    // 分别落到「通过」与 ER0081；按技能约定不使用交互验证，写入型依赖未被调用一事不宣称已验证
    @Test
    void testST007T09() {
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(acct(1004, "1100602187654321", AcctStatus.A));
        Mockito.lenient().when(irBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(records)
                .thenReturn(Collections.emptyList());

        ST007InputBO firstBo = new ST007InputBO();
        firstBo.setOthBaseAcctNo("1100602187654321");
        ST007OutputBO firstResult = st007Pbc.execute(firstBo);

        ST007InputBO secondBo = new ST007InputBO();
        secondBo.setOthBaseAcctNo("1100609900000000");
        ST007OutputBO secondResult = st007Pbc.execute(secondBo);

        assertTrue(firstResult.isSucceed());
        assertNull(firstResult.getErrorCode());
        assertFalse(secondResult.isSucceed());
        assertEquals("ER0081", secondResult.getErrorCode());
    }

    /**
     * 构造用于设桩的账户记录（仅承载存在性判定所需的集合元素，其取值不作业务断言）。
     */
    private RbBusAcctEO acct(Integer internalKey, String baseAcctNo, AcctStatus acctStatus) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setInternalKey(internalKey);
        eo.setBaseAcctNo(baseAcctNo);
        eo.setAcctStatus(acctStatus);
        return eo;
    }
}

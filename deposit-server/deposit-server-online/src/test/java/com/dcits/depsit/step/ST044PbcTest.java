package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST044InputBO;
import com.dcits.depsit.facade.bo.ST044OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST044 检查账户存在性 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST044-TC001 至 ST044-TC007，覆盖 Spec REQ-001 至 REQ-005 的已定义分支：
 * 查询到记录 → {@code succeed = true}（「通过」）；查询无记录 → {@code succeed = false} 且
 * {@code errorCode = "ER0048"}。两个子步骤顺序固定，无跳转、无循环、无提前返回。</p>
 *
 * <p>【账户信息】的数据源在 Spec 中未绑定（不覆盖事项第 1 项），用例以工程内既有的
 * {@link IRbBusAcctBcc#findByEo(RbBusAcctEO)} 作为查询承载，业务断言只落在步骤结果与查询请求携带的账号值上，
 * 不对数据源绑定本身作断言。按技能约定不使用 {@code verify}，故查询请求的账号以桩的 answer 记录后断言。</p>
 *
 * <p>未定义行为不生成用例：账号入参取空、查询调用技术异常、查询接口返回 {@code null}、
 * 输出字段 {@code baseAcctNo} 的取值来源与出现条件，均无 Spec 依据，不作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST044PbcTest {

    /** 示例账号：在【账户信息】中对应记录 */
    private static final String ACCT_WITH_RECORD = "1100602112345678";

    /** 示例账号：在【账户信息】中无对应记录 */
    private static final String ACCT_WITHOUT_RECORD = "1100609999999999";

    /** 错误码：[账户信息] 不存在 */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 被测步骤的查询依赖【账户信息】数据服务 */
    @Mock
    private IRbBusAcctBcc iRbBusAcctBcc;

    @InjectMocks
    private ST044Pbc st044Pbc;

    /** 构造一条账号为指定值的账户记录。 */
    private static RbBusAcctEO accountRecord(String baseAcctNo) {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo(baseAcctNo);
        return record;
    }

    /** REQ-002-S01、REQ-004-S01、REQ-005-S01：账号对应 1 条记录 → 步骤 1 取得 [账户信息]，步骤 2 判定存在，返回「通过」（ST044-TC001）。 */
    @Test
    void testST044T01() {
        RbBusAcctEO record = accountRecord(ACCT_WITH_RECORD);
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO result = st044Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    /** REQ-004-S02：同一账号对应 2 条记录时按第 2 步「否则」分支直接读法仍返回「通过」（ST044-TC002）。 */
    @Test
    void testST044T02() {
        RbBusAcctEO record1 = accountRecord(ACCT_WITH_RECORD);
        RbBusAcctEO record2 = accountRecord(ACCT_WITH_RECORD);
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(record1, record2));

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO result = st044Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    /** REQ-003-S01、REQ-005-S02：账号无记录（空集合）→ 返回错误码 ER0048，不返回「通过」、不以异常表达（ST044-TC003）。 */
    @Test
    void testST044T03() {
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of());

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITHOUT_RECORD);
        ST044OutputBO result = assertDoesNotThrow(() -> st044Pbc.execute(input));

        assertFalse(result.isSucceed());
        assertEquals(ERROR_CODE_ACCT_NOT_EXIST, result.getErrorCode());
    }

    /** REQ-001-S01、REQ-002-S01、REQ-002-S02：以入参账号为查询条件，结论随查询结果变化（ST044-TC004）。 */
    @Test
    void testST044T04() {
        Map<String, List<RbBusAcctEO>> recordsByAccount = new HashMap<>();
        recordsByAccount.put(ACCT_WITH_RECORD, List.of(accountRecord(ACCT_WITH_RECORD)));
        recordsByAccount.put(ACCT_WITHOUT_RECORD, List.of());
        List<String> queriedAccounts = new ArrayList<>();
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            RbBusAcctEO queryEo = invocation.getArgument(0);
            queriedAccounts.add(queryEo.getBaseAcctNo());
            return recordsByAccount.getOrDefault(queryEo.getBaseAcctNo(), List.of());
        });

        ST044InputBO inputA = new ST044InputBO();
        inputA.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO resultA = st044Pbc.execute(inputA);

        ST044InputBO inputB = new ST044InputBO();
        inputB.setBaseAcctNo(ACCT_WITHOUT_RECORD);
        ST044OutputBO resultB = st044Pbc.execute(inputB);

        assertTrue(resultA.isSucceed());
        assertNull(resultA.getErrorCode());
        assertFalse(resultB.isSucceed());
        assertEquals(ERROR_CODE_ACCT_NOT_EXIST, resultB.getErrorCode());
        assertEquals(ACCT_WITH_RECORD, queriedAccounts.get(0));
        assertEquals(ACCT_WITHOUT_RECORD, queriedAccounts.get(1));
    }

    /** REQ-004-S01：记录的其它字段取非默认值时仍视为存在、返回「通过」，判定不依赖其它字段（ST044-TC005）。 */
    @Test
    void testST044T05() {
        RbBusAcctEO record = accountRecord(ACCT_WITH_RECORD);
        record.setAcctName("测试账户名称");
        record.setClientNo("9000000001");
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO result = st044Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    /** REQ-005-S03：只读检查，执行后桩提供的记录与集合未被步骤改写（ST044-TC006）。 */
    @Test
    void testST044T06() {
        RbBusAcctEO record = accountRecord(ACCT_WITH_RECORD);
        record.setAcctName("测试账户名称");
        List<RbBusAcctEO> records = new ArrayList<>();
        records.add(record);
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(records);

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO result = st044Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertEquals(ACCT_WITH_RECORD, record.getBaseAcctNo());
        assertEquals("测试账户名称", record.getAcctName());
        assertEquals(1, records.size());
    }

    /** REQ-005-S04：输出 BO 继承 StepResult，自身只声明 baseAcctNo 一个业务输出字段（ST044-TC007）。 */
    @Test
    void testST044T07() throws NoSuchFieldException {
        RbBusAcctEO record = accountRecord(ACCT_WITH_RECORD);
        lenient().when(iRbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST044InputBO input = new ST044InputBO();
        input.setBaseAcctNo(ACCT_WITH_RECORD);
        ST044OutputBO result = st044Pbc.execute(input);

        assertInstanceOf(ST044OutputBO.class, result);
        assertTrue(result instanceof com.dcits.common.step.StepResult);
        Set<String> declaredFieldNames = new HashSet<>();
        for (Field field : ST044OutputBO.class.getDeclaredFields()) {
            declaredFieldNames.add(field.getName());
        }
        assertEquals(Set.of("baseAcctNo"), declaredFieldNames);
        assertEquals(String.class, ST044OutputBO.class.getDeclaredField("baseAcctNo").getType());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }
}

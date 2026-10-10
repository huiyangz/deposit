package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.facade.bo.ST134InputBO;
import com.dcits.depsit.facade.bo.ST134OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST134 解限更新账户冻结金额的单元测试。
 *
 * <p>用例依据：Spec REQ-001～REQ-007 与 `outputs/测试用例.md` ST134-TC001～TC008。
 * 【账户信息】的数据源绑定（{@code IRbBusAcctBcc#findByEo}）与余额写入方式（先查后改、
 * selective 更新）在 Spec 中为不覆盖事项，本测试仅作为执行载体，断言只落在查询条件取值、
 * 写入负载业务字段与最终步骤结论上；不使用 verify/never/times/InOrder。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST134PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

    @InjectMocks
    private ST134Pbc pbc;

    // ST134-TC001：REQ-001-S01/S02 输入契约——ST134InputBO 只承载唯一入参 baseAcctNo（String），
    // 账户内部键值等不作为调用方入参；本用例不执行步骤
    @Test
    void testST134T01() {
        List<Field> businessFields = businessDeclaredFields(ST134InputBO.class);
        assertEquals(1, businessFields.size());
        Field field = businessFields.get(0);
        assertEquals("baseAcctNo", field.getName());
        assertEquals(String.class, field.getType());
    }

    // ST134-TC002：REQ-001-S02、REQ-002-S01、REQ-003-S01、REQ-004-S01、REQ-006-S01、REQ-007-S01
    // 完整成功链路——按账号查到账户取得键值 1000000001，按键值把冻结金额由 5000.00 更新为 0，输出承载 0
    @Test
    void testST134T02() {
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setBaseAcctNo("1100602112345678");
        acctEo.setInternalKey(1000000001);
        RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
        balEo.setInternalKey(1000000001);
        balEo.setPldAmount(new BigDecimal("5000.00"));
        stubAccountQuery(capturedAcctEo, List.of(acctEo));
        stubBalanceHolder(1000000001, balEo);
        stubBalanceQuery(List.of(balEo));
        stubBalanceModify(writePayload, 1);

        ST134InputBO input = new ST134InputBO();
        input.setBaseAcctNo("1100602112345678");
        ST134OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("1100602112345678", capturedAcctEo.get().getBaseAcctNo());
        assertEquals(Integer.valueOf(1000000001), writePayload.get().getInternalKey());
        assertEquals(0, writePayload.get().getPldAmount().compareTo(BigDecimal.ZERO));
        assertEquals(0, out.getPldAmount().compareTo(BigDecimal.ZERO));
    }

    // ST134-TC003：REQ-003-S02 边界——命中余额记录但原冻结金额已是 0.00 时写入取值不因原值改变，仍为 0
    @Test
    void testST134T03() {
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setBaseAcctNo("1100602112345678");
        acctEo.setInternalKey(1000000001);
        RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
        balEo.setInternalKey(1000000001);
        balEo.setPldAmount(new BigDecimal("0.00"));
        stubAccountQuery(capturedAcctEo, List.of(acctEo));
        stubBalanceHolder(1000000001, balEo);
        stubBalanceQuery(List.of(balEo));
        stubBalanceModify(writePayload, 1);

        ST134InputBO input = new ST134InputBO();
        input.setBaseAcctNo("1100602112345678");
        ST134OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertEquals(Integer.valueOf(1000000001), writePayload.get().getInternalKey());
        assertEquals(0, writePayload.get().getPldAmount().compareTo(BigDecimal.ZERO));
        assertEquals(0, out.getPldAmount().compareTo(BigDecimal.ZERO));
    }

    // ST134-TC004：REQ-004-S02（并结合 REQ-002-S01、REQ-004-S01）两个账号分别取得各自的账户内部键值，
    // 并各自定位到自己的余额记录；baseAcctNo 本身不作余额表定位字段
    @Test
    void testST134T04() {
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();

        // 场景 A：账号 1100602112345678 → 账户内部键值 1000000001
        RbBusAcctEO acctEoA = new RbBusAcctEO();
        acctEoA.setBaseAcctNo("1100602112345678");
        acctEoA.setInternalKey(1000000001);
        RbBusAcctBalanceEO balEoA = new RbBusAcctBalanceEO();
        balEoA.setInternalKey(1000000001);
        balEoA.setPldAmount(new BigDecimal("5000.00"));
        stubAccountQuery(capturedAcctEo, List.of(acctEoA));
        stubBalanceHolder(1000000001, balEoA);
        stubBalanceQuery(List.of(balEoA));
        stubBalanceModify(writePayload, 1);

        ST134InputBO inputA = new ST134InputBO();
        inputA.setBaseAcctNo("1100602112345678");
        ST134OutputBO outA = pbc.execute(inputA);

        assertTrue(outA.isSucceed());
        assertEquals(Integer.valueOf(1000000001), writePayload.get().getInternalKey());
        assertEquals(0, writePayload.get().getPldAmount().compareTo(BigDecimal.ZERO));
        assertEquals(0, outA.getPldAmount().compareTo(BigDecimal.ZERO));

        // 场景 B：账号 1100602112345679 → 账户内部键值 1000000002
        RbBusAcctEO acctEoB = new RbBusAcctEO();
        acctEoB.setBaseAcctNo("1100602112345679");
        acctEoB.setInternalKey(1000000002);
        RbBusAcctBalanceEO balEoB = new RbBusAcctBalanceEO();
        balEoB.setInternalKey(1000000002);
        balEoB.setPldAmount(new BigDecimal("1250.50"));
        stubAccountQuery(capturedAcctEo, List.of(acctEoB));
        stubBalanceHolder(1000000002, balEoB);
        stubBalanceQuery(List.of(balEoB));

        ST134InputBO inputB = new ST134InputBO();
        inputB.setBaseAcctNo("1100602112345679");
        ST134OutputBO outB = pbc.execute(inputB);

        assertTrue(outB.isSucceed());
        assertEquals(Integer.valueOf(1000000002), writePayload.get().getInternalKey());
        assertEquals(0, writePayload.get().getPldAmount().compareTo(BigDecimal.ZERO));
        assertEquals(0, outB.getPldAmount().compareTo(BigDecimal.ZERO));
    }

    // ST134-TC005：REQ-005-S01 失败情形 (a)——按账号查不到账户、未取得账户内部键值，
    // 返回 ER0048 并结束本步骤，不执行更新
    @Test
    void testST134T05() {
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        stubAccountQuery(capturedAcctEo, List.of());

        ST134InputBO input = new ST134InputBO();
        input.setBaseAcctNo("1100609999999999");
        ST134OutputBO out = pbc.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0048", out.getErrorCode());
        assertEquals("1100609999999999", capturedAcctEo.get().getBaseAcctNo());
    }

    // ST134-TC006：REQ-005-S02 失败情形 (b)——已取得账户内部键值 1000000001，但该账户没有余额记录，
    // 返回与 (a) 相同的错误码 ER0048，不因已取得键值而返回成功结论
    @Test
    void testST134T06() {
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setBaseAcctNo("1100602112345678");
        acctEo.setInternalKey(1000000001);
        stubAccountQuery(capturedAcctEo, List.of(acctEo));
        stubBalanceHolder(1000000001, null);
        stubBalanceQuery(List.of());
        stubBalanceModify(writePayload, 0);

        ST134InputBO input = new ST134InputBO();
        input.setBaseAcctNo("1100602112345678");
        ST134OutputBO out = pbc.execute(input);

        assertFalse(out.isSucceed());
        assertEquals("ER0048", out.getErrorCode());
    }

    // ST134-TC007：REQ-005-S03、REQ-007-S02 业务失败口径唯一——两种失败数据状态（查不到账户 /
    // 该账户没有余额记录）结论形态一致：同一错误码 ER0048、均不表达为成功、均以返回值形式给出
    @Test
    void testST134T07() {
        // 第一次：查不到账户
        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        stubAccountQuery(capturedAcctEo, List.of());

        ST134InputBO inputA = new ST134InputBO();
        inputA.setBaseAcctNo("1100609999999999");
        ST134OutputBO outA = pbc.execute(inputA);

        assertFalse(outA.isSucceed());
        assertEquals("ER0048", outA.getErrorCode());

        // 第二次：账户命中但该账户没有余额记录
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setBaseAcctNo("1100602112345678");
        acctEo.setInternalKey(1000000001);
        stubAccountQuery(capturedAcctEo, List.of(acctEo));
        stubBalanceHolder(1000000001, null);
        stubBalanceQuery(List.of());
        stubBalanceModify(writePayload, 0);

        ST134InputBO inputB = new ST134InputBO();
        inputB.setBaseAcctNo("1100602112345678");
        ST134OutputBO outB = pbc.execute(inputB);

        assertFalse(outB.isSucceed());
        assertEquals("ER0048", outB.getErrorCode());
    }

    // ST134-TC008：REQ-006-S01 输出契约——ST134OutputBO 继承真实 StepResult，业务输出字段恰为
    // pldAmount（java.math.BigDecimal）；成功路径输出取值等于本次写入的 0、不是原值 5000.00
    @Test
    void testST134T08() {
        assertSame(StepResult.class, ST134OutputBO.class.getSuperclass());
        List<Field> businessFields = businessDeclaredFields(ST134OutputBO.class);
        assertEquals(1, businessFields.size());
        Field field = businessFields.get(0);
        assertEquals("pldAmount", field.getName());
        assertEquals(BigDecimal.class, field.getType());

        AtomicReference<RbBusAcctEO> capturedAcctEo = new AtomicReference<>();
        AtomicReference<RbBusAcctBalanceEO> writePayload = new AtomicReference<>();
        RbBusAcctEO acctEo = new RbBusAcctEO();
        acctEo.setBaseAcctNo("1100602112345678");
        acctEo.setInternalKey(1000000001);
        RbBusAcctBalanceEO balEo = new RbBusAcctBalanceEO();
        balEo.setInternalKey(1000000001);
        balEo.setPldAmount(new BigDecimal("5000.00"));
        stubAccountQuery(capturedAcctEo, List.of(acctEo));
        stubBalanceHolder(1000000001, balEo);
        stubBalanceQuery(List.of(balEo));
        stubBalanceModify(writePayload, 1);

        ST134InputBO input = new ST134InputBO();
        input.setBaseAcctNo("1100602112345678");
        ST134OutputBO out = pbc.execute(input);

        assertTrue(out.isSucceed());
        assertEquals(0, out.getPldAmount().compareTo(BigDecimal.ZERO));
        assertEquals(0, out.getPldAmount().compareTo(writePayload.get().getPldAmount()));
        assertNotEquals(0, out.getPldAmount().compareTo(new BigDecimal("5000.00")));
    }

    /** 按账号查询【账户信息】的桩：记录查询实参并返回给定账户记录集合（Spec 不覆盖事项第 3 项：非需求确认的数据源绑定）。 */
    private void stubAccountQuery(AtomicReference<RbBusAcctEO> captured, List<RbBusAcctEO> result) {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            captured.set(invocation.getArgument(0));
            return result;
        });
    }

    /** 按账户内部键值取单条余额记录的桩。 */
    private void stubBalanceHolder(Integer internalKey, RbBusAcctBalanceEO result) {
        lenient().when(rbBusAcctBalanceBcc.findByPrimaryKey(internalKey)).thenReturn(result);
    }

    /** 按余额实体条件查询的桩（兼容「先查后改」实现分支）。 */
    private void stubBalanceQuery(List<RbBusAcctBalanceEO> result) {
        lenient().when(rbBusAcctBalanceBcc.findByEo(any(RbBusAcctBalanceEO.class))).thenReturn(result);
    }

    /** 余额写入的桩：捕获写入负载业务字段并返回给定影响行数（selective 与非 selective 双桩）。 */
    private void stubBalanceModify(AtomicReference<RbBusAcctBalanceEO> payload, int affectedRows) {
        lenient().when(rbBusAcctBalanceBcc.modifyByPrimaryKeySelective(any(RbBusAcctBalanceEO.class)))
                .thenAnswer(invocation -> {
                    payload.set(invocation.getArgument(0));
                    return affectedRows;
                });
        lenient().when(rbBusAcctBalanceBcc.modifyByPrimaryKey(any(RbBusAcctBalanceEO.class)))
                .thenAnswer(invocation -> {
                    payload.set(invocation.getArgument(0));
                    return affectedRows;
                });
    }

    /** 取类中声明的业务字段（过滤 static 与 synthetic）。 */
    private static List<Field> businessDeclaredFields(Class<?> type) {
        return Arrays.stream(type.getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .filter(field -> !field.isSynthetic())
                .toList();
    }
}

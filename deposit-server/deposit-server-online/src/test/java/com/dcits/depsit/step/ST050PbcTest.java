package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST050InputBO;
import com.dcits.depsit.facade.bo.ST050OutputBO;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * ST050 设置贷记交易的借贷标志 单元测试（交易执行步骤）。
 *
 * <p>用例来源：`outputs/测试用例.md` ST050-TC001 至 ST050-TC005，对应 Spec REQ-001、REQ-002 的全部场景与
 * REQ-003-S01。本步骤无输入、无子步骤、无分支与循环、无依赖调用，全部用例共用唯一执行路径，故不设桩、
 * 不使用 Mockito，被测对象为真实实例 {@link ST050Pbc}。</p>
 *
 * <p>REQ-003-S02（技术异常传播）在无输入、无依赖、无分支的实现上无可构造的确定路径，Spec 与用例均未为其
 * 生成用例；其“不以 {@link CrDrInd#D}、空值或其它默认取值兜底”的部分由全部用例的反向断言覆盖。</p>
 */
class ST050PbcTest {

    /** 每个用例独立构造被测的真实实例：本步骤无依赖需注入。 */
    private final IST050 st050Pbc = new ST050Pbc();

    // 唯一执行路径：赋值 [借贷标志] 为“贷方”（源需求「## 步骤描述」第 5 行单条赋值动作）
    /** REQ-001-S01 赋值为贷方：crDrInd 等于 CrDrInd.C、码值为 "C"，且不等于 CrDrInd.D（ST050-TC001）。 */
    @Test
    void testST050T01() {
        ST050OutputBO out = st050Pbc.execute(new ST050InputBO());

        assertSame(CrDrInd.C, out.getCrDrInd());
        assertEquals("C", out.getCrDrInd().getValue());
        assertNotEquals(CrDrInd.D, out.getCrDrInd());
    }

    /** REQ-001-S02 输出字段契约与成功路径必赋值：crDrInd 非空且类型正确，输出 BO 业务字段仅 crDrInd（ST050-TC002）。 */
    @Test
    void testST050T02() {
        ST050OutputBO out = st050Pbc.execute(new ST050InputBO());

        assertNotNull(out.getCrDrInd());
        assertInstanceOf(CrDrInd.class, out.getCrDrInd());
        assertSame(CrDrInd.C, out.getCrDrInd());
        assertEquals(Set.of("crDrInd"), declaredBusinessFieldNames());
    }

    /** REQ-002-S01 无输入也能完成赋值与返回：不设置任何输入字段仍正常完成并返回贷方（ST050-TC003）。 */
    @Test
    void testST050T03() {
        ST050OutputBO out = st050Pbc.execute(new ST050InputBO());

        assertTrue(out.isSucceed());
        assertNotNull(out.getCrDrInd());
        assertSame(CrDrInd.C, out.getCrDrInd());
    }

    /** REQ-002-S02 执行不产生副作用与数据访问：同一输入重复调用取值确定一致，无需任何依赖装配（ST050-TC004）。 */
    @Test
    void testST050T04() {
        ST050OutputBO out1 = st050Pbc.execute(new ST050InputBO());
        ST050OutputBO out2 = st050Pbc.execute(new ST050InputBO());

        assertTrue(out1.isSucceed());
        assertSame(CrDrInd.C, out1.getCrDrInd());
        assertTrue(out2.isSucceed());
        assertSame(CrDrInd.C, out2.getCrDrInd());
    }

    /** REQ-003-S01 正常执行的结果状态：succeed = true，errorCode 与 errorMessage 均为 null（ST050-TC005）。 */
    @Test
    void testST050T05() {
        ST050OutputBO out = st050Pbc.execute(new ST050InputBO());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertSame(CrDrInd.C, out.getCrDrInd());
    }

    /**
     * 取 {@link ST050OutputBO} 自身声明的非 static、非 synthetic 字段名集合。
     *
     * <p>用于核对别名「输出数据-借贷标志」未产生第二个输出字段；继承自
     * {@code com.dcits.common.step.StepResult} 的 succeed / errorCode / errorMessage 不计入。</p>
     */
    private static Set<String> declaredBusinessFieldNames() {
        Set<String> names = new HashSet<>();
        for (Field field : ST050OutputBO.class.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !field.isSynthetic()) {
                names.add(field.getName());
            }
        }
        return names;
    }
}

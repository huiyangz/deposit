package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.facade.bo.ST065InputBO;
import com.dcits.depsit.facade.bo.ST065OutputBO;
import com.dcits.depsit.facade.components.IRbBusinessParameterBcc;
import com.dcits.depsit.facade.eo.RbBusinessParameterEO;

/**
 * ST065 检查分位金额 的单元测试。
 *
 * <p>调用签名：{@code ST065OutputBO execute(ST065InputBO input)}。本步骤唯一的运行期依赖为
 * 子步骤1 的参数取数（{@link IRbBusinessParameterBcc#findByPrimaryKey(String)}），
 * 全部用例只对该依赖设桩；TC001、TC011 为声明契约核对，不执行步骤、不设桩。</p>
 *
 * <p>按 Spec「依赖调用／短路」，判定通过分支与失败分支均无后续步骤绑定，也没有跳转与遍历语义，
 * 故无用例分类为跳转路径。错误信息文案未在 Spec 定义，失败用例不对其作等值断言；
 * 失败路径下 paraValue 的承载属 Spec 不覆盖事项，不断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST065PbcTest {

    /** 子步骤1 参数取数依赖（存款业务参数表数据服务） */
    @Mock
    private IRbBusinessParameterBcc rbBusinessParameterBcc;

    /** 被测步骤实现 */
    @InjectMocks
    private ST065Pbc st065Pbc;

    // ST065-TC001：REQ-001-S01／REQ-001-S02 输入契约——入参恰为「分位金额」(BigDecimal) 与「分位处理金额分位上限」(String) 2 个字段，无第 3 个输入
    @Test
    void testST065T01() {
        Map<String, Class<?>> fieldTypes = declaredInstanceFieldTypes(ST065InputBO.class);

        assertEquals(Set.of("分位金额", "分位处理金额分位上限"), fieldTypes.keySet());
        assertEquals(2, fieldTypes.size());
        assertEquals(BigDecimal.class, fieldTypes.get("分位金额"));
        assertEquals(String.class, fieldTypes.get("分位处理金额分位上限"));
    }

    // ST065-TC002：REQ-002-S01/S02、REQ-003-S01、REQ-006-S01——按参数名称 LIMIT_CENT_AMT 取数，分位金额等于上限（等于边界）→ 通过，且 paraValue 与判定所用上限同源
    @Test
    void testST065T02() {
        AtomicReference<String> capturedKey = new AtomicReference<>();
        RbBusinessParameterEO parameter = parameter("LIMIT_CENT_AMT", "0.01");
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey(Mockito.anyString()))
                .thenAnswer(invocation -> {
                    capturedKey.set(invocation.getArgument(0));
                    return parameter;
                });

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("0.01"));
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("0.01", output.getParaValue());
        assertEquals("LIMIT_CENT_AMT", capturedKey.get());
    }

    // ST065-TC003：REQ-003-S02——分位金额 0.005 小于上限 0.01 → 检查结果为「通过」，不产出错误码
    @Test
    void testST065T03() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("0.005"));
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("0.01", output.getParaValue());
    }

    // ST065-TC004：REQ-003-S03——分位金额取取值域下界 0.00（数值 0）→ 仍为「通过」
    @Test
    void testST065T04() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("0.00"));
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("0.01", output.getParaValue());
    }

    // ST065-TC005：REQ-004-S01——分位金额 0.02 略大于上限 0.01（大于边界）→ 返回错误码 ER0069，不返回「通过」
    @Test
    void testST065T05() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("0.02"));
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0069", output.getErrorCode());
    }

    // ST065-TC006：REQ-004-S02——分位金额 100.00 远大于上限 0.01，判定不因超出幅度而改变 → 错误码 ER0069
    @Test
    void testST065T06() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("100.00"));
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0069", output.getErrorCode());
    }

    // ST065-TC007：REQ-005-S01——标度不同的等值判定一致：0.010（标度 3）与上限 "0.01" 数值相等 → 通过，且入参标度不变
    @Test
    void testST065T07() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        BigDecimal 分位金额 = new BigDecimal("0.010");
        ST065InputBO input = new ST065InputBO();
        input.set分位金额(分位金额);
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("0.01", output.getParaValue());
        assertEquals(new BigDecimal("0.010"), 分位金额);
        assertEquals(3, 分位金额.scale());
    }

    // ST065-TC008：REQ-005-S02——尾随零不改变判定：分位金额 1.0 与上限 "1" 数值相等 → 通过，paraValue 原样承载 "1"
    @Test
    void testST065T08() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "1"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("1.0"));
        input.set分位处理金额分位上限("1");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("1", output.getParaValue());
    }

    // ST065-TC009：REQ-005-S02——尾随零的另一书写方向：分位金额 1（标度 0）与上限 "1.0" 数值相等 → 通过
    @Test
    void testST065T09() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "1.0"));

        ST065InputBO input = new ST065InputBO();
        input.set分位金额(new BigDecimal("1"));
        input.set分位处理金额分位上限("1.0");

        ST065OutputBO output = st065Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertEquals("1.0", output.getParaValue());
    }

    // ST065-TC010：REQ-005-S03——判定不做舍入或标度规整：0.0101 大于 0.01 → 错误码 ER0069，且执行前后入参取值与标度不变
    @Test
    void testST065T10() {
        Mockito.lenient().when(rbBusinessParameterBcc.findByPrimaryKey("LIMIT_CENT_AMT"))
                .thenReturn(parameter("LIMIT_CENT_AMT", "0.01"));

        BigDecimal 分位金额 = new BigDecimal("0.0101");
        ST065InputBO input = new ST065InputBO();
        input.set分位金额(分位金额);
        input.set分位处理金额分位上限("0.01");

        ST065OutputBO output = st065Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0069", output.getErrorCode());
        assertEquals(new BigDecimal("0.0101"), 分位金额);
        assertEquals(4, 分位金额.scale());
    }

    // ST065-TC011：REQ-006-S02 输出契约——业务字段恰为 1 个 paraValue（String），输出 BO 继承 StepResult，且不重复声明状态字段
    @Test
    void testST065T11() {
        Map<String, Class<?>> fieldTypes = declaredInstanceFieldTypes(ST065OutputBO.class);

        assertEquals(Set.of("paraValue"), fieldTypes.keySet());
        assertEquals(1, fieldTypes.size());
        assertEquals(String.class, fieldTypes.get("paraValue"));
        assertTrue(StepResult.class.isAssignableFrom(ST065OutputBO.class));
    }

    /** 构造参数表 EO 桩数据（子步骤1 取数返回）。 */
    private static RbBusinessParameterEO parameter(String paraKey, String paraValue) {
        RbBusinessParameterEO parameter = new RbBusinessParameterEO();
        parameter.setParaKey(paraKey);
        parameter.setParaValue(paraValue);
        return parameter;
    }

    /** 取类自身声明的非静态、非合成字段的名称与类型映射（用于声明契约核对）。 */
    private static Map<String, Class<?>> declaredInstanceFieldTypes(Class<?> type) {
        Map<String, Class<?>> fieldTypes = new HashMap<>();
        for (Field field : type.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || field.isSynthetic()) {
                continue;
            }
            fieldTypes.put(field.getName(), field.getType());
        }
        return fieldTypes;
    }
}

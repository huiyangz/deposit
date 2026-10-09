package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST127InputBO;
import com.dcits.depsit.facade.bo.ST127OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST127 检查限制类型的单元测试。
 *
 * <p>调用签名：{@code ST127OutputBO execute(ST127InputBO input)}。源需求无「## 输出」表，
 * 未定义检查结果的字段名与类型，故「通过」映射为 {@code StepResult.succeed=true}、
 * 「不通过」映射为 {@code StepResult.succeed=false}，两种结论的 {@code errorCode} /
 * {@code errorMessage} 均为 null（本步骤无业务失败场景，不以错误码表达结论）。</p>
 *
 * <p>唯一依赖为步骤1 的只读查询 {@link IRbRestraintTypeBcc#findByRestraintType(RestraintType)}，
 * 本测试只对该方法设桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST127PbcTest {

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST127Pbc st127Pbc;

    // ST127-TC001：输入契约与别名归属——本步骤恰有两个输入字段，别名不产生重复输入；输出为 StepResult 的子类
    @Test
    void testST127T01() {
        Map<String, String> fieldTypes = new HashMap<>();
        for (Field field : ST127InputBO.class.getDeclaredFields()) {
            fieldTypes.put(field.getName(), field.getType().getName());
        }
        assertEquals(2, fieldTypes.size());
        assertEquals(RestraintType.class.getName(), fieldTypes.get("restraintType"));
        assertEquals(Status.class.getName(), fieldTypes.get("status"));
        assertTrue(StepResult.class.isAssignableFrom(ST127OutputBO.class));
    }

    // ST127-TC002：路径B——按限制类型命中记录且 $状态$ 为 A-有效 → 检查结果「通过」
    @Test
    void testST127T02() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setRestraintTypeDesc("挂失止付");
        eo.setStatus(Status.A);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_13);
        input.setStatus(Status.A);

        ST127OutputBO result = st127Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST127-TC003：判定依据为查得记录的 $状态$——入参 status 与记录 status 不同时以记录为准
    @Test
    void testST127T03() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(Status.A);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_13);
        input.setStatus(Status.F);

        ST127OutputBO result = st127Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC004：取数来源与记录唯一性——查询键精确为 restraintType，取数仅来自该次查询所得单条记录
    @Test
    void testST127T04() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(Status.A);
        // 仅设精确键桩：若实现以其它限制类型为查询键，则返回 null 而结论变为「不通过」
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_13);
        input.setStatus(Status.A);

        ST127OutputBO result = st127Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC005：路径A——查询无匹配记录 → 检查结果「不通过」并短路，无错误码
    @Test
    void testST127T05() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62)).thenReturn(null);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_62);
        input.setStatus(Status.A);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST127-TC006：路径A——记录为空时结论不因状态取值改变，且与「通过」互斥
    @Test
    void testST127T06() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62)).thenReturn(null);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_62);
        input.setStatus(Status.A);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC007：路径C——「继续执行」的边界，非空分支结论由步骤3 给出，无跨步骤跳转
    @Test
    void testST127T07() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_4);
        eo.setStatus(Status.C);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_4);
        input.setStatus(Status.C);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC008：路径C——$状态$ 为 F（无效）→ 检查结果「不通过」
    @Test
    void testST127T08() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(Status.F);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_13);
        input.setStatus(Status.F);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC009：路径C——$状态$ 为 D（删除）→ 检查结果「不通过」，与其它非 A 码值结论一致
    @Test
    void testST127T09() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_16);
        eo.setRestraintTypeDesc("存款证明止付");
        eo.setStatus(Status.D);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_16)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_16);
        input.setStatus(Status.D);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC010：路径C 边界——记录非空但 $状态$ 无值 → 落入「否则」分支，检查结果「不通过」
    @Test
    void testST127T10() {
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(null);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO input = new ST127InputBO();
        input.setRestraintType(RestraintType.VALUE_13);
        input.setStatus(Status.A);

        ST127OutputBO result = st127Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertNull(result.getErrorCode());
    }

    // ST127-TC011：路径C——「否则」分支穷尽性与结果唯一性：C、N、P 分别判「不通过」
    @Test
    void testST127T11() {
        RbRestraintTypeEO eo1 = new RbRestraintTypeEO();
        eo1.setRestraintType(RestraintType.VALUE_13);
        eo1.setStatus(Status.C);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo1);

        RbRestraintTypeEO eo2 = new RbRestraintTypeEO();
        eo2.setRestraintType(RestraintType.VALUE_14);
        eo2.setStatus(Status.N);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_14)).thenReturn(eo2);

        RbRestraintTypeEO eo3 = new RbRestraintTypeEO();
        eo3.setRestraintType(RestraintType.VALUE_15);
        eo3.setStatus(Status.P);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_15)).thenReturn(eo3);

        ST127InputBO first = new ST127InputBO();
        first.setRestraintType(RestraintType.VALUE_13);
        first.setStatus(Status.C);
        ST127OutputBO firstResult = st127Pbc.execute(first);
        assertFalse(firstResult.isSucceed());
        assertNull(firstResult.getErrorCode());

        ST127InputBO second = new ST127InputBO();
        second.setRestraintType(RestraintType.VALUE_14);
        second.setStatus(Status.N);
        ST127OutputBO secondResult = st127Pbc.execute(second);
        assertFalse(secondResult.isSucceed());
        assertNull(secondResult.getErrorCode());

        ST127InputBO third = new ST127InputBO();
        third.setRestraintType(RestraintType.VALUE_15);
        third.setStatus(Status.P);
        ST127OutputBO thirdResult = st127Pbc.execute(third);
        assertFalse(thirdResult.isSucceed());
        assertNull(thirdResult.getErrorCode());
    }

    // ST127-TC012：「不通过」的两条来源结论一致且均无错误码（存在性为空、状态非 A）
    @Test
    void testST127T12() {
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_62)).thenReturn(null);

        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.VALUE_13);
        eo.setStatus(Status.F);
        Mockito.lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_13)).thenReturn(eo);

        ST127InputBO first = new ST127InputBO();
        first.setRestraintType(RestraintType.VALUE_62);
        first.setStatus(Status.A);
        ST127OutputBO firstResult = st127Pbc.execute(first);
        assertFalse(firstResult.isSucceed());
        assertNull(firstResult.getErrorCode());
        assertNull(firstResult.getErrorMessage());

        ST127InputBO second = new ST127InputBO();
        second.setRestraintType(RestraintType.VALUE_13);
        second.setStatus(Status.F);
        ST127OutputBO secondResult = st127Pbc.execute(second);
        assertFalse(secondResult.isSucceed());
        assertNull(secondResult.getErrorCode());
        assertNull(secondResult.getErrorMessage());
    }
}

package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST057InputBO;
import com.dcits.depsit.facade.bo.ST057OutputBO;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST057 检查支取交易类型 —— 单元测试。
 *
 * <p>调用签名：{@code ST057OutputBO execute(ST057InputBO input)}。用例依据本轮正式 Spec 与
 * {@code outputs/测试用例.md}／{@code .json} 的 10 个用例设计，覆盖子步骤 1 的三字段取数产出、
 * 子步骤 1 → 子步骤 2 的取值传递、子步骤 2 的通过分支与「否则」失败分支、错误码 {@code ER0067}
 * 的返回，以及输入／输出字段的契约核对。</p>
 *
 * <p>结果表达的断言口径（Spec REQ-003／REQ-004／REQ-006）：三条件同时成立→{@code isSucceed() == true}
 * 且两个错误字段为 null；任一条件不成立→{@code isSucceed() == false} 且 {@code getErrorCode()} 等于
 * {@code "ER0067"}。失败路径下三个业务输出的取值源需求未定义（Spec 明确不覆盖事项第 2 项），
 * 故失败用例不对 {@code crDrInd}／{@code cashTranFlag}／{@code reversal} 作断言。</p>
 *
 * <p>本步骤只触达一次 {@link IRbTranDefBcc#findByTranType(TranType)} 字典查询，无组件内步骤、
 * 规则或跨组件客户端依赖；按技能约定不设其它桩（包括不设任何写入桩），也不使用
 * {@code verify}/{@code never}/{@code times} 验证交互次数或顺序。Spec 定义的行为是只读的，
 * 测试不模拟技术异常、不访问真实数据库或外部服务。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST057PbcTest {

    @Mock
    private IRbTranDefBcc irTranDefBcc;

    @InjectMocks
    private ST057Pbc st057Pbc;

    // ST057-TC001（REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-005-S01）
    // 正常路径：tranType=1003（现金支取）查得借方/现金/非冲正，子步骤 1 产出三字段，
    // 子步骤 2 三条件（且）同时成立，判定通过并继续执行，不返回 ER0067
    @Test
    void testST057T01() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.D, "Y", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST057-TC002（REQ-001-S02、REQ-005-S02）
    // 契约核对：输入恰 1 个字段（tranType／TranType）、输出恰 3 个业务字段
    // （crDrInd／CrDrInd、cashTranFlag／String、reversal／String），
    // 别名表述不产生重复字段，状态字段由父类 StepResult 承载而不在 OutputBO 重复声明
    @Test
    void testST057T02() {
        Field[] inputFields = ST057InputBO.class.getDeclaredFields();
        assertEquals(1, inputFields.length);
        assertEquals("tranType", inputFields[0].getName());
        assertEquals(TranType.class, inputFields[0].getType());

        Field[] outputFields = ST057OutputBO.class.getDeclaredFields();
        assertEquals(3, outputFields.length);
        Map<String, Class<?>> outputTypes = new HashMap<>();
        for (Field field : outputFields) {
            outputTypes.put(field.getName(), field.getType());
        }
        assertEquals(Set.of("crDrInd", "cashTranFlag", "reversal"), outputTypes.keySet());
        assertEquals(CrDrInd.class, outputTypes.get("crDrInd"));
        assertEquals(String.class, outputTypes.get("cashTranFlag"));
        assertEquals(String.class, outputTypes.get("reversal"));
    }

    // ST057-TC003（REQ-002-S02、REQ-003-S01、REQ-005-S01）
    // 正常路径：tranType=1000（现金存入）为另一合法交易类型码值，步骤1 以该传入值查询
    // 并查得借方/现金/非冲正，步骤2 判定只依据三字段，同样通过
    @Test
    void testST057T03() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef(TranType.VALUE_1000, CrDrInd.D, "Y", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1000);

        ST057OutputBO result = st057Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST057-TC004（REQ-004-S01）
    // 边界否定路径：借贷标志 C（非「D-借方」），其余两条件成立 → 返回 ER0067，不继续执行
    @Test
    void testST057T04() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.C, "Y", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
    }

    // ST057-TC005（REQ-004-S02）
    // 边界否定路径：现金交易标志 "N"（非「Y是」），其余两条件成立 → 返回 ER0067，不继续执行
    // （该组 cashTranFlag 与 reversal 取值相反，可同时识别两字段映射是否倒置）
    @Test
    void testST057T05() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.D, "N", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
    }

    // ST057-TC006（REQ-004-S03）
    // 边界否定路径：冲正交易标志 "Y"（非「N否」，即冲正交易），其余两条件成立 → 返回 ER0067，不继续执行
    @Test
    void testST057T06() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.D, "Y", "Y"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
    }

    // ST057-TC007（REQ-004-S04）
    // 边界否定路径：三条件同时不成立（C、"N"、"Y"），返回值仍为同一错误码 ER0067，
    // 不因不成立条件的个数不同而返回不同结果
    @Test
    void testST057T07() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.C, "N", "Y"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
    }

    // ST057-TC008（REQ-003-S01、REQ-004-S01~S05、REQ-005-S01）
    // 判定表穷尽：crDrInd∈{D,C} × cashTranFlag∈{Y,N} × reversal∈{Y,N} 共 8 组逐一执行，
    // 仅 (D,Y,N) 判定通过并输出三字段，其余 7 组均返回 ER0067，不存在未定义组合
    @ParameterizedTest
    @MethodSource("judgementCombinations")
    void testST057T08(CrDrInd crDrInd, String cashTranFlag, String reversal, boolean expectedSucceed) {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, crDrInd, cashTranFlag, reversal));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertEquals(expectedSucceed, result.isSucceed());
        if (expectedSucceed) {
            assertNull(result.getErrorCode());
            assertNull(result.getErrorMessage());
            assertEquals(CrDrInd.D, result.getCrDrInd());
            assertEquals("Y", result.getCashTranFlag());
            assertEquals("N", result.getReversal());
        } else {
            assertEquals("ER0067", result.getErrorCode());
        }
    }

    static Stream<Arguments> judgementCombinations() {
        return Stream.of(
                Arguments.of(CrDrInd.D, "Y", "N", true),
                Arguments.of(CrDrInd.D, "Y", "Y", false),
                Arguments.of(CrDrInd.D, "N", "N", false),
                Arguments.of(CrDrInd.D, "N", "Y", false),
                Arguments.of(CrDrInd.C, "Y", "N", false),
                Arguments.of(CrDrInd.C, "Y", "Y", false),
                Arguments.of(CrDrInd.C, "N", "N", false),
                Arguments.of(CrDrInd.C, "N", "Y", false));
    }

    // ST057-TC009（REQ-004-S06）
    // 边界否定路径：cashTranFlag 取所列码值之外的字面值 "X"（crDrInd=D、reversal="N"），
    // 落入「否则」兜底分支返回 ER0067；方法正常返回，不校验取值合法性、不抛异常
    @Test
    void testST057T09() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.D, "X", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
    }

    // ST057-TC010（REQ-006-S01）
    // 错误码路径：判定不通过时错误码唯一为 ER0067（既非 null、也非其它码值），
    // 错误信息按「错误码::业务信息」格式以 ER0067 起头，返回后即结束
    @Test
    void testST057T10() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.C, "N", "N"));

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST057OutputBO result = st057Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0067"));
    }

    /**
     * 构造用于设桩的【交易类型定义】记录（承载子步骤 1 取用的三个标志）。
     */
    private RbTranDefEO tranDef(TranType tranType, CrDrInd crDrInd, String cashTranFlag, String reversal) {
        RbTranDefEO eo = new RbTranDefEO();
        eo.setTranType(tranType);
        eo.setCrDrInd(crDrInd);
        eo.setCashTranFlag(cashTranFlag);
        eo.setReversal(reversal);
        return eo;
    }
}

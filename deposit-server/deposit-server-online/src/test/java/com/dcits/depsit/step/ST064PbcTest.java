package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST064InputBO;
import com.dcits.depsit.facade.bo.ST064OutputBO;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST064 检查现金支取交易权限 —— 单元测试。
 *
 * <p>调用签名：{@code ST064OutputBO execute(ST064InputBO input)}。用例依据本轮正式 Spec 与
 * {@code outputs/测试用例.md}／{@code .json} 的 5 个用例设计，覆盖子步骤 1 的三个输出字段产出、
 * 子步骤 1 → 子步骤 2 的取值传递，以及三条条件各自不成立的分支。</p>
 *
 * <p>结果表达的断言口径（Spec「结果表达」：两类产出互斥）：三条件同时成立产出错误码 {@code ER0070}
 * → {@code isSucceed() == false} 且 {@code getErrorCode()} 等于 {@code "ER0070"}；产出检查结果为
 * 「通过」→ {@code isSucceed() == true} 且两个错误字段为 null。「检查结果」本身无承载字段
 * （Spec 明确不覆盖事项第 4 项），不作为输出字段断言。</p>
 *
 * <p>本步骤只触达一次 {@link IRbTranDefBcc#findByTranType(TranType)} 字典查询，无组件内步骤、
 * 规则或跨组件客户端依赖；按技能约定不设其它桩，也不使用 {@code verify}/{@code never}/{@code times}
 * 验证交互次数或顺序。Spec 定义的行为是只读的，测试不模拟技术异常、不访问真实数据库或外部服务。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST064PbcTest {

    @Mock
    private IRbTranDefBcc irTranDefBcc;

    @InjectMocks
    private ST064Pbc st064Pbc;

    // ST064-TC001（REQ-001-S01、REQ-002-S01、REQ-003-S01、REQ-005-S01、REQ-005-S02）
    // 正常路径：入参 1003 现金支取查得借方/现金/非冲正，子步骤 1 产出三字段，
    // 子步骤 2 三条件同时成立，产出错误码 ER0070
    @Test
    void testST064T01() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1003))
                .thenReturn(tranDef(TranType.VALUE_1003, CrDrInd.D, "Y", "N"));

        ST064InputBO input = new ST064InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST064OutputBO result = st064Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0070", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0070::"));
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST064-TC002（REQ-001-S01、REQ-003-S02、REQ-005-S01）
    // 错误码路径：入参 1006 现金支票支取同样查得借方/现金/非冲正，判定只看三个标志，
    // 不因交易类型的名称或代码值不同而改变，同样产出 ER0070
    @Test
    void testST064T02() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1006))
                .thenReturn(tranDef(TranType.VALUE_1006, CrDrInd.D, "Y", "N"));

        ST064InputBO input = new ST064InputBO();
        input.setTranType(TranType.VALUE_1006);

        ST064OutputBO result = st064Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0070", result.getErrorCode());
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST064-TC003（REQ-001-S02、REQ-004-S01）
    // 正常路径：入参 1000 现金存入查得贷方/现金/非冲正，借贷标志非「D借方」，
    // 走「否则」分支产出检查结果「通过」；三个输出字段仍按查得值产出
    @Test
    void testST064T03() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1000))
                .thenReturn(tranDef(TranType.VALUE_1000, CrDrInd.C, "Y", "N"));

        ST064InputBO input = new ST064InputBO();
        input.setTranType(TranType.VALUE_1000);

        ST064OutputBO result = st064Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(CrDrInd.C, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST064-TC004（REQ-004-S02）
    // 边界否定路径：入参 2125 查得借方/非现金/非冲正，现金交易标志非「Y是」使「与」条件不整体成立，
    // 走「否则」分支产出「通过」，不产出 ER0070
    @Test
    void testST064T04() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_2125))
                .thenReturn(tranDef(TranType.VALUE_2125, CrDrInd.D, "N", "N"));

        ST064InputBO input = new ST064InputBO();
        input.setTranType(TranType.VALUE_2125);

        ST064OutputBO result = st064Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("N", result.getCashTranFlag());
        assertEquals("N", result.getReversal());
    }

    // ST064-TC005（REQ-004-S03、REQ-005-S02）
    // 边界否定路径：入参 1004 现金支取-冲销查得借方/现金/冲正，冲正交易标志非「N否」使「与」条件
    // 不整体成立，走「否则」分支产出「通过」，不产出 ER0070
    @Test
    void testST064T05() {
        Mockito.lenient().when(irTranDefBcc.findByTranType(TranType.VALUE_1004))
                .thenReturn(tranDef(TranType.VALUE_1004, CrDrInd.D, "Y", "Y"));

        ST064InputBO input = new ST064InputBO();
        input.setTranType(TranType.VALUE_1004);

        ST064OutputBO result = st064Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals(CrDrInd.D, result.getCrDrInd());
        assertEquals("Y", result.getCashTranFlag());
        assertEquals("Y", result.getReversal());
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

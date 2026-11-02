package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST043InputBO;
import com.dcits.deposit.facade.bo.ST043OutputBO;
import com.dcits.deposit.facade.components.IRbLimitRuleRelationBcc;
import com.dcits.deposit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.deposit.facade.eo.RbLimitRuleRelationEO;
import com.dcits.deposit.facade.eo.RbLimitSceneDefEO;

/**
 * ST043 匹配限额场景 单元测试。
 *
 * <p>覆盖正式 Spec ST043 用例 ST043-TC001~TC006（REQ-001-S01、REQ-002-S01、
 * REQ-003-S01~S04）。本步骤无已声明的业务失败与错误码，"已匹配到限额场景"/"未匹配到
 * 限额场景"均为正常业务结论；检查结果承载与输出字段填充未确认（TBD-5），断言仅核对
 * succeed=true 与错误字段为 null，输出字段取值不断言。查询条件映射、表与字段绑定、
 * 关联键、启用标志物理取值等未确认事项（TBD-1~TBD-4、TBD-6~TBD-7）不作为断言依据。</p>
 *
 * <p>子步骤 1 的桩仅匹配空查询条件 EO（因子→查询条件映射 TBD-1 未确认，当前实现以
 * 空条件 EO 调用 findByEo 定位记录），与同 mock 上子步骤 2 按表达式查询的桩
 * （argThat 请求含 ruleRelationExpr）不重叠，避免任意查询被兜底桩吞掉使错误实现仍通过。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST043PbcTest {

    @Mock
    private IRbLimitRuleRelationBcc limitRuleRelationBcc;

    @Mock
    private IRbLimitSceneDefBcc limitSceneDefBcc;

    @InjectMocks
    private ST043Pbc pbc;

    // ST043-TC001（REQ-001-S01+REQ-002-S01+REQ-003-S01）：因子→表达式 EXPR_001，表达式→场景编码 [LS001,LS002]，LS001 存在启用配置即中断遍历（LS002 不触达不设桩），正常成功
    @Test
    void testST043T01() {
        // 子步骤 1：因子定位规则关系（查询条件映射 TBD-1，桩仅匹配空查询条件 EO）
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null)));
        // 子步骤 2：按表达式 EXPR_001 取得场景编码列表（表/字段绑定 TBD-2，argThat 匹配请求含 ruleRelationExpr）
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of(relation(null, "LS001"), relation(null, "LS002")));
        // 子步骤 3：LS001 存在启用标志"Y-启用"的配置数据（关联键 TBD-3、物理取值 TBD-4），首项即中断
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of(sceneDef("Y-启用")));

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 输出字段 limitSceneNo/ruleRelationExpr/validFlag 取值不断言（TBD-5）
    }

    // ST043-TC002（REQ-003-S02）：LS001 无启用配置跳过继续遍历，LS002 存在启用配置中断，正常成功
    @Test
    void testST043T02() {
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null)));
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of(relation(null, "LS001"), relation(null, "LS002")));
        // 子步骤 3：LS001 空列表跳过，LS002 非空中断
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of());
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS002".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of(sceneDef("Y-启用")));

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST043-TC003（REQ-003-S03）：LS001、LS002 均无启用配置，遍历结束返回"未匹配到限额场景"（正常业务结论，非失败）
    @Test
    void testST043T03() {
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null)));
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of(relation(null, "LS001"), relation(null, "LS002")));
        // 子步骤 3：LS001、LS002 场景定义查询均为空
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of());
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS002".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of());

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST043-TC004（REQ-003-S04）：按表达式取得空列表，循环体不执行，返回"未匹配到限额场景"；子步骤 3 不设桩
    @Test
    void testST043T04() {
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null)));
        // 子步骤 2：按表达式 EXPR_001 返回空列表
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of());

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST043-TC005（REQ-003-S01 单项边界）：场景编码列表仅 [LS001] 且 LS001 有启用配置，单项即匹配中断，正常成功
    @Test
    void testST043T05() {
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null)));
        // 子步骤 2：按表达式 EXPR_001 取得场景编码 [LS001]
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of(relation(null, "LS001")));
        // 子步骤 3：LS001 存在启用配置
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of(sceneDef("Y-启用")));

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST043-TC006（REQ-001-S01 多条记录，路径演示）：因子查询返回两条记录，实现按单条结果查询统一约定取结果集第一条 EXPR_001 继续；在 TBD-5 输出承载确认前"取首条"无观测断言，本用例为路径演示，不宣称已验证该行为
    @Test
    void testST043T06() {
        // 子步骤 1：因子定位返回两条规则关系记录，首条 EXPR_001、次条 EXPR_002（桩仅匹配空查询条件 EO，与子步骤 2 按表达式查询的桩不重叠）
        lenient().when(limitRuleRelationBcc.findByEo(argThat(EMPTY_RELATION_QUERY)))
                .thenReturn(List.of(relation("EXPR_001", null), relation("EXPR_002", null)));
        // 子步骤 2：仅首条表达式 EXPR_001 有匹配桩（请求字段绑定 TBD-2 待确认）；若实现误用次条表达式 EXPR_002 查询则无匹配桩、默认返回空
        lenient().when(limitRuleRelationBcc.findByEo(argThat(eo -> eo != null && "EXPR_001".equals(eo.getRuleRelationExpr()))))
                .thenReturn(List.of(relation(null, "LS001")));
        // 子步骤 3：LS001 存在启用配置
        lenient().when(limitSceneDefBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneDesc()) && "Y-启用".equals(eo.getValidFlag()))))
                .thenReturn(List.of(sceneDef("Y-启用")));

        ST043OutputBO output = pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    private ST043InputBO input() {
        ST043InputBO input = new ST043InputBO();
        input.setFactorName("FACTOR_LIMIT_SCENE_01");
        return input;
    }

    /**
     * 子步骤 1 查询条件匹配器：空条件 EO（因子→查询条件映射 TBD-1 未确认，当前实现以空条件
     * EO 调用 findByEo；EO 未重写 equals，须用 argThat 按字段匹配，且与子步骤 2 按表达式
     * 查询的桩（请求含 ruleRelationExpr）互斥，不重叠）
     */
    private static final ArgumentMatcher<RbLimitRuleRelationEO> EMPTY_RELATION_QUERY =
            eo -> eo != null && eo.getRuleRelationExpr() == null && eo.getLimitSceneNo() == null;

    private RbLimitRuleRelationEO relation(String ruleRelationExpr, String limitSceneNo) {
        RbLimitRuleRelationEO eo = new RbLimitRuleRelationEO();
        eo.setRuleRelationExpr(ruleRelationExpr);
        eo.setLimitSceneNo(limitSceneNo);
        return eo;
    }

    private RbLimitSceneDefEO sceneDef(String validFlag) {
        RbLimitSceneDefEO eo = new RbLimitSceneDefEO();
        eo.setValidFlag(validFlag);
        return eo;
    }
}

package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST107InputBO;
import com.dcits.depsit.facade.bo.ST107OutputBO;
import com.dcits.depsit.facade.components.IRbLimitRuleRelationBcc;
import com.dcits.depsit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.depsit.facade.eo.RbLimitRuleRelationEO;
import com.dcits.depsit.facade.eo.RbLimitSceneDefEO;

/**
 * ST107 匹配限额场景 单元测试。
 *
 * <p>用例与 {@code outputs/测试用例.md} / {@code outputs/测试用例.json} 的 ST107-TC001～TC009 一一对应，
 * 经被测实例的 {@code execute(input)} 验证业务结果，不断言交互次数与顺序。
 *
 * <p>桩说明：
 * <ul>
 *     <li>【限额规则关系表】用单个应答式桩承载两次查询——条件关系规则表达式为空即子步骤1 的因子查询
 *     （返回因子行），非空即子步骤2 的表达式查询（按该表达式返回候选行）。「因子名称」到查询列的绑定属
 *     Spec 已放行事项，桩不断言该条件字段，故「以任意列承载因子名称」与「不带条件查询后本地筛选」
 *     两类实现均可命中；子步骤2 的查询键是本 Spec 已确定的业务键，桩对其取值分派。</li>
 *     <li>【限额场景定义表】用单个应答式桩按请求编码查内表：未登记编码返回 {@code null}（无记录），
 *     登记后返回记录并由被测实现判定启用标志（有记录但启用标志非「Y」）。</li>
 *     <li>按 Spec「命中即中断、不再检查剩余候选」，部分候选在正确路径下不会被查询；桩以单个应答式
 *     承载整张表，不逐编码登记，故不存在未使用桩，全部桩按 {@code Mockito.lenient()} 设置。</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
class ST107PbcTest {

    @Mock
    private IRbLimitRuleRelationBcc rbLimitRuleRelationBcc;

    @Mock
    private IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    @InjectMocks
    private ST107Pbc st107Pbc;

    // TC001：单候选存在启用配置 —— 子步骤1 取表达式 EXPR-001、子步骤2 得候选 LS001、命中启用记录后中断返回「已匹配到限额场景」
    @Test
    void testST107T01() {
        RbLimitRuleRelationEO factorRow = relation("RULE-001", "EXPR-001", "LS001", "交易金额");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-001", Collections.singletonList(factorRow)));
        stubSceneDef(Collections.singletonMap("LS001", sceneDef("LS001", "Y", "个人存款交易金额限额场景")));

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("交易金额");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS001", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-001", out.getRuleRelationExpr());
        assertEquals("LS001", out.getRelationLimitSceneNo());
    }

    // TC002：前序候选 LS002 无配置记录（继续检查下一个），后续候选 LS001 命中启用记录后返回「已匹配到限额场景」
    @Test
    void testST107T02() {
        RbLimitRuleRelationEO factorRow = relation("RULE-002", "EXPR-002", "LS002", "交易笔数");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-002", Arrays.asList(
                        relation("RULE-002", "EXPR-002", "LS002", null),
                        relation("RULE-003", "EXPR-002", "LS001", null))));
        stubSceneDef(Collections.singletonMap("LS001", sceneDef("LS001", "Y", null)));

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("交易笔数");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS001", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-002", out.getRuleRelationExpr());
    }

    // TC003：三个候选中首个候选 LS011 即命中（LS013 亦启用），中断后不再判定后续候选，命中编码不取末位
    @Test
    void testST107T03() {
        RbLimitRuleRelationEO factorRow = relation("RULE-011", "EXPR-011", "LS011", "累计金额");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-011", Arrays.asList(
                        relation("RULE-011", "EXPR-011", "LS011", null),
                        relation("RULE-012", "EXPR-011", "LS012", null),
                        relation("RULE-013", "EXPR-011", "LS013", null))));
        Map<String, RbLimitSceneDefEO> sceneTable = new HashMap<>();
        sceneTable.put("LS011", sceneDef("LS011", "Y", null));
        sceneTable.put("LS012", sceneDef("LS012", "N", null));
        sceneTable.put("LS013", sceneDef("LS013", "Y", null));
        stubSceneDef(sceneTable);

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("累计金额");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS011", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-011", out.getRuleRelationExpr());
    }

    // TC004：两个候选均启用，遍历顺序一（LS011 在前）——结论为「已匹配到限额场景」，命中编码取当次首个命中候选
    @Test
    void testST107T04() {
        RbLimitRuleRelationEO factorRow = relation("RULE-011", "EXPR-011", "LS011", "累计金额");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-011", Arrays.asList(
                        relation("RULE-011", "EXPR-011", "LS011", null),
                        relation("RULE-012", "EXPR-011", "LS012", null))));
        Map<String, RbLimitSceneDefEO> sceneTable = new HashMap<>();
        sceneTable.put("LS011", sceneDef("LS011", "Y", null));
        sceneTable.put("LS012", sceneDef("LS012", "Y", null));
        stubSceneDef(sceneTable);

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("累计金额");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS011", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-011", out.getRuleRelationExpr());
    }

    // TC005：两个候选均启用，遍历顺序二（LS012 在前）——结论不变，命中编码随当次顺序为首个命中候选
    @Test
    void testST107T05() {
        RbLimitRuleRelationEO factorRow = relation("RULE-012", "EXPR-011", "LS012", "累计金额");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-011", Arrays.asList(
                        relation("RULE-012", "EXPR-011", "LS012", null),
                        relation("RULE-011", "EXPR-011", "LS011", null))));
        Map<String, RbLimitSceneDefEO> sceneTable = new HashMap<>();
        sceneTable.put("LS012", sceneDef("LS012", "Y", null));
        sceneTable.put("LS011", sceneDef("LS011", "Y", null));
        stubSceneDef(sceneTable);

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("累计金额");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS012", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-011", out.getRuleRelationExpr());
    }

    // TC006：全部候选均无启用配置且两类空结果并存（LS002 无记录、LS003 启用标志为 N）——返回「未匹配到限额场景」，不产出 limitSceneNo／validFlag
    @Test
    void testST107T06() {
        RbLimitRuleRelationEO factorRow = relation("RULE-021", "EXPR-006", "LS002", "交易频次");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-006", Arrays.asList(
                        relation("RULE-021", "EXPR-006", "LS002", null),
                        relation("RULE-022", "EXPR-006", "LS003", null))));
        stubSceneDef(Collections.singletonMap("LS003", sceneDef("LS003", "N", null)));

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("交易频次");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("未匹配到限额场景", out.getMatchResult());
        assertNull(out.getLimitSceneNo());
        assertNull(out.getValidFlag());
        assertEquals("EXPR-006", out.getRuleRelationExpr());
    }

    // TC007：候选编码列表为零条（表达式查无记录）——遍历立即结束，直接返回「未匹配到限额场景」，子步骤1 仍产出表达式
    @Test
    void testST107T07() {
        stubRuleRelation(Collections.singletonList(relation("RULE-031", "EXPR-003", null, "未配置因子")),
                Collections.emptyMap());
        stubSceneDef(Collections.emptyMap());

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("未配置因子");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("未匹配到限额场景", out.getMatchResult());
        assertNull(out.getLimitSceneNo());
        assertNull(out.getValidFlag());
        assertEquals("EXPR-003", out.getRuleRelationExpr());
        assertNull(out.getRelationLimitSceneNo());
    }

    // TC008：候选有记录但启用标志取 Y 之外的其它取值（LS004 取 1）——[配置数据] 为空，返回「未匹配到限额场景」
    @Test
    void testST107T08() {
        RbLimitRuleRelationEO factorRow = relation("RULE-041", "EXPR-004", "LS004", "透支金额");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-004", Collections.singletonList(factorRow)));
        stubSceneDef(Collections.singletonMap("LS004", sceneDef("LS004", "1", null)));

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("透支金额");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("未匹配到限额场景", out.getMatchResult());
        assertNull(out.getLimitSceneNo());
        assertNull(out.getValidFlag());
        assertEquals("EXPR-004", out.getRuleRelationExpr());
    }

    // TC009：唯一输入按契约接收、各输出取自查得记录而非入参（命中路径取值唯一）
    @Test
    void testST107T09() {
        RbLimitRuleRelationEO factorRow = relation("RULE-051", "EXPR-009", "LS101", "累计笔数");
        stubRuleRelation(Collections.singletonList(factorRow),
                Collections.singletonMap("EXPR-009", Collections.singletonList(factorRow)));
        stubSceneDef(Collections.singletonMap("LS101", sceneDef("LS101", "Y", "个人存款累计笔数限额场景")));

        ST107InputBO input = new ST107InputBO();
        input.set因子名称("累计笔数");

        ST107OutputBO out = st107Pbc.execute(input);

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("已匹配到限额场景", out.getMatchResult());
        assertEquals("LS101", out.getLimitSceneNo());
        assertEquals("Y", out.getValidFlag());
        assertEquals("EXPR-009", out.getRuleRelationExpr());
        assertEquals("LS101", out.getRelationLimitSceneNo());
    }

    /**
     * 构造【限额规则关系表】记录。
     */
    private static RbLimitRuleRelationEO relation(String ruleId, String ruleRelationExpr, String limitSceneNo, String ruleDesc) {
        RbLimitRuleRelationEO eo = new RbLimitRuleRelationEO();
        eo.setRuleId(ruleId);
        eo.setRuleRelationExpr(ruleRelationExpr);
        eo.setLimitSceneNo(limitSceneNo);
        eo.setRuleDesc(ruleDesc);
        return eo;
    }

    /**
     * 构造【限额场景定义表】记录。
     */
    private static RbLimitSceneDefEO sceneDef(String limitSceneNo, String validFlag, String limitSceneDesc) {
        RbLimitSceneDefEO eo = new RbLimitSceneDefEO();
        eo.setLimitSceneNo(limitSceneNo);
        eo.setValidFlag(validFlag);
        eo.setLimitSceneDesc(limitSceneDesc);
        return eo;
    }

    /**
     * 【限额规则关系表】应答式桩：条件关系规则表达式为空视为子步骤1 的因子查询，返回因子行；
     * 非空视为子步骤2 的表达式查询，按该表达式返回候选行（未登记的表达式返回空列表）。
     */
    private void stubRuleRelation(List<RbLimitRuleRelationEO> factorRows,
                                  Map<String, List<RbLimitRuleRelationEO>> rowsByExpr) {
        Mockito.lenient().when(rbLimitRuleRelationBcc.findByEo(any(RbLimitRuleRelationEO.class)))
                .thenAnswer(invocation -> {
                    RbLimitRuleRelationEO condition = invocation.getArgument(0);
                    String ruleRelationExpr = condition == null ? null : condition.getRuleRelationExpr();
                    if (ruleRelationExpr == null || ruleRelationExpr.isEmpty()) {
                        return factorRows;
                    }
                    return rowsByExpr.getOrDefault(ruleRelationExpr, Collections.emptyList());
                });
    }

    /**
     * 【限额场景定义表】应答式桩：按请求的限额场景编码查内表，未登记编码返回 null（无记录）；
     * 登记但启用标志非「Y」的记录由被测实现判为空，两类来源共用同一内表。
     */
    private void stubSceneDef(Map<String, RbLimitSceneDefEO> sceneTable) {
        Mockito.lenient().when(rbLimitSceneDefBcc.findByPrimaryKey(anyString()))
                .thenAnswer(invocation -> sceneTable.get(invocation.getArgument(0, String.class)));
    }
}

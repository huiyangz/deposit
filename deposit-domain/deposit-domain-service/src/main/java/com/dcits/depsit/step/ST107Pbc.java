package com.dcits.depsit.step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST107InputBO;
import com.dcits.depsit.facade.bo.ST107OutputBO;
import com.dcits.depsit.facade.components.IRbLimitRuleRelationBcc;
import com.dcits.depsit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.depsit.facade.eo.RbLimitRuleRelationEO;
import com.dcits.depsit.facade.eo.RbLimitSceneDefEO;

/**
 * ST107 匹配限额场景 步骤实现。
 *
 * <p>执行顺序与正式 Spec 的子步骤一致：
 * <ol>
 *     <li>子步骤1（REQ-002）：以「因子名称」查询【限额规则关系表】（{@code RB_LIMIT_RULE_RELATION}）
 *     取得关系规则表达式，输出 {@code ruleRelationExpr} 并作为子步骤2 的查询依据；</li>
 *     <li>子步骤2（REQ-003）：以该表达式为查询键查询同一张表，取得候选限额场景编码列表，
 *     承载到 {@code relationLimitSceneNo} 并作为子步骤3 的遍历对象；</li>
 *     <li>子步骤3（REQ-004～REQ-006）：逐个候选以其自身编码查询【限额场景定义表】
 *     （{@code RB_LIMIT_SCENE_DEF}），{@code validFlag} 等于码值 {@code "Y"}（启用）即中断遍历、
 *     返回「已匹配到限额场景」并产出 {@code limitSceneNo}／{@code validFlag}；
 *     [配置数据] 为空则继续检查下一个；全部检查完仍未命中时返回「未匹配到限额场景」。</li>
 * </ol>
 *
 * <p>本步骤全路径只读，不写库、不调用其它步骤／规则／外部服务，也不产出错误码
 * （源需求「## 失败处理」声明无业务失败场景），故 {@code execute} 不加事务注解，
 * 每次执行均置 {@code succeed=true}。
 *
 * <p><b>口径待确认的假定（源自 Spec 已登记的不覆盖事项，不改变本类的可测试契约）：</b>
 * <ol>
 *     <li>「因子名称」到【限额规则关系表】的查询列绑定属 Spec「## 验收范围与明确不覆盖的事项」
 *     第 1 项已放行事项（源需求未唯一确定查询键列，也不得由 Spec 代定）。本实现把「因子名称」
 *     作为<b>规则描述</b>（{@code RULE_DESC}）条件查询——该表可作条件的列中，规则编号为编号形态、
 *     关系规则表达式与限额场景编码均有各自业务键，规则描述是唯一可能承载因子名称的列；
 *     本轮测试用例的因子行夹具亦统一把因子名写入 {@code ruleDesc}。按该条件查得多条记录时
 *     取查询结果首条记录的表达式（同一表状态即同一结果）。该项待业务方明确列绑定后同步回改。</li>
 *     <li>单值字段 {@code relationLimitSceneNo} 承载多条候选的书写形式源需求未定义
 *     （Spec 不覆盖项 2），本实现取候选列表首条；单候选时即该编码本身。</li>
 *     <li>「因子名称」取到【限额规则关系表】未配置的值时源需求未定义处理（Spec 不覆盖项 5），
 *     本实现按「无关系记录 ⇒ 表达式为空 ⇒ 候选列表为空集」收尾，最终给出「未匹配到限额场景」，
 *     不抛业务失败、不产出错误码，也不为取数补默认值。</li>
 * </ol>
 */
@Service
public class ST107Pbc implements IST107 {

    /** 启用标志判定取值：源需求书写为「Y-启用」，按码值「Y」判定（含义「启用」） */
    private static final String VALID_FLAG_ENABLED = "Y";

    /** 检查结果：已匹配到限额场景 */
    private static final String MATCH_RESULT_MATCHED = "已匹配到限额场景";

    /** 检查结果：未匹配到限额场景 */
    private static final String MATCH_RESULT_NOT_MATCHED = "未匹配到限额场景";

    private final IRbLimitRuleRelationBcc rbLimitRuleRelationBcc;

    private final IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    public ST107Pbc(IRbLimitRuleRelationBcc rbLimitRuleRelationBcc,
                    IRbLimitSceneDefBcc rbLimitSceneDefBcc) {
        this.rbLimitRuleRelationBcc = rbLimitRuleRelationBcc;
        this.rbLimitSceneDefBcc = rbLimitSceneDefBcc;
    }

    @Override
    public ST107OutputBO execute(ST107InputBO input) {
        ST107OutputBO output = new ST107OutputBO();

        // 子步骤1：根据因子名称查询【限额规则关系表】取得关系规则表达式（只读）
        String ruleRelationExpr = queryRuleRelationExpr(input);
        output.setRuleRelationExpr(ruleRelationExpr);

        // 子步骤2：根据关系规则表达式查询【限额规则关系表】取得限额场景编码列表（只读）
        List<String> limitSceneNos = queryLimitSceneNos(ruleRelationExpr);
        if (!limitSceneNos.isEmpty()) {
            output.setRelationLimitSceneNo(limitSceneNos.get(0));
        }

        // 子步骤3：遍历候选编码，逐个以其自身编码查询【限额场景定义表】的启用配置
        boolean matched = false;
        for (String limitSceneNo : limitSceneNos) {
            RbLimitSceneDefEO configData = rbLimitSceneDefBcc.findByPrimaryKey(limitSceneNo);
            if (configData != null && VALID_FLAG_ENABLED.equals(configData.getValidFlag())) {
                // 子步骤3-2：[配置数据] 不为空，中断本次遍历并返回「已匹配到限额场景」
                output.setLimitSceneNo(configData.getLimitSceneNo());
                output.setValidFlag(configData.getValidFlag());
                matched = true;
                break;
            }
            // 子步骤3-3：[配置数据] 为空，继续检查下一个限额场景编码
        }
        // 子步骤3-3 收尾：全部检查完仍未匹配（含候选列表为空集）返回「未匹配到限额场景」
        output.setMatchResult(matched ? MATCH_RESULT_MATCHED : MATCH_RESULT_NOT_MATCHED);

        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1：以「因子名称」查询【限额规则关系表】取得关系规则表达式。
     *
     * <p>查询键列绑定属 Spec 已放行事项，本实现按规则描述（{@code RULE_DESC}）作为条件；
     * 查到多条记录时取首条。查无记录时返回 {@code null}，不补默认值。
     */
    private String queryRuleRelationExpr(ST107InputBO input) {
        RbLimitRuleRelationEO condition = new RbLimitRuleRelationEO();
        condition.setRuleDesc(input.get因子名称());
        List<RbLimitRuleRelationEO> records = rbLimitRuleRelationBcc.findByEo(condition);
        if (records == null || records.isEmpty()) {
            return null;
        }
        return records.get(0).getRuleRelationExpr();
    }

    /**
     * 子步骤2：以关系规则表达式为查询键查询【限额规则关系表】取得候选限额场景编码列表。
     *
     * <p>表达式无值时不存在可用的查询键，按候选列表为空集返回（Spec 未定义该情形，
     * 不为取数补默认值）。同一表达式可对应多条记录（{@code RULE_RELATION_EXPR} 非主键），
     * 记录中限额场景编码为空的条目不是候选编码，不进入遍历。
     */
    private List<String> queryLimitSceneNos(String ruleRelationExpr) {
        if (ruleRelationExpr == null || ruleRelationExpr.isEmpty()) {
            return Collections.emptyList();
        }
        RbLimitRuleRelationEO condition = new RbLimitRuleRelationEO();
        condition.setRuleRelationExpr(ruleRelationExpr);
        List<RbLimitRuleRelationEO> records = rbLimitRuleRelationBcc.findByEo(condition);
        if (records == null || records.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> limitSceneNos = new ArrayList<>();
        for (RbLimitRuleRelationEO record : records) {
            if (record != null && record.getLimitSceneNo() != null) {
                limitSceneNos.add(record.getLimitSceneNo());
            }
        }
        return limitSceneNos;
    }
}

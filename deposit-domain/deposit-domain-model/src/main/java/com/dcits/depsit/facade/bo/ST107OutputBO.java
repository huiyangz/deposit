package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST107 匹配限额场景 输出 BO。
 *
 * <p>字段取自源需求「## 输出」表的五行（第 24–26、28、29 行，第 27 行为空行）：
 * {@code relationLimitSceneNo}、{@code ruleRelationExpr}、{@code limitSceneNo}、{@code validFlag}
 * 四个数据字段照录「非必填」标记（记的是实体字段本身可空），{@code matchResult} 照录「必填」，
 * 每次执行均产出，取值域恰为「已匹配到限额场景」与「未匹配到限额场景」两个规范常量。
 *
 * <p>继承工程基类 {@link StepResult}，成功标志与错误字段由基类承载，本类不重复声明。
 * 本步骤无业务失败场景（源需求「## 失败处理」），故不产出错误码。
 */
public class ST107OutputBO extends StepResult {

    /** 关系表中查询到的候选限额场景编码（子步骤2 查得候选时承载） */
    private String relationLimitSceneNo;

    /** 关系规则表达式（子步骤1 查得关系记录时承载） */
    private String ruleRelationExpr;

    /** 匹配到的限额场景编码（仅在命中启用配置时产出，取自命中的配置数据所属记录） */
    private String limitSceneNo;

    /** 启用标志（仅在命中启用配置时产出，取自命中的配置数据所属记录） */
    private String validFlag;

    /** 检查结果：已匹配到限额场景 / 未匹配到限额场景 */
    private String matchResult;

    public String getRelationLimitSceneNo() {
        return relationLimitSceneNo;
    }

    public void setRelationLimitSceneNo(String relationLimitSceneNo) {
        this.relationLimitSceneNo = relationLimitSceneNo;
    }

    public String getRuleRelationExpr() {
        return ruleRelationExpr;
    }

    public void setRuleRelationExpr(String ruleRelationExpr) {
        this.ruleRelationExpr = ruleRelationExpr;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }
}

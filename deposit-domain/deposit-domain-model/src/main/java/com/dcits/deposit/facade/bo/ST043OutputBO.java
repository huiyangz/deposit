package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST043 匹配限额场景 输出。
 *
 * <p>继承步骤结果契约 {@link StepResult}：正常完成（含"已匹配到限额场景"/"未匹配到限额场景"
 * 两种结论）时 succeed=true 且错误字段为 null，本步骤无已声明的业务失败与错误码。</p>
 *
 * <p>业务字段对应正式 Spec ST043「输出」表：limitSceneNo、ruleRelationExpr、validFlag
 * （均非必填）。检查结果"已匹配到限额场景"/"未匹配到限额场景"的承载方式及已匹配场景下
 * 各输出字段的填充与取值来源未定义，见 {@link com.dcits.deposit.step.ST043Pbc} 中 FIXME
 * （Spec TBD-5）。</p>
 */
public class ST043OutputBO extends StepResult {

    /** 限额场景编码（非必填） */
    private String limitSceneNo;

    /** 关系规则表达式（非必填） */
    private String ruleRelationExpr;

    /** 启用标志（非必填） */
    private String validFlag;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getRuleRelationExpr() {
        return ruleRelationExpr;
    }

    public void setRuleRelationExpr(String ruleRelationExpr) {
        this.ruleRelationExpr = ruleRelationExpr;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST050 检查有权机关冻结限制 步骤输出。
 *
 * <p>字段来自正式 Spec ST050「输出」表（REQ-002），继承 {@link StepResult} 承载步骤结果。
 * ahBuFlag 为存款限制类型表记录的有权机关冻结标志，需求指定赋值并返回的业务结果；
 * 其取值集合/物理编码（如 "Y"/"N" 或 "1"/"0"）未确认（Spec 待确认事项 TBD-4），
 * 本步骤按输出表 String 类型原样透传，见
 * {@link com.dcits.deposit.step.ST050Pbc#execute(ST050InputBO)}。</p>
 */
public class ST050OutputBO extends StepResult {

    /** 有权机关冻结标志（来源 RB_RESTRAINT_TYPE，需求指定赋值并返回的业务结果） */
    private String ahBuFlag;

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }
}

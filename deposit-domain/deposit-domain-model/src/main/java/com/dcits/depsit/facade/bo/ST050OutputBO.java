package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.CrDrInd;

/**
 * ST050 设置贷记交易的借贷标志 输出 BO。
 *
 * <p>业务字段仅 [借贷标志]（别名「输出数据-借贷标志」）一个；步骤结果由基类
 * {@link StepResult} 承载。本步骤无业务失败场景，成功时 {@code succeed} 为 {@code true}，
 * {@code errorCode} 与 {@code errorMessage} 均为 {@code null}（REQ-001、REQ-003）。</p>
 */
public class ST050OutputBO extends StepResult {

    /** 借贷标志，本步骤赋值为贷方（{@link CrDrInd#C}） */
    private CrDrInd crDrInd;

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }
}

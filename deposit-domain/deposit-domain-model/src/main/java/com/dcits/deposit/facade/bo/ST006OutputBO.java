package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.CrDrInd;

/**
 * ST006 检查法透标志 步骤输出。
 *
 * <p>继承 {@code com.dcits.common.step.StepResult}（succeed / errorCode / errorMessage），
 * 业务字段与正式 Spec 输出表一致：{@code crDrInd}（{@code com.dcits.deposit.enums.CrDrInd}，
 * 非必填，来源实体=交易类型定义表（RB_TRAN_DEF））。</p>
 */
public class ST006OutputBO extends StepResult {

    /** 借贷标志（非必填），来源实体=交易类型定义表（RB_TRAN_DEF）；“D-借方”对应 CrDrInd.D（借） */
    private CrDrInd crDrInd;

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }
}

package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.CrDrInd;

/**
 * ST059 设置借记交易的借贷标志 输出 BO。
 *
 * <p>承载步骤的借贷标志赋值结果：字段 {@code crDrInd} 类型为 {@link CrDrInd}，本步骤无条件将其赋值为
 * {@link CrDrInd#D}（“D-借方”）。按源需求输出表标记该字段为「非必填」，该标记记载的是承载实体允许为空，
 * 与赋值动作无条件执行的关系及空值语义按正式 Spec 不覆盖事项第 4 项挂账，此处不派生默认值或空值分支。</p>
 *
 * <p>成功标志与错误码/错误信息由基类 {@link StepResult} 提供，本类不重复声明。</p>
 */
public class ST059OutputBO extends StepResult {

    /** 借贷标志；本步骤赋值为 D-借方（{@link CrDrInd#D}，代码值 "D"） */
    private CrDrInd crDrInd;

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }
}

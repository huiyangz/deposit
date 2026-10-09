package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.CrDrInd;

/**
 * ST064 检查现金支取交易权限 —— 输出 BO。
 *
 * <p>按 Spec「### 输出」表声明 {@code crDrInd}、{@code cashTranFlag}、{@code reversal} 三个业务字段，
 * 标记列均为「非必填」：该标记记的是字段（实体）的可空性，不表示子步骤 1 可以不产出——
 * 子步骤 1 明确要求获取这三个标志，查询取得对应值后本步骤 SHALL 分别产出，取值即查得的对应标志值
 * （Spec REQ-001 与其输出说明）。</p>
 *
 * <p>源需求未给出「检查结果＝通过」与错误码 {@code ER0070} 的字段名、类型与承载形式
 * （Spec 明确不覆盖事项第 4 项），故本类不新增相应输出字段，这两项互斥产出由继承自
 * {@link StepResult} 的 {@code succeed}／{@code errorCode}／{@code errorMessage} 承载。</p>
 */
public class ST064OutputBO extends StepResult {

    /** 借贷标志；取值由 {@link CrDrInd} 决定（C-贷、D-借），来自按 {@code tranType} 查得的借贷标志。 */
    private CrDrInd crDrInd;

    /** 现金交易标志；判定取代码值 "Y" 表示「是」，来自按 {@code tranType} 查得的现金交易标志。 */
    private String cashTranFlag;

    /** 冲正交易标志；判定取代码值 "N" 表示「否」，来自按 {@code tranType} 查得的冲正交易标志。 */
    private String reversal;

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }

    public String getCashTranFlag() {
        return cashTranFlag;
    }

    public void setCashTranFlag(String cashTranFlag) {
        this.cashTranFlag = cashTranFlag;
    }

    public String getReversal() {
        return reversal;
    }

    public void setReversal(String reversal) {
        this.reversal = reversal;
    }
}

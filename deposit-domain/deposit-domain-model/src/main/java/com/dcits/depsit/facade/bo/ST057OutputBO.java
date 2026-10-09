package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.CrDrInd;

/**
 * ST057 检查支取交易类型 —— 输出 BO。
 *
 * <p>按 Spec「### 输出」表声明 {@code crDrInd}、{@code cashTranFlag}、{@code reversal} 三个业务字段，
 * 字段名、类型与标记均照录源需求：{@code crDrInd} 为 {@link CrDrInd}，{@code cashTranFlag} 与
 * {@code reversal} 为 {@link String}，三者标记均为「非必填」（该标记记的是字段可空性）。</p>
 *
 * <p>三个输出承载步骤1 按 {@code tranType} 查询【交易类型定义】所得记录的同名业务字段
 * （借贷标志→{@code crDrInd}、现金交易标志→{@code cashTranFlag}、冲正交易标志→{@code reversal}），
 * 不引入外部入参（Spec REQ-002、REQ-005）；「非必填」标记不用于推断失败路径下是否有值
 * （Spec 明确不覆盖事项第 2 项）。步骤的通过／失败状态与错误码由继承自 {@link StepResult} 的
 * {@code succeed}／{@code errorCode}／{@code errorMessage} 承载，本类不重复声明这些字段。</p>
 */
public class ST057OutputBO extends StepResult {

    /** 借贷标志；取自按 {@code tranType} 查得的借贷标志，取值由 {@link CrDrInd} 的代码值决定（C-贷、D-借）。 */
    private CrDrInd crDrInd;

    /** 现金交易标志；取自按 {@code tranType} 查得的现金交易标志，判定取代码值 "Y" 表示「是」。 */
    private String cashTranFlag;

    /** 冲正交易标志；取自按 {@code tranType} 查得的冲正交易标志，判定取代码值 "N" 表示「否」。 */
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

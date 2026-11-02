package com.dcits.deposit.facade.bo;

/**
 * ST043 匹配限额场景 输入。
 *
 * <p>对应正式 Spec ST043「输入」表：因子名称（{@code java.lang.String}，必填），
 * 用于定位业务场景因子以查询限额规则关系。因子名称到限额规则关系表查询条件的映射未定义，
 * 见 {@link com.dcits.deposit.step.ST043Pbc} 中 FIXME（Spec TBD-1）。</p>
 */
public class ST043InputBO {

    /** 因子名称（必填）：业务场景因子名称，用于定位限额规则关系 */
    private String factorName;

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }
}

package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST032 检查交易金额 输入。
 *
 * <p>步骤仅有 {@code tranAmt} 一个入参：判定取其数值大小与 {@code 0} 比较，
 * 取值域为任意 {@code BigDecimal} 数值（含 {@code 0} 与负数）。</p>
 *
 * <p>源需求未定义该入参为空（无值）时的步骤行为，本类不生成相应的非空校验与失败分支。</p>
 */
public class ST032InputBO {

    /** 交易金额；判定取其数值大小与 0 比较 */
    private BigDecimal tranAmt;

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}

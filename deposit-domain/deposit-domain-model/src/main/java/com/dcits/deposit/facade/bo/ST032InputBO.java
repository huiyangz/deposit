package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST032 检查交易金额 步骤输入。
 *
 * <p>本步骤唯一必填输入为交易金额（tranAmt），作为金额检查依据。</p>
 */
public class ST032InputBO {

    /**
     * 交易金额（必填）
     */
    private BigDecimal tranAmt;

    // FIXME 业务项:ST032/检查交易金额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:tranAmt 来源实体需求输入表未指定（来源实体列为空），其在实际交易流程中的取值路径未确认（Spec 待确认事项 TBD-3） - 影响:本步骤仅定义输入契约，tranAmt 的实际来源未绑定 - 待确认:tranAmt 在实际交易流程中的取值路径/来源实体
    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}

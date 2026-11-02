package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranType;

/**
 * ST006 检查法透标志 步骤输入。
 *
 * <p>字段与正式 Spec 输入表一致：法人透支检查标志（{@code java.lang.String}，必填）、
 * {@code tranType}（{@code com.dcits.deposit.enums.TranType}，必填）。</p>
 */
public class ST006InputBO {

    /** 法人透支检查标志（必填）；步骤条件使用“Y-是”，即取值为“Y”、业务含义“是” */
    private String 法人透支检查标志;

    /** 交易类型（必填），取值来源于代码[交易类型]，对应枚举类 com.dcits.deposit.enums.TranType */
    private TranType tranType;

    public String get法人透支检查标志() {
        return 法人透支检查标志;
    }

    public void set法人透支检查标志(String 法人透支检查标志) {
        this.法人透支检查标志 = 法人透支检查标志;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }
}

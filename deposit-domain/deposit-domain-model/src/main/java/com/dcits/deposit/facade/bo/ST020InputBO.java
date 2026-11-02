package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranType;

/**
 * ST020 检查转账交易类型 输入 BO。
 *
 * <p>必填输入：交易类型（tranType，类型 {@link TranType}），取值来源于代码[交易类型]，
 * 对应枚举类 {@code com.dcits.deposit.enums.TranType}（正式 Spec「输入」表）。</p>
 */
public class ST020InputBO {

    /** 交易类型（必填），取值来源于代码[交易类型]，对应枚举 TranType。 */
    private TranType tranType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }
}

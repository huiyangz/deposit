package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.TranType;

/**
 * ST041 检查存入交易类型 输入 BO。
 *
 * 本步骤仅有交易类型一个入参，用于判定该笔交易是否为本场景要求的「现金存入」。
 */
public class ST041InputBO {

    /** 交易类型，必填；本步骤关心的成员为「现金存入」＝{@link TranType#VALUE_1000}（代码 "1000"）。 */
    private TranType tranType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }
}

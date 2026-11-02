package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TranType;

/**
 * ST057 检查限制优先级 输入。
 *
 * <p>输入契约对应 Spec REQ-001：必填输入交易类型（{@code tranType}）与账户限制类型
 * （{@code restraintType}），取值分别来源于代码[交易类型]（{@link TranType}）与
 * [限制类型]（{@link RestraintType}）。</p>
 */
public class ST057InputBO {
    /** 交易类型（必填） */
    private TranType tranType;
    /** 账户限制类型（必填） */
    private RestraintType restraintType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }
}

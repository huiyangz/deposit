package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST025 检查法透账户支取限制 输出 BO。
 *
 * <p>继承 {@link StepResult}，业务输出为三个组件内检查步骤返回的标志字段，均为非必填、
 * 类型 {@code java.lang.String}。不收不付标志按组件内步骤 ST058 输出字段名
 * {@code noCreditNoDebitFlag} 沿用（正式 Spec「输出」表仅声明业务名，未声明英文字段名）；
 * 三个标志业务取值「是」/「否」，物理编码待确认（正式 Spec 待确认事项 TBD-1）。</p>
 */
public class ST025OutputBO extends StepResult {

    /** 不收不付标志（业务取值「是」/「否」，经组件内步骤「检查是否存在不收不付限制」ST058 取得） */
    private String noCreditNoDebitFlag;

    /** 止付标志（业务取值「是」/「否」，经组件内步骤「检查是否存在止付限制」ST055 取得） */
    private String stopFlag;

    /** 有权机关冻结标志（业务取值「是」/「否」，经组件内步骤「检查有权机关冻结限制」ST050 取得） */
    private String ahBuFlag;

    public String getNoCreditNoDebitFlag() {
        return noCreditNoDebitFlag;
    }

    public void setNoCreditNoDebitFlag(String noCreditNoDebitFlag) {
        this.noCreditNoDebitFlag = noCreditNoDebitFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }
}

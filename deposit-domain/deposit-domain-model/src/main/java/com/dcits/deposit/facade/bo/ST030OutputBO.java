package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctStatus;

/**
 * ST030 检查对手账户是否能够入账 输出 BO。
 *
 * <p>业务输出：入账标志（规则《检查账户是否能够入账》DT002 执行结果，业务取值"允许"/"不允许"）、
 * 转账止付标志（组件内步骤 ST052 返回结果，业务取值"是"/"否"）、转账不收不付标志（组件内步骤
 * ST056 返回结果，业务取值"是"/"否"）来自步骤第 2–4 条；acctStatus（账户状态）来自对公存款账户
 * 主表（RB_BUS_ACCT，REQ-001）。输出物理字段名与取值编码口径见 ST030Pbc 中 TBD-8 FIXME。</p>
 *
 * <p>继承 {@link StepResult}，检查结果"通过"对应正常完成（succeed=true、errorCode/errorMessage
 * 为 null），入账标志非"允许"时按业务失败返回错误码 ER0077；"通过"的业务结论承载方式与失败时
 * 输出字段口径见 ST030Pbc 中 TBD-7 FIXME。</p>
 */
public class ST030OutputBO extends StepResult {

    /** 入账标志 */
    private String entryFlag;
    /** 转账止付标志 */
    private String transferStopFlag;
    /** 转账不收不付标志 */
    private String transferNoCreditNoDebitFlag;
    /** 账户状态 */
    private AcctStatus acctStatus;

    public String getEntryFlag() {
        return entryFlag;
    }

    public void setEntryFlag(String entryFlag) {
        this.entryFlag = entryFlag;
    }

    public String getTransferStopFlag() {
        return transferStopFlag;
    }

    public void setTransferStopFlag(String transferStopFlag) {
        this.transferStopFlag = transferStopFlag;
    }

    public String getTransferNoCreditNoDebitFlag() {
        return transferNoCreditNoDebitFlag;
    }

    public void setTransferNoCreditNoDebitFlag(String transferNoCreditNoDebitFlag) {
        this.transferNoCreditNoDebitFlag = transferNoCreditNoDebitFlag;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }
}

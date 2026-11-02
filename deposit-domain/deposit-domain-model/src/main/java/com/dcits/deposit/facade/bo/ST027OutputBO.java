package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctStatus;

/**
 * ST027 检查账户是否能够出账 输出 BO。
 *
 * <p>业务输出：acctStatus（账户状态，来自对公存款账户主表 RB_BUS_ACCT，REQ-001）；
 * 转账止付标志（组件内步骤 ST052 返回，REQ-002）、转账不收不付标志（组件内步骤 ST056 返回，
 * REQ-003）、出账标志（决策规则 DT001 返回，REQ-004）。三个中文输出字段按依赖约定命名：
 * transferStopFlag（沿 ST052 stopFlag 约定）、transferNoCreditNoDebitFlag（沿用 ST056 输出
 * 字段名）、debitFlag（出账标志）。</p>
 *
 * <p>继承 {@link StepResult}：出账标志为「允许」时 succeed=true、errorCode/errorMessage 为 null
 * （「检查结果为通过」按 Spec 已接受结论 TBD-7 以步骤成功结束承载）；否则 succeed=false、
 * errorCode=ER0076、errorMessage 为 {@code ER0076::转出账户不允许出账，交易失败}。</p>
 */
public class ST027OutputBO extends StepResult {

    /** 转账止付标志（组件内步骤 ST052 返回，REQ-002） */
    private String transferStopFlag;

    /** 转账不收不付标志（组件内步骤 ST056 返回，REQ-003） */
    private String transferNoCreditNoDebitFlag;

    /** 出账标志（决策规则 DT001 返回，REQ-004） */
    private String debitFlag;

    /** 账户状态（对公存款账户主表 RB_BUS_ACCT，REQ-001） */
    private AcctStatus acctStatus;

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

    public String getDebitFlag() {
        return debitFlag;
    }

    public void setDebitFlag(String debitFlag) {
        this.debitFlag = debitFlag;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }
}

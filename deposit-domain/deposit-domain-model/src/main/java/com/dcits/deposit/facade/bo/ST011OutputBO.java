package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.PasswordStatus;

/**
 * ST011 检查支取密码状态 输出 BO。
 *
 * <p>继承 {@link StepResult}，业务字段来自正式 Spec「输出」表：passwordStatus（密码状态，
 * 非必填，来源实体对公账户密码表 RB_BUS_PASSWORD）。</p>
 */
public class ST011OutputBO extends StepResult {
    /** 密码状态 */
    private PasswordStatus passwordStatus;

    public PasswordStatus getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(PasswordStatus passwordStatus) {
        this.passwordStatus = passwordStatus;
    }
}

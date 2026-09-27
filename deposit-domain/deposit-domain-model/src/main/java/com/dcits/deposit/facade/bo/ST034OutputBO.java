package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST034 设置免费账户标志 步骤输出
 */
public class ST034OutputBO extends StepResult {

    /** 免收费标志，取值 是/否 */
    private String managementFreeFlag;

    public String getManagementFreeFlag() {
        return managementFreeFlag;
    }

    public void setManagementFreeFlag(String managementFreeFlag) {
        this.managementFreeFlag = managementFreeFlag;
    }
}

package com.dcits.depsit.facade.bo;

/**
 * ST048 检查存入账户账户属性 步骤输入。
 *
 * <p>输入字段来自 Spec「### 输入」表：{@code baseAcctNo}（账号，{@link String}，必填）。
 * 本步骤仅以该账号入参驱动，不使用「## 输入」表以外的业务输入。</p>
 */
public class ST048InputBO {

    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

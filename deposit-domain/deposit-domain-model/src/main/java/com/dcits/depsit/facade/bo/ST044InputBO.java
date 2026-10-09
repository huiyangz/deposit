package com.dcits.depsit.facade.bo;

/**
 * ST044 检查账户存在性 步骤输入 BO。
 *
 * <p>字段来源：正式 Spec「### 输入」表。本步骤只声明 {@code baseAcctNo} 一个业务入参，
 * 步骤 1「获取账户信息」的查询条件 {@code {账号}} 即取自该入参，不读取其它入参。</p>
 */
public class ST044InputBO {

    /** 账号（必填）。用作步骤 1 查询【账户信息】的查询条件 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

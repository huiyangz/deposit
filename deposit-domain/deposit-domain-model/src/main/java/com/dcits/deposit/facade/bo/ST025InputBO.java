package com.dcits.deposit.facade.bo;

/**
 * ST025 检查法透账户支取限制 输入 BO。
 *
 * <p>输入字段 baseAcctNo（账号）为必填，来源为调用方/交易上下文提供，作为三个组件内步骤
 * 调用（ST058/ST055/ST050）的 {账号} 参数。</p>
 */
public class ST025InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

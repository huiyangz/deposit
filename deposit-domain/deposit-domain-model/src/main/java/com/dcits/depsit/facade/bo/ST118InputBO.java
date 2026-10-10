package com.dcits.depsit.facade.bo;

/**
 * ST118 检查是否存在现金止收限制 输入 BO。
 *
 * <p>字段与正式 Spec「### 输入」表一一对应，仅 1 个入参：账号（{@code baseAcctNo}），
 * 由调用方提供，本步骤不为它补出取值来源。</p>
 */
public class ST118InputBO {

    /** 账号：待查账户的账号，步骤 1 按账号 + 限制状态查询【账户限制信息】的条件之一。 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

package com.dcits.depsit.facade.bo;

/**
 * ST113 检查有权机关冻结限制 输入 BO。
 *
 * <p>业务入参仅一个：账号（`baseAcctNo`），对应步骤描述中的 `{账号}`，作为子步骤 1
 * 查询【账户限制信息】的查询条件之一（Spec REQ-001）。「来源实体」列未声明，由调用方提供，
 * 本步骤不为它补出取值来源。</p>
 */
public class ST113InputBO {

    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

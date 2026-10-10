package com.dcits.depsit.facade.bo;

/**
 * ST102 检查账户机构是否可匹配到限额场景配置 输入 BO。
 *
 * <p>「## 输入」表仅一行字段：{@code baseAcctNo}（{@code java.lang.String}，标记「必填」，说明「账号」，
 * 来源实体列为空）。本步骤以该字段为唯一业务入参，源需求步骤描述中的 {账号} 唯一绑定到该字段
 * （REQ-001）；「## 输出」表中的任何字段都不作为入参。来源实体列为空，故不据此新增取数动作或默认值。</p>
 *
 * <p>该字段标「必填」，但源需求未定义其取到空值（{@code null} / 空字符串）时的校验与行为
 * （Spec「验收范围与明确不覆盖的事项」第 5 项），本 BO 与步骤实现均不作非空校验。</p>
 */
public class ST102InputBO {

    /** 账号（必填）；子步骤 1 查询【账户信息（RB_BUS_ACCT）】的定位条件，语义上唯一确定一条账户记录 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

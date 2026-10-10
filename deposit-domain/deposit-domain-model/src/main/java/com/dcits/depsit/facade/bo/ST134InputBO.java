package com.dcits.depsit.facade.bo;

/**
 * ST134 解限更新账户冻结金额 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤只有 1 个入参：{@code baseAcctNo}（账号，必填，来源实体
 * 对公存款账户限制表（RB_BUS_RESTRAINTS）），对应源需求步骤描述中的 {账号}，是本步骤查询
 * 【账户信息】的查询条件。</p>
 *
 * <p>账户内部键值为本步骤内部取得的查询结果，不作为调用方入参，故本 BO 不设该字段。</p>
 */
public class ST134InputBO {

    /** 账号（必填）；源需求步骤描述中的 {账号} */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

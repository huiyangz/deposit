package com.dcits.depsit.facade.bo;

/**
 * ST115 检查账户是否存在限制 输入 BO。
 *
 * <p>字段与正式 Spec「### 输入」表一一对应，仅 1 个入参：账号（{@code baseAcctNo}），
 * 由调用方上送，本步骤不为它补出取值来源，也不要求该字段之外的业务入参（Spec REQ-001）。</p>
 *
 * <p>「## 输入」表「来源实体」列为空，本 BO 只承载上送入参；{@code baseAcctNo} 标为「必填」，
 * 但源需求未定义其为空时的处理，本实现不生成空值校验（Spec「验收范围与明确不覆盖的事项」第 1 项）。</p>
 */
public class ST115InputBO {

    /** 账号：步骤描述第 1 条 {账号} 的绑定对象，作为查询【账户信息】的条件，也是「是主账户」分支下 [待查账户] 的取值。 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

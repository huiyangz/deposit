package com.dcits.depsit.facade.bo;

/**
 * ST126 检查是否存在现金止付限制 —— 步骤输入。
 *
 * <p>本步骤只有一个输入字段：{@code baseAcctNo} 为账号，是步骤 1 查询【账户限制信息】
 * （对公存款账户限制表 RB_BUS_RESTRAINTS）的查询条件之一，另一条件为限制状态的码值
 * 「A-生效」，由步骤自身确定、非入参。</p>
 *
 * <p>源需求将该字段标为「必填」，但未定义其无值、空字符串或格式非法时的行为，
 * 故本 BO 不作合法性校验，也不为缺值设计默认值或失败分支。</p>
 */
public class ST126InputBO {

    /** 账号（必填）：步骤 1 查询【账户限制信息】的查询条件之一 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

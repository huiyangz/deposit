package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;

public class RbLimitRuleRelationEO {
    /** 黑名单检查规则编号 */
    @NotNull
    private String ruleId;
    /** 规则描述 */
    private String ruleDesc;
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 关系规则表达式 */
    private String ruleRelationExpr;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getRuleRelationExpr() {
        return ruleRelationExpr;
    }

    public void setRuleRelationExpr(String ruleRelationExpr) {
        this.ruleRelationExpr = ruleRelationExpr;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
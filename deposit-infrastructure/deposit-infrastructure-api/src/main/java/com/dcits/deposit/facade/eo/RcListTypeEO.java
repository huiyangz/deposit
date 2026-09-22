package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListCategory;
import com.dcits.deposit.enums.ListType;
import jakarta.validation.constraints.NotNull;

public class RcListTypeEO {
    /** 名单类型代码 */
    @NotNull
    private ListType listType;
    /** 名单类型描述 */
    private String listTypeDesc;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 名单种类 */
    private ListCategory listCategory;
    /** 黑名单检查规则编号 */
    private String ruleId;

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public String getListTypeDesc() {
        return listTypeDesc;
    }

    public void setListTypeDesc(String listTypeDesc) {
        this.listTypeDesc = listTypeDesc;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ListCategory getListCategory() {
        return listCategory;
    }

    public void setListCategory(ListCategory listCategory) {
        this.listCategory = listCategory;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
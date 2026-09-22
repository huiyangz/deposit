package com.dcits.deposit.enums;

/** 兑付方式 */
public enum BillIssueType {
    /** 挂销账 */
    VALUE_3("3"),
    /** 转账 */
    VALUE_2("2"),
    /** 部分兑付 */
    VALUE_12("12"),
    /** 未用退回 */
    VALUE_13("13"),
    /** 现金 */
    VALUE_1("1"),
    /** 全额兑付 */
    VALUE_11("11"),
    /** 逾期退回 */
    VALUE_14("14");

    private String value;

    private BillIssueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BillIssueType byValue(String value) {
        for (BillIssueType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
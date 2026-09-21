package com.dcits.deposit.enums;

/** 交易种类 */
public enum TranCategory {
    /** 公允价值变动计入其他综合收益 */
    OCI("OCI"),
    /** 摊余成本计量 */
    AC("AC"),
    /** 公允价值变动计入当期损益 */
    FVTPL("FVTPL");

    private String value;

    private TranCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TranCategory byValue(String value) {
        for (TranCategory item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
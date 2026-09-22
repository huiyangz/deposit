package com.dcits.deposit.enums;

/** 业务分类 */
public enum BusiCategory {
    /** 总账 */
    GL("GL"),
    /** 贷款 */
    CL("CL"),
    /** 货币市场 */
    MM("MM"),
    /** 存款 */
    BB("BB");

    private String value;

    private BusiCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BusiCategory byValue(String value) {
        for (BusiCategory item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
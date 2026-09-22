package com.dcits.deposit.enums;

/** 法人代码 */
public enum Company {
    /** 虚拟总行 */
    ALL("ALL"),
    /** 北京神码 */
    BJITS("BJITS"),
    /** 神州数码有限公司 */
    DCITS("DCITS"),
    /** 西安神码 */
    XAITS("XAITS");

    private String value;

    private Company(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Company byValue(String value) {
        for (Company item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
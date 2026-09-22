package com.dcits.deposit.enums;

/** 自贸区类型 */
public enum FtaType {
    /** 转口集散型 */
    VALUE_01("01"),
    /** 贸工结合 */
    VALUE_02("02"),
    /** 出口加工型 */
    VALUE_03("03"),
    /** 保税仓储型 */
    VALUE_04("04");

    private String value;

    private FtaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FtaType byValue(String value) {
        for (FtaType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
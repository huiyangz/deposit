package com.dcits.deposit.enums;

/** 月基准天数类型 */
public enum MonthBasisType {
    /** 按实际天数 */
    ACT("ACT"),
    /** 按30天 */
    D30("D30"),
    /** 29 按29天 */
    D29("D29"),
    /** 31 按31天 */
    D31("D31");

    private String value;

    private MonthBasisType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MonthBasisType byValue(String value) {
        for (MonthBasisType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 年基准 */
public enum YearBasisType {
    /** 按360天计算日利率 */
    VALUE_360("360"),
    /** 按365天计算日利率 */
    VALUE_365("365"),
    /** 按366天计算日利率 */
    VALUE_366("366"),
    /** 按照每年实际天数计算日利率 */
    ACT("ACT");

    private String value;

    private YearBasisType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static YearBasisType byValue(String value) {
        for (YearBasisType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
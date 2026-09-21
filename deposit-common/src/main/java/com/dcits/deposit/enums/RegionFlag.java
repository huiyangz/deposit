package com.dcits.deposit.enums;

/** 区内区外标记 */
public enum RegionFlag {
    /** Out of region */
    O("O"),
    /** In region */
    I("I");

    private String value;

    private RegionFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RegionFlag byValue(String value) {
        for (RegionFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 机构类型 */
public enum BranchType {
    /** 他行 */
    O("O"),
    /** 本行 */
    I("I");

    private String value;

    private BranchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BranchType byValue(String value) {
        for (BranchType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
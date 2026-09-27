package com.dcits.deposit.enums;

/** 借贷标志 */
public enum CrDrInd {
    /** 贷 */
    C("C"),
    /** 借 */
    D("D");

    private String value;

    private CrDrInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CrDrInd byValue(String value) {
        for (CrDrInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
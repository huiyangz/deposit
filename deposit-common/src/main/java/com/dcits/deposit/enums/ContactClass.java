package com.dcits.deposit.enums;

/** 联系人分类 */
public enum ContactClass {
    /** 行内联系人 */
    I("I"),
    /** 行外联系人 */
    O("O");

    private String value;

    private ContactClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContactClass byValue(String value) {
        for (ContactClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
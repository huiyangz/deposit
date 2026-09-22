package com.dcits.deposit.enums;

/** 期次产品分类 */
public enum StageProdClass {
    /** 结构性存款 */
    ST("ST"),
    /** 大额存单 */
    DC("DC");

    private String value;

    private StageProdClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StageProdClass byValue(String value) {
        for (StageProdClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
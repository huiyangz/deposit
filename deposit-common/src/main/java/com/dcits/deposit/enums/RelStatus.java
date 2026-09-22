package com.dcits.deposit.enums;

/** 关联状态 */
public enum RelStatus {
    /** 失效 */
    F("F"),
    /** 生效 */
    A("A");

    private String value;

    private RelStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RelStatus byValue(String value) {
        for (RelStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
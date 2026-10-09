package com.dcits.depsit.enums;

/** 法透到期日计算规则 */
public enum OdMaturityRule {
    /** 不跨月 */
    VALUE_1("1"),
    /** 不跨季 */
    VALUE_2("2"),
    /** 普通法透 */
    VALUE_3("3");

    private String value;

    private OdMaturityRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OdMaturityRule byValue(String value) {
        for (OdMaturityRule item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
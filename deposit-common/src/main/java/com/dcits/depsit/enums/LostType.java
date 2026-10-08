package com.dcits.depsit.enums;

/** 挂失类型 */
public enum LostType {
    /** 挂失止付 */
    VALUE_0("0"),
    /** 公告挂失 */
    VALUE_1("1"),
    /** 提起诉讼 */
    VALUE_2("2"),
    /** 正式挂失 */
    FOR("FOR"),
    /** 口头挂失 */
    VER("VER");

    private String value;

    private LostType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LostType byValue(String value) {
        for (LostType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.depsit.enums;

/** 尾箱更新标志 */
public enum UpdTailboxFlag {
    /** 更新 */
    Y("Y"),
    /** 不更新 */
    N("N");

    private String value;

    private UpdTailboxFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UpdTailboxFlag byValue(String value) {
        for (UpdTailboxFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 源模块 */
public enum SourceModule {
    /** 贷款 */
    CL("CL"),
    /** 内部户 */
    IA("IA"),
    /** 总账 */
    GL("GL"),
    /** 所有 */
    ALL("ALL"),
    /** 公共业务 */
    CM("CM"),
    /** 存款 */
    RB("RB");

    private String value;

    private SourceModule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SourceModule byValue(String value) {
        for (SourceModule item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
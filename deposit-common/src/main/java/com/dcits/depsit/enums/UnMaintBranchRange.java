package com.dcits.depsit.enums;

/** 解限或维护机构范围 */
public enum UnMaintBranchRange {
    /** 原限制机构 */
    A("A"),
    /** 原限制机构及其上级机构 */
    B("B"),
    /** 开户机构 */
    C("C"),
    /** 开户机构及其上级机构 */
    D("D"),
    /** 任意机构 */
    E("E"),
    /** 总行 */
    F("F");

    private String value;

    private UnMaintBranchRange(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UnMaintBranchRange byValue(String value) {
        for (UnMaintBranchRange item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
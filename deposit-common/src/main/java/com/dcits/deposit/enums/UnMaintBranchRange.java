package com.dcits.deposit.enums;

/** 维护或解限机构范围 */
public enum UnMaintBranchRange {
    /** 任意机构 */
    E("E"),
    /** 开户机构及其上级机构 */
    D("D"),
    /** 开户机构 */
    C("C"),
    /** 总行 */
    F("F"),
    /** 原限制机构及其上级机构 */
    B("B"),
    /** 原限制机构 */
    A("A");

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
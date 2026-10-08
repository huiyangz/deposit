package com.dcits.depsit.enums;

/** 解挂类型 */
public enum RelieveLossType {
    /** 挂失撤销 */
    VALUE_0("0"),
    /** 期满补发 */
    VALUE_1("1"),
    /** 挂失销户 */
    VALUE_2("2");

    private String value;

    private RelieveLossType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RelieveLossType byValue(String value) {
        for (RelieveLossType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
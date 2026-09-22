package com.dcits.deposit.enums;

/** 卡片介质类型 */
public enum MediumType {
    /** 存折 */
    P("P"),
    /** IC卡 */
    I("I"),
    /** 虚拟卡 */
    V("V"),
    /** 磁条卡 */
    M("M");

    private String value;

    private MediumType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MediumType byValue(String value) {
        for (MediumType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
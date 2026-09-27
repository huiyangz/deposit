package com.dcits.deposit.enums;

/** 计息方式（内部使用） */
public enum IntCalcBal {
    /** 积数计息 */
    AB("AB"),
    /** 差减法计息 */
    BS("BS"),
    /** 分段计息 */
    EB("EB"),
    /** 靠档计息 */
    KD("KD");

    private String value;

    private IntCalcBal(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntCalcBal byValue(String value) {
        for (IntCalcBal item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 汇率类型 */
public enum RateType {
    /** 实时汇率 */
    CTR("CTR"),
    /** PBOC汇率 */
    EER("EER"),
    /** 货币对汇率 */
    HBD("HBD"),
    /** 准备金汇率 */
    ZBD("ZBD");

    private String value;

    private RateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RateType byValue(String value) {
        for (RateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
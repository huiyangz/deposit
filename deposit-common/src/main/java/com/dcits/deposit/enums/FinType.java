package com.dcits.deposit.enums;

/** 理财类型 */
public enum FinType {
    /** 坐享其盈 */
    ZXQY("ZXQY"),
    /** 存抵贷 */
    CDD("CDD"),
    /** 免费账户签约协议类型 */
    FAC("FAC"),
    /** 金额补足签约 */
    SL("SL");

    private String value;

    private FinType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FinType byValue(String value) {
        for (FinType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
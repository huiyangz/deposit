package com.dcits.deposit.enums;

/** 挂销账资金的来源和去向 */
public enum HangDealType {
    /** 现金 */
    C("C"),
    /** 总账 */
    G("G"),
    /** 内部账 */
    I("I"),
    /** 客户账 */
    R("R");

    private String value;

    private HangDealType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HangDealType byValue(String value) {
        for (HangDealType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 资金来源 */
public enum FundSource {
    /** 现金 */
    C("C"),
    /** 总账 */
    G("G"),
    /** 内部账 */
    I("I"),
    /** 行外账户 */
    O("O"),
    /** 客户账 */
    R("R");

    private String value;

    private FundSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FundSource byValue(String value) {
        for (FundSource item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
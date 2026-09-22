package com.dcits.deposit.enums;

/** 签约产品分类 */
public enum SpecialProdClass {
    /** 登记簿类产品 */
    R("R"),
    /** 已解约 */
    C("C"),
    /** 期次类产品 */
    S("S");

    private String value;

    private SpecialProdClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SpecialProdClass byValue(String value) {
        for (SpecialProdClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
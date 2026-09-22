package com.dcits.deposit.enums;

/** 查证类型 */
public enum CheckCertificateType {
    /** 全部查证 */
    VALUE_1("1"),
    /** 对非资金类业务查证 */
    VALUE_2("2"),
    /** 对资金类业务查证 */
    VALUE_3("3"),
    /** 免查证 */
    VALUE_4("4");

    private String value;

    private CheckCertificateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CheckCertificateType byValue(String value) {
        for (CheckCertificateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
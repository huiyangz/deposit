package com.dcits.deposit.enums;

/** 协议存款类型 */
public enum AgreementDepositType {
    /** 其他 */
    D("D"),
    /** 保险公司协议存款 */
    A("A"),
    /** 全国社保基金理事会协议存款 */
    C("C"),
    /** 养老保险个人帐户基金协议存款 */
    B("B");

    private String value;

    private AgreementDepositType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AgreementDepositType byValue(String value) {
        for (AgreementDepositType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
package com.dcits.deposit.enums;

/** 支取方式 */
public enum WithdrawalType {
    /** 凭印鉴和密码支取 */
    B("B"),
    /** 凭证件支取 */
    O("O"),
    /** 凭密码支取 */
    P("P"),
    /** 支付密码器和印鉴 */
    R("R"),
    /** 凭印鉴支取 */
    S("S"),
    /** 无密码无印鉴支取 */
    W("W");

    private String value;

    private WithdrawalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WithdrawalType byValue(String value) {
        for (WithdrawalType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
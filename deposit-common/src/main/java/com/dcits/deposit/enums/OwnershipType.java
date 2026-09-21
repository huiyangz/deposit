package com.dcits.deposit.enums;

/** 归属种类 */
public enum OwnershipType {
    /** 独立账户 */
    SG("SG"),
    /** 多客户联名 */
    AS("AS"),
    /** 继承账户 */
    SU("SU");

    private String value;

    private OwnershipType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OwnershipType byValue(String value) {
        for (OwnershipType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
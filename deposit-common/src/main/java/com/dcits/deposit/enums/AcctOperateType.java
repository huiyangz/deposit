package com.dcits.deposit.enums;

/** 账户操作类型 */
public enum AcctOperateType {
    /** 销户 */
    C("C"),
    /** 账户维护 */
    M("M"),
    /** 账户开户 */
    O("O"),
    /** 销户重开 */
    R("R");

    private String value;

    private AcctOperateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctOperateType byValue(String value) {
        for (AcctOperateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
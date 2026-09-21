package com.dcits.deposit.enums;

/** 转久悬操作类型 */
public enum DossOperateType {
    /** 账户激活 */
    SA("SA"),
    /** 正常转不动户 */
    AD("AD"),
    /** 营业外销户 */
    OC("OC"),
    /** 冒名转久悬 */
    CS("CS"),
    /** 不动户激活 */
    DA("DA"),
    /** 久悬户转营业外 */
    SO("SO"),
    /** 久悬后期入账 */
    SI("SI"),
    /** 久悬户销户 */
    SC("SC"),
    /** 转久悬 */
    DS("DS"),
    /** 冒名久悬销户支取 */
    SD("SD");

    private String value;

    private DossOperateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DossOperateType byValue(String value) {
        for (DossOperateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
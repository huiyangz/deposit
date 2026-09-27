package com.dcits.deposit.enums;

/** 账户属性分类 */
public enum NatureClass {
    /** 基本户 */
    VALUE_1("1"),
    /** 经常项目账户 */
    VALUE_10("10"),
    /** 一般户 */
    VALUE_2("2"),
    /** 保证金账户 */
    VALUE_3("3"),
    /** 备案类账户 */
    VALUE_4("4"),
    /** 验资类账户 */
    VALUE_5("5"),
    /** 核准类账户 */
    VALUE_6("6"),
    /** 临时户 */
    VALUE_7("7"),
    /** 内部户 */
    VALUE_8("8"),
    /** 资本项目账户 */
    VALUE_9("9"),
    /** 结算户 */
    C("C"),
    /** 存储户 */
    S("S"),
    /** 定期 */
    T("T"),
    /** 虚拟账户 */
    V("V");

    private String value;

    private NatureClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NatureClass byValue(String value) {
        for (NatureClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
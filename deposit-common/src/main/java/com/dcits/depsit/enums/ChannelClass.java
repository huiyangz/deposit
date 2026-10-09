package com.dcits.depsit.enums;

/** 渠道分类 */
public enum ChannelClass {
    /** 人工渠道 */
    VALUE_1("1"),
    /** 自助渠道 */
    VALUE_2("2"),
    /** 电子渠道 */
    VALUE_3("3"),
    /** 第三方渠道 */
    VALUE_4("4"),
    /** 内部渠道 */
    VALUE_9("9");

    private String value;

    private ChannelClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ChannelClass byValue(String value) {
        for (ChannelClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
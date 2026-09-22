package com.dcits.deposit.enums;

/** 民族 */
public enum Nation {
    /** 白族 */
    VALUE_14("14"),
    /** 傣族 */
    VALUE_18("18"),
    /** 回族 */
    VALUE_03("03"),
    /** 维吾尔族 */
    VALUE_05("05"),
    /** 撒拉族 */
    VALUE_35("35"),
    /** 羌族 */
    VALUE_33("33"),
    /** 拉祜族 */
    VALUE_24("24"),
    /** 东乡族 */
    VALUE_26("26"),
    /** 黎族 */
    VALUE_19("19"),
    /** 基诺族 */
    VALUE_56("56"),
    /** 水族 */
    VALUE_25("25"),
    /** 普米族 */
    VALUE_40("40"),
    /** 哈尼族 */
    VALUE_16("16"),
    /** 柯尔克孜族 */
    VALUE_29("29"),
    /** 俄罗斯族 */
    VALUE_44("44"),
    /** 彝族 */
    VALUE_07("07"),
    /** 独龙族 */
    VALUE_51("51"),
    /** 侗族 */
    VALUE_12("12"),
    /** 佤族 */
    VALUE_21("21"),
    /** 仡佬族 */
    VALUE_37("37"),
    /** 锡伯族 */
    VALUE_38("38"),
    /** 哈萨克族 */
    VALUE_17("17"),
    /** 布依族 */
    VALUE_09("09"),
    /** 朝鲜族 */
    VALUE_10("10"),
    /** 鄂温克族 */
    VALUE_45("45"),
    /** 满族 */
    VALUE_11("11"),
    /** 毛南族 */
    VALUE_36("36"),
    /** 德昂族 */
    VALUE_46("46"),
    /** 藏族 */
    VALUE_04("04"),
    /** 塔塔尔族 */
    VALUE_50("50"),
    /** 汉族 */
    VALUE_01("01"),
    /** 保安族 */
    VALUE_47("47"),
    /** 壮族 */
    VALUE_08("08"),
    /** 蒙古族 */
    VALUE_02("02"),
    /** 土家族 */
    VALUE_15("15"),
    /** 门巴族 */
    VALUE_54("54"),
    /** 傈僳族 */
    VALUE_20("20"),
    /** 达斡尔族 */
    VALUE_31("31"),
    /** 仫佬族 */
    VALUE_32("32"),
    /** 怒族 */
    VALUE_42("42"),
    /** 京族 */
    VALUE_49("49"),
    /** 鄂伦春族 */
    VALUE_52("52"),
    /** 纳西族 */
    VALUE_27("27"),
    /** 布朗族 */
    VALUE_34("34"),
    /** 裕固族 */
    VALUE_48("48"),
    /** 阿昌族 */
    VALUE_39("39"),
    /** 乌孜别克族 */
    VALUE_43("43"),
    /** 土族 */
    VALUE_30("30"),
    /** 高山族 */
    VALUE_23("23"),
    /** 苗族 */
    VALUE_06("06"),
    /** 畲族 */
    VALUE_22("22"),
    /** 赫哲族 */
    VALUE_53("53"),
    /** 瑶族 */
    VALUE_13("13"),
    /** 塔吉克族 */
    VALUE_41("41"),
    /** 珞巴族 */
    VALUE_55("55"),
    /** 景颇族 */
    VALUE_28("28");

    private String value;

    private Nation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Nation byValue(String value) {
        for (Nation item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
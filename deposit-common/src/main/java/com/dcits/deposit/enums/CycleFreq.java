package com.dcits.deposit.enums;

/** 通用-周期 */
public enum CycleFreq {
    /** TOMORROW(顺延) */
    VALUE_1D("1D"),
    /** 1 MONTH(顺延) */
    VALUE_1M("1M"),
    /** 1 MONTH(提前) */
    VALUE_1MA("1MA"),
    /** 1 YEAR(顺延) */
    VALUE_1Y("1Y"),
    /** 1 YEAR(提前) */
    VALUE_1YA("1YA"),
    /** 29 DAY(顺延) */
    VALUE_29("29"),
    /** 29 DAY(提前) */
    VALUE_29A("29A"),
    /** SPOT(顺延) */
    VALUE_2D("2D"),
    /** SPOT(提前) */
    VALUE_2DA("2DA"),
    /** 2 MONTH(顺延) */
    VALUE_2M("2M"),
    /** 2 MONTH(提前) */
    VALUE_2MA("2MA"),
    /** 二周(顺延) */
    VALUE_2W("2W"),
    /** 二周(提前) */
    VALUE_2WA("2WA"),
    /** 2 YEAR(顺延) */
    VALUE_2Y("2Y"),
    /** 2 YEAR(提前) */
    VALUE_2YA("2YA"),
    /** 30 DAY(顺延) */
    VALUE_30("30"),
    /** 30 DAY(提前) */
    VALUE_30A("30A"),
    /** 330 DAY(顺延) */
    VALUE_330D("330D"),
    /** 3 MONTH(顺延) */
    VALUE_3M("3M"),
    /** 3 MONTH(提前) */
    VALUE_3MA("3MA"),
    /** 3 YEAR(顺延) */
    VALUE_3Y("3Y"),
    /** 3 YEAR(提前) */
    VALUE_3YA("3YA"),
    /** 4 MONTH(顺延) */
    VALUE_4M("4M"),
    /** 4 MONTH(提前) */
    VALUE_4MA("4MA"),
    /** 4 YEAR(顺延) */
    VALUE_4Y("4Y"),
    /** 4 YEAR(提前) */
    VALUE_4YA("4YA"),
    /** 59 DAY(顺延) */
    VALUE_59("59"),
    /** 59 DAY(提前) */
    VALUE_59A("59A"),
    /** 5 YEAR(顺延) */
    VALUE_5Y("5Y"),
    /** 5 YEAR(提前) */
    VALUE_5YA("5YA"),
    /** 60 DAY(顺延) */
    VALUE_60("60"),
    /** 60 DAY(提前) */
    VALUE_60A("60A"),
    /** 6 MONTH(顺延) */
    VALUE_6M("6M"),
    /** 6 MONTH(提前) */
    VALUE_6MA("6MA"),
    /** 6 YEAR(顺延) */
    VALUE_6Y("6Y"),
    /** 6 YEAR(提前) */
    VALUE_6YA("6YA"),
    /** 一周(顺延) */
    VALUE_7D("7D"),
    /** 一周(提前) */
    VALUE_7DA("7DA"),
    /** 7 YEAR(顺延) */
    VALUE_7Y("7Y"),
    /** 7 YEAR(提前) */
    VALUE_7YA("7YA"),
    /** 89 DAY(顺延) */
    VALUE_89("89"),
    /** 89 DAY(提前) */
    VALUE_89A("89A"),
    /** 8 YEAR(顺延) */
    VALUE_8Y("8Y"),
    /** 8 YEAR(提前) */
    VALUE_8YA("8YA"),
    /** 90 DAY(顺延) */
    VALUE_90("90"),
    /** 90 DAY(提前) */
    VALUE_90A("90A"),
    /** 90 DAY(顺延) */
    VALUE_90D("90D"),
    /** 99999 DAY(顺延) */
    VALUE_99999("99999"),
    /** 9 MONTH(顺延) */
    VALUE_9M("9M"),
    /** 9 MONTH(提前) */
    VALUE_9MA("9MA"),
    /** 本月实际天(顺延) */
    AM("AM"),
    /** 本月实际天(提前) */
    AMA("AMA"),
    /** 0 TODAY */
    D0("D0"),
    /** TOMORROW(不顺延) */
    D1("D1"),
    /** SPOT(不顺延) */
    D2("D2"),
    /** 31天 */
    D31("D31"),
    /** 一周(不顺延) */
    D7("D7"),
    /** 92天 */
    D92("D92"),
    /** 一旬(不顺延) */
    DT("DT"),
    /** 月初(顺延) */
    FM("FM"),
    /** 月初(提前) */
    FMA("FMA"),
    /** 1年初(顺延) */
    FY("FY"),
    /** 1年初(提前) */
    FYA("FYA"),
    /** 6个月 */
    HD("HD"),
    /** 半月(顺延) */
    HM("HM"),
    /** 半月(提前) */
    HMA("HMA"),
    /** 半年末(顺延) */
    HY("HY"),
    /** 半年末(提前) */
    HYA("HYA"),
    /** 月末(顺延) */
    LM("LM"),
    /** 月末(提前) */
    LMA("LMA"),
    /** 1年末(顺延) */
    LY("LY"),
    /** 1年末(提前) */
    LYA("LYA"),
    /** 1 MONTH(不顺延) */
    M1("M1"),
    /** 2 MONTH(不顺延) */
    M2("M2"),
    /** 3 MONTH(不顺延) */
    M3("M3"),
    /** 4 MONTH(不顺延) */
    M4("M4"),
    /** 6 MONTH(不顺延) */
    M6("M6"),
    /** 9 MONTH(不顺延) */
    M9("M9"),
    /** 本月实际天(不顺延) */
    MA("MA"),
    /** 1个月 */
    MD("MD"),
    /** 月初(不顺延) */
    MF("MF"),
    /** 半月(不顺延) */
    MH("MH"),
    /** 月末(不顺延) */
    ML("ML"),
    /** 3个月 */
    QD("QD"),
    /** 季度初（不顺延） */
    QF("QF"),
    /** 季度末(不顺延) */
    QL("QL"),
    /** 一旬(顺延) */
    TD("TD"),
    /** 一旬(提前) */
    TDA("TDA"),
    /** 二周(不顺延) */
    W2("W2"),
    /** 1 YEAR(不顺延) */
    Y1("Y1"),
    /** 2 YEAR(不顺延) */
    Y2("Y2"),
    /** 3 YEAR(不顺延) */
    Y3("Y3"),
    /** 4 YEAR(不顺延) */
    Y4("Y4"),
    /** 5 YEAR(不顺延) */
    Y5("Y5"),
    /** 6 YEAR(不顺延) */
    Y6("Y6"),
    /** 7 YEAR(不顺延) */
    Y7("Y7"),
    /** 8 YEAR(不顺延) */
    Y8("Y8"),
    /** 1年 */
    YD("YD"),
    /** 1年初(不顺延) */
    YF("YF"),
    /** 半年末(不顺延) */
    YH("YH"),
    /** 1年末(不顺延) */
    YL("YL");

    private String value;

    private CycleFreq(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CycleFreq byValue(String value) {
        for (CycleFreq item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
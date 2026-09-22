package com.dcits.deposit.enums;

/** 额度扣减类型 */
public enum StageLimitClass {
    /** 全额配售 */
    A("A"),
    /** 分行白名单额度 */
    WHITEBRANCH("WHITEBRANCH"),
    /** 比例配售 */
    P("P"),
    /** 支行额度 */
    SUBBRANCH("SUBBRANCH"),
    /** 年度额度 */
    YEAR("YEAR"),
    /** 机构额度 */
    BRANCH("BRANCH"),
    /** 对公/对私额度 */
    INDVLCORP("INDVLCORP"),
    /** 渠道额度 */
    CHANNEL("CHANNEL"),
    /** 所有额度 */
    ALL("ALL"),
    /** 期次额度 */
    STAGE("STAGE"),
    /** 白名单额度 */
    WHITE("WHITE");

    private String value;

    private StageLimitClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StageLimitClass byValue(String value) {
        for (StageLimitClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
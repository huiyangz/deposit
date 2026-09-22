package com.dcits.deposit.enums;

/** 金额计算类型 */
public enum AmtCalcType {
    /** 逾期本金增加 */
    C("c"),
    /** 逾期余额减少 */
    T("t"),
    /** 未到期本金减少 */
    B("b"),
    /** 当日结息利息 */
    L("l"),
    /** 逾期利息减少 */
    VALUE_8("8"),
    /** 逾期罚息增加 */
    VALUE_5("5"),
    /** 久悬余额增加 */
    O("o"),
    /** 宽限期内到期本金减少 */
    V("v"),
    /** 逾期罚息减少 */
    VALUE_9("9"),
    /** 逾期本金减少 */
    VALUE_7("7"),
    /** 逾期复利增加 */
    VALUE_6("6"),
    /** 透支金额减少无流水 */
    I("i"),
    /** 未到期本金减少 */
    Q("q"),
    /** 贴现利息 */
    K("k"),
    /** 宽限期内未到期本金减少 */
    R("r"),
    /** 发放金额增加无流水 */
    F("f"),
    /** 久悬余额减少 */
    P("p"),
    /** 逾期利息增加 */
    VALUE_4("4"),
    /** 未实现利息 */
    U("u"),
    /** 额度减少无流水 */
    H("h"),
    /** 当日结息复利 */
    N("n"),
    /** 逾期余额增加 */
    S("s"),
    /** 当日结息罚息 */
    M("m"),
    /** 未到期本金增加 */
    VALUE_3("3"),
    /** 余额增加 */
    VALUE_0("0"),
    /** 余额减少 */
    VALUE_1("1"),
    /** 余额减少无流水 */
    G("g"),
    /** 发放金额增加 */
    VALUE_2("2"),
    /** 余额增加无流水 */
    E("e"),
    /** 逾期复利减少 */
    A("a"),
    /** 透支金额增加无流水 */
    J("j"),
    /** 未到期本金减少 */
    D("d");

    private String value;

    private AmtCalcType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmtCalcType byValue(String value) {
        for (AmtCalcType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
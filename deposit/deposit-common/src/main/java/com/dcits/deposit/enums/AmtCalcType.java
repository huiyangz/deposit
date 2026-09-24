package com.dcits.deposit.enums;

/** 金额计算类型 */
public enum AmtCalcType {
    /** 余额增加 */
    VALUE_0("0"),
    /** 余额减少 */
    VALUE_1("1"),
    /** 发放金额增加 */
    VALUE_2("2"),
    /** 未到期本金增加 */
    VALUE_3("3"),
    /** 逾期利息增加 */
    VALUE_4("4"),
    /** 逾期罚息增加 */
    VALUE_5("5"),
    /** 逾期复利增加 */
    VALUE_6("6"),
    /** 逾期本金减少 */
    VALUE_7("7"),
    /** 逾期利息减少 */
    VALUE_8("8"),
    /** 逾期罚息减少 */
    VALUE_9("9"),
    /** 逾期复利减少 */
    A("a"),
    /** 未到期本金减少 */
    B("b"),
    /** 逾期本金增加 */
    C("c"),
    /** 未到期本金减少 */
    D("d"),
    /** 余额增加无流水 */
    E("e"),
    /** 发放金额增加无流水 */
    F("f"),
    /** 余额减少无流水 */
    G("g"),
    /** 额度减少无流水 */
    H("h"),
    /** 透支金额减少无流水 */
    I("i"),
    /** 透支金额增加无流水 */
    J("j"),
    /** 贴现利息 */
    K("k"),
    /** 当日结息利息 */
    L("l"),
    /** 当日结息罚息 */
    M("m"),
    /** 当日结息复利 */
    N("n"),
    /** 未到期本金减少 */
    Q("q"),
    /** 久悬余额增加 */
    O("o"),
    /** 久悬余额减少 */
    P("p"),
    /** 宽限期内未到期本金减少 */
    R("r"),
    /** 逾期余额增加 */
    S("s"),
    /** 逾期余额减少 */
    T("t"),
    /** 未实现利息 */
    U("u"),
    /** 宽限期内到期本金减少 */
    V("v");

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
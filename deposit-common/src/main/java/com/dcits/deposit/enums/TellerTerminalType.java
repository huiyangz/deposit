package com.dcits.deposit.enums;

/** 终端类型 */
public enum TellerTerminalType {
    /** Banking terminal */
    T("T"),
    /** Communication line */
    C("C"),
    /** Hexagon */
    H("H"),
    /** PTS */
    S("S"),
    /** Diskette */
    D("D"),
    /** ATM */
    A("A"),
    /** VDU */
    V("V"),
    /** Program */
    P("P"),
    /** File */
    F("F");

    private String value;

    private TellerTerminalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TellerTerminalType byValue(String value) {
        for (TellerTerminalType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
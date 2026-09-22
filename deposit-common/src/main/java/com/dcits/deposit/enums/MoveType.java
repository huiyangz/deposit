package com.dcits.deposit.enums;

/** 现金凭证调拨类型 */
public enum MoveType {
    /** 强制调剂 */
    AF("AF"),
    /** 机构尾箱上缴 */
    GC("GC"),
    /** 分配 */
    D("D"),
    /** 非本行出库 */
    O("O"),
    /** 领取 */
    F("F"),
    /** 上缴 */
    C("C"),
    /** 退回冲正 */
    R("R"),
    /** 调剂 */
    A("A"),
    /** 行内机构间出入库 */
    OI("OI"),
    /** 非本行入库 */
    I("I"),
    /** 金库分配 */
    GD("GD");

    private String value;

    private MoveType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MoveType byValue(String value) {
        for (MoveType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
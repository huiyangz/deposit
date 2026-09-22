package com.dcits.deposit.enums;

/** 票据类型 */
public enum BillType {
    /** 可转让汇票 */
    CT00("CT00"),
    /** 可转让本票 */
    PN02("PN02"),
    /** 现金汇票(三省一市) */
    BE01("BE01"),
    /** 可转让汇票(三省一市) */
    BE02("BE02"),
    /** 现金汇票 */
    CT02("CT02"),
    /** 不可转让本票 */
    PN03("PN03"),
    /** 不可转让汇票(三省一市) */
    BE03("BE03"),
    /** 现金本票 */
    PN01("PN01"),
    /** 不可转让汇票 */
    CT01("CT01");

    private String value;

    private BillType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BillType byValue(String value) {
        for (BillType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
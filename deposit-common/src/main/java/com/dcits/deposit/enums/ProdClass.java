package com.dcits.deposit.enums;

/** 产品分类 */
public enum ProdClass {
    /** 资产类 */
    A("A"),
    /** 贷款类 */
    CL("CL"),
    /** 对私贷款组 */
    CL100("CL100"),
    /** 对公贷款组 */
    CL200("CL200"),
    /** 贴现组 */
    CL300("CL300"),
    /** 垫款组 */
    CL400("CL400"),
    /** 委托贷款组 */
    CL500("CL500"),
    /** 银团贷款组 */
    CL600("CL600"),
    /** 贷款基础产品组 */
    CLBASE("CLBASE"),
    /** 内部账类 */
    GL("GL"),
    /** 内部账组 */
    GL100("GL100"),
    /** 存放同业组 */
    GL200("GL200"),
    /** 内部账基础产品组 */
    GLBASE("GLBASE"),
    /** 负债类 */
    L("L"),
    /** 存款类 */
    RB("RB"),
    /** 个人存款组 */
    RB100("RB100"),
    /** 对公存款组 */
    RB200("RB200"),
    /** 同业存款组 */
    RB300("RB300"),
    /** 存款基础产品组 */
    RBBASE("RBBASE");

    private String value;

    private ProdClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProdClass byValue(String value) {
        for (ProdClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}
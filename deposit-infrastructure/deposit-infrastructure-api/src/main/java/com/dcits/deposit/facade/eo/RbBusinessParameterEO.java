package com.dcits.deposit.facade.eo;

import jakarta.validation.constraints.NotNull;

public class RbBusinessParameterEO {
    /** 参数名称 */
    @NotNull
    private String paraKey;
    /** 参数值 */
    @NotNull
    private String paraValue;
    /** 参数描述 */
    private String paraDesc;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;

    public String getParaKey() {
        return paraKey;
    }

    public void setParaKey(String paraKey) {
        this.paraKey = paraKey;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
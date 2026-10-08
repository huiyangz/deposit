package com.dcits.depsit.entity;

public class FmChannel {
    /** 柜面标志 */
    private String counterFlag;
    /** 外围渠道类型 */
    private String channelType;
    /** 渠道简称 */
    private String channelShort;
    /** 渠道 */
    private String channel;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 渠道分类 */
    private String channelClass;
    /** 渠道描述 */
    private String channelDesc;

    public String getCounterFlag() {
        return counterFlag;
    }

    public void setCounterFlag(String counterFlag) {
        this.counterFlag = counterFlag;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelShort() {
        return channelShort;
    }

    public void setChannelShort(String channelShort) {
        this.channelShort = channelShort;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getChannelClass() {
        return channelClass;
    }

    public void setChannelClass(String channelClass) {
        this.channelClass = channelClass;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }
}
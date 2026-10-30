package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.ChannelClass;
import com.dcits.deposit.enums.SourceType;
import jakarta.validation.constraints.NotNull;

public class FmChannelEO {
    /** 外围渠道类型 */
    private SourceType channelType;
    /** 渠道简称 */
    private String channelShort;
    /** 渠道 */
    @NotNull
    private SourceType channel;
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 渠道分类 */
    private ChannelClass channelClass;
    /** 渠道描述 */
    @NotNull
    private String channelDesc;

    public SourceType getChannelType() {
        return channelType;
    }

    public void setChannelType(SourceType channelType) {
        this.channelType = channelType;
    }

    public String getChannelShort() {
        return channelShort;
    }

    public void setChannelShort(String channelShort) {
        this.channelShort = channelShort;
    }

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
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

    public ChannelClass getChannelClass() {
        return channelClass;
    }

    public void setChannelClass(ChannelClass channelClass) {
        this.channelClass = channelClass;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }
}
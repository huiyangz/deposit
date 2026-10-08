package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.ChannelClass;
import com.dcits.depsit.enums.SourceType;
import jakarta.validation.constraints.NotNull;

public class RbChannelClassEO {
    /** 渠道分类 */
    @NotNull
    private ChannelClass channelClass;
    /** 渠道描述 */
    @NotNull
    private String channelDesc;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 渠道 */
    @NotNull
    private SourceType channel;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;

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

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
        this.channel = channel;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
package com.dcits.deposit.entity;

import java.util.Date;

public class RbAcctWithdrawType {
    /** 支取方式内部键 */
    private String withdrawKey;
    /** 渠道 */
    private String channel;
    /** 支取方式 */
    private String withdrawalType;
    /** 客户号 */
    private String clientNo;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getWithdrawKey() {
        return withdrawKey;
    }

    public void setWithdrawKey(String withdrawKey) {
        this.withdrawKey = withdrawKey;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
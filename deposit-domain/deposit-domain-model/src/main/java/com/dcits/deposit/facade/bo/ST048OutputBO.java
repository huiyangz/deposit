package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.Status;

/**
 * ST048 检查限制豁免 步骤输出。
 *
 * <p>继承 {@link StepResult}；业务字段对应正式 Spec「输出」表，取值与对应查询结果一致。</p>
 */
public class ST048OutputBO extends StepResult {

                                                                                                                                                                                                                                                                                                                     
    /** 柜面标志（来源渠道类型表 FM_CHANNEL，子步骤1 取得） */
                                                       
    private String channelCounterFlag;

    /** 状态（来源限制控制明细） */
    private Status status;

    /** 产品编号（来源限制控制明细） */
    private String prodNo;

    /** 多交易类型（来源限制控制明细） */
    private String tranTypeLink;

    /** 渠道集合（来源限制控制明细） */
    private String channelMuster;

    /** 摘要码（来源限制控制明细） */
    private String narrativeCode;

    /** 限制机构范围（来源限制控制明细） */
    private LimitBranchRange resBranchRange;

    /** 柜面标志（来源限制控制明细） */
    private String counterFlag;

    public String getChannelCounterFlag() {
        return channelCounterFlag;
    }

    public void setChannelCounterFlag(String channelCounterFlag) {
        this.channelCounterFlag = channelCounterFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getTranTypeLink() {
        return tranTypeLink;
    }

    public void setTranTypeLink(String tranTypeLink) {
        this.tranTypeLink = tranTypeLink;
    }

    public String getChannelMuster() {
        return channelMuster;
    }

    public void setChannelMuster(String channelMuster) {
        this.channelMuster = channelMuster;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public LimitBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(LimitBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getCounterFlag() {
        return counterFlag;
    }

    public void setCounterFlag(String counterFlag) {
        this.counterFlag = counterFlag;
    }
}

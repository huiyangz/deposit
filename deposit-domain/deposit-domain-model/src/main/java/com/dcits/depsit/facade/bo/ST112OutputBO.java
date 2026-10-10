package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.Status;

/**
 * ST112 检查限制豁免 出参。
 *
 * <p>字段、类型与标记照录正式 Spec「## 输出」表的 7 个非必填字段，来源实体为
 * 存款限制检查控制详情（RB_RESTRAINT_CONTROL_DETAILS）。[限制控制明细信息] 命中记录时
 * 承载该集合记录对应字段的值，集合为空时为空值。按 REQ-008，本步骤不产出这 7 个字段之外的
 * 数据，[渠道的柜面标志] 与 [账户限制类型对应的柜面标志] 两个中间值不写入输出。</p>
 */
public class ST112OutputBO extends StepResult {

    /** 状态（明细记录的 $状态$） */
    private Status status;

    /** 产品编号（明细记录的 $产品类型$） */
    private String prodNo;

    /** 多交易类型（明细记录的 $多交易类型$） */
    private String tranTypeLink;

    /** 渠道集合（明细记录的 $渠道集合$） */
    private String channelMuster;

    /** 摘要码（明细记录的 $摘要码$，与入参 narrativeCode 同名不同义） */
    private String narrativeCode;

    /** 限制机构范围（明细记录的 $限制机构范围$） */
    private LimitBranchRange resBranchRange;

    /** 柜面标志（明细记录的 $柜面标志$） */
    private String counterFlag;

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

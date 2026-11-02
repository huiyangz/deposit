package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;

/**
 * ST034 检查对手账户黑名单 输出 BO。
 */
public class ST034OutputBO extends StepResult {
    /** 事件类型（第 2 步赋值为 "CRET"） */
    private String eventType;
    /** 处理方式（与[执行结果]的承载关系见 TBD-6） */
    private DealFlow dealFlow;
    // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段「授权标志」的工程承载字段（BO 字段名）未定义 - 影响:本实现暂以 authFlag 承载，字段名可能与后续确认不一致 - 待确认:「授权标志」输出字段的工程承载字段名
    /** 授权标志（第 4 步 b 分支时值为 "是"） */
    private String authFlag;
    /** 凭证种类（第 1 步取得） */
    private DocClass docClass;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }

    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }
}

package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DocClass;

/**
 * ST035 检查支取账户黑名单 步骤输出。
 *
 * <p>继承 {@link StepResult}。业务输出字段来自正式 Spec「输出」表：eventType（事件类型，
 * 第 2 步赋值为「DEBT」）、授权标志（第 4 步授权分支赋值为「是」）、docClass（凭证种类，
 * 第 1 步按凭证类型查询凭证类型定义表取得）。</p>
 */
public class ST035OutputBO extends StepResult {

    /** 事件类型（非必填，第 2 步赋值为「DEBT」） */
    private String eventType;

    /** 授权标志（非必填，第 4 步授权分支赋值为「是」） */
    private String 授权标志;

    /** 凭证种类（非必填，来源凭证类型定义表 TB_VOUCHER_DEF） */
    private DocClass docClass;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String get授权标志() {
        return 授权标志;
    }

    public void set授权标志(String 授权标志) {
        this.授权标志 = 授权标志;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }
}

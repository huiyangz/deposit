package com.dcits.depsit.facade.bo;

import java.util.Date;

/**
 * ST101 获取限额场景编码的输入 BO。
 *
 * <p>字段名、类型与「必填」标记照录正式 Spec「### 输入」表（REQ-001）：
 * baseAcctNo（账号）、clientNo（客户号）、limitSceneNo（限额场景编码）、tranDate（交易日期）。
 * [限额场景编码] 绑定 limitSceneNo、[客户号] 绑定 clientNo、{交易日期} 绑定 tranDate。</p>
 *
 * <p>baseAcctNo 未被「## 步骤描述」使用，本步骤不为其生成查询条件、校验或输出行为；
 * 源需求未定义任一必填输入取空时的校验或分支口径，故本 BO 不承载输入校验。</p>
 */
public class ST101InputBO {

    /** 账号（必填；源需求「## 步骤描述」未使用该字段） */
    private String baseAcctNo;

    /** 客户号（必填；[客户号]，子步骤3 的定位条件之一） */
    private String clientNo;

    /** 限额场景编码（必填；[限额场景编码]，子步骤1 与子步骤3 的定位条件，并作为返回结论的值） */
    private String limitSceneNo;

    /** 交易日期（必填；{交易日期}，参与生效日期筛选与失效日期比较） */
    private Date tranDate;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}

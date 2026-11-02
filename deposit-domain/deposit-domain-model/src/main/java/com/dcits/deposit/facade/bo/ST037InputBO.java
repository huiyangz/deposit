package com.dcits.deposit.facade.bo;

import java.util.Date;

/**
 * ST037 获取限额场景编码 输入 BO。
 *
 * <p>对应正式 Spec「输入」表：baseAcctNo（账号）、clientNo（客户号）、
 * limitSceneNo（限额场景编码）、tranDate（交易日期）。</p>
 */
public class ST037InputBO {

    /** 账号 */
    private String baseAcctNo;

    /** 客户号 */
    private String clientNo;

    /** 限额场景编码 */
    private String limitSceneNo;

    /** 交易日期 */
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

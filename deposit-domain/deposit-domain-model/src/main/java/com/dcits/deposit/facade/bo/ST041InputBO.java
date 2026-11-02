package com.dcits.deposit.facade.bo;

/**
 * ST041 处理限额 输入。
 */
public class ST041InputBO {

    /** 限额场景编码（必填） */
    private String limitSceneNo;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}

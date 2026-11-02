package com.dcits.deposit.facade.bo;

/**
 * ST052 检查是否存在转账止付限制 输入 BO。
 *
 * <p>业务输入：账号（baseAcctNo，必填，需求输入表未指定来源实体，由调用方提供）。</p>
 */
public class ST052InputBO {

    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

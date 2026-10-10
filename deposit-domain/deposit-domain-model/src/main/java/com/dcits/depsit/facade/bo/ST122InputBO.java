package com.dcits.depsit.facade.bo;

/**
 * ST122 检查是否存在不收不付限制 的输入 BO。
 *
 * <p>入参：账号（baseAcctNo），作为【账户限制信息】查询的定位条件之一。</p>
 */
public class ST122InputBO {

    /** 账号（必填，需求正文中的 {账号}）。 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

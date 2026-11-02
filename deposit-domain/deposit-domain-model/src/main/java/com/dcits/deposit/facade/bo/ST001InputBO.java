package com.dcits.deposit.facade.bo;

/**
 * ST001 检查对手账户凭证状态 输入 BO。
 *
 * <p>以输入账号（baseAcctNo）作为查询凭证挂失登记簿（凭证挂失信息）的定位条件。
 * baseAcctNo 为必填，空值/无效账号的校验不通过未声明为业务失败，由调用方保证提供有效账号
 * （Spec 待确认事项 2）。</p>
 */
public class ST001InputBO {

    /** 账号，作为查询凭证挂失登记簿的定位条件（必填） */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}

package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.RbAcctType;

/**
 * ST034 设置免费账户标志 步骤输入
 */
public class ST034InputBO {

    /** 客户号 */
    private String clientNo;

    /** 存款账户类型 */
    private RbAcctType rbAcctType;

    /** 产品编号 */
    private String prodNo;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }
}

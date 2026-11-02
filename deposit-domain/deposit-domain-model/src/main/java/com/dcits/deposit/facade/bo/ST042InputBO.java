package com.dcits.deposit.facade.bo;

/**
 * ST042 获取累计限额 步骤输入。
 *
 * <p>字段对应正式 Spec（ST042）「输入」表（REQ-001）：baseAcctNo（账号，来源实体对公存款账户限制表
 * RB_BUS_RESTRAINTS）、clientNo（客户号，来源实体限额累计信息表 RB_LIMIT_SUM_INFO）、
 * limitSceneNo（限额场景编码，来源实体限额累计信息表 RB_LIMIT_SUM_INFO），三者均为必填
 * {@code java.lang.String}。</p>
 */
public class ST042InputBO {

    /** 账号（来源实体：对公存款账户限制表 RB_BUS_RESTRAINTS） */
    private String baseAcctNo;
    /** 客户号（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String clientNo;
    /** 限额场景编码（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String limitSceneNo;

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
}

package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.RelStatus;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbClientAcctRelationEO;

/*实体表【客户账户关联关系表(RB_CLIENT_ACCT_RELATION)】数据服务接口*/
public interface IRbClientAcctRelationBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctRelationEO中的属性字段组合 **/
    long countByEo(RbClientAcctRelationEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctRelationEO中的属性字段组合 **/
    int removeByEo(RbClientAcctRelationEO eo);

    /** remove 根据主键: 账号/卡号、客户号、账户序号 **/
    int removeByPrimaryKey(String baseAcctNo, String clientNo, String acctSeqNo);

    int create(RbClientAcctRelationEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbClientAcctRelationEO中不为空的属性写入数据库**/
    int createSelective(RbClientAcctRelationEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbClientAcctRelationEO中的属性字段组合 **/
    List<RbClientAcctRelationEO> findByEo(RbClientAcctRelationEO eo);

    /** find 根据主键: 账号/卡号、客户号、账户序号 **/
    RbClientAcctRelationEO findByPrimaryKey(String baseAcctNo, String clientNo, String acctSeqNo);

    /**  根据主键: 账号/卡号、客户号、账户序号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbClientAcctRelationEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbClientAcctRelationEO eo);

    /** modify 根据主键: 账号/卡号、客户号、账户序号 **/
    int modifyByPrimaryKey(RbClientAcctRelationEO eo);
}
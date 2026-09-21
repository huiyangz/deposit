package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctDossEO;

/*实体表【久悬户登记簿(RB_ACCT_DOSS)】数据服务接口*/
public interface IRbAcctDossBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossEO中的属性字段组合 **/
    long countByEo(RbAcctDossEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossEO中的属性字段组合 **/
    int removeByEo(RbAcctDossEO eo);

    /** remove 根据主键: 账户内部键值、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String clientNo);

    int create(RbAcctDossEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctDossEO中不为空的属性写入数据库**/
    int createSelective(RbAcctDossEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossEO中的属性字段组合 **/
    List<RbAcctDossEO> findByEo(RbAcctDossEO eo);

    /** find 根据主键: 账户内部键值、客户号 **/
    RbAcctDossEO findByPrimaryKey(Integer internalKey, String clientNo);

    /**  根据主键: 账户内部键值、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctDossEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctDossEO eo);

    /** modify 根据主键: 账户内部键值、客户号 **/
    int modifyByPrimaryKey(RbAcctDossEO eo);
}
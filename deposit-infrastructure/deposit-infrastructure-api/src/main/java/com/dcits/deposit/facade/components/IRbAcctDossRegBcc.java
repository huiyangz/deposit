package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import com.dcits.deposit.enums.DossStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.ToAcctType;
import com.dcits.deposit.enums.ToBankInd;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctDossRegEO;

/*实体表【账户状态转移登记簿(RB_ACCT_DOSS_REG)】数据服务接口*/
public interface IRbAcctDossRegBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossRegEO中的属性字段组合 **/
    long countByEo(RbAcctDossRegEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossRegEO中的属性字段组合 **/
    int removeByEo(RbAcctDossRegEO eo);

    /** remove 根据主键: 账户内部键值、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String clientNo);

    int create(RbAcctDossRegEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctDossRegEO中不为空的属性写入数据库**/
    int createSelective(RbAcctDossRegEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctDossRegEO中的属性字段组合 **/
    List<RbAcctDossRegEO> findByEo(RbAcctDossRegEO eo);

    /** find 根据主键: 账户内部键值、客户号 **/
    RbAcctDossRegEO findByPrimaryKey(Integer internalKey, String clientNo);

    /**  根据主键: 账户内部键值、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctDossRegEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctDossRegEO eo);

    /** modify 根据主键: 账户内部键值、客户号 **/
    int modifyByPrimaryKey(RbAcctDossRegEO eo);
}
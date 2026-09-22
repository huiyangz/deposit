package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTdaHistEO;

/*实体表【定期交易历史表(RB_TDA_HIST)】数据服务接口*/
public interface IRbTdaHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTdaHistEO中的属性字段组合 **/
    long countByEo(RbTdaHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTdaHistEO中的属性字段组合 **/
    int removeByEo(RbTdaHistEO eo);

    /** remove 根据主键: 序号、账户内部键值、客户号、定期账户交易日期 **/
    int removeByPrimaryKey(String seqNo, Integer internalKey, String clientNo, Date acctMovtDate);

    int create(RbTdaHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTdaHistEO中不为空的属性写入数据库**/
    int createSelective(RbTdaHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTdaHistEO中的属性字段组合 **/
    List<RbTdaHistEO> findByEo(RbTdaHistEO eo);

    /** find 根据主键: 序号、账户内部键值、客户号、定期账户交易日期 **/
    RbTdaHistEO findByPrimaryKey(String seqNo, Integer internalKey, String clientNo, Date acctMovtDate);

    /**  根据主键: 序号、账户内部键值、客户号、定期账户交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTdaHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTdaHistEO eo);

    /** modify 根据主键: 序号、账户内部键值、客户号、定期账户交易日期 **/
    int modifyByPrimaryKey(RbTdaHistEO eo);
}
package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbLimitSumHistEO;

/*实体表【限额累计流水表(RB_LIMIT_SUM_HIST)】数据服务接口*/
public interface IRbLimitSumHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitSumHistEO中的属性字段组合 **/
    long countByEo(RbLimitSumHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitSumHistEO中的属性字段组合 **/
    int removeByEo(RbLimitSumHistEO eo);

    /** remove 根据主键: 序号 **/
    int removeByPrimaryKey(String seqNo);

    int create(RbLimitSumHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbLimitSumHistEO中不为空的属性写入数据库**/
    int createSelective(RbLimitSumHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbLimitSumHistEO中的属性字段组合 **/
    List<RbLimitSumHistEO> findByEo(RbLimitSumHistEO eo);

    /** find 根据主键: 序号 **/
    RbLimitSumHistEO findByPrimaryKey(String seqNo);

    /**  根据主键: 序号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbLimitSumHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbLimitSumHistEO eo);

    /** modify 根据主键: 序号 **/
    int modifyByPrimaryKey(RbLimitSumHistEO eo);
}
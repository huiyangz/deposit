package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.UnMaintBranchRange;
import java.util.List;

import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/*实体表【限制类型表(RB_RESTRAINT_TYPE)】数据服务接口*/
public interface IRbRestraintTypeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbRestraintTypeEO中的属性字段组合 **/
    long countByEo(RbRestraintTypeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbRestraintTypeEO中的属性字段组合 **/
    int removeByEo(RbRestraintTypeEO eo);

    /** remove 根据主键: 账户限制类型 **/
    int removeByPrimaryKey(String restraintType);

    int create(RbRestraintTypeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbRestraintTypeEO中不为空的属性写入数据库**/
    int createSelective(RbRestraintTypeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbRestraintTypeEO中的属性字段组合 **/
    List<RbRestraintTypeEO> findByEo(RbRestraintTypeEO eo);

    /** find 根据主键: 账户限制类型 **/
    RbRestraintTypeEO findByPrimaryKey(String restraintType);

    /**  根据主键: 账户限制类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbRestraintTypeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbRestraintTypeEO eo);

    /** modify 根据主键: 账户限制类型 **/
    int modifyByPrimaryKey(RbRestraintTypeEO eo);

    /**根据账户限制类型查询表《限制类型表(RB_RESTRAINT_TYPE)》**/
    RbRestraintTypeEO findByRestraintType(RestraintType restraintType);
}
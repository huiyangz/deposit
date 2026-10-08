package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import java.util.List;

import com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO;

/*实体表【存款限制检查控制详情(RB_RESTRAINT_CONTROL_DETAILS)】数据服务接口*/
public interface IRbRestraintControlDetailsBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO中的属性字段组合 **/
    long countByEo(RbRestraintControlDetailsEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO中的属性字段组合 **/
    int removeByEo(RbRestraintControlDetailsEO eo);

    /** remove 根据主键: 产品编号、表达式、多交易类型、账户限制类型、是否批量、柜面标志 **/
    int removeByPrimaryKey(String prodNo, String expression, String tranTypeLink, String restraintType, String batchFlag, String counterFlag);

    int create(RbRestraintControlDetailsEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO中不为空的属性写入数据库**/
    int createSelective(RbRestraintControlDetailsEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO中的属性字段组合 **/
    List<RbRestraintControlDetailsEO> findByEo(RbRestraintControlDetailsEO eo);

    /** find 根据主键: 产品编号、表达式、多交易类型、账户限制类型、是否批量、柜面标志 **/
    RbRestraintControlDetailsEO findByPrimaryKey(String prodNo, String expression, String tranTypeLink, String restraintType, String batchFlag, String counterFlag);

    /**  根据主键: 产品编号、表达式、多交易类型、账户限制类型、是否批量、柜面标志执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbRestraintControlDetailsEO eo);

    /** modify 根据主键: 产品编号、表达式、多交易类型、账户限制类型、是否批量、柜面标志 **/
    int modifyByPrimaryKey(RbRestraintControlDetailsEO eo);
}
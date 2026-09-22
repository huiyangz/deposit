package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranType;
import java.util.List;

import com.dcits.deposit.facade.eo.RbControlTranRelationEO;

/*实体表【控制交易类型关系表(RB_CONTROL_TRAN_RELATION)】数据服务接口*/
public interface IRbControlTranRelationBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTranRelationEO中的属性字段组合 **/
    long countByEo(RbControlTranRelationEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTranRelationEO中的属性字段组合 **/
    int removeByEo(RbControlTranRelationEO eo);

    /** remove 根据主键: 渠道控制分类、交易类型、服务唯一识别号 **/
    int removeByPrimaryKey(String controlClass, String tranType, String serviceNo);

    int create(RbControlTranRelationEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbControlTranRelationEO中不为空的属性写入数据库**/
    int createSelective(RbControlTranRelationEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTranRelationEO中的属性字段组合 **/
    List<RbControlTranRelationEO> findByEo(RbControlTranRelationEO eo);

    /** find 根据主键: 渠道控制分类、交易类型、服务唯一识别号 **/
    RbControlTranRelationEO findByPrimaryKey(String controlClass, String tranType, String serviceNo);

    /**  根据主键: 渠道控制分类、交易类型、服务唯一识别号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbControlTranRelationEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbControlTranRelationEO eo);

    /** modify 根据主键: 渠道控制分类、交易类型、服务唯一识别号 **/
    int modifyByPrimaryKey(RbControlTranRelationEO eo);
}
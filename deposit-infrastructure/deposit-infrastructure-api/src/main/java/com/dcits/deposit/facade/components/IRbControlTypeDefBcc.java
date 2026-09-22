package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.IndividualFlag;
import java.util.List;

import com.dcits.deposit.facade.eo.RbControlTypeDefEO;

/*实体表【控制类型参数表(RB_CONTROL_TYPE_DEF)】数据服务接口*/
public interface IRbControlTypeDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTypeDefEO中的属性字段组合 **/
    long countByEo(RbControlTypeDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTypeDefEO中的属性字段组合 **/
    int removeByEo(RbControlTypeDefEO eo);

    /** remove 根据主键: 渠道控制类型、渠道控制分类 **/
    int removeByPrimaryKey(String controlType, String controlClass);

    int create(RbControlTypeDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbControlTypeDefEO中不为空的属性写入数据库**/
    int createSelective(RbControlTypeDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbControlTypeDefEO中的属性字段组合 **/
    List<RbControlTypeDefEO> findByEo(RbControlTypeDefEO eo);

    /** find 根据主键: 渠道控制类型、渠道控制分类 **/
    RbControlTypeDefEO findByPrimaryKey(String controlType, String controlClass);

    /**  根据主键: 渠道控制类型、渠道控制分类执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbControlTypeDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbControlTypeDefEO eo);

    /** modify 根据主键: 渠道控制类型、渠道控制分类 **/
    int modifyByPrimaryKey(RbControlTypeDefEO eo);
}
package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusPasswordEO;

/*实体表【对公账户密码表(RB_BUS_PASSWORD)】数据服务接口*/
public interface IRbBusPasswordBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusPasswordEO中的属性字段组合 **/
    long countByEo(RbBusPasswordEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusPasswordEO中的属性字段组合 **/
    int removeByEo(RbBusPasswordEO eo);

    /** remove 根据主键: 账户内部键值、密码类型、密码键值 **/
    int removeByPrimaryKey(Integer internalKey, String pwdType, String pwdKey);

    int create(RbBusPasswordEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusPasswordEO中不为空的属性写入数据库**/
    int createSelective(RbBusPasswordEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusPasswordEO中的属性字段组合 **/
    List<RbBusPasswordEO> findByEo(RbBusPasswordEO eo);

    /** find 根据主键: 账户内部键值、密码类型、密码键值 **/
    RbBusPasswordEO findByPrimaryKey(Integer internalKey, String pwdType, String pwdKey);

    /**  根据主键: 账户内部键值、密码类型、密码键值执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusPasswordEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusPasswordEO eo);

    /** modify 根据主键: 账户内部键值、密码类型、密码键值 **/
    int modifyByPrimaryKey(RbBusPasswordEO eo);
}
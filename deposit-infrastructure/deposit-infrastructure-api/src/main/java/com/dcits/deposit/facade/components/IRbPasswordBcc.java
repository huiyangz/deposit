package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbPasswordEO;

/*实体表【帐户密码表(RB_PASSWORD)】数据服务接口*/
public interface IRbPasswordBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbPasswordEO中的属性字段组合 **/
    long countByEo(RbPasswordEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbPasswordEO中的属性字段组合 **/
    int removeByEo(RbPasswordEO eo);

    /** remove 根据主键: 密码键值、密码类型、客户号 **/
    int removeByPrimaryKey(String pwdKey, String pwdType, String clientNo);

    int create(RbPasswordEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbPasswordEO中不为空的属性写入数据库**/
    int createSelective(RbPasswordEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbPasswordEO中的属性字段组合 **/
    List<RbPasswordEO> findByEo(RbPasswordEO eo);

    /** find 根据主键: 密码键值、密码类型、客户号 **/
    RbPasswordEO findByPrimaryKey(String pwdKey, String pwdType, String clientNo);

    /**  根据主键: 密码键值、密码类型、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbPasswordEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbPasswordEO eo);

    /** modify 根据主键: 密码键值、密码类型、客户号 **/
    int modifyByPrimaryKey(RbPasswordEO eo);
}
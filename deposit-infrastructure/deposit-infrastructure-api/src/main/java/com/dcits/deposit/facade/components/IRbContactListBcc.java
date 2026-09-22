package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ContactClass;
import com.dcits.deposit.enums.ContactType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LinkmanType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbContactListEO;

/*实体表【账户联系人信息表(RB_CONTACT_LIST)】数据服务接口*/
public interface IRbContactListBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbContactListEO中的属性字段组合 **/
    long countByEo(RbContactListEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbContactListEO中的属性字段组合 **/
    int removeByEo(RbContactListEO eo);

    /** remove 根据主键: 账户内部键值、账户联系人类型、联系人电话1、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String linkmanType, String phoneNo1, String clientNo);

    int create(RbContactListEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbContactListEO中不为空的属性写入数据库**/
    int createSelective(RbContactListEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbContactListEO中的属性字段组合 **/
    List<RbContactListEO> findByEo(RbContactListEO eo);

    /** find 根据主键: 账户内部键值、账户联系人类型、联系人电话1、客户号 **/
    RbContactListEO findByPrimaryKey(Integer internalKey, String linkmanType, String phoneNo1, String clientNo);

    /**  根据主键: 账户内部键值、账户联系人类型、联系人电话1、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbContactListEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbContactListEO eo);

    /** modify 根据主键: 账户内部键值、账户联系人类型、联系人电话1、客户号 **/
    int modifyByPrimaryKey(RbContactListEO eo);
}
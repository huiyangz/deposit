package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import java.util.List;

import com.dcits.deposit.facade.eo.MbEventAttrEO;

/*实体表【事件参数定义表(MB_EVENT_ATTR)】数据服务接口*/
public interface IMbEventAttrBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbEventAttrEO中的属性字段组合 **/
    long countByEo(MbEventAttrEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbEventAttrEO中的属性字段组合 **/
    int removeByEo(MbEventAttrEO eo);

    /** remove 根据主键: 事件类型、序号、法人 **/
    int removeByPrimaryKey(String eventType, String seqNo, String company);

    int create(MbEventAttrEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbEventAttrEO中不为空的属性写入数据库**/
    int createSelective(MbEventAttrEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbEventAttrEO中的属性字段组合 **/
    List<MbEventAttrEO> findByEo(MbEventAttrEO eo);

    /** find 根据主键: 事件类型、序号、法人 **/
    MbEventAttrEO findByPrimaryKey(String eventType, String seqNo, String company);

    /**  根据主键: 事件类型、序号、法人执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbEventAttrEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbEventAttrEO eo);

    /** modify 根据主键: 事件类型、序号、法人 **/
    int modifyByPrimaryKey(MbEventAttrEO eo);
}
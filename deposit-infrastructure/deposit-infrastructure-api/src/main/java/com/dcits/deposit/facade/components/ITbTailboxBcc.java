package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.TailboxProperty;
import com.dcits.deposit.enums.TailboxStatus;
import com.dcits.deposit.enums.TailboxSubType;
import com.dcits.deposit.enums.TailboxType;
import com.dcits.deposit.enums.TellerBindType;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbTailboxEO;

/*实体表【尾箱基本信息表(TB_TAILBOX)】数据服务接口*/
public interface ITbTailboxBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    long countByEo(TbTailboxEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    int removeByEo(TbTailboxEO eo);

    /** remove 根据主键: 尾箱编号 **/
    int removeByPrimaryKey(String tailboxId);

    int create(TbTailboxEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbTailboxEO中不为空的属性写入数据库**/
    int createSelective(TbTailboxEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    List<TbTailboxEO> findByEo(TbTailboxEO eo);

    /** find 根据主键: 尾箱编号 **/
    TbTailboxEO findByPrimaryKey(String tailboxId);

    /**  根据主键: 尾箱编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbTailboxEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbTailboxEO eo);

    /** modify 根据主键: 尾箱编号 **/
    int modifyByPrimaryKey(TbTailboxEO eo);
}
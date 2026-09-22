package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAutoTranInfoEO;

/*实体表【定期账户到期自动划转登记簿(RB_AUTO_TRAN_INFO)】数据服务接口*/
public interface IRbAutoTranInfoBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAutoTranInfoEO中的属性字段组合 **/
    long countByEo(RbAutoTranInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAutoTranInfoEO中的属性字段组合 **/
    int removeByEo(RbAutoTranInfoEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbAutoTranInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAutoTranInfoEO中不为空的属性写入数据库**/
    int createSelective(RbAutoTranInfoEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAutoTranInfoEO中的属性字段组合 **/
    List<RbAutoTranInfoEO> findByEo(RbAutoTranInfoEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbAutoTranInfoEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAutoTranInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAutoTranInfoEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbAutoTranInfoEO eo);
}
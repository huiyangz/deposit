package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TranStatus;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.IaBatchOpenDetailEO;

/*实体表【内部账户批量开立详细信息表(IA_BATCH_OPEN_DETAIL)】数据服务接口*/
public interface IIaBatchOpenDetailBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.IaBatchOpenDetailEO中的属性字段组合 **/
    long countByEo(IaBatchOpenDetailEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.IaBatchOpenDetailEO中的属性字段组合 **/
    int removeByEo(IaBatchOpenDetailEO eo);

    /** remove 根据主键: 批次号、批量明细序号 **/
    int removeByPrimaryKey(String batchNo, String batchSeqNo);

    int create(IaBatchOpenDetailEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.IaBatchOpenDetailEO中不为空的属性写入数据库**/
    int createSelective(IaBatchOpenDetailEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.IaBatchOpenDetailEO中的属性字段组合 **/
    List<IaBatchOpenDetailEO> findByEo(IaBatchOpenDetailEO eo);

    /** find 根据主键: 批次号、批量明细序号 **/
    IaBatchOpenDetailEO findByPrimaryKey(String batchNo, String batchSeqNo);

    /**  根据主键: 批次号、批量明细序号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.IaBatchOpenDetailEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(IaBatchOpenDetailEO eo);

    /** modify 根据主键: 批次号、批量明细序号 **/
    int modifyByPrimaryKey(IaBatchOpenDetailEO eo);
}
package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AvailbalCalcType;
import com.dcits.deposit.enums.BalanceFlag;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranClass;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UpdTailboxFlag;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTranDefEO;

/*实体表【交易类型定义表(RB_TRAN_DEF)】数据服务接口*/
public interface IRbTranDefBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranDefEO中的属性字段组合 **/
    long countByEo(RbTranDefEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranDefEO中的属性字段组合 **/
    int removeByEo(RbTranDefEO eo);

    /** remove 根据主键: 交易类型 **/
    int removeByPrimaryKey(String tranType);

    int create(RbTranDefEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTranDefEO中不为空的属性写入数据库**/
    int createSelective(RbTranDefEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranDefEO中的属性字段组合 **/
    List<RbTranDefEO> findByEo(RbTranDefEO eo);

    /** find 根据主键: 交易类型 **/
    RbTranDefEO findByPrimaryKey(String tranType);

    /**  根据主键: 交易类型执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTranDefEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTranDefEO eo);

    /** modify 根据主键: 交易类型 **/
    int modifyByPrimaryKey(RbTranDefEO eo);

    /**根据交易类型查询表《交易类型定义表(RB_TRAN_DEF)》**/
    RbTranDefEO findByTranType(TranType tranType);
}
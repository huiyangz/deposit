package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.NearPeriodType;
import com.dcits.deposit.enums.YearBasis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbIntLayerRateEO;

/*实体表【分户分段信息利率表(RB_INT_LAYER_RATE)】数据服务接口*/
public interface IRbIntLayerRateBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbIntLayerRateEO中的属性字段组合 **/
    long countByEo(RbIntLayerRateEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbIntLayerRateEO中的属性字段组合 **/
    int removeByEo(RbIntLayerRateEO eo);

    /** remove 根据主键: 费率编号、客户号 **/
    int removeByPrimaryKey(String irlSeqNo, String clientNo);

    int create(RbIntLayerRateEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbIntLayerRateEO中不为空的属性写入数据库**/
    int createSelective(RbIntLayerRateEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbIntLayerRateEO中的属性字段组合 **/
    List<RbIntLayerRateEO> findByEo(RbIntLayerRateEO eo);

    /** find 根据主键: 费率编号、客户号 **/
    RbIntLayerRateEO findByPrimaryKey(String irlSeqNo, String clientNo);

    /**  根据主键: 费率编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbIntLayerRateEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbIntLayerRateEO eo);

    /** modify 根据主键: 费率编号、客户号 **/
    int modifyByPrimaryKey(RbIntLayerRateEO eo);
}
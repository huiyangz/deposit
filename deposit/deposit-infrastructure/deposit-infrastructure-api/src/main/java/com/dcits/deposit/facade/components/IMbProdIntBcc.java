package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.GearDaysInd;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.MbProdIntEO;

/*实体表【产品利率信息表(MB_PROD_INT)】数据服务接口*/
public interface IMbProdIntBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdIntEO中的属性字段组合 **/
    long countByEo(MbProdIntEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdIntEO中的属性字段组合 **/
    int removeByEo(MbProdIntEO eo);

    /** remove 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    int removeByPrimaryKey(String prodNo, String intType, String eventType, String intClass);

    int create(MbProdIntEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.MbProdIntEO中不为空的属性写入数据库**/
    int createSelective(MbProdIntEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.MbProdIntEO中的属性字段组合 **/
    List<MbProdIntEO> findByEo(MbProdIntEO eo);

    /** find 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    MbProdIntEO findByPrimaryKey(String prodNo, String intType, String eventType, String intClass);

    /**  根据主键: 产品编号、利率类型、事件类型、利息分类执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.MbProdIntEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbProdIntEO eo);

    /** modify 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    int modifyByPrimaryKey(MbProdIntEO eo);
}
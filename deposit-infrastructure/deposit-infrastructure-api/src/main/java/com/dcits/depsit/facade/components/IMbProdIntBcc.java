package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.DaysGearType;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.EffectDateCalcMethod;
import com.dcits.depsit.enums.GearAmtMethod;
import com.dcits.depsit.enums.GearDaysInd;
import com.dcits.depsit.enums.GroupRuleType;
import com.dcits.depsit.enums.IntCalcAmtType;
import com.dcits.depsit.enums.IntCalcMethod;
import com.dcits.depsit.enums.IntChangeType;
import com.dcits.depsit.enums.IntClass;
import com.dcits.depsit.enums.IntMatchRule;
import com.dcits.depsit.enums.IntRecalcMethod;
import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.enums.MonthBasisType;
import com.dcits.depsit.enums.RateLayerRule;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherStatus;
import com.dcits.depsit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.MbProdIntEO;

/*实体表【产品利率信息表(MB_PROD_INT)】数据服务接口*/
public interface IMbProdIntBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.MbProdIntEO中的属性字段组合 **/
    long countByEo(MbProdIntEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.MbProdIntEO中的属性字段组合 **/
    int removeByEo(MbProdIntEO eo);

    /** remove 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    int removeByPrimaryKey(String prodNo, String intType, String eventType, String intClass);

    int create(MbProdIntEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.MbProdIntEO中不为空的属性写入数据库**/
    int createSelective(MbProdIntEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.MbProdIntEO中的属性字段组合 **/
    List<MbProdIntEO> findByEo(MbProdIntEO eo);

    /** find 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    MbProdIntEO findByPrimaryKey(String prodNo, String intType, String eventType, String intClass);

    /**  根据主键: 产品编号、利率类型、事件类型、利息分类执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.MbProdIntEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(MbProdIntEO eo);

    /** modify 根据主键: 产品编号、利率类型、事件类型、利息分类 **/
    int modifyByPrimaryKey(MbProdIntEO eo);
}
package com.dcits.depsit.facade.components;

import java.math.BigDecimal;
import java.util.List;

import com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO;

/*实体表【法人透支白名单参数表(RB_OD_WHITE_LIMIT_INFO)】数据服务接口*/
public interface IRbOdWhiteLimitInfoBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO中的属性字段组合 **/
    long countByEo(RbOdWhiteLimitInfoEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO中的属性字段组合 **/
    int removeByEo(RbOdWhiteLimitInfoEO eo);

    /** remove 根据主键: 单笔透支检查金额、交易时间戳、法人、同一支付对象当日累计透支金额、凭证行外调拨标志、靠档计息跨月跨季标志 **/
    int removeByPrimaryKey(BigDecimal odPtAmt, String tranTimestamp, String company, BigDecimal sameObjectPdOdCumulative, String vbsflag, String isCrossFlag);

    int create(RbOdWhiteLimitInfoEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO中不为空的属性写入数据库**/
    int createSelective(RbOdWhiteLimitInfoEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO中的属性字段组合 **/
    List<RbOdWhiteLimitInfoEO> findByEo(RbOdWhiteLimitInfoEO eo);

    /** find 根据主键: 单笔透支检查金额、交易时间戳、法人、同一支付对象当日累计透支金额、凭证行外调拨标志、靠档计息跨月跨季标志 **/
    RbOdWhiteLimitInfoEO findByPrimaryKey(BigDecimal odPtAmt, String tranTimestamp, String company, BigDecimal sameObjectPdOdCumulative, String vbsflag, String isCrossFlag);

    /**  根据主键: 单笔透支检查金额、交易时间戳、法人、同一支付对象当日累计透支金额、凭证行外调拨标志、靠档计息跨月跨季标志执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbOdWhiteLimitInfoEO eo);

    /** modify 根据主键: 单笔透支检查金额、交易时间戳、法人、同一支付对象当日累计透支金额、凭证行外调拨标志、靠档计息跨月跨季标志 **/
    int modifyByPrimaryKey(RbOdWhiteLimitInfoEO eo);
}
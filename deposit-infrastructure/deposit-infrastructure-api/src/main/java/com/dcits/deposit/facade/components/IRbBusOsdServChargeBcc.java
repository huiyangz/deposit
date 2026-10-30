package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ChargeWay;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DiscType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.OsdStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusOsdServChargeEO;

/*实体表【对公存款应收费用表(RB_BUS_OSD_SERV_CHARGE)】数据服务接口*/
public interface IRbBusOsdServChargeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOsdServChargeEO中的属性字段组合 **/
    long countByEo(RbBusOsdServChargeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOsdServChargeEO中的属性字段组合 **/
    int removeByEo(RbBusOsdServChargeEO eo);

    /** remove 根据主键: 应收费序号、交易日期 **/
    int removeByPrimaryKey(String osdSeqNo, Date tranDate);

    int create(RbBusOsdServChargeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusOsdServChargeEO中不为空的属性写入数据库**/
    int createSelective(RbBusOsdServChargeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOsdServChargeEO中的属性字段组合 **/
    List<RbBusOsdServChargeEO> findByEo(RbBusOsdServChargeEO eo);

    /** find 根据主键: 应收费序号、交易日期 **/
    RbBusOsdServChargeEO findByPrimaryKey(String osdSeqNo, Date tranDate);

    /**  根据主键: 应收费序号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusOsdServChargeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusOsdServChargeEO eo);

    /** modify 根据主键: 应收费序号、交易日期 **/
    int modifyByPrimaryKey(RbBusOsdServChargeEO eo);
}
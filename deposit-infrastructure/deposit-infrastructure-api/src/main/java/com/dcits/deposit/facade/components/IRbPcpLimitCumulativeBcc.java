package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.LimitType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO;

/*实体表【子账户限额累计表(RB_PCP_LIMIT_CUMULATIVE)】数据服务接口*/
public interface IRbPcpLimitCumulativeBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO中的属性字段组合 **/
    long countByEo(RbPcpLimitCumulativeEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO中的属性字段组合 **/
    int removeByEo(RbPcpLimitCumulativeEO eo);

    /** remove 根据主键: 账户内部键值、限额类型、协议编号、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String limitType, String agreementId, String clientNo);

    int create(RbPcpLimitCumulativeEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO中不为空的属性写入数据库**/
    int createSelective(RbPcpLimitCumulativeEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO中的属性字段组合 **/
    List<RbPcpLimitCumulativeEO> findByEo(RbPcpLimitCumulativeEO eo);

    /** find 根据主键: 账户内部键值、限额类型、协议编号、客户号 **/
    RbPcpLimitCumulativeEO findByPrimaryKey(Integer internalKey, String limitType, String agreementId, String clientNo);

    /**  根据主键: 账户内部键值、限额类型、协议编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbPcpLimitCumulativeEO eo);

    /** modify 根据主键: 账户内部键值、限额类型、协议编号、客户号 **/
    int modifyByPrimaryKey(RbPcpLimitCumulativeEO eo);
}
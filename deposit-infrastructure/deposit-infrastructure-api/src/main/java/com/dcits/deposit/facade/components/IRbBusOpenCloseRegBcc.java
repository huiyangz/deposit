package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.InformBankFlag;
import com.dcits.deposit.enums.IsSelf;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SucFlag;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO;

/*实体表【对公存款账户开立注销登记簿(RB_BUS_OPEN_CLOSE_REG)】数据服务接口*/
public interface IRbBusOpenCloseRegBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO中的属性字段组合 **/
    long countByEo(RbBusOpenCloseRegEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO中的属性字段组合 **/
    int removeByEo(RbBusOpenCloseRegEO eo);

    /** remove 根据主键: 序号 **/
    int removeByPrimaryKey(String seqNo);

    int create(RbBusOpenCloseRegEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO中不为空的属性写入数据库**/
    int createSelective(RbBusOpenCloseRegEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO中的属性字段组合 **/
    List<RbBusOpenCloseRegEO> findByEo(RbBusOpenCloseRegEO eo);

    /** find 根据主键: 序号 **/
    RbBusOpenCloseRegEO findByPrimaryKey(String seqNo);

    /**  根据主键: 序号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusOpenCloseRegEO eo);

    /** modify 根据主键: 序号 **/
    int modifyByPrimaryKey(RbBusOpenCloseRegEO eo);
}
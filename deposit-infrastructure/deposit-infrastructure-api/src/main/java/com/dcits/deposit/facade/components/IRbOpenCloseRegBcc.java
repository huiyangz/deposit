package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SourceModule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbOpenCloseRegEO;

/*实体表【账户/卡开立注销登记簿(RB_OPEN_CLOSE_REG)】数据服务接口*/
public interface IRbOpenCloseRegBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbOpenCloseRegEO中的属性字段组合 **/
    long countByEo(RbOpenCloseRegEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbOpenCloseRegEO中的属性字段组合 **/
    int removeByEo(RbOpenCloseRegEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbOpenCloseRegEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbOpenCloseRegEO中不为空的属性写入数据库**/
    int createSelective(RbOpenCloseRegEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbOpenCloseRegEO中的属性字段组合 **/
    List<RbOpenCloseRegEO> findByEo(RbOpenCloseRegEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbOpenCloseRegEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbOpenCloseRegEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbOpenCloseRegEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbOpenCloseRegEO eo);
}
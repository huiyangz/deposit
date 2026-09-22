package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.CentDealType;
import com.dcits.deposit.enums.CloseAcctInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WipeAccount;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbCentRegEO;

/*实体表【分位金额处理登记簿(RB_CENT_REG)】数据服务接口*/
public interface IRbCentRegBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbCentRegEO中的属性字段组合 **/
    long countByEo(RbCentRegEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbCentRegEO中的属性字段组合 **/
    int removeByEo(RbCentRegEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbCentRegEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbCentRegEO中不为空的属性写入数据库**/
    int createSelective(RbCentRegEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbCentRegEO中的属性字段组合 **/
    List<RbCentRegEO> findByEo(RbCentRegEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbCentRegEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbCentRegEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbCentRegEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbCentRegEO eo);
}
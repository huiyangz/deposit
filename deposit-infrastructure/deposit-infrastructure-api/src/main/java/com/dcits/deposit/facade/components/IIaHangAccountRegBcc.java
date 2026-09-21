package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.HangDealType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.IaHangAccountRegEO;

/*实体表【挂销账挂账登记簿(IA_HANG_ACCOUNT_REG)】数据服务接口*/
public interface IIaHangAccountRegBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.IaHangAccountRegEO中的属性字段组合 **/
    long countByEo(IaHangAccountRegEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.IaHangAccountRegEO中的属性字段组合 **/
    int removeByEo(IaHangAccountRegEO eo);

    /** remove 根据主键: 挂账编号、追加挂账编号、客户号 **/
    int removeByPrimaryKey(String hangSeqNo, String subHangSeqNo, String clientNo);

    int create(IaHangAccountRegEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.IaHangAccountRegEO中不为空的属性写入数据库**/
    int createSelective(IaHangAccountRegEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.IaHangAccountRegEO中的属性字段组合 **/
    List<IaHangAccountRegEO> findByEo(IaHangAccountRegEO eo);

    /** find 根据主键: 挂账编号、追加挂账编号、客户号 **/
    IaHangAccountRegEO findByPrimaryKey(String hangSeqNo, String subHangSeqNo, String clientNo);

    /**  根据主键: 挂账编号、追加挂账编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.IaHangAccountRegEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(IaHangAccountRegEO eo);

    /** modify 根据主键: 挂账编号、追加挂账编号、客户号 **/
    int modifyByPrimaryKey(IaHangAccountRegEO eo);
}
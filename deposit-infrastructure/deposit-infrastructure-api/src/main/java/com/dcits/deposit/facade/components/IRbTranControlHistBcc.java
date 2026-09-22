package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OnlineTranStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTranControlHistEO;

/*实体表【交易流程控制表(RB_TRAN_CONTROL_HIST)】数据服务接口*/
public interface IRbTranControlHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranControlHistEO中的属性字段组合 **/
    long countByEo(RbTranControlHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranControlHistEO中的属性字段组合 **/
    int removeByEo(RbTranControlHistEO eo);

    /** remove 根据主键: 渠道流水号、渠道日期、渠道类型、子流水号、交易日期 **/
    int removeByPrimaryKey(String channelSeqNo, Date channelDate, String sourceType, String subSeqNo, Date tranDate);

    int create(RbTranControlHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTranControlHistEO中不为空的属性写入数据库**/
    int createSelective(RbTranControlHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranControlHistEO中的属性字段组合 **/
    List<RbTranControlHistEO> findByEo(RbTranControlHistEO eo);

    /** find 根据主键: 渠道流水号、渠道日期、渠道类型、子流水号、交易日期 **/
    RbTranControlHistEO findByPrimaryKey(String channelSeqNo, Date channelDate, String sourceType, String subSeqNo, Date tranDate);

    /**  根据主键: 渠道流水号、渠道日期、渠道类型、子流水号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTranControlHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTranControlHistEO eo);

    /** modify 根据主键: 渠道流水号、渠道日期、渠道类型、子流水号、交易日期 **/
    int modifyByPrimaryKey(RbTranControlHistEO eo);
}
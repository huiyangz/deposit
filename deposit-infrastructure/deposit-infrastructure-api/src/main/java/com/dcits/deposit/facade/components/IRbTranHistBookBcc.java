package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTranHistBookEO;

/*实体表【卡配对账簿交易流水专用表(RB_TRAN_HIST_BOOK)】数据服务接口*/
public interface IRbTranHistBookBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistBookEO中的属性字段组合 **/
    long countByEo(RbTranHistBookEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistBookEO中的属性字段组合 **/
    int removeByEo(RbTranHistBookEO eo);

    /** remove 根据主键: 序号、客户号 **/
    int removeByPrimaryKey(String seqNo, String clientNo);

    int create(RbTranHistBookEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTranHistBookEO中不为空的属性写入数据库**/
    int createSelective(RbTranHistBookEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistBookEO中的属性字段组合 **/
    List<RbTranHistBookEO> findByEo(RbTranHistBookEO eo);

    /** find 根据主键: 序号、客户号 **/
    RbTranHistBookEO findByPrimaryKey(String seqNo, String clientNo);

    /**  根据主键: 序号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTranHistBookEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTranHistBookEO eo);

    /** modify 根据主键: 序号、客户号 **/
    int modifyByPrimaryKey(RbTranHistBookEO eo);
}
package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.TailboxProperty;
import com.dcits.deposit.enums.TailboxStatus;
import com.dcits.deposit.enums.TailboxSubType;
import com.dcits.deposit.enums.TailboxType;
import com.dcits.deposit.enums.TellerBindType;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbTailboxEO;

/*实体表【尾箱基本信息表(TB_TAILBOX)】数据服务接口*/
public interface ITbTailboxBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    long countByEo(TbTailboxEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    int removeByEo(TbTailboxEO eo);

    /** remove 根据主键: 现金碰库时间戳、日终现金碰库标志、尾箱编号、上一柜员号、尾箱细类、归属机构号、凭证碰库时间戳、交易时间戳、创建日期、法人、尾箱分配柜员号、尾箱绑定关系类型、最后修改日期、日始凭证碰库标志、日终凭证碰库标志、尾箱状态、交易柜员号、日间凭证碰库标志、日间现金碰库标志、创建时间戳、尾箱类型、更新日期、日始现金碰库标志、尾箱属性 **/
    int removeByPrimaryKey(String cashEqualTimestamp, String eodCashEqual, String tailboxId, String lastUserId, String tailboxSubType, String branch, String voucherEqualTimestamp, String tranTimestamp, Date createDate, String company, String assignUserId, String tellerBindType, Date lastChangeDate, String sodVoucherEqual, String eodVoucherEqual, String tailboxStatus, String userId, String midVoucherEqual, String midCashEqual, String createTimestamp, String tailboxType, Date updateDate, String sodCashEqual, String tailboxProperty);

    int create(TbTailboxEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbTailboxEO中不为空的属性写入数据库**/
    int createSelective(TbTailboxEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbTailboxEO中的属性字段组合 **/
    List<TbTailboxEO> findByEo(TbTailboxEO eo);

    /** find 根据主键: 现金碰库时间戳、日终现金碰库标志、尾箱编号、上一柜员号、尾箱细类、归属机构号、凭证碰库时间戳、交易时间戳、创建日期、法人、尾箱分配柜员号、尾箱绑定关系类型、最后修改日期、日始凭证碰库标志、日终凭证碰库标志、尾箱状态、交易柜员号、日间凭证碰库标志、日间现金碰库标志、创建时间戳、尾箱类型、更新日期、日始现金碰库标志、尾箱属性 **/
    TbTailboxEO findByPrimaryKey(String cashEqualTimestamp, String eodCashEqual, String tailboxId, String lastUserId, String tailboxSubType, String branch, String voucherEqualTimestamp, String tranTimestamp, Date createDate, String company, String assignUserId, String tellerBindType, Date lastChangeDate, String sodVoucherEqual, String eodVoucherEqual, String tailboxStatus, String userId, String midVoucherEqual, String midCashEqual, String createTimestamp, String tailboxType, Date updateDate, String sodCashEqual, String tailboxProperty);

    /**  根据主键: 现金碰库时间戳、日终现金碰库标志、尾箱编号、上一柜员号、尾箱细类、归属机构号、凭证碰库时间戳、交易时间戳、创建日期、法人、尾箱分配柜员号、尾箱绑定关系类型、最后修改日期、日始凭证碰库标志、日终凭证碰库标志、尾箱状态、交易柜员号、日间凭证碰库标志、日间现金碰库标志、创建时间戳、尾箱类型、更新日期、日始现金碰库标志、尾箱属性执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbTailboxEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbTailboxEO eo);

    /** modify 根据主键: 现金碰库时间戳、日终现金碰库标志、尾箱编号、上一柜员号、尾箱细类、归属机构号、凭证碰库时间戳、交易时间戳、创建日期、法人、尾箱分配柜员号、尾箱绑定关系类型、最后修改日期、日始凭证碰库标志、日终凭证碰库标志、尾箱状态、交易柜员号、日间凭证碰库标志、日间现金碰库标志、创建时间戳、尾箱类型、更新日期、日始现金碰库标志、尾箱属性 **/
    int modifyByPrimaryKey(TbTailboxEO eo);
}
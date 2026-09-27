package com.dcits.deposit.repo;

import com.dcits.deposit.entity.TbTailbox;
import com.dcits.deposit.entity.TbTailboxExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTailboxMapper {
    long countByExample(TbTailboxExample example);

    int deleteByExample(TbTailboxExample example);

    int deleteByPrimaryKey(@Param("cashEqualTimestamp") String cashEqualTimestamp, @Param("eodCashEqual") String eodCashEqual, @Param("tailboxId") String tailboxId, @Param("lastUserId") String lastUserId, @Param("tailboxSubType") String tailboxSubType, @Param("branch") String branch, @Param("voucherEqualTimestamp") String voucherEqualTimestamp, @Param("tranTimestamp") String tranTimestamp, @Param("createDate") Date createDate, @Param("company") String company, @Param("assignUserId") String assignUserId, @Param("tellerBindType") String tellerBindType, @Param("lastChangeDate") Date lastChangeDate, @Param("sodVoucherEqual") String sodVoucherEqual, @Param("eodVoucherEqual") String eodVoucherEqual, @Param("tailboxStatus") String tailboxStatus, @Param("userId") String userId, @Param("midVoucherEqual") String midVoucherEqual, @Param("midCashEqual") String midCashEqual, @Param("createTimestamp") String createTimestamp, @Param("tailboxType") String tailboxType, @Param("updateDate") Date updateDate, @Param("sodCashEqual") String sodCashEqual, @Param("tailboxProperty") String tailboxProperty);

    int insert(TbTailbox row);

    int insertSelective(TbTailbox row);

    List<TbTailbox> selectByExample(TbTailboxExample example);

    TbTailbox selectByPrimaryKey(@Param("cashEqualTimestamp") String cashEqualTimestamp, @Param("eodCashEqual") String eodCashEqual, @Param("tailboxId") String tailboxId, @Param("lastUserId") String lastUserId, @Param("tailboxSubType") String tailboxSubType, @Param("branch") String branch, @Param("voucherEqualTimestamp") String voucherEqualTimestamp, @Param("tranTimestamp") String tranTimestamp, @Param("createDate") Date createDate, @Param("company") String company, @Param("assignUserId") String assignUserId, @Param("tellerBindType") String tellerBindType, @Param("lastChangeDate") Date lastChangeDate, @Param("sodVoucherEqual") String sodVoucherEqual, @Param("eodVoucherEqual") String eodVoucherEqual, @Param("tailboxStatus") String tailboxStatus, @Param("userId") String userId, @Param("midVoucherEqual") String midVoucherEqual, @Param("midCashEqual") String midCashEqual, @Param("createTimestamp") String createTimestamp, @Param("tailboxType") String tailboxType, @Param("updateDate") Date updateDate, @Param("sodCashEqual") String sodCashEqual, @Param("tailboxProperty") String tailboxProperty);

    int updateByExampleSelective(@Param("row") TbTailbox row, @Param("example") TbTailboxExample example);

    int updateByExample(@Param("row") TbTailbox row, @Param("example") TbTailboxExample example);

    int updateByPrimaryKeySelective(TbTailbox row);

    int updateByPrimaryKey(TbTailbox row);
}
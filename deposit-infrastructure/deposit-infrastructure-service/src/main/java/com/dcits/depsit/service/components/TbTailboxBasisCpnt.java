package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.TailboxProperty;
import com.dcits.depsit.enums.TailboxStatus;
import com.dcits.depsit.enums.TailboxSubType;
import com.dcits.depsit.enums.TailboxType;
import com.dcits.depsit.enums.TellerBindType;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.TbTailbox;
import com.dcits.depsit.entity.TbTailboxExample;
import com.dcits.depsit.facade.components.ITbTailboxBcc;
import com.dcits.depsit.facade.eo.TbTailboxEO;
import com.dcits.depsit.repo.TbTailboxMapper;
import com.dcits.depsit.service.utils.TbTailboxValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbTailboxBasisCpnt implements ITbTailboxBcc {
    @Autowired
    TbTailboxMapper tbTailboxMapper;

    @Override
    public long countByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        return tbTailboxMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        return tbTailboxMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String cashEqualTimestamp, String eodCashEqual, String tailboxId, String lastUserId, String tailboxSubType, String branch, String voucherEqualTimestamp, String tranTimestamp, Date createDate, String company, String assignUserId, String tellerBindType, Date lastChangeDate, String sodVoucherEqual, String eodVoucherEqual, String tailboxStatus, String userId, String midVoucherEqual, String midCashEqual, String createTimestamp, String tailboxType, Date updateDate, String sodCashEqual, String tailboxProperty) {
        return tbTailboxMapper.deleteByPrimaryKey(cashEqualTimestamp, eodCashEqual, tailboxId, lastUserId, tailboxSubType, branch, voucherEqualTimestamp, tranTimestamp, createDate, company, assignUserId, tellerBindType, lastChangeDate, sodVoucherEqual, eodVoucherEqual, tailboxStatus, userId, midVoucherEqual, midCashEqual, createTimestamp, tailboxType, updateDate, sodCashEqual, tailboxProperty);
    }

    @Override
    public int create(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.insert(row);
    }

    @Override
    public int createSelective(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.insertSelective(row);
    }

    @Override
    public List<TbTailboxEO> findByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        List<TbTailboxEO> result = new ArrayList<>();
        List<TbTailbox> dbResult = tbTailboxMapper.selectByExample(example);
        for (TbTailbox item : dbResult) {
            result.add(TbTailboxValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbTailboxEO findByPrimaryKey(String cashEqualTimestamp, String eodCashEqual, String tailboxId, String lastUserId, String tailboxSubType, String branch, String voucherEqualTimestamp, String tranTimestamp, Date createDate, String company, String assignUserId, String tellerBindType, Date lastChangeDate, String sodVoucherEqual, String eodVoucherEqual, String tailboxStatus, String userId, String midVoucherEqual, String midCashEqual, String createTimestamp, String tailboxType, Date updateDate, String sodCashEqual, String tailboxProperty) {
        return TbTailboxValueUtil.entityToEo(tbTailboxMapper.selectByPrimaryKey(cashEqualTimestamp, eodCashEqual, tailboxId, lastUserId, tailboxSubType, branch, voucherEqualTimestamp, tranTimestamp, createDate, company, assignUserId, tellerBindType, lastChangeDate, sodVoucherEqual, eodVoucherEqual, tailboxStatus, userId, midVoucherEqual, midCashEqual, createTimestamp, tailboxType, updateDate, sodCashEqual, tailboxProperty));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.updateByPrimaryKey(row);
    }
}
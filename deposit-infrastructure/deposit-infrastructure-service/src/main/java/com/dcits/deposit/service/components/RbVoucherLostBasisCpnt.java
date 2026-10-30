package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.LostType;
import com.dcits.deposit.enums.RelieveLossType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.VoucherLostStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbVoucherLost;
import com.dcits.deposit.entity.RbVoucherLostExample;
import com.dcits.deposit.facade.components.IRbVoucherLostBcc;
import com.dcits.deposit.facade.eo.RbVoucherLostEO;
import com.dcits.deposit.repo.RbVoucherLostMapper;
import com.dcits.deposit.service.utils.RbVoucherLostValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbVoucherLostBasisCpnt implements IRbVoucherLostBcc {
    @Autowired
    RbVoucherLostMapper rbVoucherLostMapper;

    @Override
    public long countByEo(RbVoucherLostEO eo) {
        RbVoucherLostExample example = RbVoucherLostValueUtil.eoToEntityExample(eo);
        return rbVoucherLostMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbVoucherLostEO eo) {
        RbVoucherLostExample example = RbVoucherLostValueUtil.eoToEntityExample(eo);
        return rbVoucherLostMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String lostKey, String lostNo) {
        return rbVoucherLostMapper.deleteByPrimaryKey(lostKey, lostNo);
    }

    @Override
    public int create(RbVoucherLostEO eo) {
        RbVoucherLost row = RbVoucherLostValueUtil.eoToEntity(eo);
        return rbVoucherLostMapper.insert(row);
    }

    @Override
    public int createSelective(RbVoucherLostEO eo) {
        RbVoucherLost row = RbVoucherLostValueUtil.eoToEntity(eo);
        return rbVoucherLostMapper.insertSelective(row);
    }

    @Override
    public List<RbVoucherLostEO> findByEo(RbVoucherLostEO eo) {
        RbVoucherLostExample example = RbVoucherLostValueUtil.eoToEntityExample(eo);
        List<RbVoucherLostEO> result = new ArrayList<>();
        List<RbVoucherLost> dbResult = rbVoucherLostMapper.selectByExample(example);
        for (RbVoucherLost item : dbResult) {
            result.add(RbVoucherLostValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbVoucherLostEO findByPrimaryKey(String lostKey, String lostNo) {
        return RbVoucherLostValueUtil.entityToEo(rbVoucherLostMapper.selectByPrimaryKey(lostKey, lostNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbVoucherLostEO eo) {
        RbVoucherLost row = RbVoucherLostValueUtil.eoToEntity(eo);
        return rbVoucherLostMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbVoucherLostEO eo) {
        RbVoucherLost row = RbVoucherLostValueUtil.eoToEntity(eo);
        return rbVoucherLostMapper.updateByPrimaryKey(row);
    }
}
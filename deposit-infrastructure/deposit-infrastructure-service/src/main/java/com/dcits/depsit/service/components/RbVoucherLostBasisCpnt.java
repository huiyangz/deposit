package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.LostType;
import com.dcits.depsit.enums.RelieveLossType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherLostStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbVoucherLost;
import com.dcits.depsit.entity.RbVoucherLostExample;
import com.dcits.depsit.facade.components.IRbVoucherLostBcc;
import com.dcits.depsit.facade.eo.RbVoucherLostEO;
import com.dcits.depsit.repo.RbVoucherLostMapper;
import com.dcits.depsit.service.utils.RbVoucherLostValueUtil;
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
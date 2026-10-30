package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusFundDirectionDetails;
import com.dcits.deposit.entity.RbBusFundDirectionDetailsExample;
import com.dcits.deposit.facade.components.IRbBusFundDirectionDetailsBcc;
import com.dcits.deposit.facade.eo.RbBusFundDirectionDetailsEO;
import com.dcits.deposit.repo.RbBusFundDirectionDetailsMapper;
import com.dcits.deposit.service.utils.RbBusFundDirectionDetailsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusFundDirectionDetailsBasisCpnt implements IRbBusFundDirectionDetailsBcc {
    @Autowired
    RbBusFundDirectionDetailsMapper rbBusFundDirectionDetailsMapper;

    @Override
    public long countByEo(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetailsExample example = RbBusFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        return rbBusFundDirectionDetailsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetailsExample example = RbBusFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        return rbBusFundDirectionDetailsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rbBusFundDirectionDetailsMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetails row = RbBusFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbBusFundDirectionDetailsMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetails row = RbBusFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbBusFundDirectionDetailsMapper.insertSelective(row);
    }

    @Override
    public List<RbBusFundDirectionDetailsEO> findByEo(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetailsExample example = RbBusFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        List<RbBusFundDirectionDetailsEO> result = new ArrayList<>();
        List<RbBusFundDirectionDetails> dbResult = rbBusFundDirectionDetailsMapper.selectByExample(example);
        for (RbBusFundDirectionDetails item : dbResult) {
            result.add(RbBusFundDirectionDetailsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusFundDirectionDetailsEO findByPrimaryKey(String seqNo) {
        return RbBusFundDirectionDetailsValueUtil.entityToEo(rbBusFundDirectionDetailsMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetails row = RbBusFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbBusFundDirectionDetailsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusFundDirectionDetailsEO eo) {
        RbBusFundDirectionDetails row = RbBusFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbBusFundDirectionDetailsMapper.updateByPrimaryKey(row);
    }
}
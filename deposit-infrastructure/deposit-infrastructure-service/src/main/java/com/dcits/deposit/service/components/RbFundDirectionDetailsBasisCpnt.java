package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FundAcctPurpose;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RegType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbFundDirectionDetails;
import com.dcits.deposit.entity.RbFundDirectionDetailsExample;
import com.dcits.deposit.facade.components.IRbFundDirectionDetailsBcc;
import com.dcits.deposit.facade.eo.RbFundDirectionDetailsEO;
import com.dcits.deposit.repo.RbFundDirectionDetailsMapper;
import com.dcits.deposit.service.utils.RbFundDirectionDetailsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbFundDirectionDetailsBasisCpnt implements IRbFundDirectionDetailsBcc {
    @Autowired
    RbFundDirectionDetailsMapper rbFundDirectionDetailsMapper;

    @Override
    public long countByEo(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetailsExample example = RbFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        return rbFundDirectionDetailsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetailsExample example = RbFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        return rbFundDirectionDetailsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbFundDirectionDetailsMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetails row = RbFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbFundDirectionDetailsMapper.insert(row);
    }

    @Override
    public int createSelective(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetails row = RbFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbFundDirectionDetailsMapper.insertSelective(row);
    }

    @Override
    public List<RbFundDirectionDetailsEO> findByEo(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetailsExample example = RbFundDirectionDetailsValueUtil.eoToEntityExample(eo);
        List<RbFundDirectionDetailsEO> result = new ArrayList<>();
        List<RbFundDirectionDetails> dbResult = rbFundDirectionDetailsMapper.selectByExample(example);
        for (RbFundDirectionDetails item : dbResult) {
            result.add(RbFundDirectionDetailsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbFundDirectionDetailsEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbFundDirectionDetailsValueUtil.entityToEo(rbFundDirectionDetailsMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetails row = RbFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbFundDirectionDetailsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbFundDirectionDetailsEO eo) {
        RbFundDirectionDetails row = RbFundDirectionDetailsValueUtil.eoToEntity(eo);
        return rbFundDirectionDetailsMapper.updateByPrimaryKey(row);
    }
}
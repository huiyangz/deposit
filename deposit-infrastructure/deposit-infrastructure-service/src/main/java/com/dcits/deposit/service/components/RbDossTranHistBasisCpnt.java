package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.TranStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbDossTranHist;
import com.dcits.deposit.entity.RbDossTranHistExample;
import com.dcits.deposit.facade.components.IRbDossTranHistBcc;
import com.dcits.deposit.facade.eo.RbDossTranHistEO;
import com.dcits.deposit.repo.RbDossTranHistMapper;
import com.dcits.deposit.service.utils.RbDossTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbDossTranHistBasisCpnt implements IRbDossTranHistBcc {
    @Autowired
    RbDossTranHistMapper rbDossTranHistMapper;

    @Override
    public long countByEo(RbDossTranHistEO eo) {
        RbDossTranHistExample example = RbDossTranHistValueUtil.eoToEntityExample(eo);
        return rbDossTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbDossTranHistEO eo) {
        RbDossTranHistExample example = RbDossTranHistValueUtil.eoToEntityExample(eo);
        return rbDossTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo, Integer internalKey) {
        return rbDossTranHistMapper.deleteByPrimaryKey(seqNo, clientNo, internalKey);
    }

    @Override
    public int create(RbDossTranHistEO eo) {
        RbDossTranHist row = RbDossTranHistValueUtil.eoToEntity(eo);
        return rbDossTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbDossTranHistEO eo) {
        RbDossTranHist row = RbDossTranHistValueUtil.eoToEntity(eo);
        return rbDossTranHistMapper.insertSelective(row);
    }

    @Override
    public List<RbDossTranHistEO> findByEo(RbDossTranHistEO eo) {
        RbDossTranHistExample example = RbDossTranHistValueUtil.eoToEntityExample(eo);
        List<RbDossTranHistEO> result = new ArrayList<>();
        List<RbDossTranHist> dbResult = rbDossTranHistMapper.selectByExample(example);
        for (RbDossTranHist item : dbResult) {
            result.add(RbDossTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbDossTranHistEO findByPrimaryKey(String seqNo, String clientNo, Integer internalKey) {
        return RbDossTranHistValueUtil.entityToEo(rbDossTranHistMapper.selectByPrimaryKey(seqNo, clientNo, internalKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbDossTranHistEO eo) {
        RbDossTranHist row = RbDossTranHistValueUtil.eoToEntity(eo);
        return rbDossTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbDossTranHistEO eo) {
        RbDossTranHist row = RbDossTranHistValueUtil.eoToEntity(eo);
        return rbDossTranHistMapper.updateByPrimaryKey(row);
    }
}
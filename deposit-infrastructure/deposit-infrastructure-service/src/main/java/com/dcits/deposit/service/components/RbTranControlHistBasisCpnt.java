package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OnlineTranStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTranControlHist;
import com.dcits.deposit.entity.RbTranControlHistExample;
import com.dcits.deposit.facade.components.IRbTranControlHistBcc;
import com.dcits.deposit.facade.eo.RbTranControlHistEO;
import com.dcits.deposit.repo.RbTranControlHistMapper;
import com.dcits.deposit.service.utils.RbTranControlHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTranControlHistBasisCpnt implements IRbTranControlHistBcc {
    @Autowired
    RbTranControlHistMapper rbTranControlHistMapper;

    @Override
    public long countByEo(RbTranControlHistEO eo) {
        RbTranControlHistExample example = RbTranControlHistValueUtil.eoToEntityExample(eo);
        return rbTranControlHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTranControlHistEO eo) {
        RbTranControlHistExample example = RbTranControlHistValueUtil.eoToEntityExample(eo);
        return rbTranControlHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String channelSeqNo, Date channelDate, String sourceType, String subSeqNo, Date tranDate) {
        return rbTranControlHistMapper.deleteByPrimaryKey(channelSeqNo, channelDate, sourceType, subSeqNo, tranDate);
    }

    @Override
    public int create(RbTranControlHistEO eo) {
        RbTranControlHist row = RbTranControlHistValueUtil.eoToEntity(eo);
        return rbTranControlHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbTranControlHistEO eo) {
        RbTranControlHist row = RbTranControlHistValueUtil.eoToEntity(eo);
        return rbTranControlHistMapper.insertSelective(row);
    }

    @Override
    public List<RbTranControlHistEO> findByEo(RbTranControlHistEO eo) {
        RbTranControlHistExample example = RbTranControlHistValueUtil.eoToEntityExample(eo);
        List<RbTranControlHistEO> result = new ArrayList<>();
        List<RbTranControlHist> dbResult = rbTranControlHistMapper.selectByExample(example);
        for (RbTranControlHist item : dbResult) {
            result.add(RbTranControlHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTranControlHistEO findByPrimaryKey(String channelSeqNo, Date channelDate, String sourceType, String subSeqNo, Date tranDate) {
        return RbTranControlHistValueUtil.entityToEo(rbTranControlHistMapper.selectByPrimaryKey(channelSeqNo, channelDate, sourceType, subSeqNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTranControlHistEO eo) {
        RbTranControlHist row = RbTranControlHistValueUtil.eoToEntity(eo);
        return rbTranControlHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTranControlHistEO eo) {
        RbTranControlHist row = RbTranControlHistValueUtil.eoToEntity(eo);
        return rbTranControlHistMapper.updateByPrimaryKey(row);
    }
}
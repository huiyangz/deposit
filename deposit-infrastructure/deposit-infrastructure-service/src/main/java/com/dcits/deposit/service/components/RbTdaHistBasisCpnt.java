package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTdaHist;
import com.dcits.deposit.entity.RbTdaHistExample;
import com.dcits.deposit.facade.components.IRbTdaHistBcc;
import com.dcits.deposit.facade.eo.RbTdaHistEO;
import com.dcits.deposit.repo.RbTdaHistMapper;
import com.dcits.deposit.service.utils.RbTdaHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTdaHistBasisCpnt implements IRbTdaHistBcc {
    @Autowired
    RbTdaHistMapper rbTdaHistMapper;

    @Override
    public long countByEo(RbTdaHistEO eo) {
        RbTdaHistExample example = RbTdaHistValueUtil.eoToEntityExample(eo);
        return rbTdaHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTdaHistEO eo) {
        RbTdaHistExample example = RbTdaHistValueUtil.eoToEntityExample(eo);
        return rbTdaHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, Integer internalKey, String clientNo, Date acctMovtDate) {
        return rbTdaHistMapper.deleteByPrimaryKey(seqNo, internalKey, clientNo, acctMovtDate);
    }

    @Override
    public int create(RbTdaHistEO eo) {
        RbTdaHist row = RbTdaHistValueUtil.eoToEntity(eo);
        return rbTdaHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbTdaHistEO eo) {
        RbTdaHist row = RbTdaHistValueUtil.eoToEntity(eo);
        return rbTdaHistMapper.insertSelective(row);
    }

    @Override
    public List<RbTdaHistEO> findByEo(RbTdaHistEO eo) {
        RbTdaHistExample example = RbTdaHistValueUtil.eoToEntityExample(eo);
        List<RbTdaHistEO> result = new ArrayList<>();
        List<RbTdaHist> dbResult = rbTdaHistMapper.selectByExample(example);
        for (RbTdaHist item : dbResult) {
            result.add(RbTdaHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTdaHistEO findByPrimaryKey(String seqNo, Integer internalKey, String clientNo, Date acctMovtDate) {
        return RbTdaHistValueUtil.entityToEo(rbTdaHistMapper.selectByPrimaryKey(seqNo, internalKey, clientNo, acctMovtDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTdaHistEO eo) {
        RbTdaHist row = RbTdaHistValueUtil.eoToEntity(eo);
        return rbTdaHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTdaHistEO eo) {
        RbTdaHist row = RbTdaHistValueUtil.eoToEntity(eo);
        return rbTdaHistMapper.updateByPrimaryKey(row);
    }
}
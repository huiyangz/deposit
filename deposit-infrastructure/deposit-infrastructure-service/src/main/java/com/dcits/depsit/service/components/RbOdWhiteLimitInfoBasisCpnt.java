package com.dcits.depsit.service.components;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbOdWhiteLimitInfo;
import com.dcits.depsit.entity.RbOdWhiteLimitInfoExample;
import com.dcits.depsit.facade.components.IRbOdWhiteLimitInfoBcc;
import com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO;
import com.dcits.depsit.repo.RbOdWhiteLimitInfoMapper;
import com.dcits.depsit.service.utils.RbOdWhiteLimitInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbOdWhiteLimitInfoBasisCpnt implements IRbOdWhiteLimitInfoBcc {
    @Autowired
    RbOdWhiteLimitInfoMapper rbOdWhiteLimitInfoMapper;

    @Override
    public long countByEo(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfoExample example = RbOdWhiteLimitInfoValueUtil.eoToEntityExample(eo);
        return rbOdWhiteLimitInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfoExample example = RbOdWhiteLimitInfoValueUtil.eoToEntityExample(eo);
        return rbOdWhiteLimitInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(BigDecimal odPtAmt, String tranTimestamp, String company, BigDecimal sameObjectPdOdCumulative, String vbsflag, String isCrossFlag) {
        return rbOdWhiteLimitInfoMapper.deleteByPrimaryKey(odPtAmt, tranTimestamp, company, sameObjectPdOdCumulative, vbsflag, isCrossFlag);
    }

    @Override
    public int create(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfo row = RbOdWhiteLimitInfoValueUtil.eoToEntity(eo);
        return rbOdWhiteLimitInfoMapper.insert(row);
    }

    @Override
    public int createSelective(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfo row = RbOdWhiteLimitInfoValueUtil.eoToEntity(eo);
        return rbOdWhiteLimitInfoMapper.insertSelective(row);
    }

    @Override
    public List<RbOdWhiteLimitInfoEO> findByEo(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfoExample example = RbOdWhiteLimitInfoValueUtil.eoToEntityExample(eo);
        List<RbOdWhiteLimitInfoEO> result = new ArrayList<>();
        List<RbOdWhiteLimitInfo> dbResult = rbOdWhiteLimitInfoMapper.selectByExample(example);
        for (RbOdWhiteLimitInfo item : dbResult) {
            result.add(RbOdWhiteLimitInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbOdWhiteLimitInfoEO findByPrimaryKey(BigDecimal odPtAmt, String tranTimestamp, String company, BigDecimal sameObjectPdOdCumulative, String vbsflag, String isCrossFlag) {
        return RbOdWhiteLimitInfoValueUtil.entityToEo(rbOdWhiteLimitInfoMapper.selectByPrimaryKey(odPtAmt, tranTimestamp, company, sameObjectPdOdCumulative, vbsflag, isCrossFlag));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfo row = RbOdWhiteLimitInfoValueUtil.eoToEntity(eo);
        return rbOdWhiteLimitInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbOdWhiteLimitInfoEO eo) {
        RbOdWhiteLimitInfo row = RbOdWhiteLimitInfoValueUtil.eoToEntity(eo);
        return rbOdWhiteLimitInfoMapper.updateByPrimaryKey(row);
    }
}
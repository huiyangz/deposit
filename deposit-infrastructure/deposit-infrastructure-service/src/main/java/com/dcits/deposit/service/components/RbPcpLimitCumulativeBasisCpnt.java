package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.LimitType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbPcpLimitCumulative;
import com.dcits.deposit.entity.RbPcpLimitCumulativeExample;
import com.dcits.deposit.facade.components.IRbPcpLimitCumulativeBcc;
import com.dcits.deposit.facade.eo.RbPcpLimitCumulativeEO;
import com.dcits.deposit.repo.RbPcpLimitCumulativeMapper;
import com.dcits.deposit.service.utils.RbPcpLimitCumulativeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbPcpLimitCumulativeBasisCpnt implements IRbPcpLimitCumulativeBcc {
    @Autowired
    RbPcpLimitCumulativeMapper rbPcpLimitCumulativeMapper;

    @Override
    public long countByEo(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulativeExample example = RbPcpLimitCumulativeValueUtil.eoToEntityExample(eo);
        return rbPcpLimitCumulativeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulativeExample example = RbPcpLimitCumulativeValueUtil.eoToEntityExample(eo);
        return rbPcpLimitCumulativeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String limitType, String agreementId, String clientNo) {
        return rbPcpLimitCumulativeMapper.deleteByPrimaryKey(internalKey, limitType, agreementId, clientNo);
    }

    @Override
    public int create(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulative row = RbPcpLimitCumulativeValueUtil.eoToEntity(eo);
        return rbPcpLimitCumulativeMapper.insert(row);
    }

    @Override
    public int createSelective(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulative row = RbPcpLimitCumulativeValueUtil.eoToEntity(eo);
        return rbPcpLimitCumulativeMapper.insertSelective(row);
    }

    @Override
    public List<RbPcpLimitCumulativeEO> findByEo(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulativeExample example = RbPcpLimitCumulativeValueUtil.eoToEntityExample(eo);
        List<RbPcpLimitCumulativeEO> result = new ArrayList<>();
        List<RbPcpLimitCumulative> dbResult = rbPcpLimitCumulativeMapper.selectByExample(example);
        for (RbPcpLimitCumulative item : dbResult) {
            result.add(RbPcpLimitCumulativeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbPcpLimitCumulativeEO findByPrimaryKey(Integer internalKey, String limitType, String agreementId, String clientNo) {
        return RbPcpLimitCumulativeValueUtil.entityToEo(rbPcpLimitCumulativeMapper.selectByPrimaryKey(internalKey, limitType, agreementId, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulative row = RbPcpLimitCumulativeValueUtil.eoToEntity(eo);
        return rbPcpLimitCumulativeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbPcpLimitCumulativeEO eo) {
        RbPcpLimitCumulative row = RbPcpLimitCumulativeValueUtil.eoToEntity(eo);
        return rbPcpLimitCumulativeMapper.updateByPrimaryKey(row);
    }
}
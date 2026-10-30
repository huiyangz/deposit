package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.RecordStatus;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SumType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLimitSumJnl;
import com.dcits.deposit.entity.RbLimitSumJnlExample;
import com.dcits.deposit.facade.components.IRbLimitSumJnlBcc;
import com.dcits.deposit.facade.eo.RbLimitSumJnlEO;
import com.dcits.deposit.repo.RbLimitSumJnlMapper;
import com.dcits.deposit.service.utils.RbLimitSumJnlValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitSumJnlBasisCpnt implements IRbLimitSumJnlBcc {
    @Autowired
    RbLimitSumJnlMapper rbLimitSumJnlMapper;

    @Override
    public long countByEo(RbLimitSumJnlEO eo) {
        RbLimitSumJnlExample example = RbLimitSumJnlValueUtil.eoToEntityExample(eo);
        return rbLimitSumJnlMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitSumJnlEO eo) {
        RbLimitSumJnlExample example = RbLimitSumJnlValueUtil.eoToEntityExample(eo);
        return rbLimitSumJnlMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String checkObjVal, String limitSceneNo, String clientNo) {
        return rbLimitSumJnlMapper.deleteByPrimaryKey(checkObjVal, limitSceneNo, clientNo);
    }

    @Override
    public int create(RbLimitSumJnlEO eo) {
        RbLimitSumJnl row = RbLimitSumJnlValueUtil.eoToEntity(eo);
        return rbLimitSumJnlMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitSumJnlEO eo) {
        RbLimitSumJnl row = RbLimitSumJnlValueUtil.eoToEntity(eo);
        return rbLimitSumJnlMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitSumJnlEO> findByEo(RbLimitSumJnlEO eo) {
        RbLimitSumJnlExample example = RbLimitSumJnlValueUtil.eoToEntityExample(eo);
        List<RbLimitSumJnlEO> result = new ArrayList<>();
        List<RbLimitSumJnl> dbResult = rbLimitSumJnlMapper.selectByExample(example);
        for (RbLimitSumJnl item : dbResult) {
            result.add(RbLimitSumJnlValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitSumJnlEO findByPrimaryKey(String checkObjVal, String limitSceneNo, String clientNo) {
        return RbLimitSumJnlValueUtil.entityToEo(rbLimitSumJnlMapper.selectByPrimaryKey(checkObjVal, limitSceneNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitSumJnlEO eo) {
        RbLimitSumJnl row = RbLimitSumJnlValueUtil.eoToEntity(eo);
        return rbLimitSumJnlMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitSumJnlEO eo) {
        RbLimitSumJnl row = RbLimitSumJnlValueUtil.eoToEntity(eo);
        return rbLimitSumJnlMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TranStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.IaBatchOpenDetail;
import com.dcits.deposit.entity.IaBatchOpenDetailExample;
import com.dcits.deposit.facade.components.IIaBatchOpenDetailBcc;
import com.dcits.deposit.facade.eo.IaBatchOpenDetailEO;
import com.dcits.deposit.repo.IaBatchOpenDetailMapper;
import com.dcits.deposit.service.utils.IaBatchOpenDetailValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IaBatchOpenDetailBasisCpnt implements IIaBatchOpenDetailBcc {
    @Autowired
    IaBatchOpenDetailMapper iaBatchOpenDetailMapper;

    @Override
    public long countByEo(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetailExample example = IaBatchOpenDetailValueUtil.eoToEntityExample(eo);
        return iaBatchOpenDetailMapper.countByExample(example);
    }

    @Override
    public int removeByEo(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetailExample example = IaBatchOpenDetailValueUtil.eoToEntityExample(eo);
        return iaBatchOpenDetailMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String batchNo, String batchSeqNo) {
        return iaBatchOpenDetailMapper.deleteByPrimaryKey(batchNo, batchSeqNo);
    }

    @Override
    public int create(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetail row = IaBatchOpenDetailValueUtil.eoToEntity(eo);
        return iaBatchOpenDetailMapper.insert(row);
    }

    @Override
    public int createSelective(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetail row = IaBatchOpenDetailValueUtil.eoToEntity(eo);
        return iaBatchOpenDetailMapper.insertSelective(row);
    }

    @Override
    public List<IaBatchOpenDetailEO> findByEo(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetailExample example = IaBatchOpenDetailValueUtil.eoToEntityExample(eo);
        List<IaBatchOpenDetailEO> result = new ArrayList<>();
        List<IaBatchOpenDetail> dbResult = iaBatchOpenDetailMapper.selectByExample(example);
        for (IaBatchOpenDetail item : dbResult) {
            result.add(IaBatchOpenDetailValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public IaBatchOpenDetailEO findByPrimaryKey(String batchNo, String batchSeqNo) {
        return IaBatchOpenDetailValueUtil.entityToEo(iaBatchOpenDetailMapper.selectByPrimaryKey(batchNo, batchSeqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetail row = IaBatchOpenDetailValueUtil.eoToEntity(eo);
        return iaBatchOpenDetailMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(IaBatchOpenDetailEO eo) {
        IaBatchOpenDetail row = IaBatchOpenDetailValueUtil.eoToEntity(eo);
        return iaBatchOpenDetailMapper.updateByPrimaryKey(row);
    }
}
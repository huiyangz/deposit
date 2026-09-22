package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BatchStatus;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBatchTranDetails;
import com.dcits.deposit.entity.RbBatchTranDetailsExample;
import com.dcits.deposit.facade.components.IRbBatchTranDetailsBcc;
import com.dcits.deposit.facade.eo.RbBatchTranDetailsEO;
import com.dcits.deposit.repo.RbBatchTranDetailsMapper;
import com.dcits.deposit.service.utils.RbBatchTranDetailsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBatchTranDetailsBasisCpnt implements IRbBatchTranDetailsBcc {
    @Autowired
    RbBatchTranDetailsMapper rbBatchTranDetailsMapper;

    @Override
    public long countByEo(RbBatchTranDetailsEO eo) {
        RbBatchTranDetailsExample example = RbBatchTranDetailsValueUtil.eoToEntityExample(eo);
        return rbBatchTranDetailsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBatchTranDetailsEO eo) {
        RbBatchTranDetailsExample example = RbBatchTranDetailsValueUtil.eoToEntityExample(eo);
        return rbBatchTranDetailsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String batchSeqNo, String batchNo) {
        return rbBatchTranDetailsMapper.deleteByPrimaryKey(batchSeqNo, batchNo);
    }

    @Override
    public int create(RbBatchTranDetailsEO eo) {
        RbBatchTranDetails row = RbBatchTranDetailsValueUtil.eoToEntity(eo);
        return rbBatchTranDetailsMapper.insert(row);
    }

    @Override
    public int createSelective(RbBatchTranDetailsEO eo) {
        RbBatchTranDetails row = RbBatchTranDetailsValueUtil.eoToEntity(eo);
        return rbBatchTranDetailsMapper.insertSelective(row);
    }

    @Override
    public List<RbBatchTranDetailsEO> findByEo(RbBatchTranDetailsEO eo) {
        RbBatchTranDetailsExample example = RbBatchTranDetailsValueUtil.eoToEntityExample(eo);
        List<RbBatchTranDetailsEO> result = new ArrayList<>();
        List<RbBatchTranDetails> dbResult = rbBatchTranDetailsMapper.selectByExample(example);
        for (RbBatchTranDetails item : dbResult) {
            result.add(RbBatchTranDetailsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBatchTranDetailsEO findByPrimaryKey(String batchSeqNo, String batchNo) {
        return RbBatchTranDetailsValueUtil.entityToEo(rbBatchTranDetailsMapper.selectByPrimaryKey(batchSeqNo, batchNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBatchTranDetailsEO eo) {
        RbBatchTranDetails row = RbBatchTranDetailsValueUtil.eoToEntity(eo);
        return rbBatchTranDetailsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBatchTranDetailsEO eo) {
        RbBatchTranDetails row = RbBatchTranDetailsValueUtil.eoToEntity(eo);
        return rbBatchTranDetailsMapper.updateByPrimaryKey(row);
    }
}
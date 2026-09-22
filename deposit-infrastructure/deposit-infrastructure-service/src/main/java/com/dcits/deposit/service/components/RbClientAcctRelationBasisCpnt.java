package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.RelStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbClientAcctRelation;
import com.dcits.deposit.entity.RbClientAcctRelationExample;
import com.dcits.deposit.facade.components.IRbClientAcctRelationBcc;
import com.dcits.deposit.facade.eo.RbClientAcctRelationEO;
import com.dcits.deposit.repo.RbClientAcctRelationMapper;
import com.dcits.deposit.service.utils.RbClientAcctRelationValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbClientAcctRelationBasisCpnt implements IRbClientAcctRelationBcc {
    @Autowired
    RbClientAcctRelationMapper rbClientAcctRelationMapper;

    @Override
    public long countByEo(RbClientAcctRelationEO eo) {
        RbClientAcctRelationExample example = RbClientAcctRelationValueUtil.eoToEntityExample(eo);
        return rbClientAcctRelationMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbClientAcctRelationEO eo) {
        RbClientAcctRelationExample example = RbClientAcctRelationValueUtil.eoToEntityExample(eo);
        return rbClientAcctRelationMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String baseAcctNo, String clientNo, String acctSeqNo) {
        return rbClientAcctRelationMapper.deleteByPrimaryKey(baseAcctNo, clientNo, acctSeqNo);
    }

    @Override
    public int create(RbClientAcctRelationEO eo) {
        RbClientAcctRelation row = RbClientAcctRelationValueUtil.eoToEntity(eo);
        return rbClientAcctRelationMapper.insert(row);
    }

    @Override
    public int createSelective(RbClientAcctRelationEO eo) {
        RbClientAcctRelation row = RbClientAcctRelationValueUtil.eoToEntity(eo);
        return rbClientAcctRelationMapper.insertSelective(row);
    }

    @Override
    public List<RbClientAcctRelationEO> findByEo(RbClientAcctRelationEO eo) {
        RbClientAcctRelationExample example = RbClientAcctRelationValueUtil.eoToEntityExample(eo);
        List<RbClientAcctRelationEO> result = new ArrayList<>();
        List<RbClientAcctRelation> dbResult = rbClientAcctRelationMapper.selectByExample(example);
        for (RbClientAcctRelation item : dbResult) {
            result.add(RbClientAcctRelationValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbClientAcctRelationEO findByPrimaryKey(String baseAcctNo, String clientNo, String acctSeqNo) {
        return RbClientAcctRelationValueUtil.entityToEo(rbClientAcctRelationMapper.selectByPrimaryKey(baseAcctNo, clientNo, acctSeqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbClientAcctRelationEO eo) {
        RbClientAcctRelation row = RbClientAcctRelationValueUtil.eoToEntity(eo);
        return rbClientAcctRelationMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbClientAcctRelationEO eo) {
        RbClientAcctRelation row = RbClientAcctRelationValueUtil.eoToEntity(eo);
        return rbClientAcctRelationMapper.updateByPrimaryKey(row);
    }
}
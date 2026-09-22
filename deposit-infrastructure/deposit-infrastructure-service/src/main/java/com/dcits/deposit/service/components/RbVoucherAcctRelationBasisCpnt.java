package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.VoucherStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbVoucherAcctRelation;
import com.dcits.deposit.entity.RbVoucherAcctRelationExample;
import com.dcits.deposit.facade.components.IRbVoucherAcctRelationBcc;
import com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO;
import com.dcits.deposit.repo.RbVoucherAcctRelationMapper;
import com.dcits.deposit.service.utils.RbVoucherAcctRelationValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbVoucherAcctRelationBasisCpnt implements IRbVoucherAcctRelationBcc {
    @Autowired
    RbVoucherAcctRelationMapper rbVoucherAcctRelationMapper;

    @Override
    public long countByEo(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelationExample example = RbVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        return rbVoucherAcctRelationMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelationExample example = RbVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        return rbVoucherAcctRelationMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String baseAcctNo, String docType, String voucherNo, String clientNo) {
        return rbVoucherAcctRelationMapper.deleteByPrimaryKey(baseAcctNo, docType, voucherNo, clientNo);
    }

    @Override
    public int create(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelation row = RbVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbVoucherAcctRelationMapper.insert(row);
    }

    @Override
    public int createSelective(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelation row = RbVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbVoucherAcctRelationMapper.insertSelective(row);
    }

    @Override
    public List<RbVoucherAcctRelationEO> findByEo(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelationExample example = RbVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        List<RbVoucherAcctRelationEO> result = new ArrayList<>();
        List<RbVoucherAcctRelation> dbResult = rbVoucherAcctRelationMapper.selectByExample(example);
        for (RbVoucherAcctRelation item : dbResult) {
            result.add(RbVoucherAcctRelationValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbVoucherAcctRelationEO findByPrimaryKey(String baseAcctNo, String docType, String voucherNo, String clientNo) {
        return RbVoucherAcctRelationValueUtil.entityToEo(rbVoucherAcctRelationMapper.selectByPrimaryKey(baseAcctNo, docType, voucherNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelation row = RbVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbVoucherAcctRelationMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbVoucherAcctRelationEO eo) {
        RbVoucherAcctRelation row = RbVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbVoucherAcctRelationMapper.updateByPrimaryKey(row);
    }
}
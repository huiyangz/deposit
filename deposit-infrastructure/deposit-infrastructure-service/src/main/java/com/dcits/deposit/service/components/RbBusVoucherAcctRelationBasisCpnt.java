package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusVoucherAcctRelation;
import com.dcits.deposit.entity.RbBusVoucherAcctRelationExample;
import com.dcits.deposit.facade.components.IRbBusVoucherAcctRelationBcc;
import com.dcits.deposit.facade.eo.RbBusVoucherAcctRelationEO;
import com.dcits.deposit.repo.RbBusVoucherAcctRelationMapper;
import com.dcits.deposit.service.utils.RbBusVoucherAcctRelationValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusVoucherAcctRelationBasisCpnt implements IRbBusVoucherAcctRelationBcc {
    @Autowired
    RbBusVoucherAcctRelationMapper rbBusVoucherAcctRelationMapper;

    @Override
    public long countByEo(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelationExample example = RbBusVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        return rbBusVoucherAcctRelationMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelationExample example = RbBusVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        return rbBusVoucherAcctRelationMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String docType, String baseAcctNo, String voucherNo) {
        return rbBusVoucherAcctRelationMapper.deleteByPrimaryKey(docType, baseAcctNo, voucherNo);
    }

    @Override
    public int create(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelation row = RbBusVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbBusVoucherAcctRelationMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelation row = RbBusVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbBusVoucherAcctRelationMapper.insertSelective(row);
    }

    @Override
    public List<RbBusVoucherAcctRelationEO> findByEo(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelationExample example = RbBusVoucherAcctRelationValueUtil.eoToEntityExample(eo);
        List<RbBusVoucherAcctRelationEO> result = new ArrayList<>();
        List<RbBusVoucherAcctRelation> dbResult = rbBusVoucherAcctRelationMapper.selectByExample(example);
        for (RbBusVoucherAcctRelation item : dbResult) {
            result.add(RbBusVoucherAcctRelationValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusVoucherAcctRelationEO findByPrimaryKey(String docType, String baseAcctNo, String voucherNo) {
        return RbBusVoucherAcctRelationValueUtil.entityToEo(rbBusVoucherAcctRelationMapper.selectByPrimaryKey(docType, baseAcctNo, voucherNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelation row = RbBusVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbBusVoucherAcctRelationMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusVoucherAcctRelationEO eo) {
        RbBusVoucherAcctRelation row = RbBusVoucherAcctRelationValueUtil.eoToEntity(eo);
        return rbBusVoucherAcctRelationMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.CanReasonCode;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.VoucherStatus;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusVoucherAcctRelation;
import com.dcits.depsit.entity.RbBusVoucherAcctRelationExample;
import com.dcits.depsit.facade.components.IRbBusVoucherAcctRelationBcc;
import com.dcits.depsit.facade.eo.RbBusVoucherAcctRelationEO;
import com.dcits.depsit.repo.RbBusVoucherAcctRelationMapper;
import com.dcits.depsit.service.utils.RbBusVoucherAcctRelationValueUtil;
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
    public int removeByPrimaryKey(String voucherNo, String docType, String baseAcctNo) {
        return rbBusVoucherAcctRelationMapper.deleteByPrimaryKey(voucherNo, docType, baseAcctNo);
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
    public RbBusVoucherAcctRelationEO findByPrimaryKey(String voucherNo, String docType, String baseAcctNo) {
        return RbBusVoucherAcctRelationValueUtil.entityToEo(rbBusVoucherAcctRelationMapper.selectByPrimaryKey(voucherNo, docType, baseAcctNo));
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
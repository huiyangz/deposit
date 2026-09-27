package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOperateType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.NatureProperty;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbCorpNatureDef;
import com.dcits.deposit.entity.RbCorpNatureDefExample;
import com.dcits.deposit.facade.components.IRbCorpNatureDefBcc;
import com.dcits.deposit.facade.eo.RbCorpNatureDefEO;
import com.dcits.deposit.repo.RbCorpNatureDefMapper;
import com.dcits.deposit.service.utils.RbCorpNatureDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbCorpNatureDefBasisCpnt implements IRbCorpNatureDefBcc {
    @Autowired
    RbCorpNatureDefMapper rbCorpNatureDefMapper;

    @Override
    public long countByEo(RbCorpNatureDefEO eo) {
        RbCorpNatureDefExample example = RbCorpNatureDefValueUtil.eoToEntityExample(eo);
        return rbCorpNatureDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbCorpNatureDefEO eo) {
        RbCorpNatureDefExample example = RbCorpNatureDefValueUtil.eoToEntityExample(eo);
        return rbCorpNatureDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rbCorpNatureDefMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RbCorpNatureDefEO eo) {
        RbCorpNatureDef row = RbCorpNatureDefValueUtil.eoToEntity(eo);
        return rbCorpNatureDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbCorpNatureDefEO eo) {
        RbCorpNatureDef row = RbCorpNatureDefValueUtil.eoToEntity(eo);
        return rbCorpNatureDefMapper.insertSelective(row);
    }

    @Override
    public List<RbCorpNatureDefEO> findByEo(RbCorpNatureDefEO eo) {
        RbCorpNatureDefExample example = RbCorpNatureDefValueUtil.eoToEntityExample(eo);
        List<RbCorpNatureDefEO> result = new ArrayList<>();
        List<RbCorpNatureDef> dbResult = rbCorpNatureDefMapper.selectByExample(example);
        for (RbCorpNatureDef item : dbResult) {
            result.add(RbCorpNatureDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbCorpNatureDefEO findByPrimaryKey(String seqNo) {
        return RbCorpNatureDefValueUtil.entityToEo(rbCorpNatureDefMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbCorpNatureDefEO eo) {
        RbCorpNatureDef row = RbCorpNatureDefValueUtil.eoToEntity(eo);
        return rbCorpNatureDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbCorpNatureDefEO eo) {
        RbCorpNatureDef row = RbCorpNatureDefValueUtil.eoToEntity(eo);
        return rbCorpNatureDefMapper.updateByPrimaryKey(row);
    }
}
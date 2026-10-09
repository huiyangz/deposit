package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctOperateType;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.NatureProperty;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TermType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbCorpNatureDef;
import com.dcits.depsit.entity.RbCorpNatureDefExample;
import com.dcits.depsit.facade.components.IRbCorpNatureDefBcc;
import com.dcits.depsit.facade.eo.RbCorpNatureDefEO;
import com.dcits.depsit.repo.RbCorpNatureDefMapper;
import com.dcits.depsit.service.utils.RbCorpNatureDefValueUtil;
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
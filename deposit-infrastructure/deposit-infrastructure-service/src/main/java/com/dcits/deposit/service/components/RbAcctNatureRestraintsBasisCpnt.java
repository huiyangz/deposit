package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctNatureRestraints;
import com.dcits.deposit.entity.RbAcctNatureRestraintsExample;
import com.dcits.deposit.facade.components.IRbAcctNatureRestraintsBcc;
import com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO;
import com.dcits.deposit.repo.RbAcctNatureRestraintsMapper;
import com.dcits.deposit.service.utils.RbAcctNatureRestraintsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctNatureRestraintsBasisCpnt implements IRbAcctNatureRestraintsBcc {
    @Autowired
    RbAcctNatureRestraintsMapper rbAcctNatureRestraintsMapper;

    @Override
    public long countByEo(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraintsExample example = RbAcctNatureRestraintsValueUtil.eoToEntityExample(eo);
        return rbAcctNatureRestraintsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraintsExample example = RbAcctNatureRestraintsValueUtil.eoToEntityExample(eo);
        return rbAcctNatureRestraintsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String restraintType, String acctNatureNo) {
        return rbAcctNatureRestraintsMapper.deleteByPrimaryKey(restraintType, acctNatureNo);
    }

    @Override
    public int create(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraints row = RbAcctNatureRestraintsValueUtil.eoToEntity(eo);
        return rbAcctNatureRestraintsMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraints row = RbAcctNatureRestraintsValueUtil.eoToEntity(eo);
        return rbAcctNatureRestraintsMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctNatureRestraintsEO> findByEo(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraintsExample example = RbAcctNatureRestraintsValueUtil.eoToEntityExample(eo);
        List<RbAcctNatureRestraintsEO> result = new ArrayList<>();
        List<RbAcctNatureRestraints> dbResult = rbAcctNatureRestraintsMapper.selectByExample(example);
        for (RbAcctNatureRestraints item : dbResult) {
            result.add(RbAcctNatureRestraintsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctNatureRestraintsEO findByPrimaryKey(String restraintType, String acctNatureNo) {
        return RbAcctNatureRestraintsValueUtil.entityToEo(rbAcctNatureRestraintsMapper.selectByPrimaryKey(restraintType, acctNatureNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraints row = RbAcctNatureRestraintsValueUtil.eoToEntity(eo);
        return rbAcctNatureRestraintsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctNatureRestraintsEO eo) {
        RbAcctNatureRestraints row = RbAcctNatureRestraintsValueUtil.eoToEntity(eo);
        return rbAcctNatureRestraintsMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbClientRestraints;
import com.dcits.depsit.entity.RbClientRestraintsExample;
import com.dcits.depsit.facade.components.IRbClientRestraintsBcc;
import com.dcits.depsit.facade.eo.RbClientRestraintsEO;
import com.dcits.depsit.repo.RbClientRestraintsMapper;
import com.dcits.depsit.service.utils.RbClientRestraintsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbClientRestraintsBasisCpnt implements IRbClientRestraintsBcc {
    @Autowired
    RbClientRestraintsMapper rbClientRestraintsMapper;

    @Override
    public long countByEo(RbClientRestraintsEO eo) {
        RbClientRestraintsExample example = RbClientRestraintsValueUtil.eoToEntityExample(eo);
        return rbClientRestraintsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbClientRestraintsEO eo) {
        RbClientRestraintsExample example = RbClientRestraintsValueUtil.eoToEntityExample(eo);
        return rbClientRestraintsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String resSeqNo, String clientNo) {
        return rbClientRestraintsMapper.deleteByPrimaryKey(resSeqNo, clientNo);
    }

    @Override
    public int create(RbClientRestraintsEO eo) {
        RbClientRestraints row = RbClientRestraintsValueUtil.eoToEntity(eo);
        return rbClientRestraintsMapper.insert(row);
    }

    @Override
    public int createSelective(RbClientRestraintsEO eo) {
        RbClientRestraints row = RbClientRestraintsValueUtil.eoToEntity(eo);
        return rbClientRestraintsMapper.insertSelective(row);
    }

    @Override
    public List<RbClientRestraintsEO> findByEo(RbClientRestraintsEO eo) {
        RbClientRestraintsExample example = RbClientRestraintsValueUtil.eoToEntityExample(eo);
        List<RbClientRestraintsEO> result = new ArrayList<>();
        List<RbClientRestraints> dbResult = rbClientRestraintsMapper.selectByExample(example);
        for (RbClientRestraints item : dbResult) {
            result.add(RbClientRestraintsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbClientRestraintsEO findByPrimaryKey(String resSeqNo, String clientNo) {
        return RbClientRestraintsValueUtil.entityToEo(rbClientRestraintsMapper.selectByPrimaryKey(resSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbClientRestraintsEO eo) {
        RbClientRestraints row = RbClientRestraintsValueUtil.eoToEntity(eo);
        return rbClientRestraintsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbClientRestraintsEO eo) {
        RbClientRestraints row = RbClientRestraintsValueUtil.eoToEntity(eo);
        return rbClientRestraintsMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctInternalKeyType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ResAcctRange;
import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintSource;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusRestraints;
import com.dcits.deposit.entity.RbBusRestraintsExample;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.repo.RbBusRestraintsMapper;
import com.dcits.deposit.service.utils.RbBusRestraintsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusRestraintsBasisCpnt implements IRbBusRestraintsBcc {
    @Autowired
    RbBusRestraintsMapper rbBusRestraintsMapper;

    @Override
    public long countByEo(RbBusRestraintsEO eo) {
        RbBusRestraintsExample example = RbBusRestraintsValueUtil.eoToEntityExample(eo);
        return rbBusRestraintsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusRestraintsEO eo) {
        RbBusRestraintsExample example = RbBusRestraintsValueUtil.eoToEntityExample(eo);
        return rbBusRestraintsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String resSeqNo) {
        return rbBusRestraintsMapper.deleteByPrimaryKey(resSeqNo);
    }

    @Override
    public int create(RbBusRestraintsEO eo) {
        RbBusRestraints row = RbBusRestraintsValueUtil.eoToEntity(eo);
        return rbBusRestraintsMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusRestraintsEO eo) {
        RbBusRestraints row = RbBusRestraintsValueUtil.eoToEntity(eo);
        return rbBusRestraintsMapper.insertSelective(row);
    }

    @Override
    public List<RbBusRestraintsEO> findByEo(RbBusRestraintsEO eo) {
        RbBusRestraintsExample example = RbBusRestraintsValueUtil.eoToEntityExample(eo);
        List<RbBusRestraintsEO> result = new ArrayList<>();
        List<RbBusRestraints> dbResult = rbBusRestraintsMapper.selectByExample(example);
        for (RbBusRestraints item : dbResult) {
            result.add(RbBusRestraintsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusRestraintsEO findByPrimaryKey(String resSeqNo) {
        return RbBusRestraintsValueUtil.entityToEo(rbBusRestraintsMapper.selectByPrimaryKey(resSeqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusRestraintsEO eo) {
        RbBusRestraints row = RbBusRestraintsValueUtil.eoToEntity(eo);
        return rbBusRestraintsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusRestraintsEO eo) {
        RbBusRestraints row = RbBusRestraintsValueUtil.eoToEntity(eo);
        return rbBusRestraintsMapper.updateByPrimaryKey(row);
    }
}
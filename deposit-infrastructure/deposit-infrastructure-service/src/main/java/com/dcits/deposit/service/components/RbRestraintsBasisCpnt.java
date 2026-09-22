package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctInternalKeyType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ResAcctRange;
import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintSource;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbRestraints;
import com.dcits.deposit.entity.RbRestraintsExample;
import com.dcits.deposit.facade.components.IRbRestraintsBcc;
import com.dcits.deposit.facade.eo.RbRestraintsEO;
import com.dcits.deposit.repo.RbRestraintsMapper;
import com.dcits.deposit.service.utils.RbRestraintsValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbRestraintsBasisCpnt implements IRbRestraintsBcc {
    @Autowired
    RbRestraintsMapper rbRestraintsMapper;

    @Override
    public long countByEo(RbRestraintsEO eo) {
        RbRestraintsExample example = RbRestraintsValueUtil.eoToEntityExample(eo);
        return rbRestraintsMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbRestraintsEO eo) {
        RbRestraintsExample example = RbRestraintsValueUtil.eoToEntityExample(eo);
        return rbRestraintsMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String resSeqNo, String clientNo) {
        return rbRestraintsMapper.deleteByPrimaryKey(resSeqNo, clientNo);
    }

    @Override
    public int create(RbRestraintsEO eo) {
        RbRestraints row = RbRestraintsValueUtil.eoToEntity(eo);
        return rbRestraintsMapper.insert(row);
    }

    @Override
    public int createSelective(RbRestraintsEO eo) {
        RbRestraints row = RbRestraintsValueUtil.eoToEntity(eo);
        return rbRestraintsMapper.insertSelective(row);
    }

    @Override
    public List<RbRestraintsEO> findByEo(RbRestraintsEO eo) {
        RbRestraintsExample example = RbRestraintsValueUtil.eoToEntityExample(eo);
        List<RbRestraintsEO> result = new ArrayList<>();
        List<RbRestraints> dbResult = rbRestraintsMapper.selectByExample(example);
        for (RbRestraints item : dbResult) {
            result.add(RbRestraintsValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbRestraintsEO findByPrimaryKey(String resSeqNo, String clientNo) {
        return RbRestraintsValueUtil.entityToEo(rbRestraintsMapper.selectByPrimaryKey(resSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbRestraintsEO eo) {
        RbRestraints row = RbRestraintsValueUtil.eoToEntity(eo);
        return rbRestraintsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbRestraintsEO eo) {
        RbRestraints row = RbRestraintsValueUtil.eoToEntity(eo);
        return rbRestraintsMapper.updateByPrimaryKey(row);
    }
}
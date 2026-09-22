package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SourceModule;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbOpenCloseReg;
import com.dcits.deposit.entity.RbOpenCloseRegExample;
import com.dcits.deposit.facade.components.IRbOpenCloseRegBcc;
import com.dcits.deposit.facade.eo.RbOpenCloseRegEO;
import com.dcits.deposit.repo.RbOpenCloseRegMapper;
import com.dcits.deposit.service.utils.RbOpenCloseRegValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbOpenCloseRegBasisCpnt implements IRbOpenCloseRegBcc {
    @Autowired
    RbOpenCloseRegMapper rbOpenCloseRegMapper;

    @Override
    public long countByEo(RbOpenCloseRegEO eo) {
        RbOpenCloseRegExample example = RbOpenCloseRegValueUtil.eoToEntityExample(eo);
        return rbOpenCloseRegMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbOpenCloseRegEO eo) {
        RbOpenCloseRegExample example = RbOpenCloseRegValueUtil.eoToEntityExample(eo);
        return rbOpenCloseRegMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbOpenCloseRegMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbOpenCloseRegEO eo) {
        RbOpenCloseReg row = RbOpenCloseRegValueUtil.eoToEntity(eo);
        return rbOpenCloseRegMapper.insert(row);
    }

    @Override
    public int createSelective(RbOpenCloseRegEO eo) {
        RbOpenCloseReg row = RbOpenCloseRegValueUtil.eoToEntity(eo);
        return rbOpenCloseRegMapper.insertSelective(row);
    }

    @Override
    public List<RbOpenCloseRegEO> findByEo(RbOpenCloseRegEO eo) {
        RbOpenCloseRegExample example = RbOpenCloseRegValueUtil.eoToEntityExample(eo);
        List<RbOpenCloseRegEO> result = new ArrayList<>();
        List<RbOpenCloseReg> dbResult = rbOpenCloseRegMapper.selectByExample(example);
        for (RbOpenCloseReg item : dbResult) {
            result.add(RbOpenCloseRegValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbOpenCloseRegEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbOpenCloseRegValueUtil.entityToEo(rbOpenCloseRegMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbOpenCloseRegEO eo) {
        RbOpenCloseReg row = RbOpenCloseRegValueUtil.eoToEntity(eo);
        return rbOpenCloseRegMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbOpenCloseRegEO eo) {
        RbOpenCloseReg row = RbOpenCloseRegValueUtil.eoToEntity(eo);
        return rbOpenCloseRegMapper.updateByPrimaryKey(row);
    }
}
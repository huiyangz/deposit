package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctOpenMode;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.InformBankFlag;
import com.dcits.depsit.enums.IsSelf;
import com.dcits.depsit.enums.OpMethod;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.enums.RegType;
import com.dcits.depsit.enums.SucFlag;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusOpenCloseReg;
import com.dcits.depsit.entity.RbBusOpenCloseRegExample;
import com.dcits.depsit.facade.components.IRbBusOpenCloseRegBcc;
import com.dcits.depsit.facade.eo.RbBusOpenCloseRegEO;
import com.dcits.depsit.repo.RbBusOpenCloseRegMapper;
import com.dcits.depsit.service.utils.RbBusOpenCloseRegValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusOpenCloseRegBasisCpnt implements IRbBusOpenCloseRegBcc {
    @Autowired
    RbBusOpenCloseRegMapper rbBusOpenCloseRegMapper;

    @Override
    public long countByEo(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseRegExample example = RbBusOpenCloseRegValueUtil.eoToEntityExample(eo);
        return rbBusOpenCloseRegMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseRegExample example = RbBusOpenCloseRegValueUtil.eoToEntityExample(eo);
        return rbBusOpenCloseRegMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo) {
        return rbBusOpenCloseRegMapper.deleteByPrimaryKey(seqNo);
    }

    @Override
    public int create(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseReg row = RbBusOpenCloseRegValueUtil.eoToEntity(eo);
        return rbBusOpenCloseRegMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseReg row = RbBusOpenCloseRegValueUtil.eoToEntity(eo);
        return rbBusOpenCloseRegMapper.insertSelective(row);
    }

    @Override
    public List<RbBusOpenCloseRegEO> findByEo(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseRegExample example = RbBusOpenCloseRegValueUtil.eoToEntityExample(eo);
        List<RbBusOpenCloseRegEO> result = new ArrayList<>();
        List<RbBusOpenCloseReg> dbResult = rbBusOpenCloseRegMapper.selectByExample(example);
        for (RbBusOpenCloseReg item : dbResult) {
            result.add(RbBusOpenCloseRegValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusOpenCloseRegEO findByPrimaryKey(String seqNo) {
        return RbBusOpenCloseRegValueUtil.entityToEo(rbBusOpenCloseRegMapper.selectByPrimaryKey(seqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseReg row = RbBusOpenCloseRegValueUtil.eoToEntity(eo);
        return rbBusOpenCloseRegMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusOpenCloseRegEO eo) {
        RbBusOpenCloseReg row = RbBusOpenCloseRegValueUtil.eoToEntity(eo);
        return rbBusOpenCloseRegMapper.updateByPrimaryKey(row);
    }
}
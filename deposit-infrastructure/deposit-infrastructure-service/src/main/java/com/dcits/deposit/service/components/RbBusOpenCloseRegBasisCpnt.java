package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.InformBankFlag;
import com.dcits.deposit.enums.IsSelf;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.SucFlag;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusOpenCloseReg;
import com.dcits.deposit.entity.RbBusOpenCloseRegExample;
import com.dcits.deposit.facade.components.IRbBusOpenCloseRegBcc;
import com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO;
import com.dcits.deposit.repo.RbBusOpenCloseRegMapper;
import com.dcits.deposit.service.utils.RbBusOpenCloseRegValueUtil;
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
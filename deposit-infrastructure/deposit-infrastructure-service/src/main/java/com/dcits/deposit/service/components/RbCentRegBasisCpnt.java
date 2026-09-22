package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.CentDealType;
import com.dcits.deposit.enums.CloseAcctInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WipeAccount;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbCentReg;
import com.dcits.deposit.entity.RbCentRegExample;
import com.dcits.deposit.facade.components.IRbCentRegBcc;
import com.dcits.deposit.facade.eo.RbCentRegEO;
import com.dcits.deposit.repo.RbCentRegMapper;
import com.dcits.deposit.service.utils.RbCentRegValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbCentRegBasisCpnt implements IRbCentRegBcc {
    @Autowired
    RbCentRegMapper rbCentRegMapper;

    @Override
    public long countByEo(RbCentRegEO eo) {
        RbCentRegExample example = RbCentRegValueUtil.eoToEntityExample(eo);
        return rbCentRegMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbCentRegEO eo) {
        RbCentRegExample example = RbCentRegValueUtil.eoToEntityExample(eo);
        return rbCentRegMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbCentRegMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbCentRegEO eo) {
        RbCentReg row = RbCentRegValueUtil.eoToEntity(eo);
        return rbCentRegMapper.insert(row);
    }

    @Override
    public int createSelective(RbCentRegEO eo) {
        RbCentReg row = RbCentRegValueUtil.eoToEntity(eo);
        return rbCentRegMapper.insertSelective(row);
    }

    @Override
    public List<RbCentRegEO> findByEo(RbCentRegEO eo) {
        RbCentRegExample example = RbCentRegValueUtil.eoToEntityExample(eo);
        List<RbCentRegEO> result = new ArrayList<>();
        List<RbCentReg> dbResult = rbCentRegMapper.selectByExample(example);
        for (RbCentReg item : dbResult) {
            result.add(RbCentRegValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbCentRegEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbCentRegValueUtil.entityToEo(rbCentRegMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbCentRegEO eo) {
        RbCentReg row = RbCentRegValueUtil.eoToEntity(eo);
        return rbCentRegMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbCentRegEO eo) {
        RbCentReg row = RbCentRegValueUtil.eoToEntity(eo);
        return rbCentRegMapper.updateByPrimaryKey(row);
    }
}
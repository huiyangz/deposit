package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.FundSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbApprLetter;
import com.dcits.deposit.entity.RbApprLetterExample;
import com.dcits.deposit.facade.components.IRbApprLetterBcc;
import com.dcits.deposit.facade.eo.RbApprLetterEO;
import com.dcits.deposit.repo.RbApprLetterMapper;
import com.dcits.deposit.service.utils.RbApprLetterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbApprLetterBasisCpnt implements IRbApprLetterBcc {
    @Autowired
    RbApprLetterMapper rbApprLetterMapper;

    @Override
    public long countByEo(RbApprLetterEO eo) {
        RbApprLetterExample example = RbApprLetterValueUtil.eoToEntityExample(eo);
        return rbApprLetterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbApprLetterEO eo) {
        RbApprLetterExample example = RbApprLetterValueUtil.eoToEntityExample(eo);
        return rbApprLetterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String apprLetterNo, String clientNo) {
        return rbApprLetterMapper.deleteByPrimaryKey(apprLetterNo, clientNo);
    }

    @Override
    public int create(RbApprLetterEO eo) {
        RbApprLetter row = RbApprLetterValueUtil.eoToEntity(eo);
        return rbApprLetterMapper.insert(row);
    }

    @Override
    public int createSelective(RbApprLetterEO eo) {
        RbApprLetter row = RbApprLetterValueUtil.eoToEntity(eo);
        return rbApprLetterMapper.insertSelective(row);
    }

    @Override
    public List<RbApprLetterEO> findByEo(RbApprLetterEO eo) {
        RbApprLetterExample example = RbApprLetterValueUtil.eoToEntityExample(eo);
        List<RbApprLetterEO> result = new ArrayList<>();
        List<RbApprLetter> dbResult = rbApprLetterMapper.selectByExample(example);
        for (RbApprLetter item : dbResult) {
            result.add(RbApprLetterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbApprLetterEO findByPrimaryKey(String apprLetterNo, String clientNo) {
        return RbApprLetterValueUtil.entityToEo(rbApprLetterMapper.selectByPrimaryKey(apprLetterNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbApprLetterEO eo) {
        RbApprLetter row = RbApprLetterValueUtil.eoToEntity(eo);
        return rbApprLetterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbApprLetterEO eo) {
        RbApprLetter row = RbApprLetterValueUtil.eoToEntity(eo);
        return rbApprLetterMapper.updateByPrimaryKey(row);
    }
}
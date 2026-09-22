package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.MainSubInd;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbApprLetterSub;
import com.dcits.deposit.entity.RbApprLetterSubExample;
import com.dcits.deposit.facade.components.IRbApprLetterSubBcc;
import com.dcits.deposit.facade.eo.RbApprLetterSubEO;
import com.dcits.deposit.repo.RbApprLetterSubMapper;
import com.dcits.deposit.service.utils.RbApprLetterSubValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbApprLetterSubBasisCpnt implements IRbApprLetterSubBcc {
    @Autowired
    RbApprLetterSubMapper rbApprLetterSubMapper;

    @Override
    public long countByEo(RbApprLetterSubEO eo) {
        RbApprLetterSubExample example = RbApprLetterSubValueUtil.eoToEntityExample(eo);
        return rbApprLetterSubMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbApprLetterSubEO eo) {
        RbApprLetterSubExample example = RbApprLetterSubValueUtil.eoToEntityExample(eo);
        return rbApprLetterSubMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String apprLetterNo, String mainSubInd, String ccy, String clientNo) {
        return rbApprLetterSubMapper.deleteByPrimaryKey(apprLetterNo, mainSubInd, ccy, clientNo);
    }

    @Override
    public int create(RbApprLetterSubEO eo) {
        RbApprLetterSub row = RbApprLetterSubValueUtil.eoToEntity(eo);
        return rbApprLetterSubMapper.insert(row);
    }

    @Override
    public int createSelective(RbApprLetterSubEO eo) {
        RbApprLetterSub row = RbApprLetterSubValueUtil.eoToEntity(eo);
        return rbApprLetterSubMapper.insertSelective(row);
    }

    @Override
    public List<RbApprLetterSubEO> findByEo(RbApprLetterSubEO eo) {
        RbApprLetterSubExample example = RbApprLetterSubValueUtil.eoToEntityExample(eo);
        List<RbApprLetterSubEO> result = new ArrayList<>();
        List<RbApprLetterSub> dbResult = rbApprLetterSubMapper.selectByExample(example);
        for (RbApprLetterSub item : dbResult) {
            result.add(RbApprLetterSubValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbApprLetterSubEO findByPrimaryKey(String apprLetterNo, String mainSubInd, String ccy, String clientNo) {
        return RbApprLetterSubValueUtil.entityToEo(rbApprLetterSubMapper.selectByPrimaryKey(apprLetterNo, mainSubInd, ccy, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbApprLetterSubEO eo) {
        RbApprLetterSub row = RbApprLetterSubValueUtil.eoToEntity(eo);
        return rbApprLetterSubMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbApprLetterSubEO eo) {
        RbApprLetterSub row = RbApprLetterSubValueUtil.eoToEntity(eo);
        return rbApprLetterSubMapper.updateByPrimaryKey(row);
    }
}
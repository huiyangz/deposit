package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbApprLetterTranHist;
import com.dcits.deposit.entity.RbApprLetterTranHistExample;
import com.dcits.deposit.facade.components.IRbApprLetterTranHistBcc;
import com.dcits.deposit.facade.eo.RbApprLetterTranHistEO;
import com.dcits.deposit.repo.RbApprLetterTranHistMapper;
import com.dcits.deposit.service.utils.RbApprLetterTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbApprLetterTranHistBasisCpnt implements IRbApprLetterTranHistBcc {
    @Autowired
    RbApprLetterTranHistMapper rbApprLetterTranHistMapper;

    @Override
    public long countByEo(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHistExample example = RbApprLetterTranHistValueUtil.eoToEntityExample(eo);
        return rbApprLetterTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHistExample example = RbApprLetterTranHistValueUtil.eoToEntityExample(eo);
        return rbApprLetterTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbApprLetterTranHistMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHist row = RbApprLetterTranHistValueUtil.eoToEntity(eo);
        return rbApprLetterTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHist row = RbApprLetterTranHistValueUtil.eoToEntity(eo);
        return rbApprLetterTranHistMapper.insertSelective(row);
    }

    @Override
    public List<RbApprLetterTranHistEO> findByEo(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHistExample example = RbApprLetterTranHistValueUtil.eoToEntityExample(eo);
        List<RbApprLetterTranHistEO> result = new ArrayList<>();
        List<RbApprLetterTranHist> dbResult = rbApprLetterTranHistMapper.selectByExample(example);
        for (RbApprLetterTranHist item : dbResult) {
            result.add(RbApprLetterTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbApprLetterTranHistEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbApprLetterTranHistValueUtil.entityToEo(rbApprLetterTranHistMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHist row = RbApprLetterTranHistValueUtil.eoToEntity(eo);
        return rbApprLetterTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbApprLetterTranHistEO eo) {
        RbApprLetterTranHist row = RbApprLetterTranHistValueUtil.eoToEntity(eo);
        return rbApprLetterTranHistMapper.updateByPrimaryKey(row);
    }
}
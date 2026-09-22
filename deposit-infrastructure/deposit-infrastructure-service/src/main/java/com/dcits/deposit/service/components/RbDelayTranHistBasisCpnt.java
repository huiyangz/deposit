package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ArrivalStatus;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbDelayTranHist;
import com.dcits.deposit.entity.RbDelayTranHistExample;
import com.dcits.deposit.facade.components.IRbDelayTranHistBcc;
import com.dcits.deposit.facade.eo.RbDelayTranHistEO;
import com.dcits.deposit.repo.RbDelayTranHistMapper;
import com.dcits.deposit.service.utils.RbDelayTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbDelayTranHistBasisCpnt implements IRbDelayTranHistBcc {
    @Autowired
    RbDelayTranHistMapper rbDelayTranHistMapper;

    @Override
    public long countByEo(RbDelayTranHistEO eo) {
        RbDelayTranHistExample example = RbDelayTranHistValueUtil.eoToEntityExample(eo);
        return rbDelayTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbDelayTranHistEO eo) {
        RbDelayTranHistExample example = RbDelayTranHistValueUtil.eoToEntityExample(eo);
        return rbDelayTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return rbDelayTranHistMapper.deleteByPrimaryKey(seqNo, clientNo, tranDate);
    }

    @Override
    public int create(RbDelayTranHistEO eo) {
        RbDelayTranHist row = RbDelayTranHistValueUtil.eoToEntity(eo);
        return rbDelayTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbDelayTranHistEO eo) {
        RbDelayTranHist row = RbDelayTranHistValueUtil.eoToEntity(eo);
        return rbDelayTranHistMapper.insertSelective(row);
    }

    @Override
    public List<RbDelayTranHistEO> findByEo(RbDelayTranHistEO eo) {
        RbDelayTranHistExample example = RbDelayTranHistValueUtil.eoToEntityExample(eo);
        List<RbDelayTranHistEO> result = new ArrayList<>();
        List<RbDelayTranHist> dbResult = rbDelayTranHistMapper.selectByExample(example);
        for (RbDelayTranHist item : dbResult) {
            result.add(RbDelayTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbDelayTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return RbDelayTranHistValueUtil.entityToEo(rbDelayTranHistMapper.selectByPrimaryKey(seqNo, clientNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbDelayTranHistEO eo) {
        RbDelayTranHist row = RbDelayTranHistValueUtil.eoToEntity(eo);
        return rbDelayTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbDelayTranHistEO eo) {
        RbDelayTranHist row = RbDelayTranHistValueUtil.eoToEntity(eo);
        return rbDelayTranHistMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BaseQuoteType;
import com.dcits.deposit.enums.BaseRateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CouponRateType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.SellBuyInd;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UncStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbExchangeTranHist;
import com.dcits.deposit.entity.RbExchangeTranHistExample;
import com.dcits.deposit.facade.components.IRbExchangeTranHistBcc;
import com.dcits.deposit.facade.eo.RbExchangeTranHistEO;
import com.dcits.deposit.repo.RbExchangeTranHistMapper;
import com.dcits.deposit.service.utils.RbExchangeTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbExchangeTranHistBasisCpnt implements IRbExchangeTranHistBcc {
    @Autowired
    RbExchangeTranHistMapper rbExchangeTranHistMapper;

    @Override
    public long countByEo(RbExchangeTranHistEO eo) {
        RbExchangeTranHistExample example = RbExchangeTranHistValueUtil.eoToEntityExample(eo);
        return rbExchangeTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbExchangeTranHistEO eo) {
        RbExchangeTranHistExample example = RbExchangeTranHistValueUtil.eoToEntityExample(eo);
        return rbExchangeTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return rbExchangeTranHistMapper.deleteByPrimaryKey(seqNo, clientNo, tranDate);
    }

    @Override
    public int create(RbExchangeTranHistEO eo) {
        RbExchangeTranHist row = RbExchangeTranHistValueUtil.eoToEntity(eo);
        return rbExchangeTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(RbExchangeTranHistEO eo) {
        RbExchangeTranHist row = RbExchangeTranHistValueUtil.eoToEntity(eo);
        return rbExchangeTranHistMapper.insertSelective(row);
    }

    @Override
    public List<RbExchangeTranHistEO> findByEo(RbExchangeTranHistEO eo) {
        RbExchangeTranHistExample example = RbExchangeTranHistValueUtil.eoToEntityExample(eo);
        List<RbExchangeTranHistEO> result = new ArrayList<>();
        List<RbExchangeTranHist> dbResult = rbExchangeTranHistMapper.selectByExample(example);
        for (RbExchangeTranHist item : dbResult) {
            result.add(RbExchangeTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbExchangeTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate) {
        return RbExchangeTranHistValueUtil.entityToEo(rbExchangeTranHistMapper.selectByPrimaryKey(seqNo, clientNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbExchangeTranHistEO eo) {
        RbExchangeTranHist row = RbExchangeTranHistValueUtil.eoToEntity(eo);
        return rbExchangeTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbExchangeTranHistEO eo) {
        RbExchangeTranHist row = RbExchangeTranHistValueUtil.eoToEntity(eo);
        return rbExchangeTranHistMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctPaymentStatus;
import com.dcits.deposit.enums.AcglFlag;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.Direction;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.PtPaymentTranHist;
import com.dcits.deposit.entity.PtPaymentTranHistExample;
import com.dcits.deposit.facade.components.IPtPaymentTranHistBcc;
import com.dcits.deposit.facade.eo.PtPaymentTranHistEO;
import com.dcits.deposit.repo.PtPaymentTranHistMapper;
import com.dcits.deposit.service.utils.PtPaymentTranHistValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PtPaymentTranHistBasisCpnt implements IPtPaymentTranHistBcc {
    @Autowired
    PtPaymentTranHistMapper ptPaymentTranHistMapper;

    @Override
    public long countByEo(PtPaymentTranHistEO eo) {
        PtPaymentTranHistExample example = PtPaymentTranHistValueUtil.eoToEntityExample(eo);
        return ptPaymentTranHistMapper.countByExample(example);
    }

    @Override
    public int removeByEo(PtPaymentTranHistEO eo) {
        PtPaymentTranHistExample example = PtPaymentTranHistValueUtil.eoToEntityExample(eo);
        return ptPaymentTranHistMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String channelSeqNo, String channelSubSeqNo, Date tranDate, String clientNo) {
        return ptPaymentTranHistMapper.deleteByPrimaryKey(channelSeqNo, channelSubSeqNo, tranDate, clientNo);
    }

    @Override
    public int create(PtPaymentTranHistEO eo) {
        PtPaymentTranHist row = PtPaymentTranHistValueUtil.eoToEntity(eo);
        return ptPaymentTranHistMapper.insert(row);
    }

    @Override
    public int createSelective(PtPaymentTranHistEO eo) {
        PtPaymentTranHist row = PtPaymentTranHistValueUtil.eoToEntity(eo);
        return ptPaymentTranHistMapper.insertSelective(row);
    }

    @Override
    public List<PtPaymentTranHistEO> findByEo(PtPaymentTranHistEO eo) {
        PtPaymentTranHistExample example = PtPaymentTranHistValueUtil.eoToEntityExample(eo);
        List<PtPaymentTranHistEO> result = new ArrayList<>();
        List<PtPaymentTranHist> dbResult = ptPaymentTranHistMapper.selectByExample(example);
        for (PtPaymentTranHist item : dbResult) {
            result.add(PtPaymentTranHistValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public PtPaymentTranHistEO findByPrimaryKey(String channelSeqNo, String channelSubSeqNo, Date tranDate, String clientNo) {
        return PtPaymentTranHistValueUtil.entityToEo(ptPaymentTranHistMapper.selectByPrimaryKey(channelSeqNo, channelSubSeqNo, tranDate, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(PtPaymentTranHistEO eo) {
        PtPaymentTranHist row = PtPaymentTranHistValueUtil.eoToEntity(eo);
        return ptPaymentTranHistMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(PtPaymentTranHistEO eo) {
        PtPaymentTranHist row = PtPaymentTranHistValueUtil.eoToEntity(eo);
        return ptPaymentTranHistMapper.updateByPrimaryKey(row);
    }
}
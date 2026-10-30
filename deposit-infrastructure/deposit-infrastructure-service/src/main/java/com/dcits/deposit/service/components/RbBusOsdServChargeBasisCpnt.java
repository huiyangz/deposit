package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ChargeWay;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DiscType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.OsdStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusOsdServCharge;
import com.dcits.deposit.entity.RbBusOsdServChargeExample;
import com.dcits.deposit.facade.components.IRbBusOsdServChargeBcc;
import com.dcits.deposit.facade.eo.RbBusOsdServChargeEO;
import com.dcits.deposit.repo.RbBusOsdServChargeMapper;
import com.dcits.deposit.service.utils.RbBusOsdServChargeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusOsdServChargeBasisCpnt implements IRbBusOsdServChargeBcc {
    @Autowired
    RbBusOsdServChargeMapper rbBusOsdServChargeMapper;

    @Override
    public long countByEo(RbBusOsdServChargeEO eo) {
        RbBusOsdServChargeExample example = RbBusOsdServChargeValueUtil.eoToEntityExample(eo);
        return rbBusOsdServChargeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusOsdServChargeEO eo) {
        RbBusOsdServChargeExample example = RbBusOsdServChargeValueUtil.eoToEntityExample(eo);
        return rbBusOsdServChargeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String osdSeqNo, Date tranDate) {
        return rbBusOsdServChargeMapper.deleteByPrimaryKey(osdSeqNo, tranDate);
    }

    @Override
    public int create(RbBusOsdServChargeEO eo) {
        RbBusOsdServCharge row = RbBusOsdServChargeValueUtil.eoToEntity(eo);
        return rbBusOsdServChargeMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusOsdServChargeEO eo) {
        RbBusOsdServCharge row = RbBusOsdServChargeValueUtil.eoToEntity(eo);
        return rbBusOsdServChargeMapper.insertSelective(row);
    }

    @Override
    public List<RbBusOsdServChargeEO> findByEo(RbBusOsdServChargeEO eo) {
        RbBusOsdServChargeExample example = RbBusOsdServChargeValueUtil.eoToEntityExample(eo);
        List<RbBusOsdServChargeEO> result = new ArrayList<>();
        List<RbBusOsdServCharge> dbResult = rbBusOsdServChargeMapper.selectByExample(example);
        for (RbBusOsdServCharge item : dbResult) {
            result.add(RbBusOsdServChargeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusOsdServChargeEO findByPrimaryKey(String osdSeqNo, Date tranDate) {
        return RbBusOsdServChargeValueUtil.entityToEo(rbBusOsdServChargeMapper.selectByPrimaryKey(osdSeqNo, tranDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusOsdServChargeEO eo) {
        RbBusOsdServCharge row = RbBusOsdServChargeValueUtil.eoToEntity(eo);
        return rbBusOsdServChargeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusOsdServChargeEO eo) {
        RbBusOsdServCharge row = RbBusOsdServChargeValueUtil.eoToEntity(eo);
        return rbBusOsdServChargeMapper.updateByPrimaryKey(row);
    }
}
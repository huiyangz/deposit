package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.HangDealType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.IaHangAccountReg;
import com.dcits.deposit.entity.IaHangAccountRegExample;
import com.dcits.deposit.facade.components.IIaHangAccountRegBcc;
import com.dcits.deposit.facade.eo.IaHangAccountRegEO;
import com.dcits.deposit.repo.IaHangAccountRegMapper;
import com.dcits.deposit.service.utils.IaHangAccountRegValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IaHangAccountRegBasisCpnt implements IIaHangAccountRegBcc {
    @Autowired
    IaHangAccountRegMapper iaHangAccountRegMapper;

    @Override
    public long countByEo(IaHangAccountRegEO eo) {
        IaHangAccountRegExample example = IaHangAccountRegValueUtil.eoToEntityExample(eo);
        return iaHangAccountRegMapper.countByExample(example);
    }

    @Override
    public int removeByEo(IaHangAccountRegEO eo) {
        IaHangAccountRegExample example = IaHangAccountRegValueUtil.eoToEntityExample(eo);
        return iaHangAccountRegMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String hangSeqNo, String subHangSeqNo, String clientNo) {
        return iaHangAccountRegMapper.deleteByPrimaryKey(hangSeqNo, subHangSeqNo, clientNo);
    }

    @Override
    public int create(IaHangAccountRegEO eo) {
        IaHangAccountReg row = IaHangAccountRegValueUtil.eoToEntity(eo);
        return iaHangAccountRegMapper.insert(row);
    }

    @Override
    public int createSelective(IaHangAccountRegEO eo) {
        IaHangAccountReg row = IaHangAccountRegValueUtil.eoToEntity(eo);
        return iaHangAccountRegMapper.insertSelective(row);
    }

    @Override
    public List<IaHangAccountRegEO> findByEo(IaHangAccountRegEO eo) {
        IaHangAccountRegExample example = IaHangAccountRegValueUtil.eoToEntityExample(eo);
        List<IaHangAccountRegEO> result = new ArrayList<>();
        List<IaHangAccountReg> dbResult = iaHangAccountRegMapper.selectByExample(example);
        for (IaHangAccountReg item : dbResult) {
            result.add(IaHangAccountRegValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public IaHangAccountRegEO findByPrimaryKey(String hangSeqNo, String subHangSeqNo, String clientNo) {
        return IaHangAccountRegValueUtil.entityToEo(iaHangAccountRegMapper.selectByPrimaryKey(hangSeqNo, subHangSeqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(IaHangAccountRegEO eo) {
        IaHangAccountReg row = IaHangAccountRegValueUtil.eoToEntity(eo);
        return iaHangAccountRegMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(IaHangAccountRegEO eo) {
        IaHangAccountReg row = IaHangAccountRegValueUtil.eoToEntity(eo);
        return iaHangAccountRegMapper.updateByPrimaryKey(row);
    }
}
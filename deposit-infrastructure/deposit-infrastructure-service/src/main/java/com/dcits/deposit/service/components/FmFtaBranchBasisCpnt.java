package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.FtaNature;
import com.dcits.deposit.enums.FtaType;
import com.dcits.deposit.enums.RateType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmFtaBranch;
import com.dcits.deposit.entity.FmFtaBranchExample;
import com.dcits.deposit.facade.components.IFmFtaBranchBcc;
import com.dcits.deposit.facade.eo.FmFtaBranchEO;
import com.dcits.deposit.repo.FmFtaBranchMapper;
import com.dcits.deposit.service.utils.FmFtaBranchValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmFtaBranchBasisCpnt implements IFmFtaBranchBcc {
    @Autowired
    FmFtaBranchMapper fmFtaBranchMapper;

    @Override
    public long countByEo(FmFtaBranchEO eo) {
        FmFtaBranchExample example = FmFtaBranchValueUtil.eoToEntityExample(eo);
        return fmFtaBranchMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmFtaBranchEO eo) {
        FmFtaBranchExample example = FmFtaBranchValueUtil.eoToEntityExample(eo);
        return fmFtaBranchMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String ftaCode) {
        return fmFtaBranchMapper.deleteByPrimaryKey(ftaCode);
    }

    @Override
    public int create(FmFtaBranchEO eo) {
        FmFtaBranch row = FmFtaBranchValueUtil.eoToEntity(eo);
        return fmFtaBranchMapper.insert(row);
    }

    @Override
    public int createSelective(FmFtaBranchEO eo) {
        FmFtaBranch row = FmFtaBranchValueUtil.eoToEntity(eo);
        return fmFtaBranchMapper.insertSelective(row);
    }

    @Override
    public List<FmFtaBranchEO> findByEo(FmFtaBranchEO eo) {
        FmFtaBranchExample example = FmFtaBranchValueUtil.eoToEntityExample(eo);
        List<FmFtaBranchEO> result = new ArrayList<>();
        List<FmFtaBranch> dbResult = fmFtaBranchMapper.selectByExample(example);
        for (FmFtaBranch item : dbResult) {
            result.add(FmFtaBranchValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmFtaBranchEO findByPrimaryKey(String ftaCode) {
        return FmFtaBranchValueUtil.entityToEo(fmFtaBranchMapper.selectByPrimaryKey(ftaCode));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmFtaBranchEO eo) {
        FmFtaBranch row = FmFtaBranchValueUtil.eoToEntity(eo);
        return fmFtaBranchMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmFtaBranchEO eo) {
        FmFtaBranch row = FmFtaBranchValueUtil.eoToEntity(eo);
        return fmFtaBranchMapper.updateByPrimaryKey(row);
    }
}
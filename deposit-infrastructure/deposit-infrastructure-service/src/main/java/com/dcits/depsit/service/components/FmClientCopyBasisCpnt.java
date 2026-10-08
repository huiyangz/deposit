package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.CategoryType;
import com.dcits.depsit.enums.City;
import com.dcits.depsit.enums.ClassLevel;
import com.dcits.depsit.enums.ClientClass;
import com.dcits.depsit.enums.ClientIndicator;
import com.dcits.depsit.enums.ClientStatus;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.ClientVerificationResult;
import com.dcits.depsit.enums.ContactType;
import com.dcits.depsit.enums.CountryLoc;
import com.dcits.depsit.enums.CrRating;
import com.dcits.depsit.enums.Education;
import com.dcits.depsit.enums.Industry;
import com.dcits.depsit.enums.IndustryLevel;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.Nation;
import com.dcits.depsit.enums.OccupationCode;
import com.dcits.depsit.enums.Sex;
import com.dcits.depsit.enums.SpokenLanguage;
import com.dcits.depsit.enums.State;
import com.dcits.depsit.enums.TaxFlag;
import com.dcits.depsit.enums.TaxResidentFlag;
import com.dcits.depsit.enums.ThawDocumentType2;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.FmClientCopy;
import com.dcits.depsit.entity.FmClientCopyExample;
import com.dcits.depsit.facade.components.IFmClientCopyBcc;
import com.dcits.depsit.facade.eo.FmClientCopyEO;
import com.dcits.depsit.repo.FmClientCopyMapper;
import com.dcits.depsit.service.utils.FmClientCopyValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmClientCopyBasisCpnt implements IFmClientCopyBcc {
    @Autowired
    FmClientCopyMapper fmClientCopyMapper;

    @Override
    public long countByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        return fmClientCopyMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        return fmClientCopyMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String clientNo) {
        return fmClientCopyMapper.deleteByPrimaryKey(clientNo);
    }

    @Override
    public int create(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.insert(row);
    }

    @Override
    public int createSelective(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.insertSelective(row);
    }

    @Override
    public List<FmClientCopyEO> findByEo(FmClientCopyEO eo) {
        FmClientCopyExample example = FmClientCopyValueUtil.eoToEntityExample(eo);
        List<FmClientCopyEO> result = new ArrayList<>();
        List<FmClientCopy> dbResult = fmClientCopyMapper.selectByExample(example);
        for (FmClientCopy item : dbResult) {
            result.add(FmClientCopyValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmClientCopyEO findByPrimaryKey(String clientNo) {
        return FmClientCopyValueUtil.entityToEo(fmClientCopyMapper.selectByPrimaryKey(clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmClientCopyEO eo) {
        FmClientCopy row = FmClientCopyValueUtil.eoToEntity(eo);
        return fmClientCopyMapper.updateByPrimaryKey(row);
    }
}
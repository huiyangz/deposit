package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcrossBranCheckFlag;
import com.dcits.deposit.enums.AllowReverseFlag;
import com.dcits.deposit.enums.BlacklistCheckFlag;
import com.dcits.deposit.enums.BusiCategory;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MultiCorpCheckFlag;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmServiceDefine;
import com.dcits.deposit.entity.FmServiceDefineExample;
import com.dcits.deposit.facade.components.IFmServiceDefineBcc;
import com.dcits.deposit.facade.eo.FmServiceDefineEO;
import com.dcits.deposit.repo.FmServiceDefineMapper;
import com.dcits.deposit.service.utils.FmServiceDefineValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmServiceDefineBasisCpnt implements IFmServiceDefineBcc {
    @Autowired
    FmServiceDefineMapper fmServiceDefineMapper;

    @Override
    public long countByEo(FmServiceDefineEO eo) {
        FmServiceDefineExample example = FmServiceDefineValueUtil.eoToEntityExample(eo);
        return fmServiceDefineMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmServiceDefineEO eo) {
        FmServiceDefineExample example = FmServiceDefineValueUtil.eoToEntityExample(eo);
        return fmServiceDefineMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String serviceCode, String messageType, String messageCode) {
        return fmServiceDefineMapper.deleteByPrimaryKey(serviceCode, messageType, messageCode);
    }

    @Override
    public int create(FmServiceDefineEO eo) {
        FmServiceDefine row = FmServiceDefineValueUtil.eoToEntity(eo);
        return fmServiceDefineMapper.insert(row);
    }

    @Override
    public int createSelective(FmServiceDefineEO eo) {
        FmServiceDefine row = FmServiceDefineValueUtil.eoToEntity(eo);
        return fmServiceDefineMapper.insertSelective(row);
    }

    @Override
    public List<FmServiceDefineEO> findByEo(FmServiceDefineEO eo) {
        FmServiceDefineExample example = FmServiceDefineValueUtil.eoToEntityExample(eo);
        List<FmServiceDefineEO> result = new ArrayList<>();
        List<FmServiceDefine> dbResult = fmServiceDefineMapper.selectByExample(example);
        for (FmServiceDefine item : dbResult) {
            result.add(FmServiceDefineValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmServiceDefineEO findByPrimaryKey(String serviceCode, String messageType, String messageCode) {
        return FmServiceDefineValueUtil.entityToEo(fmServiceDefineMapper.selectByPrimaryKey(serviceCode, messageType, messageCode));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmServiceDefineEO eo) {
        FmServiceDefine row = FmServiceDefineValueUtil.eoToEntity(eo);
        return fmServiceDefineMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmServiceDefineEO eo) {
        FmServiceDefine row = FmServiceDefineValueUtil.eoToEntity(eo);
        return fmServiceDefineMapper.updateByPrimaryKey(row);
    }
}
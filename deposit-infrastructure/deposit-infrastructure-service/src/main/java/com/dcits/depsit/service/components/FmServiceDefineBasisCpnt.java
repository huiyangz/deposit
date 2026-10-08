package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.BusiCategory;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.FmServiceDefine;
import com.dcits.depsit.entity.FmServiceDefineExample;
import com.dcits.depsit.facade.components.IFmServiceDefineBcc;
import com.dcits.depsit.facade.eo.FmServiceDefineEO;
import com.dcits.depsit.repo.FmServiceDefineMapper;
import com.dcits.depsit.service.utils.FmServiceDefineValueUtil;
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
    public int removeByPrimaryKey(String messageCode, String serviceCode, String messageType) {
        return fmServiceDefineMapper.deleteByPrimaryKey(messageCode, serviceCode, messageType);
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
    public FmServiceDefineEO findByPrimaryKey(String messageCode, String serviceCode, String messageType) {
        return FmServiceDefineValueUtil.entityToEo(fmServiceDefineMapper.selectByPrimaryKey(messageCode, serviceCode, messageType));
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
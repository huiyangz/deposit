package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmStructureParam;
import com.dcits.deposit.entity.FmStructureParamExample;
import com.dcits.deposit.facade.components.IFmStructureParamBcc;
import com.dcits.deposit.facade.eo.FmStructureParamEO;
import com.dcits.deposit.repo.FmStructureParamMapper;
import com.dcits.deposit.service.utils.FmStructureParamValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmStructureParamBasisCpnt implements IFmStructureParamBcc {
    @Autowired
    FmStructureParamMapper fmStructureParamMapper;

    @Override
    public long countByEo(FmStructureParamEO eo) {
        FmStructureParamExample example = FmStructureParamValueUtil.eoToEntityExample(eo);
        return fmStructureParamMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmStructureParamEO eo) {
        FmStructureParamExample example = FmStructureParamValueUtil.eoToEntityExample(eo);
        return fmStructureParamMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String structureType, String paramType, String startPos) {
        return fmStructureParamMapper.deleteByPrimaryKey(structureType, paramType, startPos);
    }

    @Override
    public int create(FmStructureParamEO eo) {
        FmStructureParam row = FmStructureParamValueUtil.eoToEntity(eo);
        return fmStructureParamMapper.insert(row);
    }

    @Override
    public int createSelective(FmStructureParamEO eo) {
        FmStructureParam row = FmStructureParamValueUtil.eoToEntity(eo);
        return fmStructureParamMapper.insertSelective(row);
    }

    @Override
    public List<FmStructureParamEO> findByEo(FmStructureParamEO eo) {
        FmStructureParamExample example = FmStructureParamValueUtil.eoToEntityExample(eo);
        List<FmStructureParamEO> result = new ArrayList<>();
        List<FmStructureParam> dbResult = fmStructureParamMapper.selectByExample(example);
        for (FmStructureParam item : dbResult) {
            result.add(FmStructureParamValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmStructureParamEO findByPrimaryKey(String structureType, String paramType, String startPos) {
        return FmStructureParamValueUtil.entityToEo(fmStructureParamMapper.selectByPrimaryKey(structureType, paramType, startPos));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmStructureParamEO eo) {
        FmStructureParam row = FmStructureParamValueUtil.eoToEntity(eo);
        return fmStructureParamMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmStructureParamEO eo) {
        FmStructureParam row = FmStructureParamValueUtil.eoToEntity(eo);
        return fmStructureParamMapper.updateByPrimaryKey(row);
    }
}
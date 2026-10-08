package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.IntBasis;
import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.MbIntMatrix;
import com.dcits.depsit.entity.MbIntMatrixExample;
import com.dcits.depsit.facade.components.IMbIntMatrixBcc;
import com.dcits.depsit.facade.eo.MbIntMatrixEO;
import com.dcits.depsit.repo.MbIntMatrixMapper;
import com.dcits.depsit.service.utils.MbIntMatrixValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbIntMatrixBasisCpnt implements IMbIntMatrixBcc {
    @Autowired
    MbIntMatrixMapper mbIntMatrixMapper;

    @Override
    public long countByEo(MbIntMatrixEO eo) {
        MbIntMatrixExample example = MbIntMatrixValueUtil.eoToEntityExample(eo);
        return mbIntMatrixMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbIntMatrixEO eo) {
        MbIntMatrixExample example = MbIntMatrixValueUtil.eoToEntityExample(eo);
        return mbIntMatrixMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String matrixNo) {
        return mbIntMatrixMapper.deleteByPrimaryKey(matrixNo);
    }

    @Override
    public int create(MbIntMatrixEO eo) {
        MbIntMatrix row = MbIntMatrixValueUtil.eoToEntity(eo);
        return mbIntMatrixMapper.insert(row);
    }

    @Override
    public int createSelective(MbIntMatrixEO eo) {
        MbIntMatrix row = MbIntMatrixValueUtil.eoToEntity(eo);
        return mbIntMatrixMapper.insertSelective(row);
    }

    @Override
    public List<MbIntMatrixEO> findByEo(MbIntMatrixEO eo) {
        MbIntMatrixExample example = MbIntMatrixValueUtil.eoToEntityExample(eo);
        List<MbIntMatrixEO> result = new ArrayList<>();
        List<MbIntMatrix> dbResult = mbIntMatrixMapper.selectByExample(example);
        for (MbIntMatrix item : dbResult) {
            result.add(MbIntMatrixValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbIntMatrixEO findByPrimaryKey(String matrixNo) {
        return MbIntMatrixValueUtil.entityToEo(mbIntMatrixMapper.selectByPrimaryKey(matrixNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbIntMatrixEO eo) {
        MbIntMatrix row = MbIntMatrixValueUtil.eoToEntity(eo);
        return mbIntMatrixMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbIntMatrixEO eo) {
        MbIntMatrix row = MbIntMatrixValueUtil.eoToEntity(eo);
        return mbIntMatrixMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbBranchProd;
import com.dcits.deposit.entity.MbBranchProdExample;
import com.dcits.deposit.facade.components.IMbBranchProdBcc;
import com.dcits.deposit.facade.eo.MbBranchProdEO;
import com.dcits.deposit.repo.MbBranchProdMapper;
import com.dcits.deposit.service.utils.MbBranchProdValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbBranchProdBasisCpnt implements IMbBranchProdBcc {
    @Autowired
    MbBranchProdMapper mbBranchProdMapper;

    @Override
    public long countByEo(MbBranchProdEO eo) {
        MbBranchProdExample example = MbBranchProdValueUtil.eoToEntityExample(eo);
        return mbBranchProdMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbBranchProdEO eo) {
        MbBranchProdExample example = MbBranchProdValueUtil.eoToEntityExample(eo);
        return mbBranchProdMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String branch, String prodType, String company) {
        return mbBranchProdMapper.deleteByPrimaryKey(branch, prodType, company);
    }

    @Override
    public int create(MbBranchProdEO eo) {
        MbBranchProd row = MbBranchProdValueUtil.eoToEntity(eo);
        return mbBranchProdMapper.insert(row);
    }

    @Override
    public int createSelective(MbBranchProdEO eo) {
        MbBranchProd row = MbBranchProdValueUtil.eoToEntity(eo);
        return mbBranchProdMapper.insertSelective(row);
    }

    @Override
    public List<MbBranchProdEO> findByEo(MbBranchProdEO eo) {
        MbBranchProdExample example = MbBranchProdValueUtil.eoToEntityExample(eo);
        List<MbBranchProdEO> result = new ArrayList<>();
        List<MbBranchProd> dbResult = mbBranchProdMapper.selectByExample(example);
        for (MbBranchProd item : dbResult) {
            result.add(MbBranchProdValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbBranchProdEO findByPrimaryKey(String branch, String prodType, String company) {
        return MbBranchProdValueUtil.entityToEo(mbBranchProdMapper.selectByPrimaryKey(branch, prodType, company));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbBranchProdEO eo) {
        MbBranchProd row = MbBranchProdValueUtil.eoToEntity(eo);
        return mbBranchProdMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbBranchProdEO eo) {
        MbBranchProd row = MbBranchProdValueUtil.eoToEntity(eo);
        return mbBranchProdMapper.updateByPrimaryKey(row);
    }
}
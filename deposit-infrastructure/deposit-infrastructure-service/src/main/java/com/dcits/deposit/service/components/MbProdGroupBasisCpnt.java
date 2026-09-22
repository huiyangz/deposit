package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbProdGroup;
import com.dcits.deposit.entity.MbProdGroupExample;
import com.dcits.deposit.facade.components.IMbProdGroupBcc;
import com.dcits.deposit.facade.eo.MbProdGroupEO;
import com.dcits.deposit.repo.MbProdGroupMapper;
import com.dcits.deposit.service.utils.MbProdGroupValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbProdGroupBasisCpnt implements IMbProdGroupBcc {
    @Autowired
    MbProdGroupMapper mbProdGroupMapper;

    @Override
    public long countByEo(MbProdGroupEO eo) {
        MbProdGroupExample example = MbProdGroupValueUtil.eoToEntityExample(eo);
        return mbProdGroupMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbProdGroupEO eo) {
        MbProdGroupExample example = MbProdGroupValueUtil.eoToEntityExample(eo);
        return mbProdGroupMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String prodType, String prodSubType, String company) {
        return mbProdGroupMapper.deleteByPrimaryKey(prodType, prodSubType, company);
    }

    @Override
    public int create(MbProdGroupEO eo) {
        MbProdGroup row = MbProdGroupValueUtil.eoToEntity(eo);
        return mbProdGroupMapper.insert(row);
    }

    @Override
    public int createSelective(MbProdGroupEO eo) {
        MbProdGroup row = MbProdGroupValueUtil.eoToEntity(eo);
        return mbProdGroupMapper.insertSelective(row);
    }

    @Override
    public List<MbProdGroupEO> findByEo(MbProdGroupEO eo) {
        MbProdGroupExample example = MbProdGroupValueUtil.eoToEntityExample(eo);
        List<MbProdGroupEO> result = new ArrayList<>();
        List<MbProdGroup> dbResult = mbProdGroupMapper.selectByExample(example);
        for (MbProdGroup item : dbResult) {
            result.add(MbProdGroupValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbProdGroupEO findByPrimaryKey(String prodType, String prodSubType, String company) {
        return MbProdGroupValueUtil.entityToEo(mbProdGroupMapper.selectByPrimaryKey(prodType, prodSubType, company));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbProdGroupEO eo) {
        MbProdGroup row = MbProdGroupValueUtil.eoToEntity(eo);
        return mbProdGroupMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbProdGroupEO eo) {
        MbProdGroup row = MbProdGroupValueUtil.eoToEntity(eo);
        return mbProdGroupMapper.updateByPrimaryKey(row);
    }
}
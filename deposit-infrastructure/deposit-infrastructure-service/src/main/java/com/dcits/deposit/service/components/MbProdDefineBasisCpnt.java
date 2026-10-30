package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbProdDefine;
import com.dcits.deposit.entity.MbProdDefineExample;
import com.dcits.deposit.facade.components.IMbProdDefineBcc;
import com.dcits.deposit.facade.eo.MbProdDefineEO;
import com.dcits.deposit.repo.MbProdDefineMapper;
import com.dcits.deposit.service.utils.MbProdDefineValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbProdDefineBasisCpnt implements IMbProdDefineBcc {
    @Autowired
    MbProdDefineMapper mbProdDefineMapper;

    @Override
    public long countByEo(MbProdDefineEO eo) {
        MbProdDefineExample example = MbProdDefineValueUtil.eoToEntityExample(eo);
        return mbProdDefineMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbProdDefineEO eo) {
        MbProdDefineExample example = MbProdDefineValueUtil.eoToEntityExample(eo);
        return mbProdDefineMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String prodNo) {
        return mbProdDefineMapper.deleteByPrimaryKey(seqNo, prodNo);
    }

    @Override
    public int create(MbProdDefineEO eo) {
        MbProdDefine row = MbProdDefineValueUtil.eoToEntity(eo);
        return mbProdDefineMapper.insert(row);
    }

    @Override
    public int createSelective(MbProdDefineEO eo) {
        MbProdDefine row = MbProdDefineValueUtil.eoToEntity(eo);
        return mbProdDefineMapper.insertSelective(row);
    }

    @Override
    public List<MbProdDefineEO> findByEo(MbProdDefineEO eo) {
        MbProdDefineExample example = MbProdDefineValueUtil.eoToEntityExample(eo);
        List<MbProdDefineEO> result = new ArrayList<>();
        List<MbProdDefine> dbResult = mbProdDefineMapper.selectByExample(example);
        for (MbProdDefine item : dbResult) {
            result.add(MbProdDefineValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbProdDefineEO findByPrimaryKey(String seqNo, String prodNo) {
        return MbProdDefineValueUtil.entityToEo(mbProdDefineMapper.selectByPrimaryKey(seqNo, prodNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbProdDefineEO eo) {
        MbProdDefine row = MbProdDefineValueUtil.eoToEntity(eo);
        return mbProdDefineMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbProdDefineEO eo) {
        MbProdDefine row = MbProdDefineValueUtil.eoToEntity(eo);
        return mbProdDefineMapper.updateByPrimaryKey(row);
    }
}
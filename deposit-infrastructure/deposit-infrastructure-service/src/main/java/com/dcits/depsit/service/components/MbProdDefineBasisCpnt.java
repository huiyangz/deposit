package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.BranchType;
import com.dcits.depsit.enums.City;
import com.dcits.depsit.enums.EventDefault;
import com.dcits.depsit.enums.HierarchyCode;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.ProfitCenter;
import com.dcits.depsit.enums.State;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.MbProdDefine;
import com.dcits.depsit.entity.MbProdDefineExample;
import com.dcits.depsit.facade.components.IMbProdDefineBcc;
import com.dcits.depsit.facade.eo.MbProdDefineEO;
import com.dcits.depsit.repo.MbProdDefineMapper;
import com.dcits.depsit.service.utils.MbProdDefineValueUtil;
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
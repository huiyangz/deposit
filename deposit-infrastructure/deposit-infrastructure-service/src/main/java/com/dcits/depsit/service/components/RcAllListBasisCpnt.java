package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.ListCategory;
import com.dcits.depsit.enums.ListOrg;
import com.dcits.depsit.enums.RcBlackStatus;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RcAllList;
import com.dcits.depsit.entity.RcAllListExample;
import com.dcits.depsit.facade.components.IRcAllListBcc;
import com.dcits.depsit.facade.eo.RcAllListEO;
import com.dcits.depsit.repo.RcAllListMapper;
import com.dcits.depsit.service.utils.RcAllListValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RcAllListBasisCpnt implements IRcAllListBcc {
    @Autowired
    RcAllListMapper rcAllListMapper;

    @Override
    public long countByEo(RcAllListEO eo) {
        RcAllListExample example = RcAllListValueUtil.eoToEntityExample(eo);
        return rcAllListMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RcAllListEO eo) {
        RcAllListExample example = RcAllListValueUtil.eoToEntityExample(eo);
        return rcAllListMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String rcSeqNo) {
        return rcAllListMapper.deleteByPrimaryKey(rcSeqNo);
    }

    @Override
    public int create(RcAllListEO eo) {
        RcAllList row = RcAllListValueUtil.eoToEntity(eo);
        return rcAllListMapper.insert(row);
    }

    @Override
    public int createSelective(RcAllListEO eo) {
        RcAllList row = RcAllListValueUtil.eoToEntity(eo);
        return rcAllListMapper.insertSelective(row);
    }

    @Override
    public List<RcAllListEO> findByEo(RcAllListEO eo) {
        RcAllListExample example = RcAllListValueUtil.eoToEntityExample(eo);
        List<RcAllListEO> result = new ArrayList<>();
        List<RcAllList> dbResult = rcAllListMapper.selectByExample(example);
        for (RcAllList item : dbResult) {
            result.add(RcAllListValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RcAllListEO findByPrimaryKey(String rcSeqNo) {
        return RcAllListValueUtil.entityToEo(rcAllListMapper.selectByPrimaryKey(rcSeqNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RcAllListEO eo) {
        RcAllList row = RcAllListValueUtil.eoToEntity(eo);
        return rcAllListMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RcAllListEO eo) {
        RcAllList row = RcAllListValueUtil.eoToEntity(eo);
        return rcAllListMapper.updateByPrimaryKey(row);
    }
}
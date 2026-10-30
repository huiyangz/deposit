package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbOdBranchInfo;
import com.dcits.deposit.entity.RbOdBranchInfoExample;
import com.dcits.deposit.facade.components.IRbOdBranchInfoBcc;
import com.dcits.deposit.facade.eo.RbOdBranchInfoEO;
import com.dcits.deposit.repo.RbOdBranchInfoMapper;
import com.dcits.deposit.service.utils.RbOdBranchInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbOdBranchInfoBasisCpnt implements IRbOdBranchInfoBcc {
    @Autowired
    RbOdBranchInfoMapper rbOdBranchInfoMapper;

    @Override
    public long countByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        return rbOdBranchInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        return rbOdBranchInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String branch) {
        return rbOdBranchInfoMapper.deleteByPrimaryKey(branch);
    }

    @Override
    public int create(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.insert(row);
    }

    @Override
    public int createSelective(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.insertSelective(row);
    }

    @Override
    public List<RbOdBranchInfoEO> findByEo(RbOdBranchInfoEO eo) {
        RbOdBranchInfoExample example = RbOdBranchInfoValueUtil.eoToEntityExample(eo);
        List<RbOdBranchInfoEO> result = new ArrayList<>();
        List<RbOdBranchInfo> dbResult = rbOdBranchInfoMapper.selectByExample(example);
        for (RbOdBranchInfo item : dbResult) {
            result.add(RbOdBranchInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbOdBranchInfoEO findByPrimaryKey(String branch) {
        return RbOdBranchInfoValueUtil.entityToEo(rbOdBranchInfoMapper.selectByPrimaryKey(branch));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbOdBranchInfoEO eo) {
        RbOdBranchInfo row = RbOdBranchInfoValueUtil.eoToEntity(eo);
        return rbOdBranchInfoMapper.updateByPrimaryKey(row);
    }

    RbOdBranchInfoEO byBranch(TranBranch branch) {
        RbOdBranchInfoEO eo = new RbOdBranchInfoEO();
        eo.setBranch(branch);
        return eo;
    }

    /**根据归属机构号查询表《机构法人透支额度信息表(RB_OD_BRANCH_INFO)》**/
    public RbOdBranchInfoEO findByBranch(TranBranch branch) {
        List<RbOdBranchInfoEO> eos = findByEo(byBranch(branch));
        return eos.isEmpty() ? null : eos.get(0);
    }
}
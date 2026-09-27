package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureClass;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbAcctNatureDef;
import com.dcits.deposit.entity.RbAcctNatureDefExample;
import com.dcits.deposit.facade.components.IRbAcctNatureDefBcc;
import com.dcits.deposit.facade.eo.RbAcctNatureDefEO;
import com.dcits.deposit.repo.RbAcctNatureDefMapper;
import com.dcits.deposit.service.utils.RbAcctNatureDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbAcctNatureDefBasisCpnt implements IRbAcctNatureDefBcc {
    @Autowired
    RbAcctNatureDefMapper rbAcctNatureDefMapper;

    @Override
    public long countByEo(RbAcctNatureDefEO eo) {
        RbAcctNatureDefExample example = RbAcctNatureDefValueUtil.eoToEntityExample(eo);
        return rbAcctNatureDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbAcctNatureDefEO eo) {
        RbAcctNatureDefExample example = RbAcctNatureDefValueUtil.eoToEntityExample(eo);
        return rbAcctNatureDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String acctNatureNo) {
        return rbAcctNatureDefMapper.deleteByPrimaryKey(acctNatureNo);
    }

    @Override
    public int create(RbAcctNatureDefEO eo) {
        RbAcctNatureDef row = RbAcctNatureDefValueUtil.eoToEntity(eo);
        return rbAcctNatureDefMapper.insert(row);
    }

    @Override
    public int createSelective(RbAcctNatureDefEO eo) {
        RbAcctNatureDef row = RbAcctNatureDefValueUtil.eoToEntity(eo);
        return rbAcctNatureDefMapper.insertSelective(row);
    }

    @Override
    public List<RbAcctNatureDefEO> findByEo(RbAcctNatureDefEO eo) {
        RbAcctNatureDefExample example = RbAcctNatureDefValueUtil.eoToEntityExample(eo);
        List<RbAcctNatureDefEO> result = new ArrayList<>();
        List<RbAcctNatureDef> dbResult = rbAcctNatureDefMapper.selectByExample(example);
        for (RbAcctNatureDef item : dbResult) {
            result.add(RbAcctNatureDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbAcctNatureDefEO findByPrimaryKey(String acctNatureNo) {
        return RbAcctNatureDefValueUtil.entityToEo(rbAcctNatureDefMapper.selectByPrimaryKey(acctNatureNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbAcctNatureDefEO eo) {
        RbAcctNatureDef row = RbAcctNatureDefValueUtil.eoToEntity(eo);
        return rbAcctNatureDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbAcctNatureDefEO eo) {
        RbAcctNatureDef row = RbAcctNatureDefValueUtil.eoToEntity(eo);
        return rbAcctNatureDefMapper.updateByPrimaryKey(row);
    }

    RbAcctNatureDefEO byAcctNatureNo(AcctNatureNo acctNatureNo) {
        RbAcctNatureDefEO eo = new RbAcctNatureDefEO();
        eo.setAcctNatureNo(acctNatureNo);
        return eo;
    }

    /**根据账户属性查询表《账户属性定义(RB_ACCT_NATURE_DEF)》**/
    public RbAcctNatureDefEO findByAcctNatureNo(AcctNatureNo acctNatureNo) {
        List<RbAcctNatureDefEO> eos = findByEo(byAcctNatureNo(acctNatureNo));
        return eos.isEmpty() ? null : eos.get(0);
    }
}
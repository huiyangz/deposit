package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.NatureClass;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.ClAcctNatureDef;
import com.dcits.deposit.entity.ClAcctNatureDefExample;
import com.dcits.deposit.facade.components.IClAcctNatureDefBcc;
import com.dcits.deposit.facade.eo.ClAcctNatureDefEO;
import com.dcits.deposit.repo.ClAcctNatureDefMapper;
import com.dcits.deposit.service.utils.ClAcctNatureDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClAcctNatureDefBasisCpnt implements IClAcctNatureDefBcc {
    @Autowired
    ClAcctNatureDefMapper clAcctNatureDefMapper;

    @Override
    public long countByEo(ClAcctNatureDefEO eo) {
        ClAcctNatureDefExample example = ClAcctNatureDefValueUtil.eoToEntityExample(eo);
        return clAcctNatureDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(ClAcctNatureDefEO eo) {
        ClAcctNatureDefExample example = ClAcctNatureDefValueUtil.eoToEntityExample(eo);
        return clAcctNatureDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String acctNature) {
        return clAcctNatureDefMapper.deleteByPrimaryKey(acctNature);
    }

    @Override
    public int create(ClAcctNatureDefEO eo) {
        ClAcctNatureDef row = ClAcctNatureDefValueUtil.eoToEntity(eo);
        return clAcctNatureDefMapper.insert(row);
    }

    @Override
    public int createSelective(ClAcctNatureDefEO eo) {
        ClAcctNatureDef row = ClAcctNatureDefValueUtil.eoToEntity(eo);
        return clAcctNatureDefMapper.insertSelective(row);
    }

    @Override
    public List<ClAcctNatureDefEO> findByEo(ClAcctNatureDefEO eo) {
        ClAcctNatureDefExample example = ClAcctNatureDefValueUtil.eoToEntityExample(eo);
        List<ClAcctNatureDefEO> result = new ArrayList<>();
        List<ClAcctNatureDef> dbResult = clAcctNatureDefMapper.selectByExample(example);
        for (ClAcctNatureDef item : dbResult) {
            result.add(ClAcctNatureDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public ClAcctNatureDefEO findByPrimaryKey(String acctNature) {
        return ClAcctNatureDefValueUtil.entityToEo(clAcctNatureDefMapper.selectByPrimaryKey(acctNature));
    }

    @Override
    public int modifyByPrimaryKeySelective(ClAcctNatureDefEO eo) {
        ClAcctNatureDef row = ClAcctNatureDefValueUtil.eoToEntity(eo);
        return clAcctNatureDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(ClAcctNatureDefEO eo) {
        ClAcctNatureDef row = ClAcctNatureDefValueUtil.eoToEntity(eo);
        return clAcctNatureDefMapper.updateByPrimaryKey(row);
    }

    ClAcctNatureDefEO byAcctNature(AcctNature acctNature) {
        ClAcctNatureDefEO eo = new ClAcctNatureDefEO();
        eo.setAcctNature(acctNature);
        return eo;
    }

    /**根据账户属性查询表《账户属性定义(CL_ACCT_NATURE_DEF)》**/
    public ClAcctNatureDefEO findByAcctNature(AcctNature acctNature) {
        List<ClAcctNatureDefEO> eos = findByEo(byAcctNature(acctNature));
        return eos.isEmpty() ? null : eos.get(0);
    }
}
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntBasis;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbIntBasis;
import com.dcits.deposit.entity.MbIntBasisExample;
import com.dcits.deposit.facade.components.IMbIntBasisBcc;
import com.dcits.deposit.facade.eo.MbIntBasisEO;
import com.dcits.deposit.repo.MbIntBasisMapper;
import com.dcits.deposit.service.utils.MbIntBasisValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbIntBasisBasisCpnt implements IMbIntBasisBcc {
    @Autowired
    MbIntBasisMapper mbIntBasisMapper;

    @Override
    public long countByEo(MbIntBasisEO eo) {
        MbIntBasisExample example = MbIntBasisValueUtil.eoToEntityExample(eo);
        return mbIntBasisMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbIntBasisEO eo) {
        MbIntBasisExample example = MbIntBasisValueUtil.eoToEntityExample(eo);
        return mbIntBasisMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String intBasis) {
        return mbIntBasisMapper.deleteByPrimaryKey(intBasis);
    }

    @Override
    public int create(MbIntBasisEO eo) {
        MbIntBasis row = MbIntBasisValueUtil.eoToEntity(eo);
        return mbIntBasisMapper.insert(row);
    }

    @Override
    public int createSelective(MbIntBasisEO eo) {
        MbIntBasis row = MbIntBasisValueUtil.eoToEntity(eo);
        return mbIntBasisMapper.insertSelective(row);
    }

    @Override
    public List<MbIntBasisEO> findByEo(MbIntBasisEO eo) {
        MbIntBasisExample example = MbIntBasisValueUtil.eoToEntityExample(eo);
        List<MbIntBasisEO> result = new ArrayList<>();
        List<MbIntBasis> dbResult = mbIntBasisMapper.selectByExample(example);
        for (MbIntBasis item : dbResult) {
            result.add(MbIntBasisValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbIntBasisEO findByPrimaryKey(String intBasis) {
        return MbIntBasisValueUtil.entityToEo(mbIntBasisMapper.selectByPrimaryKey(intBasis));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbIntBasisEO eo) {
        MbIntBasis row = MbIntBasisValueUtil.eoToEntity(eo);
        return mbIntBasisMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbIntBasisEO eo) {
        MbIntBasis row = MbIntBasisValueUtil.eoToEntity(eo);
        return mbIntBasisMapper.updateByPrimaryKey(row);
    }

    MbIntBasisEO byIntBasis(IntBasis intBasis) {
        MbIntBasisEO eo = new MbIntBasisEO();
        eo.setIntBasis(intBasis);
        return eo;
    }

    /**根据基准利率类型查询表《基准利率类型表(MB_INT_BASIS)》**/
    public MbIntBasisEO findByIntBasis(IntBasis intBasis) {
        List<MbIntBasisEO> eos = findByEo(byIntBasis(intBasis));
        return eos.isEmpty() ? null : eos.get(0);
    }
}
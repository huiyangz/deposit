package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTranHistBook;
import com.dcits.deposit.entity.RbTranHistBookExample;
import com.dcits.deposit.facade.components.IRbTranHistBookBcc;
import com.dcits.deposit.facade.eo.RbTranHistBookEO;
import com.dcits.deposit.repo.RbTranHistBookMapper;
import com.dcits.deposit.service.utils.RbTranHistBookValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTranHistBookBasisCpnt implements IRbTranHistBookBcc {
    @Autowired
    RbTranHistBookMapper rbTranHistBookMapper;

    @Override
    public long countByEo(RbTranHistBookEO eo) {
        RbTranHistBookExample example = RbTranHistBookValueUtil.eoToEntityExample(eo);
        return rbTranHistBookMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTranHistBookEO eo) {
        RbTranHistBookExample example = RbTranHistBookValueUtil.eoToEntityExample(eo);
        return rbTranHistBookMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String seqNo, String clientNo) {
        return rbTranHistBookMapper.deleteByPrimaryKey(seqNo, clientNo);
    }

    @Override
    public int create(RbTranHistBookEO eo) {
        RbTranHistBook row = RbTranHistBookValueUtil.eoToEntity(eo);
        return rbTranHistBookMapper.insert(row);
    }

    @Override
    public int createSelective(RbTranHistBookEO eo) {
        RbTranHistBook row = RbTranHistBookValueUtil.eoToEntity(eo);
        return rbTranHistBookMapper.insertSelective(row);
    }

    @Override
    public List<RbTranHistBookEO> findByEo(RbTranHistBookEO eo) {
        RbTranHistBookExample example = RbTranHistBookValueUtil.eoToEntityExample(eo);
        List<RbTranHistBookEO> result = new ArrayList<>();
        List<RbTranHistBook> dbResult = rbTranHistBookMapper.selectByExample(example);
        for (RbTranHistBook item : dbResult) {
            result.add(RbTranHistBookValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTranHistBookEO findByPrimaryKey(String seqNo, String clientNo) {
        return RbTranHistBookValueUtil.entityToEo(rbTranHistBookMapper.selectByPrimaryKey(seqNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTranHistBookEO eo) {
        RbTranHistBook row = RbTranHistBookValueUtil.eoToEntity(eo);
        return rbTranHistBookMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTranHistBookEO eo) {
        RbTranHistBook row = RbTranHistBookValueUtil.eoToEntity(eo);
        return rbTranHistBookMapper.updateByPrimaryKey(row);
    }
}
package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.ApprType;
import com.dcits.depsit.enums.FundSource;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusApprLetter;
import com.dcits.depsit.entity.RbBusApprLetterExample;
import com.dcits.depsit.facade.components.IRbBusApprLetterBcc;
import com.dcits.depsit.facade.eo.RbBusApprLetterEO;
import com.dcits.depsit.repo.RbBusApprLetterMapper;
import com.dcits.depsit.service.utils.RbBusApprLetterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusApprLetterBasisCpnt implements IRbBusApprLetterBcc {
    @Autowired
    RbBusApprLetterMapper rbBusApprLetterMapper;

    @Override
    public long countByEo(RbBusApprLetterEO eo) {
        RbBusApprLetterExample example = RbBusApprLetterValueUtil.eoToEntityExample(eo);
        return rbBusApprLetterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusApprLetterEO eo) {
        RbBusApprLetterExample example = RbBusApprLetterValueUtil.eoToEntityExample(eo);
        return rbBusApprLetterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String apprLetterNo, String clientNo) {
        return rbBusApprLetterMapper.deleteByPrimaryKey(apprLetterNo, clientNo);
    }

    @Override
    public int create(RbBusApprLetterEO eo) {
        RbBusApprLetter row = RbBusApprLetterValueUtil.eoToEntity(eo);
        return rbBusApprLetterMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusApprLetterEO eo) {
        RbBusApprLetter row = RbBusApprLetterValueUtil.eoToEntity(eo);
        return rbBusApprLetterMapper.insertSelective(row);
    }

    @Override
    public List<RbBusApprLetterEO> findByEo(RbBusApprLetterEO eo) {
        RbBusApprLetterExample example = RbBusApprLetterValueUtil.eoToEntityExample(eo);
        List<RbBusApprLetterEO> result = new ArrayList<>();
        List<RbBusApprLetter> dbResult = rbBusApprLetterMapper.selectByExample(example);
        for (RbBusApprLetter item : dbResult) {
            result.add(RbBusApprLetterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusApprLetterEO findByPrimaryKey(String apprLetterNo, String clientNo) {
        return RbBusApprLetterValueUtil.entityToEo(rbBusApprLetterMapper.selectByPrimaryKey(apprLetterNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusApprLetterEO eo) {
        RbBusApprLetter row = RbBusApprLetterValueUtil.eoToEntity(eo);
        return rbBusApprLetterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusApprLetterEO eo) {
        RbBusApprLetter row = RbBusApprLetterValueUtil.eoToEntity(eo);
        return rbBusApprLetterMapper.updateByPrimaryKey(row);
    }
}
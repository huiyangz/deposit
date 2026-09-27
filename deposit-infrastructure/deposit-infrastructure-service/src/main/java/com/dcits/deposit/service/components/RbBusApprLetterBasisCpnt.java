package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusApprLetter;
import com.dcits.deposit.entity.RbBusApprLetterExample;
import com.dcits.deposit.facade.components.IRbBusApprLetterBcc;
import com.dcits.deposit.facade.eo.RbBusApprLetterEO;
import com.dcits.deposit.repo.RbBusApprLetterMapper;
import com.dcits.deposit.service.utils.RbBusApprLetterValueUtil;
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
package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BillBusiType;
import com.dcits.deposit.enums.BillIssueType;
import com.dcits.deposit.enums.BillPaymentStatus;
import com.dcits.deposit.enums.BillStatus;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.ReturnType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBillRegister;
import com.dcits.deposit.entity.RbBillRegisterExample;
import com.dcits.deposit.facade.components.IRbBillRegisterBcc;
import com.dcits.deposit.facade.eo.RbBillRegisterEO;
import com.dcits.deposit.repo.RbBillRegisterMapper;
import com.dcits.deposit.service.utils.RbBillRegisterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBillRegisterBasisCpnt implements IRbBillRegisterBcc {
    @Autowired
    RbBillRegisterMapper rbBillRegisterMapper;

    @Override
    public long countByEo(RbBillRegisterEO eo) {
        RbBillRegisterExample example = RbBillRegisterValueUtil.eoToEntityExample(eo);
        return rbBillRegisterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBillRegisterEO eo) {
        RbBillRegisterExample example = RbBillRegisterValueUtil.eoToEntityExample(eo);
        return rbBillRegisterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String billSerialNo, String clientNo) {
        return rbBillRegisterMapper.deleteByPrimaryKey(billSerialNo, clientNo);
    }

    @Override
    public int create(RbBillRegisterEO eo) {
        RbBillRegister row = RbBillRegisterValueUtil.eoToEntity(eo);
        return rbBillRegisterMapper.insert(row);
    }

    @Override
    public int createSelective(RbBillRegisterEO eo) {
        RbBillRegister row = RbBillRegisterValueUtil.eoToEntity(eo);
        return rbBillRegisterMapper.insertSelective(row);
    }

    @Override
    public List<RbBillRegisterEO> findByEo(RbBillRegisterEO eo) {
        RbBillRegisterExample example = RbBillRegisterValueUtil.eoToEntityExample(eo);
        List<RbBillRegisterEO> result = new ArrayList<>();
        List<RbBillRegister> dbResult = rbBillRegisterMapper.selectByExample(example);
        for (RbBillRegister item : dbResult) {
            result.add(RbBillRegisterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBillRegisterEO findByPrimaryKey(String billSerialNo, String clientNo) {
        return RbBillRegisterValueUtil.entityToEo(rbBillRegisterMapper.selectByPrimaryKey(billSerialNo, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBillRegisterEO eo) {
        RbBillRegister row = RbBillRegisterValueUtil.eoToEntity(eo);
        return rbBillRegisterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBillRegisterEO eo) {
        RbBillRegister row = RbBillRegisterValueUtil.eoToEntity(eo);
        return rbBillRegisterMapper.updateByPrimaryKey(row);
    }
}
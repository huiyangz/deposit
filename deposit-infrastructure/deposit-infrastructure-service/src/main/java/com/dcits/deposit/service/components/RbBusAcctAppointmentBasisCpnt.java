package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AppointmentStatus;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusAcctAppointment;
import com.dcits.deposit.entity.RbBusAcctAppointmentExample;
import com.dcits.deposit.facade.components.IRbBusAcctAppointmentBcc;
import com.dcits.deposit.facade.eo.RbBusAcctAppointmentEO;
import com.dcits.deposit.repo.RbBusAcctAppointmentMapper;
import com.dcits.deposit.service.utils.RbBusAcctAppointmentValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAcctAppointmentBasisCpnt implements IRbBusAcctAppointmentBcc {
    @Autowired
    RbBusAcctAppointmentMapper rbBusAcctAppointmentMapper;

    @Override
    public long countByEo(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointmentExample example = RbBusAcctAppointmentValueUtil.eoToEntityExample(eo);
        return rbBusAcctAppointmentMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointmentExample example = RbBusAcctAppointmentValueUtil.eoToEntityExample(eo);
        return rbBusAcctAppointmentMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String orderNo) {
        return rbBusAcctAppointmentMapper.deleteByPrimaryKey(orderNo);
    }

    @Override
    public int create(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointment row = RbBusAcctAppointmentValueUtil.eoToEntity(eo);
        return rbBusAcctAppointmentMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointment row = RbBusAcctAppointmentValueUtil.eoToEntity(eo);
        return rbBusAcctAppointmentMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAcctAppointmentEO> findByEo(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointmentExample example = RbBusAcctAppointmentValueUtil.eoToEntityExample(eo);
        List<RbBusAcctAppointmentEO> result = new ArrayList<>();
        List<RbBusAcctAppointment> dbResult = rbBusAcctAppointmentMapper.selectByExample(example);
        for (RbBusAcctAppointment item : dbResult) {
            result.add(RbBusAcctAppointmentValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAcctAppointmentEO findByPrimaryKey(String orderNo) {
        return RbBusAcctAppointmentValueUtil.entityToEo(rbBusAcctAppointmentMapper.selectByPrimaryKey(orderNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointment row = RbBusAcctAppointmentValueUtil.eoToEntity(eo);
        return rbBusAcctAppointmentMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAcctAppointmentEO eo) {
        RbBusAcctAppointment row = RbBusAcctAppointmentValueUtil.eoToEntity(eo);
        return rbBusAcctAppointmentMapper.updateByPrimaryKey(row);
    }
}
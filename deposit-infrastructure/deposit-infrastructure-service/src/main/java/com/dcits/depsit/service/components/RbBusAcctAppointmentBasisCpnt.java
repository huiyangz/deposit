package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.AppointmentStatus;
import com.dcits.depsit.enums.CategoryType;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.RbAcctType;
import com.dcits.depsit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusAcctAppointment;
import com.dcits.depsit.entity.RbBusAcctAppointmentExample;
import com.dcits.depsit.facade.components.IRbBusAcctAppointmentBcc;
import com.dcits.depsit.facade.eo.RbBusAcctAppointmentEO;
import com.dcits.depsit.repo.RbBusAcctAppointmentMapper;
import com.dcits.depsit.service.utils.RbBusAcctAppointmentValueUtil;
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
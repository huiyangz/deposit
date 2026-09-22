package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ContactClass;
import com.dcits.deposit.enums.ContactType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LinkmanType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbContactList;
import com.dcits.deposit.entity.RbContactListExample;
import com.dcits.deposit.facade.components.IRbContactListBcc;
import com.dcits.deposit.facade.eo.RbContactListEO;
import com.dcits.deposit.repo.RbContactListMapper;
import com.dcits.deposit.service.utils.RbContactListValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbContactListBasisCpnt implements IRbContactListBcc {
    @Autowired
    RbContactListMapper rbContactListMapper;

    @Override
    public long countByEo(RbContactListEO eo) {
        RbContactListExample example = RbContactListValueUtil.eoToEntityExample(eo);
        return rbContactListMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbContactListEO eo) {
        RbContactListExample example = RbContactListValueUtil.eoToEntityExample(eo);
        return rbContactListMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String linkmanType, String phoneNo1, String clientNo) {
        return rbContactListMapper.deleteByPrimaryKey(internalKey, linkmanType, phoneNo1, clientNo);
    }

    @Override
    public int create(RbContactListEO eo) {
        RbContactList row = RbContactListValueUtil.eoToEntity(eo);
        return rbContactListMapper.insert(row);
    }

    @Override
    public int createSelective(RbContactListEO eo) {
        RbContactList row = RbContactListValueUtil.eoToEntity(eo);
        return rbContactListMapper.insertSelective(row);
    }

    @Override
    public List<RbContactListEO> findByEo(RbContactListEO eo) {
        RbContactListExample example = RbContactListValueUtil.eoToEntityExample(eo);
        List<RbContactListEO> result = new ArrayList<>();
        List<RbContactList> dbResult = rbContactListMapper.selectByExample(example);
        for (RbContactList item : dbResult) {
            result.add(RbContactListValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbContactListEO findByPrimaryKey(Integer internalKey, String linkmanType, String phoneNo1, String clientNo) {
        return RbContactListValueUtil.entityToEo(rbContactListMapper.selectByPrimaryKey(internalKey, linkmanType, phoneNo1, clientNo));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbContactListEO eo) {
        RbContactList row = RbContactListValueUtil.eoToEntity(eo);
        return rbContactListMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbContactListEO eo) {
        RbContactList row = RbContactListValueUtil.eoToEntity(eo);
        return rbContactListMapper.updateByPrimaryKey(row);
    }
}
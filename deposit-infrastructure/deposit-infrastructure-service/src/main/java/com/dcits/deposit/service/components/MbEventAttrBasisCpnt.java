package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.MbEventAttr;
import com.dcits.deposit.entity.MbEventAttrExample;
import com.dcits.deposit.facade.components.IMbEventAttrBcc;
import com.dcits.deposit.facade.eo.MbEventAttrEO;
import com.dcits.deposit.repo.MbEventAttrMapper;
import com.dcits.deposit.service.utils.MbEventAttrValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MbEventAttrBasisCpnt implements IMbEventAttrBcc {
    @Autowired
    MbEventAttrMapper mbEventAttrMapper;

    @Override
    public long countByEo(MbEventAttrEO eo) {
        MbEventAttrExample example = MbEventAttrValueUtil.eoToEntityExample(eo);
        return mbEventAttrMapper.countByExample(example);
    }

    @Override
    public int removeByEo(MbEventAttrEO eo) {
        MbEventAttrExample example = MbEventAttrValueUtil.eoToEntityExample(eo);
        return mbEventAttrMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String eventType, String seqNo, String company) {
        return mbEventAttrMapper.deleteByPrimaryKey(eventType, seqNo, company);
    }

    @Override
    public int create(MbEventAttrEO eo) {
        MbEventAttr row = MbEventAttrValueUtil.eoToEntity(eo);
        return mbEventAttrMapper.insert(row);
    }

    @Override
    public int createSelective(MbEventAttrEO eo) {
        MbEventAttr row = MbEventAttrValueUtil.eoToEntity(eo);
        return mbEventAttrMapper.insertSelective(row);
    }

    @Override
    public List<MbEventAttrEO> findByEo(MbEventAttrEO eo) {
        MbEventAttrExample example = MbEventAttrValueUtil.eoToEntityExample(eo);
        List<MbEventAttrEO> result = new ArrayList<>();
        List<MbEventAttr> dbResult = mbEventAttrMapper.selectByExample(example);
        for (MbEventAttr item : dbResult) {
            result.add(MbEventAttrValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public MbEventAttrEO findByPrimaryKey(String eventType, String seqNo, String company) {
        return MbEventAttrValueUtil.entityToEo(mbEventAttrMapper.selectByPrimaryKey(eventType, seqNo, company));
    }

    @Override
    public int modifyByPrimaryKeySelective(MbEventAttrEO eo) {
        MbEventAttr row = MbEventAttrValueUtil.eoToEntity(eo);
        return mbEventAttrMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(MbEventAttrEO eo) {
        MbEventAttr row = MbEventAttrValueUtil.eoToEntity(eo);
        return mbEventAttrMapper.updateByPrimaryKey(row);
    }
}
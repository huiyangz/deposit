package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.TailboxProperty;
import com.dcits.deposit.enums.TailboxStatus;
import com.dcits.deposit.enums.TailboxSubType;
import com.dcits.deposit.enums.TailboxType;
import com.dcits.deposit.enums.TellerBindType;
import com.dcits.deposit.enums.TranBranch;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.TbTailbox;
import com.dcits.deposit.entity.TbTailboxExample;
import com.dcits.deposit.facade.components.ITbTailboxBcc;
import com.dcits.deposit.facade.eo.TbTailboxEO;
import com.dcits.deposit.repo.TbTailboxMapper;
import com.dcits.deposit.service.utils.TbTailboxValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbTailboxBasisCpnt implements ITbTailboxBcc {
    @Autowired
    TbTailboxMapper tbTailboxMapper;

    @Override
    public long countByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        return tbTailboxMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        return tbTailboxMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String tailboxId) {
        return tbTailboxMapper.deleteByPrimaryKey(tailboxId);
    }

    @Override
    public int create(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.insert(row);
    }

    @Override
    public int createSelective(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.insertSelective(row);
    }

    @Override
    public List<TbTailboxEO> findByEo(TbTailboxEO eo) {
        TbTailboxExample example = TbTailboxValueUtil.eoToEntityExample(eo);
        List<TbTailboxEO> result = new ArrayList<>();
        List<TbTailbox> dbResult = tbTailboxMapper.selectByExample(example);
        for (TbTailbox item : dbResult) {
            result.add(TbTailboxValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbTailboxEO findByPrimaryKey(String tailboxId) {
        return TbTailboxValueUtil.entityToEo(tbTailboxMapper.selectByPrimaryKey(tailboxId));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbTailboxEO eo) {
        TbTailbox row = TbTailboxValueUtil.eoToEntity(eo);
        return tbTailboxMapper.updateByPrimaryKey(row);
    }
}
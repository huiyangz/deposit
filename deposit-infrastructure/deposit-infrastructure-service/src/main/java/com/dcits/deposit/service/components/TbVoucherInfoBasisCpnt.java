package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.TbVoucherInfo;
import com.dcits.deposit.entity.TbVoucherInfoExample;
import com.dcits.deposit.facade.components.ITbVoucherInfoBcc;
import com.dcits.deposit.facade.eo.TbVoucherInfoEO;
import com.dcits.deposit.repo.TbVoucherInfoMapper;
import com.dcits.deposit.service.utils.TbVoucherInfoValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbVoucherInfoBasisCpnt implements ITbVoucherInfoBcc {
    @Autowired
    TbVoucherInfoMapper tbVoucherInfoMapper;

    @Override
    public long countByEo(TbVoucherInfoEO eo) {
        TbVoucherInfoExample example = TbVoucherInfoValueUtil.eoToEntityExample(eo);
        return tbVoucherInfoMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbVoucherInfoEO eo) {
        TbVoucherInfoExample example = TbVoucherInfoValueUtil.eoToEntityExample(eo);
        return tbVoucherInfoMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer voucherId) {
        return tbVoucherInfoMapper.deleteByPrimaryKey(voucherId);
    }

    @Override
    public int create(TbVoucherInfoEO eo) {
        TbVoucherInfo row = TbVoucherInfoValueUtil.eoToEntity(eo);
        return tbVoucherInfoMapper.insert(row);
    }

    @Override
    public int createSelective(TbVoucherInfoEO eo) {
        TbVoucherInfo row = TbVoucherInfoValueUtil.eoToEntity(eo);
        return tbVoucherInfoMapper.insertSelective(row);
    }

    @Override
    public List<TbVoucherInfoEO> findByEo(TbVoucherInfoEO eo) {
        TbVoucherInfoExample example = TbVoucherInfoValueUtil.eoToEntityExample(eo);
        List<TbVoucherInfoEO> result = new ArrayList<>();
        List<TbVoucherInfo> dbResult = tbVoucherInfoMapper.selectByExample(example);
        for (TbVoucherInfo item : dbResult) {
            result.add(TbVoucherInfoValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbVoucherInfoEO findByPrimaryKey(Integer voucherId) {
        return TbVoucherInfoValueUtil.entityToEo(tbVoucherInfoMapper.selectByPrimaryKey(voucherId));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbVoucherInfoEO eo) {
        TbVoucherInfo row = TbVoucherInfoValueUtil.eoToEntity(eo);
        return tbVoucherInfoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbVoucherInfoEO eo) {
        TbVoucherInfo row = TbVoucherInfoValueUtil.eoToEntity(eo);
        return tbVoucherInfoMapper.updateByPrimaryKey(row);
    }
}
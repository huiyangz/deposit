package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.DepositType;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.ProfitCenter;
import com.dcits.depsit.enums.SaleFlag;
import com.dcits.depsit.enums.VoucherApproveStatus;
import com.dcits.depsit.enums.VoucherBillInd;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.TbVoucherDef;
import com.dcits.depsit.entity.TbVoucherDefExample;
import com.dcits.depsit.facade.components.ITbVoucherDefBcc;
import com.dcits.depsit.facade.eo.TbVoucherDefEO;
import com.dcits.depsit.repo.TbVoucherDefMapper;
import com.dcits.depsit.service.utils.TbVoucherDefValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TbVoucherDefBasisCpnt implements ITbVoucherDefBcc {
    @Autowired
    TbVoucherDefMapper tbVoucherDefMapper;

    @Override
    public long countByEo(TbVoucherDefEO eo) {
        TbVoucherDefExample example = TbVoucherDefValueUtil.eoToEntityExample(eo);
        return tbVoucherDefMapper.countByExample(example);
    }

    @Override
    public int removeByEo(TbVoucherDefEO eo) {
        TbVoucherDefExample example = TbVoucherDefValueUtil.eoToEntityExample(eo);
        return tbVoucherDefMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String docType) {
        return tbVoucherDefMapper.deleteByPrimaryKey(docType);
    }

    @Override
    public int create(TbVoucherDefEO eo) {
        TbVoucherDef row = TbVoucherDefValueUtil.eoToEntity(eo);
        return tbVoucherDefMapper.insert(row);
    }

    @Override
    public int createSelective(TbVoucherDefEO eo) {
        TbVoucherDef row = TbVoucherDefValueUtil.eoToEntity(eo);
        return tbVoucherDefMapper.insertSelective(row);
    }

    @Override
    public List<TbVoucherDefEO> findByEo(TbVoucherDefEO eo) {
        TbVoucherDefExample example = TbVoucherDefValueUtil.eoToEntityExample(eo);
        List<TbVoucherDefEO> result = new ArrayList<>();
        List<TbVoucherDef> dbResult = tbVoucherDefMapper.selectByExample(example);
        for (TbVoucherDef item : dbResult) {
            result.add(TbVoucherDefValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public TbVoucherDefEO findByPrimaryKey(String docType) {
        return TbVoucherDefValueUtil.entityToEo(tbVoucherDefMapper.selectByPrimaryKey(docType));
    }

    @Override
    public int modifyByPrimaryKeySelective(TbVoucherDefEO eo) {
        TbVoucherDef row = TbVoucherDefValueUtil.eoToEntity(eo);
        return tbVoucherDefMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(TbVoucherDefEO eo) {
        TbVoucherDef row = TbVoucherDefValueUtil.eoToEntity(eo);
        return tbVoucherDefMapper.updateByPrimaryKey(row);
    }

    TbVoucherDefEO byDocType(DocType docType) {
        TbVoucherDefEO eo = new TbVoucherDefEO();
        eo.setDocType(docType);
        return eo;
    }

    /**根据凭证类型查询表《凭证类型定义表(TB_VOUCHER_DEF)》**/
    public TbVoucherDefEO findByDocType(DocType docType) {
        List<TbVoucherDefEO> eos = findByEo(byDocType(docType));
        return eos.isEmpty() ? null : eos.get(0);
    }
}
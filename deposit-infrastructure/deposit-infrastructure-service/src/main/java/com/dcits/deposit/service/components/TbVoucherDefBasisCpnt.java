package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.SaleFlag;
import com.dcits.deposit.enums.VoucherApproveStatus;
import com.dcits.deposit.enums.VoucherBillInd;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.TbVoucherDef;
import com.dcits.deposit.entity.TbVoucherDefExample;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;
import com.dcits.deposit.repo.TbVoucherDefMapper;
import com.dcits.deposit.service.utils.TbVoucherDefValueUtil;
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
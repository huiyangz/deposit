package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbVoucherInfo;
import com.dcits.deposit.entity.TbVoucherInfoExample;
import com.dcits.deposit.facade.eo.TbVoucherInfoEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class TbVoucherInfoValueUtil {
    private TbVoucherInfoValueUtil() {
    }

    public static TbVoucherInfoEO entityToEo(TbVoucherInfo entity) {
        if (entity == null) {
            return null;
        }
        TbVoucherInfoEO eo = new TbVoucherInfoEO();
        eo.setVoucherId(entity.getVoucherId());
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setTailboxId(entity.getTailboxId());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setPrefix(entity.getPrefix());
        eo.setVoucherStartNo(entity.getVoucherStartNo());
        eo.setVoucherEndNo(entity.getVoucherEndNo());
        eo.setStartNoInt(entity.getStartNoInt());
        eo.setEndNoInt(entity.getEndNoInt());
        eo.setVoucherSum(entity.getVoucherSum());
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        eo.setEopdVoucherSum(entity.getEopdVoucherSum());
        eo.setSopdVoucherSum(entity.getSopdVoucherSum());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setTranAmt(entity.getTranAmt());
        eo.setRemark(entity.getRemark());
        eo.setLastUserId(entity.getLastUserId());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static TbVoucherInfo eoToEntity(TbVoucherInfoEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherInfo entity = new TbVoucherInfo();
        entity.setVoucherId(eo.getVoucherId());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setTailboxId(eo.getTailboxId());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setPrefix(eo.getPrefix());
        entity.setVoucherStartNo(eo.getVoucherStartNo());
        entity.setVoucherEndNo(eo.getVoucherEndNo());
        entity.setStartNoInt(eo.getStartNoInt());
        entity.setEndNoInt(eo.getEndNoInt());
        entity.setVoucherSum(eo.getVoucherSum());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        entity.setEopdVoucherSum(eo.getEopdVoucherSum());
        entity.setSopdVoucherSum(eo.getSopdVoucherSum());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setTranAmt(eo.getTranAmt());
        entity.setRemark(eo.getRemark());
        entity.setLastUserId(eo.getLastUserId());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static TbVoucherInfoExample eoToEntityExample(TbVoucherInfoEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherInfoExample example = new TbVoucherInfoExample();
        TbVoucherInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getVoucherId() != null) criteria.andVoucherIdEqualTo(eo.getVoucherId());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getVoucherStartNo() != null) criteria.andVoucherStartNoEqualTo(eo.getVoucherStartNo());
        if (eo.getVoucherEndNo() != null) criteria.andVoucherEndNoEqualTo(eo.getVoucherEndNo());
        if (eo.getStartNoInt() != null) criteria.andStartNoIntEqualTo(eo.getStartNoInt());
        if (eo.getEndNoInt() != null) criteria.andEndNoIntEqualTo(eo.getEndNoInt());
        if (eo.getVoucherSum() != null) criteria.andVoucherSumEqualTo(eo.getVoucherSum());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        if (eo.getEopdVoucherSum() != null) criteria.andEopdVoucherSumEqualTo(eo.getEopdVoucherSum());
        if (eo.getSopdVoucherSum() != null) criteria.andSopdVoucherSumEqualTo(eo.getSopdVoucherSum());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getLastUserId() != null) criteria.andLastUserIdEqualTo(eo.getLastUserId());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}
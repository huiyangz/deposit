package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbCcyRate;
import com.dcits.deposit.entity.MbCcyRateExample;
import com.dcits.deposit.facade.eo.MbCcyRateEO;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.Company;

public final class MbCcyRateValueUtil {
    private MbCcyRateValueUtil() {
    }

    public static MbCcyRateEO entityToEo(MbCcyRate entity) {
        if (entity == null) {
            return null;
        }
        MbCcyRateEO eo = new MbCcyRateEO();
        eo.setRateType(RateType.byValue(entity.getRateType()));
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setQuoteType(QuoteType.byValue(entity.getQuoteType()));
        eo.setExchBuyRate(entity.getExchBuyRate());
        eo.setExchSellRate(entity.getExchSellRate());
        eo.setMiddleRate(entity.getMiddleRate());
        eo.setNotesBuyRate(entity.getNotesBuyRate());
        eo.setNotesSellRate(entity.getNotesSellRate());
        eo.setMaxFloatRateUp(entity.getMaxFloatRateUp());
        eo.setMaxFloatRateDown(entity.getMaxFloatRateDown());
        eo.setCentralBankRate(entity.getCentralBankRate());
        eo.setEffectDate(entity.getEffectDate());
        eo.setEffectTime(entity.getEffectTime());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static MbCcyRate eoToEntity(MbCcyRateEO eo) {
        if (eo == null) {
            return null;
        }
        MbCcyRate entity = new MbCcyRate();
        entity.setRateType(eo.getRateType() == null ? null : eo.getRateType().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setQuoteType(eo.getQuoteType() == null ? null : eo.getQuoteType().getValue());
        entity.setExchBuyRate(eo.getExchBuyRate());
        entity.setExchSellRate(eo.getExchSellRate());
        entity.setMiddleRate(eo.getMiddleRate());
        entity.setNotesBuyRate(eo.getNotesBuyRate());
        entity.setNotesSellRate(eo.getNotesSellRate());
        entity.setMaxFloatRateUp(eo.getMaxFloatRateUp());
        entity.setMaxFloatRateDown(eo.getMaxFloatRateDown());
        entity.setCentralBankRate(eo.getCentralBankRate());
        entity.setEffectDate(eo.getEffectDate());
        entity.setEffectTime(eo.getEffectTime());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static MbCcyRateExample eoToEntityExample(MbCcyRateEO eo) {
        if (eo == null) {
            return null;
        }
        MbCcyRateExample example = new MbCcyRateExample();
        MbCcyRateExample.Criteria criteria = example.createCriteria();
        if (eo.getRateType() != null) criteria.andRateTypeEqualTo(eo.getRateType().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getQuoteType() != null) criteria.andQuoteTypeEqualTo(eo.getQuoteType().getValue());
        if (eo.getExchBuyRate() != null) criteria.andExchBuyRateEqualTo(eo.getExchBuyRate());
        if (eo.getExchSellRate() != null) criteria.andExchSellRateEqualTo(eo.getExchSellRate());
        if (eo.getMiddleRate() != null) criteria.andMiddleRateEqualTo(eo.getMiddleRate());
        if (eo.getNotesBuyRate() != null) criteria.andNotesBuyRateEqualTo(eo.getNotesBuyRate());
        if (eo.getNotesSellRate() != null) criteria.andNotesSellRateEqualTo(eo.getNotesSellRate());
        if (eo.getMaxFloatRateUp() != null) criteria.andMaxFloatRateUpEqualTo(eo.getMaxFloatRateUp());
        if (eo.getMaxFloatRateDown() != null) criteria.andMaxFloatRateDownEqualTo(eo.getMaxFloatRateDown());
        if (eo.getCentralBankRate() != null) criteria.andCentralBankRateEqualTo(eo.getCentralBankRate());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getEffectTime() != null) criteria.andEffectTimeEqualTo(eo.getEffectTime());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}
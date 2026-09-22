package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RcRuleType;
import com.dcits.deposit.entity.RcRuleTypeExample;
import com.dcits.deposit.facade.eo.RcRuleTypeEO;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.ResOperateFlag;
import com.dcits.deposit.enums.LimitRef;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.IndividualFlag;

public final class RcRuleTypeValueUtil {
    private RcRuleTypeValueUtil() {
    }

    public static RcRuleTypeEO entityToEo(RcRuleType entity) {
        if (entity == null) {
            return null;
        }
        RcRuleTypeEO eo = new RcRuleTypeEO();
        eo.setRuleId(entity.getRuleId());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setRuleDesc(entity.getRuleDesc());
        eo.setDealFlow(DealFlow.byValue(entity.getDealFlow()));
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTerm(entity.getTerm());
        eo.setResAllFlag(IndividualFlag.byValue(entity.getResAllFlag()));
        eo.setOthTerm(entity.getOthTerm());
        eo.setOthTermType(TermType.byValue(entity.getOthTermType()));
        eo.setCardMedium(entity.getCardMedium());
        eo.setResOperateFlag(ResOperateFlag.byValue(entity.getResOperateFlag()));
        eo.setLimitRef(LimitRef.byValue(entity.getLimitRef()));
        eo.setOthRestraintType(RestraintType.byValue(entity.getOthRestraintType()));
        eo.setResBranchRange(LimitBranchRange.byValue(entity.getResBranchRange()));
        eo.setControlType(ControlType.byValue(entity.getControlType()));
        eo.setOthDelayTerm(entity.getOthDelayTerm());
        eo.setOthDelayTermType(TermType.byValue(entity.getOthDelayTermType()));
        eo.setOthControlType(ControlType.byValue(entity.getOthControlType()));
        eo.setRelVerifyFlag(IndividualFlag.byValue(entity.getRelVerifyFlag()));
        return eo;
    }

    public static RcRuleType eoToEntity(RcRuleTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RcRuleType entity = new RcRuleType();
        entity.setRuleId(eo.getRuleId());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setRuleDesc(eo.getRuleDesc());
        entity.setDealFlow(eo.getDealFlow() == null ? null : eo.getDealFlow().getValue());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTerm(eo.getTerm());
        entity.setResAllFlag(eo.getResAllFlag() == null ? null : eo.getResAllFlag().getValue());
        entity.setOthTerm(eo.getOthTerm());
        entity.setOthTermType(eo.getOthTermType() == null ? null : eo.getOthTermType().getValue());
        entity.setCardMedium(eo.getCardMedium());
        entity.setResOperateFlag(eo.getResOperateFlag() == null ? null : eo.getResOperateFlag().getValue());
        entity.setLimitRef(eo.getLimitRef() == null ? null : eo.getLimitRef().getValue());
        entity.setOthRestraintType(eo.getOthRestraintType() == null ? null : eo.getOthRestraintType().getValue());
        entity.setResBranchRange(eo.getResBranchRange() == null ? null : eo.getResBranchRange().getValue());
        entity.setControlType(eo.getControlType() == null ? null : eo.getControlType().getValue());
        entity.setOthDelayTerm(eo.getOthDelayTerm());
        entity.setOthDelayTermType(eo.getOthDelayTermType() == null ? null : eo.getOthDelayTermType().getValue());
        entity.setOthControlType(eo.getOthControlType() == null ? null : eo.getOthControlType().getValue());
        entity.setRelVerifyFlag(eo.getRelVerifyFlag() == null ? null : eo.getRelVerifyFlag().getValue());
        return entity;
    }

    public static RcRuleTypeExample eoToEntityExample(RcRuleTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RcRuleTypeExample example = new RcRuleTypeExample();
        RcRuleTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getRuleDesc() != null) criteria.andRuleDescEqualTo(eo.getRuleDesc());
        if (eo.getDealFlow() != null) criteria.andDealFlowEqualTo(eo.getDealFlow().getValue());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getResAllFlag() != null) criteria.andResAllFlagEqualTo(eo.getResAllFlag().getValue());
        if (eo.getOthTerm() != null) criteria.andOthTermEqualTo(eo.getOthTerm());
        if (eo.getOthTermType() != null) criteria.andOthTermTypeEqualTo(eo.getOthTermType().getValue());
        if (eo.getCardMedium() != null) criteria.andCardMediumEqualTo(eo.getCardMedium());
        if (eo.getResOperateFlag() != null) criteria.andResOperateFlagEqualTo(eo.getResOperateFlag().getValue());
        if (eo.getLimitRef() != null) criteria.andLimitRefEqualTo(eo.getLimitRef().getValue());
        if (eo.getOthRestraintType() != null) criteria.andOthRestraintTypeEqualTo(eo.getOthRestraintType().getValue());
        if (eo.getResBranchRange() != null) criteria.andResBranchRangeEqualTo(eo.getResBranchRange().getValue());
        if (eo.getControlType() != null) criteria.andControlTypeEqualTo(eo.getControlType().getValue());
        if (eo.getOthDelayTerm() != null) criteria.andOthDelayTermEqualTo(eo.getOthDelayTerm());
        if (eo.getOthDelayTermType() != null) criteria.andOthDelayTermTypeEqualTo(eo.getOthDelayTermType().getValue());
        if (eo.getOthControlType() != null) criteria.andOthControlTypeEqualTo(eo.getOthControlType().getValue());
        if (eo.getRelVerifyFlag() != null) criteria.andRelVerifyFlagEqualTo(eo.getRelVerifyFlag().getValue());
        return example;
    }
}
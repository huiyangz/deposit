package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.PtPaymentTranHist;
import com.dcits.deposit.entity.PtPaymentTranHistExample;
import com.dcits.deposit.facade.eo.PtPaymentTranHistEO;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Direction;
import com.dcits.deposit.enums.AcglFlag;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.AcctPaymentStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.Company;

public final class PtPaymentTranHistValueUtil {
    private PtPaymentTranHistValueUtil() {
    }

    public static PtPaymentTranHistEO entityToEo(PtPaymentTranHist entity) {
        if (entity == null) {
            return null;
        }
        PtPaymentTranHistEO eo = new PtPaymentTranHistEO();
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setChannelSubSeqNo(entity.getChannelSubSeqNo());
        eo.setChannel(SourceType.byValue(entity.getChannel()));
        eo.setReference(entity.getReference());
        eo.setPtOperateType(entity.getPtOperateType());
        eo.setDirection(Direction.byValue(entity.getDirection()));
        eo.setAcglFlag(AcglFlag.byValue(entity.getAcglFlag()));
        eo.setSettleStep(entity.getSettleStep());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setSeqNo(entity.getSeqNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctName(entity.getAcctName());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setBillType(BillType.byValue(entity.getBillType()));
        eo.setBillNo(entity.getBillNo());
        eo.setTranAmt(entity.getTranAmt());
        eo.setFeeAmt(entity.getFeeAmt());
        eo.setOthBankCode(entity.getOthBankCode());
        eo.setOthBankName(entity.getOthBankName());
        eo.setContraBaseAcctNo(entity.getContraBaseAcctNo());
        eo.setContraAcctName(entity.getContraAcctName());
        eo.setSettleNo(entity.getSettleNo());
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setTrustedPayNo(entity.getTrustedPayNo());
        eo.setOrigReference(entity.getOrigReference());
        eo.setCollateDate(entity.getCollateDate());
        eo.setAcctPaymentStatus(AcctPaymentStatus.byValue(entity.getAcctPaymentStatus()));
        eo.setEntrySuccessFlag(IndividualFlag.byValue(entity.getEntrySuccessFlag()));
        eo.setHangStatus(HangStatus.byValue(entity.getHangStatus()));
        eo.setRetCode(entity.getRetCode());
        eo.setRetMsg(entity.getRetMsg());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCollateBatchNo(entity.getCollateBatchNo());
        eo.setHangSeqNo(entity.getHangSeqNo());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static PtPaymentTranHist eoToEntity(PtPaymentTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        PtPaymentTranHist entity = new PtPaymentTranHist();
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setChannelSubSeqNo(eo.getChannelSubSeqNo());
        entity.setChannel(eo.getChannel() == null ? null : eo.getChannel().getValue());
        entity.setReference(eo.getReference());
        entity.setPtOperateType(eo.getPtOperateType());
        entity.setDirection(eo.getDirection() == null ? null : eo.getDirection().getValue());
        entity.setAcglFlag(eo.getAcglFlag() == null ? null : eo.getAcglFlag().getValue());
        entity.setSettleStep(eo.getSettleStep());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setSeqNo(eo.getSeqNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctName(eo.getAcctName());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setBillType(eo.getBillType() == null ? null : eo.getBillType().getValue());
        entity.setBillNo(eo.getBillNo());
        entity.setTranAmt(eo.getTranAmt());
        entity.setFeeAmt(eo.getFeeAmt());
        entity.setOthBankCode(eo.getOthBankCode());
        entity.setOthBankName(eo.getOthBankName());
        entity.setContraBaseAcctNo(eo.getContraBaseAcctNo());
        entity.setContraAcctName(eo.getContraAcctName());
        entity.setSettleNo(eo.getSettleNo());
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setTrustedPayNo(eo.getTrustedPayNo());
        entity.setOrigReference(eo.getOrigReference());
        entity.setCollateDate(eo.getCollateDate());
        entity.setAcctPaymentStatus(eo.getAcctPaymentStatus() == null ? null : eo.getAcctPaymentStatus().getValue());
        entity.setEntrySuccessFlag(eo.getEntrySuccessFlag() == null ? null : eo.getEntrySuccessFlag().getValue());
        entity.setHangStatus(eo.getHangStatus() == null ? null : eo.getHangStatus().getValue());
        entity.setRetCode(eo.getRetCode());
        entity.setRetMsg(eo.getRetMsg());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCollateBatchNo(eo.getCollateBatchNo());
        entity.setHangSeqNo(eo.getHangSeqNo());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static PtPaymentTranHistExample eoToEntityExample(PtPaymentTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        PtPaymentTranHistExample example = new PtPaymentTranHistExample();
        PtPaymentTranHistExample.Criteria criteria = example.createCriteria();
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getChannelSubSeqNo() != null) criteria.andChannelSubSeqNoEqualTo(eo.getChannelSubSeqNo());
        if (eo.getChannel() != null) criteria.andChannelEqualTo(eo.getChannel().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getPtOperateType() != null) criteria.andPtOperateTypeEqualTo(eo.getPtOperateType());
        if (eo.getDirection() != null) criteria.andDirectionEqualTo(eo.getDirection().getValue());
        if (eo.getAcglFlag() != null) criteria.andAcglFlagEqualTo(eo.getAcglFlag().getValue());
        if (eo.getSettleStep() != null) criteria.andSettleStepEqualTo(eo.getSettleStep());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getBillType() != null) criteria.andBillTypeEqualTo(eo.getBillType().getValue());
        if (eo.getBillNo() != null) criteria.andBillNoEqualTo(eo.getBillNo());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getFeeAmt() != null) criteria.andFeeAmtEqualTo(eo.getFeeAmt());
        if (eo.getOthBankCode() != null) criteria.andOthBankCodeEqualTo(eo.getOthBankCode());
        if (eo.getOthBankName() != null) criteria.andOthBankNameEqualTo(eo.getOthBankName());
        if (eo.getContraBaseAcctNo() != null) criteria.andContraBaseAcctNoEqualTo(eo.getContraBaseAcctNo());
        if (eo.getContraAcctName() != null) criteria.andContraAcctNameEqualTo(eo.getContraAcctName());
        if (eo.getSettleNo() != null) criteria.andSettleNoEqualTo(eo.getSettleNo());
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getTrustedPayNo() != null) criteria.andTrustedPayNoEqualTo(eo.getTrustedPayNo());
        if (eo.getOrigReference() != null) criteria.andOrigReferenceEqualTo(eo.getOrigReference());
        if (eo.getCollateDate() != null) criteria.andCollateDateEqualTo(eo.getCollateDate());
        if (eo.getAcctPaymentStatus() != null) criteria.andAcctPaymentStatusEqualTo(eo.getAcctPaymentStatus().getValue());
        if (eo.getEntrySuccessFlag() != null) criteria.andEntrySuccessFlagEqualTo(eo.getEntrySuccessFlag().getValue());
        if (eo.getHangStatus() != null) criteria.andHangStatusEqualTo(eo.getHangStatus().getValue());
        if (eo.getRetCode() != null) criteria.andRetCodeEqualTo(eo.getRetCode());
        if (eo.getRetMsg() != null) criteria.andRetMsgEqualTo(eo.getRetMsg());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCollateBatchNo() != null) criteria.andCollateBatchNoEqualTo(eo.getCollateBatchNo());
        if (eo.getHangSeqNo() != null) criteria.andHangSeqNoEqualTo(eo.getHangSeqNo());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}
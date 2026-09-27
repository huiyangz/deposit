package com.dcits.deposit.step;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST046 登记账户信息 步骤实现
 *
 * 步骤描述：
 * 1.登记账户辅助信息：登记允许账户转久悬标志、监管账户标志、年检标志、简易账户标志、农户标志、
 *   允许出售支票标志、归属条线名称、客户经理工号、客户经理名称、推介人编号、推介人名称；
 *   若监管账户标志为"是"，登记监管账户类型、监管原因；若查证类型为"对资金类业务查证"，登记查证金额。
 * 2.登记账户基本信息：登记客户号、客户账号、账户币种、产品类型、账户开立行行号、账户开户日期、
 *   账户状态、账户类型、通存标志、通兑标志、账户属性、计息标志、核准件编号、生效日期、开户许可证编号，
 *   账户内部键值由系统根据账号生成，创建时间戳与最后修改时间戳为当前系统时间。
 *
 * 两个子步骤登记的字段共同构成一条对公存款账户主表（RB_BUS_ACCT）记录，经 createSelective 写入。
 * 按已接受的需求处理结论：查证类型无条件补登记（主表必填且输出需要来源）；账户内部键值生成机制
 * 未在 SPEC 中定义，本实现按账号确定性派生（hashCode），待需求方明确正式机制后替换。
 * 实体必填字段 ftaAcctFlag、osaFlag 不在本步骤登记范围，未发明取值。
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST046Pbc implements IST046 {

    private final IRbBusAcctBcc rbBusAcctBcc;

    public ST046Pbc(IRbBusAcctBcc rbBusAcctBcc) {
        this.rbBusAcctBcc = rbBusAcctBcc;
    }

    /**
     * {@inheritDoc}
     *
     * 事务要求：新增本地对公存款账户主表（RB_BUS_ACCT）记录，方法内开启 Spring 声明式事务。
     */
    @Override
    @Transactional
    public ST046OutputBO execute(ST046InputBO input) {
        RbBusAcctEO busAcct = new RbBusAcctEO();

        // 子步骤1 登记账户辅助信息
        registerAuxiliaryInfo(input, busAcct);
        // 子步骤2 登记账户基本信息
        registerBasicInfo(input, busAcct);

        // 两个子步骤的字段共同构成一条 RB_BUS_ACCT 记录，按非空属性写入
        rbBusAcctBcc.createSelective(busAcct);

        ST046OutputBO output = buildOutput(busAcct);
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1 登记账户辅助信息：11 项无条件登记；监管账户标志为"是"时登记监管账户类型与监管原因；
     * 查证类型为"对资金类业务查证"时登记查证金额；查证类型按已接受的需求处理结论无条件补登记。
     */
    private void registerAuxiliaryInfo(ST046InputBO input, RbBusAcctEO busAcct) {
        busAcct.setAllowSuspendFlag(input.getAllowSuspendFlag());
        busAcct.setManageFlag(input.getManageFlag());
        busAcct.setAnnualFlag(input.getAnnualFlag());
        busAcct.setSimpleAcct(input.getSimpleAcct());
        busAcct.setFarmerFlag(input.getFarmerFlag());
        busAcct.setIsSellCheque(input.getIsSellCheque());
        busAcct.setLineOwnerShip(input.getLineOwnerShip());
        busAcct.setAcctExecCode(input.getAcctExecCode());
        busAcct.setAcctExecName(input.getAcctExecName());
        busAcct.setPromoterCode(input.getPromoterCode());
        busAcct.setPromoterName(input.getPromoterName());
        // 若{监管账户标志}等于"是"，则登记监管账户类型、监管原因
        if ("是".equals(input.getManageFlag())) {
            busAcct.setManageType(input.getManageType());
            busAcct.setManageContent(input.getManageContent());
        }
        // 若{查证类型}等于"对资金类业务查证"，则登记查证金额
        if (CheckCertificateType.VALUE_03.equals(input.getCheckCertificateType())) {
            busAcct.setCheckCertificateAmt(input.getCheckCertificateAmt());
        }
        // 查证类型无条件补登记：主表必填且输出需要来源（已接受的需求处理结论）
        busAcct.setCheckCertificateType(input.getCheckCertificateType());
    }

    /**
     * 子步骤2 登记账户基本信息：账户内部键值由系统根据账号生成（机制未定义，按账号确定性派生），
     * 创建时间戳与最后修改时间戳为当前系统时间。
     */
    private void registerBasicInfo(ST046InputBO input, RbBusAcctEO busAcct) {
        busAcct.setInternalKey(input.getBaseAcctNo().hashCode());
        busAcct.setClientNo(input.getClientNo());
        busAcct.setBaseAcctNo(input.getBaseAcctNo());
        busAcct.setAcctCcy(input.getAcctCcy());
        busAcct.setProdNo(input.getProdNo());
        busAcct.setAcctBranch(input.getTranBranch());
        busAcct.setAcctOpenDate(input.getAcctOpenDate());
        busAcct.setAcctStatus(input.getAcctStatus());
        busAcct.setRbAcctType(input.getRbAcctType());
        busAcct.setAllDepInd(input.getAllDepInd());
        busAcct.setAllDraInd(input.getAllDraInd());
        busAcct.setAcctNatureNo(input.getAcctNatureNo());
        String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        busAcct.setCreateTimestamp(now);
        busAcct.setLastUpdTimestamp(now);
        busAcct.setIntIndFlag(input.getIntIndFlag());
        busAcct.setApprLetterNo(input.getApprLetterNo());
        busAcct.setEffectDate(input.getEffectDate());
        busAcct.setAcctLicenseNo(input.getAcctLicenseNo());
    }

    /**
     * 按输出表回显已登记的对公存款账户主表信息（来源实体 RB_BUS_ACCT），未登记的字段保持 null。
     */
    private ST046OutputBO buildOutput(RbBusAcctEO busAcct) {
        ST046OutputBO output = new ST046OutputBO();
        output.setAllowSuspendFlag(busAcct.getAllowSuspendFlag());
        output.setManageFlag(busAcct.getManageFlag());
        output.setManageContent(busAcct.getManageContent());
        output.setManageType(busAcct.getManageType());
        output.setAnnualFlag(busAcct.getAnnualFlag());
        output.setSimpleAcct(busAcct.getSimpleAcct());
        output.setFarmerFlag(busAcct.getFarmerFlag());
        output.setIsSellCheque(busAcct.getIsSellCheque());
        output.setLineOwnerShip(busAcct.getLineOwnerShip());
        output.setAcctExecName(busAcct.getAcctExecName());
        output.setAcctExecCode(busAcct.getAcctExecCode());
        output.setPromoterName(busAcct.getPromoterName());
        output.setPromoterCode(busAcct.getPromoterCode());
        output.setCheckCertificateAmt(busAcct.getCheckCertificateAmt());
        output.setCheckCertificateType(busAcct.getCheckCertificateType());
        output.setClientNo(busAcct.getClientNo());
        output.setBaseAcctNo(busAcct.getBaseAcctNo());
        output.setProdNo(busAcct.getProdNo());
        output.setAcctCcy(busAcct.getAcctCcy());
        output.setAcctOpenDate(busAcct.getAcctOpenDate());
        output.setEffectDate(busAcct.getEffectDate());
        output.setAcctStatus(busAcct.getAcctStatus());
        output.setRbAcctType(busAcct.getRbAcctType());
        output.setAcctNatureNo(busAcct.getAcctNatureNo());
        output.setAllDraInd(busAcct.getAllDraInd());
        output.setAllDepInd(busAcct.getAllDepInd());
        output.setAcctLicenseNo(busAcct.getAcctLicenseNo());
        output.setIntIndFlag(busAcct.getIntIndFlag());
        output.setApprLetterNo(busAcct.getApprLetterNo());
        return output;
    }
}

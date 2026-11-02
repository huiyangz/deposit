package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ST002 检查账户到期日 步骤实现。
 *
 * <p>子步骤1（获取账户到期日）：根据账号（baseAcctNo）从对公存款账户主表（RB_BUS_ACCT）
 * 获取账户到期日期（acctDueDate）并作为输出提供（Spec 步骤描述 条目 1 / REQ-002）。</p>
 * <p>子步骤2（检查账户到期日）：账户到期日期小于交易日期（tranDate）时判定账户已过期，
 * 返回业务失败 ER0054；不小于交易日期（含相等边界）时检查结果为"通过"，步骤正常完成
 * （Spec 步骤描述 条目 2 / REQ-003、REQ-004）。</p>
 */
@Service
public class ST002Pbc implements IST002 {

    /** 错误码：账户已过期（errorcodes.properties：ER0054=账户已过期） */
    private static final String ERROR_CODE_ACCT_EXPIRED = "ER0054";
    /** 错误信息：错误码::业务说明（Spec 错误码与步骤结果契约） */
    private static final String ERROR_MESSAGE_ACCT_EXPIRED = "ER0054::账户已过期";

    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST002OutputBO execute(ST002InputBO input) {
        ST002OutputBO output = new ST002OutputBO();

        // 子步骤1（获取账户到期日）：按账号获取对公存款账户主表记录，取账户到期日期作为输出。
        // baseAcctNo 与 tranDate 为必填（REQ-001）；缺失时"不得继续执行检查"的返回契约未定义，
        // 当前不设置校验失败返回，缺失分支的实际结果未确认，见下方 REQ-001 输入缺失 FIXME。
        // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求声明 baseAcctNo 与 tranDate 缺失时"不得继续执行检查"，但缺失时的返回契约（失败状态/错误码/异常）未定义（REQ-001 输入缺失分支） - 影响:输入缺失分支无已确认失败处理，当前按正常入参路径自然执行，不臆造校验失败返回 - 待确认:输入缺失时应返回的失败状态/错误码/异常
        RbBusAcctEO rbBusAcct = queryRbBusAcct(input.getBaseAcctNo());
        if (rbBusAcct != null) {
            output.setAcctDueDate(rbBusAcct.getAcctDueDate());
        }

        // 子步骤2（检查账户到期日）：账户到期日期小于交易日期时判定账户过期并返回 ER0054；
        // 不小于交易日期（含相等边界）时检查结果为"通过"，步骤正常完成。
        if (output.getAcctDueDate() == null) {
            // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:账户到期日期 acctDueDate 标记非必填可为 null，null 时与交易日期比较的结果（判定通过/失败）未定义（Spec TBD-3） - 影响:空到期日分支无已确认比较结果，当前按"通过"占位，不作为已确认业务行为 - 待确认:acctDueDate 为 null 时应判定通过还是失败
            // 占位返回：账户到期日期为空（含主表无记录未取到到期日期的情况）时比较结果未确认，
            // 此处返回值仅用于满足返回要求，不作为已确认业务行为；待 TBD-2/TBD-3 确认后按确认结果实现。
            output.setSucceed(true);
            return output;
        }
        if (output.getAcctDueDate().before(input.getTranDate())) {
            // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:日期比较口径未确认——按自然日（仅比较日期部分）还是按 java.util.Date 完整时分秒值比较（Spec TBD-5） - 影响:同日不同时刻的到期日期与交易日期比较结果未定义；已确认场景均以日级午夜值编写，本实现按完整 Date 值比较 - 待确认:日期比较口径（自然日/完整时分秒）
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_EXPIRED);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_EXPIRED);
            return output;
        }

        // 检查结果为"通过"：按公共成功状态表达（succeed=true、错误字段为 null）。
        // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表仅声明 acctDueDate，未声明承载"检查结果为'通过'"的业务输出字段，"通过"是否另有业务输出字段承载未确认（Spec TBD-4） - 影响:若"通过"应另有业务输出字段承载，当前 OutputBO 缺少该字段 - 待确认:"通过"是否另有业务输出字段承载，字段名与取值
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1（获取账户到期日）的数据访问：按账号获取对公存款账户主表记录。
     *
     * @param baseAcctNo 账号
     * @return 对公存款账户主表记录；无对应记录时返回 null
     */
    private RbBusAcctEO queryRbBusAcct(String baseAcctNo) {
        // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:由账号 baseAcctNo 定位对公存款账户主表（RB_BUS_ACCT）记录的具体查询路径未确认；主表主键为 clientNo+internalKey，RbBusAcctEO 无账号字段，候选需经对公客户账户表（RB_BUS_CLIENT_ACCT）取得关联键后查询主表（Spec TBD-1） - 影响:当前实现对已确认数据源 IRbBusAcctBcc 以空查询条件 EO 调用 findByEo 作占位绑定，入参未携带 baseAcctNo 条件，查询路径与请求字段映射待确认后调整 - 待确认:按账号获取主表记录的具体查询方法/路径及请求字段映射
        RbBusAcctEO query = new RbBusAcctEO();
        List<RbBusAcctEO> accts = rbBusAcctBcc.findByEo(query);
        if (accts == null || accts.isEmpty()) {
            // FIXME 业务项:ST002/检查账户到期日 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:账号 baseAcctNo 在对公存款账户主表无对应记录时的行为未定义（Spec TBD-2） - 影响:无记录分支无已确认失败条件与返回，不推断为查询无记录即业务失败，当前按"未取到账户到期日期"（null）继续日期比较 - 待确认:主表无记录时应返回的结果（通过/失败/其他）及失败条件
            return null;
        }
        // 面向单条结果的查询，多条统一取结果集第一条（本项目约定）。
        return accts.get(0);
    }
}

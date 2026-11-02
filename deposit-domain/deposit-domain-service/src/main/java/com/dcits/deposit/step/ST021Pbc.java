package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST021 检查支取账户类型 步骤实现。
 *
 * <p>步骤1（获取账户类型）：以必填输入 baseAcctNo（账号）为查询条件，经对公存款账户
 * 主表（RB_BUS_ACCT）数据服务 {@link IRbBusAcctBcc} 查询账户信息，取得存款账户类型。</p>
 *
 * <p>步骤2（检查账户类型）：账户类型既非 T（定期账户）且非 A（AIO账户）时检查通过
 * （succeed=true，错误字段为空，输出 rbAcctType）；账户类型为 T 或 A 时业务失败
 * （succeed=false，errorCode=ER0052，errorMessage 按「错误码::业务说明」格式）。</p>
 */
@Service
public class ST021Pbc implements IST021 {

    /** 对公存款账户主表（RB_BUS_ACCT）数据服务 */
    @Autowired
    private IRbBusAcctBcc irbBusAcctBcc;

    @Override
    public ST021OutputBO execute(ST021InputBO input) {
        ST021OutputBO output = new ST021OutputBO();

        // 步骤1（获取账户类型）：按 baseAcctNo 查询【账户信息】（对公存款账户主表）取得账户类型
        RbBusAcctEO queryEo = new RbBusAcctEO();
        // FIXME 业务项:ST021/检查支取账户类型 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求步骤1按{账号}baseAcctNo 查询【账户信息】取得账户类型，但对公存款账户主表（RB_BUS_ACCT）实体 RbBusAcctEO 无账号字段（主键为客户号+账户内部键值；账号字段实际存在于对公客户账户表 RbBusClientAcctEO），baseAcctNo 到查询 EO 的定位字段映射未定义（Spec「依赖核对」注明步骤实现所需查询接口尚未生成、具体查询方法及定位字段待实现阶段确认） - 影响:当前按候选字段 cardNo 携带 baseAcctNo 定位，若真实映射不符则查询结果为空或定位错误 - 待确认:baseAcctNo 应对应对公存款账户主表哪个定位字段（是否 cardNo），或是否需先经对公客户账户表取客户号后按主键查询
        queryEo.setCardNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = irbBusAcctBcc.findByEo(queryEo);

        // 单条结果查询返回多条时按统一约定取结果集第一条，先判空再取值
        RbBusAcctEO acct = null;
        if (!acctList.isEmpty()) {
            acct = acctList.get(0);
        }
        if (acct == null || acct.getRbAcctType() == null) {
            // FIXME 业务项:ST021/检查支取账户类型 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按 baseAcctNo 查询账户信息无记录，或账户的存款账户类型字段为空/不在枚举代码值 A/C/S/T 范围内时，需求未定义行为（Spec TBD-3，是否视为检查不通过、返回哪个错误码或按其它规则处理） - 影响:这些情形当前返回未决结果（succeed=false、错误字段与 rbAcctType 均为空），不构成已确认的检查结论 - 待确认:查询无记录/账户类型为空时应返回通过、失败或其它结果
            return output;
        }

        // 步骤2（检查账户类型）：既非 T 且非 A → 通过；T 或 A → 返回错误码 ER0052
        if (acct.getRbAcctType() == RbAcctType.T || acct.getRbAcctType() == RbAcctType.A) {
            output.setSucceed(false);
            output.setErrorCode("ER0052");
            output.setErrorMessage("ER0052::当前账户不为活期账户");
        } else {
            output.setSucceed(true);
            output.setRbAcctType(acct.getRbAcctType());
        }
        return output;
    }
}

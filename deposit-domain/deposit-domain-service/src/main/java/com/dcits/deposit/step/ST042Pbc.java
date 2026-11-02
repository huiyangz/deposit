package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST042 获取累计限额 步骤实现。
 *
 * <p>以必填输入限额场景编码（limitSceneNo）与账号（baseAcctNo）为查询条件，经
 * {@link IRbLimitSumInfoBcc#findByPrimaryKey} 查询限额累计信息表（RB_LIMIT_SUM_INFO），
 * 命中记录时输出该记录的限额累计金额（limitSumAmt）与限额累计笔数，同时输出客户号（clientNo）
 * 与限额场景编码（limitSceneNo）；记录对应列为空时相应输出为空。本步骤无已确认的业务失败条件
 * （Spec「依赖核对」），正常完成时 succeed=true 且错误字段为空。</p>
 */
@Service
public class ST042Pbc implements IST042 {

    /** 限额累计信息表访问组件 */
    @Autowired
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @Override
    public ST042OutputBO execute(ST042InputBO input) {
        ST042OutputBO output = new ST042OutputBO();
        // FIXME 业务项:ST042/获取累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求以「{账号}」为查询条件之一，未声明其对应限额累计信息表（RB_LIMIT_SUM_INFO）的哪个字段（Spec 待确认事项 1）；当前按工程候选将 baseAcctNo 置于主键参数位 checkObjVal，必填输入 clientNo 在本步骤中的作用（查询条件/校验依据/仅透传输出）亦未确认 - 影响:确认映射后须复核查询方法（findByPrimaryKey 或 findByEo）、参数位及 clientNo 是否参与查询条件，用例查询桩随之调整 - 待确认:账号是否直接作为 checkObjVal 参与查询；检查对象类型为 CUST 时是否改以 clientNo 查询；clientNo 在本步骤中的作用
        RbLimitSumInfoEO limitSumInfo = rbLimitSumInfoBcc.findByPrimaryKey(input.getBaseAcctNo(), input.getLimitSceneNo());
        if (limitSumInfo != null) {
            output.setClientNo(limitSumInfo.getClientNo());
            output.setLimitSceneNo(limitSumInfo.getLimitSceneNo());
            output.setLimitSumAmt(limitSumInfo.getLimitSumAmt());
            output.set否(limitSumInfo.get否());
        }
        // FIXME 业务项:ST042/获取累计限额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按 limitSceneNo 与 baseAcctNo 查询限额累计信息表无匹配记录（findByPrimaryKey 返回 null）时需求未定义行为（Spec 待确认事项 3，按 0 处理继续或返回业务错误及错误码均未定义），确认前不新增失败场景、不生成临时错误码 - 影响:无匹配记录时当前按无业务输出返回成功结束，最终行为待业务确认 - 待确认:无匹配记录时按限额累计金额/笔数为 0 继续、返回业务错误及错误码，还是其他处理
        // FIXME 业务项:ST042/获取累计限额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入 baseAcctNo、clientNo、limitSceneNo 任一缺失或为空时需求未定义处理（Spec 待确认事项 4，是否校验报错、错误码及失败结果未定义），本实现不新增校验失败场景 - 影响:缺失或为空的输入当前直接参与查询，最终校验行为待确认 - 待确认:任一必填输入缺失或为空时是否校验报错、错误码及失败结果
        output.setSucceed(true);
        return output;
    }
}

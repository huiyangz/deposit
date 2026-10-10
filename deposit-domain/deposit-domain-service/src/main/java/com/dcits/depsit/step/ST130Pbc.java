package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST130InputBO;
import com.dcits.depsit.facade.bo.ST130OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST130 登记账户限制信息 步骤实现。
 *
 * <p>依据正式 Spec REQ-002：把「## 输入」表中与步骤描述列举信息对应的 6 个字段
 * （{账号}→{@code baseAcctNo}、{限制类型}→{@code restraintType}、{开始日期}→{@code startDate}、
 * {结束日期}→{@code endDate}、{限制期限}→{@code term}、{限制期限类型}→{@code termType}）
 * 作为一条账户限制信息登记到【对公存款账户限制表（RB_BUS_RESTRAINTS）】。写入取值与输入逐一对应，
 * 不换算、不舍入、不截断、不格式化，也不把枚举代码转换为中文文本；单次调用只登记这一条记录，
 * 不查询、不更新、不删除登记簿中的其它记录（REQ-002-S02）。</p>
 *
 * <p>登记对象按本 Spec 已确定有来源的 6 个字段构造；{系统日期} 的取值来源与落列、以及
 * 限制编号、账户内部键值、渠道流水号、渠道日期、创建/最后修改时间戳、法人等不可为空列的来源
 * 源需求均未写明且已按需求处理流程放行，本实现不为其补出取值，也不写占位或默认值
 * （Spec「验收范围与明确不覆盖的事项」第 1、2 项），因此采用只写入非空属性的选择性登记写入。</p>
 *
 * <p>{@code tranDate}（交易日期）与 {@code runDate}（核心运行日期）源需求未写明用途与落库列，
 * 本实现只按「## 输入」表接收，不据其写入或判断（Spec 第 4 项）。本步骤未定义业务校验、
 * 拒件分支或业务错误码，执行正常完成即 {@code succeed=true}、错误字段保持 {@code null}；
 * 失败仅由技术异常按工程既有方式传播（REQ-005）。</p>
 */
@Service
public class ST130Pbc implements IST130 {

    /** 实体表【对公存款账户限制表(RB_BUS_RESTRAINTS)】数据服务接口 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /**
     * 执行登记账户限制信息。
     *
     * @param input 「## 输入」表的 8 个字段
     * @return 登记结果；成功时 {@code succeed=true}、{@code errorCode} 与 {@code errorMessage} 均为
     *         {@code null}
     */
    @Override
    @Transactional
    public ST130OutputBO execute(ST130InputBO input) {
        ST130OutputBO output = new ST130OutputBO();

        // 「## 步骤描述」1：登记账户的【限制信息】，包括{账号},{限制类型},{系统日期},{结束日期},
        // {限制期限},{限制期限类型},{开始日期}
        // 登记落点＝【对公存款账户限制表(RB_BUS_RESTRAINTS)】；登记内容＝正文列举且存在输入对应的 6 项，
        // 逐项按输入原值写入，不作换算、截断、格式化或枚举代码转文本
        RbBusRestraintsEO registerEo = new RbBusRestraintsEO();
        registerEo.setBaseAcctNo(input.getBaseAcctNo());
        registerEo.setRestraintType(input.getRestraintType());
        registerEo.setStartDate(input.getStartDate());
        registerEo.setEndDate(input.getEndDate());
        registerEo.setTerm(input.getTerm());
        registerEo.setTermType(input.getTermType());

        // 只登记这一条记录：选择性写入本次有来源的字段，不查询、不更新、不删除登记簿中的其它记录
        rbBusRestraintsBcc.createSelective(registerEo);

        // 「## 失败处理」声明本步骤无业务失败场景，正常完成即成功，无业务输出字段，错误字段保持 null
        output.setSucceed(true);
        return output;
    }
}

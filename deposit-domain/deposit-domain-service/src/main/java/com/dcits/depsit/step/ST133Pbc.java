package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST133InputBO;
import com.dcits.depsit.facade.bo.ST133OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST133 登记账户限制登记簿 步骤实现。
 *
 * <p>依据正式 Spec REQ-002：「## 输入」表的 14 个字段作为一条记录登记到账户限制登记簿
 * 【对公存款账户限制表（RB_BUS_RESTRAINTS）】，登记内容覆盖步骤描述第 5 行列出的六类信息
 * （{限制编号}、{限制金额}、{开始日期}、{结束日期}、{执法人信息}、{法律文书}）。写入的字段名与取值
 * 与输入逐一对应，不改写输入值：不做单位换算、舍入、截断、归一化、格式化，也不把证件类型枚举代码
 * 转换为中文文本或其它码值。限制编号 {@code resSeqNo} 写入该表主键列 RES_SEQ_NO。</p>
 *
 * <p>单次调用只登记这一条记录，不查询登记簿既有记录，不更新或删除任何记录，也不改写账户、凭证或
 * 其它业务数据（REQ-001-S02、REQ-002-S02）；「## 输入」表以外的登记簿列（如 {@code restraintType}、
 * {@code internalKey}、{@code company}、{@code tranDate}、{@code channelSeqNo}、时间戳等）的取值来源
 * 已按需求处理流程放行，本实现不为其填补默认值或占位值（Spec「验收范围与明确不覆盖的事项」第 1、2、7 项）。</p>
 *
 * <p>登记成功后输出 14 个字段承载本次已登记的值（REQ-003）。本步骤无业务失败场景
 * （Spec「## 失败处理」），执行正常完成即设置 {@code succeed=true} 并保持错误字段为 {@code null}；
 * 技术失败由工程既有方式以上抛异常表达，本实现不吞异常、不转换为业务失败结果、不以默认值兜底
 * （REQ-005）。</p>
 */
@Service
public class ST133Pbc implements IST133 {

    /** 实体表【对公存款账户限制表(RB_BUS_RESTRAINTS)】数据服务接口 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /**
     * 执行登记账户限制登记簿。
     *
     * @param input 「## 输入」表的 14 个登记字段
     * @return 登记结果；成功时 {@code succeed=true}、错误字段为 {@code null}，
     *         且 14 个输出字段承载本次已登记的值
     */
    @Override
    @Transactional
    public ST133OutputBO execute(ST133InputBO input) {
        ST133OutputBO output = new ST133OutputBO();

        // 「## 步骤描述」1：登记账户限制登记簿，包括{限制编号}，{限制金额}，{开始日期}，{结束日期}，
        // {执法人信息}，{法律文书}——14 个输入字段作为一条记录写入【对公存款账户限制表】
        RbBusRestraintsEO registerEo = new RbBusRestraintsEO();
        // {限制编号}：登记记录标识，写入主键列 RES_SEQ_NO
        registerEo.setResSeqNo(input.getResSeqNo());
        // {限制金额}：原值写入，不换算、不舍入
        registerEo.setPledgedAmt(input.getPledgedAmt());
        // {开始日期}：原值写入，不截断、不归一化
        registerEo.setStartDate(input.getStartDate());
        // {结束日期}：原值写入，不截断、不归一化
        registerEo.setEndDate(input.getEndDate());
        // {执法人信息}：4 个证件类型（枚举常量，按代码值登记）与 4 个证件号码（字符串原值）
        registerEo.setJudiciaryDocumentType(input.getJudiciaryDocumentType());
        registerEo.setJudiciaryDocumentType2(input.getJudiciaryDocumentType2());
        registerEo.setJudiciaryOthDocumentType(input.getJudiciaryOthDocumentType());
        registerEo.setJudiciaryOthDocumentType2(input.getJudiciaryOthDocumentType2());
        registerEo.setJudiciaryDocumentId(input.getJudiciaryDocumentId());
        registerEo.setJudiciaryDocumentId2(input.getJudiciaryDocumentId2());
        registerEo.setJudiciaryOthDocumentId(input.getJudiciaryOthDocumentId());
        registerEo.setJudiciaryOthDocumentId2(input.getJudiciaryOthDocumentId2());
        // {法律文书}：有权机关名称与扣划法律文书号
        registerEo.setDeductionJudiciaryName(input.getDeductionJudiciaryName());
        registerEo.setDeductionLawNo(input.getDeductionLawNo());

        // 仅新增本次这一条记录，不查询、不更新、不删除既有记录
        rbBusRestraintsBcc.createSelective(registerEo);

        // REQ-003：输出 14 个字段承载本次登记到登记簿的取值
        output.setResSeqNo(registerEo.getResSeqNo());
        output.setPledgedAmt(registerEo.getPledgedAmt());
        output.setStartDate(registerEo.getStartDate());
        output.setEndDate(registerEo.getEndDate());
        output.setJudiciaryDocumentType(registerEo.getJudiciaryDocumentType());
        output.setJudiciaryDocumentType2(registerEo.getJudiciaryDocumentType2());
        output.setJudiciaryOthDocumentType(registerEo.getJudiciaryOthDocumentType());
        output.setJudiciaryOthDocumentType2(registerEo.getJudiciaryOthDocumentType2());
        output.setJudiciaryDocumentId(registerEo.getJudiciaryDocumentId());
        output.setJudiciaryDocumentId2(registerEo.getJudiciaryDocumentId2());
        output.setJudiciaryOthDocumentId(registerEo.getJudiciaryOthDocumentId());
        output.setJudiciaryOthDocumentId2(registerEo.getJudiciaryOthDocumentId2());
        output.setDeductionJudiciaryName(registerEo.getDeductionJudiciaryName());
        output.setDeductionLawNo(registerEo.getDeductionLawNo());

        // 「## 失败处理」声明本步骤无业务失败场景，正常完成即成功，错误字段保持 null
        output.setSucceed(true);
        return output;
    }
}

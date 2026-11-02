package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;
import com.dcits.deposit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST023 登记代办人信息 步骤实现。
 *
 * <p>步骤行为（正式 Spec REQ-001 / REQ-002）：若代办人信息数组不为空，将步骤输入的 16 个字段
 * 登记到代办人登记表（RB_COMMISSION_REGISTER），登记成功后按输出契约返回登记结果字段；
 * 代办人信息数组为空时不登记、不新增记录，步骤正常成功结束。需求未声明本步骤的业务失败
 * 场景与错误码，不设置失败分支。</p>
 */
@Service
public class ST023Pbc implements IST023 {

    private final IRbCommissionRegisterBcc rbCommissionRegisterBcc;

    public ST023Pbc(IRbCommissionRegisterBcc rbCommissionRegisterBcc) {
        this.rbCommissionRegisterBcc = rbCommissionRegisterBcc;
    }

    /**
     * 执行登记代办人信息步骤。
     *
     * <p>代办人信息数组不为空时登记，数组为空时不登记并正常成功结束。</p>
     */
    @Override
    @Transactional
    public ST023OutputBO execute(ST023InputBO input) {
        ST023OutputBO output = new ST023OutputBO();
        // FIXME 业务项:ST023/登记代办人信息 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入表标注 reference、commissionClientName、commissionDocumentId、commissionDocumentType、country、commissionStartDate、commissionExpireDate、commissionClientTel 为必填，但需求未声明必填输入缺失时的失败行为与错误码（Spec 待确认事项4，验收范围明确不在验收范围） - 影响:必填输入缺失时本步骤不校验、照常执行，无已确认失败分支 - 待确认:必填缺失时是否失败、使用的错误码及失败后行为
        // FIXME 业务项:ST023/登记代办人信息 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:代办人信息数组的来源与结构未在本步骤输入表声明（Spec 待确认事项1），数组与标量字段的处理粒度未确认（Spec 待确认事项2），本实现以必填输入「代办人名称」非空作为数组非空的可执行代理条件 - 影响:数组非空但元素字段为空、数组含多条代办人信息时的登记批次/循环行为无法按已确认定义唯一确定，当前按代理条件登记单条 - 待确认:代办人信息数组在交易上下文中的来源与元素字段结构，以及本步骤一次调用登记的代办人数量
        if (input.getCommissionClientName() != null) {
            register(input, output);
        }
        // 正常结束：成功且错误字段保持 null
        output.setSucceed(true);
        return output;
    }

    /**
     * 登记分支（REQ-001-S01）：将步骤输入 16 个字段登记到代办人登记表，并按登记后记录回填输出。
     */
    private void register(ST023InputBO input, ST023OutputBO output) {
        RbCommissionRegisterEO eo = new RbCommissionRegisterEO();
        eo.setReference(input.getReference());
        eo.setCommissionClientName(input.getCommissionClientName());
        eo.setCommissionClientNo(input.getCommissionClientNo());
        eo.setCommissionDocumentId(input.getCommissionDocumentId());
        eo.setCommissionDocumentType(input.getCommissionDocumentType());
        eo.setCountry(input.getCountry());
        eo.setCommissionStartDate(input.getCommissionStartDate());
        eo.setCommissionExpireDate(input.getCommissionExpireDate());
        eo.setCommissionClientTel(input.getCommissionClientTel());
        eo.setCommissionReason(input.getCommissionReason());
        eo.setCommissionRelation(input.getCommissionRelation());
        eo.setCommissionConfirmUserIdKey1(input.getCommissionConfirmUserIdKey1());
        eo.setCommissionConfirmUserIdKey2(input.getCommissionConfirmUserIdKey2());
        eo.setCommissionConfirmTel(input.getCommissionConfirmTel());
        eo.setCommissionConfirmTime(input.getCommissionConfirmTime());
        eo.setCommissionConfirmResult(input.getCommissionConfirmResult());
        // FIXME 业务项:ST023/登记代办人信息 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:代办人登记表 EO 标注 @NotNull 的 createTimestamp、internalKey、channelSeqNo、clientNo、lastUpdTimestamp 未在本步骤输入表声明，交易上下文来源未确认（Spec 待确认事项3） - 影响:上述必填依赖字段无法从已确认输入赋值，真实数据库写入时可能因必填列缺失失败（技术异常按项目约定传播） - 待确认:这些字段由交易上下文中哪些数据提供、本步骤如何取得
        // 需求未声明必填缺失的失败行为与错误码（Spec 待确认事项4，验收范围明确不在验收范围），不补校验失败分支
        rbCommissionRegisterBcc.create(eo);
        // 输出字段为登记后记录中的对应值（登记的记录即本步骤构建的 eo）
        output.setReference(eo.getReference());
        output.setCommissionClientName(eo.getCommissionClientName());
        output.setCommissionClientNo(eo.getCommissionClientNo());
        output.setCommissionDocumentId(eo.getCommissionDocumentId());
        output.setCommissionDocumentType(eo.getCommissionDocumentType());
        output.setCountry(eo.getCountry());
        output.setCommissionStartDate(eo.getCommissionStartDate());
        output.setCommissionExpireDate(eo.getCommissionExpireDate());
        output.setCommissionClientTel(eo.getCommissionClientTel());
        output.setCommissionReason(eo.getCommissionReason());
        output.setCommissionRelation(eo.getCommissionRelation());
        output.setCommissionConfirmUserIdKey1(eo.getCommissionConfirmUserIdKey1());
        output.setCommissionConfirmUserIdKey2(eo.getCommissionConfirmUserIdKey2());
        output.setCommissionConfirmTel(eo.getCommissionConfirmTel());
        output.setCommissionConfirmTime(eo.getCommissionConfirmTime());
        output.setCommissionConfirmResult(eo.getCommissionConfirmResult());
    }
}

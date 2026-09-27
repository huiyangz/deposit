package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;
import com.dcits.deposit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST014 登记代办人信息
 *
 * 步骤描述：
 * 1.登记代办人信息：若{代办人名称}不为空，则登记【代办人信息】，记录$代办人客户号$为{代办人客户号}、
 * $代办人名称$为{代办人名称}、$代办人证件类型$为{代办人证件类型}、$代办人证件号码$为{代办人证件号码}、
 * $代办人证件开始日期$为{代办人证件开始日期}、$代办人证件到期日期$为{代办人证件到期日期}、
 * $代办人电话$为{代办人电话}、$国家$为{国家}、$代办人关系类型$为{代办人关系类型}、
 * $核实结果$为{核实结果}、$核实电话号码$为{核实电话号码}、$代办核实时间$为{代办核实时间}、
 * $代办核实员工号1$为{代办核实员工号1}、$代办核实员工号2$为{代办核实员工号2}。
 *
 * 失败处理：本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST014Pbc implements IST014 {

    private final IRbCommissionRegisterBcc rbCommissionRegisterBcc;

    public ST014Pbc(IRbCommissionRegisterBcc rbCommissionRegisterBcc) {
        this.rbCommissionRegisterBcc = rbCommissionRegisterBcc;
    }

    @Override
    @Transactional
    public ST014OutputBO execute(ST014InputBO input) {
        ST014OutputBO output = new ST014OutputBO();
        // 子步骤1 登记代办人信息：代办人名称不为空（null 或空字符串视为空）才登记
        if (input.getCommissionClientName() != null && !input.getCommissionClientName().isEmpty()) {
            registerCommissionInfo(input, output);
        }
        // 条件不成立时正常跳过登记；无业务失败场景，正常结束即成功
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1：登记代办人信息。
     * 按步骤描述 14 项记录清单写入代办人登记表，并补齐主键（渠道流水号+客户号）与 EO 必填字段；
     * 登记后按输出表定义回显 16 个业务字段。
     * 交易参考号（reference）、代办原因（commissionReason）不在步骤描述记录清单内，
     * 按"已接受的需求处理结论"不随登记写入实体，仅在输出侧回显。
     */
    private void registerCommissionInfo(ST014InputBO input, ST014OutputBO output) {
        RbCommissionRegisterEO eo = new RbCommissionRegisterEO();
        eo.setCommissionClientNo(input.getCommissionClientNo());
        eo.setCommissionClientName(input.getCommissionClientName());
        eo.setCommissionDocumentType(input.getCommissionDocumentType());
        eo.setCommissionDocumentId(input.getCommissionDocumentId());
        eo.setCommissionStartDate(input.getCommissionStartDate());
        eo.setCommissionExpireDate(input.getCommissionExpireDate());
        eo.setCommissionClientTel(input.getCommissionClientTel());
        eo.setCountry(input.getCountry());
        eo.setCommissionRelation(input.getCommissionRelation());
        eo.setCommissionConfirmResult(input.getCommissionConfirmResult());
        eo.setCommissionConfirmTel(input.getCommissionConfirmTel());
        eo.setCommissionConfirmTime(input.getCommissionConfirmTime());
        eo.setCommissionConfirmUserIdKey1(input.getCommissionConfirmUserIdKey1());
        eo.setCommissionConfirmUserIdKey2(input.getCommissionConfirmUserIdKey2());
        eo.setChannelSeqNo(input.getChannelSeqNo());
        eo.setClientNo(input.getClientNo());
        eo.setInternalKey(input.getInternalKey());
        // EO 必填技术时间戳，SPEC 未定义取值来源，按 14 位字符串时间戳约定取当前时间
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        eo.setCreateTimestamp(timestamp);
        eo.setLastUpdTimestamp(timestamp);
        rbCommissionRegisterBcc.createSelective(eo);
        // 输出回显：输出表 16 字段按登记信息回显
        output.setReference(input.getReference());
        output.setCommissionClientName(input.getCommissionClientName());
        output.setCommissionClientNo(input.getCommissionClientNo());
        output.setCommissionDocumentId(input.getCommissionDocumentId());
        output.setCommissionDocumentType(input.getCommissionDocumentType());
        output.setCountry(input.getCountry());
        output.setCommissionStartDate(input.getCommissionStartDate());
        output.setCommissionExpireDate(input.getCommissionExpireDate());
        output.setCommissionClientTel(input.getCommissionClientTel());
        output.setCommissionReason(input.getCommissionReason());
        output.setCommissionRelation(input.getCommissionRelation());
        output.setCommissionConfirmUserIdKey1(input.getCommissionConfirmUserIdKey1());
        output.setCommissionConfirmUserIdKey2(input.getCommissionConfirmUserIdKey2());
        output.setCommissionConfirmTel(input.getCommissionConfirmTel());
        output.setCommissionConfirmTime(input.getCommissionConfirmTime());
        output.setCommissionConfirmResult(input.getCommissionConfirmResult());
    }
}

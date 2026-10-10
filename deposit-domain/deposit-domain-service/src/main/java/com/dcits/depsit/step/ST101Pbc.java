package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST101InputBO;
import com.dcits.depsit.facade.bo.ST101OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.components.IRbLimitCtrlCustomInfoBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.depsit.facade.eo.RbLimitCtrlCustomInfoEO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST101 获取限额场景编码的步骤实现。
 *
 * <p>执行顺序：子步骤1（按 [限额场景编码] 查询【限额控制配置表】取两项标志）→ 子步骤2
 * （$允许自定义标识$ 为 N-否 时返回 [限额场景编码]，否则跳转至子步骤《获取自定义限额》）→ 子步骤3
 * （按 [客户号] 与 [限额场景编码] 查询【限额控制客户自定义配置表】，取 $生效日期$ 不晚于
 * {交易日期} 中离 {交易日期} 最近的一条作为 [自定义限额]）→ 子步骤4（检查 [自定义限额] 的四个判定项）。</p>
 *
 * <p>本步骤只读取上述两张表，不产生业务副作用；全部返回路径均为正常结束（{@code succeed = true}），
 * 无业务失败场景与业务错误码（REQ-012）。</p>
 */
@Service
public class ST101Pbc implements IST101 {

    /** 标志取值：是。 */
    private static final String FLAG_YES = "Y";

    /** 标志取值：否。 */
    private static final String FLAG_NO = "N";

    /** 【限额控制配置表】数据服务接口。 */
    @Autowired
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    /** 【限额控制客户自定义配置表】数据服务接口。 */
    @Autowired
    private IRbLimitCtrlCustomInfoBcc rbLimitCtrlCustomInfoBcc;

    @Override
    public ST101OutputBO execute(ST101InputBO input) {
        ST101OutputBO output = new ST101OutputBO();

        // 子步骤1：获取允许自定义标识——按 [限额场景编码] 单键查询【限额控制配置表】
        RbLimitCtrlConfEO confQuery = new RbLimitCtrlConfEO();
        confQuery.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confRecords = rbLimitCtrlConfBcc.findByEo(confQuery);
        // 同一 [限额场景编码] 只应有一条配置记录；查询到多条或查不到时返回 [限额场景编码] 为空并结束，
        // 不再执行子步骤2～4（不判定标识、不查询【限额控制客户自定义配置表】）
        if (confRecords == null || confRecords.size() != 1) {
            output.setSucceed(true);
            return output;
        }
        RbLimitCtrlConfEO confRecord = confRecords.get(0);
        output.setAllowCustomFlag(confRecord.getAllowCustomFlag());
        output.setOnlyCustom(confRecord.getOnlyCustom());

        // 子步骤2：获取限额信息——$允许自定义标识$ 为 N-否 时返回 [限额场景编码] 并结束
        if (FLAG_NO.equals(confRecord.getAllowCustomFlag())) {
            output.setLimitSceneNo(input.getLimitSceneNo());
            output.setSucceed(true);
            return output;
        }

        // 子步骤3：获取自定义限额——跳转至子步骤《获取自定义限额》，按 [客户号] 与 [限额场景编码] 查询
        RbLimitCtrlCustomInfoEO customQuery = new RbLimitCtrlCustomInfoEO();
        customQuery.setClientNo(input.getClientNo());
        customQuery.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlCustomInfoEO> customRecords = rbLimitCtrlCustomInfoBcc.findByEo(customQuery);
        RbLimitCtrlCustomInfoEO customLimit = selectNearestByEffectDate(input.getTranDate(), customRecords);
        if (customLimit != null) {
            output.setEffectDate(customLimit.getEffectDate());
            output.setExpireDate(customLimit.getExpireDate());
            output.setTempLimitFlag(customLimit.getTempLimitFlag());
        }

        // 子步骤4：获取限额值——检查 [自定义限额]
        if (customLimit != null) {
            // 判定项 1：存在且 $临时限额标志$ 等于 Y-是
            if (FLAG_YES.equals(customLimit.getTempLimitFlag())) {
                Date expireDate = customLimit.getExpireDate();
                // {交易日期} 大于 $失效日期$ 时返回 [限额场景编码] 为空；
                // $失效日期$ 为空或 {交易日期} 小于等于 $失效日期$ 时返回 [限额场景编码]
                if (expireDate != null && input.getTranDate().after(expireDate)) {
                    output.setSucceed(true);
                    return output;
                }
                output.setLimitSceneNo(input.getLimitSceneNo());
                output.setSucceed(true);
                return output;
            }
            // 判定项 2：存在且 $临时限额标志$ 不等于 Y-是（包括为空）时返回 [限额场景编码]，
            // 本分支不检查该记录的 $失效日期$
            output.setLimitSceneNo(input.getLimitSceneNo());
            output.setSucceed(true);
            return output;
        }

        // 判定项 3：[自定义限额] 不存在且【限额控制配置表】的 $仅检查客户自定义标志$ 等于 Y-是
        // 时返回 [限额场景编码] 为空
        if (FLAG_YES.equals(confRecord.getOnlyCustom())) {
            output.setSucceed(true);
            return output;
        }
        // 判定项 4：[自定义限额] 不存在且 $仅检查客户自定义标志$ 不等于 Y-是（包括为空）时返回 [限额场景编码]
        output.setLimitSceneNo(input.getLimitSceneNo());
        output.setSucceed(true);
        return output;
    }

    /**
     * 从子步骤3 命中的记录中选出 [自定义限额]：满足 $生效日期$ 小于等于 {交易日期} 的记录中，
     * 取 $生效日期$ 离 {交易日期} 最近（即 $生效日期$ 最大且不晚于 {交易日期}）的一条。
     *
     * <p>$生效日期$ 为空或晚于 {交易日期} 的记录不满足取数条件、不参与候选；无满足条件的记录时返回
     * {@code null}，表示 [自定义限额] 不存在（不判为业务失败、不返回业务错误码）。</p>
     *
     * @param tranDate {交易日期}（入参 tranDate）
     * @param records  按 [客户号] 与 [限额场景编码] 查询【限额控制客户自定义配置表】命中的记录
     * @return 作为 [自定义限额] 的记录；不存在时为 {@code null}
     */
    private RbLimitCtrlCustomInfoEO selectNearestByEffectDate(Date tranDate,
            List<RbLimitCtrlCustomInfoEO> records) {
        if (records == null) {
            return null;
        }
        RbLimitCtrlCustomInfoEO nearest = null;
        for (RbLimitCtrlCustomInfoEO record : records) {
            Date effectDate = record.getEffectDate();
            if (effectDate == null || effectDate.after(tranDate)) {
                continue;
            }
            if (nearest == null || effectDate.after(nearest.getEffectDate())) {
                nearest = record;
            }
        }
        return nearest;
    }
}

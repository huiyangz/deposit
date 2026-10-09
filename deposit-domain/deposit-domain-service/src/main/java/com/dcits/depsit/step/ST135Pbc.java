package com.dcits.depsit.step;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST135InputBO;
import com.dcits.depsit.facade.bo.ST135OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ST135 更新账户手工解限限制状态 步骤实现。
 *
 * <p>依据正式 Spec REQ-001：以输入 {限制编号}（{@code resSeqNo}，对公存款账户限制表 RB_BUS_RESTRAINTS 主键）
 * 定位【账户限制信息】记录，把限制状态 {@code restraintsStatus} 更新为 "E-失效"
 * （{@code com.dcits.depsit.enums.RestraintsStatus.E}，码值 "E"）。更新写入的字段范围仅为限制状态，
 * 采用按主键的选择性更新，不修改定位记录的限制状态以外的字段，不新增或删除记录；
 * 写入取值不因被更新记录原有的限制状态而改变（REQ-001-S02）。</p>
 *
 * <p>{@code clientNo} 不参与本步骤的更新行为，不作为定位条件、不作为写入字段，也不触发查询或校验（REQ-002）。</p>
 *
 * <p>输出 {@code restraintsStatus} 取自本次写入的取值（REQ-003），不采用另一次查询或另一来源的取值。
 * 本步骤无业务失败场景（Spec「## 失败处理」），执行完成即设置 {@code succeed=true} 并保持错误字段为
 * {@code null}；更新影响行数在本 Spec 中未定义业务语义，故不据其产生分支（Spec「验收范围与明确不覆盖的事项」第 1、7 项）。</p>
 */
@Service
public class ST135Pbc implements IST135 {

    /** 实体表【对公存款账户限制表(RB_BUS_RESTRAINTS)】数据服务接口 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /**
     * 执行更新账户手工解限限制状态。
     *
     * @param input 限制编号（{@code resSeqNo}）与客户号（{@code clientNo}）
     * @return 更新结果；成功时 {@code succeed=true}、错误字段为 {@code null}，
     *         且 {@code restraintsStatus} 为本次写入的 {@code RestraintsStatus.E}（"E-失效"）
     */
    @Override
    @Transactional
    public ST135OutputBO execute(ST135InputBO input) {
        ST135OutputBO output = new ST135OutputBO();

        // 「## 步骤描述」1：根据{限制编号}更新【账户限制信息】的$限制状态$为"E-失效"
        // 定位条件＝限制编号（该表主键 RES_SEQ_NO）；写入字段＝限制状态；写入取值＝RestraintsStatus.E
        RbBusRestraintsEO updateEo = new RbBusRestraintsEO();
        updateEo.setResSeqNo(input.getResSeqNo());
        updateEo.setRestraintsStatus(RestraintsStatus.E);
        rbBusRestraintsBcc.modifyByPrimaryKeySelective(updateEo);

        // REQ-003：输出承载本次写入的限制状态取值（"E-失效"）
        output.setRestraintsStatus(RestraintsStatus.E);

        // 「## 失败处理」声明本步骤无业务失败场景，正常完成即成功，错误字段保持 null
        output.setSucceed(true);
        return output;
    }
}
